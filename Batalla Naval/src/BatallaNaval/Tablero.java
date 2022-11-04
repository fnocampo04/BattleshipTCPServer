package BatallaNaval;


import java.security.InvalidParameterException;

import java.util.*;


public class Tablero {
    final int tamano, numBarcos;
    int[][] miTablero, tableroPines;



    public Tablero(int tamano, int numBarcos) {

        if (tamano <= 0)
            throw new InvalidParameterException("Tamaño de tablero invalido! No puede ser <= 0");
        if (numBarcos <= 0)
            throw new InvalidParameterException("Numero de barcos invalido! No puede ser <= 0");

        this.tamano = tamano;
        this.numBarcos = numBarcos;

        crearMiTablero();
        crearTableroPines();
    }
    public void crearMiTablero() {
        miTablero = new int[tamano][tamano];
    }

    public void crearTableroPines(){
        tableroPines = new int[tamano][tamano];
    }
    public void mostrarMiTablero(){

        System.out.println("          | MI TABLERO |        ");

        char ch = 'A';
        System.out.printf("  ");
        for(int i = 1; i <= 10; i++)
        {
            System.out.printf("  " + i);
        }
        System.out.println();
        System.out.println("   ------------------------------"); // Separador
        for (int i = 0; i < miTablero.length; i++) {
            System.out.printf(ch + " | "); // Pone la letra en la fila

            for (int j = 0; j < miTablero[i].length; j++) {
                System.out.print(miTablero[i][j] + "  ");
            }
            ch++; // Siguiente letra
            System.out.println();
        }
        System.out.println();
    }
    public void posicionarBarcos(){

        for (int numBarco = 2; numBarco<=numBarcos; numBarco++){
            boolean satisfactorio = false;
            while (satisfactorio == false){

        int posicionX = 0;
        int posicionY = 0;

        System.out.println("Ubica el barco de tamaño: "+ numBarco);
        boolean bool = true;
        boolean bool2 = true;
        while (bool){
            int coordenadaX = 0;
            System.out.println("Por favor ingrese la letra correspondiente a la fila (A - J): ");
            Scanner sc = new Scanner(System.in);
            char c = sc.next().charAt(0);
            for (char ch = 'A'; ch <='J'; ch++){
                if (c == ch){
                    posicionX = coordenadaX;
                    bool = false;
                }
                coordenadaX++;
            }
        }
        while (bool2){
            int coordenadaY = 0;
            System.out.println("Por favor ingrese el número correspondiente a la columna (1 - 10): ");
            Scanner sc = new Scanner(System.in);
            boolean esNumero = false;
            int sn = 0;
            while (esNumero == false){
                String s = sc.nextLine();
                esNumero = s.chars().allMatch( Character::isDigit );
                if (esNumero == true){
                    sn=Integer.parseInt(s);
                }else{
                    System.out.println("¡Debe ser un número!");
                    System.out.println("Digite la columna nuevamente");
                }
            }

            for (int i = 1; i <= 10; i++){
                if (sn == i){
                    posicionY = coordenadaY;
                    bool2 = false;
                }
                coordenadaY++;
            }
        }
        if (miTablero[posicionX][posicionY] == 0){
        miTablero[posicionX][posicionY] = 1;
        mostrarMiTablero();
        System.out.println("Ingrese la dirección en que quiere el barco");
        System.out.println("A: Arriba | B: Abajo | D: Derecha | I: Izquierda");
        Scanner sc = new Scanner(System.in);
        try {
        String direccion = sc.nextLine();
            switch (direccion) {

                case "A":
                    // Arriba

                    int contador = 1;
                    for (int i = posicionX-1;contador<numBarco; i--){
                        if (miTablero[i][posicionY]==0){
                            miTablero[i][posicionY] = 1;
                            satisfactorio= true;
                        }else{
                            System.out.println("Posicion inválida");
                            miTablero[posicionX][posicionY]= 0;
                            satisfactorio= false;
                            break;
                        }
                        contador++;
                    }

                    break;
                case "B":
                    // Abajo

                    contador = 1;
                    for (int i = posicionX+1;contador<numBarco; i++){
                        if (miTablero[i][posicionY]==0){
                            miTablero[i][posicionY] = 1;
                            satisfactorio= true;
                        }else{
                            System.out.println("Posicion inválida");
                            miTablero[posicionX][posicionY]= 0;
                            satisfactorio= false;
                            break;
                        }
                        contador++;
                    }
                    break;

                case "I" :
                    // Izquierda
                    contador = 1;
                    for (int i = posicionY-1;contador<numBarco; i--){
                        if (miTablero[posicionX][i]==0){
                            miTablero[posicionX][i] = 1;
                            satisfactorio= true;
                        }else{
                            System.out.println("Posicion inválida");
                            miTablero[posicionX][posicionY]= 0;
                            satisfactorio= false;
                            break;
                        }
                        contador++;
                    }
                    break;

                case "D" :
                    // Derecha
                    contador = 1;
                    for (int i = posicionY+1;contador<numBarco; i++){
                        if (miTablero[posicionX][i]==0){
                            miTablero[posicionX][i] = 1;
                            satisfactorio= true;
                        }else{
                            System.out.println("Posicion inválida");
                            miTablero[posicionX][posicionY]= 0;
                            satisfactorio= false;
                            break;
                        }
                        contador++;
                    }
                    break;

                default:
                    System.out.println("Dirección no válida, ingrese nuevamente");
                    miTablero[posicionX][posicionY]=0;
                    satisfactorio= false;
                    break;
                    // Default secuencia de sentencias.
            }
        }catch (ArrayIndexOutOfBoundsException e){ // Este catch para cuando se sale de la matriz
            System.out.println("Dirección no válida, ingrese nuevamente");
            miTablero[posicionX][posicionY]=0;
            satisfactorio= false;

        }
        mostrarMiTablero();
        }else{
            System.out.println("La posición ya está ocupada intente nuevamente");
            satisfactorio = false;
        }
        }
        }
    }



    public void mostrarTableroPines(){

        System.out.println("        | TABLERO ATAQUE |      ");
        char ch = 'A';
        System.out.printf("  ");
        for(int i = 1; i <= 10; i++)
        {
            System.out.printf("  " + i);
        }
        System.out.println();
        System.out.println("   ------------------------------"); // Separador
        for (int i = 0; i < tableroPines.length; i++) {
            System.out.printf(ch + " | "); // Pone la letra en la fila

            for (int j = 0; j < tableroPines[i].length; j++) {
                System.out.print(tableroPines[i][j] + "  ");
            }
            ch++; // Siguiente letra
            System.out.println();
        }
        System.out.println();
    }
}
