package com.aurionpro.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.aurionpro.model.Accout;

public class StreamObject {

	public static void main(String[] args) {
		Accout account1 = new Accout(123456789, "Jain" , 78000);
		Accout account2 = new Accout(122324335, "Aurionpro" , 24000);
		Accout account3 = new Accout(325534523, "Swabhav" , 80000);
		Accout account4 = new Accout(353453466, "Techlabs" , 48000);
		
		
		List<Accout> accounts = Arrays.asList(account1,account2,account3,account4);
		
		//finding the minimum balance
		Optional<Accout> minimumBalance = accounts.stream().min(Comparator.comparing(Accout::getBalance));
		System.out.println("Mininum Balance");
		System.out.println(minimumBalance);
		
		//
		Optional<Accout> maximumBalance = accounts.stream().max(Comparator.comparing(Accout::getBalance));
		System.out.println("Maximum Balance");
		System.out.println(maximumBalance);
		
		List<Accout> namesGreaterThanSixChar = accounts.stream().filter(account -> account.getName().length()>6).collect(Collectors.toList());
		System.out.println("Names are");
		namesGreaterThanSixChar.forEach((name) -> System.out.println(name)) ;
		
		Double sum  = accounts.stream().mapToDouble(Accout::getBalance).reduce(0, (a1,a2) -> a1+ a2);
		System.out.println("Sum is " + sum);
	}

}
