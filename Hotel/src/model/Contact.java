package model;

import java.util.Scanner;

public class Contact {
	Scanner input = new Scanner(System.in);
	
	private String email;
	private String Telephone;
	private String city;
	private String uf;
	
	public Contact() {
		
		setEmail();
		setTelephone();
		setCity();
		setUf();
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail() {
		System.out.print("Insira seu e-mail: ");
		String email = input.nextLine();
		this.email = email;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone() {
		System.out.print("Insira seu telefone: ");
		String telephone = input.nextLine();
		Telephone = telephone;
	}
	public String getCity() {
		return city;
	}
	public void setCity() {
		System.out.print("Cidade: ");
		String city = input.nextLine();
		this.city = city;
	}
	public String getUf() {
		return uf;
	}
	public void setUf() {
		System.out.print("Unidade federativa: ");
		String uf = input.next();
		this.uf = uf;
	}
	
}
