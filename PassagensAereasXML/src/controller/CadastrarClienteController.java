package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    private ClienteDAO cDao = new ClienteDAO();
    private Cliente c = new Cliente();

    @FXML
    private void efetuarCadastroCliente(ActionEvent event) throws SQLException {
        String nome = txbNome.getText();
        Integer rg = Integer.parseInt(txbRg.getText());
        String contato = txbTelefone.getText();
        
        if(nome.equals("") || rg.equals("") || contato.equals(""))
        
        c.setNome(nome);
        c.setRg(rg);
        c.setContato(contato);
        cDao.insert(c);

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
