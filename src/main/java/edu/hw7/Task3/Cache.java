package edu.hw7.Task3;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache implements PersonDatabase {

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock writeLock = readWriteLock.writeLock();
    private final Lock readLock = readWriteLock.readLock();

    private final Map<Integer, Person> idDB = new HashMap<>();
    private final Map<String, Person> nameDB = new HashMap<>();
    private final Map<String, Person> addressDB = new HashMap<>();
    private final Map<String, Person> phoneDB = new HashMap<>();

    @Override
    public synchronized void add(Person person) {
        idDB.put(person.id(), person);
        nameDB.put(person.name(), person);
        addressDB.put(person.address(), person);
        phoneDB.put(person.phone(), person);
    }

    @Override
    public synchronized void delete(int id) {
        Person person = idDB.get(id);
        idDB.remove(id);
        nameDB.remove(person.name());
        addressDB.remove(person.address());
        phoneDB.remove(person.phone());
    }

    @Override
    public synchronized Person findById(int id) {
        return idDB.get(id);
    }
    @Override
    public synchronized Person findByName(String name) {
        return nameDB.get(name);
    }

    @Override
    public synchronized Person findByAddress(String address) {
        return addressDB.get(address);
    }

    @Override
    public synchronized Person findByPhone(String phone) {
        return phoneDB.get(phone);
    }

    public static void main(String[] args) throws InterruptedException {
        var cache = new Cache();
        var res = Collections.synchronizedList(new ArrayList<>());

        Thread addRecord = new Thread(() -> {
            for(int i = 1; i < 1000; i++){
                cache.add(new Person(i, "n" + i, "a" + i, "p" + i));
            }
        });

        Thread getRecord = new Thread(() -> {
            for(int i = 1; i < 1000; i++){
                Person person = cache.findById(i);
                if(person != null) {
                    res.add(cache.findByName(person.name()));
                    res.add(cache.findByAddress(person.address()));
                    res.add(cache.findByPhone(person.phone()));
                }
            }
        });
        addRecord.start();
        getRecord.start();
        try {
            addRecord.join();
            getRecord.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(res);
    }
}

