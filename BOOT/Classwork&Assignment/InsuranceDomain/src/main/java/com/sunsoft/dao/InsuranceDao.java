package com.sunsoft.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunsoft.model.InsuranceData;
import com.sunsoft.repository.InsuranceRepository;



@Service
public class InsuranceDao {
	@Autowired
	InsuranceRepository ir;
	
	public void insertData(InsuranceData obj) {
		ir.save(obj);
	}
	public void deleteData(int id) {
		ir.deleteById(id);
	}
	public List<InsuranceData> displayAll(){
		List<InsuranceData> list =(List<InsuranceData>) ir.findAll();
		return list;
	}
	
}
