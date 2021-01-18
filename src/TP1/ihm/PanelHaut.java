package TP1.ihm;

import TP1.TypeSignal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The type Panel haut.
 */
public class PanelHaut extends JPanel
{
    /**
     * The Frame.
     */
    FenetrePrincipale frame;
    /**
     * The Txtf binaire.
     */
    JTextField txtfBinaire;
    /**
     * The Cbb choix.
     */
    JComboBox<TypeSignal> cbbChoix;
    /**
     * The Btn valider.
     */
    JButton btnValider;
    /**
     * The Pnl droite.
     */
    JPanel pnlDroite;

    /**
     * Instantiates a new Panel haut.
     *
     * @param frame the frame
     */
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
                }

                if (key != '0' && key != '1')
                {
                    try
                    {
                        ((Runnable)Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.exclamation")).run();
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }

                    e.consume();
                }
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

    /**
     * Retour string binaire string.
     *
     * @return the string
     */
    public String retourStringBinaire()
    {
        return txtfBinaire.getText();
    }

    /**
     * Retour type type signal.
     *
     * @return the type signal
     */
    public TypeSignal retourType()
    {
        return (TypeSignal) cbbChoix.getSelectedItem();
    }
}
