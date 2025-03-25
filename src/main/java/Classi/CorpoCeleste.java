package Classi;
public class CorpoCeleste {
    private double massa;
    private int posizione[] = new int[2];
    private String nome;

    public CorpoCeleste(double massa, int posizioneX, int posizioneY, String nome) {
        this.massa = massa;
        this.posizione[0] = posizioneX;
        this.posizione[1] = posizioneY;
        this.nome = nome;
    }

    public double getMassa() {
        return massa;
    }

    public int getPosizioneX() {
        return posizione[0];
    }

    public int getPosizioneY() {
        return posizione[1];
    }
    public String getNome() {
        return nome;
    }

}