# TD3 - ALGORITHMES GLOUTONS

## Exercice 1 - Ordonnancement d’intervalles (interval scheduling) :

1. **Sélectionner les requêtes qui débutent le plus tôt d’abord** n'est pas optimal si il y a plusieurs petits intervalles qui démarrent après un très long intervalle.
2. **Sélectionner les plus petites requêtes $(f (i) − s(i))$ d’abord** n'est pas optimal si ces petites requêtes sont en conflits avec beaucoup d'intervalles.
3. **Sélectionner les requêtes qui finissent en premier d’abord** est la solution la plus optimale parmi les 4 possibilités que nous avons.
4. **sélectionner les requêtes qui ont le moins de conflits d’abord** n'est pas optimal car on omet beaucoup d'intervalles.


