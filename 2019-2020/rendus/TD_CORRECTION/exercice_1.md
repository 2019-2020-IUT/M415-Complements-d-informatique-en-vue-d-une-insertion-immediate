

# TD 1 sur la correction et la terminaison des algorithmes

  

## Exercice 1 - Boucles imbriquées

```java
public static void bonjour1(int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            System.out.println("Bonjour 1");
        }
    }
}

public static void bonjour2(int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
            System.out.println("Bonjour 2");
        }
    }
}
```

1. La méthode ```bonjour1(5)``` affichera 25 fois "Bonjour 1"

2. La méthode ```bonjour2(5)``` affichera 10 fois "Bonjour 2"

3. La méthode ```bonjour1(n)``` affichera "Bonjour 1" $n^2$ fois.

4. La méthode ```bonjour1(n)``` affichera "Bonjour 1" $\frac{n(n-1)}{2}$ fois.


