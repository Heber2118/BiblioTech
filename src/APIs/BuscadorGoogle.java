package APIs;

import Modelos.LivroGoogle;
import Modelos.VolumeInfo;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class BuscadorGoogle {

    private static final String API_KEY = "AIzaSyA7F4nBEfPWBXb-Qj07qLp8vQX0tqbvYGk";

    public void buscaLivro() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o livro que deseja buscar: ");
        String livro = sc.nextLine();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.googleapis.com/books/v1/volumes?q=" + livro + "&key=" + API_KEY + "&fields=items(volumeInfo(title,authors,publishedDate))&maxResults=1"))
                .build();

        HttpResponse<String> resposta = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = resposta.body();
        System.out.println(json);

        Gson gson = new Gson();
        LivroGoogle livroGoogle = gson.fromJson(json, LivroGoogle.class);

        if(livroGoogle.getItems() != null && !livroGoogle.getItems().isEmpty()){
            Item item = livroGoogle.getItems().get(0);
            VolumeInfo volumeInfo = item.getVolumeInfo();

            System.out.println("Título: " + volumeInfo.getTitle());
            System.out.println("Autores: " + volumeInfo.getAuthors());
            System.out.println("Data de Publicação: " + volumeInfo.getPublishedDate());
        } else {
            System.out.println("Nenhum livro encontrado.");
        }

    }
}