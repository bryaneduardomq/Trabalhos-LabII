package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Aviao;
import model.bd.Conexao;

public class AviaoDAO {

    private Connection con = Conexao.getConnection();

    public void insertAviao(Aviao aviao) throws SQLException {

        String sql = "INSERT INTO aviao (codaviao, nomeaviao, qtassentos) VALUES (?,?,?)";

        PreparedStatement prepara = con.prepareStatement(sql);

        int cod = aviao.getCodigo();
        String nome = aviao.getNomeAviao();
        int qtassentos = aviao.getQtAssentos();

        prepara.setInt(1, cod);
        prepara.setString(2, nome);
        prepara.setInt(3, qtassentos);

        prepara.execute();
        prepara.close();

        System.out.println("Registro -Aviao- salvo com sucesso");

    }

    public List<Aviao> listAviao() throws SQLException {

        List<Aviao> frotaDeAvioes = new ArrayList<Aviao>();

        String sql = "SELECT * FROM aviao";

        PreparedStatement prepara = con.prepareStatement(sql);

        ResultSet result = prepara.executeQuery();

        while (result.next()) {

            Aviao a = new Aviao();

            int cod = result.getInt("codaviao");
            String nome = result.getString("nomeaviao");
            int qt = result.getInt("qtassentos");

            a.setCodigo(cod);
            a.setNomeAviao(nome);
            a.setQtAssentos(qt);

            frotaDeAvioes.add(a);

        }

        prepara.close();
        return frotaDeAvioes;

    }

}
