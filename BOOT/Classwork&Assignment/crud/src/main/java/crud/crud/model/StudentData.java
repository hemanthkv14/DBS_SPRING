package crud.crud.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studentdata")
public class StudentData implements Serializable{
	
	@Id
	@Column
	private int id;

	@Column
	private String name;

	@Column
	private String dept;

	@Column
	private int marks;

	StudentData(){
		
	}
	
	public StudentData(int id, String name, String dept, int marks){
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.marks = marks;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDept() {
		return this.dept;
	}
	
	public int getMarks() {
		return this.marks;
	}
	
	@Override
	public String toString() {
		return "Id : "+this.getId()+"\tName : "+this.getName()+"\t Department : "+this.getDept()+"\tMarks : "+this.getMarks();
	}
}
