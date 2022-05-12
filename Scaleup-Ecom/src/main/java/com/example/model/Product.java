package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long pid;
	private String p_name;
	private String p_category;
	private String p_details;
	private long p_price;
	private int p_qty;
	private String p_img;
	private long m_id;
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_category() {
		return p_category;
	}
	public void setP_category(String p_category) {
		this.p_category = p_category;
	}
	public String getP_details() {
		return p_details;
	}
	public void setP_details(String p_details) {
		this.p_details = p_details;
	}
	public long getP_price() {
		return p_price;
	}
	public void setP_price(long p_price) {
		this.p_price = p_price;
	}
	public int getP_qty() {
		return p_qty;
	}
	public void setP_qty(int p_qty) {
		this.p_qty = p_qty;
	}
	public String getP_img() {
		return p_img;
	}
	public void setP_img(String p_img) {
		this.p_img = p_img;
	}
	public long getM_id() {
		return m_id;
	}
	public void setM_id(long m_id) {
		this.m_id = m_id;
	}
	public Product(long pid, String p_name, String p_category, String p_details, long p_price, int p_qty, String p_img,
			long m_id) {
		super();
		this.pid = pid;
		this.p_name = p_name;
		this.p_category = p_category;
		this.p_details = p_details;
		this.p_price = p_price;
		this.p_qty = p_qty;
		this.p_img = p_img;
		this.m_id = m_id;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", p_name=" + p_name + ", p_category=" + p_category + ", p_details=" + p_details
				+ ", p_price=" + p_price + ", p_qty=" + p_qty + ", p_img=" + p_img + ", m_id=" + m_id + "]";
	}
	
	

	
	
}
