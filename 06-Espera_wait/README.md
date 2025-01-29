# Preguntes teòriques

**1. Perquè s'atura l'execució al cap d'un temps?**: 

No s'atura com a tal perquè està en un bucle infinit però els assistents estan bloquejats en wait() perquè no hi ha places disponibles. També és possible que el sistema operatiu aturi el programa per alliberar recursos.

**2. Què passaria si en lloc d'una probabilitat del 50%-50% fora de 70%(ferReserva) - 30%(cancel·lar)? I si foran al revés les possibilitats? Mostra la porció de codi modificada i la sortida resultant en cada un dels casos.**

**70% ferReserva() - 30% cancelaReserva()**
Les places s'omplen molt ràpid i molts assistents queden bloquejats esperant ja que no hi ha tantes possibilitats de cancel·lació..

Codi: 
   if (random.nextInt(100) < 70) {  // 70% probabilitat de fer reserva
      esdeveniment.ferReserva(this);
   } else {  // 30% probabilitat de cancel·lar
      esdeveniment.cancelaReserva(this);
   }

Execució: 
Asistent-1 ha reservat una plaça. Places disponibles: 4
Asistent-6 ha reservat una plaça. Places disponibles: 3
Asistent-10 ha reservat una plaça. Places disponibles: 2
Asistent-4 ha reservat una plaça. Places disponibles: 1
Asistent-5 ha reservat una plaça. Places disponibles: 0
Asistent-3 no ha pogut cancelar una reserva inexistent. Places disponibles: 0


**30% ferReserva() - 70% cancelaReserva()**
Es cancel·len reserves molt sovint i els assistents tenen més oportunitats per reservar. 

Codi: 
if (random.nextInt(100) < 30) {  // 30% probabilitat de fer reserva
    esdeveniment.ferReserva(this);
} else {  // 70% probabilitat de cancel·lar
    esdeveniment.cancelaReserva(this);
} 

Execució: 

Asistent-9 ha reservat una plaça. Places disponibles: 4
Asistent-2 no ha pogut cancelar una reserva inexistent. Places disponibles: 4
Asistent-7 ha reservat una plaça. Places disponibles: 3
Asistent-9 ha cancel·lat una reserva. Places disponibles: 4
Asistent-1 no ha pogut cancelar una reserva inexistent. Places disponibles: 4
Asistent-2 ha reservat una plaça. Places disponibles: 3
Asistent-6 no ha pogut cancelar una reserva inexistent. Places disponibles: 3
Asistent-2 ha cancel·lat una reserva. Places disponibles: 4
Asistent-8 no ha pogut cancelar una reserva inexistent. Places disponibles: 4
Asistent-1 no ha pogut cancelar una reserva inexistent. Places disponibles: 4
Asistent-6 no ha pogut cancelar una reserva inexistent. Places disponibles: 4
Asistent-9 no ha pogut cancelar una reserva inexistent. Places disponibles: 4
Asistent-4 no ha pogut cancelar una reserva inexistent. Places disponibles: 4
Asistent-5 no ha pogut cancelar una reserva inexistent. Places disponibles: 4
Asistent-3 no ha pogut cancelar una reserva inexistent. Places disponibles: 4

**3. Perquè creus que fa falta la llista i no valdria només amb una variable sencera de reserves? **: 

Si només hi hagués una variable de placesDisponibles, no podríem saber quins assistents tenen reserva i quins no. És necessari l'ús de la llista per mantenir un historial. 
