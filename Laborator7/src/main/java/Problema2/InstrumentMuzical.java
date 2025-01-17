package Problema2;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)

abstract class InstrumentMuzical
{
    protected String producator;
    protected double pret;

    public InstrumentMuzical(String producator, double pret)
    {
        this.producator = producator;
        this.pret = pret;
    }

    public InstrumentMuzical()
    {

    }

    public double getPret() { return pret; }
    public String getProducator() { return producator; }
    public abstract String getTip();
}