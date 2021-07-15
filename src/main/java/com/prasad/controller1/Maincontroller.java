package com.prasad.controller1;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prasad.model.Product;
import com.prasad.model.ProductList;

@RestController
@RequestMapping("/client")
public class Maincontroller {

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/addProduct")
	public Product save(@RequestBody Product product) {
		System.out.println("the product details are i am from productclient: " + product);
		Product obj = restTemplate.postForObject("http://localhost:8090/service/save", product, Product.class);
		System.out.println("helloooooooooooo" + obj);
		return obj;

	}

	@GetMapping("/getallProducts")
	public ProductList getalldetaills(){
		ProductList obj=   restTemplate.getForObject("http://localhost:8090/service/getallProducts", ProductList.class);
	//	ModelAndView mv= new ModelAndView();
	//	mv.addObject("list",obj);
	//	mv.setViewName("Product");
		return obj;
	
	}
	
	
}
