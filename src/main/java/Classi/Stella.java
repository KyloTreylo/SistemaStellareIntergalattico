package Classi;
import java.util.ArrayList;

public class Stella extends CorpoCeleste{
    private ArrayList<Pianeta> pianeti = new ArrayList<>();

    public Stella(double massa, int posizioneX, int posizioneY, String codice, String nome) {
        super(massa, posizioneX, posizioneY, codice, nome);
    }

    public boolean addPianeta (){
        System.out.println("Inserisci il nome del ");
        pianeti.add(new Pianeta());

    }
}
