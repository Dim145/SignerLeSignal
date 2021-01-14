package TP1.ihm;

import java.awt.BorderLayout;

import javax.swing.*;

import TP1.Controlleur;

public class FenetrePrincipale extends JFrame
{
	Controlleur control;
	PanelHaut   pnlHaut;
	PanelGraph  pnlGraph;

	public FenetrePrincipale(Controlleur control)
	{
		this.setTitle("Projet Boireau/Dubois");
		this.setSize(500, 500);
		

		this.control = control;
		this.pnlHaut = new PanelHaut(this);
		this.add(pnlHaut, BorderLayout.NORTH);
		
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void captureTexteBinaire()
	{
		control.creerTableau(pnlHaut.retourStringBinaire());
	}
	
	public void captureType()
	{
		control.changeType(pnlHaut.retourType());
	}
}
