package model;

import java.util.Scanner;

public class Client {
	Scanner input = new Scanner(System.in);
	
	private String name;
	private String birthDate;
	public Contact contact;
	private char smoker;
	public static Client arr[] = new Client[10];
	public static int index = 0;
	
	public Client() {
		
		setName();
		setBirthDate();
		setContact();
		setSmoker();
		
		index++;
		

	}
	
	public String getName() {
		return name;
	}
	public void setName() {
		System.out.print("insira seu nome: ");
		String name = input.nextLine();
		this.name = name;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate() {
		System.out.print("Data de nascimento: ");
		String birthDate = input.nextLine();
		this.birthDate = birthDate;
	}
	
	public Contact getContact() {
		return contact;
	}
	public void setContact() {
		this.contact = new Contact();
	}
	
	public char getSmoker() {
		return smoker;
	}
	public void setSmoker() {
		System.out.print("Fumante?(S/N): ");
		char smoker = input.next().charAt(0);
		this.smoker = smoker;
	}
	
	public static void callHeader() {
		System.out.println("************************"
				+ "\n GESTÃO - CLIENTE"
				+ "\n************************"
				+ "\n1 - Cadastrar"
				+ "\n2 - Editar"
				+ "\n3 - Listar"
				+ "\n4 - Excluir"
				+ "\n\nSelecione uma opção acima: ");
	}
	public static void menuClient() {
		Scanner input = new Scanner(System.in);
		
		int number = input.nextInt();
		switch(number) {
			case 1: 
				System.out.println("quantidade de clientes cadastrados: " + index);
				arr[index] = new Client();
				break;
			case 2:
				break;
			case 3:
				System.out.print("Insira o código do cliente: ");
				int cod = input.nextInt();
				System.out.println("nome: "+ arr[cod].getName()+
						"\nData de nascimento: "+arr[cod].getBirthDate()+
						"\nE-mail: "+ arr[cod].getContact().getEmail()+
						"\nTelefone: "+ arr[cod].getContact().getTelephone()+
						"\nCidade: "+arr[cod].getContact().getCity()+
						"\nUF: "+arr[cod].getContact().getUf()+
						"\nFumante: "+ arr[cod].getSmoker());
				break;
			case 4:
				System.out.println("Insira do cliente para excluí-lo: ");
				int i = input.nextInt();
				arr[i] = null;
				break;			
				
		}
	}
}
