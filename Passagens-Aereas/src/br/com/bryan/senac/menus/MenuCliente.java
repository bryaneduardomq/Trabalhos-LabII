package br.com.bryan.senac.menus;

import java.util.Scanner;

import br.com.bryan.senac.classes.Cliente;

//Classe do Menu do Cliente
public class MenuCliente {

    //Método Menu Cliente
    @SuppressWarnings("static-access")
    public static void menuCliente() {
        Scanner e = new Scanner(System.in);
        Cliente cliente = new Cliente();
        MenuPrincipal voltar = new MenuPrincipal();
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
                    cliente.cadastrarCliente();
                    break;
                case 2:
                    cliente.visualizarClientes();
                    break;
                case 3:
                    cliente.atualizarDadosCliente();
                    break;
                case 4:
                    cliente.excluirCliente();
                    break;
                case 5:
                    voltar.menuPrincipal();
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }
    }
}
