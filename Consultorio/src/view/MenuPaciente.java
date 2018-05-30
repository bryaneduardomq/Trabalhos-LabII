package view;

import model.Paciente;
import java.util.Scanner;

public class MenuPaciente {

    public static void menuPaciente() {
        while (true) {
            switch (scanInt(menuP())) {
                case 1:
                    Paciente.adicionarPaciente();
                    break;
                case 2:
                    Paciente.visualizarPacientes();
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

    private static String menuP() {
        String menuP = "\n=============================";
        menuP += "\n>>>Menu de Pacientes<<<";
        menuP += "\n=============================";
        menuP += "\n1- Adicionar Paciente";
        menuP += "\n2- Visualizar Pacientes";
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
