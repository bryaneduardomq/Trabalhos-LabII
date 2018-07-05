package model;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.DAO.AviaoDAO;
import model.DAO.VooDAO;
import view.Menu;

//Classe Voo
public class Voo {

    private Integer codVoo;
    private String origem;
    private String destino;
    private String horario;
    private Aviao aviao;
    private int quantidadeAssentos; //Variável para controlar a quantidade de assentos no voo

    //Construtor
    public Voo() {

    }

    public Integer getCodVoo() {
        return codVoo;
    }

    public void setCodVoo(Integer codVoo) {
        this.codVoo = codVoo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getQuantidadeAssentos() {
        return quantidadeAssentos;
    }

    public void setQuantidadeAssentos(int quantidadeAssentos) {
        this.quantidadeAssentos = quantidadeAssentos;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    //Método de cadastro de voo
    @SuppressWarnings("static-access")
    public static void cadastrarVoo() throws SQLException, ParseException {
        Voo v = new Voo();
        VooDAO vDao = new VooDAO();
        AviaoDAO avDao = new AviaoDAO();

        List<Aviao> frotaDeAvioes = avDao.listAviao();

        boolean valida = false;
        int cod = 0;

        do {
            v.origem = digita("Digite a origem do voo: ");
            Pattern padrao = Pattern.compile("[0-9]");
            Matcher combinacao = padrao.matcher(v.getOrigem());
            if (combinacao.find()) {
                System.out.println("Não pode conter números!");
                valida = false;
            } else {
                valida = true;
            }

        } while (valida == false || v.origem.equals(""));

        do {
            v.destino = digita("Digite o destino do voo: ");
            Pattern padrao = Pattern.compile("[0-9]");
            Matcher combinacao = padrao.matcher(v.getDestino());
            if (combinacao.find()) {
                System.out.println("Não pode conter números!");
                valida = false;
            } else {
                valida = true;
            }

        } while (valida == false || v.destino.equals(""));

        SimpleDateFormat form = new SimpleDateFormat("HH:mm");

        Date date = new Date(System.currentTimeMillis());

        v.horario = form.format(date);
        do {
            try {
                cod = Integer.parseInt(digita("Digite o código do avião deste voo: "));
                for (int i = 0; i < frotaDeAvioes.size(); i++) {
                    if (cod != frotaDeAvioes.get(i).getCodigo()) {
                        System.out.println("Código não encontrado!");
                        Menu.menuVoo();
                    }
                }
                valida = true;
            } catch (NumberFormatException ex) {
                System.out.println("Erro: " + ex);
                valida = false;
            }

        } while (valida == false);

        Aviao av = avDao.listaCod(cod);

        v.aviao = av;
        v.quantidadeAssentos = av.getQtAssentos();

        vDao.insertVoo(v);

        Menu.menuVoo();
    }

    //Método para visualizar dados do voo
    @SuppressWarnings("static-access")
    public static void visualizarVoo() throws SQLException, ParseException {
        VooDAO vDao = new VooDAO();

        List<Voo> listaDeVoos = vDao.listaDeVoos();

        if (listaDeVoos.isEmpty()) {
            System.out.println("Nenhum Voo Cadastrado!!!");
            Menu.menuVoo();
        } else {
            for (Voo v : listaDeVoos) {
                System.out.println(">>>VOO<<<");
                System.out.println("Código: " + v.getCodVoo());
                System.out.println("Origem: " + v.getOrigem());
                System.out.println("Destino: " + v.getDestino());
                System.out.println("Horário: " + v.getHorario());
                System.out.println("\nAvião: " + v.getAviao().getNomeAviao() + "\nCódigo do Avião: "
                        + v.getAviao().getCodigo() + "\nQuantidade de Assentos do Avião: "
                        + v.getAviao().getQtAssentos());
                System.out.println();
            }
        }
        Menu.menuVoo();
    }

    public static void atualizarVoo() throws SQLException, ParseException {

    }

    public static void deletarVoo() throws SQLException, ParseException {
        VooDAO vDao = new VooDAO();

        List<Voo> listaVoo = vDao.listaDeVoos();

        int codvoo = 0;

        boolean valida = false;

        if (listaVoo.isEmpty()) {
            System.out.println("Voo não cadastrado!");
            Menu.menuVoo();
        } else {
            do {
                try {
                    codvoo = Integer.parseInt(digita("Digite o rg do cliente a ser excluído: "));
                    for (int i = 0; i < listaVoo.size(); i++) {
                        if (codvoo != listaVoo.get(i).getCodVoo()) {
                            System.out.println("Código não cadastrado!!!");
                            Menu.menuVoo();
                        }
                    }
                    valida = true;
                } catch (NumberFormatException ex) {
                    System.out.println("Erro: " + ex);
                    valida = false;
                }

            } while (valida == false);

            Voo listaCod = vDao.listVoo(codvoo);

            vDao.deleteVoo(listaCod);
            Menu.menuVoo();

        }
    }

    private static String digita(String mens) {
        @SuppressWarnings("resource")
        Scanner e = new Scanner(System.in);
        System.out.println(mens);
        return e.nextLine();
    }

}
