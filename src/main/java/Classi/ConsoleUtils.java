package Classi;

public class ConsoleUtils {

    /**
     * Stampa un messaggio di successo in verde e grassetto.
     *
     * @param messaggio Il messaggio da visualizzare.
     */
    public static void stampaMessaggioSuccesso(String messaggio) {
        System.out.println("\u001B[32;1m" + messaggio + "\u001B[0m");
    }

    /**
     * Stampa un messaggio di errore in rosso senza grassetto.
     *
     * @param messaggio Il messaggio da visualizzare.
     */
    public static void stampaMessaggioErrore(String messaggio) {
        System.out.println("\u001B[31m" + messaggio + "\u001B[0m");
    }
}
