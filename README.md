# Adneom : Java Interview Test

## Problématique
```sh
Le but de ce petit projet est de fournir une petite librairie qui permet de partitioner une liste 
en un ensemble de sous liste.

Pour cela, il faut donc que la librairie soit générique, c'est à dire que notre librairie doit etre
capable de partitioner toutes les classes(listes) qui héritent de l'interface collection.
```
## Rappel: Archicteture de l'Interface Collection
![Alt text](https://github.com/MarLeo/adneom/blob/master/collection.jpg)

# Implémentation

## Raisons
```sh
Notre implémentation utilisera donc la classe Queue, car elle fournit des méthodes qui nous
semblent plus adaptées à résoudre le probléme.
* Elle fournie une structure de type FIFO(on n'a pas de contrainte de Priorité ici)
* Donc on pourra facilement retirer des éléments dans la liste de départ, tout en réduisant 
la taille de la liste
```

## Implémentation
```sh
Une description de notre implémentation:
* On vérifie d'abord si le nombre de partitions à faire est un entier > 0, sinon une exception est lancée.
* Si la premiére condition est vérifiée, on vérifie si la liste est de type Queue, sinon on la transforme en Queue
* Si les deux premières conditions sont véifiées, on vérifie si la liste est vide , si oui une exception est lancée.
* Si tout est bon le corps de la méthode est donc appelé:
```
```java
....
while (queue.size() > 0) {
   List<T> little = new LinkedList<>();
   for (int i = 0; i < partitions; i++) {
       if (queue.peek() != null) {
           little.add(queue.poll());
        } else break;
   }
   big.add(little);
}
....
```

## Test
```sh
Pour respecter les normes du TDD, ne jamais oublier les tests unitaires!!! Les librairies hamcrest et JUnit
sont donc celles avec lesquelles elle a été testée.
On obtient donc une couverture de 100%
```
![Alt text](https://github.com/MarLeo/adneom/blob/master/couverture.PNG)

# Exécution
```sh
Pour tester notre petit programme la commande suivante vous sera d'une grande aide:
$ mvn clean package
```


