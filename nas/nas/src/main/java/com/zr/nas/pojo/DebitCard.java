package com.zr.nas.pojo;

public class DebitCard {
	private int id;
	private int u_id;
	private int emp_id;
	private double card_amount;
	private String card_species;
	private String phone;
	private double card_deduction;
	@Override
	public String toString() {
		return "DebitCard [id=" + id + ", u_id=" + u_id + ", emp_id=" + emp_id + ", card_amount=" + card_amount
				+ ", card_species=" + card_species + ", phone=" + phone + ", card_deduction=" + card_deduction + "]";
	}
	public DebitCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DebitCard(int id, int u_id, int emp_id, double card_amount, String card_species, String phone,
			double card_deduction) {
		super();
		this.id = id;
		this.u_id = u_id;
		this.emp_id = emp_id;
		this.card_amount = card_amount;
		this.card_species = card_species;
		this.phone = phone;
		this.card_deduction = card_deduction;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public double getCard_amount() {
		return card_amount;
	}
	public void setCard_amount(double card_amount) {
		this.card_amount = card_amount;
	}
	public String getCard_species() {
		return card_species;
	}
	public void setCard_species(String card_species) {
		this.card_species = card_species;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getCard_deduction() {
		return card_deduction;
	}
	public void setCard_deduction(double card_deduction) {
		this.card_deduction = card_deduction;
	}
	
	
}
