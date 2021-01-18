package TP1.ihm;

import javax.swing.*;
import java.awt.*;

/**
 * The type Panel graph.
 */
public class PanelGraph extends JPanel
{
	private final FenetrePrincipale frame;
	private int[]             tab = {5,10,15,20,30,40,45,55,60,70};
	private PanelDessin[]     tabPanel;

	/**
	 * Instantiates a new Panel graph.
	 *
	 * @param frame the frame
	 */
	public PanelGraph(FenetrePrincipale frame)
	{
		this.frame = frame;

		this.setLayout(new BorderLayout());
	}

	/**
	 * Update.
	 *
	 * @param tab the tab
	 */
	public void update(int[] tab)
	{
		this.tab = tab;

		this.removeAll();
		System.gc();

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

			if( cpt % 2 != 0 )
			{
				label = new JLabel()
				{
					@Override
					public void paint(Graphics g)
					{
						super.paint(g);
						g.drawLine(this.getWidth()-1, 0, this.getWidth()-1, this.getHeight());
					}
				};

				label.setText(String.valueOf(binaires.charAt(cpt/2)));
			}

			panelTmp.add(label);
		}

		this.add(panelTmp, BorderLayout.NORTH);
	}

	/**
	 * Construire tab panel.
	 */
	public void construireTabPanel()
	{
		JPanel panelTmp = new JPanel();
		panelTmp.setLayout(new GridLayout(1, this.tab.length));

		this.tabPanel = new PanelDessin[this.tab.length];
		System.gc();
		
		for (int i = 0; i < tab.length; i++)
			this.tabPanel[i] = new PanelDessin(this.tab[i], i%2 != 0);

		for (int i = 0; i < tab.length; i++)
			panelTmp.add(tabPanel[i]);

		this.add(panelTmp, BorderLayout.CENTER);

		SwingUtilities.updateComponentTreeUI(this);
	}
}
