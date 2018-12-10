package com.alexdb.dtpatterns.dataRegistry;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegistryTest {

    @Test
    public void registryProvidesUniqueNumbers(){
        User user1 = UserRegistry.getUser();
        User user2 = UserRegistry.getUser();

        Assert.assertNotEquals(user1.getNumber(), user2.getNumber(),
                "Users should have unequal numbers.");
    }
}
