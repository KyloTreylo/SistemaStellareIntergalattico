package Classi;

import java.util.HashMap;
import it.kibo.fp.lib.InputData;

public class Stella extends CorpoCeleste{

    /* -------- STATICI & COSTANTI UTIL --------- */
    // Numero massimo di lune per ogni pianeta
    private static final int MAX_PianetiPerStella = 26000;
    // Codice dell'ultimo pianeta creato
    private static Codice ultimoCodice = new Codice ( "S", 0);

    /* -------- ATTRIBUTI ISTANZA --------- */
    // Mappa di tutti i pianeti della stella
    private final HashMap<Codice, Pianeta> pianeti = new HashMap<>();

    /* -------- COSTRUTTORE --------- */
    public Stella(double massa, int posizioneX, int posizioneY, String nome) {
        super(nome, massa, posizioneX, posizioneY, ultimoCodice.nuovo()); // Utilizzo il metodo Costruttore di CorpoCeleste che ho ereditato
    }


    /*============================
            METODI ISTANZA
    =============================*/


    // Getters
    public int getNumeroPianeti() {
        return pianeti.size();
    }

    public boolean aggiungiPianeta(){
        // Da gestire l'input utente e poi inserire nella HashMap il nuovo pianeta
        return false;
    }

    public boolean aggiungiLuna() {
        return false;
    }

    public boolean rimuoviPianeta(){
        // Da gestire l'input utente del codice pianeta e rimuoverlo dalla HashMap
        return false;
    }

    // Metodo che cerca un pianeta e ne ritorna l'oggetto
    public Pianeta cercaPianeta(){
        String codice = InputData.readString("Inserisci il codice del pianeta da cercare :", true);
        while(!Codice.controlloValiditaCodice(codice, "P")){
            System.out.print("Codice non valido! Deve iniziare con 'P seguito dai numeri");
            codice = InputData.readString("Reinserisci il codice: ", true);
        }

        Codice codicePianeta = Codice.valueOf(codice);
        for (Codice key : pianeti.keySet()) {
            if (key.equals(codicePianeta)) {
                return pianeti.get(key);
            }
        }
        System.out.println("Il pianeta '".concat(codice).concat("' non è presente in questo sistema"));
        return null;
    }

    // Metodo da usare prima di aggiungere un nuovo pianeta alla stella, controlla se ci sono meno di 26000 pianeti sulla stella
    public boolean cercaDisponibilita(){
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
                        
                        ----------------------------
                          Pianeti Associati
                        
                        %s
                        """,
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