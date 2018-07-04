package model;

import view.Menu;
import java.util.Scanner;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    public static void realizarVenda() throws SQLException {
        Venda venda = new Venda();
        ClienteDAO clDao = new ClienteDAO();
        AviaoDAO avDao = new AviaoDAO();
        VooDAO vDao = new VooDAO();
        VendaDAO vdDao = new VendaDAO();

        List<Cliente> listaDeClientes = clDao.list();
        List<Aviao> frotaDeAvioes = avDao.listAviao();
        List<Voo> listaDeVoos = vDao.listaDeVoos();

        int rgCompra = 0;
        String buscarOrigem = null;
        String buscarDestino = null;
        boolean valida = false;

        if (listaDeClientes.isEmpty() || frotaDeAvioes.isEmpty() || listaDeVoos.isEmpty()) {
            System.out.println("Venda não pode ser realizada!");
            Menu.menuPrincipal();
        } else {
            System.out.println(">>>Venda de Passagens Aéreas<<<");

            do {
                buscarOrigem = digita("Digite a origem do seu voo: ");
                Pattern padrao = Pattern.compile("[0-9]");
                Matcher combinacao = padrao.matcher(buscarOrigem);
                if (combinacao.find()) {
                    System.out.println("Não pode conter números!");
                    valida = false;
                } else {
                    valida = true;
                }

            } while (valida == false);

            do {
                buscarDestino = digita("Digite o destino do seu voo: ");
                Pattern padrao = Pattern.compile("[0-9]");
                Matcher combinacao = padrao.matcher(buscarDestino);
                if (combinacao.find()) {
                    System.out.println("Não pode conter números!");
                    valida = false;
                } else {
                    valida = true;
                }

            } while (valida == false);

            for (int i = 0; i < listaDeVoos.size(); i++) {
                if (buscarOrigem.equals(listaDeVoos.get(i).getOrigem())
                        && buscarDestino.equals(listaDeVoos.get(i).getDestino())) {

                    System.out.println("Trecho disponível!");
                    listaDeVoos.get(i).setQuantidadeAssentos(listaDeVoos.get(i).getQuantidadeAssentos() - 1);//Diminui a quantidade de assentos disponíveis no voo
                    if (listaDeVoos.get(i).getQuantidadeAssentos() == 0) {
                        System.out.println("Voo Lotado!");
                        Menu.menuPrincipal();
                    }

                    venda.setVoo(listaDeVoos.get(i));

                    do {
                        try {
                            rgCompra = Integer.parseInt(digita("RG do Cliente que realizou a compra: "));
                            valida = true;
                        } catch (NumberFormatException ex) {
                            System.out.println("Erro: " + ex);
                            valida = false;
                        }

                    } while (valida == false);

                    for (i = 0; i < listaDeClientes.size(); i++) {
                        if (rgCompra == listaDeClientes.get(i).getRg()) {
                            venda.setCliente(listaDeClientes.get(i));
                            System.out.println("Cliente encontrado!");
                        } else {
                            System.out.println("Cliente não registrado!");
                            Menu.menuPrincipal();
                        }
                    }

                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date(System.currentTimeMillis());
                    venda.setHorarioCompra(dateFormat.format(date));

                    vdDao.insertVenda(venda);

                    System.out.println("\nCompra Realizada com Sucesso!!!");

                    //Irá mostrar a compra realizada pelo cliente
                } else {
                    System.out.println("Trecho não disponível!");
                    Menu.menuPrincipal();
                }
            }
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
