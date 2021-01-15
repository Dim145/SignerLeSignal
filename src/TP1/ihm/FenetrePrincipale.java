package TP1.ihm;

import java.awt.*;

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
		

		this.control  = control;
		this.pnlHaut  = new PanelHaut(this);
		this.pnlGraph = new PanelGraph(this);
		this.add(pnlHaut, BorderLayout.NORTH);
		this.add(pnlGraph, BorderLayout.CENTER);
		
		this.setMinimumSize(new Dimension(200, 300));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void update(int[] tab)
	{
		this.pnlGraph.update(tab);
	}

	public String getStringBinaire()
	{
		return pnlHaut.retourStringBinaire();
	}

	public void captureTexteBinaire()
	{
		control.creerTableau(this.getStringBinaire());
	}
	
	public void captureType()
	{
		control.changeType(pnlHaut.retourType());
	}
}
