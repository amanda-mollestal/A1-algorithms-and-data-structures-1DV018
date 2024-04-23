# Uppgift 4

## UnionFind Union Performance Table

| Array Size | Mean Execution (ns) | Mean Execution (ms) | Standard Deviation (ns) |
|------------|---------------------|---------------------|-------------------------|
| 100        | 2088.16             | 0.00208816          | 2063.4466               |
| 200        | 7339.72             | 0.00733972          | 5055.3861               |
| 400        | 22034.29            | 0.02203429          | 1488.7193               |
| 800        | 78481.07            | 0.07848107          | 5890.5123               |
| 1600       | 298706.1            | 0.2987061           | 16892.4033              |
| 3200       | 1155365.54          | 1.15536554          | 47407.2374              |

## WQUnionFind Union Performance Table

| Array Size | Mean Execution (ns) | Mean Execution (ms) | Standard Deviation (ns) |
|------------|---------------------|---------------------|-------------------------|
| 100        | 381.74              | 0.00038174          | 333.3025                |
| 200        | 205.39              | 0.00020539          | 132.4460                |
| 400        | 384.07              | 0.00038407          | 264.7286                |
| 800        | 714.41              | 0.00071441          | 191.7586                |
| 1600       | 1399.99             | 0.00139999          | 293.5251                |
| 3200       | 2747.52             | 0.00274752          | 354.5248                |

## UnionFind Connected Performance Table

| Array Size | Mean Execution (ns) | Mean Execution (ms) | Standard Deviation (ns) |
|------------|---------------------|---------------------|-------------------------|
| 100        | 292.81              | 0.00029281          | 400.4863                |
| 200        | 52.83               | 0.00005283          | 87.2582                 |
| 400        | 60.6                | 0.0000606           | 123.0432                |
| 800        | 94.44               | 0.00009444          | 71.5198                 |
| 1600       | 156.99              | 0.00015699          | 89.5608                 |
| 3200       | 325.96              | 0.00032596          | 331.4002                |


## WQUnionFind Connected Performance Table

| Array Size | Mean Execution (ns) | Mean Execution (ms) | Standard Deviation (ns) |
|------------|---------------------|---------------------|-------------------------|
| 100        | 488.2               | 0.0004882           | 944.4251                |
| 200        | 219.39              | 0.00021939          | 97.7805                 |
| 400        | 369.33              | 0.00036933          | 126.1759                |
| 800        | 726.64              | 0.00072664          | 192.3650                |
| 1600       | 1438.97             | 0.00143897          | 411.5074                |
| 3200       | 2794.59             | 0.00279459          | 765.5898                |

#### UnionFind Union:

| Array Size | Mean Execution (ms) | Time Ratio | Log2 Ratio  |
|------------|---------------------|------------|-------------|
| 200        | 0.00733972          | -          | -inf        |
| 400        | 0.02203429          | 3.0021     | 1.5860      |
| 800        | 0.07848107          | 3.5618     | 1.8326      |
| 1600       | 0.2987061           | 3.8061     | 1.9283      |
| 3200       | 1.15536554          | 3.8679     | 1.9516      |


#### WQUnionFind Union:

| Array Size | Mean Execution (ms) | Time Ratio | Log2 Ratio  |
|------------|---------------------|------------|-------------|
| 200        | 0.00020539          | -          | -inf        |
| 400        | 0.00038407          | 1.8706     | 0.9045      |
| 800        | 0.00071441          | 1.8601     | 0.8993      |
| 1600       | 0.00139999          | 1.9599     | 0.9750      |
| 3200       | 0.00274752          | 1.9625     | 0.9762      |

UnionFind Connected:

| Array Size | Mean Execution (ms) | Time Ratio | Log2 Ratio  |
|------------|---------------------|------------|-------------|
| 200        | 0.00005283          | -          | -inf        |
| 400        | 0.0000606           | 1.1476     | 0.2092      |
| 800        | 0.00009444          | 1.5601     | 0.6350      |
| 1600       | 0.00015699          | 1.6623     | 0.7276      |
| 3200       | 0.00032596          | 2.0767     | 1.0397      |

