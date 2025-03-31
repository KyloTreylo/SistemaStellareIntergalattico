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

    /* -------- METODI STATICI --------- */

    // Validates if the string is in the format "<letter><number>" (e.g., "P123").
    public static boolean controlloValiditaCodice(String codice) {
        return codice.matches("^[SPL]\\d+$");
    }

    // Validates if the string is in the format "<letter><number>" (e.g., "P123").
    public static boolean controlloValiditaCodice(String codice, String lettera) {
        return codice.matches("^[".concat(lettera.toUpperCase()).concat("]\\d+$"));
    }

    // Creates a Codice object from a given string if valid, or throws an exception otherwise.
    public static Codice valueOf(String codice) {
        if (!controlloValiditaCodice(codice)) {
            throw new IllegalArgumentException("Il codice fornito non è valido. Deve iniziare con 'P' o 'L' seguito da numeri.");
        }
        String lettera = codice.substring(0, 1);
        int numero = Integer.parseInt(codice.substring(1));
        return new Codice(lettera, numero);
    }

    // Sovrascrive il metodo equals() per confrontare sia gli attributi lettera che numero.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Codice codice = (Codice) obj;
        return numero == codice.numero && lettera.equals(codice.lettera);
    }


    /*============================
            METODI ISTANZA
    =============================*/
    

    // Getters
    public String getLettera() {
        return lettera;
    }

    // Passiamo il codice pronto per essere stampato, usiamo ".concat()" per fare bene capire cosa facciamo
    public String toString () {
            return lettera.concat(String.valueOf(numero));
    }

    // Generiamo un nuovo codice partendo da quello passato
    public Codice nuovo (){
        return  new Codice(lettera , numero +1);
    }
}
