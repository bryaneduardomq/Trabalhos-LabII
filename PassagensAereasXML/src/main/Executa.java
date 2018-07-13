package main;

import java.sql.Connection;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.bd.Conexao;

public class Executa extends Application {

    private Connection con = Conexao.getConnection();

    public void closeConnection() throws SQLException {
        con.close();
    }

    @Override
    public void start(Stage stage) throws Exception {

        if (con.isClosed()) {
            System.out.println("Não conectou");

        } else {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Menu.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Venda de Passagens Aéreas");
            stage.show();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
