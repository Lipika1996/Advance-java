package com.js.product;

public class SaveProduct {

	public static void main(String[] args) {
		Product p = new Product();
		p.setId(2);
		p.setName("pen");
		p.setBrand("Camel");
		p.setQuantity(15);
		p.setPrice(10);
		
		
		ProductCrud ps = new ProductCrud();
		ps.saveProduct(p);
		System.out.println("Inserted");

	}

}
