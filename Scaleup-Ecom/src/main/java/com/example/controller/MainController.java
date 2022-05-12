package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Customer;
import com.example.model.Orders;
import com.example.model.Cart;
import com.example.model.Product;
import com.example.repo.CartRepository;
import com.example.repo.CustomerRepository;
import com.example.repo.OrderRepository;
import com.example.repo.ProductRepository;
import com.example.service.CartService;
import com.example.service.ProductService;

@Controller
public class MainController {
	
	String name="";
	String login_msg="";
	@Autowired(required = true)
	private CustomerRepository custrepo;
		
	 @Autowired
	 private ProductService service;
	 
	 @Autowired
	 private CartService cartservice;
	
	 @Autowired
	private CartRepository cartRepo;
	 
	 @Autowired
	private OrderRepository orderRepo;
	 
//================================================Home Product Page============================================================	
	 @RequestMapping(value = "/", method = RequestMethod.GET)
	public String Home(Model model) {
		if(name=="")
			return "login";
		else {
				List<Product> listProducts = service.listAll();
				model.addAttribute("listProducts", listProducts);  
				
				List<Cart> c = cartRepo.getByUname(name);
				model.addAttribute("cartProducts", c);  
				model.addAttribute("total",cartRepo.sumQuantities(name));
				model.addAttribute("count",cartRepo.Countitem(name));
				login_msg="";
				return "index";		
		}
	}
	
//=================================================="login design Page"============================================
	@GetMapping("/login")
	public String Login(Model model) {
		
		
		if(name=="") {
			model.addAttribute("customers", new Customer());
			System.out.println(name);
			return "login";
			
		}
		else
			return "index";
	}
//	=================================description page================================================
	
	  @GetMapping("/descr")
	  public String description(Model model) {
		  	List<Cart> c = cartRepo.getByUname(name);
			model.addAttribute("cartProducts", c);  
			model.addAttribute("total",cartRepo.sumQuantities(name));
			model.addAttribute("count",cartRepo.Countitem(name));
		  return "description"; 
	  }
//========================================Signup page====================================================	 
	@GetMapping("/signup")
	public String Signup(Model model) {
		model.addAttribute("customers", new Customer());

		return "signup";
	}
//=========================================Cart =========================================================
	@GetMapping("/cart")
	public String Cart(@ModelAttribute("cart") Cart cart,Model model) {
		
	
		List<Cart> c = cartRepo.getByUname(name);
		model.addAttribute("cartProducts", c);  
		model.addAttribute("total",cartRepo.sumQuantities(name));
		model.addAttribute("count",cartRepo.Countitem(name));
			return "cart";
		
	}
//========================================================signup page=====================================================
	@RequestMapping(value = "/onsignup", method = RequestMethod.POST)
	public @ResponseBody String doSignup(@ModelAttribute("customer") Customer cust, Model model,HttpSession session) {
		
			
		String txt = null;
		if (custrepo.existsByEmail(cust.getEmail())) {
			txt = "1";
		} else {
			txt = "0";
			this.custrepo.save(cust);
		}
		return txt;
				
	}
//===========================================onLogin Page================================================================
	@RequestMapping(value = "/onlogin", method = RequestMethod.POST)
	public @ResponseBody String doLogin(@ModelAttribute("customer") Customer cust, Model model,HttpSession session) {
		String txt = null;
			if(custrepo.existsByEmailAndPassword(cust.getEmail(),cust.getPassword())) {
				
				model.addAttribute("name",cust.getEmail());
				session.setAttribute("name", cust.getEmail());
				name=(String) session.getAttribute("name");
				List<Product> listProducts = service.listAll();
				model.addAttribute("listProducts", listProducts); 
				session.setAttribute("log_msg","Successfull");
				login_msg=(String) session.getAttribute("log_msg");
				txt="1";
				return txt;
				
			}
			else {
				txt="0";
				return txt;
			}
	}
//	====================================Logout=============================================================
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		name="";
		return "login";
	}
	
//============================================Description page==============================================
	
	@RequestMapping(value="/{pid}",method = RequestMethod.GET) 
	public ModelAndView ShowDescription(@PathVariable(name = "pid") long pid ,Model model) {
	   
		ModelAndView mav = new ModelAndView("description");  
	    Product product = service.get(pid);
	    mav.addObject("product", product);
	    List<Cart> c = cartRepo.getByUname(name);
		model.addAttribute("cartProducts", c);  
		model.addAttribute("total",cartRepo.sumQuantities(name));
		model.addAttribute("count",cartRepo.Countitem(name));
	    return mav;
	}
//	====================================add to cart========================================
	@RequestMapping(value="/addcart",method=RequestMethod.POST)
	public @ResponseBody String AddCart(@ModelAttribute("cart") Cart cart,Model model) {
		
		String res="";
		if(cartRepo.existsBypidAndUname(cart.getPid(), cart.getUname())) {
		res="1";
		
		}else {
			res="0";
			this.cartRepo.save(cart);
			
		}
		return res;
	}
	
	/*
	 * @RequestMapping(value="/{cid}",method = RequestMethod.POST) public String
	 * DeleteItem(@ModelAttribute("cart") Cart cart,Model model) {
	 * cartRepo.DeleteItem(cart.getCid(), name); return "index"; }
	 */
	@RequestMapping(value="/delete/{cid}",method = RequestMethod.GET)
	public String deleteCart(@PathVariable(name = "cid") int cid) {
		cartservice.delete(cid);
	    return "redirect:/";       
	}
	
	@RequestMapping(value="/order",method=RequestMethod.GET)
	public String Order(Model model) {
		
		List<Cart> c = cartRepo.getByUname(name);
		model.addAttribute("cartProducts", c);  
		model.addAttribute("total",cartRepo.sumQuantities(name));
		model.addAttribute("count",cartRepo.Countitem(name));
		return "order";
	}
//	=================================place order=======================================
	@RequestMapping(value="/placeorder",method=RequestMethod.POST)
	public  String AddCart(@ModelAttribute("orders") Orders ord,Model model) {
		
		model.addAttribute("");
		this.orderRepo.save(ord);
		
		return "order";
	
}
}
