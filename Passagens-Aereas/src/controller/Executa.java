package controller;

import model.bd.Conexao;

public class Executa {

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        // Iniciar conexão com o banco
        Conexao.getConnection();
    }
}
