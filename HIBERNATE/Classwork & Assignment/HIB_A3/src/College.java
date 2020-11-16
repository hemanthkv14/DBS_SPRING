import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity(name = "College")
public class College {
	
	private String code;
	private String name;
	private Set<Student> std = new HashSet<Student>(0);
	

	College(){
		
	}
	
	College(String code, String name){
		this.code = code;
		this.name = name;
	}
	
	College(String code, String name, Set<Student> std){
		this.code = code;
		this.name = name;
		this.std = std;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setStd(Set<Student> std) {
		this.std = std;
	}

	@Id
	@Column(name = "code")
	public String getCode() {
		return this.code;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CLGSTU", joinColumns = { @JoinColumn(name = "code") }, inverseJoinColumns = { @JoinColumn(name = "pin") })
	public Set<Student> getStd() {
			return this.std;
	}
	
	@Override
	public String toString() {
		return "Code : "+this.getCode()+"\nName : "+this.getName();
	}
	
}
