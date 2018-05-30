package view;

import model.Consulta;
import java.util.Scanner;

public class MenuConsulta {

    public static void menuConsulta() {
        while (true) {
            switch (scanInt(menuConsult())) {
                case 1:
                    Consulta.adicionarConsulta();
                    break;
                case 2:
                    Consulta.visualizarConsultas();
                    break;
                case 3:
                    Consultorio.menuConsultorio();
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        }

    }

    private static String menuConsult() {
        String menuP = "\n=============================";
        menuP += "\n>>>Menu de Consultas<<<";
        menuP += "\n=============================";
        menuP += "\n1- Adicionar Consulta";
        menuP += "\n2- Visualizar Consultas";
        menuP += "\n3- Voltar";
        menuP += "\n   Escolha qual deseja acessar: ";
        return menuP;
    }

    private static int scanInt(Object out) {
        System.out.print(out);
        Scanner scanner = new Scanner(System.in);
        return (scanner.nextInt());
    }

}
