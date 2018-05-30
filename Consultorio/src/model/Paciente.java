package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import view.Consultorio;

public class Paciente {

    private int rg;
    private String nome;
    private Calendar dtnascimento;
    public static ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

    public Paciente() {

    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDtnascimento() {
        return dtnascimento;
    }

    public void setDtnascimento(Calendar dtnascimento) {
        this.dtnascimento = dtnascimento;
    }

    public static void adicionarPaciente() {
        Paciente p = new Paciente();

        p.rg = Integer.parseInt(digita("Digite o rg: "));
        p.nome = digita("Digite o nome: ");

        pacientes.add(p);

        Consultorio.menuConsultorio();
    }

    public static void visualizarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum Paciente Cadastrado");
            Consultorio.menuConsultorio();

        } else {
            for (Paciente p : pacientes) {
                System.out.println(">>>Paciente<<<");
                System.out.println("Nome: " + p.getNome());
                System.out.println("RG: " + p.getRg());
                System.out.println("Data de Nascimento: " + p.getDtnascimento());
            }

            Consultorio.menuConsultorio();
        }

    }

    private static String digita(String mens) {
        @SuppressWarnings("resource")
        Scanner e = new Scanner(System.in);
        System.out.println(mens);
        return e.nextLine();
    }

}
