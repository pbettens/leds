# Représentation graphique d'un javabean avec Swing et JavaFX

Codes illustratifs du billet [homonyme][blog].

Sens conseillé de lecture

* `LedOn` Un bean non graphique avec une seule propriété « primitive » pour
  javafx et deux propriétés pour swing. `TestLedOn` permet de voir l'ajout 
  d'un écouteur à la led. 
* `LedOnColor` Un bean non grapgique avec deux propriété
* `GLed` Ajout de l'aspect graphique de la led. C'est un disque rouge. 
* `GLedClickable` ajout de la capacité à s'écouter soi-même ^^
* `GLedClickableNoimplement` version sans implémenter d'interface, avec une 
  classe interne anonyme. 
* `GLedBinding` version utilisant un *binding* des propriétés *color* et *on*
  avec la proprité *fill* de *Circle*. (Assez élégante). 


Pierre Bettens <pbettens@heb.be>

![Licence CC-BY-NC-SA](cc-by-nc-sa.png)
