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

public class PanelHaut extends JPanel {
	FenetrePrincipale frame;
	JFormattedTextField txtfBinaire;
	JComboBox<String> cbbChoix;
	JButton btnValider;

	public PanelHaut(FenetrePrincipale frame) {
		this.setLayout(new GridLayout(0, 3));

		this.frame = frame;

		this.txtfBinaire = new JFormattedTextField();
		this.txtfBinaire.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				char key = e.getKeyChar();

				if (key != '0' && key != '1')
					e.consume();
			}

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {}
		});

		this.cbbChoix = new JComboBox<>();

		for (TypeSignal t : TypeSignal.values())
			this.cbbChoix.addItem(t.toString());

		this.btnValider = new JButton("GO");
		this.btnValider.addActionListener(e ->{frame.captureTexteBinaire();});

		this.add(this.txtfBinaire);
		this.add(this.cbbChoix);
		this.add(this.btnValider);
	}
	
	public String retourStringBinaire()
	{
		return txtfBinaire.getText();
	}
}
