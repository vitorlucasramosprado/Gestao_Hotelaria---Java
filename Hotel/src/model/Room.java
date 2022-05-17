package model;

import java.util.Scanner;

public class Room {
	
	private String category;
	private int number;
	private int capacity;
	private Double price;
	private boolean smoker;
	private int daysHosted;
	private  String guest;
	public boolean occupied = false;
	public static int index = 0;
	
	public Room() {
		
		System.out.print("Insira a categoria: ");
		setCategory(new Scanner(System.in).next());
		
		System.out.print("Insira o número do quarto: ");
		setNumber(new Scanner(System.in).nextInt());
		
		System.out.print("Capacidade máxima de hóspedes: ");
		setCapacity(new Scanner(System.in).nextInt());
		
		System.out.print("Insira o valor da diária: R$");
		setPrice(new Scanner(System.in).nextDouble());
		
		System.out.print("Aceita fumantes?(s/n): ");
		setSmoker(new Scanner(System.in).next());
		
		index++;	
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public boolean getSmoker() {
		return smoker;
	}
	public void setSmoker(String smoker) {
		if(smoker.equals("s")) {
			this.smoker = true;
		}else if(smoker.equals("n")) {
			this.smoker = false;
		}else {
			System.out.println("WARNING:Cadastrado como não fumante");			
		}
	}
	
	public boolean getOccupied() {
		return occupied;
	}
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public  String getGuest() {
		return guest;
	}
	public  void setGuest(String guest) {
		this.guest = guest;
	}

	public int getDaysHosted() {
		return daysHosted;
	}
	public void setDaysHosted(int daysHosted) {
		this.daysHosted = daysHosted;
	}

	
	public static void createRoom() {
    //CRIA UM NOVO QUARTO 
		System.out.println("\n***************************************************"
				+ "\n                   NOVO QUARTO");
		Hotel.room[index] = new Room();
		System.out.println("\nQuarto cadastrado com sucesso!");
	}
	public static void listRoom() {
		//LISTA TODOS OS QUARTOS
		System.out.println("\n***************************************************"
							+ "\n                  LISTA DE QUARTOS");
		int i = 0;
		while(i < index) {
			if(Hotel.room[i] != null ) {
				System.out.println("__________________________________________________"+
					"\n                     "+Hotel.room[i].getCategory()+
					"\nCódigo: "+i+
					"\nQuarto número: "+Hotel.room[i].getNumber()+
					"\nCapacidade máxima: "+Hotel.room[i].getCapacity()+
					"\nValor da diária: R$"+ Hotel.room[i].getPrice()+
					"\nAceita fumantes?: "+ Hotel.room[i].getSmoker());
			}else {
				System.out.println("\n**************************************************"
						+ "\nQuarto inexistente"
						+ "\n**************************************************");
			}i++;
		}
	}
	public static void deleteRoom() {
	//DELETA CLIENTE
		Scanner input = new Scanner(System.in);
	
		System.out.print("Insira o código do quarto para excluí-lo: ");
		int i = input.nextInt();
		Hotel.room[i] = null;
		System.out.println("Quarto excluído com sucesso!");
	}
	
	public static void screenModifyRoom(int cod) {
		//TELA DE ALTERAÇÃO DO QUARTO
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n***************************************************"
				+ "\n ALTERA QUARTO: "+Hotel.room[cod].getNumber()
				+ "\n1 - Categoria"
				+ "\n2 - Número do quarto"
				+ "\n3 - Capacidade máxima"
				+ "\n4 - Valor da diária"
				+ "\n5 - Aceita Fumante?"
				+ "\n\nDigite o número do campo que deseja alterar");
	}
	public static void modifyRoom() {
	//ALTERA DADOS DOS QUARTOS
		Scanner input = new Scanner(System.in);
		
		System.out.println("Código do quarto que deseja editar:");
		int cod = input.nextInt();
		if(Hotel.room[cod] == null) {
			System.out.println("Quarto inexistente");
		}else {
			screenModifyRoom(cod);
			int number = input.nextInt();
			switch(number) {
				case 1:
					//ALTERA CATEGORIA DO QUARTO
					System.out.print("Nova categoria: ");
					Hotel.room[cod].setCategory(new Scanner(System.in).nextLine());
					System.out.println("\nCategoria alterada com sucesso!");
					break;
				case 2:
					//ALTERA NÚMERO DO QUARTO
					System.out.print("Novo número: ");
					Hotel.room[cod].setNumber(new Scanner(System.in).nextInt());
					System.out.println("\nNúmero alterado com sucesso!");
					break;
				case 3:
					//ALTERA CAPACIDADE MÁXIMA
					System.out.print("Novo capacidade: ");
					Hotel.room[cod].setCapacity(new Scanner(System.in).nextInt());
					System.out.println("\nCapacidade máxima alterada com sucesso!");
					break;
				case 4:
					//ALTERA VALOR DA DIÁRIA
					System.out.print("Novo valor: ");
					Hotel.room[cod].setPrice(new Scanner(System.in).nextDouble());
					System.out.println("\nPreço alterado com sucesso!");
					break;
				case 5:
					//ALTERA STATUS DO FUMANTE
					System.out.println("Altere fumante para:");
					Hotel.room[cod].setSmoker(new Scanner(System.in).next());
					System.out.println("Fumante alterado com sucesso!");
					break;
			}
		}
	}
}

