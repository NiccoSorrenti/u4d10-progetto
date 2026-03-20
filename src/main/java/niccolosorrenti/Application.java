package niccolosorrenti;

import niccolosorrenti.entities.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Collezione collezione = new Collezione();
        Videogioco videogioco = new Videogioco(1, "Fifa", 2026, 70, "Xbox", 90, Genere.SPORT);
        Videogioco videogioco1 = new Videogioco(2, "Call Of Duty", 2000, 70, "Xbox", 100, Genere.RPG);
        Videogioco videogioco2 = new Videogioco(3, "Cyberpunk", 2024, 80, "PC", 1000, Genere.GDR);
        GiocoDaTavolo giocoDaTavolo = new GiocoDaTavolo(2, "Risiko", 1990, 60, 8, 60);
        Gioco gioco = new Gioco() {
            
        };

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPremi 1 per aggiungere un videogioco");
            System.out.println("Premi 2 per aggiungere un gioco da tavolo");
            System.out.println("Premi 3 per ricercare per id");
            System.out.println("Premi 4 per ricercare per prezzo");
            System.out.println("Premi 5 per ricercare per numero giocatori");
            System.out.println("Premi 6 per rimuovere un gioco");
            System.out.println("Premi 7 per aggiornare un gioco");
            System.out.println("Premi 8 per le statistiche totali");
            System.out.println("Premi 0 per uscire");


            int tastoPremuto = Integer.parseInt(scanner.nextLine());

            try {
                switch (tastoPremuto) {
                    case 1:
                        collezione.aggiungiGioco(videogioco);
                        collezione.aggiungiGioco(videogioco1);
                        break;
                    case 2:
                        collezione.aggiungiGioco(giocoDaTavolo);
                        break;
                    case 3:
                        System.out.println("Inserisci l'ID da cercare: ");
                        int idCercato = Integer.parseInt(scanner.nextLine());

                        Optional<Gioco> risultato = collezione.ricercaPerId(idCercato);

                        if (risultato.isPresent()) {
                            System.out.println("Il gioco con id " + idCercato + " è stato trovato " + risultato.get());
                        } else {
                            System.out.println("Nessun gioco trovato con ID: " + idCercato);
                        }

                        break;
                    case 4:
                        System.out.println("Inserisci il prezzo da cercare: ");
                        int prezzoCercato = Integer.parseInt(scanner.nextLine());

                        List<Gioco> risultato1 = collezione.ricercaPerPrezzo(prezzoCercato);

                        if (risultato1.isEmpty()) {
                            System.out.println("Nessun gioco trovato con il prezzo cercato: " + prezzoCercato);
                        } else {
                            System.out.println("Gioco " + gioco.getTitolo() + " con prezzo: " + prezzoCercato + " trovato");
                        }
                        break;
                    case 5:
                        System.out.println("Inserisci il numero di giocatori da cercare: ");
                        int giocatoriCercati = Integer.parseInt(scanner.nextLine());

                        List<GiocoDaTavolo> risultato2 = collezione.ricercaPerNumeroGiocatori(giocatoriCercati);
                        if (risultato2.isEmpty()) {
                            System.out.println("nessun gioco trovato con il numero di giocatori cercato: " + giocatoriCercati);
                        } else {
                            System.out.println("Gioco: " + giocoDaTavolo.getTitolo() + " con numero di giocatori " + giocatoriCercati + " trovato");
                        }

                        break;
                    case 6:
                        System.out.println("Inserisci l'ID da rimuovere");
                        int idDaRimuovere = Integer.parseInt(scanner.nextLine());

                        collezione.rimozioneGioco(idDaRimuovere);
                        break;
                    case 7:
                        int id = Integer.parseInt(scanner.nextLine());
                        collezione.aggiornaGioco(id, videogioco2);
                        break;
                    case 8:
                        collezione.mostraStatistiche();
                        break;
                    case 0:
                        return;

                }
            } catch (Exception exception) {
                System.out.println("Errore: " + exception.getMessage());
            }
        }
    }
}
