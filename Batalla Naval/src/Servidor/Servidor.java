package Servidor;


import BatallaNaval.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class ServidorTCP {
    private Socket socketCliente;
    private ServerSocket socketServidor;
    private BufferedReader entrada;
    private PrintWriter salida;

    public ServidorTCP(int puerto) {
        this.socketCliente = null;
        this.socketServidor = null;
        this.entrada = null;
        this.salida = null;
        try {
            socketServidor = new ServerSocket(puerto);
            System.out.println("Esperando conexion...");
            socketCliente = socketServidor.accept();
            System.out.println("¡Conectado! : " + socketCliente);
            entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())), true);
        } catch (IOException e) {
            System.out.println("No puede usar el puerto: " + puerto);
            System.exit(-1);
        }
    }

    public void cerrarServidorTCP() {
        try {
            salida.close();
            entrada.close();
            socketCliente.close();
            socketServidor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----// Servidor cerrado //----");
    }

    public String recibirMensaje() {
        String linea = "";
        try {
            linea = entrada.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linea;
    }

    public void enviarMensaje(String linea) {
        salida.println(linea);
    }
}

public class Servidor {
    public static void main(String[] args) throws IOException {

        Juego();

    }

    public static void Juego() {
        ServidorTCP miServidor = new ServidorTCP(55555);
        boolean fin = false;
        Scanner sc = new Scanner(System.in);
        Tablero tableroSv = new Tablero(10, 5);

        tableroSv.mostrarMiTablero();
        tableroSv.posicionarBarcos();
        tableroSv.mostrarMiTablero();
        tableroSv.mostrarTableroPines();
        /*Tablero mTablero = new Tablero();
        System.out.println("\n---- COMIENZA EL JUEGO -----\n");
        //mTablero.placeBoats();
        mTablero.mostrarTablero();
        /*
        do {
            String message = myServer.receiveMessage();
            System.out.println("¡EL ENEMIGO HA ATACADO EN LA POSICION " + message);
            if (mBoard.atackBoard(message)) {
                System.out.println("¡HAS PERDIDO!");
                fin = true;
                myServer.sendMessage("FIN");
            }

            else {

                myServer.sendMessage("AGUA");

                do {
                    System.out.print("¡AL ATAQUE!\nEscribe la coordenada, por ejemplo -> (B4): ");
                    message = sc.nextLine();
                } while (!message.matches("^[A-J][0-9]*$"));
                System.out.println("¡HAS REALIZADO EL ATAQUE!");
                myServer.sendMessage(message);
                message = myServer.receiveMessage();
                System.out.println(message);
                if (message.contains("FIN")) {
                    System.out.println("¡HAS GANADO!");
                    fin = true;
                }
            }

        } while (!fin);
        */

    }


}


