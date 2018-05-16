package br.com.bryan.senac.menus;

import java.util.Scanner;

import br.com.bryan.senac.classes.Voo;

public class MenuVoo {

    static Scanner e = new Scanner(System.in);

    @SuppressWarnings("static-access")
    public static void menuVoo() {
        Voo voo = new Voo();
        MenuPrincipal voltar = new MenuPrincipal();
        String mVoo = "\n=========================";
        mVoo += "\nMenu de Voos";
        mVoo += "\n=========================";
        mVoo += "\n1- Cadastrar Voo";
        mVoo += "\n2- Visualizar Total de Voos";
        mVoo += "\n3- Voltar";
        mVoo += "\n   Escolha: ";
        boolean sair = true;
        System.out.println(mVoo);
        int opcao = e.nextInt();
        while (sair) {
            switch (opcao) {
                case 1:
                    voo.cadastrarVoo();
                    break;
                case 2:
                    voo.visualizarVoo();
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
