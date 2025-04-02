package Classi;

/**
 * Rappresenta un corpo celeste con un nome, una massa, una posizione nello spazio
 * e un codice identificativo.
 */
public class CorpoCeleste {

    /* -------- ATTRIBUTI ISTANZA --------- */
    final double massa;
    final int[] posizione = new int[2];
    String nome;
    final Codice codice;

    /* -------- COSTRUTTORE --------- */

    /**
     * Crea un nuovo oggetto CorpoCeleste.
     *
     * @param nome       Il nome del corpo celeste.
     * @param massa      La massa del corpo celeste.
     * @param posizioneX La posizione X del corpo celeste nello spazio.
     * @param posizioneY La posizione Y del corpo celeste nello spazio.
     * @param codice     Il codice identificativo associato al corpo celeste.
     */
    public CorpoCeleste(String nome, double massa, int posizioneX, int posizioneY, Codice codice) {
        this.massa = massa;
        this.codice = codice;
        this.posizione[0] = posizioneX;
        this.posizione[1] = posizioneY;
        this.nome = nome;
    }


    /*============================
            METODI ISTANZA
    =============================*/


    // Getters

    /**
     * Restituisce la posizione X del corpo celeste.
     *
     * @return La posizione X del corpo celeste.
     */
    public int getPosizioneX() {
        return posizione[0];
    }

    /**
     * Restituisce la posizione Y del corpo celeste.
     *
     * @return La posizione Y del corpo celeste.
     */
    public int getPosizioneY() {
        return posizione[1];
    }

    /**
     * Restituisce il nome del corpo celeste.
     *
     * @return Il nome del corpo celeste.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Restituisce la massa del corpo celeste.
     *
     * @return La massa del corpo celeste.
     */
    public double getMassa() {
        return massa;
    }

    /**
     * Restituisce il codice identificativo del corpo celeste.
     *
     * @return Il codice identificativo del corpo celeste.
     */
    public Codice getCodice() {
        return codice;
    }

    // Setters

    /**
     * Modifica il nome del corpo celeste.
     *
     * @param nome Il nuovo nome del corpo celeste.
     */
    public void setNome(String nome) {
        this.nome = nome;
    } // Lasciamo la possibilità di modificare il nome di un Corpo Celeste
}