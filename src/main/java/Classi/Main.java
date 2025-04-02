package Classi;

import it.kibo.fp.lib.InputData;
import it.kibo.fp.lib.Menu;

import static Classi.ConsoleUtils.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Sistema Stellare Galattico");
        System.out.println("=========================");
        System.out.println("Creazione e gestione di un sistema stellare galattico.");
        System.out.println("=========================");

        // Passo 1: Inserimento dati per la stella principale
        // Richiedi all'utente di inserire il nome della stella (controllando che non sia vuoto)
        String nomeStella = InputData.readNonEmptyString("Inserisci il nome della stella: ", true);
        double massaStella = InputData.readDoubleWithMinimum("Inserisci la massa della stella (kg): ", 0);
        Stella stella = new Stella(massaStella, 0, 0, nomeStella);

        // Passo 2: Avvio del menu ciclico per interagire con il sistema
        String[] opzioni = {
                "Aggiungi pianeta",
                "Aggiungi luna",
                "Stampa dettagli della stella",
                "Stampa dettagli di un corpo celeste per codice",
                "Rimuovi un corpo celeste",
                "Calcola il centro di massa",
                "Modifica il nome di un corpo celeste"
        };
        Menu menu = new Menu("Scegli un'opzione:", opzioni, true, false, false);

        boolean exit = false;
        while (!exit) {
            int scelta = menu.choose();

            switch (scelta) {
                // Aggiunge un nuovo pianeta alla stella se c'è disponibilità
                case 1 -> {
                    if (stella.cercaDisponibilita()) {
                        if (stella.aggiungiPianeta()) {
                            stampaMessaggioSuccesso("Pianeta aggiunto con successo!");
                        } else {
                            stampaMessaggioErrore("Errore nell'aggiungere il pianeta.");
                        }
                    } else {
                        stampaMessaggioErrore("Capacità massima di pianeti raggiunta (26000).");
                    }
                }
                // Aggiunge una nuova luna a un pianeta esistente
                case 2 -> {
                    if (stella.getNumeroPianeti() > 0) {
                        if (stella.aggiungiLuna()) {
                            stampaMessaggioSuccesso("Luna aggiunta con successo!");
                        } else {
                            stampaMessaggioErrore("Errore nell'aggiungere la luna. Controlla le condizioni.");
                        }
                    } else {
                        stampaMessaggioErrore("Non ci sono pianeti a cui aggiungere lune.");
                    }
                }
                // Stampa i dettagli della stella principale
                case 3 -> {
                    System.out.println(stella.toString());
                }
                // Stampa i dettagli di un corpo celeste specifico, cercando tramite il codice
                case 4 -> {
                    CorpoCeleste corpoCeleste = stella.cercaCorpoCeleste();
                    if (corpoCeleste != null) {
                        System.out.println(corpoCeleste.toString());
                    } else {
                        System.out.println("Corpo celeste non trovato.");
                    }
                }
                // Rimuove un corpo celeste identificato da un codice
                case 5 -> {
                    if (!stella.rimuoviCorpoCeleste()) {
                        stampaMessaggioErrore("Errore nella rimozione. Controlla il codice inserito.");
                    }
                }
                // Calcola e stampa il centro di massa del sistema
                case 6 -> {
                    System.out.printf("""
                            ================================
                                Calcolo Centro di Massa
                            ================================
                            Centro di massa X: %f
                            Centro di massa Y: %f
                            =================================
                            %n""", stella.centroDiMassa()[0], stella.centroDiMassa()[1]);
                }
                // Modifica il nome di un corpo celeste
                case 7 -> {
                    CorpoCeleste corpoCeleste = stella.cercaCorpoCeleste();
                    if (corpoCeleste != null) {
                        String nuovoNome = InputData.readNonEmptyString("Inserisci il nuovo nome del corpo celeste: ", true);
                        corpoCeleste.setNome(nuovoNome);
                        stampaMessaggioSuccesso("Nome del corpo celeste aggiornato con successo.");
                    } else {
                        stampaMessaggioErrore("Corpo celeste non trovato.");
                    }
                }
                // Esce dal programma e termina l'esecuzione
                case 0 -> {
                    exit = true;
                    stampaMessaggioSuccesso("Programma terminato.");
                }
                default -> stampaMessaggioErrore("Opzione non valida. Riprova.");
            }
        }
    }
}
