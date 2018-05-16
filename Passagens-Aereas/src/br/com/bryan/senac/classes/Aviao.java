package br.com.bryan.senac.classes;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.bryan.senac.menus.MenuAviao;

public class Aviao {

    private int codigo;
    private String nomeAviao;
    private int qtAssentos;
    public static ArrayList<Aviao> avioes = new ArrayList<Aviao>();

    public Aviao() {

    }

    public Aviao(int codigo, String nomeAviao, int qtAssentos) {
        this.codigo = codigo;
        this.nomeAviao = nomeAviao;
        this.qtAssentos = qtAssentos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeAviao() {
        return nomeAviao;
    }

    public void setNomeAviao(String nomeAviao) {
        this.nomeAviao = nomeAviao;
    }

    public int getQtAssentos() {
        return qtAssentos;
    }

    public void setQtAssentos(int qtAssentos) {
        this.qtAssentos = qtAssentos;
    }

    @SuppressWarnings("static-access")
    public static void cadastrarAviao() {
        Aviao a = new Aviao();
        MenuAviao m = new MenuAviao();

        a.codigo = Integer.parseInt(digita("Digite o código do avião: "));
        a.nomeAviao = digita("Digite o nome do avião: ");
        a.qtAssentos = Integer.parseInt(digita("Digite a quantidade de assentos do avião: "));

        avioes.add(a);

        m.menuAviao();

    }

    @SuppressWarnings("static-access")
    public static void visualizarFrota() {

        MenuAviao m = new MenuAviao();

        if (avioes.isEmpty()) {
            System.out.println("Nenhum Avião Cadastrado!!!");
            m.menuAviao();
        } else {
            for (Aviao a : avioes) {
                System.out.println("Código: " + a.getCodigo());
                System.out.println("Nome: " + a.getNomeAviao());
                System.out.println("Quantidade de Assentos: " + a.getQtAssentos());
                System.out.println();
            }
            m.menuAviao();
        }

    }

    private static String digita(String mens) {
        @SuppressWarnings("resource")
        Scanner e = new Scanner(System.in);
        System.out.println(mens);
        return e.next();
    }

}
