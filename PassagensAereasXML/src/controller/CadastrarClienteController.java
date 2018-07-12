package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CadastrarClienteController implements Initializable {

    @FXML
    private AnchorPane painelCadastrarCliente;

    @FXML
    private void efetuarCadastroCliente(ActionEvent event) {
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
