package Modelos;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    private String nome;
    private String RA;
    private String email;
    private String senha;

    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private static final String ARQUIVO_USUARIOS = "usuarios.txt";


    public static void salvarUsuarios() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_USUARIOS))) {
            for (Usuario usuario : listaUsuarios) {
                writer.write(usuario.getRA() + "|" + usuario.getNome() + "|" + usuario.getEmail() + "|" + usuario.getSenha());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar usuários: " + e.getMessage());
        }
    }

    public static void carregarUsuarios() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_USUARIOS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split("|");
                Usuario usuario = new Usuario();
                usuario.setRA(dados[0]);
                usuario.setNome(dados[1]);
                usuario.setEmail(dados[2]);
                usuario.setSenha(dados[3]);
                listaUsuarios.add(usuario);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar usuários: " + e.getMessage());
        }
    }

    public void realizarCadastro() {
        Scanner sc = new Scanner(System.in);
        Usuario usuario = new Usuario();

        System.out.println("Digite seu RA: ");
        String ra = sc.nextLine();
        usuario.setRA(ra);

        System.out.println("Digite seu nome e sobrenome: ");
        String nome = sc.nextLine();
        usuario.setNome(nome);

        System.out.println("Digite seu email: ");
        String email = sc.nextLine();
        usuario.setEmail(email);

        System.out.println("Cadastre sua senha: ");
        String senha1 = sc.nextLine();
        System.out.println("Repita sua senha: ");
        String senha2 = sc.nextLine();

        if (senha1.equals(senha2)) {
            usuario.setSenha(senha1);
            listaUsuarios.add(usuario);
            salvarUsuarios();  // Salva os dados no arquivo
            System.out.println("Cadastro realizado com sucesso!");

        } else {
            System.out.println("As senhas não são iguais, tente novamente.");
        }
    }

    public boolean fazerLogin() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Digite seu RA: ");
            String ra = sc.nextLine();
            System.out.println("Digite sua senha: ");
            String senha = sc.nextLine();

            for (Usuario usuario : listaUsuarios) {
                if (usuario.getRA().equals(ra) && usuario.getSenha().equals(senha)) {
                    System.out.println("Login realizado com sucesso!");
                    return true;
                }
            }

            System.out.println("Senha ou RA incorretos. Tente novamente.");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRA() {
        return RA;
    }

    public void setRA(String RA) {
        this.RA = RA;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}