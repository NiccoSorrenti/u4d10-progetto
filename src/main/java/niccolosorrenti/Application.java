package niccolosorrenti;

import niccolosorrenti.entities.Collezione;
import niccolosorrenti.entities.Genere;
import niccolosorrenti.entities.Videogioco;

public class Application {

    public static void main(String[] args) {
        Collezione collezione = new Collezione();
        Videogioco videogioco = new Videogioco(1, "Fifa", 2026, 70, "Xbox", 90, Genere.SPORT);


    }
}
