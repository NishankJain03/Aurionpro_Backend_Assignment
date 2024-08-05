package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.exception.AgeNotValidException;
import com.aurionpro.model.Voter;

public class VoterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		try {
		
		System.out.println("Enter the voterid");
		int voterId = scanner.nextInt();
		System.out.println("Enter the firstname");
		String firstName = scanner.next();
		System.out.println("Enter the lastName");
		String lastName = scanner.next();
		System.out.println("Enter the age");
		int age = scanner.nextInt();
		
		Voter voter = new Voter(voterId, firstName, lastName, age);
		System.out.println(voter);
		}catch(AgeNotValidException e) {
			System.out.println(e.getMessage());
		}

	}

}
