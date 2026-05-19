package com.mvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.entity.TestFood;

public interface FoodOrderRepository extends JpaRepository<TestFood, Long>{

}
