package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Aviao;
import model.Voo;
import model.bd.Conexao;

public class VooDAO {

    private final Connection con = Conexao.getConnection();

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
        List<Voo> listaDeVoos = new ArrayList<>();

        String sql = "SELECT * FROM voo";

        PreparedStatement prepara = con.prepareStatement(sql);

        ResultSet rs = prepara.executeQuery();

        while (rs.next()) {

            Voo v = new Voo();

            String sqlAv = "SELECT * FROM aviao where codaviao = " + rs.getInt("codaviao");

            PreparedStatement prepAv = con.prepareStatement(sqlAv);

            ResultSet rsAviao = prepAv.executeQuery();

            Aviao a = new Aviao();

            rsAviao.next();

            a.setCodigo(rsAviao.getInt("codaviao"));
            a.setNomeAviao(rsAviao.getString("nomeaviao"));
            a.setQtAssentos(rsAviao.getInt("qtassentos"));

            int cod = rs.getInt("idvoo");
            String or = rs.getString("origem");
            String ds = rs.getString("destino");
            String hr = rs.getString("horario");
            int qt = rs.getInt("qtassentosvoo");

            v.setCodVoo(cod);
            v.setOrigem(or);
            v.setDestino(ds);
            v.setHorario(hr);
            v.setQuantidadeAssentos(qt);
            v.setAviao(a);

            listaDeVoos.add(v);
        }

        prepara.close();

        return listaDeVoos;
    }

    public Voo listVoo(int codvoo) throws SQLException {
        Voo v = null;

        String sql = "SELECT * FROM voo WHERE idVoo= '" + codvoo + "'";

        PreparedStatement prep = con.prepareStatement(sql);

        ResultSet rs = prep.executeQuery();

        while (rs.next()) {
            v = new Voo();

            String sqlAv = "SELECT * FROM aviao where codaviao = " + rs.getInt("codaviao");

            PreparedStatement prepAv = con.prepareStatement(sqlAv);

            ResultSet rsAviao = prepAv.executeQuery();

            Aviao a = new Aviao();

            rsAviao.next();

            a.setCodigo(rsAviao.getInt("codaviao"));
            a.setNomeAviao(rsAviao.getString("nomeaviao"));
            a.setQtAssentos(rsAviao.getInt("qtassentos"));

            v.setCodVoo(rs.getInt("idVoo"));
            v.setOrigem(rs.getString("origem"));
            v.setDestino(rs.getString("destino"));
            v.setHorario(rs.getString("horario"));
            v.setQuantidadeAssentos(rs.getInt("qtAssentosVoo"));
            v.setAviao(a);

        }

        prep.close();

        return v;
    }

    public void updateVoo(Voo voo) throws SQLException {

        String sql = "UPDATE voo SET horario=?, aviao=? WHERE idvoo=  '" + voo.getCodVoo() + "'";

        PreparedStatement prep = con.prepareStatement(sql);

        String horario = voo.getHorario();
        int cod = voo.getCodVoo();

        prep.setString(1, horario);
        prep.setInt(2, cod);

        prep.execute();
        prep.close();

        System.out.println("Registro Voo -alterado- com sucesso");

    }

    public void deleteVoo(Voo voo) throws SQLException {

        String sql = "DELETE FROM voo WHERE rg = '" + voo.getCodVoo() + "'";

        PreparedStatement prepara = con.prepareStatement(sql);

        prepara.executeUpdate();

        prepara.close();

        System.out.println("Registro Voo -deletado- com sucesso");

    }

}
