package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.bd.Conexao;

public class ClienteDAO {

    private Connection con = Conexao.getConnection();

    public void insert(Cliente cliente) throws SQLException {

        String sql = "INSERT INTO CLIENTE (rg, nome, contato) values (?,?,?)";

        PreparedStatement prepara = con.prepareStatement(sql);

        int rg = cliente.getRg();
        String nome = cliente.getNome();
        String contato = cliente.getContato();

        prepara.setInt(1, rg);
        prepara.setString(2, nome);
        prepara.setString(3, contato);

        prepara.execute();
        prepara.close();

        System.out.println("Registro Cliente -salvo- com sucesso");

    }

    public List<Cliente> list() throws SQLException { //procurar todos nao tem parametro

        List<Cliente> listaDeClientes = new ArrayList<Cliente>();

        String sql = "SELECT * FROM cliente";

        PreparedStatement prepara = con.prepareStatement(sql);

        ResultSet resultado = prepara.executeQuery(); //retorna resultado da consulta da query -> tipo ResultSet

        while (resultado.next()) { //buscando valor das colunas, registro por registro

            Cliente c = new Cliente();

            int rg = resultado.getInt("rg");
            String nome = resultado.getString("nome");
            String contato = resultado.getString("contato");

            c.setRg(rg);
            c.setNome(nome);
            c.setContato(contato);

            listaDeClientes.add(c);
        }
        prepara.close();

        return listaDeClientes;
    }

    public void update(Cliente cliente) throws SQLException {

        String sql = "UPDATE cliente SET nome=?, contato=? WHERE rg = '" + cliente.getRg() + "'";

        PreparedStatement prepara = con.prepareStatement(sql);

        String nome = cliente.getNome();
        String contato = cliente.getContato();

        prepara.setString(1, nome);
        prepara.setString(2, contato);

        prepara.execute();
        prepara.close();

        System.out.println("Registro Cliente -alterado- com sucesso");

    }

    public void delete(Cliente cliente) throws SQLException {

        String sql = "DELETE FROM cliente WHERE rg = '" + cliente.getRg() + "'";

        PreparedStatement prepara = con.prepareStatement(sql);

        prepara.executeUpdate();

        prepara.close();

        System.out.println("Registro Cliente -deletado- com sucesso");

    }

}
