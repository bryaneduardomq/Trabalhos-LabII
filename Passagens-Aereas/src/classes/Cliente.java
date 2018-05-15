package br.com.bryan.senac.classes;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.bryan.senac.menus.MenuCliente;

public class Cliente {
	private String nome;
	private int rg;
	private String contato;
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	// Construtor Padrão
	public Cliente() {

	}

	public Cliente(String nome, int rg, String contato) {
		this.nome = nome;
		this.rg = rg;
		this.contato = contato;

	}

	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	// Método Para Cadastrar Cliente, é referenciado na classe MenuCliente
	@SuppressWarnings("static-access")
	public static void cadastrarCliente() {
		Cliente c = new Cliente();
		MenuCliente m = new MenuCliente();

		c.nome = digita("Digite o nome do cliente: ");
		c.rg = Integer.parseInt(digita("Digite o rg do cliente: "));
		c.contato = digita("Digite o contato do cliente: ");

		clientes.add(c);

		m.menuCliente();

	}

	// Método para visualização dos clientes cadastrados
	@SuppressWarnings("static-access")
	public static void visualizarClientes() {
		MenuCliente m = new MenuCliente();

		if (clientes.isEmpty()) {
			System.out.println("Nenhum Cliente Cadastrado!!!");
			m.menuCliente();
		} else {
			for (Cliente c : clientes) {
				System.out.println("Nome: " + c.getNome());
				System.out.println("RG: " + c.getRg());
				System.out.println("Contato: " + c.getContato());
				System.out.println();
			}
			m.menuCliente();
		}

	}

	/*
	 * Método para atualizar os dados do Cliente 
	 * public static void
	 * atualizarDadosCliente() {
	 * 
	 * if (clientes.isEmpty()) {
	 * 
	 * } else { int atualiza = Integer .parseInt(
	 * digita("Qual cliente gostaria de atualizar o cadastro? Digite o RG dele(a)"
	 * ));
	 * 
	 * for (int i = 0; i < clientes.size(); i++) { if (atualiza !=
	 * clientes.get(i).getRg()) { System.out.println("RG não cadastrado!"); }
	 * else { System.out.println(""); } }
	 * 
	 * }
	 * 
	 * }
	 */

	public static void excluirCliente() {

	}

	// Método para facilitar a digitação de dados
	private static String digita(String mens) {
		@SuppressWarnings("resource")
		Scanner e = new Scanner(System.in);
		System.out.println(mens);
		return e.next();
	}

}
