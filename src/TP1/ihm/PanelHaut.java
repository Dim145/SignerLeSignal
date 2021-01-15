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

public class PanelHaut extends JPanel
{
    FenetrePrincipale frame;
    JTextField txtfBinaire;
    JComboBox<TypeSignal> cbbChoix;
    JButton btnValider;
    JPanel pnlDroite;

    public PanelHaut(FenetrePrincipale frame)
    {
        this.setLayout(new BorderLayout());
        this.frame = frame;
        this.pnlDroite = new JPanel(new BorderLayout());

        this.txtfBinaire = new JTextField();
        this.txtfBinaire.setColumns(25);
        this.txtfBinaire.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                char key = e.getKeyChar();

                if( key == KeyEvent.VK_ENTER)
                {
                    frame.captureType();
                    frame.captureTexteBinaire();
                    System.out.println("entrer !");
                }

                if (key != '0' && key != '1') e.consume();
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        this.cbbChoix = new JComboBox<>();

        for (TypeSignal t : TypeSignal.values())
            this.cbbChoix.addItem(t);

        this.btnValider = new JButton("GO");
        this.btnValider.addActionListener(e ->
        {
            frame.captureType();
            frame.captureTexteBinaire();
        });

        this.add(this.txtfBinaire, BorderLayout.CENTER);
        this.add(pnlDroite, BorderLayout.EAST);
        this.pnlDroite.add(this.cbbChoix, BorderLayout.CENTER);
        this.pnlDroite.add(this.btnValider, BorderLayout.EAST);
    }

    public String retourStringBinaire()
    {
        return txtfBinaire.getText();
    }

    public TypeSignal retourType()
    {
        return (TypeSignal) cbbChoix.getSelectedItem();
    }
}
