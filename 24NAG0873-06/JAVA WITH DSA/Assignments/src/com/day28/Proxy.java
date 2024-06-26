package com.day28;

import java.util.Scanner;

interface SensitiveObjectInterface{
	String getSecretKey();
}
class SensitiveObject implements SensitiveObjectInterface{
	private String secretKey;
	public SensitiveObject(String secretKey) {
		this.secretKey = secretKey;
	}
	@Override
	public String getSecretKey() {
		return secretKey;
	}
}
class SensitiveObjectProxy implements SensitiveObjectInterface{
	private SensitiveObject sensitiveObject;
	private String password;
	public SensitiveObjectProxy(String secretKey, String password) {
		this.sensitiveObject = new SensitiveObject(secretKey);
		this.password = password;
	}
	@Override
	public String getSecretKey() {
		throw new UnsupportedOperationException("Use getScretKey(String password) method instead");
	}
	public String getSecretKey(String inputPassword) {
		if(this.password.equals(inputPassword)) {
			return sensitiveObject.getSecretKey();
		} else {
			throw new SecurityException("Access Denied: Incorrect Password");
		}
	}
}

public class Proxy {
	
	public static void main(String[] args) {
		String secretKey = "SecretKey@123";
		String  correctPassword = "Swati@123";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the password:");
		String inputPassword = sc.nextLine();
		SensitiveObjectProxy proxy = new SensitiveObjectProxy(secretKey, correctPassword);
		try {
			System.out.println("Attempting to access with provided password:");
			System.out.println("Secret Key: " + proxy.getSecretKey(inputPassword));
		} catch(SecurityException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
		
	}

}
