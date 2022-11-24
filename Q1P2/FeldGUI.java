package Q1P2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class FeldGUI {

	private JFrame frmFelderInJava;
	//Konstanten festlegen, hier: maximale Anzahl der Feldelemente
	final static int cMaxZahlen = 20;
	final static int cMaxZZahl  = 100;

	//Deklaration des Feldes und weiterer Variablen
	int[] zahlen;
	private JTextField textTauschA;
	private JTextField textTauschB;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeldGUI window = new FeldGUI();
					window.frmFelderInJava.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public FeldGUI() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		//Allokation des Speichers für das Feld
		zahlen = new int[cMaxZahlen];

		frmFelderInJava = new JFrame();
		frmFelderInJava.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmFelderInJava.setTitle("Felder in Java");
		frmFelderInJava.setResizable(false);
		frmFelderInJava.setBounds(100, 100, 341, 559);
		frmFelderInJava.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFelderInJava.getContentPane().setLayout(null);
		
		JButton btnAppClose = new JButton("Beenden");
		btnAppClose.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAppClose.setBounds(225, 496, 89, 23);
		frmFelderInJava.getContentPane().add(btnAppClose);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textArea.setEditable(false);
		textArea.setColumns(2);
		textArea.setBounds(10, 34, 166, 353);
		frmFelderInJava.getContentPane().add(textArea);
		
		JLabel lblInfoUser = new JLabel("Zahlenfeld mit 20 Werten");
		lblInfoUser.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInfoUser.setBounds(10, 11, 147, 14);
		frmFelderInJava.getContentPane().add(lblInfoUser);
		
		JButton btnArrayInit = new JButton("Initialisieren");
		btnArrayInit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnArrayInit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FeldFuellen(zahlen,cMaxZahlen,0);
				ArrayDisplayValues(textArea,zahlen,cMaxZahlen);
			}
		});
		btnArrayInit.setBounds(186, 34, 128, 23);
		frmFelderInJava.getContentPane().add(btnArrayInit);
		
		JButton btnArrayRandomFill = new JButton("Zufallszahlen");
		btnArrayRandomFill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FeldFuellenZufallszahl(zahlen,cMaxZahlen,cMaxZZahl);
				ArrayDisplayValues(textArea,zahlen,cMaxZahlen);
			}
		});
		btnArrayRandomFill.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnArrayRandomFill.setBounds(186, 68, 128, 23);
		frmFelderInJava.getContentPane().add(btnArrayRandomFill);
		
		textTauschA = new JTextField();
		textTauschA.setBounds(186, 102, 54, 20);
		frmFelderInJava.getContentPane().add(textTauschA);
		textTauschA.setColumns(10);
		
		textTauschB = new JTextField();
		textTauschB.setBounds(186, 133, 54, 20);
		frmFelderInJava.getContentPane().add(textTauschB);
		textTauschB.setColumns(10);
		
		JButton btnArraySwap = new JButton("Vertauschen");
		btnArraySwap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FeldElementTausch(zahlen,(Integer.parseInt(textTauschA.getText()) - 1),(Integer.parseInt(textTauschB.getText()) - 1));
				ArrayDisplayValues(textArea,zahlen,cMaxZahlen);
			}
		});
		btnArraySwap.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnArraySwap.setBounds(186, 164, 128, 23);
		frmFelderInJava.getContentPane().add(btnArraySwap);
		
		JButton btnArraySort = new JButton("Sortieren");
		btnArraySort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FeldSortierenBubbleSort(zahlen);
				ArrayDisplayValues(textArea,zahlen,cMaxZahlen);
			}
		});
		btnArraySort.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnArraySort.setBounds(186, 198, 128, 23);
		frmFelderInJava.getContentPane().add(btnArraySort);
		btnAppClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	}
	
	
	static void FeldFuellen(int[] dasFeld, int maxAnzahl, int fuellWert) {
		//Deklaration von notwendigen lokalen Variablen
		int counter;

		//Füllen mit Nullen "zu Fuß"
		//Füllen bequem (setzt java.util.Arrays voraus): fill(zahlen,1);
		for (counter = 0; counter < maxAnzahl ; counter++) {
			dasFeld[counter] = fuellWert;
		}
		
	}
	
	static void FeldFuellenZufallszahl(int[] dasFeld, int maxAnzahl, int maxZufallszahl) {
		//Deklaration von notwendigen lokalen Variablen
		int counter;
		
		for (counter = 0; counter < maxAnzahl ; counter++) {
			dasFeld[counter] = (int) (Math.random() * maxZufallszahl) + 1;
		}
	}
	
	static void FeldElementTausch(int[] dasFeld, int ElementA, int ElementB) {
		int hilfsZahl;
		
		if ((ElementA < cMaxZahlen) && (ElementB < cMaxZahlen) && (ElementA >= 0) && (ElementB >=0)) {
		 	hilfsZahl = dasFeld[ElementA];
		 	dasFeld[ElementA] = dasFeld[ElementB];
		 	dasFeld[ElementB] = hilfsZahl;
		}
	}
	
	
	static void FeldSortierenBubbleSort(int[] dasFeld) {
		int ptrA, ptrB;
		
		for (ptrA = 1; ptrA < cMaxZahlen; ptrA++) {
			for (ptrB = (cMaxZahlen - 1); ptrB >= ptrA; ptrB--) {
				if (dasFeld[(ptrB-1)] > dasFeld[(ptrB)]) {
					FeldElementTausch(dasFeld, (ptrB - 1), (ptrB));
				}
			}
		}
	}
	
	private static void ArrayDisplayValues(JTextArea TheTxtField,int[] dasFeld, int maxAnzahl) {
		//Deklation von notwendigen lokalen Variablen
		int counter;
		
		TheTxtField.setText(""); //Textfeld löschen

		for (counter = 0; counter < maxAnzahl ; counter++) {
			if (counter < 9) { 
				TheTxtField.append("#0" + (counter + 1) + " :: " + 
			                        Integer.toString(dasFeld[counter]) + "\n");
			} else {
				TheTxtField.append("#" + (counter + 1) + " :: " + 
		                         	Integer.toString(dasFeld[counter]) + "\n");				
			}
		}
		
		
	}
}

