package Classi;

public class Codice {

    /* -------- ATTRIBUTI ISTANZA --------- */

    private final int numero;

    private final String lettera;

    /* -------- COSTRUTTORE --------- */

    /**
     * Costruttore della classe Codice.
     *
     * @param passata La lettera associata al codice.
     * @param numeri  Il numero associato al codice.
     */
    public Codice(String passata, int numeri) {
        this.lettera = passata;
        this.numero = numeri;
    }

    /* -------- METODI STATICI --------- */

    /**
     * Verifica se la stringa è nel formato "<lettera><numero>" (es. "P123").
     *
     * @param codice La stringa da validare.
     * @return true se la stringa rispetta il formato corretto, false altrimenti.
     */
    public static boolean controlloInvaliditaCodice(String codice) {
        return !codice.matches("^[SPL]\\d+$");
    }

    /**
     * Crea un oggetto Codice da una stringa valida o genera un'eccezione se il formato non è corretto.
     *
     * @param codice La stringa da cui creare l'oggetto Codice.
     * @return L'oggetto Codice creato.
     * @throws IllegalArgumentException Se il codice fornito non è valido.
     */
    public static Codice valueOf(String codice) {
        if (controlloInvaliditaCodice(codice)) {
            throw new IllegalArgumentException("Il codice fornito non è valido. Deve iniziare con 'P' o 'L' seguito da numeri.");
        }
        String lettera = codice.substring(0, 1);
        int numero = Integer.parseInt(codice.substring(1));
        return new Codice(lettera, numero);
    }

    // Sovrascrive il metodo equals() per confrontare sia gli attributi lettera che numero.

    /**
     * Confronta questo oggetto con un altro per verificare se i loro attributi
     * {@code lettera} e {@code numero} sono uguali.
     *
     * @param obj L'oggetto da confrontare.
     * @return true se i due oggetti sono uguali, false altrimenti.
     */
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

    /**
     * Restituisce la lettera associata al codice.
     *
     * @return La lettera associata.
     */
    public String getLettera() {
        return lettera;
    }

    // Passiamo il codice pronto per essere stampato, usiamo ".concat()" per fare bene capire cosa facciamo

    /**
     * Converte il codice in una stringa nel formato "<lettera><numero>".
     *
     * @return Una stringa rappresentativa del codice.
     */
    public String toString() {
        return lettera.concat(String.valueOf(numero));
    }

    // Generiamo un nuovo codice partendo da quello passato

    /**
     * Genera un nuovo oggetto Codice, incrementando di 1 il numero rispetto al codice corrente.
     *
     * @return Un nuovo oggetto Codice con il numero incrementato.
     */
    public Codice nuovo() {
        return  new Codice(lettera , numero +1);
    }
}
