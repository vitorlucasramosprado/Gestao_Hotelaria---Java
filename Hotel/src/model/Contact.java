package model;

import java.util.Scanner;

public class Contact {
	Scanner input = new Scanner(System.in);
	
	private String email;
	private String Telephone;
	private String city;
	private String uf;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
	
		this.email = email;
	}
	
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
}
