package com.example.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repo.CartRepository;

@Service
@Transactional
public class CartService {
	
	@Autowired
	private CartRepository repo;
	 public void delete(long cid) {
	        repo.deleteById(cid);
	    }
}
