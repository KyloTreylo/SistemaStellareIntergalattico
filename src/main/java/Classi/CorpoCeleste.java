package Classi;

public class CorpoCeleste {

    /* -------- ATTRIBUTI ISTANZA --------- */
    final double massa;
    final int[] posizione = new int[2];
    String nome;
    final Codice codice;

    /* -------- COSTRUTTORE --------- */
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
    public int getPosizioneX() {
        return posizione[0];
    }
    public int getPosizioneY() {
        return posizione[1];
    }
    public String getNome() {
        return nome;
    }
    public double getMassa() {
        return massa;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    } // Lasciamo la possibilità di modificare il nome di un Corpo Celeste
}