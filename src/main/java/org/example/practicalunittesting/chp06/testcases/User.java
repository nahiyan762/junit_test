package org.example.practicalunittesting.chp06.testcases;

/**
 * Practical Unit Testing with JUnit and Mockito - source code for exercises.
 * Visit http://practicalunittesting.com for more information.
 *
 * @author Tomek Kaczanowski
 */
public interface User {
	String getPassword();

	void setPassword(String passwordMd5);
}
