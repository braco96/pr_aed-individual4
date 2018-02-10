# AED — Entrega Individual 4: PositivePositionListIterator
**Autor:** Luis Bravo  
**Curso:** 2017–2018 — Algoritmos y Estructuras de Datos (UPM)

Proyecto **Maven** organizado para la práctica de iteradores sobre listas de posiciones.

## Estructura
```
src/
  main/java/aed/positiveiterator/
    PositivePositionListIterator.java   # clase principal (sin modificar)
    Example.java                        # main de ejemplo
  test/java/aed/positiveiterator/
    TesterInd4.java                     # tester oficial
    BuildSmokeTest.java                 # test mínimo JUnit
docs/guia.pdf                           # enunciado de la práctica
libs/aedlibraries.jar                   # librería externa (añádela manualmente)
```

## Uso
```bash
# 1) Copia la librería aedlibraries.jar en la carpeta libs/
# 2) Compila y ejecuta los tests
mvn -q -DskipTests=false test

# Ejecuta el main de ejemplo
mvn -q -Dexec.mainClass=aed.positiveiterator.Example exec:java
```

### Descripción del ejercicio
Implementar un iterador `PositivePositionListIterator` que recorra una `PositionList<Integer>` devolviendo solo los **valores positivos**, ignorando los negativos y `null`.  
Debe lanzar `IllegalArgumentException` si la lista es `null` y `UnsupportedOperationException` en `remove()`.

**Ejemplo de salida esperada:**
| Entrada | Salida |
|----------|---------|
| {2, -2, 1, 2} | 2, 1, 2 |
| {2, 2, null, null, 2, 3, -1, -1} | 2, 2, 2, 3 |
| {null, -1, 5} | 5 |

Consulta *docs/guia.pdf* para más detalles.

— *Luis Bravo*