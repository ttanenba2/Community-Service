package unitTests;

import static org.junit.Assert.*;
import org.junit.Test;
import people.Person;
import initialClasses.*;

public class Person_TESTS {

	@Test
	public void ValidEmailReturnsTrue() {
		assertTrue("Valid email does not return true.", Person.verifyEmail("cgewanter@gmail.com"));
	}
	
	@Test (expected = InvalidDataException.class)
	public void InvalidEmailThrowsInvalidDataException() throws InvalidDataException{
		Person.verifyEmail("cgewantergmail.com");
	}
	
	@Test 
	public void ValidPasswordReturnsTrue() {
		assertTrue("Valid password does not return true.", Person.verifyPassword("3487abc"));
	}
	
	@Test (expected = InvalidDataException.class)
	public void InvalidPasswordThrowsInvalidDataException() {
		Person.verifyPassword("123");
	}
	
	@Test 
	public void ValidNumberReturnsTrue() {
		assertTrue("Valid phone number does not return true.", Person.verifyPhoneNumber("7182222222"));
	}
	
	@Test (expected = InvalidDataException.class)
	public void InvalidNumberThrowsInvalidDataException() {
		Person.verifyPhoneNumber("12345678");
	}
}
