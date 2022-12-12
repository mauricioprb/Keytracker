package model;

public class Registrador {
    private String data;
    private String ip;
    private String teclaPressionada;

    public Registrador(String teclaPressionada) {
        this.teclaPressionada = teclaPressionada;
    }

    public Registrador(String data, String ip, String teclaPressionada) {
        this.data = data;
        this.ip = ip;
        this.teclaPressionada = teclaPressionada;
    }
    
    public String getData() {
        return data;
    }
    
    public String getIp() {
        return ip;
    }

    public String getTeclaPressionada() {
        return teclaPressionada;
    }
}