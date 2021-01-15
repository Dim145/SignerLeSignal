package TP1.ihm;

import java.awt.*;

import javax.swing.*;

public class PanelGraph extends JPanel
{
	private final FenetrePrincipale frame;
	private int[]             tab = {5,10,15,20,30,40,45,55,60,70};
	private PanelDessin[]     tabPanel;
	
	public PanelGraph(FenetrePrincipale frame)
	{
		this.frame = frame;

		this.setLayout(new BorderLayout());
	}
	
	public void update(int[] tab)
	{
		this.tab = tab;

		this.removeAll();
		this.construireChaine();
		this.construireTabPanel();
	}

	private void construireChaine()
	{
		String binaires = this.frame.getStringBinaire();

		JPanel panelTmp = new JPanel();
		panelTmp.setLayout(new GridLayout(1, this.tab.length));

		for (int cpt = 0; cpt < this.tab.length; cpt++ )
		{
			JLabel label = new JLabel();
			panelTmp.add(label);

			if( cpt % 2 != 0 ) label.setText(String.valueOf(binaires.charAt(cpt/2)));
		}

		this.add(panelTmp, BorderLayout.NORTH);
	}

	public void construireTabPanel()
	{
		JPanel panelTmp = new JPanel();
		panelTmp.setLayout(new GridLayout(1, this.tab.length));

		this.tabPanel = new PanelDessin[this.tab.length];
		
		for (int i = 0; i < tab.length; i++)
		{
			this.tabPanel[i] = new PanelDessin(this.tab[i], i%2 != 0);
			panelTmp.add(tabPanel[i]);
		}

		this.add(panelTmp, BorderLayout.CENTER);

		SwingUtilities.updateComponentTreeUI(this);
	}
}
