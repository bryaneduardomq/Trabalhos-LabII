package controller;

import java.sql.SQLException;
import java.text.ParseException;
import model.bd.Conexao;
import view.Menu;

public class Executa {

    @SuppressWarnings("static-access")
    public static void main(String[] args) throws SQLException, ParseException {
        // Iniciar conexão com o banco
        Conexao.getConnection();
        Menu.menuPrincipal();
    }
}
