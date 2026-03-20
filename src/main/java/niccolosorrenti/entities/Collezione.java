package niccolosorrenti.entities;

import niccolosorrenti.exceptions.CustomException;

import java.util.ArrayList;
import java.util.List;

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
}
