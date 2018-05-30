package menus;

import java.util.Scanner;

import classes.Voo;

//Método do menu de voos
public class MenuVoo {

    static Scanner e = new Scanner(System.in);

    //Menu de voos
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
        System.out.println(mVoo);
        int opcao = e.nextInt();
        while (true) {
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