package Modelos.auxiliares;
import java.io.FileWriter;

public class ProcessaBusca {
    private String resposta_titulo;
    private String resposta_autor;
    private String resposta_data;

    public String getResposta_titulo() {
        return resposta_titulo;
    }

    public void setResposta_titulo(String resposta_titulo) {
        this.resposta_titulo = resposta_titulo;
    }

    public String getResposta_autor() {
        return resposta_autor;
    }

    public void setResposta_autor(String resposta_autor) {
        this.resposta_autor = resposta_autor;
    }

    public String getResposta_data() {
        return resposta_data;
    }

    public void setResposta_data(String resposta_data) {
        this.resposta_data = resposta_data;
    }

    @Override
    public String toString() {
        return "ProcessaBusca{" +
                "resposta_titulo='" + resposta_titulo + '\'' +
                ", resposta_autor='" + resposta_autor + '\'' +
                ", resposta_data='" + resposta_data + '\'' +
                '}';
    }

}