WQUnionFind Connected:

| Array Size | Mean Execution (ms) | Time Ratio | Log2 Ratio  |
|------------|---------------------|------------|-------------|
| 200        | 0.00021939          | -          | -inf        |
| 400        | 0.00036933          | 1.6834     | 0.7409      |
| 800        | 0.00072664          | 1.9680     | 0.9778      |
| 1600       | 0.00143897          | 1.9802     | 0.9823      |
| 3200       | 0.00279459          | 1.9428     | 0.9578      |


## Kod- och tidskomplexitetsanalys:
#### UnionFind:
Union: Union-metoden i UnionFind-klassen innebär att uppdatera parent-arrayen för att ansluta två noder. Denna operation itererar genom hela parent-arrayen för att uppdatera föräldern till alla noder som tillhör samma komponent som a till roten av b. Detta resulterar i en tidskomplexitet på O(N) för varje union-operation.

Connected: Connected-metoden kontrollerar om två noder är anslutna genom att jämföra deras parent-värden. Denna operation är konstant tid, O(1), eftersom den involverar direkt array-åtkomst.

#### Weighted Quick Union Find (WQUnionFind):
Union: Union-metoden i WQUnionFind-klassen innebär att ansluta två noder baserat på storleken på deras träd. Det mindre trädet kopplas till roten av det större trädet. Detta garanterar att träden förblir mer balanserade. Root-metoden används för att hitta roten av en nod, vilket i värsta fall kan vara O(N), men på grund av den vägda naturen går det oftast mycket snabbare, vilket leder till en genomsnittlig tidskomplexitet på O(logN) för varje union-operation.

Connected: Connected-metoden kontrollerar om två noder är anslutna genom att hitta deras rötter och jämföra dem. Denna operation har en tidskomplexitet av O(logN) på grund av root-metoden.

## Empirisk analys:

### Lutning:
Med formeln för lutning: m = (y2 - y1) / (x2 - x1), där x1 och x2 är array-storlekarna och y1 och y2 är de motsvarande exekveringstiderna, kan vi beräkna lutningen för varje intervall.

UnionFind Union:
- Lutning mellan 200 och 400: 0.07347285
- Lutning mellan 400 och 800: 0.14189256
- Lutning mellan 800 och 1600: 0.27528154
- Lutning mellan 1600 och 3200: 0.53591215

WQUnionFind Union:
- Lutning mellan 200 och 400: 0.0008934
- Lutning mellan 400 och 800: 0.00066068
- Lutning mellan 800 och 1600: 0.00085729
- Lutning mellan 1600 och 3200: 0.00084208

UnionFind Connected:
- Lutning mellan 200 och 400: 0.00003885
- Lutning mellan 400 och 800: 0.00006768
- Lutning mellan 800 och 1600: 0.000078275
- Lutning mellan 1600 och 3200: 0.0001059875

WQUnionFind Connected:
- Lutning mellan 200 och 400: 0.0007497
- Lutning mellan 400 och 800: 0.00071462
- Lutning mellan 800 och 1600: 0.00089166
- Lutning mellan 1600 och 3200: 0.00084726

UnionFind Union: Lutningsvärdena som beräknats för UnionFind union-metoden visar en konsekvent ökning när indatastorleken växer. Detta indikerar linjär tillväxt. Förekomsten av en loop i algoritmen som itererar genom hela parent-arrayen tyder på att tillväxten är linjär: O(N). Detta innebär att för varje enhetsökning i indatastorleken ökar exekveringstiden proportionellt. Denna linjära ökning av exekveringstiden med ökande indatastorlek är ett kännetecken för linjär tillväxt.

