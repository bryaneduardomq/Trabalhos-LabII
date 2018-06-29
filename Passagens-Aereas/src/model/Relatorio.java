package model;

import java.sql.SQLException;
import java.util.List;
import model.DAO.ClienteDAO;
import model.DAO.VendaDAO;
import view.Menu;

public class Relatorio {

    public static void relatorioPorCliente() {

    }

    public static void relatorioPorPassageiros() throws SQLException {
        ClienteDAO clDao = new ClienteDAO();
        VendaDAO vDao = new VendaDAO();

        List<Cliente> listCliente = clDao.list();
        List<Venda> listaVenda = vDao.listaVenda();
        if (listCliente.isEmpty() || listaVenda.isEmpty()) {
            System.out.println("Cliente/Venda não registrado(a)!");
            Menu.menuPrincipal();

        } else{
            
        }
    }

    public static void relatorioPorOrigem() {

    }

    public static void relatorioPorDestino() {

    }

    public static void relatorioPorVoos() {

    }
}
