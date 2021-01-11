

# TD 1 sur la correction et la terminaison des algorithmes

  

## Exercice 3 - Recherche dichotomique dans un tableau

```java
public static int rechercheVite(int[] tab, int x) {
    int gauche = 0;
    int droite = tab.length - 1;
    int milieu;
    while (gauche <= droite) {
        milieu = (gauche + droite) / 2;
        if (x == tab[milieu]) {
            return milieu;
        }
        if (x < tab[milieu]) {
            droite = milieu - 1;
        }
        else {
            gauche = milieu + 1;
        }
    }
    return -1;
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


3. 







