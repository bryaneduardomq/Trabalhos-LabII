package br.com.bryan.senac.main;
import br.com.bryan.senac.menus.MenuPrincipal;

//Classe de in�cio do programa, apenas aciona o menu principal de outra classe (Inicio)
public class Executa {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// Inst�ncia do objeto
		MenuPrincipal ini = new MenuPrincipal();

		// Iniciar o programa
		ini.menuPrincipal();

	}

}
