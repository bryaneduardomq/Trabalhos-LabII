package model.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import main.Executa;

public class Conexao {

    private final static String HOST = "localhost";
    private final static String PORT = "5432";
    private final static String BD = "voos";
    private final static String URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + BD;
    private final static String USUARIO = "postgres";
    private final static String SENHA = "1234";
    //private final static String SENHA = "admin";

    public static Connection getConnection() {
        Connection conexao = null;
        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

        } catch (ClassNotFoundException ex) {
            System.err.println("Erro de Sistema - Classe do Driver Nao Encontrada!");
            //throw new BDException(ex);
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setContentText("Erro de Sistema - Problema na conexão do banco de dados");
            alert.showAndWait();
            //throw new BDException(ex);
        }
        return (conexao);
    }

}
