package classes;

import menus.MenuCliente;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {

    private String nome;
    private int rg;
    private String contato;
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

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
    @SuppressWarnings("static-access")
    public static void cadastrarCliente() {
        Cliente c = new Cliente();
        MenuCliente m = new MenuCliente();
        boolean valida = false;

        do {
            c.nome = digita("Digite o nome do cliente: ");
            Pattern padrao = Pattern.compile("[0-9]");
            Matcher combinacao = padrao.matcher(c.getNome());
            if (combinacao.find()) {
                System.out.println("Não pode conter números!");
            } else {
                valida = true;
            }

        } while (valida == false);

        do {
            try {
                boolean verificacao = true;

                while (verificacao == true) {
                    verificacao = verificaRepetido(c.rg = Integer.parseInt(digita("Digite o rg do cliente: ")));
                    if (verificacao == true) {
                        System.out.println("ERRO NESSA CASSETA");
                    } else {
                        valida = true;
                    }

                }

            } catch (NumberFormatException ex) {
                System.out.println("Erro: " + ex);
                valida = false;
            }

        } while (valida == false);

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

        } while (valida == false);

        clientes.add(c);

        m.menuCliente();

    }

    // Método para visualização dos clientes cadastrados
    @SuppressWarnings("static-access")
    public static void visualizarClientes() {
        MenuCliente m = new MenuCliente();

        if (clientes.isEmpty()) {
            System.out.println("Nenhum Cliente Cadastrado!!!");
            m.menuCliente();
        } else {
            for (Cliente c : clientes) {
                System.out.println(">>>Cliente<<<");
                System.out.println("Nome: " + c.getNome());
                System.out.println("RG: " + c.getRg());
                System.out.println("Contato: " + c.getContato());
            }
            m.menuCliente();
        }

    }

    // Método para atualizar os dados do cliente 
    @SuppressWarnings("static-access")
    public static void atualizarDadosCliente() {
        MenuCliente m = new MenuCliente();
        boolean valida = false;
        int rgAtualiza = 0;
        int atualiza = 0;

        if (clientes.isEmpty()) {
            System.out.println("Cliente não cadastrado!!!");
            m.menuCliente();
        } else {
            do {
                try {
                    rgAtualiza = Integer.parseInt(
                            digita("Qual cliente gostaria de atualizar o cadastro? Digite o RG dele(a):"));
                    valida = true;
                } catch (NumberFormatException ex) {
                    System.out.println("Erro: " + ex);
                    valida = false;
                }

            } while (valida == false);

            for (int i = 0; i < clientes.size(); i++) {
                if (rgAtualiza == clientes.get(i).getRg()) {
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

                    System.out.println("Cliente encontrado!");

                    if (atualiza == 1) {
                        clientes.get(i).setNome(digita("Digite o nome: "));
                    }
                    if (atualiza == 2) {
                        clientes.get(i).setContato(digita("Digite o contato: "));
                    }

                } else {
                    System.out.println("RG não cadastrado!");
                    m.menuCliente();
                }
            }
            m.menuCliente();
        }

    }

    //Método para excluir o cliente
    @SuppressWarnings("static-access")
    public static void excluirCliente() {
        MenuCliente m = new MenuCliente();
        int rgExcluido = 0;
        boolean valida = false;
        if (clientes.isEmpty()) {
            System.out.println("Cliente não cadastrado!!!");
            m.menuCliente();
        } else {
            do {
                try {
                    rgExcluido = Integer.parseInt(digita("Digite o rg do cliente a ser excluído: "));
                    valida = true;
                } catch (NumberFormatException ex) {
                    System.out.println("Erro: " + ex);
                    valida = false;
                }

            } while (valida == false);

            for (int i = 0; i < clientes.size(); i++) {
                if (rgExcluido == clientes.get(i).getRg()) {
                    clientes.remove(i);
                    System.out.println("Cliente Excluído!!!");
                    m.menuCliente();
                } else {
                    System.out.println("RG não cadastrado!!!");
                    m.menuCliente();
                }

            }
            m.menuCliente();
        }

    }

    private static boolean verificaRepetido(int rg) {
        boolean rgDuplicado = false;

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getRg() == rg) {
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
