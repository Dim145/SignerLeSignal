package TP1.ihm;

import java.awt.GridLayout;
import java.awt.event.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import TP1.TypeSignal;
import TP1.metier.Metier;

public class PanelHaut extends JPanel
{
	Metier              metier;
	JFormattedTextField txtfBinaire;
	JComboBox<String>   cbbChoix;
	JButton             btnValider;
	
	public PanelHaut(Metier metier)
	{
		this.setLayout(new GridLayout(0,3));
		
		this.metier = metier;
		
		this.txtfBinaire = new JFormattedTextField();
		this.txtfBinaire.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e)
			{
				char key = e.getKeyChar();

				if( key != '0' && key != '1' )
					e.consume();
			}

			@Override
			public void keyPressed(KeyEvent e)
			{

			}

			@Override
			public void keyReleased(KeyEvent e)
			{

			}
		});
		
		this.cbbChoix = new JComboBox<>();

		for (TypeSignal t : TypeSignal.values() )
			this.cbbChoix.addItem(t.toString());
		
		this.btnValider = new JButton("GO");
		this.btnValider.addActionListener(e ->
		{
			//envoi de données vers le metier via txtfBinaire.getText()
			System.out.println("text: " + txtfBinaire.getText() + "|");
			metier.creerTableaux(txtfBinaire.getText());
		});
		
		this.add(this.txtfBinaire);
		this.add(this.cbbChoix);
		this.add(this.btnValider);
	}
}
