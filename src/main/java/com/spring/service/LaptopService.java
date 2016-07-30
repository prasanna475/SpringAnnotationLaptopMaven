package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.Laptop;
import com.spring.dao.LaptopDAO;
@Component
public class LaptopService {
	@Autowired
	private LaptopDAO laptopDAO;
	
	/*public LaptopDAO getLaptopDAO() {
		return laptopDAO;
	}

	public void setLaptopDAO(LaptopDAO laptopDAO) {
		this.laptopDAO = laptopDAO;
	}

*/
	public void insertLaptopDetails(Laptop laptop) {
		laptopDAO.insertLaptopDetails(laptop);
	}

	public List<Laptop> getLaptopDetails(int modelNum) {
		return laptopDAO.getLaptopDetails(modelNum);
				
	}
}
