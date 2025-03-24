package Classi;

public class Codice {
    private enum Lettera {
        P,
        L
    };

    private Integer numeri;
    private Lettera lettera;

    public String Tipo () {
        return String.valueOf(lettera);
    }

    public String toString () {
            return String.valueOf(lettera) + numeri;
    }


}
