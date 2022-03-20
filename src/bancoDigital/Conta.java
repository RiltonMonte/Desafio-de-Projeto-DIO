package bancoDigital;

public class Conta {
	
	private static final int AGENCIA = 1;
	private static int SEQUENCIAL = 1;
	
	private int agencia;
	private int numero;
	private double saldo;
	private Cliente cliente;
	
	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void saque(double valor) {
		saldo -= valor;
	}
	public void deposito(double valor) {
		saldo += valor;
	}
	public void transferencia(double valor, Conta contaDestino) {
		this.saque(valor);
		contaDestino.deposito(valor);
		}
	public void extrato() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: R$%.2f", this.saldo));
	}
}
