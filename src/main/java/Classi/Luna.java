package Classi;

public class Luna extends CorpoCeleste{

    /* -------- STATICI & COSTANTI UTIL --------- */
    private static Codice ultimoCodice = new Codice("L", 0);
    
    /* -------- ATTRIBUTI ISTANZA --------- */
    private final Pianeta pianeta;
    private final double raggioOrbita;

    /* -------- COSTRUTTORE --------- */
    public Luna(String nome, double massa, int posizioneX, int posizioneY, int orbita, Pianeta pianeta) {
        super(nome, massa, posizioneX, posizioneY, ultimoCodice.nuovo()); // Utilizzo il metodo Costruttore di CorpoCeleste che ho ereditato
        this.raggioOrbita  = orbita;
        this.pianeta = pianeta;

        ultimoCodice = this.codice ;
    }


    /*============================
            METODI ISTANZA     
    =============================*/


    public Codice getCodice() {
        return this.codice;
    }

     /**
     * Sovrascrive il metodo toString per fornire una rappresentazione del contenuto formattata come stringa.
     * Contiene prima i dettagli della luna, seguiti da un riepilogo del pianeta associato.
     * Generato con AI di IntelliJ IDEA Ultimate
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
                        Nome: %s
                        Codice Pianeta: %s
                        """,
                this.getNome(), this.getMassa(), this.getPosizioneX(), this.getPosizioneY(),
                this.codice, this.raggioOrbita, pianeta.getNome(), pianeta.getCodice()
        );
    }
}
