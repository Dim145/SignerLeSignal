package TP1.ihm;

import TP1.Controlleur;

import javax.swing.*;
import java.awt.*;

/**
 * The type Fenetre principale.
 */
public class FenetrePrincipale extends JFrame
{
	/**
	 * The Control.
	 */
	Controlleur control;
	/**
	 * The Pnl haut.
	 */
	PanelHaut   pnlHaut;
	/**
	 * The Pnl graph.
	 */
	PanelGraph  pnlGraph;

	/**
	 * Instantiates a new Fenetre principale.
	 *
	 * @param control the control
	 */
	public FenetrePrincipale(Controlleur control)
	{
		this.setTitle("Projet Boireau/Dubois");
		

		this.control  = control;
		this.pnlHaut  = new PanelHaut(this);
		this.pnlGraph = new PanelGraph(this);
		this.add(pnlHaut, BorderLayout.NORTH);
		this.add(pnlGraph, BorderLayout.CENTER);
		
		this.setMinimumSize(new Dimension(300, 200));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * Update.
	 *
	 * @param tab the tab
	 */
	public void update(int[] tab)
	{
		this.pnlGraph.update(tab);
	}

	/**
	 * Gets string binaire.
	 *
	 * @return the string binaire
	 */
	public String getStringBinaire()
	{
		return pnlHaut.retourStringBinaire();
	}

	/**
	 * Capture texte binaire.
	 */
	public void captureTexteBinaire()
	{
		control.creerTableau(this.getStringBinaire());
	}

	/**
	 * Capture type.
	 */
	public void captureType()
	{
		control.changeType(pnlHaut.retourType());
	}
}
