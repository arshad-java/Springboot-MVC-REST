package com.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class BillController {
	
	@Autowired
	Customer cust;
	
//	@GetMapping("/bill")
//	public String bill(Model model)
//	{
//		double st = cust.getQyt()*cust.getPrice();
//		double gst = st*0.18;
//		double dis = st>5000?st*0.10:st;
//		double total = st+gst-dis;
//		
//		model.addAttribute("st", st);
//		model.addAttribute("gst", gst);
//		model.addAttribute("dis", dis);
//		model.addAttribute("total", total);
//		
//		return "bill";
//	}
//	
	@GetMapping("/bill")
	public String bill(Model model)
	{
		double Airfiar = cust.getQyt()*cust.getPrice();
//		double gst = st*0.18;
//		double dis = st>5000?st*0.10:st;
		double total = Airfiar+1000;
		
		model.addAttribute("af", Airfiar);
//		model.addAttribute("gst", gst);
//		model.addAttribute("dis", dis);
		model.addAttribute("total", total);
		
		return "bill";
	}

}
