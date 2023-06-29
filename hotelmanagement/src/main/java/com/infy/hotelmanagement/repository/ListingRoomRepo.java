package com.infy.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.hotelmanagement.entity.Roomtype;

@Repository
public interface ListingRoomRepo extends JpaRepository<Roomtype, Integer>{
	

}
