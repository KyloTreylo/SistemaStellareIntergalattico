package Classi;

import it.kibo.fp.lib.InputData;

public class Main {
    public static void main(String[] args) {
        // Step 1: Input data for the central star
        String starName = InputData.readNonEmptyString("Inserisci il nome della stella: ", true);
        double starMass = InputData.readDoubleWithMinimum("Inserisci la massa della stella: ", 0);
        int starPosX = InputData.readInteger("Inserisci la posizione X della stella: ");
        int starPosY = InputData.readInteger("Inserisci la posizione Y della stella: ");
        Stella stella = new Stella(starMass, starPosX, starPosY, starName);

        // Step 2: Start the cyclic menu
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    Scegli un'opzione:
                    1. Aggiungi pianeta
                    2. Aggiungi luna
                    3. Stampa dettagli della stella
                    4. Stampa dettagli di un corpo celeste per codice
                    5. Esci
                    """);
            int choice = InputData.readIntegerBetween("Inserisci la tua scelta (1-5): ", 1, 5);

            switch (choice) {
                case 1 -> {
                    if (stella.cercaDisponibilita()) {
                        if (stella.aggiungiPianeta()) {
                            System.out.println("Pianeta aggiunto con successo!");
                        } else {
                            System.out.println("Errore nell'aggiungere il pianeta.");
                        }
                    } else {
                        System.out.println("Capacità massima di pianeti raggiunta.");
                    }
                }
                case 2 -> {
                    if (stella.getNumeroPianeti() > 0) {
                        if (stella.aggiungiLuna()) {
                            System.out.println("Luna aggiunta con successo!");
                        } else {
                            System.out.println("Errore nell'aggiungere la luna. Controlla le condizioni.");
                        }
                    } else {
                        System.out.println("Non ci sono pianeti a cui aggiungere lune.");
                    }
                }
                case 3 -> {
                    System.out.println(stella);
                }
                case 4 -> {
                    CorpoCeleste body = stella.cercaPianeta();
                    if (body != null) {
                        System.out.println(body);
                    } else {
                        System.out.println("Corpo celeste non trovato.");
                    }
                }
                case 5 -> {
                    exit = true;
                    System.out.println("Programma terminato.");
                }
                default -> System.out.println("Opzione non valida. Riprova.");
            }
        }
    }
}
