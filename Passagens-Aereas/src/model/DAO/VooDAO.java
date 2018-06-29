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

        String sql = "INSERT INTO Voo (origem,destino,horario,qtassentosvoo,codaviao) VALUES (?,?,?,?,?)";

        PreparedStatement prepara = con.prepareStatement(sql);

        String or = voo.getOrigem();
        String des = voo.getDestino();
        String hor = voo.getHorario();
        int qt = voo.getQuantidadeAssentos();
        int codaviao = voo.getAviao().getCodigo();

        prepara.setString(1, or);
        prepara.setString(2, des);
        prepara.setString(3, hor);
        prepara.setInt(4, qt);
        prepara.setInt(5, codaviao);

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

            String or = rs.getString("origem");
            String ds = rs.getString("destino");
            String hr = rs.getString("horario");
            int qt = rs.getInt("qtassentos");
            int codaviao = rs.getInt("codaviao");

            v.setOrigem(or);
            v.setDestino(ds);
            v.setHorario(hr);
            v.setQuantidadeAssentos(qt);
            //v.setAviao(codaviao);

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
