import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

@Entity
@Table(name="STUDENT_one_to_one")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	private int id;
	private String name;
	private int age;
	private String branch;

	@OneToOne(targetEntity=Address.class,cascade=CascadeType.ALL)
	private Address address;
	
	Student(){}
	Student(int id, String name, int age, String branch){
		this.id = id;
		this.name = name;
		this.age = age;
		this.branch = branch;
	}
	Student(int id, String name, int age, String branch, Address address){
		this.id = id;
		this.name = name;
		this.age = age;
		this.branch = branch;
		this.address = address;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setBranch(String branch) {
		this.branch = branch;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getBranch() {
		return this.branch;
	}
	

	public Address getAddress() {
		return address;
	}
	
}
