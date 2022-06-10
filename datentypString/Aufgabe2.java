package datentypString;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Aufgabe2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEingabe1;
	private JTextField textFieldEingabe2;
	private JTextField textFieldAnfang1;
	private JTextField textFieldAnfang2;
	private JTextField textFieldAlphabet1;
	private JTextField textFieldAlphabet2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aufgabe2 frame = new Aufgabe2();
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
	public Aufgabe2() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldEingabe1 = new JTextField();
		textFieldEingabe1.setBounds(23, 47, 517, 20);
		contentPane.add(textFieldEingabe1);
		textFieldEingabe1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Eingabe1");
		lblNewLabel.setBounds(24, 22, 516, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Eingabe2");
		lblNewLabel_1.setBounds(23, 86, 517, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldEingabe2 = new JTextField();
		textFieldEingabe2.setBounds(23, 111, 517, 20);
		contentPane.add(textFieldEingabe2);
		textFieldEingabe2.setColumns(10);
		
		textFieldAnfang1 = new JTextField();
		textFieldAnfang1.setEditable(false);
		textFieldAnfang1.setBounds(168, 149, 86, 20);
		contentPane.add(textFieldAnfang1);
		textFieldAnfang1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Anfangsbuchstabe 1");
		lblNewLabel_2.setBounds(23, 152, 141, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Anfangsbuchstabe 2");
		lblNewLabel_3.setBounds(23, 177, 141, 14);
		contentPane.add(lblNewLabel_3);
		
		textFieldAnfang2 = new JTextField();
		textFieldAnfang2.setEditable(false);
		textFieldAnfang2.setBounds(168, 174, 86, 20);
		contentPane.add(textFieldAnfang2);
		textFieldAnfang2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Alphabet");
		lblNewLabel_4.setBounds(575, 22, 60, 14);
		contentPane.add(lblNewLabel_4);
		
		textFieldAlphabet1 = new JTextField();
		textFieldAlphabet1.setEditable(false);
		textFieldAlphabet1.setBounds(550, 47, 86, 20);
		contentPane.add(textFieldAlphabet1);
		textFieldAlphabet1.setColumns(10);
		
		textFieldAlphabet2 = new JTextField();
		textFieldAlphabet2.setEditable(false);
		textFieldAlphabet2.setBounds(550, 111, 86, 20);
		contentPane.add(textFieldAlphabet2);
		textFieldAlphabet2.setColumns(10);
		
		JButton btnUeberpruefen = new JButton("Ueberpruefen");
		
		btnUeberpruefen.setBounds(481, 173, 154, 23);
		contentPane.add(btnUeberpruefen);
		
		JButton btnReset = new JButton("Reset");
		
		btnReset.setEnabled(false);
		btnReset.setBounds(303, 173, 154, 23);
		contentPane.add(btnReset);
		
		
		
		btnUeberpruefen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eingabe1 = textFieldEingabe1.getText().toLowerCase();
				String eingabe2 = textFieldEingabe2.getText().toLowerCase();
				
				char eingabe1FirstChar = textFieldEingabe1.getText().charAt(0); // Damit der Erste Buchstabe auch die richtige Groﬂ- und Kleinschreibung
				char eingabe2FirstChar = textFieldEingabe2.getText().charAt(0);
				
				
				
				
				if (eingabe1.compareTo(eingabe2)<0) {
					textFieldAlphabet1.setText("1");
					textFieldAlphabet2.setText("2");
				} else {
					textFieldAlphabet1.setText("2");
					textFieldAlphabet2.setText("1");
				}
				
				textFieldAnfang1.setText(String.valueOf(eingabe1FirstChar));
				textFieldAnfang2.setText(String.valueOf(eingabe2FirstChar));
				
				
				btnReset.setEnabled(true);
				btnUeberpruefen.setEnabled(false);
				textFieldEingabe1.setEditable(false);
				textFieldEingabe2.setEditable(false);
			}
		});
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldAlphabet1.setText("");
				textFieldAlphabet2.setText("");
				
				textFieldAnfang1.setText("");
				textFieldAnfang2.setText("");
				
				textFieldEingabe1.setText("");
				textFieldEingabe2.setText("");
				
				textFieldEingabe1.setEditable(true);
				textFieldEingabe2.setEditable(true);
				
				btnUeberpruefen.setEnabled(true);
				btnReset.setEnabled(false);
			}
		});
	}
}
