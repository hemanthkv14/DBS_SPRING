import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "Teacher")
public class Teacher {
	private int id;
	private String subject;
	private String name;
	private Set<Student> std = new HashSet<Student>(0);
	

	Teacher(){
		
	}
	
	Teacher(int id, String subject, String name){
		this.id = id;
		this.subject = subject;
		this.name = name;
	}
	
	Teacher(int id, String subject, String name, Set<Student> std){
		this.id = id;
		this.subject = subject;
		this.name = name;
		this.std = std;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setStd(Set<Student> std) {
		this.std = std;
	}

	@Id
	@Column(name="id")
	public int getId() {
		return this.id;
	}
	
	@Column(name = "subject")
	public String getSubject() {
		return this.subject;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "TCHRSTU", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = { @JoinColumn(name = "pin") })
	public Set<Student> getStd() {
			return this.std;
	}
	
	@Override
	public String toString() {
		return "Id : "+this.getId()+"\tName : "+this.getName()+"\tSubject : "+this.getSubject();
	}
	
}
