package base;

import javax.swing.*;
import java.util.*;

public class Produto {
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

            Txt.gravarProd("produtos", new_name, String.valueOf(new_qtd));

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

    public String mudarProd() {
        String retorno = "";
        ArrayList<String> item = new ArrayList<>();
        ArrayList<String> qtd = new ArrayList<>();
        int ct = 0;

        System.out.println(this.blau);

        for (String val: this.blau) {

            if(ct % 2 == 0){
                item.add(val);
            }else{
                qtd.add(val);
            }

            ct+=1;

        }
            for (int i = 0; i < item.size(); i++) {
                retorno = retorno.concat(String.format("\n%d Produto: %s -> %s", i, item.get(i), qtd.get(i)));

            }

            JOptionPane.showMessageDialog(null, "Produtos: "+ retorno);

            int valorAlterado = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o index da quantidade? \n" + this.blau));

            int quantidadeDesejada = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade desejada: \n" + retorno));

            this.blau.set(valorAlterado, String.valueOf(quantidadeDesejada));
            Txt.gravarAux("auxiliar", "produtos", this.blau);

//            Txt.gravarTxtAux("auxiliar","produtos", this.sas);
            JOptionPane.showMessageDialog(null, "Os produtos agora sao: "+this.blau);
            this.blau.clear();

        return retorno;
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
