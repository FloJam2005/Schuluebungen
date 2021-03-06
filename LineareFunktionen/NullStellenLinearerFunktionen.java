package main.de.Florian.LineareFunktionen;

import javax.swing.*;

public class NullStellenLinearerFunktionen {
    public static void main(String[] args){
        double inputM, inputB, nullStelle;

        //f(x) = mx + b = 0
        try
        {
            inputM = Double.parseDouble(JOptionPane.showInputDialog("f(x) = m * x + b \n Geben sie m an"));
            inputB = Double.parseDouble(JOptionPane.showInputDialog("f(x) = " + inputM + " * x + b \n Geben sie b an"));
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Das war keine gueltige Eingabe!");
            return;
        }

        if (inputM != 0)
        {
            if (inputB != 0)
            {

                nullStelle = -inputB / inputM;
                JOptionPane.showMessageDialog(null, "Die Funktion f(x)= " + inputM + " * x +" + inputB +" hat die 0 Stelle " +nullStelle + "!" );

            }
            else
            {
                //Keine Verschiebung entlang der X-Achse
                JOptionPane.showMessageDialog(null, "Die Funktion f(x)= " + inputM + " * x +" + inputB +" verläuft durch den Ursprung!");

            }

        }
        else
        {
            if (inputB != 0)
            {
                JOptionPane.showMessageDialog(null, "Die Funktion f(x)= " + inputM + " * x +" + inputB + " hat keine 0 Stelle!");
            } else
            {
                JOptionPane.showMessageDialog(null, "Die Funktion f(x)= " + inputM + " * x +" + inputB + " hat unendlich viele 0 Stellen!");

            }
        }
    }
}
