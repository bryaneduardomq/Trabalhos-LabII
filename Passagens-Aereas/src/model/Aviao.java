package model;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import model.DAO.AviaoDAO;
import view.Menu;

//Classe Avião
public class Aviao {

    private int codigo;
    private String nomeAviao;
    private int qtAssentos;

    //Construtor
    public Aviao() {

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

    //Método de cadastro de aviões
    @SuppressWarnings("static-access")
    public static void cadastrarAviao() throws SQLException, ParseException {
        Aviao a = new Aviao();
        AviaoDAO avDao = new AviaoDAO();
        boolean valida = false;

        do {
            try {
                a.codigo = Integer.parseInt(digita("Digite o código do avião: "));
                valida = true;
            } catch (NumberFormatException ex) {
                System.out.println("Erro: " + ex);
                valida = false;
            }

        } while (valida == false);

        valida = false;

        a.nomeAviao = digita("Digite o nome do avião: ");

        do {
            try {
                a.qtAssentos = Integer.parseInt(digita("Digite a quantidade de assentos do avião: "));
                valida = true;
            } catch (NumberFormatException ex) {
                System.out.println("Erro: " + ex);
                valida = false;
            }

        } while (valida == false);

        avDao.insertAviao(a);

        Menu.menuAviao();

    }

    //Método para visualizar frota de aviões
    @SuppressWarnings("static-access")
    public static void visualizarFrota() throws SQLException, ParseException {
        AviaoDAO avDao = new AviaoDAO();

        List<Aviao> frotaDeAvioes = avDao.listAviao();

        if (frotaDeAvioes.isEmpty()) {
            System.out.println("Nenhum Avião Cadastrado!!!");
            Menu.menuAviao();
        } else {
            for (Aviao a : frotaDeAvioes) {
                System.out.println(">>>AVIÃO<<<");
                System.out.println("Código: " + a.getCodigo());
                System.out.println("Nome: " + a.getNomeAviao());
                System.out.println("Quantidade de Assentos: " + a.getQtAssentos());
                System.out.println();
            }
            Menu.menuAviao();
        }

    }

    public static void atualizarAviao() throws SQLException, ParseException {
        AviaoDAO avDao = new AviaoDAO();

        List<Aviao> listaAviao = avDao.listAviao();

        boolean valida = false;
        int codAviao = 0;

        if (listaAviao.isEmpty()) {
            System.out.println("Avião não cadastrado.");
        } else {
            do {
                try {
                    codAviao = Integer.parseInt(digita("Digite o código do avião a ser atualizado"));
                    for (int i = 0; i < listaAviao.size(); i++) {
                        if (codAviao != listaAviao.get(i).getCodigo()) {
                            System.out.println("Código não encontrado!");
                            Menu.menuAviao();
                        }
                    }
                    valida = true;
                } catch (NumberFormatException ex) {
                    System.out.println("Erro: " + ex);
                    valida = false;
                }

            } while (valida == false);

            valida = false;

            Aviao cod = avDao.listaCod(codAviao);

            int atAviao = 0;

            do {
                try {
                    atAviao = Integer.parseInt(digita("Qual dado quer atualizar? 1 - Nome do Aviao, 2 - Qt de Assentos"));
                    valida = true;
                } catch (NumberFormatException ex) {
                    System.out.println("Erro: " + ex);
                    valida = false;
                }

            } while (valida == false || atAviao != 1 || atAviao != 2);

            if (atAviao == 1) {
                cod.setNomeAviao(digita("Digite o nome atualizado do avião: "));
                avDao.updateAviao(cod);
            }

            if (atAviao == 2) {
                cod.setQtAssentos(Integer.parseInt("Digite a quantidade de assentos atualizada do avião: "));
                avDao.updateAviao(cod);
            }

        }
        Menu.menuAviao();
    }

    public static void deletarAviao() throws SQLException, ParseException {

        AviaoDAO avDao = new AviaoDAO();

        List<Aviao> listaAviao = avDao.listAviao();

        int cod = 0;

        boolean valida = false;

        if (listaAviao.isEmpty()) {
            System.out.println("Avião não cadastrado!");
            Menu.menuAviao();
        } else {
            do {
                try {
                    cod = Integer.parseInt(digita("Digite o rg do cliente a ser excluído: "));
                    for (int i = 0; i < listaAviao.size(); i++) {
                        if (cod != listaAviao.get(i).getCodigo()) {
                            System.out.println("Código não cadastrado!!!");
                            Menu.menuAviao();
                        }
                    }
                    valida = true;
                } catch (NumberFormatException ex) {
                    System.out.println("Erro: " + ex);
                    valida = false;
                }

            } while (valida == false);

            Aviao listCod = avDao.listaCod(cod);

            avDao.deleteAviao(listCod);
            Menu.menuAviao();

        }

    }

    private static String digita(String mens) {
        @SuppressWarnings("resource")
        Scanner e = new Scanner(System.in);
        System.out.println(mens);
        return e.nextLine();
    }

}