WQUnionFind Union: Lutningsvärdena för WQUnionFind union-metoden är mycket mindre i jämförelse. Detta indikerar att exekveringstiden inte ökar lika snabbt med tillväxten i indatastorleken. Algoritmens utformning, som involverar att hitta roten av noder och sedan ansluta dem baserat på storleken av deras träd, föreslår ett tillväxtmönster som är mer logaritmiskt. Hittandet av root har en komplexitet av O(logN), vilket gör den totala komplexiteten till O(logN).

UnionFind Connected: Lutningsvärdena för UnionFind connected-metoden är relativt konsekventa, vilket tyder på en konstant tidskomplexitet av O(1). Detta beror på att metoden involverar direkt array-åtkomst för att kontrollera om två noder är anslutna.

WQUnionFind Connected: Lutningsvärdena för WQUnionFind connected-metoden visar ett tillväxtmönster som är närmare logaritmiskt. Detta stämmer överens med O(logN) tidskomplexiteten av hittandet av root som används för att kontrollera om två noder är anslutna.

### Tillväxtförhållande (Ratio, finns i tabellen):

Tillväxtförhållandet ger insikt i hur exekveringstiden multipliceras när indatastorleken fördubblas.

UnionFind Union: Tillväxtförhållandet för UnionFind union-metoden ökar konsekvent, vilket indikerar ett mönster av exponentiell tillväxt. Värdena varierar från 3.0021 till 3.8679, vilket tyder på att exekveringstiden multipliceras med en faktor på ungefär 3 till 4 när indatastorleken fördubblas.

UnionFind Connected:
Tillväxtförhållandet för UnionFind connected-metoden varierar från 1.1476 till 2.0767, vilket indikerar ett tillväxtmönster som är närmare linjärt.

WQUnionFind Union:
Tillväxtförhållandet för WQUnionFind union-metoden är relativt konsekvent, med värden som varierar från 1.8601 till 1.9625. Detta indikerar ett nära linjärt tillväxtmönster, där exekveringstiden multipliceras med en faktor av cirka 2 när indatastorleken fördubblas.

WQUnionFind Connected:
Tillväxtförhållandet för WQUnionFind connected-metoden är relativt konsekvent, med värden som varierar från 1.6834 till 1.9802. Detta tyder på ett nära linjärt tillväxtmönster.

### Log2-förhållande (Log2-Ratio, finns i tabellen):
Log2-förhållandet ger ett annat perspektiv på tillväxtmönstret genom att undersöka hur exekveringstiden fördubblas.

UnionFind Union:
Log2-förhållandets värden för UnionFind union-metoden ligger konsekvent runt 2, vilket tyder på att exekveringstiden fördubblas i en takt som är en potens av 2 av indatastorleken.

UnionFind Connected:
Log2-förhållandets värden för UnionFind connected-metoden varierar men ligger generellt sett under 2, vilket tyder på ett tillväxtmönster som är närmare linjärt.

WQUnionFind Union:
Log2-förhållandets värden för WQUnionFind union-metoden ligger nära 1, vilket indikerar ett tillväxtmönster som är närmare linjärt.

WQUnionFind Connected:
Log2-förhållandets värden för WQUnionFind connected-metoden ligger nära 1, vilket ytterligare bekräftar det linjära tillväxtmönstret.

### Slutsats:
UnionFind Union: Koden tyder på en linjär tidskomplexitet, O(N), vilket bekräftas av den empiriska datan. Tillväxtförhållandet och Log2-förhållandet validerar ytterligare denna linjära tillväxt.

WQUnionFind Union: Koden indikerar en logaritmisk tidskomplexitet, O(logN). Empiriska data, särskilt de mindre lutningsvärdena och tillväxtförhållandena nära 1, stöder detta.

UnionFind Connected: Koden förutsäger en konstant tid, O(1), vilket den empiriska datan stöder, vilket visar en nära linjär tillväxt.

