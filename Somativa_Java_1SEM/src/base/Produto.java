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

    public void listarProd() {
        ArrayList<String> it = new ArrayList<>();
        ArrayList<String> qt = new ArrayList<>();

        String show = "";

        int count = 0;

        System.out.println(this.blau);
        for (String value: this.blau) {
            if(count % 2 == 0){
                it.add(value);

            }else{
                qt.add(value);

            }
            count++;
        }
        show = "";
        for (int i = 0; i < it.size(); i++) {
            show = show.concat(String.format("\n%d Produto: %s -> %s", i+1, it.get(i), qt.get(i)));
        }
        this.blau.clear();
        JOptionPane.showMessageDialog(null, show);
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
                JOptionPane.showMessageDialog(null, this.blau);
                break;
            } else if(!yorno_usuario.equals("y")) {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }

    public void  mudarProd(String nome, String qtd) {
        Path path = Paths.get("produtos.txt");

        try{
            List<String> allItems = Files.readAllLines(path, StandardCharsets.UTF_8);
            HashMap<String, String> dictItems = new HashMap<>();
            int i = 0;
            String aux = "";

            for(String values : allItems){
                if(i % 2 == 0){
                    dictItems.put(values, "");
                    aux = values;
                    i++;
                }else{
                    dictItems.replace(aux, values);
                    i++;
                }
            }

            dictItems.replace(nome, qtd);
            Files.delete(path);
            for ( Map.Entry<String, String> entry : dictItems.entrySet() ) {
                String keys = entry.getKey();
                String values = entry.getValue();
                Txt.gravarProd(keys, values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void preencheArray(){
      this.blau =  Txt.lerProduto("produtos");
    }


    public void removerProduto() {
        produtos.add(this.blau);
        String retorno = "";
        ArrayList<String> item = new ArrayList<>();
        ArrayList<String> qtd = new ArrayList<>();


        int count = 0;

        System.out.println(this.blau);
        for (String val: this.blau) {
            if(count % 2 == 0){
                item.add(val);

            }else{
                qtd.add(val);

            }
            count++;
        }

        for (int i = 0; i < item.size(); i++) {
            retorno = retorno.concat(String.format("\n%d Produto: %s -> %s", i+1, item.get(i), qtd.get(i)));

        }

        JOptionPane.showMessageDialog(null, "Os produtos sao: "+retorno);
        int valorAlterado = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o index do produto que deseja remover:  \n" + this.blau));

        this.blau.remove(valorAlterado + 1);
        this.blau.remove(valorAlterado);

        System.out.println("SAAAAAAAAS" + this.blau);

        Txt.gravarAux("auxiliar", "produtos", this.blau);
        JOptionPane.showMessageDialog(null, "Item removido com sucesso!");

        System.out.println(this.blau);
        this.blau.clear();
    }
}
