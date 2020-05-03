

# TD 1 sur la correction et la terminaison des algorithmes


## Exercice 2 - Tri de tableaux par sélection

```java
/**
  * Preconditions :
  * Postconditions :
  */
  
public static void triSelection(int[] tab) {
    for (int i = 0; i < tab.length; i++) {
        // A1 : tab[0..i-1] est trié
        int indiceMin = i;
        for (int j = i + 1; j < tab.length; j++){
            // A2 : tab[indiceMin] <= tab[k] pour tout i <= k <j
            if (tab[indiceMin] > tab[j]) {
                indiceMin = j;
            }
        }
        int aux = tab[i];
        tab[i] = tab[indiceMin];
        tab[indiceMin] = aux;
    }
}
```

1. 
|Étape 0|3 |25|50|8 |1 |3 |49|
|:-----:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|
|Étape 1|1 |25|50|8 |3 |3 |49|
|Étape 2|1 |3 |50|8 |25|3 |49|
|Étape 3|1 |3 |3 |8 |25|50|49|
|Étape 4|1 |3 |3 |8 |25|50|49|
|Étape 5|1 |3 |3 |8 |25|50|49|
|Étape 6|1 |3 |3 |8 |25|49|50|

2. Il y a $\frac{n(n-1)}{2}$ répétitions.
3. 
|Tableau n=7|16|25|50|18|100|32|512|
|:-----:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|
4. Le nombre de répétitions est identique.
5. 



