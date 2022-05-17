//GESTÃO DE HOTELARIA
package model;

import java.util.Scanner;

public class Hotel {
	
	public static Client client[] = new Client[100];
	public static Room room[] = new Room[40];
	public static double feeService = 50; 
	
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
					check_out();
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
				+ "\n                 QUARTOS DISPONÍVEIS");
		int i = 0;
		while(i < Room.index) {
			if(Hotel.room[i].getOccupied() == false ) {
				System.out.println("__________________________________________________"+
					"\n                     "+Hotel.room[i].getCategory()+
					"\nCódigo: "+i+
					"\nQuarto número: "+Hotel.room[i].getNumber()+
					"\nCapacidade máxima: "+Hotel.room[i].getCapacity()+
					"\nValor da diária: R$"+ Hotel.room[i].getPrice()+
					"\nAceita fumantes?: "+ Hotel.room[i].getSmoker());
			}else {
				System.out.println("\n**************************************************"
						+ "\nQuarto nº:"+Hotel.room[i].getNumber() +" OCUPADO "
						+ "\nCliente: "+ Hotel.client[i].getName()
						+ "\nCPF: "+room[i].getGuest()
						+ "\n**************************************************");
			}
			i++;
		}
	}
	public static void check_in() {
	//REALIZA CHECK-IN 
		Scanner input = new Scanner(System.in);
		System.out.println("**************************************************"
					+ "\n                   CHECK-IN"
					+ "\n**************************************************");
		
		System.out.print("Insira o código do hóspede: ");
		int codClient = input.nextInt();
		
		System.out.print("Insira o código do quarto: ");
		int codRoom = input.nextInt();
		
		System.out.println("Quantos dias você pretende ficar hospedado: ");
		int days = input.nextInt();
		//Faz o processamento do check-in
		String cpfClientIn = client[codClient].getCpf();
		room[codRoom].setDaysHosted(days);
		room[codRoom].setGuest(cpfClientIn);
		room[codRoom].setOccupied(true);
		
		System.out.println("\nCheck-in realizado com sucesso!");
	}
	public static void check_out() {
	//REALIZA CHECK-OUT
		Scanner input = new Scanner(System.in);
		System.out.println("**************************************************"
				+ "\n                    CHECK-OUT"
				+ "\n**************************************************");
		
		System.out.println("CPF do cliente:  ");
		String cpfClientOut = input.nextLine(); 
		
		//Percorre os quartos e verifica em qual quarto tem o CPF do cliente
		for(int i = 0; i < Room.index; i++) {
			if(room[i].getGuest().equals(cpfClientOut)) {
				//Faz o processamento do check-out
				int amountPay = (int) (room[i].getPrice()* room[i].getDaysHosted());
				System.out.print("Dias hospedado: "+ room[i].getDaysHosted());
				System.out.print("\nValor a pagar: R$"+(amountPay+feeService));
				room[i].setOccupied(false);
				room[i].setGuest(null);
				System.out.println("\nCheck-out concluído!");	
				break;
			}
		} 		
	}
}