WQUnionFind Connected: Koden tyder på O(logN) komplexitet. Den empiriska datan, särskilt lutningsvärdena, bekräftar en logaritmisk tillväxt.

### Jämförelse:
UnionFind union-metoden visar linjär tillväxt, medan WQUnionFind union-metoden är mer logaritmisk, vilket gör WQUnionFind mer skalbar för större dataset. Både UnionFind och WQUnionFind connected-metoderna är effektiva, men WQUnionFinds vägda metod erbjuder en något mer optimerad lösning.




# Uppgift 7

## Brute Force Three Sum Performance Table

| Array Size | Mean Execution (ns)    | Mean Execution (ms) | Standard Deviation (ns) | Standard Deviation (ms) |
|------------|------------------------|---------------------|-------------------------|-------------------------|
| 200        | 6058062.0              | 6.058062            | 577929.5562229          | 0.5779295562229         |
| 400        | 4.3473696E7            | 43.473696           | 633098.8974749          | 0.6330988974749         |
| 800        | 3.55105702E8           | 355.105702          | 1.1616356557346E7       | 11.616356557346         |
| 1600       | 2.75886969003E9        | 2758.86969003       | 3.4259537571397E7       | 34.259537571397         |
| 3200       | 2.166989755699E10      | 21669.89755699      | 6.3135758351614E7       | 63.135758351614         |

| Array Size | Mean Execution (ms) | Time Ratio | Log2 Ratio  |
|------------|---------------------|------------|-------------|
| 200        | 6.058062            | -          | -inf        |
| 400        | 43.473696           | 7.1762     | 2.8432      |
| 800        | 355.105702          | 8.1683     | 3.0300      |
| 1600       | 2758.86969003       | 7.7692     | 2.9578      |
| 3200       | 21669.89755699      | 7.8546     | 2.9735      |


## Two Pointer Three Sum Performance Table

| Array Size | Mean Execution (ns)    | Mean Execution (ms) | Standard Deviation (ns) | Standard Deviation (ms) |
|------------|------------------------|---------------------|-------------------------|-------------------------|
| 200        | 57409.0                | 0.057409            | 11662.4276632           | 0.0116624276632         |
| 400        | 267338.0               | 0.267338            | 28944.6429586           | 0.0289446429586         |
| 800        | 1408711.0              | 1.408711            | 614897.0216052          | 0.6148970216052         |
| 1600       | 4942752.87             | 4.94275287          | 1107770.4421021         | 1.1077704421021         |
| 3200       | 3.0356148E7            | 30.356148           | 1.3575565141757E7       | 13.575565141757         |

| Array Size | Mean Execution (ms) | Time Ratio | Log2 Ratio  |
|------------|---------------------|------------|-------------|
| 200        | 0.057409            | -          | -inf        |
| 400        | 0.267338            | 4.6567     | 2.2193      |
| 800        | 1.408711            | 5.2694     | 2.3976      |
| 1600       | 4.94275287          | 3.5087     | 1.8109      |
| 3200       | 30.356148           | 6.1415     | 2.6186      |

## Kod- och tidskomplexitetsanalys:

### BruteForceThreeSum:
Metoden bruteForceThreeSum använder tre nästlade loopar för att iterera över arrayen. Den har dock ett villkor som säkerställer att samma index inte används mer än en gång. Detta minskar något antalet iterationer, men ändrar inte den övergripande tidskomplexiteten. Operationerna inuti looparna är operationer med konstant tid (till exempel åtkomst av array, addition och jämförelse). Därför är den övergripande tidskomplexiteten: O(N^3). Detta är det sämsta, genomsnittliga och bästa fallet, eftersom looparna alltid körs för hela arrayens längd.

