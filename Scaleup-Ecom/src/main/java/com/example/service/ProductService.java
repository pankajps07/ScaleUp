package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.repo.ProductRepository;

@Service
@Transactional
public class ProductService {

		@Autowired
	    private ProductRepository repo;
	     
	    public List<Product> listAll() {
	        return repo.findAll();
	    } 
	    
	  
	    public Product get(long pid) {
	        return repo.findById(pid).get();
	    }
}
