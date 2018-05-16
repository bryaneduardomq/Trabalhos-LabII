package br.com.bryan.senac.menus;

import br.com.bryan.senac.venda.Venda;
import java.util.Scanner;

//Classe do Menu Principal do Programa
public class MenuPrincipal {
    
    //Método do menu principal
    @SuppressWarnings({"static-access"})
    public static void menuPrincipal() {
        Scanner e = new Scanner(System.in);
        MenuCliente mc = new MenuCliente();
        MenuAviao ma = new MenuAviao();
        MenuVoo mv = new MenuVoo();
        Venda vd = new Venda();
        String menu = "\n===========================================";
        menu += "\n>>>Controle de Vendas de Passagens Aéreas<<<";
        menu += "\n===========================================";
        menu += "\nDentre as seguintes opções disponíveis:";
        menu += "\n1- Cadastro de Clientes";
        menu += "\n2- Cadastro de Aviões";
        menu += "\n3- Cadastro de Voos";
        menu += "\n4- Venda de Passagens Aéreas";
        menu += "\n5- Relatório da Venda";
        menu += "\n6- Sair";
        menu += "\n   Escolha qual deseja acessar: ";
        System.out.println(menu);
        int op = e.nextInt();
        while (true) {
            switch (op) {
                case 1:
                    mc.menuCliente();
                    break;
                case 2:
                    ma.menuAviao();
                    break;
                case 3:
                    mv.menuVoo();
                    break;
                case 4:
                    vd.realizarVenda();
                    break;
                case 5:
                    //Relatorio.main(args);
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