### TwoPointerThreeSum:
Metoden twoPointerThreeSum sorterar först arrayen, vilket tar O(NlogN) tid. Efter sorteringen använder den en enkel loop och två pekare för att hitta de tre nummer som summerar till noll. Operationerna inuti loopen och while-loopen är operationer med konstant tid. Därför är den övergripande tidskomplexiteten: O(N log N) + O(N^2) = O(N^2). Detta beror på att O(N^2) dominerar O(NlogN). Detta är det sämsta och genomsnittliga fallet. Det bästa fallet är när arrayen redan är sorterad, men tidskomplexiteten kvarstår på grund av den yttre loopen och den tvåpekareansatsen.

## Empirisk analys:

### Lutning:

Brute Force Three Sum:
- Lutning mellan 200 och 400: 0.18707817
- Lutning mellan 400 och 800: 0.781580015
- Lutning mellan 800 och 1600: 3.00351999
- Lutning mellan 1600 och 3200: 11.819392417

Two Pointer Three Sum:
- Lutning mellan 200 och 400: 0.001049645
- Lutning mellan 400 och 800: 0.002853465
- Lutning mellan 800 och 1600: 0.00441704835
- Lutning mellan 1600 och 3200: 0.015882747565

Brute Force: Lutningsvärdena som beräknats för Brute Force-metoden visar en betydande ökning när indatastorleken växer. Detta indikerar polynomisk tillväxt. Dem tre nästlade loopar i algoritmen antyder att tillväxten är kubisk: O(N^3). Detta innebär att för varje enhetsökning i indatastorleken ökar exekveringstiden med en faktor av indatastorleken upphöjt till tre. Denna snabba ökning av exekveringstiden med ökande indatastorlek är ett kännetecken för polynomisk tillväxt.

Two Pointer: Lutningsvärdena för Two Pointer-metoden är mycket mindre i jämförelse. Detta indikerar att exekveringstiden inte ökar lika snabbt med tillväxten i indatastorleken. Algoritmens design, som sorterar arrayen och sedan använder två pekare för att hitta summan, tyder på ett tillväxtmönster som är mer linjärt eller logaritmiskt. Sorteringssteget har en komplexitet av O(NlogN), och den tvåpekarsökningssteget är O(N), vilket gör den totala komplexiteten till O(NlogN).

#### Tillväxtförhållande (Ratio, finns i tabell):

Brute Force: Ett konsekvent tillväxtförhållande på runt 7-8 gånger indikerar att exekveringstiden konsekvent multipliceras med denna faktor när indatastorleken fördubblas. Detta bekräftar på nytt det polynomiska tillväxtmönstret, eftersom den tid som tas växer i en takt som är en potens av indatastorleken.

Two Pointer: Det varierande men generellt lägre tillväxtförhållandet för Two Pointer-metoden indikerar att dess exekveringstid inte multipliceras lika snabbt med ökande indatastorlek. Detta är konsekvent med ett mer linjärt eller logaritmiskt tillväxtmönster.

### Log2-förhållande (Log2-Ratio, finns i tabell):

Brute Force: Ett konsekvent Log2-förhållande runt 3 för Brute Force-metoden antyder att den tid som tas fördubblas i en takt som är en potens av 3 av indatastorleken, vilket ytterligare bekräftar det kubiska tillväxtmönstret.

Two Pointer: Det varierande Log2-förhållandet för Two Pointer-metoden, som generellt sett är lägre, indikerar ett tillväxtmönster som är närmare linjärt eller logaritmiskt. Detta innebär att den tid som tas fördubblas i en takt som är linjär eller logaritmisk i förhållande till indatastorleken.

### Slutsats och jämförelse:

Det kubiska tillväxtmönstret innebär att Brute Force-metodens exekveringstid kommer att öka mycket snabbt. Detta gör den opraktisk för större dataset, eftersom den tid som tas kan bli orimligt lång. Det linjära eller logaritmiska tillväxtmönstret för Two Pointer-metoden innebär att den skalar mycket bättre med större input. Dess exekveringstid ökar i en mycket långsammare takt jämfört med Brute Force-metoden, vilket gör den mer lämplig för större dataset.