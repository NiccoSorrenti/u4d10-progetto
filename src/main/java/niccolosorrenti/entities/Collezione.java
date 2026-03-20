package niccolosorrenti.entities;

import niccolosorrenti.exceptions.CustomException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Collezione {

    List<Gioco> listaGiochi = new ArrayList<>();

    public void aggiungiGioco(Gioco gioco) {

        boolean giocoEsistente = listaGiochi.stream().anyMatch(g -> g.getIdGioco() == (gioco.getIdGioco()));

        if (giocoEsistente) {
            throw new CustomException("Esiste gia un gioco con questo ID!");
        } else {
            listaGiochi.add(gioco);
        }
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
        Optional<Gioco> g = ricercaPerId(id);
        listaGiochi.remove(g);
    }

    public void aggiornaGioco(int id, Gioco nuovoGioco) {
        rimozioneGioco(id);
        aggiungiGioco(nuovoGioco);
    }
}
