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

        boolean finDelJuego = false;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la ip del servidor: ");
        String IP = sc.nextLine();
        System.out.println("Ingrese el puerto: ");
        boolean puertocorrecto = false;
        String entradaPUERTO;
        int PUERTO = 0;
        while (!puertocorrecto){
            entradaPUERTO = sc.nextLine();
            if(entradaPUERTO.chars().allMatch( Character::isDigit )){
                PUERTO = Integer.parseInt(entradaPUERTO);
                puertocorrecto = true;
            }else{
                System.out.println("ENTRADA INVÁLIDA, INTENTE NUEVAMENTE");
                puertocorrecto = false;
            }
        }
        System.out.println("Intentando conectar...");
        ClienteTCP miCliente = new ClienteTCP(IP, PUERTO);

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
