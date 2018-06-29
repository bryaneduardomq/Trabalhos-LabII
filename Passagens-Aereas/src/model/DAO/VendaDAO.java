package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Venda;
import model.bd.Conexao;

public class VendaDAO {

    private Connection con = Conexao.getConnection();

    public void insertVenda(Venda venda) throws SQLException {

        String sql = "INSERT INTO venda (horariocompra, cliente, voo) VALUES (?,?,?)";

        PreparedStatement prepara = con.prepareStatement(sql);

        String hrcompra = venda.getHorarioCompra();
        int cliente = venda.getCliente().getRg();
        int voo = venda.getVoo().getCodigoVoo();

        prepara.setString(1, hrcompra);
        prepara.setInt(2, cliente);
        prepara.setInt(3, voo);

        prepara.execute();
        prepara.close();

    }

    public List<Venda> listaVenda() throws SQLException {

        List<Venda> listaVenda = new ArrayList<Venda>();

        String sql = "SELECT * FROM venda";

        PreparedStatement prepara = con.prepareStatement(sql);

        ResultSet rs = prepara.executeQuery();

        while (rs.next()) {

            Venda v = new Venda();

            String hrcompra = rs.getString("horariocompra");
            int cliente = rs.getInt("cliente");
            int voo = rs.getInt("voo");

            v.setHorarioCompra(hrcompra);
            //v.setCliente(cliente);
            //v.setVoo(voo);

            listaVenda.add(v);

        }

        prepara.close();

        return listaVenda;
    }

}
