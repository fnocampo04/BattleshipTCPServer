# BattleShip
![logo](https://www.ultraboardgames.com/img/slideshow/battleship.jpg)
## Proyecto final programación en Java
## Descripción del Juego

![logo](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTGPPexbjYw9RScCXDvKZNIPd4RBMaJimOWuw&usqp=CAU)

Batalla naval (también conocido como BattleShip) es un juego clásico de adivinanzas de tipo estrategia para dos jugadores. Se juega en tableros (generalmente de tamaño 10x10) en los que se marca la flota de buques de guerra de cada jugador. Las ubicaciones de las flotas están ocultas para el otro jugador. Se juega con dos tableros entre las dos personas, en el que el ataque de uno se efectúa en el del otro y se lleva un registro de las jugadas en otro tablero. Gana el jugador que destruya los barcos del contrincante.

## Glosario de términos
| Termino | Definición |
| --- | --- |
| Servidor | definimos como servidor en nuestro caso, como la parte del codigo que permite recibir conexión de otra computadora conectado en la misma red local, dando la particularidad que el servidor se modificó para que sea uno de los jugadores.|
| Cliente | llamamos cliente a una clase en particular que permite conectarse con otra maquina en este caso el servidor, el cual hace peticiones de datos en la misma red para que funcionen sincrónicamente, también lo modificamos para que sea uno de los jugadores.|
| Arreglos | Son colecciones de datos ordenados que tienen una identificación o dirección especifica la cual nos permite hacer operaciones, modificaciones y más opciones para seguir con la dinámica del juego, los arreglos en este juego son utilizadas para crear tanto el tablero de ataque individual y el tablero de posiciones de los barcos.|
| Captura de Excepciones | es inevitable que algún código no genere un error, por eso la captura de excepciones nos brinda anticiparnos a estos casos para manejarlos y darles un manejo más ordenado especificando la funcionalidad que se les puede brindar, también las usamos para que los jugadores indique bien las posiciones tanto de los ataque como la de los barcos.|
| métodos | son parte del cogido que cumplen con una función específica para el programa, ayudando a la reutilización y que las líneas sean más compactas.|
| Depurar | es el manejo que le damos a los errores, para que cumplan cierta función y no permita que nuestro programa deje de funcionar.|

## Una descripción detallada de las actividades en las cuales se involucró cada integrante del equipo
| Integrante | Actividad |
| --- | --- |
| Mateo Salazar Zapata | Encargado de hacer la conexion entre el servidor y cliente, lo que consiste en la creacion de los metodos para tener una escucha permanente entre ambos, particularmente son funciones o metodos como lo es recibirMensaje(), enviarMensaje(), tambien se cuenta con metedos para el cierre de la conexión al momento de finalizar el juego cerraClienteTCP() Y cerrarServerTCP(), teniendo en cuenta la funcionalidad de cada clase y constructores propios que cuenta con la creacion del socket para la permitir la conexión  |
|  Francisco Javier Ocampo Betancur   | Estructuración de la dinámica del juego, validación de los metodos principales como creacion de barcos posicionarBarcos(), creación de tableros tanto de ataque como tablero propio getMiTablero(), crearMiTablero(), mostrarMiTablero(), tambien incluye la comprobacion de los metodos de ataque y validación de posiciones, permaneciendo en los estanderes de jugabilidad para batalla Naval|

## alternativas comerciales o libres que respondan o resuelvan el problema, en cierta medida o por completo.

Batalla Naval empezó como juego de mesa creado por Milton Bradley Company en 1931, despues de su gran acogida por los hogares, se decide exportar la experiencia a un nivel virtual tieniendo hoy en dia miles de versiones que tiene la misma dinamica del juego original.
Como por nombrar uno de los productos comerciales del juego encontramos 
- BattleShip por la empresa UBISOFT contando con una experiencia mas competitiva incluyendo torneos con diferentes retos del juego.
![logo](https://staticctf.akamaized.net/J3yJr34U2pZ2Ieem48Dwy9uqj5PNUQTn/2HbynDtkRoykvenxEGPTaF/89ea1746e327f197387a7a4311ef03fd/-BS-_Hero_Image_-_Desktop.jpg)

https://www.ubisoft.com/es-mx/game/battleship/battleship

- Hasbro's Battleship es el original juego estratégico de guerra naval. ¡Elige a tu Capitán, posiciona tus barcos, apunta tus misiles y hunde la flota enemiga! Enfréntate a ellos en el modo Clásico o aumenta las apuestas en el nuevo Modo Comandantes. 
![logo](https://cdn.cloudflare.steamstatic.com/steam/apps/893050/ss_ee4b9922101bcbb33e1131d6c0bff39811796469.600x338.jpg?t=1663350033)

https://store.steampowered.com/app/893050/Hasbros_BATTLESHIP/

- Como propuesta comercial para los dispositivos moviles, Microsoft tiene una version llamada Batalla Naval 
![logo](https://store-images.microsoft.com/image/apps.33252.13510798882837222.f8d1e577-97ae-4c99-bc70-d3bf8ab7d793.cd27d4af-358c-4200-8a42-6747bcb14265?w=472&h=788&q=90&format=jpg)

https://www.microsoft.com/es-co/p/batalla-naval/9nblggh07qbp#

## Quién tiene el problema

De forma general el juego abarca a personas de todas las edades que deseen divertirse un rato con una partida de Batalla Naval de manera simple y en línea; particularmente a aquellas personas con experiencia en el juego clásico de Batalla Naval o en su defecto que le apasionan los videojuegos, por su parte también surge como un reto en la construcción de la arquitectura del juego aplicando los conocimientos del curso, tales como una conexión TCP adecuada y un manejo óptimo de la lógica interna que permita depurar más fácilmente los posibles inconvenientes que sucedan en el desarrollo.

## descripción detallada del problema, usando requerimientos, casos de uso, historias de usuario, o alguna otra herramienta que permita la descripción detallada del mismo.

![logo](https://github.com/fnocampo04/Proyecto-final-programacion-en-Java/blob/ec2bec12d76e9fff970999d17286eee372e46192/Batalla%20Naval/A(1).png)

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

## Arquitectura de la solución
- Una descripción en lenguaje natural de cómo decidió el equipo abordar el problema.
- Diagrama de bloques, de clases, de flujo, de interfaz, etc.


## Ensayos y Solución a errores
| Fecha | Problema | Solución |
| --- | --- | --- |
|03/11/2022 | Error en el método posicionar barcos | La solución fue ingresar condiciones “IF” para asegurar que esté entre el rango de las columnas (A, J) y en las filas que no pase de (1,10), agregando la excepción de que no se salga de la matriz indicada para el tablero. |
|03/11/2022 | Codigo innecesario excesiamente largo  | Se optimizo el codigo y se iliminó algunos comentarios ruido que no eran muy relevantes |
|05/11/2022| Errores al momento de atacar generan excepciones en el codigo | creamos filtros con condicionales IF, try catch, bucles entre otros para evitar errores en el ataque, el metodo ataqueValido() fue añadido |
|10/11/2022 | Al momento de atacar cuenta 3 jugadas y termina la conexión del servidor | Fin del juego estaba habilitado en todo momento, despues de que se realizara un ataque del servidor al cliente, y este recibiera el ataque, de forma mas precisa encontramos el problema despues de realizar una jugada, el error fue corregido modificando algunos parametros del fin del juego  |
|15/11/2022 | Encontramos que las posiciones J9 e I9 al momento de atacar nos arroja posición inválida. | se corrige la ubicación de la columna ingresada, el error se encontraba en que al evaluar, si la columna era valida estaba evaluando en la siguiente columna, por tanto no se podia posicionar barcos apartir de la columna 9 o que tuvieran una posición ya ocupada en la siguiente columna. Particularmente el error se encontraba en la clase tablero "en el metodo posicionarBarcos()" |
| 15/11/2022 | juego en consola no permite distinguir de forma armonica algunas jugadas realizadas por el usuario | Añadimos console colors para poder apreciar las diferencias significativas al momento de realizar ataques y recibirlos |
|17/11/2022 | Fin del juego no funciona. | Se cambió la lógica en la comunicación de fin del juego entre cliente y servidor, evitando que se envie el mismo mensaje al mismo tiempo y no haya quien lo reciba, entre otros inconvenientes al momentos de avisar cuando se acabo la partida. Particularmente los cambios fueron realizados en la clase servidor y en la clase cliente  |
|20/11/2022 | La ip y el puerto solo pueden ser ingresados desde la consola | Permitimos al usuario que va a ser el servidor escoger su puerto, haciendo uso de su propia ip, y al usuario que se le asigne el cliente ingresar la ip del servidor del cual desea conectarse |

