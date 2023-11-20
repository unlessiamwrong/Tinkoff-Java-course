package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("MagicNumber") public class Cache implements PersonDataBase {

    private final static Logger LOGGER = LogManager.getLogger();

    private static final Map<Integer, Person> ID_DB = new ConcurrentHashMap<>();
    private static final Map<String, Person> NAME_DB = new ConcurrentHashMap<>();
    private static final Map<String, Person> ADDRESS_DB = new ConcurrentHashMap<>();
    private static final Map<String, Person> PHONE_DB = new ConcurrentHashMap<>();

    public synchronized static List<Object> run() throws InterruptedException {
        var cache = new Cache();
        var result = Collections.synchronizedList(new ArrayList<>() {
        });

        Thread addRecord = new Thread(() -> {
            for (int i = 1; i < 1000; i++) {
                cache.add(new Person(i, "n" + i, "a" + i, "p" + i));
            }
        });

        Thread getRecord = new Thread(() -> {
            for (int i = 1; i < 1000; i++) {
                Person person = cache.findById(i);
                result.add(cache.findByName(person.name()));
                result.add(cache.findByAddress(person.address()));
                result.add(cache.findByPhone(person.phone()));

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

    @Override public synchronized void add(Person person) {
        ID_DB.put(person.id(), person);
        NAME_DB.put(person.name(), person);
        ADDRESS_DB.put(person.address(), person);
        PHONE_DB.put(person.phone(), person);
    }

    @Override public synchronized void delete(int id) {
        Person person = ID_DB.get(id);
        ID_DB.remove(id);
        NAME_DB.remove(person.name());
        ADDRESS_DB.remove(person.address());
        PHONE_DB.remove(person.phone());
    }

    @Override public synchronized Person findById(int id) {
        return ID_DB.get(id);
    }

    @Override public synchronized Person findByName(String name) {
        return NAME_DB.get(name);
    }

    @Override public synchronized Person findByAddress(String address) {
        return ADDRESS_DB.get(address);
    }

    @Override public synchronized Person findByPhone(String phone) {
        return PHONE_DB.get(phone);
    }
}


