package edu.hw7.Task3;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@SuppressWarnings("MagicNumber") public class Cache implements PersonDataBase {


    private static final Map<Integer, Person> ID_DB = new ConcurrentHashMap<>();
    private static final Map<String, Person> NAME_DB = new ConcurrentHashMap<>();
    private static final Map<String, Person> ADDRESS_DB = new ConcurrentHashMap<>();
    private static final Map<String, Person> PHONE_DB = new ConcurrentHashMap<>();


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


