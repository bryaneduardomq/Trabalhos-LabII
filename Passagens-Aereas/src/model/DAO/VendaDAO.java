package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Venda;
import model.Voo;
import model.bd.Conexao;

public class VendaDAO {

    private Connection con = Conexao.getConnection();

    public void insertVenda(Venda venda) throws SQLException {

        String sql = "INSERT INTO venda (idvoo, rg, horariocompra) VALUES (?,?,?)";

        PreparedStatement prepara = con.prepareStatement(sql);

        int voo = venda.getVoo().getCodVoo();
        int cliente = venda.getCliente().getRg();
        String hrcompra = venda.getHorarioCompra();

        prepara.setInt(1, voo);
        prepara.setInt(2, cliente);
        prepara.setString(3, hrcompra);

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

            String sqlC = "SELECT * FROM cliente WHERE rg = " + rs.getInt("rg");

            PreparedStatement sqlCliente = con.prepareStatement(sqlC);

            ResultSet rsCliente = sqlCliente.executeQuery();

            Cliente c = new Cliente();

            rsCliente.next();

            c.setNome("nome");

            String sqlV = "SELECT * FROM voo WHERE codvoo = " + rs.getInt("idvoo");

            PreparedStatement sqlVoo = con.prepareStatement(sqlV);

            ResultSet rsVoo = sqlVoo.executeQuery();

            Voo voo = new Voo();

            rsVoo.next();

            voo.setOrigem("origem");
            voo.setDestino("destino");
            voo.setHorario("horario");

            String hrcompra = rs.getString("horariocompra");

            v.setVoo(voo);
            v.setCliente(c);
            v.setHorarioCompra(hrcompra);

            listaVenda.add(v);

        }

        prepara.close();

        return listaVenda;
    }

}
