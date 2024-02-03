package local.javaredes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author William Siqueira Nascimento
 */
public class Servidor {
    private static ServerSocket servidor;
    private static Socket conexao;
    private static DataInputStream entrada;
    private static DataOutputStream saida;
    
    public static void main(String[] args) {
        try{
            System.out.println("Aguardando conexão.....");
            servidor = new ServerSocket(55000);
            conexao = servidor.accept();
            
            String valorEntrada = "";
            String resultado = "";
            boolean result = false;
            entrada = new DataInputStream(conexao.getInputStream());
            valorEntrada = entrada.readUTF();
            
            result = validarCPF(valorEntrada);
            
            if (result)
                resultado = "Este CPF é válido";
            else
                resultado = "Este CPF é inválido";
            
            
            saida = new DataOutputStream(conexao.getOutputStream());
            saida.writeUTF(resultado);
            
            conexao.close();
            
        }catch(IOException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    private static boolean validarCPF(String entrada){
        entrada = entrada.replaceAll("[^0-9]", "");

        if (entrada.length() != 11) {
            return false;
        }

        if (entrada.matches("(\\d)\\1*")) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(entrada.charAt(i)) * (10 - i);
        }
        int remainder = sum % 11;
        int digit1 = (remainder < 2) ? 0 : (11 - remainder);

        if (digit1 != Character.getNumericValue(entrada.charAt(9))) {
            return false;
        }

        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(entrada.charAt(i)) * (11 - i);
        }
        remainder = sum % 11;
        int digit2 = (remainder < 2) ? 0 : (11 - remainder);

        return digit2 == Character.getNumericValue(entrada.charAt(10));
    }   
}
