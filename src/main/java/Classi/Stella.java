package Classi;

import java.util.HashMap;
import it.kibo.fp.lib.InputData;

/**
 * Rappresenta un corpo celeste, nello specifico una Stella
 */
public class Stella extends CorpoCeleste{

    /* -------- STATICI & COSTANTI UTIL --------- */
    /**
     * Numero massimo di pianeti che possono orbitare attorno a questa stella.
     */
    private static final int MAX_PianetiPerStella = 26000;
    /**
     * Codice univoco che tiene traccia dell'ultimo pianeta creato, utilizzando
     * una lettera e un numero sequenziale.
     */
    private static final Codice ultimoCodice = new Codice("S", 0); // Togliere final se si lavora con più stelle

    /* -------- ATTRIBUTI ISTANZA --------- */
    /**
     * Mappa contenente tutti i pianeti associati a questa stella.
     * Ogni pianeta è identificato da un codice univoco.
     */
    private final HashMap<Codice, Pianeta> pianeti = new HashMap<>();

    /* -------- COSTRUTTORE --------- */

    /**
     * Costruisce un oggetto Stella con i dati specificati e un nuovo codice univoco.
     *
     * @param massa      la massa della stella
     * @param posizioneX la posizione X della stella
     * @param posizioneY la posizione Y della stella
     * @param nome       il nome della stella
     */
    public Stella(double massa, int posizioneX, int posizioneY, String nome) {
        super(nome, massa, posizioneX, posizioneY, ultimoCodice.nuovo());
        // Utilizzo il metodo Costruttore di CorpoCeleste che ho ereditato
    }


    /*============================
            METODI ISTANZA
    =============================*/


    // - Getters -

    /**
     * Restituisce il numero di pianeti attualmente associati a questa stella.
     *
     * @return il numero di pianeti associati alla stella
     */
    public int getNumeroPianeti() {
        return pianeti.size();
    }

    /**
     * Calcola le coordinate X e Y del centro di massa del sistema, considerando
     * la stella, i pianeti e le loro lune.
     *
     * @return un array di due elementi, dove il primo è la coordinata X e il secondo
     * la coordinata Y del centro di massa
     */
    public double[] centroDiMassa() {
        double numeratoreX = this.getMassa() * this.getPosizioneX();
        double numeratoreY = this.getMassa() * this.getPosizioneY();
        double denominatore = this.getMassa();

        for (Pianeta pianeta : pianeti.values()) {
            for (Luna luna : pianeta.getLune().values()) {
                numeratoreX += pianeta.getPosizioneX() * luna.getMassa();
                numeratoreY += pianeta.getPosizioneY() * luna.getMassa();
                denominatore += luna.getMassa();
            }
            numeratoreX += pianeta.getPosizioneX() * pianeta.getMassa();
            numeratoreY += pianeta.getPosizioneY() * pianeta.getMassa();
            denominatore += pianeta.getMassa();
        }

        double centroX = Math.floor((numeratoreX / denominatore) * 1e7) / 1e7;
        double centroY = Math.floor((numeratoreY / denominatore) * 1e7) / 1e7;
        return new double[]{centroX, centroY};
    }

    public boolean aggiungiPianeta(){
        // Da gestire l'input utente e poi inserire nella HashMap il nuovo pianeta
        return false;
    }

    /**
     * Aggiunge una nuova luna a uno dei pianeti esistenti nel sistema. Richiede la selezione del pianeta
     * e l'inserimento dei dati della luna.
     *
     * @return {@code true} se la luna è stata aggiunta con successo, {@code false} in caso di errore
     */
    public boolean aggiungiLuna() {
        try {

            // Scelta del pianeta a cui aggiungere la luna
            System.out.println("""
                Scegli il pianeta a cui aggiungere la luna,
                se un pianeta non compare nella lista è perché ha già un numero di lune massimo (5000).
                \s
                Inserisci il numero del pianeta:
            """);

            int index = 1;
            for (Pianeta pianeta : pianeti.values()) {
                if (!pianeta.cercaDisponibilita()) {
                    System.out.println(index + ". " + pianeta.getNome() + " (Codice: " + pianeta.getCodice() + ")");
                    index++;
                }
            }
            int scelta = InputData.readIntegerBetween("Inserisci il numero del pianeta:", 1, pianeti.size());
            Pianeta pianetaScelto = (Pianeta) pianeti.values().toArray()[scelta - 1];

            pianetaScelto.aggiungiLuna();

            return true;
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
            return false;
        }
    }


