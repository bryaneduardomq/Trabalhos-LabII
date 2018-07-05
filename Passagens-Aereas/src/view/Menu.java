package view;

import java.sql.SQLException;
import model.Aviao;
import model.Venda;
import model.Voo;
import java.util.Scanner;
import model.Cliente;
import model.Relatorio;

//Classe do Menu Principal do Programa
public class Menu {

    //Método do menu principal
    @SuppressWarnings("static-access")
    public static void menuPrincipal() throws SQLException {
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
                    menuCliente();
                    break;
                case 2:
                    menuAviao();
                    break;
                case 3:
                    menuVoo();
                    break;
                case 4:
                    Venda.realizarVenda();
                    break;
                case 5:
                    menuRelatorio();
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

    public static void menuCliente() throws SQLException {
        Scanner e = new Scanner(System.in);
        String mCliente = "\n=========================";
        mCliente += "\nMenu Cliente";
        mCliente += "\n=========================";
        mCliente += "\n1- Cadastrar Cliente";
        mCliente += "\n2- Visualizar Total de Clientes";
        mCliente += "\n3- Atualizar Dados do Cliente";
        mCliente += "\n4- Excluir Cliente";
        mCliente += "\n5- Voltar";
        mCliente += "\n   Escolha: ";
        System.out.println(mCliente);
        int opcao = e.nextInt();
        while (true) {
            switch (opcao) {
                case 1:
                    Cliente.cadastrarCliente();
                    break;
                case 2:
                    Cliente.visualizarClientes();
                    break;
                case 3:
                    Cliente.atualizarDadosCliente();
                    break;
                case 4:
                    Cliente.excluirCliente();
                    break;
                case 5:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }
    }

    public static void menuAviao() throws SQLException {
        Scanner e = new Scanner(System.in);
        String mAviao = "\n=========================";
        mAviao += "\nMenu de Aviões";
        mAviao += "\n=========================";
        mAviao += "\n1- Cadastrar Avião";
        mAviao += "\n2- Visualizar Frota de Aviões";
        mAviao += "\n3- Atualizar Avião";
        mAviao += "\n4- Excluir Avião";
        mAviao += "\n5- Voltar";
        mAviao += "\n   Escolha: ";
        System.out.println(mAviao);
        int opcao = e.nextInt();
        while (true) {
            switch (opcao) {
                case 1:
                    Aviao.cadastrarAviao();
                    break;
                case 2:
                    Aviao.visualizarFrota();
                    break;
                case 3:
                    Aviao.atualizarAviao();
                    break;
                case 4:
                    Aviao.deletarAviao();
                    break;
                case 5:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }
    }

    @SuppressWarnings("static-access")
    public static void menuVoo() throws SQLException {
        Scanner e = new Scanner(System.in);
        String mVoo = "\n=========================";
        mVoo += "\nMenu de Voos";
        mVoo += "\n=========================";
        mVoo += "\n1- Cadastrar Voo";
        mVoo += "\n2- Visualizar Total de Voos";
        mVoo += "\n3- Atualizar Voo";
        mVoo += "\n4- Excluir Voo";
        mVoo += "\n5- Voltar";
        mVoo += "\n   Escolha: ";
        System.out.println(mVoo);
        int opcao = e.nextInt();
        while (true) {
            switch (opcao) {
                case 1:
                    Voo.cadastrarVoo();
                    break;
                case 2:
                    Voo.visualizarVoo();
                    break;
                case 3:
                    Voo.atualizarVoo();
                    break;
                case 4:
                    Voo.deletarVoo();
                case 5:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }
    }

    @SuppressWarnings("static-access")
    public static void menuRelatorio() throws SQLException {
        Scanner e = new Scanner(System.in);
        String menuRelat = "\n=====================";
        menuRelat += "\nRelatórios";
        menuRelat += "\n=====================";
        menuRelat += "\n1- Relatório de Clientes";
        menuRelat += "\n2- Relatório de Passageiros";
        menuRelat += "\n3- Relatório de Origem";
        menuRelat += "\n4- Relatório de Destino";
        menuRelat += "\n5- Relatório de Voos";
        menuRelat += "\n6- Voltar";
        menuRelat += "\n   Escolha qual deseja acessar: ";
        System.out.println(menuRelat);
        int op = e.nextInt();
        while (true) {
            switch (op) {
                case 1:
                    Relatorio.relatorioPorCliente();
                    break;
                case 2:
                    Relatorio.relatorioPorPassageiros();
                    break;
                case 3:
                    Relatorio.relatorioPorOrigem();
                    break;
                case 4:
                    Relatorio.relatorioPorDestino();
                    break;
                case 5:
                    Relatorio.relatorioPorVoos();
                    break;
                case 6:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }
    }

}
