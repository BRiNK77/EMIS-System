package com.emissystem.www.home.model;

//Written by Chase, corrected by Triston Scallan
public class UnitTests {
	public static void testUserModel() {
		User u = new User("EMAIL", "SALT", "PASS", 1000, "hello", "PRIVLEVEL");
		if(u.equals(u)){
			System.out.println("Equals method pass.");
		}
		else {
			System.out.println("Equals method fail.");
		}
		if(u.getEMAIL().equals("EMAIL")){
			System.out.println("getEMAIL pass.");
		}
		else {
			System.out.println("getEMAIL fail.");
		}
		if(u.getSALT().equals("SALT")){
			System.out.println("getSALT pass.");
		}
		else {
			System.out.println("getSALT fail.");
		}
		if(u.getPASS().equals("PASS")){
			System.out.println("getPASS pass.");
		}
		else {
			System.out.println("getPASS fail.");
		}
		if(u.getPRIVLEVEL().equals("PRIVLEVEL")){
			System.out.println("getPRIVLEVEL pass.");
		}
		else {
			System.out.println("getPRIVLEVEL fail.");
		}
	}
}
