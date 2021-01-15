package TP1;

import TP1.ihm.FenetrePrincipale;
import TP1.metier.Metier;

/**
 * The type Controlleur.
 */
public class Controlleur
{
    private final Metier            metier;
    private final FenetrePrincipale ihm;

	/**
	 * Instantiates a new Controlleur.
	 */
	public Controlleur()
	{
		this.metier = new Metier(this);
		this.ihm    = new FenetrePrincipale(this);
	}

	/**
	 * Creer tableau.
	 *
	 * @param txt the txt
	 */
	public void creerTableau(String txt)
	{
		this.metier.creerTableaux(txt);
	}

	/**
	 * Change type.
	 *
	 * @param type the type
	 */
	public void changeType(TypeSignal type)
	{
		metier.changeType(type);
	}

	/**
	 * Update.
	 *
	 * @param tab the tab
	 */
	public void update(int[] tab)
	{
		this.ihm.update(tab);
	}

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args)
	{
		new Controlleur();
	}
}
