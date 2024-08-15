package Main;

import java.io.IOException;
import java.util.Scanner;
import APIs.googlebooks.BuscadorGoogle;
import Modelos.Usuario;

import static Modelos.Usuario.carregarUsuarios;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        carregarUsuarios();
        Scanner sc = new Scanner(System.in);
        Usuario usuarioCobaia = new Usuario();
        Usuario loginUsuario = new Usuario();
        BuscadorGoogle buscar = new BuscadorGoogle();

        System.out.println("Qual função você deseja acessar?");
        System.out.println("1 - Fazer Login");
        System.out.println("2 - Realizar Cadastro");
        System.out.println("3 - Buscar livro");
        int funcao = sc.nextInt();
        sc.nextLine();

        if (funcao == 1) {
            loginUsuario.fazerLogin();
        } else if (funcao == 2) {
            usuarioCobaia.realizarCadastro();
        } else if (funcao == 3) {
            buscar.buscaLivro();
        }
    }
}