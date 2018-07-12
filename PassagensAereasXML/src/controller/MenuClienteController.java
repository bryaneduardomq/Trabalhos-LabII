package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuClienteController implements Initializable {

    @FXML
    private AnchorPane painelMenuCliente;

    @FXML
    private void addClient(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/CadastroCliente.fxml"));
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(painelMenuCliente.getScene().getWindow());
        stage.setResizable(false);
        stage.showAndWait();

    }

    @FXML
    private void changeClient(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/changeClient.fxml"));
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(painelMenuCliente.getScene().getWindow());
        stage.setResizable(false);
        stage.showAndWait();
    }

    @FXML
    private void removeClient(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/removeClient.fxml"));
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(painelMenuCliente.getScene().getWindow());
        stage.setResizable(false);
        stage.showAndWait();
    }

    @FXML
    private void returnClient(ActionEvent event) throws IOException {
        //System.out.println("Voltar");
        Stage stage = (Stage) painelMenuCliente.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
