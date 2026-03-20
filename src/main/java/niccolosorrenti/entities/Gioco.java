package niccolosorrenti.entities;

public abstract class Gioco {
    protected int idGioco;
    protected String titolo;
    protected int annoPubblicazione;
    protected int prezzo;

    public Gioco(int idGioco, String titolo, int annoPubblicazione, int prezzo) {
        this.idGioco = idGioco;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
    }

    public int getIdGioco() {
        return idGioco;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public int getPrezzo() {
        return prezzo;
    }

    @Override
    public String toString() {
        return "Gioco{" +
                "idGioco=" + idGioco +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", prezzo=" + prezzo +
                '}';
    }
}
