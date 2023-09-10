
# Batalla Naval

## Descripción del Juego

Batalla naval (también conocido como BattleShip) es un juego clásico de adivinanzas de tipo estrategia para dos jugadores. Se juega en tableros (generalmente de tamaño 10x10) en los que se marca la flota de buques de guerra de cada jugador. Las ubicaciones de las flotas están ocultas para el otro jugador. Se juega con dos tableros entre las dos personas, en el que el ataque de uno se efectúa en el del otro y se lleva un registro de las jugadas en otro tablero. Gana el jugador que destruya los barcos del contrincante.


## Glosario de términos
| Término | Definición |
| --- | --- |
| Servidor | definimos como servidor en nuestro caso, como la parte del codigo que permite recibir conexión de otra computadora conectado en la misma red local, dando la particularidad que el servidor se modificó para que sea uno de los jugadores.|
| Cliente | llamamos cliente a una clase en particular que permite conectarse con otra máquina en este caso el servidor, el cual hace peticiones de datos en la misma red para que funcionen sincrónicamente, también lo modificamos para que sea uno de los jugadores.|
| Arreglos | Son colecciones de datos ordenados que tienen una identificación o dirección específica la cual nos permite hacer operaciones, modificaciones y más opciones para seguir con la dinámica del juego, los arreglos en este juego son utilizadas para crear tanto el tablero de ataque individual y el tablero de posiciones de los barcos.|
| Captura de Excepciones | es inevitable que algún código no genere un error, por eso la captura de excepciones nos brinda anticiparnos a estos casos para manejarlos y darles un manejo más ordenado especificando la funcionalidad que se les puede brindar, también las usamos para que los jugadores indique bien las posiciones tanto de los ataque como la de los barcos.|
| métodos | Son parte del código que cumplen con una función específica para el programa, ayudando a la reutilización y que las líneas sean más compactas.|
| Depurar | Es el manejo que le damos a los errores, para que cumplan cierta función y no permita que nuestro programa deje de funcionar.|
| Socket | Socket designa un concepto abstracto por el cual dos procesos (posiblemente situados en computadoras distintas) pueden intercambiar cualquier flujo de datos, generalmente de manera fiable y ordenada. Además es una estructura de datos que permite que dos máquinas se comuniquen entre ellas. |

## Descripción del problema

![logo](https://github.com/fnocampo04/Proyecto-final-programacion-en-Java/blob/ec2bec12d76e9fff970999d17286eee372e46192/Batalla%20Naval/A(1).png)

### Las condiciones que deben ser cubiertas por el análisis y diseño del proyecto se resumen en las siguientes:
- Como generalidad, se pueden conectar dos jugadores de forma remota mediante una conexión punto a punto en el que un jugador es el servidor que aloja la conexión y otro es el cliente que se conecta.

- Se debe crear un tablero de tamaño 10x10 a cada uno de los jugadores para que ubiquen los barcos, adicionalmente otro para que almacene sus jugadas.

![logo](https://github.com/fnocampo04/Proyecto-final-programacion-en-Java/blob/main/Batalla%20Naval/creacionTablero.png)

### El programa debe brindar libertad al momento de elegir la posición de los barcos, de manera que se cumplan las siguientes restricciones:
 - Los barcos a posicionar son de tamaño de 5, 4, 3 y 2 casillas cada uno.
 - Se puede elegir la posición del barco en el tablero y la dirección en la que desee el usuario.
- Los barcos no pueden salir del límite del tablero.
- Los barcos no se pueden cruzar entre ellos, ni ocupar una misma casilla simultáneamente.
- Las posiciones a ingresar deben ser casillas existentes en el tablero

![logo](https://github.com/fnocampo04/Proyecto-final-programacion-en-Java/blob/main/Batalla%20Naval/posicionBarcos.png)

### Una vez posicionados los barcos, se sortea quien inicia el juego aleatoriamente
- Al atacar el usuario que le corresponde, deberá indicar en su turno la posición que desea descubrir en su ataque (fila, columna), mientras que el otro jugador debe esperar su turno.

- Después del ataque el programa les indica a los dos jugadores como sucedió la acción; al que atacó le imprime la posición atacada en el tablero y un mensaje si FALLÓ, hubo IMPACTO o un ERROR en el ataque, adicionalmente al que recibe el ataque se le informa la posición y se actualiza en su tablero.
- El juego se termina cuando ya no se encuentran barcos disponibles para ataque en el tablero de alguno de los jugadores, así pierde el que no tenga e inmediatamente gana el otro.

![logo](https://github.com/fnocampo04/Proyecto-final-programacion-en-Java/blob/main/Batalla%20Naval/FinJuego.png)

## Arquitectura de la solución

Al momento de abordar el problema sabíamos que tenemos que crear una conexión entre cliente y servidor para poder jugar en dos computadores diferentes sin dar la posibilidad de que cada jugador vea el tablero del enemigo.
Como inicio fundamental se debe establecer la comunicación a partir de los sockets permitiendo el flujo de datos o en este caso intercambio de ataques, para ello se debe permitir recibir y enviar mensaje en ambos extremos, por ello la creación de los métodos especiales para esta tareas es indispensable particularmente son llamados enviarMensaje() y recibirMensaje(), una vez concluido la conexión debemos empezar por crear un tablero vacío que nuestra solución fue hacer una matriz de 10*10 que contenga solo ceros para dar la oportunidad al jugador de que ponga sus barcos en posiciones diferentes, de aquí se utilizan los métodos correspondientes en la clase Tablero.

Para este momento ya los dos jugadores tanto el servidor como el cliente ponen al mismo tiempo o de forma asíncrona la posición del barco, teniendo en cuenta que el programa comprueba las posiciones válidas, algo para destacar es que el juego no inicia si algún jugador le falta barcos por poner, evitando la generación de errores y posibles caídas del juego.

Posteriormente se juega mediante la modalidad de turnos, haciendo uso de el método atacar() y el método recibirataque() segun sea el caso sucesivamente, adicionalmente ataqueValido() permite comprobar que el ataque realizado si sea correcto. Adicionalmente se lleva el registro de ataques en el tablero de pines y el registro de ataques hacia uno mismo en el tablero propio.

Por ultimo se verifica cada iteración(jugada) el estado de los barcos en los tableros para determinar si hay un ganador o no en el juego.

Algunas consideraciones:

| Número asignado en la posición | Significado |
| --- | --- |
| 0 | Es agua (se colorea de azul) |
| 1 | Hay un barco (se colorea de blanco) |
| 2 | Se atacó y hubo impacto (se colorea de rojo) |
| 3 | Se atacó y no hubo impacto (se colorea de verde) |


- Diagrama de de clases
![logo](https://github.com/fnocampo04/Proyecto-final-programacion-en-Java/blob/main/Batalla%20Naval/DiagramaClases.jpeg)


## Bibliografia 
- https://www.codejava.net/java-se/networking/java-socket-server-examples-tcp-ip
- https://en.wikipedia.org/wiki/Battleship_(game)
- https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
- http://puntocomnoesunlenguaje.blogspot.com/2012/12/matriz-en-java.html
- https://es.wikipedia.org/wiki/Socket_de_Internet

## Authors

- [@TeoZapata](https://github.com/TeoZapata)
- [@fnocampo04](https://github.com/fnocampo04)
