package Schuluebungen/QuadratischeFunktionen;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class NullstellenQuadratischerFunktionen {

	public static void main(String[] args) {
		
		// f(x) = a*x^2 + b*x + c
		double a,b,c,d,p,q,lsg1, lsg2, w;
		String funktion;
		
		
		JTextField input_a = new JTextField();
		JTextField input_b = new JTextField();
		JTextField input_c = new JTextField();
		
		
		Object[] message = {
				"f(x) = a*x^2 + b*x + c", 
				"Eingabe a", 
				input_a, 
				"Eingabe b", 
				input_b,
				"Eingabe c",
				input_c};
		
		
		JOptionPane pane = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
		JDialog dialog = pane.createDialog(null,  "Berechnung");
		dialog.setVisible(true);
		
		
		try {
			a = Double.parseDouble(input_a.getText().replace(',', '.'));
			b = Double.parseDouble(input_b.getText().replace(',', '.'));
			c = Double.parseDouble(input_c.getText().replace(',', '.'));
			
			funktion = a + "x^2+"+ b + "x+" + c;
			
		} catch (NumberFormatException e) {
			//Irgendwas
			System.exit(0);
			return;
		}
		
		
		if (a != 0) {
			
			p = b/a;
			q = c/a;
			d = p*p/4 -q;
			
			if (d < 0) {
				JOptionPane.showMessageDialog(null, "Die Funktion " + funktion + " hat keine Nullstellen!" );
				
			} else if (d > 0) {
				w = Math.sqrt(d);
				lsg1 = -p/2 + w;
				lsg2 = -p/2 - w;
				
				JOptionPane.showMessageDialog(null, "Die Funktion " + funktion + " hat die Nullstellen, " 
				+ Math.round(lsg1 * 100.0)/100.0 +" & " + Math.round(lsg2 * 100.0)/100.0);
				
				
				
			} else {
				
				JOptionPane.showMessageDialog(null, "Die Funktion " + funktion + " hat die Nullstelle " + Math.round(-p/2 * 100.0)/100.0);
				
			}
			System.exit(0);
			
			System.exit(0);
			
		} else {
			
			
			//0 = Yes 1 = No -1 = No?
			int selection = JOptionPane.showConfirmDialog(null,
					"Die Funktion " + funktion + " ist keine Quadratische Funktion. Möchten Sie troztdem Fortfahren?",
					"Trotzdem Fortfahren?", JOptionPane.YES_NO_OPTION);
			
			if (selection != 0) {
				System.exit(0);
			}
			
			//f(x) = bx + c 
			
			if (b != 0) {
				if (c != 0) {
					lsg1 = -c/b;
					JOptionPane.showMessageDialog(null,  "Die Funktion f(x) = " + b + "x+" + c+ " hat die Nullstelle " + lsg1);
				} else {
					JOptionPane.showMessageDialog(null, "Die Funktion f(x) = " + b + "x+" + c+ " verläuft durch den Ursprung");
				}
			} else {
				if (c != 0) {
					JOptionPane.showMessageDialog(null,  "Die Funktion f(x) = " + b + "x+" + c+ " hat keine Nullstelle!");
				} else {
					JOptionPane.showMessageDialog(null, "Die Funktion f(x) = " + b + "x+" + c+ " hat unendlich viele 0 Stellen!");
				}
			}
			System.exit(0);
		}	
	}
}
