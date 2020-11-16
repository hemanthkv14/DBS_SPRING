package model;

public class Employee {
	
	private int id;
	private String name;
	private int basic;
	private int hra;
	private int allowance;
	private int deductions;
	private int grossSal;
	private int finalDeductions;
	private int totalSal;
	
	Employee(){
		
	}
	
	public Employee(int id, String name, int basic, int hra, int allowance, int deductions){
		this.id = id;
		this.name = name;
		this.basic = basic;
		this.hra = hra;
		this.allowance = allowance;
		this.deductions = deductions;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBasic(int basic) {
		this.basic = basic;
	}
	
	public void setHra(int hra) {
		this.hra = hra;
	}
	
	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}
	
	public void setDeductions(int deductions) {
		this.deductions = deductions;
	}
	
	public void setGrossSal(int grossSal) {
		this.grossSal = grossSal;
	}
	
	public void setFinalDeductions(int finalDeductions) {
		this.finalDeductions = finalDeductions;
	}
	
	public void setTotalSal(int totalSal) {
		this.totalSal = totalSal;
	}

	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}

	public int getBasic() {
		return this.basic;
	}

	public int getHra() {
		return this.hra;
	}

	public int getAllowance() {
		return this.allowance;
	}

	public int getDeductions() {
		return this.deductions;
	}

	public int getGrossSal() {
		return this.grossSal;
	}

	public int getFinalDeductions() {
		return this.finalDeductions;
	}

	public int getTotalSal() {
		return this.totalSal;
	}	
	
	@Override
	public String toString() {
		return "Id : "+this.getId()+"\tName : "+this.getName()+"\tBasic : "+this.getBasic()+"\tHra : "+this.getHra()+"\tAllowance : "+this.getAllowance()+"\tDeductions : "+this.getDeductions()+"\tGrossSal : "+this.getGrossSal()+"\tFinalDeductions : "+this.getFinalDeductions()+"\tTotalSal : "+this.getTotalSal();
	}
	
}
