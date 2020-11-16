package com.sunsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunsoft.dao.InsuranceDao;
import com.sunsoft.model.InsuranceData;

@RestController
public class InsuranceController {
	@Autowired
	InsuranceDao  insd;
	@RequestMapping("/insert")
	public String insertData()
	{
		InsuranceData i1=new InsuranceData();
		i1.setId(259);
		i1.setName("Hemanth");
		i1.setTenure(3);
		i1.setAmount(77000);
		
		InsuranceData i2=new InsuranceData();
		i2.setId(224);
		i2.setName("Prasadh");
		i2.setTenure(2);
		i2.setAmount(49000);
		
		insd.insertData(i1);
		insd.insertData(i2);
		return "Data Inserted Successfully";
	}
	@RequestMapping("/delete/{id}")
	public String deleteData(@PathVariable ("id") int id) {
		insd.deleteData(id);
		return "Record Deleted Successfully";
	}
	
	@RequestMapping("/update/{id}/{newId}/{name}/{tenure}/{amount}")
	public String updateData(@PathVariable ("id") int id, @PathVariable ("newId") int newId, @PathVariable ("name") String name, @PathVariable ("tenure") int tenure, @PathVariable ("amount") int amount) {
		List<InsuranceData> lt = displayAll();
		for(InsuranceData t: lt) {
			if(t.getId() == id) {
				t.setId(newId);
				t.setName(name);
				t.setTenure(tenure);
				t.setAmount(amount);
				break;
			}
		}
		return "update"+id;
	}
	@RequestMapping("/displayAll")
	 public List<InsuranceData> displayAll(){
		  List<InsuranceData> il=(List<InsuranceData>) insd.displayAll();
		  return il;
	  }

}

