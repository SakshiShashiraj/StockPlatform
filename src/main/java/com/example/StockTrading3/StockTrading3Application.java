package com.example.StockTrading3;

import com.example.StockTrading3.model.Customer;
import com.example.StockTrading3.model.Stock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockTrading3Application {

	public static void main(String[] args) {


		SpringApplication.run(StockTrading3Application.class, args);
		Customer John = new Customer("John Doe");
		Customer Jane = new Customer("Jane Doe");
		System.out.println("Jon id: " + John.getId());
		System.out.println("jane id: " + Jane.getId());

		John.addFunds(1000);
		Stock Nvidia = new Stock("Nvidia", 50, 200);
		System.out.println("Stock id = " + Nvidia.getId());
		Stock apple = new Stock("apple", 100, 10);
		System.out.println("Stock id apple = " + apple.getId());
		John.buy(Nvidia, 10);
		System.out.println(John.generateStatement());
		System.out.println(Nvidia);

	}

}
