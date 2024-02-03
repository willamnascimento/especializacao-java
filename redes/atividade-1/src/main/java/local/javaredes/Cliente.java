package local.javaredes;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author William Siqueira Nascimento
 */
public class Cliente {
    private static Socket conexao;
    private static DataInputStream entrada;
    private static DataOutputStream saida;
    
    public static void main(String[] args) {
        try {
            conexao = new Socket("localhost",55000);
            saida = new DataOutputStream(conexao.getOutputStream());
            
            String cpf = "";
            String resposta = "";
            
            System.out.println("Digite o CPF para ser validado");
            InputStreamReader teclado = new InputStreamReader(System.in);
            BufferedReader buffer = new BufferedReader(teclado);
            cpf = buffer.readLine();
            
            saida.writeUTF(cpf);
           
            entrada = new DataInputStream(conexao.getInputStream());
            resposta = entrada.readUTF();
            
            System.out.println("Resposta: "+resposta);
            
            conexao.close();
            
        }catch (IOException ex) {
          Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE,null, ex);

        }
    }
}
