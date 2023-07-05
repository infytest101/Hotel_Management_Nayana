package com.infy.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.hotelmanagement.entity.Customer;

public interface CutomerRepo extends JpaRepository<Customer, Integer>{
	

}
