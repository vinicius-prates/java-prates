package base;

import javax.swing.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Produto {
    Txt txt = new Txt();
    private String name;
    private int qtd;
    private ArrayList<String> blau = new ArrayList<>();
    ArrayList<ArrayList<String>> produtos = new ArrayList<>();
    boolean hasNext = true;

    Produto() {

    }
    Produto(String name, int qtd) {
        this.name = name;
        this.qtd = qtd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;

    }
    public static ArrayList<String> lerTxt(String nomeArquivo) throws IOException {
        Path caminho = Paths.get(nomeArquivo + ".txt");
        ArrayList<String> txt_data = new ArrayList<>((Files.readAllLines(caminho)));
        return txt_data;
    }



    public void addProd() {

        while(hasNext) {

            ArrayList<String> prodsCru = new ArrayList<>();

            String new_name = JOptionPane.showInputDialog(null,"Nome do produto: ");
            int new_qtd = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade: "));

            prodsCru.add(new_name);
            prodsCru.add(String.valueOf(new_qtd));
            produtos.add(prodsCru);

            Txt.gravarProd(new_name, String.valueOf(new_qtd));

            String yorno_usuario = JOptionPane.showInputDialog(null,"Deseja adicionar mais algum produto? (y/n)");
            yorno_usuario = yorno_usuario.toLowerCase(Locale.ROOT);
            if (yorno_usuario.equals("n")){
                break;
            } else if(!yorno_usuario.equals("y")) {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }

    public void  mudarProd(String nome, String qtd) {
        Path path = Paths.get("produtos.txt");

        try{
            List<String> produtos = Files.readAllLines(path, StandardCharsets.UTF_8);
            HashMap<String, String> dicio_produtos = new HashMap<>();
            int i = 0;
            String variavel_auxiliar = "";


            for(String valores : produtos){

                if(i % 2 == 0){

                    dicio_produtos.put(valores, "");
                    variavel_auxiliar = valores;
                    i++;

                }else{
                    dicio_produtos.replace(variavel_auxiliar, valores);
                    i++;
                }
            }

            dicio_produtos.replace(nome, qtd);
            Files.delete(path);
            for ( Map.Entry<String, String> entry : dicio_produtos.entrySet() ) {

                String chave = entry.getKey();
                String valores = entry.getValue();
                Txt.gravarProd(chave, valores);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void preencheArray(){
      this.blau =  Txt.lerProduto("produtos");
    }


    public void removerProduto(String key) {
        Path caminho = Paths.get("produtos.txt");

        try{
            List<String> produtos = Files.readAllLines(caminho, StandardCharsets.UTF_8);
            HashMap<String, String> dictItems = new HashMap<>();
            int i = 0;
            String variavel_auxiliar = "";

            for(String todos_valores : produtos){
                if(i % 2 == 0){
                    dictItems.put(todos_valores, "");
                    variavel_auxiliar = todos_valores;
                    i++;
                }else{
                    dictItems.replace(variavel_auxiliar, todos_valores);
                    i++;
                }
            }
            dictItems.remove(key);
            Files.delete(caminho);
            for ( Map.Entry<String, String> entry : dictItems.entrySet() ) {
                String keys = entry.getKey();
                String values = entry.getValue();
                Txt.gravarProd(keys, values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, String> getTxt() throws IOException {

        Path caminho = Paths.get("produtos.txt");
        List<String> produtos = Files.readAllLines(caminho, StandardCharsets.UTF_8);
        HashMap<String, String> dicio_produtos = new HashMap<>();
        int i = 0;
        String variavel_auxiliar = "";

        for(String values : produtos){
            if(i % 2 == 0){
                dicio_produtos.put(values, "");
                variavel_auxiliar = values;
                i++;
            }else{
                dicio_produtos.replace(variavel_auxiliar, values);
                i++;
            }
        }
        return dicio_produtos;
    }

    public static String printaBonito(HashMap<String, String> valor){
        String frase_fim = "";
        int i = 0;
        for ( Map.Entry<String, String> y : valor.entrySet() ) {
            if(i > 2){
                frase_fim = frase_fim.concat("");
                i = 0;
            }

            String keys = y.getKey();
            String valores = y.getValue();

            frase_fim = frase_fim.concat(keys + " -> " + valores + "\n");
            i++;
        }
        return frase_fim;
    }
    }

