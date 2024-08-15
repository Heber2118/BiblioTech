import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    private String nome;
    private String RA;
    private String email;
    private String senha;

    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public String getRA() {
        return RA;
    }

    public void setRA(String RA) {
        this.RA = RA;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void realizarCadastro() {
        Scanner sc = new Scanner(System.in);
        Usuario usuario = new Usuario();

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
            System.out.println("Cadastro realizado com sucesso!");

        } else {
            System.out.println("As senhas não são iguais, tente novamente.");
        }

        sc.close();
    }

    public boolean fazerLogin() {
        while (true) {

            Scanner sc = new Scanner(System.in);
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

            System.out.println("Senha ou RA incorretos.");
        }
    }
}