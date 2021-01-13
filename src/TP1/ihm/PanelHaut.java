package TP1.ihm;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

public class PanelHaut extends JPanel
{
	JFormattedTextField          txtfBinaire;
	JComboBox<String>   cbbChoix;
	JButton             btnValider;
	
	public PanelHaut()
	{
		this.setLayout(new GridLayout(0,3));
		
		MaskFormatter binaireOnly = null;
		try
		{
			binaireOnly = new MaskFormatter("##################################################"); //50 bit max
		} catch (ParseException e){e.printStackTrace();}
		binaireOnly.setValidCharacters("01");
		
		this.txtfBinaire = new JFormattedTextField(binaireOnly);
		/*this.txtfBinaire.getDocument().addDocumentListener(new DocumentListener()
		{
			public void removeUpdate (DocumentEvent e) {}
			public void changedUpdate(DocumentEvent e){}
			@Override
			public void insertUpdate(DocumentEvent e)
			{}
		});*/
		
		this.cbbChoix = new JComboBox<String>();
		this.cbbChoix.addItem("NRZ");
		this.cbbChoix.addItem("Manchester");
		this.cbbChoix.addItem("Manchester Différentiel");
		this.cbbChoix.addItem("Miller");
		
		this.btnValider = new JButton("GO");
		this.btnValider.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//envoi de données vers le metier via txtfBinaire.getText()
				System.out.println("envoi");
			}
		});
		
		this.add(this.txtfBinaire);
		this.add(this.cbbChoix);
		this.add(this.btnValider);
	}
}
