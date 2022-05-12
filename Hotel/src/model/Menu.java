package model;

import java.util.Scanner;

public class Menu {
	//Sistema de gestão de hotel
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			
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
			System.out.println("*************************************************"
					+ "\nSISTEMA DE GERENCIAMENTO DE HOTEL - MENU PRINCIPAL"
					+ "\n*************************************************"
					+ "\n1 - Cadastrar, editar, listar ou excluir clientes"
					+ "\n2 - Cadastrar, editar, listar ou excluir quartos"
					+ "\n3 - Verificar quartos disponíveis"
					+ "\n4 - Realizar check-in"
					+ "\n5 - Realizar check-out"
					+ "\n6 - Sair do sistema"
					+ "\n\nSelecione uma opção acima: ");
		}
}
