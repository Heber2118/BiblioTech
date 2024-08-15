package APIs;

import Modelos.LivroGoogle;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class GoogleLibrary {

    private static final String API_KEY = "AIzaSyA7F4nBEfPWBXb-Qj07qLp8vQX0tqbvYGk"; // Substitua pela sua chave de API

    public void buscaLivro() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o livro que deseja buscar: ");
        String livro = sc.nextLine();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.googleapis.com/books/v1/volumes?q=" + livro + "&key=" + API_KEY))
                .build();

        HttpResponse<String> resposta = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = resposta.body();
        System.out.println(json); // Exibe a resposta JSON para referência

        Gson gson = new Gson();
        GoogleBooksResponse response = gson.fromJson(json, GoogleBooksResponse.class);

        if (response.getItems() != null && response.getItems().length > 0) {
            LivroGoogle livroEncontrado = response.getItems()[0].getVolumeInfo();
            System.out.println("Nome do Livro: " + livroEncontrado.getTitle());
            System.out.println("Autor: " + livroEncontrado.getAutor());
        } else {
            System.out.println("Nenhum livro encontrado.");
        }
    }

    private static class GoogleBooksResponse {
        private LivroGoogle[] items;

        public LivroGoogle[] getItems() {
            return items;
        }

        public void setItems(LivroGoogle[] items) {
            this.items = items;
        }
    }

    private static class VolumeInfo {
        private String title;
        private String[] authors;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String[] getAuthors() {
            return authors;
        }

        public void setAuthors(String[] authors) {
            this.authors = authors;
        }
    }
}