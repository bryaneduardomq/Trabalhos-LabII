package model;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.DAO.ClienteDAO;
import java.util.List;
import view.Menu;

public class Cliente {

    private String nome;
    private int rg;
    private String contato;

    // Construtor Padrão
    public Cliente() {

    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    // Método para cadastrar o cliente
    public static void cadastrarCliente() throws SQLException, ParseException {
        Cliente c = new Cliente();
        ClienteDAO clDAO = new ClienteDAO();
        boolean valida = false;

        do {
            try {
                boolean verificacao = true;

                while (verificacao == true) {
                    verificacao = verificaRepetido(c.rg = Integer.parseInt(digita("Digite o rg do cliente: ")));
                    if (verificacao == true) {
                        System.out.println("ERRO! Rg Repetido");
                    } else {
                        valida = true;
                    }

                }

            } catch (NumberFormatException ex) {
                System.out.println("Erro: " + ex);
                valida = false;
            }

        } while (valida == false);

        valida = false;

        do {
            c.nome = digita("Digite o nome do cliente: ");
            Pattern padrao = Pattern.compile("[0-9]");
            Matcher combinacao = padrao.matcher(c.getNome());
            if (combinacao.find()) {
                System.out.println("Não pode conter números!");
            } else {
                valida = true;
            }

        } while (valida == false || c.nome.equals(""));

        do {
            c.contato = digita("Digite o contato do cliente: ");
            Pattern padrao = Pattern.compile("[a-zA-Z]");
            Matcher combinacao = padrao.matcher(c.getContato());
            if (combinacao.find()) {
                System.out.println("Não pode conter letras!");
                valida = false;
            } else {
                valida = true;
            }

        } while (valida == false || c.contato.equals(""));

        clDAO.insert(c);

        Menu.menuCliente();

    }

    // Método para visualização dos clientes cadastrados
    @SuppressWarnings("static-access")
    public static void visualizarClientes() throws SQLException, ParseException {
        ClienteDAO clDao = new ClienteDAO();
        List<Cliente> listaDeClientes = clDao.list();

        if (listaDeClientes.isEmpty()) {
            System.out.println("Nenhum Cliente Cadastrado!!!");
            Menu.menuCliente();
        } else {
            for (Cliente c : listaDeClientes) {
                System.out.println(">>>Cliente<<<");
                System.out.println("Nome: " + c.getNome());
                System.out.println("RG: " + c.getRg());
                System.out.println("Contato: " + c.getContato());
                System.out.println();
            }
            Menu.menuCliente();
        }

    }

    // Método para atualizar os dados do cliente 
    @SuppressWarnings("static-access")
    public static void atualizarDadosCliente() throws SQLException, ParseException {
        ClienteDAO clDao = new ClienteDAO();

        List<Cliente> listaDeClientes = clDao.list();

        boolean valida = false;
        int rgAtualiza = 0;
        int atualiza = 0;

        if (listaDeClientes.isEmpty()) {
            System.out.println("Cliente não cadastrado!!!");
            Menu.menuCliente();
        } else {
            do {
                try {
                    rgAtualiza = Integer.parseInt(
                            digita("Qual cliente gostaria de atualizar o cadastro? Digite o RG dele(a):"));
                    for (int i = 0; i < listaDeClientes.size(); i++) {
                        if (rgAtualiza != listaDeClientes.get(i).getRg()) {
                            System.out.println("RG não cadastrado!");
                            Menu.menuCliente();
                        }
                    }
                    valida = true;
                } catch (NumberFormatException ex) {
                    System.out.println("Erro: " + ex);
                    valida = false;
                }

            } while (valida == false);

            Cliente listRG = clDao.listRG(rgAtualiza);

            System.out.println("Cliente encontrado!");

            do {
                try {
                    atualiza = Integer.parseInt(
                            digita(("Digite o dado que deve ser alterado: 1 para nome, 2 para contato.")));
                    valida = true;
                } catch (NumberFormatException ex) {
                    System.out.println("Erro: " + ex);
                    valida = false;
                }

            } while (valida == false);

            if (atualiza == 1) {

                listRG.setNome(digita("Digite o nome: "));
                clDao.update(listRG);
            }
            if (atualiza == 2) {
                listRG.setContato(digita("Digite o contato: "));
                clDao.update(listRG);
            }

        }

        Menu.menuCliente();
    }

//Método para excluir o cliente
    @SuppressWarnings("static-access")
    public static void excluirCliente() throws SQLException, ParseException {
        ClienteDAO clDao = new ClienteDAO();

        List<Cliente> listaDeClientes = clDao.list();

        int rgExcluido = 0;

        boolean valida = false;

        if (listaDeClientes.isEmpty()) {
            System.out.println("Cliente não cadastrado!!!");
            Menu.menuCliente();
        } else {
            do {
                try {
                    rgExcluido = Integer.parseInt(digita("Digite o rg do cliente a ser excluído: "));
                    for (int i = 0; i < listaDeClientes.size(); i++) {
                        if (rgExcluido != listaDeClientes.get(i).getRg()) {
                            System.out.println("RG não cadastrado!!!");
                            Menu.menuCliente();
                        }
                    }
                    valida = true;
                } catch (NumberFormatException ex) {
                    System.out.println("Erro: " + ex);
                    valida = false;
                }

            } while (valida == false);

            Cliente listRG = clDao.listRG(rgExcluido);

            clDao.delete(listRG);
            Menu.menuCliente();
        }

    }

    private static boolean verificaRepetido(int rg) throws SQLException {
        ClienteDAO clDao = new ClienteDAO();
        List<Cliente> listaDeClientes = clDao.list();

        boolean rgDuplicado = false;

        for (int i = 0; i < listaDeClientes.size(); i++) {
            if (listaDeClientes.get(i).getRg() == rg) {
                rgDuplicado = true;
            }
        }

        return rgDuplicado;
    }

    // Método para facilitar a digitação de dados
    private static String digita(String mens) {
        @SuppressWarnings("resource")
        Scanner e = new Scanner(System.in);
        System.out.println(mens);
        return e.nextLine();
    }

}
