package base;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Menu {

    Menu(){

    }
    public static void menuzin() throws IOException {
        User user = new User();
        Produto produto = new Produto();
        ArrayList<String> log = new ArrayList<>();

        log.add("Iniciou o programa as: " + LocalDateTime.now() + "\n");

        while(true) {
            int op_user = Integer.parseInt(JOptionPane.showInputDialog("            "+Yorno.Yes.getValue() + " -  novo cadastro  " +
                    "\n             " + Yorno.No.getValue() + " -  logar \n"));
            if (op_user == Yorno.Yes.getValue()) {
                user.addUser();
                log.add("Criado um novo user as: " + LocalDateTime.now() + "\n");
            } else if (op_user == Yorno.No.getValue()) {
                user.verifyUser();

                log.add("User logou as: " + LocalDateTime.now() + "\n");
            }

            int op = Integer.parseInt(JOptionPane.showInputDialog(null, "           Oque deseja fazer?\n" +
                    "           [1] - Adicionar Produto\n" +
                    "           [2] - Alterar Quantidade\n" +
                    "           [3] - Remover Produto\n" +
                    "           [4] - Listar Produto\n" +
                    "           [5] - Sair"));

            switch (op) {
                case 1 -> {
                    produto.addProd();
                    log.add("Adicionado um produto as: " + LocalDateTime.now() + "\n");

                }
                case 2 -> {
                    produto.preencheArray();
                    String name_item = JOptionPane.showInputDialog(null,"Digite o nome do que deseja alterar:");
                    String qtd_item = JOptionPane.showInputDialog(null, "Digite a quantidade que deseja colocar desse produto:");
                    produto.mudarProd(name_item, qtd_item);
                    log.add("Produto alterado as: " + LocalDateTime.now() + "\n");
                }
                case 3 -> {
                    produto.preencheArray();
                    produto.removerProduto();
                    log.add("Produto removido as: " + LocalDateTime.now() + "\n");
                }
                case 4 -> {
                    produto.preencheArray();
                    produto.listarProd();
                    log.add("Produtos listados as: " + LocalDateTime.now() + "\n");

                }

                case 5 -> {
                    ImageIcon bye = new ImageIcon("bye.jpg");
                    JOptionPane.showMessageDialog(null,"","Bye Bye",JOptionPane.INFORMATION_MESSAGE,bye);
                    System.exit(0);
                }

            }
            log.add("Iniciou o programa as: " + LocalDateTime.now() + "\n");
        }
    }

}
