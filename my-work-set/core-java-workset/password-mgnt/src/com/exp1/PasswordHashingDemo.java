package com.exp1;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * @author uskarc01
 * 
 *         <pre>
 *         Reference urls
 * @see https://dzone.com/articles/storing-passwords-java-web
 * @see http://www.jasypt.org/howtoencryptuserpasswords.html
 */
public class PasswordHashingDemo {

	public static final String SALT = "my-salt-text";
	private static final Map<String, String> CREDSTORE = new HashMap<String, String>();

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		PasswordHashingDemo hashingDemo = new PasswordHashingDemo();

		System.out.println("\tsigned-up ....!");
		hashingDemo.signup("john", "dummy123");
		
		//hashingDemo.signup("a", "a");
		
		// testArrayCopying();

		System.out.println("\n\tLogin Testing....!");

		// login should succeed.
		hashingDemo.reportLogin("john", "dummy123");

		// login should fail because of wrong password.
		hashingDemo.reportLogin("john", "blahblah");

		System.out.println("final try");
		hashingDemo.reportLogin("john", "Dummy123");

	}

	/**
	 * 
	 * @param username
	 * @param password
	 */
	public void reportLogin(String username, String password) {

		if (login(username, password)) {
			System.out.println("Successful login.");
		} else {
			System.out.println("Failed login.");
		}
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public Boolean login(String username, String password) {
		Boolean isAuthenticated = false;

		// remember to use the same SALT value use used while storing password
		// for the first time.
		String saltedPassword = SALT + password;
		// String hashedPassword = generateHash(saltedPassword);
		String hashedPassword = generateHashV2(Boolean.TRUE, password);

		String storedPasswordHash = CREDSTORE.get(username);
		if (hashedPassword.equals(storedPasswordHash)) {
			isAuthenticated = true;
		} else {
			isAuthenticated = false;
		}
		return isAuthenticated;
	}

	/**
	 * 
	 * @param input
	 * @return
	 */
	private static String generateHash(String input) {
		StringBuilder hashBuilder = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(input.getBytes());
			char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
			for (int idx = 0; idx < hashedBytes.length; ++idx) {
				byte b = hashedBytes[idx];
				hashBuilder.append(digits[(b & 0xf0) >> 4]);
				hashBuilder.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Not such alg found" + e);
			e.printStackTrace();
		}

		System.out.println("hashStrValue:" + hashBuilder);
		return hashBuilder.toString();
	}

	/**
	 * 
	 * @param clearTxtPasswrd
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private static String generateHashV2(boolean userSalt, String clearTxtPasswrd) {
		StringBuilder hashBuilder = new StringBuilder();

		byte[] saltBytes = null;

		// to decided what salt to be used.
		String saltClearText;
		if (userSalt == false) {
			// constant salt for all users
			saltClearText = SALT;
		} else {
			// diff salt for user
			saltClearText = clearTxtPasswrd;
		}
		try {
			saltBytes = saltClearText.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		try {
			byte[] loopHashedBytes = null;
			MessageDigest sha = MessageDigest.getInstance("MD5");
			try {

				// byte[] hashedBytes =
				// sha.digest(clearTxtPasswrd.getBytes("UTF-8"));
				loopHashedBytes = sha.digest(clearTxtPasswrd.getBytes("UTF-8"));

				int counter = 1000;
				// System.out.println("looping for counter:" + counter);

				// to loop the digest.
				for (int i = 0; i < counter; i++) {
					loopHashedBytes = sha.digest(loopHashedBytes);
					// System.out.println(i + ":\t" + new
					// Base64().encodeAsString(loopHashedBytes));
				}

			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			loopHashedBytes = concat(saltBytes, loopHashedBytes);

			// encode to the represent binary to US-ASCII values
			hashBuilder.append(new Base64().encodeAsString(loopHashedBytes));

		} catch (NoSuchAlgorithmException e) {
			System.out.println("Not such alg found" + e);
			e.printStackTrace();
		}

		System.out.println("hashed Password: " + hashBuilder);
		return hashBuilder.toString();
	}

	/**
	 * 
	 * @param username
	 * @param password
	 */
	public void signup(String username, String password) {
		String saltedPassword = SALT + password;
		// String hashedPassword = generateHash(saltedPassword);

		System.out.println(String.format("for user %s and psswd %s",username,password));
		String hashedPassword = generateHashV2(true, password);
		CREDSTORE.put(username, hashedPassword);
	}

	/**
	 * 
	 * @param firstArray
	 * @param secondArray
	 * @return
	 */
	public static byte[] concat(byte[] firstArray, byte[] secondArray) {
		byte[] resultArray = Arrays.copyOf(firstArray, firstArray.length + secondArray.length);
		System.arraycopy(secondArray, 0, resultArray, firstArray.length, secondArray.length);
		return resultArray;
	}

	/**
	 * test code for the array copying
	 * 
	 * @param firstArray
	 * @param secondArray
	 * @return
	 */
	private static int[] concat(int[] firstArray, int[] secondArray) {
		int[] resultArray = Arrays.copyOf(firstArray, firstArray.length + secondArray.length);
		System.arraycopy(secondArray, 0, resultArray, firstArray.length, secondArray.length);
		return resultArray;
	}

	/**
	 * Test method
	 */
	private static void testArrayCopying() {
		int[] firstSaltArray = {1, 2, 3};
		int[] secondPasswordArray = {5, 6, 7};

		int[] finalArray = concat(firstSaltArray, secondPasswordArray);

		System.out.println(Arrays.toString(finalArray));
	}
}
