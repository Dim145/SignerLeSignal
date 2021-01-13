package TP1;

import TP1.ihm.FenetrePrincipale;
import TP1.metier.Metier;

public class Controlleur
{
    private Metier            metier;
    private FenetrePrincipale ihm;

    public Controlleur()
    {
        this.metier = new Metier(this);

        //this.metier.creerTableaux("110110");
    }

    public static void main(String[] args)
    {
        new Controlleur();
    }
}
