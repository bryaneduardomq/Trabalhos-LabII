package br.com.bryan.senac.menus;

import br.com.bryan.senac.venda.Venda;
import java.util.Scanner;

//Classe do Menu Principal do Programa
public class MenuPrincipal {

    //Método do menu principal
    @SuppressWarnings({"static-access"})
    public static void menuPrincipal() {
        Scanner e = new Scanner(System.in);
        String menu = "\n===========================================";
        menu += "\n>>>Controle de Vendas de Passagens Aéreas<<<";
        menu += "\n===========================================";
        menu += "\nDentre as seguintes opções disponíveis:";
        menu += "\n1- Cadastro de Clientes";
        menu += "\n2- Cadastro de Aviões";
        menu += "\n3- Cadastro de Voos";
        menu += "\n4- Venda de Passagens Aéreas";
        menu += "\n5- Relatórios";
        menu += "\n6- Sair";
        menu += "\n   Escolha qual deseja acessar: ";
        System.out.println(menu);
        int op = e.nextInt();
        while (true) {
            switch (op) {
                case 1:
                    MenuCliente.menuCliente();
                    break;
                case 2:
                    MenuAviao.menuAviao();
                    break;
                case 3:
                    MenuVoo.menuVoo();
                    break;
                case 4:
                    Venda.realizarVenda();
                    break;
                case 5:
                    MenuRelatorio.menuRelatorio();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }
    }
}
