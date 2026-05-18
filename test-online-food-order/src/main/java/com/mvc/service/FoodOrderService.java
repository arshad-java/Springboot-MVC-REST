package com.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.entity.TestFood;
import com.mvc.repo.FoodOrderRepository;

@Service
public class FoodOrderService {
	@Autowired
	FoodOrderRepository repo;
	
	public void addOrder(TestFood tf)
	{
		repo.save(tf);
	}
	
	public List<TestFood> viewOrders()
	{
		return repo.findAll();
	}
	
	public void deleteOrder(Long id)
	{
		repo.deleteById(id);
	}
	
	public TestFood getOrderById(Long id)
	{
		return repo.findById(id).get();
	}
	

}
