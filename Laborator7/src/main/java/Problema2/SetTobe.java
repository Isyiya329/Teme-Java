package Problema2;

public class SetTobe extends InstrumentMuzical {
    enum TipTobe { ELECTRONICE, ACUSTICE }
    private TipTobe tip_tobe;
    private int nr_tobe;
    private int nr_cinele;

    public SetTobe(String producator, double pret, TipTobe tip_tobe, int nr_tobe, int nr_cinele) {
        super(producator, pret);
        this.tip_tobe = tip_tobe;
        this.nr_tobe = nr_tobe;
        this.nr_cinele = nr_cinele;
    }

    public SetTobe()
    {

    }

    public int getNrTobe() { return nr_tobe; }
    public int getNrCinele() { return nr_cinele; }
    public String getTip() { return "SetTobe"; }
}
