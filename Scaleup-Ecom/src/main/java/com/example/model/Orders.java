package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long oid;
	private long pid;
	private String p_name;
	private String p_category;
	private String p_details;
	private String p_price;
	private int p_qty;
	private String p_img;
	private long m_id;
	private String total_price;
	private String uname;
	private String address;
	private String grand_total;
	private String order_status;
	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
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
	public String getP_price() {
		return p_price;
	}
	public void setP_price(String p_price) {
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
	public String getTotal_price() {
		return total_price;
	}
	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGrand_total() {
		return grand_total;
	}
	public void setGrand_total(String grand_total) {
		this.grand_total = grand_total;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	
	
	public Orders(long oid, long pid, String p_name, String p_category, String p_details, String p_price, int p_qty,
			String p_img, long m_id, String total_price, String uname, String address, String grand_total,
			String order_status) {
		super();
		this.oid = oid;
		this.pid = pid;
		this.p_name = p_name;
		this.p_category = p_category;
		this.p_details = p_details;
		this.p_price = p_price;
		this.p_qty = p_qty;
		this.p_img = p_img;
		this.m_id = m_id;
		this.total_price = total_price;
		this.uname = uname;
		this.address = address;
		this.grand_total = grand_total;
		this.order_status = order_status;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", pid=" + pid + ", p_name=" + p_name + ", p_category=" + p_category
				+ ", p_details=" + p_details + ", p_price=" + p_price + ", p_qty=" + p_qty + ", p_img=" + p_img
				+ ", m_id=" + m_id + ", total_price=" + total_price + ", uname=" + uname + ", address=" + address
				+ ", grand_total=" + grand_total + ", order_status=" + order_status + "]";
	}
	
	
	
	
}
