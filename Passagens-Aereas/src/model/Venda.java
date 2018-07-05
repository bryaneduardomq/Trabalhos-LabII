package model;

import view.Menu;
import java.util.Scanner;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import model.DAO.AviaoDAO;
import model.DAO.ClienteDAO;
import model.DAO.VendaDAO;
import model.DAO.VooDAO;

//Classe de Venda
public class Venda {

    private Integer codigoVenda;
    private String horarioCompra;
    private Cliente cliente;
    private Voo voo;

    public Integer getCodigoVenda() {
        return codigoVenda;
    }

    public String getHorarioCompra() {
        return horarioCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setCodigoVenda(Integer codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public void setHorarioCompra(String horarioCompra) {
        this.horarioCompra = horarioCompra;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    //Método para realizar a venda da passagem
    @SuppressWarnings("static-access")
    public static void realizarVenda() throws SQLException, ParseException {
        Venda venda = new Venda();
        ClienteDAO clDao = new ClienteDAO();
        AviaoDAO avDao = new AviaoDAO();
        VooDAO vDao = new VooDAO();
        VendaDAO vdDao = new VendaDAO();

        List<Cliente> listaDeClientes = clDao.list();
        List<Aviao> frotaDeAvioes = avDao.listAviao();
        List<Voo> listaDeVoos = vDao.listaDeVoos();

        int idVoo = 0;
        int rgCompra = 0;
        boolean valida = false;

        if (listaDeClientes.isEmpty() || frotaDeAvioes.isEmpty() || listaDeVoos.isEmpty()) {
            System.out.println("Venda não pode ser realizada!");
            Menu.menuPrincipal();
        } else {
            System.out.println(">>>Venda de Passagens Aéreas<<<");

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

            do {
                try {
                    idVoo = Integer.parseInt(digita("Digite o código do voo que deseja comprar uma passagem: "));
                    for (int i = 0; i < listaDeVoos.size(); i++) {
                        if (idVoo != listaDeVoos.get(i).getCodVoo()) {
                            System.out.println("Trecho não disponível!");
                            Menu.menuPrincipal();
                        }
                    }

                    valida = true;
                } catch (NumberFormatException ex) {
                    System.out.println("Erro: " + ex);
                    valida = false;
                }

            } while (valida == false);

            Voo v = vDao.listVoo(idVoo);

            System.out.println("Trecho disponível!");
            v.setQuantidadeAssentos(v.getQuantidadeAssentos() - 1);
            if (v.getQuantidadeAssentos() == 0) {
                System.out.println("Voo Lotado!");
                Menu.menuPrincipal();
            }

            venda.setVoo(v);

            do {
                try {
                    rgCompra = Integer.parseInt(digita("RG do Cliente que realizou a compra: "));
                    valida = true;
                } catch (NumberFormatException ex) {
                    System.out.println("Erro: " + ex);
                    valida = false;
                }

            } while (valida == false);

            Cliente listaRG = clDao.listRG(rgCompra);

            venda.setCliente(listaRG);

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            venda.setHorarioCompra(dateFormat.format(date));

            vdDao.insertVenda(venda);

            System.out.println("\nCompra Realizada com Sucesso!!!");
        }
        Menu.menuPrincipal();

    }

    private static String digita(String mens) {
        @SuppressWarnings("resource")
        Scanner e = new Scanner(System.in);
        System.out.println(mens);
        return e.nextLine();
    }

}
