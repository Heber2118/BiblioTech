package Modelos.auxiliares;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cadastro {
    private String nomeAluno;
    private String raAluno;
    private String emailAluno;
    private String senhaAluno;
    private String nomeADM;
    private String idADM;
    private String senhaADM;

    public void fazerCadastro() throws IOException {
        Scanner sc = new Scanner(System.in);
        FileWriter escreveAluno = new FileWriter("alunos.txt", true);
        FileWriter escreveADM = new FileWriter("adm.txt", true);

        System.out.println("Pressione 1 se você é aluno");
        System.out.println("Pressione 2 se você é ADM");
        int resposta = sc.nextInt();
        sc.nextLine();

        switch (resposta) {
            case 1:
                int repeticao = 1;

                System.out.println("Qual o seu nome completo? ");
                nomeAluno = sc.nextLine();
                System.out.println("Digite o seu RA: ");
                raAluno = sc.nextLine();
                System.out.println("Digite o seu email: ");
                emailAluno = sc.nextLine();

                while (repeticao != 0) {
                    System.out.println("Digite sua senha: ");
                    senhaAluno = sc.nextLine();
                    System.out.println("Repita sua senha: ");
                    String testeSenha = sc.nextLine();

                    if (testeSenha.equals(senhaAluno)) {
                        System.out.println("Cadastro realizado com sucesso!");
                        String dadosAluno = nomeAluno + "," + raAluno + "," + emailAluno + ","
                                + senhaAluno;
                        escreveAluno.append(dadosAluno).append("\n");
                        escreveAluno.close();
                        repeticao = 0;
                    } else {
                        System.out.println("As senhas não correspondem.");
                        System.out.println("Digite 1 para tentar novamente");
                        System.out.println("Digite 0 para sair...");
                        sc.nextLine();
                    }
                }
            case 2:
                System.out.println("Digite o código de acesso ADM: ");
                String codigoAcesso = sc.nextLine();
                if (codigoAcesso.equals("rayannemeuamor")) {
                    System.out.println("Digite nome: ");
                    nomeADM = sc.nextLine();
                    System.out.println("Digite seu ID: ");
                    idADM = sc.nextLine();

                    int repeticao1 = 1;
                    while (repeticao1 != 0) {
                        System.out.println("Digite sua senha: ");
                        senhaADM = sc.nextLine();
                        System.out.println("Repita sua senha: ");
                        String testeSenha = sc.nextLine();

                        if (testeSenha.equals(senhaADM)) {
                            System.out.println("Cadastro realizado com sucesso!");
                            String dadosADM = nomeADM + "," + idADM + "," + senhaADM;
                            escreveADM.append(dadosADM).append("\n");
                            escreveADM.close();
                            repeticao1 = 0;
                        } else {
                            System.out.println("As senhas não correspondem.");
                            System.out.println("Digite 1 para tentar novamente");
                            System.out.println("Digite 0 para sair...");
                            sc.nextLine();
                        }
                    }


                }

        }
    }
}
