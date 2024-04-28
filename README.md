# SapaMercat-UF5, Alba Matamoros Morales
## INTRODUIR PRODCUTE
Per introduir productes he fet tres mètodes diferents per cadascun dels productes. Un cop l'usuari introdueix les dades correctament (Alimentació, textil o Electrònica) les dades de l'objecte creat es guarden en un ArrayList comú on es troben tots els productes.
## PASSAR PER CAIXA
En passar per caixa utilitzo Collections.sort(productes); per ordenar tots els productes segons el seu codi de barres, i els tèxtils segons la seva composició.

Despres crido a llegirPreuTextil(p); per si hem de modificar el preu o afegir el codi al fitxer de preus.

Finalment abans de mostrar tot el tiquet, cridem al mètode afegirACarroPerCaixa(p); per emplenar el LinkedHashMap amb l'ArrayList productes i comprovar els productes repetits segons el seu codi i preu.

Mostrem el tiquet amb el LinkedHashMap emplenat i mostrem els detalls de cada producte més el seu preu final.
## MOSTRAR CARRO DE LA COMPRA
En mostrar carro de la compra oh primer és utilitzar Collections.sort(productes); després amb un bucle cridem afegirACarro() per emplenar el HashMap carro amb el ArrayList productes, i comprarem els productes repetits segons el codi de barres.

En acabat mostrem els productes que tenim al carro amb el seu número d'unitats.
## CERCAR PRODUCTE
En cercar producte passem un codi introduït per l'usuari i busquem en productes (ArrayList) el codi introduït per comparar-lo i poder trobar el nom del producte.
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
He utilitzat tan comparable com comparator, comparable compara segons el codi de barres i l'ordena i comparator compara segons el preu i l'ordena. A més també he fet servir un comparable exclusiu de tèxtil per ordenar la composició segons llargada i ordre alfabètic.

El comparable de codi és a productes perquè afecti a tots igual que el comparator i el comparable per orde alfabètic és a tèxtil perquè només apliqui a aquest tipus de producte.
## EXCEPCIONS
Principlament he utilitzat Exception, però també he utilitzat IOException, FileNotFoundException, InputMismatchException i ParseException.
- IOException l'he utilitzat per si hi ha algun problema amb la lectura del fitxer UpdateTextilPrices.
- InputMismatchException l'he fet servir per si a algun problema amb l'entrada del preu i els dies de garantia.
- FileNotFoundException l'he fet servir per si per casualitat el programa no troba els fitxers creats.
- ParseException l'he fet servir per al format d'entrada d'algunes variables com la data caducitat.

També he tractat individualment algunes excepcions amb l'Exception, com la llargada del nom, que no pot superar els 15 caràcters o el format del codi de barres, que només pot ser 4 números.