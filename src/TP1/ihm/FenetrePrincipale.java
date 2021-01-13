package TP1.ihm;

import java.awt.BorderLayout;

import javax.swing.*;

import TP1.metier.Metier;

public class FenetrePrincipale extends JFrame
{
	Metier     metier;
	PanelHaut  pnlHaut;
	PanelGraph pnlGraph;

	public FenetrePrincipale(Metier metier)
	{
		this.setTitle("Projet Boireau/Dubois");
		this.setSize(500, 500);
		

		this.metier  = metier;
		this.pnlHaut = new PanelHaut(metier);
		this.add(pnlHaut, BorderLayout.NORTH);
		
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
