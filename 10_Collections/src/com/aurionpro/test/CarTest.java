package com.aurionpro.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.model.Car;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		List<Car> cars = new ArrayList<Car>();
		//entering the elements
		readStudent(scanner, cars);
		//accessing the elements
		printDetails(cars);
		
		Car maxMileageCar = maximumMileage(cars);
		System.out.println("Car with maximum mileage " + maxMileageCar.getMileage());

	}
	private static void readStudent(Scanner scanner, List<Car> cars) {
		System.out.println("Enter the number of cars");
		int size = scanner.nextInt();
		for(int i=0;i<size;i++) {
			System.out.println("Enter the carId");
			int carId = scanner.nextInt();
			System.out.println("Enter the comapny name");
			String companyName = scanner.next();
			System.out.println("Enter the price");
			double price = scanner.nextDouble();
			System.out.println("Enter the mileage");
			double mileage = scanner.nextDouble();
			
			cars.add(new Car (carId, companyName, price,mileage));
		}
		
	}
	private static void printDetails( List<Car> cars) {
		for(Car car: cars)
			System.out.println(car);
	}
	
	private static Car maximumMileage (List<Car> cars) {
		Car maxMileageCar = cars.get(0);
        for (Car car : cars) {
            isMax(cars, car, maxMileageCar);
        }
        return maxMileageCar;
	}
	private static void isMax(List<Car>cars, Car car, Car maxMileageCar) {
		if(car.getMileage() > maxMileageCar.getMileage())
			maxMileageCar = car;
	}
	
}

//linkedlist --> in java by default doubly linked list is created
