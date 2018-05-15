package br.com.bryan.senac.menus;
import java.util.Scanner;

import br.com.bryan.senac.classes.Cliente;

public class MenuCliente {

	static Scanner e = new Scanner(System.in);

	@SuppressWarnings("static-access")
	public static void menuCliente() {
		Cliente cliente = new Cliente();
		MenuPrincipal voltar = new MenuPrincipal();
		int opcao = 0;
		String mCliente = "\n=========================";
		mCliente += "\nMenu Cliente";
		mCliente += "\n=========================";
		mCliente += "\n1- Cadastrar Cliente";
		mCliente += "\n2- Visualizar Total de Clientes";
		mCliente += "\n3- Atualizar Dados do Cliente";
		mCliente += "\n4- Excluir Cliente";
		mCliente += "\n5- Voltar";
		mCliente += "\n   Escolha: ";
		boolean sair = true;
		System.out.println(mCliente);
		opcao = e.nextInt();
		while (sair) {
			switch (opcao) {
			case 1:
				cliente.cadastrarCliente();
				break;
			case 2:
				cliente.visualizarClientes();
				break;
			case 3:

				break;
			case 4:

				break;
			case 5:
				voltar.menuPrincipal();
				break;
			default:
				System.out.println("Opção Inválida");
				break;
			}

		}
	}
}
