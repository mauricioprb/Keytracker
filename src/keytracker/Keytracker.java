/** Keytracker: Aplicação Desktop para Registro de Teclas Digitadas pelo Usuário
 *
 * @author Mauricio
 * @version 1.0
 */
package keytracker;

import com.dustinredmond.fxtrayicon.FXTrayIcon;
import com.github.kwhat.jnativehook.NativeHookException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Keytracker extends Application {
    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Tela.fxml"));

        /**
         * @param Evento de pressionar o mouse
         */
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        /**
         * @param Evento segurar o mouse
         */
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });

        Scene scene = new Scene(root);
        
        FXTrayIcon icon = new FXTrayIcon(stage, getClass().getResource("/img/icons/icon.png"));
        icon.show();

        scene.setFill(javafx.scene.paint.Color.TRANSPARENT);

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.getIcons().add(new Image("/img/icons/icon.png"));
        stage.setScene(scene);
        stage.setTitle("Keytracker: Registrador de Teclas");
        stage.show();

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((screenBounds.getHeight() - stage.getHeight()) / 2);
    }

    public static void main(String[] args) throws NativeHookException {
        launch(args);
    }
}