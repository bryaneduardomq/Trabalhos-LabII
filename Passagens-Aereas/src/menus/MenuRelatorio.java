package menus;

//import br.com.bryan.senac.venda.Relatorio;
import java.util.Scanner;

public class MenuRelatorio {

    public static void menuRelatorio() {
        Scanner e = new Scanner(System.in);
        String menuRelat = "\n=====================";
        menuRelat += "\nRelatórios";
        menuRelat += "\n=====================";
        menuRelat += "\n1- Relatório de Clientes";
        menuRelat += "\n2- Relatório de Passageiros";
        menuRelat += "\n3- Relatório de Origem";
        menuRelat += "\n4- Relatório de Destino";
        menuRelat += "\n5- Relatório de voos";
        menuRelat += "\n6- Voltar";
        menuRelat += "\n   Escolha qual deseja acessar: ";
        System.out.println(menuRelat);
        int op = e.nextInt();
        while (true) {
            switch (op) {
                case 1:
                    //Relatorio.relatorioPorCliente();
                    break;
                case 2:
                    //Relatorio.relatorioPorPassageiros();
                    break;
                case 3:
                    //Relatorio.relatorioPorOrigem();
                    break;
                case 4:
                    //Relatorio.relatorioPorDestino();
                    break;
                case 5:
                    //Relatorio.relatorioPorVoos();
                    break;
                case 6:
                    //MenuPrincipal.menuPrincipal();
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }
    }
}
