package Classi;

/* Da decidere se usare
    private enum Lettera {
        P,
        L
    };
*/

public class Codice {

    /* -------- ATTRIBUTI ISTANZA --------- */
    private final int numero;
    private final String lettera;

    /* -------- COSTRUTTORE --------- */
    public  Codice (String passata, int  numeri ){
        this.lettera = passata;
        this.numero = numeri;
    }


    /*============================
            METODI ISTANZA
    =============================*/

    // Getters
    public String getLettera() {
        return lettera;
    }

    // Passiamo il codice pronto per essere stampato
    public String toString () {
            return lettera + numero;
    }

    // Generiamo un nuovo codice partendo da quello passato
    public Codice nuovo (){
        return  new Codice(lettera , numero +1);
    }


}
