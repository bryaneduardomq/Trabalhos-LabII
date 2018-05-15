package br.com.bryan.senac.menus;
import java.util.Scanner;

public class MenuPrincipal {

	static Scanner e = new Scanner(System.in);

	@SuppressWarnings({ "static-access" })
	public static void menuPrincipal() {
		MenuCliente mc = new MenuCliente();
		MenuAviao ma = new MenuAviao();

		String menu = "\n=================================";
		menu += "\nControle de Vendas de Passagens A�reas";
		menu += "\n=================================";
		menu += "\nDentre as seguintes op��es dispon�veis:";
		menu += "\n1- Cadastro de Clientes";
		menu += "\n2- Cadastro de Avi�es";
		menu += "\n3- Cadastro de Voos";
		menu += "\n4- Venda de Passagens A�reas";
		menu += "\n5- Relat�rio da Venda";
		menu += "\n6- Sair";
		menu += "\n   Escolha qual deseja acessar: ";

		boolean sair = true;
		int op = 0;
		while (sair) {
			System.out.println(menu);
			op = e.nextInt();
			switch (op) {
			case 1:
				mc.menuCliente();
				break;
			case 2:
				ma.menuAviao();
				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:
				// sair = false;
				System.exit(6);
				break;
			default:
				System.out.println("Op��o Inv�lida");
				break;
			}
		}
	}
}