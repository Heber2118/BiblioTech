package Modelos.auxiliares;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FazerLogin{
    private String RA;
    private String ID;
    private String Senha;

    public void fazLogin() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        Scanner leitor = new Scanner(new File("alunos.txt"));
        Scanner leitorADM = new Scanner(new File("adm.txt"));

        System.out.println("1 - Fazer login como aluno");
        System.out.println("2- Fazer login como ADM");
        int resposta = sc.nextInt();
        sc.nextLine();
        switch (resposta){
            case 1:
                    System.out.println("Digite seu RA: ");
                    RA = sc.nextLine();
                    System.out.println("Digite sua senha: ");
                    Senha = sc.nextLine();

                    boolean loginEncontrado = false;

                    while (leitor.hasNextLine()) {
                        String linha = leitor.nextLine();
                        String[] dados = linha.split(",");

                        if (dados.length >= 4 && dados[1].equals(RA) && dados[3].equals(Senha)) {
                            System.out.println("Login realizado com sucesso, " + dados[0] + "!");
                            loginEncontrado = true;
                            break;
                        }
                    }

                    if (!loginEncontrado) {
                        System.out.println("RA ou senha incorretos. Tente novamente.");
                    }
            case 2:
                System.out.println("Digite seu ID: ");
                ID = sc.nextLine();
                System.out.println("Digite sua senha: ");
                Senha = sc.nextLine();

                boolean loginAdm = false;

                while (leitorADM.hasNextLine()){
                    String linha = leitorADM.nextLine();
                    String[] dados = linha.split(",");
                    if(dados.length>=4 && dados[1].equals(ID) && dados[3].equals(Senha)){
                        System.out.println("Login realizado com sucesso. Bem vindo " + dados[0] + "!");
                        loginAdm = true;
                    }
                    else {
                        System.out.println("ID ou senha incorretos.");
                    }
                }

                }


                }


    }
