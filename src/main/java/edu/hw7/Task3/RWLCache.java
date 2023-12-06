package edu.hw7.Task3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@SuppressWarnings("MagicNumber") public class RWLCache implements PersonDataBase {

    private static final ReadWriteLock RW_LOCK = new ReentrantReadWriteLock();
    private static final Lock R_LOCK = RW_LOCK.readLock();
    private static final Lock W_LOCK = RW_LOCK.writeLock();
    private static final Map<Integer, Person> ID_DB = new HashMap<>();
    private static final Map<String, Person> NAME_DB = new HashMap<>();
    private static final Map<String, Person> ADDRESS_DB = new HashMap<>();
    private static final Map<String, Person> PHONE_DB = new HashMap<>();

    @Override public void add(Person person) {
        R_LOCK.lock();
        ID_DB.put(person.id(), person);
        NAME_DB.put(person.name(), person);
        ADDRESS_DB.put(person.address(), person);
        PHONE_DB.put(person.phone(), person);
        R_LOCK.unlock();
    }

    @Override public void delete(int id) {
        W_LOCK.lock();
        Person person = ID_DB.get(id);
        ID_DB.remove(id);
        NAME_DB.remove(person.name());
        ADDRESS_DB.remove(person.address());
        PHONE_DB.remove(person.phone());
        W_LOCK.unlock();
    }

    @Override public Person findById(int id) {
        W_LOCK.lock();
        try {
            return ID_DB.get(id);
        } finally {
            W_LOCK.unlock();
        }
    }

    @Override public Person findByName(String name) {
        W_LOCK.lock();
        try {
            return NAME_DB.get(name);
        } finally {
            W_LOCK.unlock();
        }
    }

    @Override public Person findByAddress(String address) {
        W_LOCK.lock();
        try {
            return ADDRESS_DB.get(address);
        } finally {
            W_LOCK.unlock();
        }
    }

    @Override public Person findByPhone(String phone) {
        W_LOCK.lock();
        try {
            return PHONE_DB.get(phone);
        } finally {
            W_LOCK.unlock();
        }
    }
}

