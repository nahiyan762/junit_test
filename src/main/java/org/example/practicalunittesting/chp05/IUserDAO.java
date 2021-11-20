package org.example.practicalunittesting.chp05;

public interface IUserDAO {
	void updateUser(IUser user) throws IllegalArgumentException;
	void insetUser(IUser user);
}
