package Classi;
public class CorpoCeleste {
    private double massa;
    private int posizioneX;
    private int posizioneY;
    private String codice;
    private String nome;

    public CorpoCeleste(double massa, int posizioneX, int posizioneY, String codice, String nome) {
        this.massa = massa;
        this.posizioneX = posizioneX;
        this.posizioneY = posizioneY;
        this.nome = nome;
    }

    public double getMassa() {
        return massa;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }

    public int getPosizioneX() {
        return posizioneX;
    }

    public void setPosizioneX(int posizioneX) {
        this.posizioneX = posizioneX;
    }

    public int getPosizioneY() {
        return posizioneY;
    }

    public void setPosizioneY(int posizioneY) {
        this.posizioneY = posizioneY;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
