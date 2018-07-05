package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DAO.ClienteDAO;
import model.DAO.VooDAO;
import model.bd.Conexao;
import view.Menu;

public class Relatorio {

    private Connection con = Conexao.getConnection();
    private Cliente cliente;
    private Voo voo;
    private Venda venda;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public static void relatorioPorCliente() throws SQLException {
        ClienteDAO clDao = new ClienteDAO();
        List<Cliente> listaDeClientes = clDao.list();

        if (listaDeClientes.isEmpty()) {
            System.out.println("Nenhum Cliente Cadastrado!!!");
            Menu.menuPrincipal();
        } else {
            for (Cliente c : listaDeClientes) {
                System.out.println(">>>Cliente<<<");
                System.out.println("Nome: " + c.getNome());
                System.out.println("RG: " + c.getRg());
                System.out.println("Contato: " + c.getContato());
            }
            Menu.menuPrincipal();
        }
    }

    public List<Relatorio> listaPassageiros() throws SQLException {

        List<Relatorio> listPassageiros = new ArrayList<>();

        String sql = "SELECT venda.codvenda, venda.horariocompra, voo.origem, voo.destino, voo.horario, cliente.nome\n"
                + "FROM venda INNER JOIN voo ON venda.idvoo = voo.idvoo INNER JOIN cliente ON venda.rg = cliente.rg ";

        PreparedStatement prep = con.prepareStatement(sql);

        ResultSet rs = prep.executeQuery();

        while (rs.next()) {

            Relatorio r = new Relatorio();

            Venda v = new Venda();

            Voo vooVenda = new Voo();

            Cliente clienteVenda = new Cliente();

            v.setCodigoVenda(rs.getInt("codvenda"));
            v.setHorarioCompra(rs.getString("horariocompra"));

            vooVenda.setOrigem(rs.getString("origem"));
            vooVenda.setDestino(rs.getString("destino"));
            vooVenda.setHorario(rs.getString("horario"));

            clienteVenda.setNome(rs.getString("nome"));

            r.setVenda(v);
            r.setVoo(vooVenda);
            r.setCliente(clienteVenda);

            listPassageiros.add(r);
        }

        prep.close();
        return listPassageiros;
    }

    public static void relatorioPorPassageiros() throws SQLException {
        Relatorio r = new Relatorio();

        List<Relatorio> passageiros = r.listaPassageiros();

        if (passageiros.isEmpty()) {
            System.out.println("Cliente/Venda não registrado(a)!");
            Menu.menuPrincipal();

        } else {
            for (Relatorio passageiro : passageiros) {
                System.out.println(">>>>>Relatório de Passageiros<<<<<");
                System.out.println("Código da Venda: " + passageiro.getVenda().getCodigoVenda());
                System.out.println("Horário Venda: " + passageiro.getVenda().getHorarioCompra());
                System.out.println("Origem do Voo: " + passageiro.getVoo().getOrigem());
                System.out.println("Destino do Voo: " + passageiro.getVoo().getDestino());
                System.out.println("Horário do Voo: " + passageiro.getVoo().getHorario());
                System.out.println("Cliente: " + passageiro.getCliente().getNome());
                System.out.println();
            }

        }
        Menu.menuPrincipal();
    }

    public List<Relatorio> listaOrigem() throws SQLException {

        List<Relatorio> listaOrigem = new ArrayList<>();

        String sql = "SELECT venda.codvenda, voo.origem, cliente.nome \n"
                + "FROM venda INNER JOIN voo ON venda.idvoo = voo.idvoo\n"
                + "INNER JOIN cliente ON venda.rg = cliente.rg ";

        PreparedStatement prep = con.prepareStatement(sql);

        ResultSet rs = prep.executeQuery();

        while (rs.next()) {

            Relatorio r = new Relatorio();

            Venda ven = new Venda();

            Voo v = new Voo();

            Cliente c = new Cliente();

            ven.setCodigoVenda(rs.getInt("codvenda"));
            v.setOrigem(rs.getString("origem"));
            c.setNome(rs.getString("nome"));

            r.setVenda(ven);
            r.setVoo(v);
            r.setCliente(c);

            listaOrigem.add(r);
        }

        prep.close();
        return listaOrigem;
    }

    public static void relatorioPorOrigem() throws SQLException {
        Relatorio r = new Relatorio();
        List<Relatorio> origem = r.listaOrigem();

        if (origem.isEmpty()) {
            System.out.println("Não disponível");
            Menu.menuPrincipal();
        } else {
            for (Relatorio o : origem) {
                System.out.println(">>>>>Relatório por Origens<<<<<");
                System.out.println("Código da venda: " + o.getVenda().getCodigoVenda());
                System.out.println("Origem do Voo: " + o.getVoo().getOrigem());
                System.out.println("Cliente: " + o.getCliente().getNome());

            }
        }
        Menu.menuPrincipal();
    }

    public List<Relatorio> listaDestino() throws SQLException {
        List<Relatorio> listaDestino = new ArrayList<>();

        String sql = "SELECT venda.codvenda, voo.destino, cliente.nome \n"
                + "FROM venda INNER JOIN voo ON venda.idvoo = voo.idvoo\n"
                + "INNER JOIN cliente ON venda.rg = cliente.rg ";

        PreparedStatement prep = con.prepareStatement(sql);

        ResultSet rs = prep.executeQuery();

        while (rs.next()) {
            Relatorio r = new Relatorio();

            Venda ven = new Venda();

            Voo v = new Voo();

            Cliente c = new Cliente();

            ven.setCodigoVenda(rs.getInt("codvenda"));
            v.setDestino(rs.getString("destino"));
            c.setNome(rs.getString("nome"));

            r.setVenda(ven);
            r.setVoo(v);
            r.setCliente(c);

            listaDestino.add(r);
        }

        prep.close();
        return listaDestino;
    }

    public static void relatorioPorDestino() throws SQLException {
        Relatorio r = new Relatorio();
        List<Relatorio> destino = r.listaDestino();

        if (destino.isEmpty()) {
            System.out.println("Não disponível");
            Menu.menuPrincipal();
        } else {
            for (Relatorio d : destino) {
                System.out.println(">>>>>Relatório por Origens<<<<<");
                System.out.println("Código da venda: " + d.getVenda().getCodigoVenda());
                System.out.println("Destino do Voo: " + d.getVoo().getDestino());
                System.out.println("Cliente: " + d.getCliente().getNome());

            }
        }
        Menu.menuPrincipal();
    }

    public static void relatorioPorVoos() throws SQLException {
        VooDAO vDao = new VooDAO();

        List<Voo> listaDeVoos = vDao.listaDeVoos();

        if (listaDeVoos.isEmpty()) {
            System.out.println("Nenhum Voo Cadastrado!!!");
            Menu.menuPrincipal();
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
        Menu.menuPrincipal();
    }

}
