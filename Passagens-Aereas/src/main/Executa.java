package main;

import jdbc.Conexao;
import menus.MenuPrincipal;

//Classe de início do programa
public class Executa {

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        // Iniciar conexão com o banco
        Conexao.getConnection();
        // Iniciar o programa
        MenuPrincipal.menuPrincipal();

    }

}
