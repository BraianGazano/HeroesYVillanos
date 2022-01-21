# HEROES Y VILLANOS

## CONSIGNA

Se desea modelar un juego compuesto por héroes y villanos. Cada 
personaje del juego posee un 
nombre real, un nombre de super héroe o villano y un conjunto de cualidades o características tales 
como visión nocturna, velocidad, fuerza y edad, entre otras. Cada una de estas posee un nivel 
asociado, por ejemplo, **velocidad: 500**, **fuerza: 700**, **edad: 33**. 


Asimismo, existen características que se calculan en base a los valores de otras, por ejemplo: 
-  **Resistencia**: valor de la fuerza dividido la velocidad 
-  **Camuflaje**: Si valor invisibilidad > valor fuerza entonces 50; si no valor de la velocidad 
-  **Modernidad**: Si valor tecnología > valor superpoderes entonces valor edad; si no 10 

## EL JUEGO
El juego debe permitir la definición de nuevas características. 
El mecanismo básico del juego se basa en enfrentar un personaje con otro y decidir cuál de ellos es el 
ganador. Para decidir quién es el ganador se utiliza el valor de una de las características (por ejemplo,
**fuerza**, **velocidad**, **invisibilidad**). En caso de empate, se decide por el valor de otra característica dada 
(en el orden establecido previamente). 


A su vez, el juego debe proveer un mecanismo de agrupamiento de los personajes en ligas para realizar 
desafíos o enfrentamientos entre grupos de personajes. Para esto, el valor de cada característica se 
determina como el promedio de todos los personajes. Es posible que también un solo personaje se 
enfrente a un grupo, o que una liga pertenezca a una liga más grande.

## SERVICIOS
Se debe proveer servicios que permitan obtener: 
- Todos los personajes/ligas que existen en el juego que venzan a un personaje dado para un 
cierto criterio. 
- Decidir quién es el vencedor de una disputa, acorde a un criterio. 
- Poder armar ligas de súper héroes o súper villanos. 
- Obtener listados de personajes ordenados (ascendente o descendentemente) por múltiples 
criterios. En caso de igualdad de dos personajes para un atributo dado se debe permitir 
ordenarlos por los siguientes criterios de orden. Por ejemplo: 
    - Por nombre de súper héroe, después por fuerza y finalmente por velocidad 
    - Por fuerza y luego por invisibilidad 

## AUTOR

### Braian Gazano