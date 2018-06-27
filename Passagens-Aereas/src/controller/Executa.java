package controller;

import java.sql.SQLException;
import model.bd.Conexao;
import view.Menu;

public class Executa {

    @SuppressWarnings("static-access")
    public static void main(String[] args) throws SQLException {
        // Iniciar conexão com o banco
        Conexao.getConnection();
        Menu.menuPrincipal();
    }
}
