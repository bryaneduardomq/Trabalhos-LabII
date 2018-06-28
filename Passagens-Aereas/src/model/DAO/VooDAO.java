package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Voo;
import model.bd.Conexao;

public class VooDAO {

    private Connection con = Conexao.getConnection();

    public void insertVoo(Voo voo) throws SQLException {

        String sql = "INSERT INTO Voo (codvoo,origem,destino,horario,qtassentosvoo,codaviao) VALUES (?,?,?,?,?,?)";

        PreparedStatement prepara = con.prepareStatement(sql);

        //int codvoo = voo.
        String or = voo.getOrigem();
        String des = voo.getDestino();
        String hor = voo.getHorario();
        int qt = voo.getQuantidadeAssentos();

        //prepara.setInt(1, codvoo);
        prepara.setString(2, or);
        prepara.setString(3, des);
        prepara.setString(4, hor);
        prepara.setInt(5, qt);

        prepara.execute();
        prepara.close();

    }

    public List<Voo> listaDeVoos() throws SQLException {
        List<Voo> listaDeVoos = new ArrayList<Voo>();

        String sql = "SELECT * FROM voo";

        PreparedStatement prepara = con.prepareStatement(sql);

        ResultSet rs = prepara.executeQuery();

        while (rs.next()) {

            Voo v = new Voo();

            listaDeVoos.add(v);
        }

        prepara.close();

        return listaDeVoos;
    }

    public void updateVoo(Voo voo) throws SQLException {

    }

    public void deleteVoo(Voo voo) throws SQLException {

    }

}
