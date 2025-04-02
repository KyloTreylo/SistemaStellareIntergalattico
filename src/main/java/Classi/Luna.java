package Classi;

/**
 * Rappresenta un corpo celeste, nello specifico una Luna
 */
public class Luna extends CorpoCeleste{

    /* -------- STATICI & COSTANTI UTIL --------- */
    private static Codice ultimoCodice = new Codice("L", 0);
    
    /* -------- ATTRIBUTI ISTANZA --------- */
    private final Pianeta pianeta;
    private final double raggioOrbita;

    /**
     * Costruisce una nuova istanza di Luna con i dati forniti.
     *
     * @param nome         Il nome della luna.
     * @param massa        La massa della luna.
     * @param posizioneX   La posizione X della luna nell'universo.
     * @param posizioneY   La posizione Y della luna nell'universo.
     * @param raggioOrbita Il raggio dell'orbita della luna in chilometri.
     * @param pianeta      Il pianeta a cui la luna è associata.
     */
    public Luna(String nome, double massa, int posizioneX, int posizioneY, double raggioOrbita, Pianeta pianeta) {
        super(nome, massa, posizioneX, posizioneY, ultimoCodice.nuovo()); // Utilizzo il metodo Costruttore di CorpoCeleste che ho ereditato
        this.raggioOrbita = raggioOrbita;
        this.pianeta = pianeta;

        ultimoCodice = this.codice;
    }


    /*============================
            METODI ISTANZA     
    =============================*/


    /**
     * Restituisce il codice unico associato alla luna.
     *
     * @return Il codice della luna.
     */
    public Codice getCodice() {
        return this.codice;
    }

    /**
     * Genera una rappresentazione testuale dettagliata della luna, comprensiva delle
     * sue proprietà e informazioni sul pianeta associato.
     *
     * @return Una stringa che rappresenta il contenuto dettagliato della luna.
     */
    @Override
    public String toString() {
        return String.format(
                """
                        ================================
                                 Dettagli Luna
                        ================================
                        Nome: %s
                        Massa: %.2f
                        Posizione: (%d, %d)
                        Codice: %s
                        Raggio Orbita: %.2f km
                        
                        ----------------------------
                          Pianeta Associato
                        ----------------------------
                        Nome: %s (%s)
                        """,
                this.getNome(), this.getMassa(), this.getPosizioneX(), this.getPosizioneY(),
                this.codice, this.raggioOrbita, pianeta.getNome(), pianeta.getCodice()
        );
    }
}
