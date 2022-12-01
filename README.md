## Proyecto final programación en Java

# Batalla Naval
![logo](https://github.com/fnocampo04/Proyecto-final-programacion-en-Java/blob/main/Batalla%20Naval/logo.png)

## Descripción del Juego

![logo](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTGPPexbjYw9RScCXDvKZNIPd4RBMaJimOWuw&usqp=CAU)


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

## Una descripción detallada de las actividades en las cuales se involucró cada integrante del equipo
| Integrante | Actividad |
| --- | --- |
| Mateo Salazar Zapata | Encargado de hacer la conexión entre el servidor y cliente, lo que consiste en la creación de los métodos para tener una escucha permanente entre ambos, particularmente son funciones o métodos como lo es recibirMensaje(), enviarMensaje(), también se cuenta con métodos para el cierre de la conexión al momento de finalizar el juego cerraClienteTCP() Y cerrarServerTCP(), teniendo en cuenta la funcionalidad de cada clase y constructores propios que cuenta con la creación del socket para la permitir la conexión  |
|  Francisco Javier Ocampo Betancur   | Estructuración de la dinámica del juego, validación de los métodos principales como creación de barcos posicionarBarcos(), creación de tableros tanto de ataque como tablero propio getMiTablero(), crearMiTablero(), mostrarMiTablero(), tambien incluye la comprobación de los métodos de ataque y validación de posiciones, permaneciendo en los estándares de jugabilidad para batalla Naval|

## alternativas comerciales o libres que respondan o resuelvan el problema, en cierta medida o por completo.

Batalla Naval empezó como juego de mesa creado por Milton Bradley Company en 1931, después de su gran acogida por los hogares, se decide exportar la experiencia a un nivel virtual teniendo hoy en día miles de versiones que tiene la misma dinámica del juego original.
Como por nombrar uno de los productos comerciales del juego encontramos
- BattleShip por la empresa UBISOFT contando con una experiencia más competitiva incluyendo torneos con diferentes retos del juego.
![logo](https://staticctf.akamaized.net/J3yJr34U2pZ2Ieem48Dwy9uqj5PNUQTn/2HbynDtkRoykvenxEGPTaF/89ea1746e327f197387a7a4311ef03fd/-BS-_Hero_Image_-_Desktop.jpg)

https://www.ubisoft.com/es-mx/game/battleship/battleship

- Hasbro's Battleship es el original juego estratégico de guerra naval. ¡Elige a tu Capitán, posiciona tus barcos, apunta tus misiles y hunde la flota enemiga! Enfréntate a ellos en el modo Clásico o aumenta las apuestas en el nuevo Modo Comandantes.
![logo](https://cdn.cloudflare.steamstatic.com/steam/apps/893050/ss_ee4b9922101bcbb33e1131d6c0bff39811796469.600x338.jpg?t=1663350033)

https://store.steampowered.com/app/893050/Hasbros_BATTLESHIP/

- Como propuesta comercial para los dispositivos móviles, Microsoft tiene una versión llamada Batalla Naval
![logo](https://store-images.microsoft.com/image/apps.33252.13510798882837222.f8d1e577-97ae-4c99-bc70-d3bf8ab7d793.cd27d4af-358c-4200-8a42-6747bcb14265?w=472&h=788&q=90&format=jpg)

https://www.microsoft.com/es-co/p/batalla-naval/9nblggh07qbp#

## Quién tiene el problema

De forma general el juego abarca a personas de todas las edades que deseen divertirse un rato con una partida de Batalla Naval de manera simple y en línea; particularmente a aquellas personas con experiencia en el juego clásico de Batalla Naval o en su defecto que le apasionan los videojuegos, por su parte también surge como un reto en la construcción de la arquitectura del juego aplicando los conocimientos del curso, tales como una conexión TCP adecuada y un manejo óptimo de la lógica interna que permita depurar más fácilmente los posibles inconvenientes que sucedan en el desarrollo.

## descripción detallada del problema, usando requerimientos, casos de uso, historias de usuario, o alguna otra herramienta que permita la descripción detallada del mismo.

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
- Una descripción en lenguaje natural de cómo decidió el equipo abordar el problema.

Al momento de abordar el problema sabíamos que tenemos que crear una conexión entre cliente y servidor para poder jugar en dos computadores diferentes sin dar la posibilidad de que cada jugador vea el tablero del enemigo.
Como inicio fundamental se debe establecer la comunicación a partir de los sockets permitiendo el flujo de datos o en este caso intercambio de ataques, para ello se debe permitir recibir y enviar mensaje en ambos extremos, por ello la creación de los métodos especiales para esta tareas es indispensable particularmente son llamados enviarMensaje() y recibirMensaje(), una vez concluido la conexión debemos empezar por crear un tablero vacío que nuestra solución fue hacer una matriz de 10*10 que contenga solo ceros para dar la oportunidad al jugador de que ponga sus barcos en posiciones diferentes.
Para este momento ya los dos jugadores tanto el servidor como el cliente ponen al mismo tiempo la posición del barco, teniendo en cuenta el programa comprueba las posiciones válidas, algo para destacar es que el juego no inicia si algún jugador le falta barcos por poner, evitando la generación de errores y posibles caídas del juego.

- Diagrama de bloques, de clases, de flujo, de interfaz, etc.
![logo](https://github.com/fnocampo04/Proyecto-final-programacion-en-Java/blob/main/Batalla%20Naval/DiagramaClases.jpeg)


## Ensayos y Solución a errores
| Fecha | Problema | Solución |
| --- | --- | --- |
|03/11/2022 | Error en el método posicionar barcos | La solución fue ingresar condiciones “IF” para asegurar que esté entre el rango de las columnas (A, J) y en las filas que no pase de (1,10), agregando la excepción de que no se salga de la matriz indicada para el tablero. |
|03/11/2022 | Código innecesario excesivamente largo  | Se optimizó el código y se eliminó algunos comentarios ruido que no eran muy relevantes |
|05/11/2022| Errores al momento de atacar generan excepciones en el código | creamos filtros con condicionales IF, try catch, bucles entre otros para evitar errores en el ataque, el método ataqueValido() fue añadido |
|10/11/2022 | Al momento de atacar cuenta 3 jugadas y termina la conexión del servidor | Fin del juego estaba habilitado en todo momento, después de que se realizará un ataque del servidor al cliente, y este recibiera el ataque, de forma más precisa encontramos el problema después de realizar una jugada, el error fue corregido modificando algunos parámetros del fin del juego  |
|15/11/2022 | Encontramos que las posiciones J9 e I9 al momento de atacar nos arroja posición inválida. | Se corrige la ubicación de la columna ingresada, el error se encontraba en que al evaluar, si la columna era válida estaba evaluando en la siguiente columna, por tanto no se podía posicionar barcos a partir de la columna 9 o que tuvieran una posición ya ocupada en la siguiente columna. Particularmente el error se encontraba en la clase tablero "en el método posicionarBarcos()" |
| 15/11/2022 | juego en consola no permite distinguir de forma armónica algunas jugadas realizadas por el usuario | Añadimos console colors para poder apreciar las diferencias significativas al momento de realizar ataques y recibirlos |
|17/11/2022 | El final del juego no funciona. | Se cambió la lógica en la comunicación de fin del juego entre cliente y servidor, evitando que se envíe el mismo mensaje al mismo tiempo y no haya quien lo reciba, entre otros inconvenientes al momentos de avisar cuando se acabó la partida. Particularmente los cambios fueron realizados en la clase servidor y en la clase cliente  |
|20/11/2022 | La ip y el puerto solo pueden ser ingresados desde la consola | Permitimos al usuario que va a ser el servidor escoger su puerto, haciendo uso de su propia ip, y al usuario que se le asigne el cliente ingresar la ip del servidor del cual desea conectarse |

## Bibliografia 
- https://www.codejava.net/java-se/networking/java-socket-server-examples-tcp-ip
- https://en.wikipedia.org/wiki/Battleship_(game)
- https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
- http://puntocomnoesunlenguaje.blogspot.com/2012/12/matriz-en-java.html
- https://es.wikipedia.org/wiki/Socket_de_Internet

## Authors

- [@TeoZapata](https://github.com/TeoZapata)
- [@fnocampo04](https://github.com/fnocampo04)
