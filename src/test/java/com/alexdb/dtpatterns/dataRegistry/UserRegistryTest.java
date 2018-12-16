package com.alexdb.dtpatterns.dataRegistry;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegistryTest {

    @Test
    public void registryProvidesUniqueNumbers(){
        User user1 = UserRegistry.getUniqueUser();
        User user2 = UserRegistry.getUniqueUser();

        Assert.assertNotEquals(user1.getNumber(), user2.getNumber(),
                "Users should have unique numbers.");
    }
}
