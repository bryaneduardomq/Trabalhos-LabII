package model;

import view.Menu;
import java.util.ArrayList;
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

//Classe de Venda
public class Venda {

    private String horarioCompra;
    private Cliente cliente;
    private Voo voo;
    public static ArrayList<Venda> vendas = new ArrayList<Venda>();

    public String getHorarioCompra() {
        return horarioCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Voo getVoo() {
        return voo;
    }

    //Método para realizar a venda da passagem
    @SuppressWarnings("static-access")
    public static void realizarVenda() throws SQLException {
        Venda venda = new Venda();
        ClienteDAO clDao = new ClienteDAO();
        AviaoDAO avDao = new AviaoDAO();

        List<Cliente> listaDeClientes = clDao.list();
        List<Aviao> frotaDeAvioes = avDao.listAviao();

        int rgCompra = 0;
        String buscarOrigem = null;
        String buscarDestino = null;
        boolean valida = false;

        if (listaDeClientes.isEmpty() || frotaDeAvioes.isEmpty() || Voo.voos.isEmpty()) {
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

            for (int i = 0; i < Voo.voos.size(); i++) {
                if (buscarOrigem.equals(Voo.voos.get(i).getOrigem())
                        && buscarDestino.equals(Voo.voos.get(i).getDestino())) {

                    System.out.println("Trecho disponível!");
                    Voo.voos.get(i).setQuantidadeAssentos(Voo.voos.get(i).getQuantidadeAssentos() - 1);//Diminui a quantidade de assentos disponíveis no voo
                    if (Voo.voos.get(i).getQuantidadeAssentos() == 0) {
                        System.out.println("Voo Lotado!");
                        Menu.menuPrincipal();
                    }

                    venda.voo = Voo.voos.get(i);

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
                            venda.cliente = listaDeClientes.get(i);
                            System.out.println("Cliente registrado!");
                        } else {
                            System.out.println("Cliente não registrado!");
                            Menu.menuPrincipal();
                        }
                    }

                    System.out.println("\nCompra Realizada com Sucesso!!!");

                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date(System.currentTimeMillis());
                    venda.horarioCompra = dateFormat.format(date);

                    vendas.add(venda);

                    //Irá mostrar a compra realizada pelo cliente
                    for (i = 0; i < Venda.vendas.size(); i++) {
                        if (rgCompra == venda.cliente.getRg()) {
                            System.out.println(">>>Extrato da venda<<<<");
                            System.out.println("Cliente: " + vendas.get(i).getCliente().getNome());
                            System.out.println("Voo" + "\nOrigem: " + vendas.get(i).getVoo().getOrigem()
                                    + "\nDestino: " + vendas.get(i).getVoo().getDestino() + "\nHorário do voo: "
                                    + vendas.get(i).getVoo().getHorario() + "\nHoráro da compra: "
                                    + vendas.get(i).getHorarioCompra());

                        }
                    }

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