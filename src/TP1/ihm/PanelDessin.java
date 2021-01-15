package TP1.ihm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelDessin extends JPanel
{
	private final int setup;
	private final boolean isSecond;

	public PanelDessin(int setup, boolean isSecond)
	{
		this.setup = setup;
		this.isSecond = isSecond;
	}

	public void paint(Graphics g)
	{
		if( isSecond )
			g.drawLine(this.getWidth()-1, 10, this.getWidth()-1, this.getHeight()-10);

		g.setColor(Color.red);

		//ligne haut
		if(setup == 5 || setup == 15 || setup == 25 || setup == 45 || setup == 55)
		{
			g.drawLine(0, 10, this.getWidth(), 10);
		}

		//ligne droite
		if(setup == 10 || setup == 15 || setup == 30|| setup == 55 || setup == 70)
		{
			g.drawLine(this.getWidth()-3, 10, this.getWidth()-3, this.getHeight()-10);
		}

		//ligne bas
		if(setup == 20 || setup == 30 || setup == 60 || setup == 70)
		{
			g.drawLine(0, this.getHeight()-10, this.getWidth(), this.getHeight()-10);
		}

		//ligne gauche
		if(setup == 40 || setup == 45 || setup == 55 || setup == 60 || setup == 70)
		{
			g.drawLine(0, 10, 0, this.getHeight()-10);
		}
	}
}
