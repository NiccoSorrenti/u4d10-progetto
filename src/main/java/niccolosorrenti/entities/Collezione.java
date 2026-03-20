package niccolosorrenti.entities;

import niccolosorrenti.exceptions.CustomException;

import java.util.*;
import java.util.stream.Collectors;

public class Collezione {

    List<Gioco> listaGiochi = new ArrayList<>();

    public void aggiungiGioco(Gioco gioco) {

        boolean giocoEsistente = listaGiochi.stream().anyMatch(g -> g.getIdGioco() == (gioco.getIdGioco()));

        if (giocoEsistente) {
            throw new CustomException("Esiste gia un gioco con questo ID!");
        } else {
            listaGiochi.add(gioco);
            System.out.println(gioco.getTitolo() + " aggiunto");
        }

        System.out.println("Lista giochi" + listaGiochi);

    }

    public Optional<Gioco> ricercaPerId(int id) {
        return listaGiochi.stream().filter(gioco -> gioco.getIdGioco() == id).findFirst();
    }

    public List<Gioco> ricercaPerPrezzo(int prezzo) {
        return listaGiochi.stream().filter(gioco -> gioco.getPrezzo() < prezzo).collect(Collectors.toList());
    }

    public List<GiocoDaTavolo> ricercaPerNumeroGiocatori(int numGiocatori) {
        return listaGiochi.stream()
                .filter(gioco -> gioco instanceof GiocoDaTavolo)
                .map(gioco -> (GiocoDaTavolo) gioco)
                .filter(gioco -> gioco.getNumeroGiocatori() == numGiocatori)
                .collect(Collectors.toList());
    }

    public void rimozioneGioco(int id) {
        listaGiochi.remove(id);
        System.out.println("il gioco è stato rimosso");
        System.out.println(listaGiochi);
    }

    public void aggiornaGioco(int id, Gioco nuovoGioco) {
        rimozioneGioco(id);
        aggiungiGioco(nuovoGioco);
        System.out.println("il gioco è stato aggiornato");
        System.out.println(listaGiochi);

    }

    public void mostraStatistiche() {
        long numeroVidegiochi = listaGiochi.stream().filter(gioco -> gioco instanceof Videogioco).count();
        long numeroGiochiDaTavolo = listaGiochi.stream().filter(gioco -> gioco instanceof GiocoDaTavolo).count();
        List<Gioco> giocoConPrezzoPiuAlto = listaGiochi.stream().sorted(Comparator.comparing(gioco -> gioco.getPrezzo())).limit(1).toList();
        OptionalDouble mediaPrezzi = listaGiochi.stream().mapToDouble(gioco -> gioco.getPrezzo()).average();

        System.out.println("Numero videogiochi: " + numeroVidegiochi);
        System.out.println("Numero giochi da tavolo: " + numeroGiochiDaTavolo);
        System.out.println("Gioco con prezzo più alto: " + giocoConPrezzoPiuAlto);
        System.out.println("Media prezzi di tutti gli elementi: " + mediaPrezzi);
    }

    @Override
    public String toString() {
        return "Collezione{" +
                "listaGiochi=" + listaGiochi +
                '}';
    }
}
