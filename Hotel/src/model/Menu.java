//GESTÃO DE HOTELARIA
package model;

import java.util.Scanner;

public class Menu {
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			//CHAMA O MENU PRINCIPAL
			while(true) {
				mainMenu();
				int number = input.nextInt();
				switch(number) {
					case 1:
						Client.callHeader();
						Client.menuClient();
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break;
					case 6:
						System.out.println("Operação finalizada");
						return;
				}			
			}
		}
		
		public static void mainMenu() {
			System.out.println("\n**************************************************"
					+ "\nSISTEMA DE GERENCIAMENTO DE HOTEL - MENU PRINCIPAL"
					+ "\n**************************************************"
					+ "\n1 - Clientes"
					+ "\n2 - Quartos"
					+ "\n3 - Verificar quartos disponíveis"
					+ "\n4 - Realizar check-in"
					+ "\n5 - Realizar check-out"
					+ "\n6 - Sair do sistema"
					+ "\n\nSelecione uma opção acima: ");
		}
}
