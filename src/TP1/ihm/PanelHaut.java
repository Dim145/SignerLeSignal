package TP1.ihm;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import TP1.TypeSignal;

public class PanelHaut extends JPanel {
	FenetrePrincipale   frame;
	JTextField          txtfBinaire;
	JComboBox<String>   cbbChoix;
	JButton             btnValider;
	JPanel              pnlDroite;

	public PanelHaut(FenetrePrincipale frame) {
		this.setLayout(new BorderLayout());
		this.frame = frame;
		this.pnlDroite = new JPanel(new GridLayout(0,2));
		
		this.txtfBinaire = new JTextField();
		this.txtfBinaire.setColumns(25);
		this.txtfBinaire.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				char key = e.getKeyChar();

				if (key != '0' && key != '1')
					e.consume();
			}

			@Override
			public void keyPressed(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {}
		});

		this.cbbChoix = new JComboBox<>();

		for (TypeSignal t : TypeSignal.values())
			this.cbbChoix.addItem(t.toString());

		this.btnValider = new JButton("GO");
		this.btnValider.addActionListener(e-> {
			frame.captureType();
			frame.captureTexteBinaire();
			});

		this.add(this.txtfBinaire, BorderLayout.CENTER);
		this.add(pnlDroite, BorderLayout.EAST);
		this.pnlDroite.add(this.cbbChoix);
		this.pnlDroite.add(this.btnValider);
	}
	
	public String retourStringBinaire()
	{
		return txtfBinaire.getText();
	}

	public TypeSignal retourType()
	{
		if     (cbbChoix.getSelectedItem().equals("NRZ"))                     return TypeSignal.NRZ;
		else if(cbbChoix.getSelectedItem().equals("Manchester"))              return TypeSignal.MANCHESTER;
		else if(cbbChoix.getSelectedItem().equals("Manchester Différentiel")) return TypeSignal.MANCHESTER_DIFF;
		else                                                                  return TypeSignal.MILLER;
	}
}
