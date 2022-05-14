package model;

import java.util.Scanner;

public class Client extends Contact {
	
	private String name;
	private String birthDate;
	private char smoker;
	public static Client arr[] = new Client[100];
	public static int index = 0;
	
	public Client() {
		//MÉTODO CONSTRUTOR QUE CHAMA OS SETTERS
		
		System.out.print("Insira seu nome: ");
		setName(new Scanner(System.in).nextLine());
		
		System.out.print("Data de nascimento: ");
		setBirthDate(new Scanner(System.in).nextLine());
		
		System.out.print("Insira seu e-mail: ");
		setEmail(new Scanner(System.in).nextLine());
		
		System.out.print("Insira seu telefone: ");
		setTelephone(new Scanner(System.in).nextLine());
		
		System.out.print("Cidade: ");
		setCity(new Scanner(System.in).nextLine());
		
		System.out.print("Unidade federativa: ");
		setUf(new Scanner(System.in).nextLine());
		
		System.out.print("Fumante?(S/N): ");
		setSmoker(new Scanner(System.in).next().charAt(0));
		
		index++;		

	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
			this.name = name;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public char getSmoker() {
		return smoker;
	}
	public void setSmoker(char smoker) {
		this.smoker = smoker;
	}
	
	public static void callHeader() {
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
	public static void menuClient() {
		//CHAMA AS FUNÇÕES DO CLIENTE
		Scanner input = new Scanner(System.in);
		
		int number = input.nextInt();
		switch(number) {
			case 1: 
				createCustomer();
				break;
			case 2:
				alterCustomer();
				break;
			case 3:
				listCustomer();	
				break;
			case 4:
				deleteCustomer();
				break;				
		}
	}
	public static void menuAlter(int cod) {
		//CHAMA A TELA DO MENU DE ALTERAÇÃO
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n****************************************"
				+ "\n ALTERA CLIENTE: "+arr[cod].getName()
				+ "\n1 - nome"
				+ "\n2 - Data de nascimento"
				+ "\n3 - E-mail"
				+ "\n4 - Telefone"
				+ "\n5 - Cidade"
				+ "\n6 - UF"
				+ "\n7 - Fumante "
				+ "\n\nDigite o número do campo que deseja alterar");
	}
	
	public static void createCustomer() {
		//CRIA UM NOVO CLIENTE ACIONANDO O CONSTRUTOR Client
		System.out.println("\n*********************************************"
				+ "\n\n                 NOVO CLIENTE");
		arr[index] = new Client();
		System.out.println("\nCliente cadastrado com sucesso!");
	}
	public static void listCustomer() {
		//LISTA TODOS OS CLIENTES
		int i = 0;
		while(i < index) {
			if(arr[i] != null) {
			System.out.println("***************************************"+
					"\nCódigo: "+i+
					 "\nNome: "+ arr[i].getName()+
					"\nData de nascimento: "+arr[i].getBirthDate()+
					"\nE-mail: "+ arr[i].getEmail()+
					"\nTelefone: "+ arr[i].getTelephone()+
					"\nCidade: "+arr[i].getCity()+
					"\nUF: "+arr[i].getUf()+
					"\nFumante: "+ arr[i].getSmoker());
			i++;
			}
		}
	}
	public static void deleteCustomer() {
		//DELETA CLIENTE
		Scanner input = new Scanner(System.in);

		System.out.println("Insira o código do cliente para excluí-lo: ");
		int i = input.nextInt();
		arr[i] = null;
		System.out.println("Cliente excluído com sucesso!");
	}
	public static void alterCustomer() {
		//ALTERA OS DADOS DO CLIENTE
		Scanner input = new Scanner(System.in);
		
		System.out.println("Código do cliente que deseja alterar: ");
		int cod = input.nextInt();
		menuAlter(cod);
		int number = input.nextInt();
			switch(number) {
				case 1:
					//ALTERA NOME DO CLIENTE
					System.out.print("Novo nome: ");
					arr[cod].setName(new Scanner(System.in).nextLine());
					System.out.println("\nNome alterado com sucesso!");
					break;
				case 2:
					//ALTERA DATA DE NASCIMENTO
					System.out.print("Nova data: ");
					arr[cod].setBirthDate(new Scanner(System.in).nextLine());
					System.out.println("\nNome alterado com sucesso!");
					break;
				case 3:
					//ALTERA EMAIL
					System.out.print("Novo E-mail: ");
					arr[cod].setEmail(new Scanner(System.in).nextLine());
					System.out.println("\nData de nascimento alterada com sucesso!");
					break;
				case 4:
					//ALTERA TELEFONE
					System.out.print("Novo Telefone: ");
					arr[cod].setTelephone(new Scanner(System.in).nextLine());
					System.out.println("\nTelefone alterado com sucesso!");
					break;
				case 5: 
					//ALTERA CIDADE
					System.out.print("Nova cidade: ");
					arr[cod].setCity(new Scanner(System.in).nextLine());
					System.out.println("\nCidade alterada com sucesso!");
					break;
				case 6:
					//ALTERA UNIDADE FEDERATIVA
					System.out.print("Nova unidade federativa: ");
					arr[cod].setUf(new Scanner(System.in).nextLine());
					System.out.println("\nCidade alterada com sucesso!");
					break;
				case 7:
					//ALTERA FUMANTE
					System.out.print("Altere fumante para: ");
					arr[cod].setSmoker(new Scanner(System.in).next().charAt(0));
					System.out.println("\nFumante alterado com sucesso!");
					break;
					
					
					
					
			}	
	}

}
