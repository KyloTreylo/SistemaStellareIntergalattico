# Gestione del Sistema Stellare
### Descrizione
Questo progetto Java consente la gestione di un sistema stellare composto da corpi celesti come stelle, pianeti e lune. È pensato per simulare le interazioni principali tra gli elementi astronomici e fornire funzionalità per la modifica e l'analisi dinamica del sistema. Il codice è progettato con un'architettura modulare, facilitando l'espansione e la manutenzione.
### Funzionalità principali
- **Gestione delle Stelle**:
    - Creazione di stelle con massa e posizione definite.
    - Calcolo del centro di massa del sistema stellare.

- **Gestione dei Pianeti**:
    - Aggiunta di nuovi pianeti associati a una stella.
    - Rimozione di pianeti dal sistema utilizzando un codice univoco.

- **Gestione delle Lune**:
    - Aggiunta e rimozione di lune a pianeti specifici.

- **Calcolo delle Proprietà del Sistema**:
    - Calcolo dinamico del centro di massa dell’intero sistema, considerando stelle, pianeti e lune.

- **Persistenza e identificazione tramite codice univoco**:
    - Tutti i corpi celesti all'interno di una stella sono identificati tramite un codice sequenziale unico.

### Requisiti
- **Java**: Versione 8 o superiore
- **Librerie esterne**:
    - `it.kibo.fp.lib.InputData` per la gestione dell'input dati.

### Struttura del Codice
Il progetto è organizzato in package per migliorare la gestione e il riutilizzo del codice:
1. **Classi principali**:
    - `Stella`: La classe principale per rappresentare una stella e i suoi corpi celesti associati.
    - `CorpoCeleste`: Classe base per tutti gli oggetti astronomici (stella, pianeta, luna, ecc.).
    - `Pianeta`, `Luna`: Classi derivate per rappresentare rispettivamente i pianeti e le lune.

2. **Metodi principali**:
    - **Creazione e gestione dei corpi celesti**:
        - Metodi per aggiungere/rimuovere pianeti e lune.

    - **Calcoli astronomici**:
        - Calcolo del centro di massa del sistema.

    - **Sistema di identificazione**:
        - Gestione automatizzata dei codici univoci associati a ogni corpo celeste.

### Esempio di utilizzo
``` java
// Creazione di una stella
Stella stella = new Stella(1.989E30, 0, 0, "Sole");

// Aggiunta di un pianeta
stella.aggiungiPianeta();

// Calcolo del centro di massa del sistema
double[] centroMassa = stella.centroDiMassa();
System.out.println("Centro di Massa: X=" + centroMassa[0] + ", Y=" + centroMassa[1]);

// Rimozione di un pianeta
stella.rimuoviCorpoCeleste();
```
### Come eseguire il progetto
1. Clonare il repository:
``` bash
   git clone https://github.com/[nome-utente]/gestione-sistema-stellare.git
```
1. Aprire il progetto in un IDE Java (es. IntelliJ IDEA, Eclipse).
2. Compilare ed eseguire il progetto.
3. Seguire le istruzioni fornite per interagire con l'applicazione.

### Credits
- **Autore**: [TheNew&TheSeasoned (Nicola Moretta, Brandon Vezi, Diego Fausti)]
- **Tecnologie utilizzate**: Java SDK, IntelliJ IDEA
