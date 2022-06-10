package datentypString;

/**
 * 
 * @author Florian Jambresic
 * Erstellen Sie ein Program, dass den Nutzer nach 2 Zahlen fragt und dann 
 * diese Zahlen ausmultipliziert. Die Anzahl der Ziffer im Produkt wird auf der Konsole ausgegeben
 *
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class Aufgabe1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldZahl1;
	private JTextField textFieldZahl2;
	private JTextField textFieldAusgabe;
	private ScheduledExecutorService ses;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aufgabe1 frame = new Aufgabe1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Aufgabe1() {
		this.ses = Executors.newScheduledThreadPool(1);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 265, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldZahl1 = new JTextField();
		textFieldZahl1.setBounds(10, 45, 86, 20);
		contentPane.add(textFieldZahl1);
		textFieldZahl1.setColumns(10);
		
		textFieldZahl2 = new JTextField();
		textFieldZahl2.setBounds(146, 45, 86, 20);
		contentPane.add(textFieldZahl2);
		textFieldZahl2.setColumns(10);
		
		textFieldAusgabe = new JTextField();
		textFieldAusgabe.setEditable(false);
		textFieldAusgabe.setBounds(10, 107, 222, 20);
		contentPane.add(textFieldAusgabe);
		textFieldAusgabe.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Zahl 1");
		lblNewLabel.setBounds(10, 20, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Zahl 2");
		lblNewLabel_1.setBounds(146, 20, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ziffern");
		lblNewLabel_2.setBounds(10, 82, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnBerechnen = new JButton("Berechnen");
		btnBerechnen.setBounds(7, 243, 114, 23);
		contentPane.add(btnBerechnen);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldAusgabe.setText("");
				textFieldZahl1.setText("");
				textFieldZahl2.setText("");
				
				textFieldZahl1.setEditable(true);
				textFieldZahl2.setEditable(true);
				btnReset.setEnabled(false);
				btnBerechnen.setEnabled(true);
				
				
			}
		});
		btnReset.setEnabled(false);
		btnReset.setBounds(131, 243, 108, 23);
		contentPane.add(btnReset);
		
		btnBerechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					double zahl1 = Double.parseDouble(textFieldZahl1.getText());
					double zahl2 = Double.parseDouble(textFieldZahl2.getText());
					int zuEntfernen = 1; // Wie viel am ende von der anzahl der Ziffern abgezogen wird. +1 für den Punkt +1 für letzte "0";
					
					String strErgebnis = String.valueOf(zahl1*zahl2);
					if (strErgebnis.endsWith("0")) {
						zuEntfernen ++; 
					}
					
					System.out.println(zahl1*zahl2);
					int ergebnis = strErgebnis.length() - zuEntfernen;
					
					textFieldAusgabe.setText(String.valueOf(ergebnis));
					
					textFieldZahl1.setEditable(false);
					textFieldZahl2.setEditable(false);
					btnBerechnen.setEnabled(false);
					btnReset.setEnabled(true);
				} catch (NumberFormatException e1) {
					// ungueltige eingabe -> wir lassen den User von dem Fehler wissen und er darf es nach 5 Sekunden neu versuchen.
					btnBerechnen.setEnabled(false);
					textFieldAusgabe.setText("Das war keine Gueltige eingabe!");
					ses.schedule(() -> {
						textFieldAusgabe.setText("");
						btnBerechnen.setEnabled(true);
					}, 5, TimeUnit.SECONDS); //Setzt den Text "Das war keine Gueltige eingabe nach 5 Sekunden zurueck, 
				}
				
				
			}
		});
	}
}
