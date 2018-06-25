package model.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import view.Menu;

public class Conexao {

    public static Connection getConnection() {
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/voos", "postgres", "1234");
            System.out.println("Conectado com Sucesso");
            Menu.menuPrincipal();
        } catch (SQLException e) {
            System.out.println("Falha na conexão!");
        }

        return con;
    }
}
