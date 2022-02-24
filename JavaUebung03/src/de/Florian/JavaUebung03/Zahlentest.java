package de.Florian.JavaUebung03;

import javax.swing.JOptionPane;

public class Zahlentest {
	/*
	 * Pr�ft eine Zahl auf Negativit�t
	 * Zahl > 0 return true
	 * Zahl < 0 return false
	 * param double Zahl, Zahl die �berpr�ft wird
	 * 
	 * 
	 */
	private static Boolean pruefen(double Zahl) {
		if (Zahl > 0 ) {
			return true;
		} else 
			return false;
		}
	

	public static void main(String[] args) {
		//Endlosschleife um n Zahlen auf Negativit�t zu pr�fen
		while (true) {
			String str_input = JOptionPane.showInputDialog("Geben Sie eine Zahl ein!"); 
			double db_zahl;
			//�berpr�ft ob es eine Eingabe gab, wenn es keine gab wird die Schleife durchbrochen und das Programm beendet.
			if (str_input == null) {
				break;
			}
			try {
				db_zahl = Math.round(Double.parseDouble(str_input.replace(",", "."))*100.00)/100.00; 
				/*Wandelt den Input String in einen auf 2 Nachkommastellen gerundeten Double um.
				 * Das Komma wird vor dem Runden um 2 nach links verschoben nach dem Runden wieder um 2 nach rechts
				 * Eingegebene "," werden in "." umgewandelt
				*/
				
			} catch (NumberFormatException e) {
				//F�ngt die Exceptions "NumberFormatException" falls der Input String nicht in einen Double umgewandelt werden kann.
				JOptionPane.showMessageDialog(null, "Das war keine g�ltige Zahl.");
				continue;// Wenn es nicht funktioniert hat wird alles von vorne gestartet
			}
			if (db_zahl == 0) {
				JOptionPane.showMessageDialog(null, "Die Zahl '0' ist weder Positiv noch Negativ!");
			} else {
				//Wenn die Zahl nicht 0 ist wird sie auf Negativit�t �berpr�ft
				if (pruefen(db_zahl)) {
					JOptionPane.showMessageDialog(null, "Die Zahl " + db_zahl + " ist nicht Negativ!");
				} else if (!pruefen(db_zahl)) {
					JOptionPane.showMessageDialog(null, "Die Zahl " + db_zahl + " ist Negativ!");
				}
			}
			
			
		
		}
	
	
	}
}
