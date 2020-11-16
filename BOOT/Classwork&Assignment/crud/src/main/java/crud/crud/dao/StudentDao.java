package crud.crud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.crud.model.StudentData;
import crud.crud.repo.StudentRepository;

@Service
public class StudentDao {

	@Autowired
	StudentRepository sr;
	public void insertData(StudentData studentObj) {
		sr.save(studentObj);
	}
	
	public void deleteRecord(int id) {
		sr.deleteById(id);
	}
	
	public List<StudentData> displayAll(){
		List<StudentData> sl = (List<StudentData>) sr.findAll();
		return sl;
	}
	
}
