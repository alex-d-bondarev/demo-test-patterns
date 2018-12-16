package com.alexdb.dtpatterns.dataRegistry;

import java.util.concurrent.atomic.AtomicInteger;

public class UserRegistry {
    private static AtomicInteger COUNTER = new AtomicInteger(0);

    public static User getUniqueUser(){
        int index = COUNTER.incrementAndGet();
        return new User(index);
    }
}
