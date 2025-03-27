package Classi;
import java.util.ArrayList;
import java.util.Scanner;
import it.kibo.fp.lib.InputData;

public class Stella extends CorpoCeleste{
    private ArrayList<Pianeta> pianeti = new ArrayList<>();

    public Stella(double massa, int posizioneX, int posizioneY, String nome) {
        super(massa, posizioneX, posizioneY, nome);
    }

    public boolean aggiungiPianeta (){
        pianeti = InputData.
        pianeti.add(new Pianeta());

    }

    public boolean rimuoviPianeta(){
        System.out.println("Inserisci il codice del pianeta: ");
        pianeti.remove(Pianeta());

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