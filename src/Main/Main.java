package Main;

import java.io.IOException;
import java.util.Scanner;
import APIs.googlebooks.BuscadorGoogle;
import Modelos.auxiliares.Cadastro;
import Modelos.auxiliares.FazerLogin;
import Modelos.auxiliares.ProcessaBusca;
import Modelos.auxiliares.SalvaLivro;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        BuscadorGoogle buscar = new BuscadorGoogle();
        ProcessaBusca processa = new ProcessaBusca();
        SalvaLivro salvaLivro = new SalvaLivro(processa);
        Cadastro cadastro = new Cadastro();
        FazerLogin fazerLogin = new FazerLogin();
        int opcao = 1;
        while(opcao !=0) {
            System.out.println("Qual função você deseja acessar?");
            System.out.println("1 - Cadastro");
            System.out.println("2 - Fazer login");
            System.out.println("3 - Buscar livro");
            int funcao = sc.nextInt();
            sc.nextLine();

            switch (funcao){
                case 1:
                cadastro.fazerCadastro();
                break;

                case 2:
                fazerLogin.fazLogin();
                break;

                case 3:
                buscar.buscaLivro();
                break;

                case 4:
                salvaLivro.salvaDadosNoArquivo();
                System.out.println("Livro salvo com sucesso!");
                break;
            }
            System.out.println("digite 1 para voltar ao menu principal.");
            System.out.println("digite 0 para sair...");
            opcao = sc.nextInt();
        }

    }
}