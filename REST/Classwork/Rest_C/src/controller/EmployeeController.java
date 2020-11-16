package controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Employee;

@RestController
@RequestMapping("/payroll")
public class EmployeeController {
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String getPayroll(@PathVariable int id) {
		HashMap<Integer, Employee> emp = new  HashMap<Integer, Employee>();
		emp.put(1, new Employee (1, "Hemanth", 350000, 240000, 2000, 200));
		emp.put(2, new Employee (2, "Chandrakanth", 450000, 120000, 3000, 250));
		emp.put(3, new Employee (3, "Prasadh", 750000, 350000, 5000, 400));
		Employee ep = null;
		if(emp.containsKey(id)) {
			ep = emp.get(id);
		}
		ep.setGrossSal(ep.getBasic()+ep.getHra()+ep.getAllowance());
		ep.setFinalDeductions((int)(ep.getDeductions()+(ep.getBasic()*0.2)));
		ep.setTotalSal(ep.getGrossSal()-ep.getFinalDeductions());
		return ep.toString();
	}
	
	@RequestMapping(value="/display",method=RequestMethod.POST)
	public ResponseEntity<String> createEmployee(@RequestBody String name){
		System.out.println(name);
		return new ResponseEntity(HttpStatus.CREATED);
	}
}