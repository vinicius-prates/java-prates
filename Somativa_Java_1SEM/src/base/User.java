package base;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.util.ArrayList;

public class User {
    Main main = new Main();

    private String login;
    private String password;

    User(){

    }

    User(String login, String password){
        this.login = login;
        this.password = password;

    }


    public void addUser() {
        login = JOptionPane.showInputDialog("Novo login: \n");
        password = JOptionPane.showInputDialog("Senha: \n");
        Txt.gravarUser("users", login, password);
        JOptionPane.showMessageDialog(null, "Cadastro concluído", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
    }


    public void verifyUser() throws IOException {
        ArrayList<String> ler = Txt.lerTxt("users");

//        Variavel zimbas é um contador
        int zimbas = 0;
        boolean verifUser = false, verifSenha = false;

        login = JOptionPane.showInputDialog("Digite o login: \n");
        password = JOptionPane.showInputDialog("Digite a senha: \n");

        for (String value : ler) {
            if (zimbas % 2 == 0) {
                System.out.println(value);
                System.out.println(zimbas);
                if (value.equals(login)) {
                    verifUser = true;
                } else {
                    verifUser = false;

                }
            } else {
                if (value.equals(password)) {
                    verifSenha = true;
                } else {
                    verifSenha = false;
                }
            }
            if (verifUser && verifSenha) {
                break;
            }
            zimbas++;

        }
        if (!verifUser || !verifSenha) {
            JOptionPane.showMessageDialog(null, "User e/ou senha incorretos!", "Error", JOptionPane.ERROR_MESSAGE);


        } else {
            JOptionPane.showMessageDialog(null, "Login realizar com sucesso!", "Login", JOptionPane.INFORMATION_MESSAGE);

        }
    }
}
