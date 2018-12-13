package com.emissystem.www.home.model;


public class UnitTests {
	public static void main(String[] args) {
		User u = new User("EMAIL", "SALT", "PASS", "PRIVLEVEL");
		if(u.equals(u)){
			System.out.println("Equals method pass.");
		}
		else {
			System.out.println("Equals method fail.");
		}
		if(u.getEMAIL()=="EMAIL"){
			System.out.println("getEMAIL pass.");
		}
		else {
			System.out.println("getEMAIL fail.");
		}
		if(u.getSALT()=="SALT"){
			System.out.println("getSALT pass.");
		}
		else {
			System.out.println("getSALT fail.");
		}
		if(u.getPASS()=="PASS"){
			System.out.println("getPASS pass.");
		}
		else {
			System.out.println("getPASS fail.");
		}
		if(u.getPRIVLEVEL()=="PRIVLEVEL"){
			System.out.println("getPRIVLEVEL pass.");
		}
		else {
			System.out.println("getPRIVLEVEL fail.");
		}
	}
}
