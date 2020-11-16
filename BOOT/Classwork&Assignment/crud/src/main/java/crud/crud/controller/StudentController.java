package crud.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crud.crud.dao.StudentDao;
import crud.crud.model.StudentData;

@RestController
public class StudentController {
	@Autowired
	StudentDao std;

	@RequestMapping("/insert")
	public String insertData() {
		StudentData st1 = new StudentData(1, "Hemanth", "CSE", 825);
		StudentData st2 = new StudentData(2, "Prasadh", "IT", 892);
		std.insertData(st1);
		std.insertData(st2);
		return "Data Inserted";
	}
	

	@RequestMapping("/delete/{id}")
	public String insertData(@PathVariable("id") int id) {
		std.deleteRecord(id);
		return "Data Deleted";
	}
	
	@RequestMapping("/display")
	public List<StudentData> getData(){
		List<StudentData> stdList = std.displayAll();
		return stdList;
	}
	
}
