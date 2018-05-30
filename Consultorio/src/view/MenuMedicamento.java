package view;

import model.Medicamento;
import java.util.Scanner;

public class MenuMedicamento {

    public static void menuMedicamento() {
        while (true) {
            switch (scanInt(menuMed())) {
                case 1:
                    Medicamento.adicionarMedicamentos();
                    break;
                case 2:
                    Medicamento.visualizarMedicamentos();
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

    private static String menuMed() {
        String menuP = "\n=============================";
        menuP += "\n>>>Menu de Medicamentos<<<";
        menuP += "\n=============================";
        menuP += "\n1- Adicionar Medicamento";
        menuP += "\n2- Visualizar Medicamentos";
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
