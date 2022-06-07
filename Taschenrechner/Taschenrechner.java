package main.de.Florian.Taschenrechner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Taschenrechner extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField eingabeEins;
	private JTextField eingabeZwei;
	private JTextField textField_Modus;
	private JTextField istGleich;
	private JTextField textFieldErgebnis;
	private JButton btnClear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Taschenrechner frame = new Taschenrechner();
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
	public Taschenrechner() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 327, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		eingabeEins = new JTextField();
		eingabeEins.setBounds(24, 80, 86, 20);
		contentPane.add(eingabeEins);
		eingabeEins.setColumns(10);
		
		JLabel labelEingabe1 = new JLabel("Eingabe Eins");
		labelEingabe1.setBounds(24, 55, 86, 14);
		contentPane.add(labelEingabe1);
		
		eingabeZwei = new JTextField();
		eingabeZwei.setBounds(169, 80, 86, 20);
		contentPane.add(eingabeZwei);
		eingabeZwei.setColumns(10);
		
		JLabel labelEingabeZwei = new JLabel("Eingabe Zwei");
		labelEingabeZwei.setBounds(169, 55, 86, 14);
		contentPane.add(labelEingabeZwei);
		
		textField_Modus = new JTextField();
		textField_Modus.setText("?");
		textField_Modus.setEditable(false);
		textField_Modus.setBounds(129, 80, 19, 20);
		contentPane.add(textField_Modus);
		textField_Modus.setColumns(10);
		
		JButton btnAddieren = new JButton("Addieren");
		
		btnAddieren.setBounds(21, 192, 104, 23);
		contentPane.add(btnAddieren);
		
		istGleich = new JTextField();
		istGleich.setEditable(false);
		istGleich.setText("=");
		istGleich.setBounds(24, 121, 86, 20);
		contentPane.add(istGleich);
		istGleich.setColumns(10);
		
		textFieldErgebnis = new JTextField();
		textFieldErgebnis.setEnabled(false);
		textFieldErgebnis.setEditable(false);
		textFieldErgebnis.setBounds(24, 161, 231, 20);
		contentPane.add(textFieldErgebnis);
		textFieldErgebnis.setColumns(10);
		
		JButton btnSubtrahieren = new JButton("Subtrahieren");
		
		btnSubtrahieren.setBounds(151, 192, 104, 23);
		contentPane.add(btnSubtrahieren);
		
		JButton btnMultiplizieren = new JButton("Multiplizieren");
		
		btnMultiplizieren.setBounds(24, 237, 101, 23);
		contentPane.add(btnMultiplizieren);
		
		JButton btnDividieren = new JButton("Dividieren");
		btnDividieren.setBounds(151, 237, 104, 23);
		contentPane.add(btnDividieren);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset(eingabeEins, eingabeZwei, textFieldErgebnis, textField_Modus, btnAddieren, btnSubtrahieren, btnMultiplizieren, btnDividieren);
			}
		});
		btnClear.setBounds(92, 323, 89, 23);
		contentPane.add(btnClear);
		
		btnAddieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double[] zahlen = getInputs(eingabeEins, eingabeZwei);
					double ergebnis = zahlen[0] + zahlen[1];
					textField_Modus.setText("+");
					onInput(""+ergebnis, eingabeEins, eingabeZwei, textFieldErgebnis, btnAddieren, btnSubtrahieren, btnMultiplizieren, btnDividieren);
				}catch (NumberFormatException exception) {
					onInput("Falsche Eingabe!", eingabeEins, eingabeZwei, textFieldErgebnis, btnAddieren, btnSubtrahieren, btnMultiplizieren, btnDividieren);
				}
			}
		});
		
		btnSubtrahieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double[] zahlen = getInputs(eingabeEins, eingabeZwei);
					double ergebnis = zahlen[0] - zahlen[1];
					textField_Modus.setText("-");
					onInput(""+ergebnis, eingabeEins, eingabeZwei, textFieldErgebnis, btnAddieren, btnSubtrahieren, btnMultiplizieren, btnDividieren);
				}catch (NumberFormatException exception) {
					onInput("Falsche Eingabe!", eingabeEins, eingabeZwei, textFieldErgebnis, btnAddieren, btnSubtrahieren, btnMultiplizieren, btnDividieren);
				}
			}
		});
		
		btnMultiplizieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double[] zahlen = getInputs(eingabeEins, eingabeZwei);
					double ergebnis = zahlen[0] * zahlen[1];
					textField_Modus.setText("*");
					onInput(""+ergebnis, eingabeEins, eingabeZwei, textFieldErgebnis, btnAddieren, btnSubtrahieren, btnMultiplizieren, btnDividieren);
				}catch (NumberFormatException exception) {
					onInput("Falsche Eingabe!", eingabeEins, eingabeZwei, textFieldErgebnis, btnAddieren, btnSubtrahieren, btnMultiplizieren, btnDividieren);
				}
			}
		});
		
		
		btnDividieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double[] zahlen = getInputs(eingabeEins, eingabeZwei);
					double ergebnis = zahlen[0] / zahlen[1];
					textField_Modus.setText("/");
					onInput(""+ergebnis, eingabeEins, eingabeZwei, textFieldErgebnis, btnAddieren, btnSubtrahieren, btnMultiplizieren, btnDividieren);
				}catch (NumberFormatException exception) {
					onInput("Falsche Eingabe!", eingabeEins, eingabeZwei, textFieldErgebnis, btnAddieren, btnSubtrahieren, btnMultiplizieren, btnDividieren);
				}
				
			}
		});
		
	}
	
	private double[] getInputs(JTextField field1, JTextField field2) throws NumberFormatException {
		double[] zahlen = new double[2];
		
		try {
			double zahl1 = Double.parseDouble(field1.getText().replace(",", "."));
			double zahl2 = Double.parseDouble(field2.getText().replace(",", "."));
			zahlen[0] = zahl1;
			zahlen[1] = zahl2;
			return zahlen;
		}catch(NumberFormatException e) {
			throw e;
		}
		
		
	}
	
	
	private void onInput(String zahl, JTextField field1, JTextField field2, JTextField ausgabe, JButton btnAddieren, JButton btnSubtrahieren, JButton btnMultiplizieren, JButton btnDividieren) {
		ausgabe.setText("" + zahl.replace(".", ","));
		ausgabe.setEnabled(true);
		
		//field1.setEnabled(false);
		//field2.setEnabled(false);
		
		field2.setEditable(false);
		field1.setEditable(false);
		
		btnAddieren.setEnabled(false);
		btnSubtrahieren.setEnabled(false);
		btnMultiplizieren.setEnabled(false);
		btnDividieren.setEnabled(false);
		
	}
	
	
	
	private void reset(JTextField field1, JTextField field2, JTextField ausgabe, JTextField modus, JButton btnAddieren, JButton btnSubtrahieren, JButton btnMultiplizieren, JButton btnDividieren) {
		ausgabe.setText("");
		ausgabe.setEnabled(false);
		
		field1.setText("");
		field1.setEnabled(true);
		field1.setEditable(true);
		
		field2.setText("");
		field2.setEnabled(true);
		field2.setEditable(true);
		
		
		btnAddieren.setEnabled(true);
		btnSubtrahieren.setEnabled(true);
		btnMultiplizieren.setEnabled(true);
		btnDividieren.setEnabled(true);
		
		modus.setText("?");
		
	}
	
	
	
	
}