    /**
     * Rimuove un pianeta specifico dal sistema utilizzando il codice univoco del pianeta.
     *
     * @param codiceRimuovere il codice univoco del pianeta da rimuovere
     * @return {@code true} se il pianeta è stato rimosso con successo, {@code false} altrimenti
     */
    private boolean rimuoviPianeta(Codice codiceRimuovere) {
        if (pianeti.containsKey(codiceRimuovere)) {
            pianeti.remove(codiceRimuovere);
            System.out.println("Pianeta rimosso con successo.");
            return true;
        } else {
            System.out.println("Il pianeta con codice '" + codiceRimuovere.toString() + "' non è presente nel sistema.");
            return false;
        }
    }
    /**
     * Rimuove una luna specifica dal sistema utilizzando il codice univoco della luna.
     *
     * @param codiceRimuovere il codice univoco della luna da rimuovere
     * @return {@code true} se la luna è stata rimossa con successo, {@code false} altrimenti
     */
    private boolean rimuoviLuna(Codice codiceRimuovere) {
        for (Pianeta pianeta : pianeti.values()) {
            if (pianeta.getLune().containsKey(codiceRimuovere)) {
                return pianeta.rimuoviLuna(codice);
            }
        }
        System.out.println("La luna con codice '" + codiceRimuovere.toString() + "' non è presente nel sistema.");
        return false;
    }

