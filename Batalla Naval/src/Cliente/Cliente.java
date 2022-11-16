package Cliente;

import BatallaNaval.Tablero;
import Servidor.Servidor;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


import static Servidor.Servidor.ataque;
import static Servidor.Servidor.recibirAtaque;


public class Cliente {
    public static void main(String[] args) throws IOException {
        ClienteTCP miCliente = new ClienteTCP("localhost", 55555);
        boolean finDelJuego = false;
        Scanner sc = new Scanner(System.in);
        Tablero tableroCl = new Tablero(10, 5);

        tableroCl.posicionarBarcos();

        int quienComienza = Integer.parseInt(miCliente.recibirMensaje());
        boolean ataqueExitoso = false;
        System.out.println("      | COMIENZA EL JUEGO |     ");

        do {
            if (quienComienza == 1){
                boolean seguir_recibiendo;
                tableroCl.mostrarMiTablero();
                tableroCl.mostrarTableroPines();

                do{
                    seguir_recibiendo = recibirAtaque(tableroCl, miCliente);
                }while (seguir_recibiendo == true);

                tableroCl.mostrarMiTablero();
                tableroCl.mostrarTableroPines();

                finDelJuego = !tableroCl.hayBarcos();
                miCliente.enviarMensaje(String.valueOf(finDelJuego));
                if(finDelJuego == true){
                    System.out.println("Has perdido :c");
                    break;
                }



            do{
                ataqueExitoso = ataque(tableroCl, miCliente);

            }while (ataqueExitoso == false);


                finDelJuego = Boolean.parseBoolean(miCliente.recibirMensaje());
                if(finDelJuego == true){
                    System.out.println("¡Usted ha ganado!");
                    break;
                }



            } else if (quienComienza == 2) {
                tableroCl.mostrarMiTablero();
                tableroCl.mostrarTableroPines();
                do{

                    ataqueExitoso = ataque(tableroCl, miCliente);

                }while (ataqueExitoso == false);

                tableroCl.mostrarMiTablero();
                tableroCl.mostrarTableroPines();


                finDelJuego = Boolean.parseBoolean(miCliente.recibirMensaje());
                if(finDelJuego == true){
                    System.out.println("¡Usted ha ganado!");
                    break;
                }


                boolean seguir_recibiendo;
                do{
                    seguir_recibiendo = recibirAtaque(tableroCl, miCliente);
                }while (seguir_recibiendo == true);


                finDelJuego = !tableroCl.hayBarcos();
                miCliente.enviarMensaje(String.valueOf(finDelJuego));
                if(finDelJuego == true){
                    System.out.println("Has perdido :c");
                    break;
                }
            }


        }while (finDelJuego == false);

    }





}
