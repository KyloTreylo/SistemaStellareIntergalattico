package Classi;

public class Codice {
    /*private enum Lettera {
        P,
        L
    };
    private Lettera lettera;
    */

    private Integer numeri;
    private String lettera;

    public  Codice (String passata, int  numeri ){
        this.lettera = passata;
        this.numeri = numeri;
    }

    public String Tipo () {
        return lettera;
    }

    public String toString () {
            return lettera + numeri;
    }

    public Codice nuovo (Codice ultimo){

        return  new Codice(lettera , numeri+1);
    }


}
