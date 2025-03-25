package Classi;
import java.util.ArrayList;
import java.util.Scanner;

public class Stella extends CorpoCeleste{
    private ArrayList<Pianeta> pianeti = new ArrayList<>();

    public Stella(double massa, int posizioneX, int posizioneY, String nome) {
        super(massa, posizioneX, posizioneY, nome);
    }

    public boolean aggiungiPianeta (){
        System.out.println("Inserisci il codice del pianeta: ");
        pianeti.add(new Pianeta());

    }

    public boolean rimuoviPianeta(){
        System.out.println("Inserisci il codice del pianeta: ");
        pianeti.remove(Pianeta());

    }

    private Pianeta cercaPianeta(Codice){
    
    }


}
