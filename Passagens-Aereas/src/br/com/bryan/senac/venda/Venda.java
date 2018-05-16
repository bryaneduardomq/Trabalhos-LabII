package br.com.bryan.senac.venda;

import br.com.bryan.senac.classes.Aviao;
import br.com.bryan.senac.classes.Cliente;
import br.com.bryan.senac.classes.Voo;
import br.com.bryan.senac.menus.MenuPrincipal;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Venda {

    private static String horarioCompra;
    private static Cliente cliente;
    private static ArrayList<Venda> vendas = new ArrayList<Venda>();

    @SuppressWarnings("static-access")
    public static void realizarVenda() {
        Venda v = new Venda();
        MenuPrincipal mp = new MenuPrincipal();
        if (Cliente.clientes.isEmpty() && Aviao.avioes.isEmpty() && Voo.voos.isEmpty()) {
            mp.menuPrincipal();
        } else {
            System.out.println("Venda de Passagens Aéreas!");
            String buscarOrigem = digita("Digite a origem do seu voo: ");
            String buscarDestino = digita("Digite o destino do seu voo: ");
            for (int i = 0; i < Voo.voos.size(); i++) {
                if (buscarOrigem.equals(Voo.voos.get(i).getOrigem()) && buscarDestino.equals(Voo.voos.get(i).getDestino())) {
                    System.out.println("Trecho disponível!");
                    Voo.voos.get(i).setQuantidadeAssentos(Voo.voos.get(i).getQuantidadeAssentos(i) - 1);
                    int rgCompra = Integer.parseInt(digita("RG do Cliente que realizou a compra: "));
                    for (i = 0; i < Cliente.clientes.size(); i++) {
                        if (rgCompra == Cliente.clientes.get(i).getRg()) {
                            v.cliente = Cliente.clientes.get(i);
                            System.out.println("Cliente registrado!");
                        }
                    }
                    System.out.println("Compra Realizada!!!");

                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date(System.currentTimeMillis());

                    v.horarioCompra = dateFormat.format(date);

                    vendas.add(v);
                    //java.time.Instant.now();
                } else {
                    System.out.println("Trecho não disponível!");
                    mp.menuPrincipal();
                }
            }
        }

    }

    private static String digita(String mens) {
        @SuppressWarnings("resource")
        Scanner e = new Scanner(System.in);
        System.out.println(mens);
        return e.next();
    }
}
