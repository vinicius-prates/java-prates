package base;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Scanner;

public class Txt {
    private String name, login, password;
    private List<String> list;
    private static Scanner scanner;

    private static ArrayList<String> prod = new ArrayList<>();

    public static void gravarLog(String nome, List<String> lista) {
        
        Path caminho = Paths.get(nome + ".txt");
        
        try {
            if (Files.exists(Paths.get("Log.txt")) && caminho.equals("Log.txt")) {
                Files.write(caminho, lista, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            } else {
                Files.write(caminho, lista, StandardCharsets.UTF_8);
            }
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    Código usado da aula de TXT
    public static ArrayList<String> lerTxt(String nomeArquivo) throws IOException {
        
        Path caminho = Paths.get(nomeArquivo + ".txt");
        ArrayList<String> dados = new ArrayList<>((Files.readAllLines(caminho)));
        System.out.println(dados);

        return dados;
    }

    public static void gravarUser(String name, String logib, String password) {
        
        ArrayList<String> usuarios = new ArrayList<>();
        Path caminho = Paths.get(name + ".txt");
        
        usuarios.add(logib);
        usuarios.add(password);

        try {
            if (Files.exists(caminho)) {
                Files.write(caminho, usuarios, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            } else {
                Files.write(caminho, usuarios, StandardCharsets.UTF_8);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void gravarProd( String name, String qtd) {
        
        ArrayList<String> produtos = new ArrayList<>();
        Path caminho = Paths.get("produtos.txt");
        
        produtos.add(name); produtos.add(qtd);

        try {
            if (Files.exists(caminho)) {
                Files.write(caminho, produtos, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            } else {
                Files.write(caminho, produtos, StandardCharsets.UTF_8);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static ArrayList<String> lerProduto(String nome) {
        Path path = Paths.get("produtos.txt");
        try {
            List<String> contents = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (String content : contents) {
                prod.add(content);
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prod;
    }
}