    /**
     * Rimuove un corpo celeste (pianeta o luna) dal sistema identificato tramite il suo codice univoco.
     *
     * @return {@code true} se il corpo celeste è stato rimosso con successo, {@code false} in caso di errore
     */
    public boolean rimuoviCorpoCeleste() {
        try {
            // Richiedi il codice del corpo celeste da rimuovere
            String codiceInput = InputData.readString("Inserisci il codice del corpo celeste da rimuovere: ", true).toUpperCase();

            // Verifica se il codice è valido
            while (Codice.controlloInvaliditaCodice(codiceInput)) {
                System.out.println("Codice non valido! Deve iniziare con S, P o L seguito dai numeri.");
                codiceInput = InputData.readString("Reinserisci un codice valido: ", true).toUpperCase();
            }

            // Converte il codice in un oggetto Codice
            Codice codiceRimuovere = Codice.valueOf(codiceInput);

            // Controlla il tipo di corpo celeste e rimuove di conseguenza
            if (codiceInput.startsWith("P")) {
                return rimuoviPianeta(codiceRimuovere);
            } else if (codiceInput.startsWith("L")) {
                return rimuoviLuna(codiceRimuovere);
            } else if (codiceInput.startsWith("S")) {
                System.out.println("Non puoi rimuovere la stella centrale del sistema.");
                return false;
            } else {
                System.out.println("Codice non gestito.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
            return false;
        }
    }


    /**
     * Cerca la stella nel sistema basandosi sul codice univoco.
     *
     * @param codiceRicerca il codice univoco della stella
     * @return la stella associata al codice, oppure {@code null} se non è stata trovata
     */
    private CorpoCeleste cercaStella(Codice codiceRicerca) {
        if (this.codice.equals(codiceRicerca)) {
            System.out.println("La stella cercata è quella di questo sistema\n");
            return this;
        }
        // Da cambiare se più sistemi
        else {
            System.out.println(
                    "Stella non esistente.\nAl momento esiste solo una stella ("
                            .concat(this.codice.toString())
                            .concat("), quindi un solo sistema di pianeti\n")
            );
            return null;
        }
    }
    /**
     * Cerca un pianeta nel sistema utilizzando il codice univoco.
     *
     * @param codiceRicerca il codice univoco del pianeta
     * @return il pianeta associato al codice, oppure {@code null} se non è stato trovato
     */
    private CorpoCeleste cercaPianeta(Codice codiceRicerca) {
        // Itero tutti i pianeti
        for (Codice key : pianeti.keySet()) {
            if (key.equals(codiceRicerca)) {
                return pianeti.get(key);
            }
        }
        System.out.println("Il pianeta '".concat(codiceRicerca.toString()).concat("' non è presente in questo sistema"));
        return null;
    }
    /**
     * Cerca una luna nel sistema, iterando attraverso tutti i pianeti e le loro lune,
     * basandosi sul codice univoco fornito.
     *
     * @param codiceRicerca il codice univoco della luna
     * @return la luna associata al codice, oppure {@code null} se non è stata trovata
     */
    private CorpoCeleste cercaLuna(Codice codiceRicerca) {
        // Itero tutte le lune di tutti i pianeti usando il metodo della classe pianeta
        for (Pianeta pianeta : pianeti.values()) {
            return pianeta.cercaLuna(codiceRicerca);
        }
        System.out.println("La luna '".concat(codiceRicerca.toString()).concat("' non è presente in questo sistema"));
        return null;
    }

    /**
     * Cerca un corpo celeste in base al suo codice univoco e ne restituisce l'oggetto.
     *
     * @return il corpo celeste associato al codice, oppure {@code null} se non è stato trovato
     */
    public CorpoCeleste cercaCorpoCeleste() {
        String codice = InputData.readString("Inserisci il codice del corpo celeste da cercare :", true).toUpperCase();
        while(Codice.controlloInvaliditaCodice(codice)){
            System.out.print("Codice non valido! Deve iniziare con S, P o L seguito dai numeri");
            codice = InputData.readString("\nReinserisci il codice: ", true).toUpperCase();
        }

        // Rendo la stringa fornita dall'utente un vero e proprio oggetto Codice
        Codice codiceRicerca = Codice.valueOf(codice);

        // Controllo di che tipo di corpo celeste stiamo parlando
        return switch (codiceRicerca.getLettera()) {
            case "S" -> cercaStella(codiceRicerca);
            case "P" -> cercaPianeta(codiceRicerca);
            case "L" -> cercaLuna(codiceRicerca);
            default -> null;
        };
    }

    // Metodo da usare prima di aggiungere un nuovo pianeta alla stella, controlla se ci sono meno di 26000 pianeti sulla stella

    /**
     * Controlla se è ancora possibile aggiungere nuovi pianeti alla stella.
     *
     * @return {@code true} se c'è ancora spazio per altri pianeti, {@code false} altrimenti
     */
    public boolean cercaDisponibilita() {
        return pianeti.size() < MAX_PianetiPerStella;
    }

    /**
     * Sovrascrive il metodo toString per fornire una rappresentazione del contenuto formattata come stringa.
     * Contiene i dettagli della stella, seguiti da una lista dei pianeti con il numero di lune associate.
     * Generato con AI di IntelliJ IDEA Ultimate
     */
    @Override
    public String toString() {
        StringBuilder pianetiDettagli = new StringBuilder();
        for (Pianeta pianeta : pianeti.values()) {
            pianetiDettagli.append(String.format(
                    """
                            ----------------------------
                            Nome: %s
                            Codice: %s
                            Numero di Lune: %d
                            """,
                    pianeta.getNome(), pianeta.getCodice(), pianeta.getNumeroLune()
            ));
        }

        return String.format(
                """
                        ================================
                                 Dettagli Stella
                        ================================
                        Nome: %s
                        Massa: %.2f
                        Posizione: (%d, %d)
                       \s
                        ----------------------------
                       \s
                          Pianeti Associati
                       \s
                        %s
                       \s""",
                this.getNome(), this.getMassa(), this.getPosizioneX(), this.getPosizioneY(),
                pianetiDettagli.toString()
        );
    }
}

/*package Classi;
import java.util.HashMap;
import it.kibo.fp.lib.InputData;

public class Stella{
    private HashMap<String, String> pianeti;

    public Stella(){
        pianeti = new HashMap<>();
    }

    public boolean codiceValido(String codice){
        return codice.matches("^P\\d+$");
    }

    public void cercaPianeta(){
        codice = InputData.readChar("Inserisci il codice del pianeta da cercare :");
        while(!codiceValido(codice)){
            System.out.print("Codice non valido! Deve iniziare con 'P seguito dai numeri");
            codice = InputData.readChar("Reinserisci il codice: ");

        }
        if(pianeti.containsKey(codice)){
            System.out.println("Pianeta trovato :" + pianeti.get(codice));
        }else{System.out.println("Pianeta non è presente in questo sistema");}
    }

}*/