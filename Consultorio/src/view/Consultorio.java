package view;

import java.util.Scanner;

public class Consultorio {

    public static void menuConsultorio() {
        while (true) {
            switch (scanInt(menu())) {
                case 1:
                    MenuPaciente.menuPaciente();
                    break;
                case 2:
                    MenuMedicamento.menuMedicamento();
                    break;
                case 3:
                    MenuConsulta.menuConsulta();
                    break;
                case 4:

                    break;
                case 5:

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

    private static String menu() {
        String menu = "\n=============================";
        menu += "\n>>>Consultório Médico<<<";
        menu += "\n=============================";
        menu += "\n1- Cadastro de Pacientes";
        menu += "\n2- Cadastro de Medicamentos";
        menu += "\n3- Agendamento de Consultas";
        menu += "\n4- Registro de Consultas";
        menu += "\n5- Histórico de Consultas por Paciente";
        menu += "\n6- Sair";
        menu += "\n   Escolha qual deseja acessar: ";
        return menu;
    }

    private static int scanInt(Object out) {
        System.out.print(out);
        Scanner scanner = new Scanner(System.in);
        return (scanner.nextInt());
    }
}
