package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Cliente;
import model.DAO.ClienteDAO;

public class CadastrarClienteController implements Initializable {

    @FXML
    private TextField txbNome;

    @FXML
    private TextField txbRg;

    @FXML
    private TextField txbTelefone;

    @FXML
    private Button btnCadastro;

    @FXML
    private Button btnVoltar;

    @FXML
    private AnchorPane painelCadastrarCliente;

    //private Cliente c = null;
    private static boolean verificaRepetido(int rg) throws SQLException {
        ClienteDAO clDao = new ClienteDAO();

        List<Cliente> listaDeClientes = clDao.list();

        //Cliente c = clDao.listRG(rg);
        boolean rgDuplicado = false;

        for (int i = 0; i < listaDeClientes.size(); i++) {
            if (listaDeClientes.get(i).getRg() == rg) {
                rgDuplicado = true;
            }
        }
        return rgDuplicado;
    }

    @FXML
    private void efetuarCadastroCliente(ActionEvent event) throws SQLException {
        ClienteDAO cDao = new ClienteDAO();
        Cliente c = new Cliente();
        String nome = txbNome.getText();
        Integer rg = Integer.parseInt(txbRg.getText());

        String contato = txbTelefone.getText();

        Pattern padrao = Pattern.compile("[0-9]");
        Matcher combinacao = padrao.matcher(nome);

        Pattern padraoNum = Pattern.compile("[a-zA-Z]");
        Matcher combinacaoNum = padraoNum.matcher(contato);

        Pattern padraoRG = Pattern.compile("[a-zA-Z]");
        Matcher combinacaoRG = padraoRG.matcher(txbRg.getText());

        boolean verifica;

        verifica = verificaRepetido(rg);

        if (verifica == true) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("RG já cadastrado! Digite novamente");

            alert.showAndWait();

            txbNome.setText("");
            txbRg.setText("");
            txbTelefone.setText("");

        } else if (nome.isEmpty() || rg.equals("") || contato.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Algum campo ficou vazio! Digite novamente");

            alert.showAndWait();

            txbNome.setText("");
            txbRg.setText("");
            txbTelefone.setText("");

        } else if (combinacao.find() || combinacaoNum.find() || combinacaoRG.find()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Algum campo digitado incorretamente! Digite novamente");

            alert.showAndWait();

            txbNome.setText("");
            txbRg.setText("");
            txbTelefone.setText("");

        } else {

            c.setNome(nome);
            c.setRg(rg);
            c.setContato(contato);
            cDao.insert(c);

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Cadastro");
            alert.setHeaderText(null);
            alert.setContentText("Cadastro efetuado com sucesso!");
            alert.showAndWait();

            txbNome.setText("");
            txbRg.setText("");
            txbTelefone.setText("");
        }
    }

    @FXML
    private void returnCadastroCliente(ActionEvent event) throws IOException {
        Stage stage = (Stage) painelCadastrarCliente.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
