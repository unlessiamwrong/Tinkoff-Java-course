package edu.hw8;

import edu.hw8.Task1.MultiThreadClient;
import edu.hw8.Task2.FixedThreadPool;

public class Test {

    public static void main(String[] args){
        var a = new FixedThreadPool(33);
        a.execute(null);
    }

}
