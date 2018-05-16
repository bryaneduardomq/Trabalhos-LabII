package br.com.bryan.senac.menus;

import java.util.Scanner;

import br.com.bryan.senac.classes.Aviao;

//Classe do menu de aviões
public class MenuAviao {

    static Scanner e = new Scanner(System.in);

    //Método menu avião
    @SuppressWarnings("static-access")
    public static void menuAviao() {
        Aviao aviao = new Aviao();
        MenuPrincipal voltar = new MenuPrincipal();
        String mAviao = "\n=========================";
        mAviao += "\nMenu de Aviões";
        mAviao += "\n=========================";
        mAviao += "\n1- Cadastrar Avião";
        mAviao += "\n2- Visualizar Frota de Aviões";
        mAviao += "\n3- Voltar";
        mAviao += "\n   Escolha: ";
        System.out.println(mAviao);
        int opcao = e.nextInt();
        while (true) {
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
