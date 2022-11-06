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

        do {
            if (quienComienza == 1){

                recibirAtaque(tableroCl, miCliente);

            do{
                ataqueExitoso = ataque(tableroCl, miCliente);

            }while (ataqueExitoso == false);



            } else if (quienComienza == 2) {

                do{

                    ataqueExitoso = ataque(tableroCl, miCliente);

                }while (ataqueExitoso == false);

                recibirAtaque(tableroCl, miCliente);
            }

            finDelJuego = !tableroCl.hayBarcos();
            if(finDelJuego){
                miCliente.enviarMensaje(String.valueOf(finDelJuego));
            }else{
                finDelJuego = Boolean.parseBoolean(miCliente.recibirMensaje());
            }

        }while (finDelJuego == false);

    }





}
