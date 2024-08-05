package com.aurionpro.model;

import java.util.Comparator;

public class StudentComparators {
	public static class StudentRollNoComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			if(o1.getRollNo() > o2.getRollNo())
				return 1;
			if(o1.getRollNo() < o2.getRollNo())
				return -1;
			return 0;
		}
	}
	public static class StudentNameComparator implements Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) {
			return o1.getName().compareTo(o2.getName());
		}

	}
	public static class StudentPercentageComparator implements Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) {
			if(o1.getPercentage() > o2.getPercentage())
				return 1;
			if(o1.getPercentage() < o2.getPercentage())
				return -1;
			return 0;
		}

	}

}
