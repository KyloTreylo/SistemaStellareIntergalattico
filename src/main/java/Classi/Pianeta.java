package Classi;

import java.util.HashMap;
import java.util.Scanner;

public class Pianeta extends CorpoCeleste{
    private Codice codice;
    private static Codice ultimoCodice= new Codice ( "P",00000);
    private Stella  stella;
    private double raggioOrbita;

    private HashMap<Codice, Luna > lune = new HashMap<>();


    public Pianeta(double massa, int posizioneX, int posizioneY, String nome, Stella stella, double orbita) {
        super(massa, posizioneX, posizioneY, nome);
        this.stella = stella;
        this.raggioOrbita  = orbita;

        this.codice = ultimoCodice.nuovo(ultimoCodice);
        ultimoCodice = this.codice ;
    }

    public boolean aggiungiLuna (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il nome della luna");
        String nome = scanner.nextLine();
        System.out.println("Inserisci la posizione X della luna");
        int posX = scanner.nextInt();
        System.out.println("Inserisci la posizione Y della luna");
        int posY = scanner.nextInt();
        System.out.println("Inserisci la massa della luna");
        int massa = scanner.nextInt();
        System.out.println("Inserisci il raggio dell'orbita della luna");
        int raggio = scanner.nextInt();

        try{
            Luna ciao = new Luna(massa, posX, posY, nome, raggio,  this.getNome(), this.codice);
            lune.put(ciao.getCodice(), ciao );
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean rimuoviLuna (Codice rimossione){
        try{
            lune.remove(rimossione);
            return true;
            }
        catch (Exception e){
            return false;
        }
    }

    public Luna cercaLuna (Codice cerca){
        if(!lune.isEmpty()) {
            Luna temp = lune.get(cerca);
                if ( temp == null  ){
                    System.out.println("Nessuna luna con questo codice è stata trovata attorno a questo pianeta");
                    return null;
                }else{
                    return temp;
                }
        }else
        {
            System.out.println("Questo pianeta non ha lune orbitanti attorno a se, quindi la luna che stai cercando non puù essere qua");
            return null;
        }
    }


}
