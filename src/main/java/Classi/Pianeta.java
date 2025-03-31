package Classi;

import java.util.HashMap;
import java.util.Scanner;

public class Pianeta extends CorpoCeleste{

    /* -------- STATICI & COSTANTI UTIL --------- */
    // Numero massimo di lune per ogni pianeta
    private static final int MAX_LunePerPianeta = 5000;
    // Codice dell'ultimo pianeta creato
    private static Codice ultimoCodice = new Codice ( "P", 0);

    /* -------- ATTRIBUTI ISTANZA --------- */
    private final Stella stella;
    private final double raggioOrbita;
    // Mappa di tutte le lune del pianeta
    private final HashMap<Codice, Luna > lune = new HashMap<>();

    /* -------- COSTRUTTORE --------- */
    public Pianeta(String nome, double massa, int posizioneX, int posizioneY, Stella stella, double orbita) {
        super(nome, massa, posizioneX, posizioneY, ultimoCodice.nuovo()); // Utilizzo il metodo Costruttore di CorpoCeleste che ho ereditato
        this.stella = stella;
        this.raggioOrbita = orbita;

        ultimoCodice = this.codice ;
    }
    
    
    /*============================
            METODI ISTANZA     
    =============================*/


    // Getters
    public int getNumeroLune() {
        return lune.size();
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
            Luna ciao = new Luna(nome, massa, posX, posY, raggio, this);
            lune.put(ciao.getCodice(), ciao );
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean rimuoviLuna (Codice codice){
        try{
            lune.remove(codice);
            return true;
            }
        catch (Exception e){
            return false;
        }
    }

    public Luna cercaLuna (Codice codice){
        if(!lune.isEmpty()) {
            Luna temp = lune.get(codice);
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
    
    // Metodo da usare prima di aggiungere un nuovo pianeta alla stella, controlla se ci sono meno di 5000 lune sul pianeta
    public boolean cercaDisponibilita(){
        return lune.size() < MAX_LunePerPianeta;
    }

    /**
     * Sovrascrive il metodo toString per fornire una rappresentazione del contenuto formattata come stringa.
     * Contiene prima i dettagli del pianeta, seguiti da un elenco delle lune orbitanti.
     * Generato con AI di IntelliJ IDEA Ultimate
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(
                """
                        ================================
                                 Dettagli Pianeta
                        ================================
                        Nome: %s
                        Massa: %.2f
                        Posizione: (%d, %d)
                        Codice: %s
                        Raggio Orbita: %.2f km
                        Stella: %s (%s)
                        
                        ----------------------------
                               Lune Orbitanti
                        ----------------------------
                        """,
                this.getNome(), this.getMassa(), this.getPosizioneX(), this.getPosizioneY(),
                this.codice, this.raggioOrbita, stella.getNome(), stella.getCodice()
        ));

        if (lune.isEmpty()) {
            sb.append("Nessuna luna presente attorno a questo pianeta.\n");
        } else {
            lune.forEach((codice, luna) -> sb.append(String.format("Nome: %s (%s)\n", luna.getNome(), codice)));
        }

        return sb.toString();
    }
}
