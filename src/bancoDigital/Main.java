package bancoDigital;

import java.util.Scanner;

public class Main {
	 	
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		Banco DIO = new Banco();
	
		while(true) {
			System.out.println("=== Banco Digital DIO ===");
			System.out.println("Bem vindo(a).");
			System.out.println("Selecione a operação desejada: ");
			System.out.println(" 1 - Cadastrar usuario\n 2 - Criar conta\n 3 - Transacoes finaceiras\n 4 - sair");	
			int opc = leitor.nextInt();
			switch(opc) {
			case(1): DIO.cadastrarUsuario();break;
			case(2): DIO.criarConta();break;
			case(3): DIO.transFinaceiras();break;
			case(4):return;
			default:System.out.println("\n\n opcao invalida.\n\n");
			}
		}
	}
}	
