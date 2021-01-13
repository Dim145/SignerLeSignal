package TP1.ihm;

import java.awt.BorderLayout;

import javax.swing.*;

public class FenetrePrincipale extends JFrame
{
	PanelHaut  pnlHaut  = new PanelHaut();
	PanelGraph pnlGraph;

	public FenetrePrincipale()
	{
		this.setTitle("Projet Boireau/Dubois");
		this.setSize(500, 500);
		
		this.add(pnlHaut, BorderLayout.NORTH);
		
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
