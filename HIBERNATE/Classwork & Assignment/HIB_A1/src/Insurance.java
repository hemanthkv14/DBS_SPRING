import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Insurance")
public class Insurance {
	@Id
	@Column(name = "policyNo")
	private int policyNo;
	@Column(name = "name")
	private String name;
	@Column(name = "tenure")
	private int tenure;
	@Column(name = "amountToPay")
	private int amountToPay;

	Insurance(){
		
	}
	
	Insurance(int policyNo, String name, int tenure, int amountToPay){
		this.policyNo = policyNo;
		this.name = name;
		this.tenure = tenure;
		this.amountToPay = amountToPay;
	}
	
	public void setPolicyNo(int policyNo) {
		this.policyNo = policyNo;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public void setAmountToPay(int amountToPay) {
		this.amountToPay = amountToPay;
	}

	public int getPolicyNo() {
		return this.policyNo;
	}

	public String getName() {
		return this.name;
	}
	
	public int getTenure() {
		return this.tenure;
	}

	public int getAmountToPay() {
		return this.amountToPay;
	}
	
}
