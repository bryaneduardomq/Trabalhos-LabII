package model.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection getConnection() {
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/voos", "postgres", "admin");
            //System.out.println("Conectado com Sucesso");
        } catch (SQLException e) {
            System.out.println("Falha na conexão" + e);
        }

        return con;
    }

}
