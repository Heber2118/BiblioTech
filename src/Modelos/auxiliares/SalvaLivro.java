package Modelos.auxiliares;

import java.io.FileWriter;
import java.io.IOException;

public class SalvaLivro {
    private ProcessaBusca dadoslivro;

    // Construtor para receber um objeto ProcessaBusca
    public SalvaLivro(ProcessaBusca dadoslivro) {
        this.dadoslivro = dadoslivro;
    }

    // Método para imprimir os dados
    public void imprimedados() {
        System.out.println(dadoslivro);
    }

    // Método para salvar os dados no arquivo
    public void salvaDadosNoArquivo() {
        try (FileWriter writer = new FileWriter("estoque.txt")) {
            writer.write(dadoslivro.toString());
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}