package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("MagicNumber")
public class Cache implements PersonDataBase {

    private final static Logger LOGGER = LogManager.getLogger();
    private static final ReadWriteLock RW_LOCK = new ReentrantReadWriteLock();
    private static final Lock R_LOCK = RW_LOCK.readLock();
    private static final Lock W_LOCK = RW_LOCK.writeLock();
    private static final Map<Integer, Person> ID_DB = new ConcurrentHashMap<>();
    private static final Map<String, Person> NAME_DB = new ConcurrentHashMap<>();
    private static final Map<String, Person> ADDRESS_DB = new ConcurrentHashMap<>();
    private static final Map<String, Person> PHONE_DB = new ConcurrentHashMap<>();

    public static ArrayList<Object> run() throws InterruptedException {
        var cache = new Cache();
        var result = new ArrayList<>() {
        };

        Thread addRecord = new Thread(() -> {
            for (int i = 1; i < 1000; i++) {
                cache.add(new Person(i, "n" + i, "a" + i, "p" + i));
            }
        });

        Thread getRecord = new Thread(() -> {
            for (int i = 1; i < 1000; i++) {
                Person person = cache.findById(i);
                W_LOCK.lock();
                result.add(cache.findByName(person.name()));
                result.add(cache.findByAddress(person.address()));
                result.add(cache.findByPhone(person.phone()));
                W_LOCK.unlock();

            }
        });
        addRecord.start();
        Thread.sleep(10);
        getRecord.start();
        try {
            addRecord.join();
            getRecord.join();
        } catch (InterruptedException e) {
            LOGGER.info(e.getMessage());
        }
        return result;
    }

    @Override
    public synchronized void add(Person person) {
        R_LOCK.lock();
        ID_DB.put(person.id(), person);
        NAME_DB.put(person.name(), person);
        ADDRESS_DB.put(person.address(), person);
        PHONE_DB.put(person.phone(), person);
        R_LOCK.unlock();
    }

    @Override
    public synchronized void delete(int id) {
        R_LOCK.lock();
        Person person = ID_DB.get(id);
        ID_DB.remove(id);
        NAME_DB.remove(person.name());
        ADDRESS_DB.remove(person.address());
        PHONE_DB.remove(person.phone());
        R_LOCK.unlock();
    }

    @Override
    public synchronized Person findById(int id) {
        W_LOCK.lock();
        try {
            return ID_DB.get(id);
        } finally {
            W_LOCK.unlock();
        }
    }

    @Override
    public synchronized Person findByName(String name) {
        W_LOCK.lock();
        try {
            return NAME_DB.get(name);
        } finally {
            W_LOCK.unlock();
        }
    }

    @Override
    public synchronized Person findByAddress(String address) {
        W_LOCK.lock();
        try {
            return ADDRESS_DB.get(address);
        } finally {
            W_LOCK.unlock();
        }
    }

    @Override
    public synchronized Person findByPhone(String phone) {
        W_LOCK.lock();
        try {
            return PHONE_DB.get(phone);
        } finally {
            W_LOCK.unlock();
        }
    }
}

