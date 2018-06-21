package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Cliente;

public class ClienteDAO {

    private Connection con = Conexao.getConnection();

    public void insert(Cliente cliente) {

        String sql = "INSERT INTO CLIENTE (rg, nome, contato) values (?,?,?)";
        try {
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

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
