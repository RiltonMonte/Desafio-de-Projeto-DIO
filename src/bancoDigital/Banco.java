package bancoDigital;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
	
	private List<Conta> contasCorrente = new ArrayList<Conta>();
	private List<Conta> contasPoupanca = new ArrayList<Conta>();
	private List<Cliente> clientes = new ArrayList<Cliente>();
	Scanner leitor = new Scanner(System.in);

	
	private String nome;

	public List<Conta> getContasCorrente() {
		return contasCorrente;
	}


	public void setContasCorrente(List<Conta> contasCorrente) {
		this.contasCorrente = contasCorrente;
	}


	public List<Conta> getContasPoupanca() {
		return contasPoupanca;
	}


	public void setContasPoupanca(List<Conta> contasPoupanca) {
		this.contasPoupanca = contasPoupanca;
	}


	public List<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void comprovanteTransferencia(Conta origem, double valor, Conta destino) {
		System.out.println("=== Coprovante de Transferencia ===");
		System.out.println();
		System.out.println(String.format("Conta de origem: %d",origem.getNumero()));
		System.out.println();
		System.out.println(String.format("Valor: %.2f",valor));
		System.out.println();
		System.out.println(String.format("Conta de destino: %d",destino.getNumero()));
		
	}
	
	public void transFinaceiras() {
		System.out.println("Selecione a transação desejada: ");
		System.out.println("1 - saque, 2 - deposito, 3 - transferencia, 4 - extrato, ou qualquer outro valor para retornar ao menu principal.");
		int Trans = leitor.nextInt();
		switch(Trans) {
		case(1):{
			System.out.println("Digite o nome do titular da conta: ");
			String nome = leitor.next();
			if(verificaListaCadastro(nome) == false) {
			System.out.println("usuario nao encontrado.");
			break;
			}
			System.out.println("Selecione o tipo de conta: 1 - corrente, 2 - poupanca.");
			int cont = leitor.nextInt();
			switch(cont) {
			case(1):{
				if(verificaConta(nome,contasCorrente)==true) {
					System.out.println("Conta nao existente para este usuario.");
					break;
				}
				System.out.println("Digite o valor a ser sacado:");
				int valor = leitor.nextInt();
				if (valor<=0) System.out.println("valor invalido.");
				retornaConta(nome, contasCorrente).saque(valor);
				System.out.println("Saque efetuado com sucesso.");
				break;
			}
			case(2):{
				if(verificaConta(nome,contasPoupanca)==true) {
					System.out.println("Conta nao existente para este usuario.");
					break;
				}
				System.out.println("Digite o valor a ser sacado:");
				int valor = leitor.nextInt();
				if (valor<=0) System.out.println("valor invalido.");
				retornaConta(nome, contasPoupanca).saque(valor);
				System.out.println("Saque efetuado com sucesso.");
				break;	
				}
			default:System.out.println("Opção invalida.");
			}
		break;
		}
		case(2):{
			System.out.println("Digite o nome do titular da conta: ");
			String nome = leitor.next();
			if(verificaListaCadastro(nome) == false) {
			System.out.println("usuario nao encontrado.");
			break;
			}
			System.out.println("Selecione o tipo de conta: 1 - corrente, 2 - poupanca.");
			int cont = leitor.nextInt();
			switch(cont) {
			case(1):{
				if(verificaConta(nome,contasCorrente)==true) {
					System.out.println("Conta nao existente para este usuario.");
					break;
				}
				System.out.println("Digite o valor a ser depositado:");
				int valor = leitor.nextInt();
				if (valor<=0) System.out.println("valor invalido.");
				retornaConta(nome, contasCorrente).deposito(valor);
				System.out.println("Deposito efetuado com sucesso.");
				break;
			}
			case(2):{
				if(verificaConta(nome,contasPoupanca)==true) {
					System.out.println("Conta nao existente para este usuario.");
					break;
				}
				System.out.println("Digite o valor a ser Depositado:");
				int valor = leitor.nextInt();
				if (valor<=0) System.out.println("valor invalido.");
				retornaConta(nome, contasPoupanca).deposito(valor);
				System.out.println("Deposito efetuado com sucesso.");
				break;	
				}
			default:System.out.println("Opção invalida.");
			}
		break;
		}
		case(3):{
			System.out.println("Digite o nome do titular da conta de origem: ");
			String nomeOrigem = leitor.next();
			if(verificaListaCadastro(nomeOrigem) == false) {
			System.out.println("usuario nao encontrado.");
			break;
			}
			System.out.println("Selecione o tipo de conta de origem: 1 - corrente, 2 - poupanca.");
			int cont = leitor.nextInt();
			switch(cont) {
			case(1):{
				if(verificaConta(nomeOrigem,contasCorrente)==true) {
				System.out.println("Conta nao existente para este usuario.");
				break;
				}
				System.out.println("Digite o nome do titular da conta de destino:");
				String nomeDestino = leitor.next();
				if(verificaListaCadastro(nomeDestino) == false) {
				System.out.println("usuario nao encontrado.");
				break;
				}
				System.out.println("Digite o valor a ser transferido:");
				int valor = leitor.nextInt();
				if (valor<=0) System.out.println("valor invalido.");
				retornaConta(nomeOrigem, contasCorrente).transferencia(valor, retornaConta(nomeDestino, contasCorrente));
				System.out.println("Transferencia efetuada com sucesso.");
				comprovanteTransferencia(retornaConta(nomeOrigem, contasCorrente), valor, retornaConta(nomeDestino, contasCorrente));
				break;
			}
			case(2):{
				if(verificaConta(nomeOrigem,contasPoupanca)==true) {
				System.out.println("Conta nao existente para este usuario.");
				break;
				}
				System.out.println("Digite o nome do titular da conta de destino:");
				String nomeDestino = leitor.next();
				if(verificaListaCadastro(nomeDestino) == false) {
				System.out.println("usuario nao encontrado.");
				break;
				}
				System.out.println("Digite o valor a ser transferido:");
				int valor = leitor.nextInt();
				if (valor<=0) System.out.println("valor invalido.");
				retornaConta(nomeOrigem, contasPoupanca).transferencia(valor, retornaConta(nomeDestino, contasPoupanca));
				System.out.println("Transferencia efetuada com sucesso.");
				comprovanteTransferencia(retornaConta(nomeOrigem, contasPoupanca), valor, retornaConta(nomeDestino, contasPoupanca));
				break;
			}
			default:System.out.println("Opção invalida.");
			}
		break;
		}
		case(4):{
		System.out.println("Digite o nome do titular da conta: ");
		String nome = leitor.next();
		if(verificaListaCadastro(nome) == false) {
		System.out.println("usuario nao encontrado.");
		break;
		}
		System.out.println("Selecione o tipo de conta: 1 - corrente, 2 - poupanca.");
		int cont = leitor.nextInt();
		switch(cont) {
			case(1):{
				if(verificaConta(nome,contasCorrente)==true) {
				System.out.println("Conta nao existente para este usuario.");
				break;
				}
				retornaConta(nome, contasCorrente).extrato();
				break;
			}
			case(2):{
				if(verificaConta(nome,contasPoupanca)==true) {
				System.out.println("Conta nao existente para este usuario.");
				break;
				}
				retornaConta(nome, contasPoupanca).extrato();
				break;
			}
		default:System.out.println("Opção invalida");
		}
		break;
		}
		
		default:System.out.println("Opção invalida");
		}
	}
	
	public void criarConta() {
		System.out.println("Digite o nome do Titular da conta:");
		String nome = leitor.next();
		Cliente cliente = verificaLista(nome);
		if(cliente == null) {
		System.out.println("Usuario nao encontrado.");
		return;
		}
		System.out.println("Selecione o tipo de conta:");
		System.out.println("1 - Conta Corrente");
		System.out.println("2 - Conta Poupança");
		int tipo = leitor.nextInt();
		
		switch(tipo){
		case(1):{
			if(verificaConta(cliente.getNome(),contasCorrente)==false) {
			System.out.println("Ja existe uma conta corrente cadastrada para este usuario.");
			break;
			}
			ContaCorrente Cconrente = new ContaCorrente(cliente);
			contasCorrente.add(Cconrente);
			System.out.println("Conta Corrente criada com sucesso!!!");
			break; 
		}
		case(2):{
			if(verificaConta(cliente.getNome(),contasPoupanca)==false) {
			System.out.println("Ja existe uma conta poupanca cadastrada para este usuario.");
			break;
			}
			ContaPoupanca Cpoupanca = new ContaPoupanca(cliente);
			contasPoupanca.add(Cpoupanca);
			System.out.println("Conta Poupanca criada com sucesso!!!");
			break;
		}
		default:System.out.println("opção invalida");	
		}
	}
		
	public void cadastrarUsuario() {
		System.out.println("Digite o nome do usuario: ");
		String nome = leitor.next();
		
				if(verificaListaCadastro(nome)== false) {
				Cliente cliente = new Cliente();
				cliente.setNome(nome);
				clientes.add(cliente);
				System.out.println("Usuario cadastrado com sucesso!");
				}else System.out.println("Usuario ja cadastrado.");	
	}
	
	public boolean verificaListaCadastro(String nome) {
		for (int i=0;i < clientes.size();i++) {
			if( clientes.size()==0) {
				return false;
			}else if (nome.equals(clientes.get(i).getNome())) {
			return true;
			}		
		}return false;
	}
	
	public Cliente verificaLista(String nome) {
		for(int i=0;i < clientes.size();i++) {
			if( clientes.size()==0) {
			return null;
			}else if (nome.equals(clientes.get(i).getNome())) {
			return clientes.get(i);
			}
		}return null;
	}

	public Conta retornaConta(String nome,List<Conta> contas) {
		for(int i=0;i < contas.size();i++) {
			if( contas.size()==0) {
			return null;
			}else if (nome.equals(contas.get(i).getCliente().getNome())) {
			return contas.get(i);
			}
		}return null;
	}
	
	public boolean verificaConta(String nome,List<Conta> contas) {
		for(int i=0;i < contas.size();i++) {
			if( contas.size()==0) {
			return true;
			}else if (nome.equals(contas.get(i).getCliente().getNome())) {
			return false;
			}
		}return true;
	}
}


	

