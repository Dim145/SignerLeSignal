package TP1;

import TP1.ihm.FenetrePrincipale;
import TP1.metier.Metier;

public class Controlleur
{
    private final Metier            metier;
    private final FenetrePrincipale ihm;

	public Controlleur()
	{
		this.metier = new Metier(this);
		this.ihm    = new FenetrePrincipale(this);
	}
	
	public void creerTableau(String txt)
	{
		this.metier.creerTableaux(txt);
	}
	
	public void changeType(TypeSignal type)
	{
		metier.changeType(type);
	}
	
	public void update(int[] tab)
	{
		this.ihm.update(tab);
	}

	public static void main(String[] args)
	{
		Controlleur c = new Controlleur();
	}
}
