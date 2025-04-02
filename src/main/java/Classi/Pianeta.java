package Classi;

import it.kibo.fp.lib.InputData;

import java.util.HashMap;

/**
 * Rappresenta un corpo celeste, nello specifico un Pianeta
 */
public class Pianeta extends CorpoCeleste{

    /* -------- STATICI & COSTANTI UTIL --------- */
    // Numero massimo di lune per ogni pianeta
    private static final int MAX_LunePerPianeta = 5000;
    // Codice dell'ultimo pianeta creato
    private static Codice ultimoCodice = new Codice ( "P", 0);

    /* -------- ATTRIBUTI ISTANZA --------- */
    private final Stella stella;
    private final double raggioOrbita;
    // Mappa di tutte le lune del pianeta
    private final HashMap<Codice, Luna > lune = new HashMap<>();

    /* -------- COSTRUTTORE --------- */

    /**
     * Costruisce un nuovo oggetto {@code Pianeta}.
     *
     * @param nome         Il nome del pianeta.
     * @param massa        La massa del pianeta.
     * @param posizioneX   La posizione X nel sistema di riferimento.
     * @param posizioneY   La posizione Y nel sistema di riferimento.
     * @param stella       La stella attorno alla quale orbita il pianeta.
     * @param raggioOrbita La distanza orbitale tra il pianeta e la stella in kilometri.
     */
    public Pianeta(String nome, double massa, int posizioneX, int posizioneY, Stella stella, double raggioOrbita) {
        super(nome, massa, posizioneX, posizioneY, ultimoCodice.nuovo()); // Utilizzo il metodo Costruttore di CorpoCeleste che ho ereditato
        this.stella = stella;
        this.raggioOrbita = raggioOrbita;

        ultimoCodice = this.codice;
    }
    
    
    /*============================
            METODI ISTANZA     
    =============================*/


    // Getters

    /**
     * Ottiene il numero di lune che orbitano attorno al pianeta.
     *
     * @return Il numero totale di lune.
     */
    public int getNumeroLune() {
        return lune.size();
    }

    /**
     * Restituisce una mappa contenente tutte le lune che orbitano attorno al pianeta.
     *
     * @return Una {@code HashMap} delle lune con i loro codici corrispondenti.
     */
    public HashMap<Codice, Luna> getLune() {
        return lune;
    }

    /**
     * Permette di aggiungere una nuova luna al pianeta attraverso input dell'utente.
     */
    public void aggiungiLuna() {
        // Inserimento dati per la luna
        String nome = InputData.readString("Inserisci il nome della luna: ", true);
        double massa = InputData.readDouble("Inserisci la massa della luna (kg): ");
        int posizioneX = InputData.readInteger("Inserisci la posizione X della luna (assoluta): ");
        int posizioneY = InputData.readInteger("Inserisci la posizione Y della luna (assoluta): ");
        double raggioOrbita = InputData.readDouble("Inserisci il raggio dell'orbita della luna: ");

        Luna nuovaLuna = new Luna(nome, massa, posizioneX, posizioneY, raggioOrbita, this);
        this.lune.put(nuovaLuna.getCodice(), nuovaLuna);
    }

    /**
     * Rimuove una luna associata al codice specificato dalla lista di lune del pianeta.
     *
     * @param codice Il codice identificativo della luna.
     * @return {@code true} se la luna è stata correttamente rimossa, {@code false} in caso contrario.
     */
    public boolean rimuoviLuna(Codice codice) {
        try {
            lune.remove(codice);
            System.out.println("Luna rimossa con successo.");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Cerca una luna tramite il suo codice identificativo.
     *
     * @param codice Il codice identificativo della luna da cercare.
     * @return La {@code Luna} corrispondente al codice se presente, altrimenti {@code null}.
     */
    public Luna cercaLuna(Codice codice) {
        for (Codice key : this.lune.keySet()) {
            if (key.equals(codice)) {
                return this.lune.get(key);
            }
        }
        return null;
    }

    // Metodo da usare prima di aggiungere una luna al pianeta, controlla se ci sono meno di 5000 lune sul pianeta

    /**
     * Verifica se è possibile aggiungere ulteriori lune al pianeta.
     *
     * @return {@code true} se il numero di lune è inferiore al limite massimo, {@code false} altrimenti.
     */
    public boolean cercaDisponibilita() {
        return lune.size() < MAX_LunePerPianeta;
    }

    /**
     * Sovrascrive il metodo toString per fornire una rappresentazione del contenuto formattata come stringa.
     * Contiene prima i dettagli del pianeta, seguiti da un elenco delle lune orbitanti.
     * Generato con AI di IntelliJ IDEA Ultimate
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(
                """
                        ================================
                                 Dettagli Pianeta
                        ================================
                        Nome: %s
                        Massa: %.2f
                        Posizione: (%d, %d)
                        Codice: %s
                        Raggio Orbita: %.2f km
                        Stella: %s (%s)
                        
                        ----------------------------
                               Lune Orbitanti
                        ----------------------------
                        """,
                this.getNome(), this.getMassa(), this.getPosizioneX(), this.getPosizioneY(),
                this.codice, this.raggioOrbita, stella.getNome(), stella.getCodice()
        ));

        if (lune.isEmpty()) {
            sb.append("Nessuna luna presente attorno a questo pianeta.\n");
        } else {
            lune.forEach((codice, luna) -> sb.append(String.format("Nome: %s (%s)\n", luna.getNome(), codice)));
        }

        return sb.toString();
    }
}
