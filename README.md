# SapaMercat-UF5, Alba Matamoros Morales
## INTRODUIR PRODCUTE
Per introduir productes he fet tres mètodes diferents per cadascun dels productes. 
Un cop l'usuari introdueix les dades correctament (Alimentació, textil o Electrònica) les dades de l'objecte creat es guarden en un ArrayList comú on es troben tots els productes.
## PASSAR PER CAIXA
En passar per caixa utilitzo Collections.sort(productes); per ordenar tots els productes segons el seu codi de barres, i els tèxtils segons la seva composició.
Despres crido a llegirPreuTextil(p); per si hem de modificar el preu o afegir el codi al fitxer de preus.
Finalment abans de mostrar tot el tiquet, cridem al mètode afegirACarroPerCaixa(p); per emplenar el LinkedHashMap amb l'ArrayList productes i comprovar els productes repetits segons el seu codi i preu.

Mostrem el tiquet amb el LinkedHashMap emplenat i mostrem els detalls de cada producte més el seu preu final.
## MOSTRAR CARRO DE LA COMPRA

## COLLECTIONS
### COLLECTION LIST
He utilitzat dos ArrayList, l'ArrayList productes i prodTextil. Productes l'utilitzo per guardar tots els productes creats, i prodTextil només guarda els tèxtils per poder comparar els codis de barres i no emmagatzemar dos amb el mateix codi. 
(Els productes tèxtils també s'emmagatzemen en l'ArrayList productes)
Per què ArrayList?
He utilitzat ArrayList com la collection List, perquè em semblava la millor opció a l'hora de poder accedir als productes emmagatzemats. 
LinkedList funciona amb un punter, i per poder fer-ho com ho volia fer, l'ArrayList m'anava millor a l'hora de recórrer-ho.
### COLLECTION MAP
Per què LinkedHashMap?
containsKey i containsValue.
He utilitzat LinkedHashMap en compte de HashMap perquè LinkedHashMap ordena els productes introduïts segons com tu els has introduït, si poses primer Pera i després Poma l'orde es quedarà així, en canvi HashMap ordena com ell vol.
### COMPARABLE I COMPARATOR

## EXCEPCIONS


:construction: Proyecto en construcción :construction:
