package Classi;

public class Luna extends CorpoCeleste{

    private Codice codice ;
    static Codice ultimoCodice = new Codice("L", 0000);
    private Codice codicePianeta;
    private String nomePianeta;
    private double raggioOrbita;

    public Luna(double massa, int posizioneX, int posizioneY, String nome, int orbita, String noemPianeta, Codice codicePianeta) {
        super(massa, posizioneX, posizioneY, nome);
        this.codicePianeta = codicePianeta;
        this.raggioOrbita  = orbita;
        this.nomePianeta=noemPianeta;

        this.codice = ultimoCodice.nuovo(ultimoCodice);

        ultimoCodice = this.codice ;
    }


    public Codice getCodice (){
        return this.codice;
    }

    public String toString() {
        return "Luna :  " + this.getNome()  +
                "\t\tcodice=" + codice +
                "\n Orbita attorno al pianeta '" + nomePianeta +"' ('"+codicePianeta+"') con un  orbita di " + raggioOrbita + " km\n";
    }
}
