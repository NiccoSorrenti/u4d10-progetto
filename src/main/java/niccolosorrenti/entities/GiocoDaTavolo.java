package niccolosorrenti.entities;

public class GiocoDaTavolo extends Gioco {

    private int numeroGiocatori;
    private int durataMediaPartita;

    public GiocoDaTavolo(int idGioco, String titolo, int annoPubblicazione, int prezzo, int numeroGiocatori, int durataMediaPartita) {
        super(idGioco, titolo, annoPubblicazione, prezzo);
        this.numeroGiocatori = numeroGiocatori;
        this.durataMediaPartita = durataMediaPartita;
    }

    public int getNumeroGiocatori() {
        return numeroGiocatori;
    }

    public int getDurataMediaPartita() {
        return durataMediaPartita;
    }

    @Override
    public String toString() {
        return "GiocoDaTavolo{" +
                "numeroGiocatori=" + numeroGiocatori +
                ", durataMediaPartita=" + durataMediaPartita +
                '}';
    }
}
