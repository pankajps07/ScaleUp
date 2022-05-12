package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Cart;

public interface CartRepository extends JpaRepository<Cart ,Long> {
	public boolean existsBypidAndUname(long pid,String uname);
	
	public List<Cart> getByUname(String uname);
	
	@Query(value = "SELECT sum(total_price) FROM Cart WHERE uname=?1",nativeQuery=true)
    public Long sumQuantities(String uname);
	
	@Query(value = "SELECT count(*) FROM Cart WHERE uname=?1",nativeQuery=true)
	public Long Countitem(String uname);
	
	
	
}
