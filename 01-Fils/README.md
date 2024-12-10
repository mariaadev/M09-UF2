# **01-Fils**

Aquest projecte forma part de la UF2 de programació de fils en Java. 

L’activitat consisteix en la implementació de diferents comportaments de fils per posar en pràctica les bases de la multiprogramació en Java. 

Es treballa amb dos fils (`Juan` i `Pepe`) que es gestionen de manera diferent en funció del comportament configurat.

---

## **Descripció del projecte**

El projecte consta de dos fitxers principals:
1. **`Principal.java`**: Conté el codi principal que inicialitza i gestiona els fils en els diferents comportaments.

2. **`Fil.java`**: Defineix la classe per als fils, amb lògica específica segons el comportament seleccionat.

### **Comportaments implementats**

1. **Comportament 1**: Execució intercalada però sense un ordre estricte. Els fils s’executen amb freqüència més o menys igual, però l’ordre no està garantit.

2. **Comportament 2**: Un fil domina l'execució completant totes les seves iteracions abans que l'altre fil comenci.

3. **Comportament 3**: Execució estrictament alternada. Els fils s’executen seguint un ordre estricte (un torn per cada fil).

---

## **Estructura de la carpeta**

La carpeta `01-Fils` conté els fitxers següents:
- **`Principal.java`**: El codi principal que gestiona els fils i mostra el resultat de cada comportament.
- **`Fil.java`**: La classe que implementa els diferents comportaments dels fils.
- **`README.md`**: Explicació del projecte i els resultats de les execucions.

---

## **Execucions realitzades**

### Comportament 1: Execució intercalada
Aquest comportament permet que els fils s’executin amb intercalació, però no amb un ordre estricte.

**Exemple de sortida:**
```plaintext
Termina thread main
Juan 1
Pepe 1
Juan 2
Pepe 2
Juan 3
Pepe 3
Juan 4
Pepe 4
Juan 5
Pepe 5
Juan 6
Pepe 6
Juan 7
Pepe 7
Pepe 8
Juan 8
Juan 9
Pepe 9
Termina el fil Juan
Termina el fil Pepe
```

### Comportament 2: Execució dominant
**Exemple de sortida:**
```plaintext
Termina thread main
Juan 1
Juan 2
Juan 3
Juan 4
Juan 5
Juan 6
Juan 7
Juan 8
Juan 9
Pepe 1
Pepe 2
Pepe 3
Pepe 4
Pepe 5
Pepe 6
Pepe 7
Pepe 8
Pepe 9
Termina el fil Juan
Termina el fil Pepe
```

### Comportament 3: Execució alternança estricte
**Exemple de sortida:**
```plaintext
Termina thread main
Juan 1
Pepe 1
Juan 2
Pepe 2
Juan 3
Pepe 3
Juan 4
Pepe 4
Juan 5
Pepe 5
Juan 6
Pepe 6
Juan 7
Pepe 7
Juan 8
Pepe 8
Juan 9
Pepe 9
Termina el fil Juan
Termina el fil Pepe
```