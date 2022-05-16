package model;

import java.util.Scanner;

public class Client extends Contact {
	
	private String name;
	private String birthDate;
	private char smoker;
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
	
	public static void createCustomer() {
		//CRIA UM NOVO CLIENTE ACIONANDO O CONSTRUTOR Client
		System.out.println("\n***************************************************"
				+ "\n                   NOVO CLIENTE");
		Hotel.client[index] = new Client();
		System.out.println("\nCliente cadastrado com sucesso!");
	}
	public static void listCustomer() {
		//LISTA TODOS OS CLIENTES
		System.out.println("\n***************************************************"
						   + "\n                  LISTA DE CLIENTES");
		int i = 0;
		while(i < index) {
			if(Hotel.client[i] != null) {
			System.out.println("__________________________________________________"+
					"\n                 "+Hotel.client[i].getName()+
					"\nCódigo: "+i+ 
					"\nData de nascimento: "+Hotel.client[i].getBirthDate()+
					"\nE-mail: "+ Hotel.client[i].getEmail()+
					"\nTelefone: "+ Hotel.client[i].getTelephone()+
					"\nCidade: "+Hotel.client[i].getCity()+
					"\nUF: "+Hotel.client[i].getUf()+
					"\nFumante: "+ Hotel.client[i].getSmoker());	
			}else {
				System.out.println("\n**************************************************"
						+ "\nCódigo:"+i+"|Cliente inexistente"
						+ "\n**************************************************");
			}
			i++;
		}
	}
	public static void deleteCustomer() {
		//DELETA CLIENTE
		Scanner input = new Scanner(System.in);

		System.out.println("Insira o código do cliente para excluí-lo: ");
		int i = input.nextInt();
		Hotel.client[i] = null;
		System.out.println("Cliente excluído com sucesso!");
	}
	
	public static void screenModify(int cod) {
		//CHAMA A TELA DO MENU DE ALTERAÇÃO
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n****************************************"
				+ "\n ALTERA CLIENTE: "+Hotel.client[cod].getName()
				+ "\n1 - nome"
				+ "\n2 - Data de nascimento"
				+ "\n3 - E-mail"
				+ "\n4 - Telefone"
				+ "\n5 - Cidade"
				+ "\n6 - UF"
				+ "\n7 - Fumante "
				+ "\n\nDigite o número do campo que deseja alterar");
	}
	public static void modifyCustomer() {
		//ALTERA OS DADOS DO CLIENTE
		Scanner input = new Scanner(System.in);
		
		System.out.println("Código do cliente que deseja editar: ");
		int cod = input.nextInt();
			if(Hotel.client[cod] == null) {
				System.out.println("cliente inexistente");
			}else {
			screenModify(cod);
			int number = input.nextInt();
				switch(number) {
					case 1:
						//ALTERA NOME DO CLIENTE
						System.out.print("Novo nome: ");
						Hotel.client[cod].setName(new Scanner(System.in).nextLine());
						System.out.println("\nNome alterado com sucesso!");
						break;
					case 2:
						//ALTERA DATA DE NASCIMENTO
						System.out.print("Nova data: ");
						Hotel.client[cod].setBirthDate(new Scanner(System.in).nextLine());
						System.out.println("\nNome alterado com sucesso!");
						break;
					case 3:
						//ALTERA EMAIL
						System.out.print("Novo E-mail: ");
						Hotel.client[cod].setEmail(new Scanner(System.in).nextLine());
						System.out.println("\nData de nascimento alterada com sucesso!");
						break;
					case 4:
						//ALTERA TELEFONE
						System.out.print("Novo Telefone: ");
						Hotel.client[cod].setTelephone(new Scanner(System.in).nextLine());
						System.out.println("\nTelefone alterado com sucesso!");
						break;
					case 5: 
						//ALTERA CIDADE
						System.out.print("Nova cidade: ");
						Hotel.client[cod].setCity(new Scanner(System.in).nextLine());
						System.out.println("\nCidade alterada com sucesso!");
						break;
					case 6:
						//ALTERA UNIDADE FEDERATIVA
						System.out.print("Nova unidade federativa: ");
						Hotel.client[cod].setUf(new Scanner(System.in).nextLine());
						System.out.println("\nCidade alterada com sucesso!");
						break;
					case 7:
						//ALTERA FUMANTE
						System.out.print("Altere fumante para: ");
						Hotel.client[cod].setSmoker(new Scanner(System.in).next().charAt(0));
						System.out.println("\nFumante alterado com sucesso!");
						break;			
				}	
			}	
	}
}
