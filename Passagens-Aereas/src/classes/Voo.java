package classes;

import menus.MenuVoo;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Classe Voo
public class Voo {

    private String origem;
    private String destino;
    private String horario;
    private Aviao aviao;
    private int quantidadeAssentos; //Variável para controlar a quantidade de assentos no voo
    public static ArrayList<Voo> voos = new ArrayList<Voo>();

    //Construtor
    public Voo() {

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

    //Método de cadastro de voo
    @SuppressWarnings("static-access")
    public static void cadastrarVoo() {
        Voo v = new Voo();
        MenuVoo mv = new MenuVoo();
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

        } while (valida == false);

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

        } while (valida == false);

        v.horario = digita("Digite o horário do voo: ");

        do {
            try {
                cod = Integer.parseInt(digita("Digite o código do avião deste voo: "));
                valida = true;
            } catch (NumberFormatException ex) {
                System.out.println("Erro: " + ex);
                valida = false;
            }

        } while (valida == false);

        for (int i = 0; i < Aviao.avioes.size(); i++) {
            if (cod == Aviao.avioes.get(i).getCodigo()) {
                v.aviao = Aviao.avioes.get(i);
                v.quantidadeAssentos = Aviao.avioes.get(i).getQtAssentos();
                voos.add(v);
            } else {
                System.out.println("Avião não cadastrado");
                mv.menuVoo();
            }
        }
        mv.menuVoo();
    }

    //Método para visualizar dados do voo
    @SuppressWarnings("static-access")
    public static void visualizarVoo() {
        MenuVoo mv = new MenuVoo();

        if (voos.isEmpty()) {
            System.out.println("Nenhum Voo Cadastrado!!!");
            mv.menuVoo();
        } else {
            for (Voo v : voos) {
                System.out.println(">>>VOO<<<");
                System.out.println("Origem: " + v.getOrigem());
                System.out.println("Destino: " + v.getDestino());
                System.out.println("Horário: " + v.getHorario());
                System.out.println("\nAvião: " + v.getAviao().getNomeAviao() + "\nCódigo Avião "
                        + v.getAviao().getCodigo() + "\nQuantidade de Assentos do Avião: "
                        + v.getAviao().getQtAssentos());//Arrumar
            }
        }
        mv.menuVoo();
    }

    private static String digita(String mens) {
        @SuppressWarnings("resource")
        Scanner e = new Scanner(System.in);
        System.out.println(mens);
        return e.nextLine();
    }

}
