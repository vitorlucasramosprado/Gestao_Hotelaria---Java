//GESTÃO DE HOTELARIA
package model;

import java.util.Scanner;

public class Hotel {
	
	public static Client client[] = new Client[100];
	public static Room room[] = new Room[40];

	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		while(true) {
			//CHAMA MENU PRINCIPAL
			mainScreen();
			int number = input.nextInt();
			switch(number) {
				case 1:
					customerScreen();
					customerMenu();
					break;
				case 2:
					roomScreen();
					roomMenu();
					break;
				case 3:
					checkRoom();
					break;
				case 4:
					check_in();
					break;
				case 5:
					break;
				case 6:
					System.out.println("Operação finalizada");
					return;
			
			}			
		}
	}
		
	public static void mainScreen() {
		System.out.print("__________________________________________________"
				+ "\n\nSISTEMA DE GERENCIAMENTO DE HOTEL - MENU PRINCIPAL"
				+ "\n__________________________________________________"
				+ "\n\n1 - Clientes"
				+ "\n2 - Quartos"
				+ "\n3 - Verificar quartos disponíveis"
				+ "\n4 - Realizar check-in"
				+ "\n5 - Realizar check-out"
				+ "\n6 - Sair do sistema"
				+ "\n\nSelecione uma opção acima: ");
	}
	public static void customerScreen() {
	//IMPRIME A TELA DE OPÇÕES DO CLIENTE 
		System.out.println("**************************************************"
				+ "\n                  MENU - CLIENTE"
				+ "\n**************************************************"
				+ "\n1 - Cadastrar"
				+ "\n2 - Editar"
				+ "\n3 - Listar"
				+ "\n4 - Excluir"
				+ "\n\nSelecione uma opção acima: ");
	}
	public static void roomScreen() {
		//IMPRIME O MENU DE OPÇÕES DOS QUARTOS 
		System.out.print("**************************************************"
				+ "\n                  MENU - QUARTOS"
				+ "\n**************************************************"
				+ "\n1 - Cadastrar"
				+ "\n2 - Editar"
				+ "\n3 - Listar"
				+ "\n4 - Excluir"
				+ "\n\nSelecione uma opção acima: ");
	}
		
	public static void customerMenu() {
		//CHAMA OS MÉTODOS DO CLIENTE
		Scanner input = new Scanner(System.in);
		
		int number = input.nextInt();
		switch(number) {
			case 1: 
				Client.createCustomer();
				break;
			case 2:
				Client.modifyCustomer();
				break;
			case 3:
				Client.listCustomer();	
				break;
			case 4:
				Client.deleteCustomer();
				break;				
		}
	}
	public static void roomMenu() {
		//CHAMA OS MÉTODOS DO QUARTO
		Scanner input = new Scanner(System.in);
		
		int number = input.nextInt();
		switch(number) {
			case 1:
				Room.createRoom();
				break;
			case 2:
				Room.modifyRoom();
				break;
			case 3:
				Room.listRoom();
				break;
			case 4:
				Room.deleteRoom();
				break;				
		}
	}
	
	public static void checkRoom() {
		//LISTA TODOS OS QUARTOS DISPONÍVEIS
			System.out.println("\n***************************************************"
					+ "\n                  QUARTOS DISPONÍVEIS");
			int i = 0;
			while(i < Room.index) {
				if(Hotel.room[i].getOccupied() == false ) {
					System.out.println("__________________________________________________"+
						"\n                     "+Hotel.room[i].getCategory()+
						"\nQuarto número: "+Hotel.room[i].getNumber()+
						"\nCapacidade máxima: "+Hotel.room[i].getCapacity()+
						"\nValor da diária: R$"+ Hotel.room[i].getPrice()+
						"\nAceita fumantes?: "+ Hotel.room[i].getSmoker());
				}else {
					System.out.println("\n**************************************************"
							+ "\nQuarto nº:"+Hotel.room[i].getNumber() +" OCUPADO "
							+ "\nCliente: "+room[i].getGuest()
							+ "\n**************************************************");
				}
				i++;
			}
		}
	
	public static void check_in() {
	//REALIZA CHECK-IN 
		Scanner input = new Scanner(System.in);

		System.out.println("**************************************************"
				+ "\n                  CHECK-IN"
				+ "\n**************************************************");
		
		System.out.print("Insira o código do cliente que vai se hospedar: ");
		int codClient = input.nextInt();
		
		System.out.print("Insira o código do quarto: ");
		int codRoom = input.nextInt();	
		
		String nameClient = client[codClient].getName();
		
		room[codRoom].setGuest(nameClient);
		room[codRoom].setOccupied(true);
		
		System.out.println("Check-in realizado com sucesso");
	}	
}
