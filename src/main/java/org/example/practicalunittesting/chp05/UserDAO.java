package org.example.practicalunittesting.chp05;

import java.util.HashMap;
import java.util.Map;

public class UserDAO implements IUserDAO{

    Map<Integer, IUser> users = new HashMap<>();

    @Override
    public void updateUser(IUser user) {
        if (users.get(user.getUserId()) != null) {
            users.replace(user.getUserId(), user);
        } else {
            throw new IllegalArgumentException("User not found!");
        }
    }

    @Override
    public void insetUser(IUser user) {
        users.put(user.getUserId(), user);
    }
}
