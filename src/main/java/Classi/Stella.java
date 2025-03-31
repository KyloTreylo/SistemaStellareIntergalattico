package Classi;

import java.util.HashMap;
import it.kibo.fp.lib.InputData;

public class Stella extends CorpoCeleste{

    /* -------- STATICI & COSTANTI UTIL --------- */
    // Numero massimo di lune per ogni pianeta
    private static final int MAX_PianetiPerStella = 26000;

    /* -------- ATTRIBUTI ISTANZA --------- */
    // Mappa di tutti i pianeti della stella
    private HashMap<Codice, Pianeta> pianeti = new HashMap<>();

    /* -------- COSTRUTTORE --------- */
    public Stella(double massa, int posizioneX, int posizioneY, String nome) {
        super(nome, massa, posizioneX, posizioneY); // Utilizzo il metodo Costruttore di CorpoCeleste che ho ereditato
    }


    /*============================
            METODI ISTANZA
    =============================*/


    public boolean aggiungiPianeta (){
        // Da gestire l'input utente e poi inserire nella HashMap il nuovo pianeta
        return false;
    }

    public boolean rimuoviPianeta(){
        // Da gestire l'input utente del codice pianeta e rimuoverlo dalla HashMap
        return false;
    }

    // Metodo che cerca un pianeta e ne ritorna l'oggetto
    public Pianeta cercaPianeta(){
        codice = InputData.readChar("Inserisci il codice del pianeta da cercare :");
        while(!controllaValiditaCodice(codice)){
            System.out.print("Codice non valido! Deve iniziare con 'P seguito dai numeri");
            codice = InputData.readChar("Reinserisci il codice: ");

        }
        if(pianeti.containsKey(codice)){
            System.out.println("Pianeta trovato :" + pianeti.get(codice));
        }else{System.out.println("Pianeta non è presente in questo sistema");}
    }

    public boolean controllaValiditaCodice(Codice codice){
        return codice.getLettera().equals("P");

    }

    // Metodo da usare prima di aggiungere un nuovo pianeta alla stella
    // Controlla se ci sono meno di 26000 pianeti sulla stella
    public boolean cercaDisponibilita(){
        return pianeti.size() < MAX_PianetiPerStella;
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