package com.tuto.Hibernate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.Adress;
import entities.Customer;
import entities.Invoice;
import entities.Product;
import model.AdressDao;
import model.CustomerDao;
import model.ProductDao;

public class App {
	
    public static void main( String[] args ){
    	
    	CustomerDao customerDao = new CustomerDao();
    	//AdressDao adressDao = new AdressDao();
    	ProductDao productDao = new ProductDao();
    	
    	Adress adress = new Adress("street 300", "2B", 3333, "ville");
    	Adress adress2 = new Adress("street 10", "2A", 1111, "tunis");
    	
    	//adress= adressDao.saveAdressr(adress);
    	Customer oussema = new Customer("oussema",adress);
    	Customer personne = new Customer("personne",adress2);
    	
    	
    	Product pomme = new Product("pomme",1.15F);
    	productDao.saveProduct(pomme);
    	Product poire = new Product("poire",1F);
    	productDao.saveProduct(poire);
    	
    	Map<Product,Integer> productList1 = new HashMap<>();
    	productList1.put(pomme, 5);
    	productList1.put(poire, 2);
    	
    	Map<Product,Integer> productList2 = new HashMap<>();
    	productList2.put(pomme, 15);
    	productList2.put(poire, 20);
    	
    	Map<Product,Integer> productList3 = new HashMap<>();
    	productList3.put(pomme, 1);
    	
    	Invoice invoice1= new Invoice();
    	Invoice invoice2= new Invoice();
    	Invoice invoice3= new Invoice();
    	
    	invoice1.setProductQuantity(productList1);
    	invoice2.setProductQuantity(productList2);
    	invoice3.setProductQuantity(productList3);
    	
    	
    	List<Invoice> invoiceList = new ArrayList();
    	invoiceList.add(invoice1);
    	invoiceList.add(invoice2);
    	invoiceList.add(invoice3);
    	
    	oussema.setInvoices(invoiceList);
   
    	
    	customerDao.saveCustomer(oussema);
    	
       
        
    	System.out.println( "Le client "+ customerDao.showCustomer(1L) );
      
    }
}
