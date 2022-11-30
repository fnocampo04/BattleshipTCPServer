# BattleShip
![logo](https://www.ultraboardgames.com/img/slideshow/battleship.jpg)
## Proyecto final programación en Java
## Descripción del Juego

![logo](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTGPPexbjYw9RScCXDvKZNIPd4RBMaJimOWuw&usqp=CAU)

Batalla naval (también conocido como BattleShip) es un juego clásico de adivinanzas de tipo estrategia para dos jugadores. Se juega en tableros (generalmente de tamaño 10x10) en los que se marca la flota de buques de guerra de cada jugador. Las ubicaciones de las flotas están ocultas para el otro jugador. Se juega con dos tableros entre las dos personas, en el que el ataque de uno se efectúa en el del otro y se lleva un registro de las jugadas en otro tablero. Gana el jugador que destruya los barcos del contrincante.

## Glosario de términos
Servidor -> definimos como servidor en nuestro caso, como la parte del codigo que permite recibir conexión de otra computadora conectado en la misma red local, dando la particularidad que el servidor se modificó para que sea uno de los jugadores.

Cliente -> llamamos cliente a una clase en particular que permite conectarse con otra maquina en este caso el servidor, el cual hace peticiones de datos en la misma red para que funcionen sincrónicamente, también lo modificamos para que sea uno de los jugadores.

Arreglos -> Son colecciones de datos ordenados que tienen una identificación o dirección especifica la cual nos permite hacer operaciones, modificaciones y más opciones para seguir con la dinámica del juego, los arreglos en este juego son utilizadas para crear tanto el tablero de ataque individual y el tablero de posiciones de los barcos.

Captura de Excepciones -> es inevitable que algún código no genere un error, por eso la captura de excepciones nos brinda anticiparnos a estos casos para manejarlos y darles un manejo más ordenado especificando la funcionalidad que se les puede brindar, también las usamos para que los jugadores indique bien las posiciones tanto de los ataque como la de los barcos.

métodos -> son parte del cogido que cumplen con una función específica para el programa, ayudando a la reutilización y que las líneas sean más compactas.

Depurar -> es el manejo que le damos a los errores, para que cumplan cierta función y no permita que nuestro programa deje de funcionar.

## Quién tiene el problema

De forma general el juego abarca a personas de todas las edades que deseen divertirse un rato con una partida de Batalla Naval de manera simple y en línea; particularmente a aquellas personas con experiencia en el juego clásico de Batalla Naval o en su defecto que le apasionan los videojuegos, por su parte también surge como un reto en la construcción de la arquitectura del juego aplicando los conocimientos del curso, tales como una conexión TCP adecuada y un manejo óptimo de la lógica interna que permita depurar más fácilmente los posibles inconvenientes que sucedan en el desarrollo.

## descripción detallada del problema, usando requerimientos, casos de uso, historias de usuario, o alguna otra herramienta que permita la descripción detallada del mismo.

![logo](https://i.pinimg.com/474x/8a/13/0d/8a130d22081c9b169b56ed3694704716--vocabulary-practice-teaching-vocabulary.jpg)

### Las condiciones que deben ser cubiertas por el análisis y diseño del proyecto se resumen en las siguientes:
- Como generalidad, se pueden conectar dos jugadores de forma remota mediante una conexión punto a punto en el que un jugador es el servidor que aloja la conexión y otro es el cliente que se conecta.

- Se debe crear un tablero de tamaño 10x10 a cada uno de los jugadores para que posicionen los barcos, adicionalmente otro para que almacene sus jugadas.

### El programa debe brindar libertad al momento de elegir la posición de los barcos, de manera que se cumplan las siguientes restricciones:
 - Los barcos a posicionar son de tamaño de 5, 4, 3 y 2 casillas cada uno.
 - Se puede elegir la posición del barco en el tablero y la dirección en la que desee el usuario.
- Los barcos no pueden salir del límite del tablero.
- Los barcos no se pueden cruzar entre ellos, ni ocupar una misma casilla simultáneamente.
- Las posiciones a ingresar deben ser casillas existentes en el tablero
### Una vez posicionados los barcos, se sortea quien inicia el juego aleatoriamente
- Al atacar el usuario que le corresponde, deberá indicar en su turno la posición que desea descubrir en su ataque (fila, columna), mientras que el otro jugador debe esperar su turno.

- Después del ataque el programa les indica a los dos jugadores como sucedió la acción; al que atacó le imprime la posición atacada en el tablero y un mensaje si FALLÓ, hubo IMPACTO o un ERROR en el ataque, adicionalmente al que recibe el ataque se le informa la posición y se actualiza en su tablero.
- El juego se termina cuando ya no se encuentran barcos disponibles para ataque en el tablero de alguno de los jugadores, así pierde el que no tenga e inmediatamente gana el otro.

## Ensayos y Solución a errores
| Fecha | Problema | Solución |
| --- | --- | --- |
|03/11/2022 | Error en el método posicionar barcos | La solución fue ingresar condiciones “IF” para asegurar que esté entre el rango de las columnas (A, J) y en las filas que no pase de (1,10), agregando la excepción de que no se salga de la matriz indicada para el tablero. |
|08/11/2022 | | |
|10/11/2022 | Al momento de atacar cuenta 3 jugadas y termina la conexión del servidor | |
|15/11/2022 | Encontramos que las posiciones J9 e I9 al momento de atacar nos arroja posición inválida. | |
|17/11/2022 | Fin del juego no funciona. | |

