package Cliente;

import java.io.*;
import java.net.Socket;


class ClienteTCP {
    private Socket socketCliente = null;
    private BufferedReader entrada = null;
    private PrintWriter salida = null;

    public ClienteTCP(String ip, int puerto) {
        try {
            socketCliente = new Socket(ip, puerto);
            System.out.println("¡Conectado! : " + socketCliente);
            entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())), true);
        } catch (IOException e) {
            System.err.printf("No se pudo conectar con ip:%s / puerto:%d", ip, puerto);
            System.exit(-1);
        }
    }

    public void cerrarClienteTCP() {
        try {
            salida.close();
            entrada.close();
            socketCliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----// Cliente cerrado //----");
    }

    public void enviarMensaje(String linea) {
        salida.println(linea);
    }

    public String recibirMensaje() {
        String msg = "";
        try {
            msg = entrada.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }
}

public class Cliente {
    public static void main(String[] args) throws IOException {
        ClienteTCP myClient = new ClienteTCP("localhost", 55555);
    }
}
