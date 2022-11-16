package Servidor;


import BatallaNaval.*;
import Cliente.ClienteTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) throws IOException {

        Juego();

    }

    public static void Juego() {
        ServidorTCP miServidor = new ServidorTCP(55555);
        boolean finDelJuego = false;
        Scanner sc = new Scanner(System.in);
        Tablero tableroSv = new Tablero(10, 5);


        tableroSv.posicionarBarcos();

        System.out.println(ConsoleColors.GREEN + "      | COMIENZA EL JUEGO |     "+ ConsoleColors.RESET);
        //tableroSv.mostrarMiTablero();
        //tableroSv.mostrarTableroPines();
        int quienComienza = (int) Math.floor(Math.random()*2+1);

        quienComienza = 2;

        miServidor.enviarMensaje(String.valueOf(quienComienza));

        boolean ataqueExitoso;
        do{
            if (quienComienza == 1){ //comienza el server
                tableroSv.mostrarMiTablero();
                tableroSv.mostrarTableroPines();
            do{

                ataqueExitoso = ataque(tableroSv, miServidor);

            }while (ataqueExitoso == false);

                tableroSv.mostrarMiTablero();
                tableroSv.mostrarTableroPines();

                finDelJuego = Boolean.parseBoolean(miServidor.recibirMensaje());
                if(finDelJuego == true){
                    System.out.println("¡Usted ha ganado!");
                    break;
                }


                boolean seguir_recibiendo;
                do{
                    seguir_recibiendo = recibirAtaque(tableroSv, miServidor);
                }while (seguir_recibiendo == true);

                finDelJuego = !tableroSv.hayBarcos();
                miServidor.enviarMensaje(String.valueOf(finDelJuego));
                if(finDelJuego == true){
                    System.out.println("Has perdido :c");
                    break;
                }


            } else if (quienComienza == 2) { //comienza el cliente

                tableroSv.mostrarMiTablero();
                tableroSv.mostrarTableroPines();

                boolean seguir_recibiendo;
                do{
                    seguir_recibiendo = recibirAtaque(tableroSv, miServidor);
                }while (seguir_recibiendo == true);

                tableroSv.mostrarMiTablero();
                tableroSv.mostrarTableroPines();

                finDelJuego = !tableroSv.hayBarcos();
                miServidor.enviarMensaje(String.valueOf(finDelJuego));
                if(finDelJuego == true){
                    System.out.println("Has perdido :c");
                    break;
                }



                do{

                    ataqueExitoso = ataque(tableroSv, miServidor);

                }while (ataqueExitoso == false);


                finDelJuego = Boolean.parseBoolean(miServidor.recibirMensaje());
                if(finDelJuego == true){
                    System.out.println("¡Usted ha ganado!");
                    break;
                }

            }




        }while (finDelJuego == false);

    }

    public static boolean ataqueValido(String str, Tablero tablero) {
        try{


        int[][] miTablero = tablero.getMiTablero();

            if (str.length()>2){
                String letra = String.valueOf(str.charAt(0));
                if(str.charAt(1) == '1' && str.charAt(2) == '0'){
                    if (letra.matches(".*[A-J].*")){
                        int posX = str.charAt(0) - 'A';
                        int posY = 9;
                        if(miTablero[posX][posY] == 0 || miTablero[posX][posY] == 1){
                            return true;
                        }
                    }else{
                        return false;
                    }

                }else {
                    return false;
                }
            } else if (str.length() == 0 || str.length() == 1) {
                return false;
            } else{
            String letra = String.valueOf(str.charAt(0));
            String digito = String.valueOf(str.charAt(1));
                if (letra.matches(".*[A-J].*")){
                        if (digito.chars().allMatch( Character::isDigit )){
                            int digito2 =Integer.parseInt(digito)-1;
                            int posX = str.charAt(0) - 'A';
                            int posY = digito2;
                            if(miTablero[posX][posY] == 0 || miTablero[posX][posY] == 1){
                                return true;
                            }
                        }else{
                            return false;

                        }
            }
            }

        return false;

        }catch (Exception e){
            return false;
        }


    }

    public static boolean ataque(Tablero tableroSv, Object clienteServer){
        if (clienteServer instanceof ServidorTCP) {
            ServidorTCP miServidor = (ServidorTCP) clienteServer;
            String recibido;
            String mensaje;
            int posY;
            int posX;
            Scanner sc = new Scanner(System.in);
            //comienza el server
            System.out.println("¡Es su turno!");
            do{
                System.out.println("Por favor digite la casilla en la que desea atacar");
                mensaje = sc.nextLine();
                miServidor.enviarMensaje(mensaje);
                recibido = miServidor.recibirMensaje();
                if(recibido.contains("ERROR")){
                    System.out.println("POSICION NO VALIDA, INTENTE NUEVAMENTE");
                }
            }while (recibido.contains("ERROR"));

            System.out.println(recibido);
            posX = mensaje.charAt(0) - 'A';
            if (mensaje.contains("10")){
                posY = 9;
            }else{
                posY = Integer.parseInt(String.valueOf(mensaje.charAt(1)))-1;

            }
            if(recibido.contains("IMPACTO")){
                tableroSv.getTableroPines()[posX][posY] = 2;
            }
            else if (recibido.contains("FALLO")){
                tableroSv.getTableroPines()[posX][posY] = 3;
            }

            return true;
        } else if (clienteServer instanceof ClienteTCP) {
            ClienteTCP miCliente = (ClienteTCP) clienteServer;
            String recibido;
            String mensaje;
            int posY;
            int posX;
            Scanner sc = new Scanner(System.in);
            //comienza el server
            System.out.println("¡Es su turno!");
            do{
                System.out.println("Por favor digite la casilla en la que desea atacar");
                mensaje = sc.nextLine();
                miCliente.enviarMensaje(mensaje);
                recibido = miCliente.recibirMensaje();
                if(recibido.contains("ERROR")){
                    System.out.println("POSICION NO VALIDA, INTENTE NUEVAMENTE");
                }
            }while (recibido.contains("ERROR"));

            System.out.println(recibido);
            posX = mensaje.charAt(0) - 'A';
            if (mensaje.contains("10")){
                posY = 9;
            }else{
                posY = Integer.parseInt(String.valueOf(mensaje.charAt(1)))-1;

            }
            if(recibido.contains("IMPACTO")){
                tableroSv.getTableroPines()[posX][posY] = 2;
            }
            else if (recibido.contains("FALLO")){
                tableroSv.getTableroPines()[posX][posY] = 3;
            }

            return true;
        }
        return false;

    }


    public static boolean recibirAtaque(Tablero tableroCl, Object clienteServer){

        if (clienteServer instanceof ClienteTCP) {
            System.out.println("¡Es el turno del enemigo!");
            ClienteTCP miCliente = (ClienteTCP) clienteServer;
            String mensaje = miCliente.recibirMensaje();
            if(Servidor.ataqueValido(mensaje, tableroCl)){
                int posY;
                int posX;
                if (mensaje.contains("10")){
                    posY = 9;
                }else{
                    posY = Integer.parseInt(String.valueOf(mensaje.charAt(1)))-1;

                }

                posX = mensaje.charAt(0) - 'A';
                if(tableroCl.getMiTablero()[posX][posY] == 0){
                    tableroCl.getMiTablero()[posX][posY] = 3;
                    miCliente.enviarMensaje("FALLO");
                    System.out.println("¡EL ENEMIGO HA ATACADO EN LA POSICION " + mensaje);
                    return false;
                } else if (tableroCl.getMiTablero()[posX][posY] == 1) {
                    tableroCl.getMiTablero()[posX][posY] = 2;
                    miCliente.enviarMensaje("IMPACTO");
                    System.out.println("¡EL ENEMIGO HA ATACADO EN LA POSICION " + mensaje);
                    return false;
                }else{
                    miCliente.enviarMensaje("ERROR");
                    System.out.println("ERROR EN EL ATAQUE DEL ENEMIGO");
                    return true;
                }

            }else{
                miCliente.enviarMensaje("ERROR");
                System.out.println("ERROR EN EL ATAQUE DEL ENEMIGO");
                return true;
            }
            //tableroCl.mostrarMiTablero();

        } else if (clienteServer instanceof ServidorTCP) {
            System.out.println("¡Es el turno del enemigo!");
            ServidorTCP miServidor = (ServidorTCP) clienteServer;
            String mensaje = miServidor.recibirMensaje();
            if(Servidor.ataqueValido(mensaje, tableroCl)){
                int posY;
                int posX;
                if (mensaje.contains("10")){
                    posY = 9;
                }else{
                    posY = Integer.parseInt(String.valueOf(mensaje.charAt(1)))-1;

                }

                posX = mensaje.charAt(0) - 'A';
                if(tableroCl.getMiTablero()[posX][posY] == 0){
                    tableroCl.getMiTablero()[posX][posY] = 3;
                    miServidor.enviarMensaje("FALLO");
                    System.out.println("¡EL ENEMIGO HA ATACADO EN LA POSICION " + mensaje);
                    return false;
                } else if (tableroCl.getMiTablero()[posX][posY] == 1) {
                    tableroCl.getMiTablero()[posX][posY] = 2;
                    miServidor.enviarMensaje("IMPACTO");
                    System.out.println("¡EL ENEMIGO HA ATACADO EN LA POSICION " + mensaje);
                    return false;
                }else{
                    miServidor.enviarMensaje("ERROR");
                    System.out.println("ERROR EN EL ATAQUE DEL ENEMIGO");
                    return true;
                }

            }else{
                miServidor.enviarMensaje("ERROR");
                System.out.println("ERROR EN EL ATAQUE DEL ENEMIGO");
                return true;
            }
            //tableroCl.mostrarMiTablero();

        }
        return true;


    }





}




