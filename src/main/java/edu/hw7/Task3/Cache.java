package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache implements PersonDatabase {

    private static final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private static final Lock rLock = rwLock.readLock();
    private static final Lock wLock = rwLock.writeLock();
    private final Map<Integer, Person> idDB = new ConcurrentHashMap<>();
    private final Map<String, Person> nameDB = new ConcurrentHashMap<>();
    private final Map<String, Person> addressDB = new ConcurrentHashMap<>();
    private final Map<String, Person> phoneDB = new ConcurrentHashMap<>();

    public static ArrayList<Object> run() throws InterruptedException {
        var cache = new Cache();
        var res = new ArrayList<>() {
        };

        Thread addRecord = new Thread(() -> {
            for (int i = 1; i < 1000; i++) {
                cache.add(new Person(i, "n" + i, "a" + i, "p" + i));
            }
        });

        Thread getRecord = new Thread(() -> {
            for (int i = 1; i < 1000; i++) {
                Person person = cache.findById(i);
                    wLock.lock();
                    res.add(cache.findByName(person.name()));
                    res.add(cache.findByAddress(person.address()));
                    res.add(cache.findByPhone(person.phone()));
                    wLock.unlock();

            }
        });
        addRecord.start();
        Thread.sleep(10);
        getRecord.start();
        try {
            addRecord.join();
            getRecord.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public synchronized void add(Person person) {
        rLock.lock();
        idDB.put(person.id(), person);
        nameDB.put(person.name(), person);
        addressDB.put(person.address(), person);
        phoneDB.put(person.phone(), person);
        rLock.unlock();
    }

    @Override
    public synchronized void delete(int id) {
        rLock.lock();
        Person person = idDB.get(id);
        idDB.remove(id);
        nameDB.remove(person.name());
        addressDB.remove(person.address());
        phoneDB.remove(person.phone());
        rLock.unlock();
    }

    @Override
    public synchronized Person findById(int id) {
        wLock.lock();
        try {
            return idDB.get(id);
        } finally {
            wLock.unlock();
        }
    }

    @Override
    public synchronized Person findByName(String name) {
        wLock.lock();
        try {
            return nameDB.get(name);
        } finally {
            wLock.unlock();
        }
    }

    @Override
    public synchronized Person findByAddress(String address) {
        wLock.lock();
        try {
            return addressDB.get(address);
        } finally {
            wLock.unlock();
        }
    }

    @Override
    public synchronized Person findByPhone(String phone) {
        wLock.lock();
        try {
            return phoneDB.get(phone);
        } finally {
            wLock.unlock();
        }
    }
}

