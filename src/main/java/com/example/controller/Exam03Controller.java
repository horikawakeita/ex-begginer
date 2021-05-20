package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
	
	@Autowired
	private ServletContext application;

	@RequestMapping("")
	public String index() {
		return "exam03";
	}
	
	@RequestMapping("/buy")
	public String buy(String product1,String product2,String product3) {
		int price1 = Integer.parseInt(product1);
		int price2 = Integer.parseInt(product2);
		int price3 = Integer.parseInt(product3);
		int nonTaxPrice = price1 + price2 + price3;
		int price = (int)(1.1 * nonTaxPrice);
		application.setAttribute("nonTaxPrice", nonTaxPrice);
		application.setAttribute("price", price);
		System.out.println(price);
		return "exam03-result";
	}
}
