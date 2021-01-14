package TP1.ihm;

import java.awt.GridLayout;

import javax.swing.*;

public class PanelGraph extends JPanel
{
	private FenetrePrincipale frame;
	private int[]             tab = {5,10,15,20,30,40,45,55,60,70};
	private PanelDessin[]     tabPanel;
	
	public PanelGraph(FenetrePrincipale frame)
	{
		this.frame = frame;
	}
	
	public void recupererTabPanel(int[] tab)
	{
		this.tab = tab;
		construireTabPanel();
	}
	
	public void construireTabPanel()
	{
		this.setLayout(new GridLayout(1, this.tab.length));
		this.tabPanel = new PanelDessin[this.tab.length];
		
		for (int i = 0; i < tab.length; i++)
		{
			this.tabPanel[i] = new PanelDessin(this.tab[i]);
			this.add(tabPanel[i]);
		}
		//SwingUtilities.updateComponentTreeUI(frame);
		this.repaint();
	}
}
