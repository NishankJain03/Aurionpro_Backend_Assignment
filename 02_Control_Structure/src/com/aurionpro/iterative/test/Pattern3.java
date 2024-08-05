package com.aurionpro.iterative.test;

public class Pattern3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cnt = 1;
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= i; j++ ) {
				System.out.print(cnt);
				cnt++;
			}
			System.out.println();
		}

	}

}
