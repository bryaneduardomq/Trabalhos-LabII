package br.com.bryan.senac.menus;

import java.util.Scanner;

import br.com.bryan.senac.classes.Aviao;

public class MenuAviao {

	static Scanner e = new Scanner(System.in);

	@SuppressWarnings("static-access")
	public static void menuAviao() {
		Aviao aviao = new Aviao();
		MenuPrincipal voltar = new MenuPrincipal();
		int opcao = 0;
		String mAviao = "\n=========================";
		mAviao += "\nMenu de Aviões";
		mAviao += "\n=========================";
		mAviao += "\n1- Cadastrar Avião";
		mAviao += "\n2- Visualizar Frota de Aviões";
		mAviao += "\n3- Voltar";
		mAviao += "\n   Escolha: ";
		boolean sair = true;
		System.out.println(mAviao);
		opcao = e.nextInt();
		while (sair) {
			switch (opcao) {
			case 1:
				aviao.cadastrarAviao();
				break;
			case 2:
				aviao.visualizarFrota();
				break;
			case 3:
				voltar.menuPrincipal();
				break;
			default:
				System.out.println("Opção Inválida");
				break;
			}
		}
	}
}
