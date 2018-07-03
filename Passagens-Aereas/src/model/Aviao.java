package model;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    public static void cadastrarAviao() throws SQLException {
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
        
        //tirar do-while
        do {
            a.nomeAviao = digita("Digite o nome do avião: ");
            Pattern padrao = Pattern.compile("[0-9]");
            Matcher combinacao = padrao.matcher(a.getNomeAviao());
            if (combinacao.find()) {
                System.out.println("Não pode conter números!");
            } else {
                valida = true;
            }
            
        } while (valida == false);
        
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
    public static void visualizarFrota() throws SQLException {
        AviaoDAO avDao = new AviaoDAO();
        
        List<Aviao> frotaDeAvioes = avDao.listAviao();
        
        if (frotaDeAvioes.isEmpty()) {
            System.out.println("Nenhum Avião Cadastrado!!!");
            Menu.menuAviao();
        } else {
            for (Aviao a : frotaDeAvioes) {
                System.out.println(">>>AVIÃO<<<");
                System.out.println("Nome: " + a.getNomeAviao());
                System.out.println("Código: " + a.getCodigo());
                System.out.println("Quantidade de Assentos: " + a.getQtAssentos());
            }
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
