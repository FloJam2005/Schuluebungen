package ggt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GGT extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldZahlEins;
	private JTextField textFieldZahlZwei;
	private JTextField textFieldAusgabe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GGT frame = new GGT();
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
	public GGT() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 322, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldZahlEins = new JTextField();
		textFieldZahlEins.setBounds(37, 68, 86, 20);
		contentPane.add(textFieldZahlEins);
		textFieldZahlEins.setColumns(10);
		
		textFieldZahlZwei = new JTextField();
		textFieldZahlZwei.setBounds(155, 68, 86, 20);
		contentPane.add(textFieldZahlZwei);
		textFieldZahlZwei.setColumns(10);
		
		textFieldAusgabe = new JTextField();
		textFieldAusgabe.setEditable(false);
		textFieldAusgabe.setBounds(37, 128, 204, 20);
		contentPane.add(textFieldAusgabe);
		textFieldAusgabe.setColumns(10);
		
		JButton btnGetGGT = new JButton("berechnen");
		
		btnGetGGT.setBounds(34, 207, 144, 23);
		contentPane.add(btnGetGGT);
		
		JLabel lblNewLabel = new JLabel("Zahl 1");
		lblNewLabel.setBounds(37, 43, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Zahl 2");
		lblNewLabel_1.setBounds(155, 43, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("GGT");
		lblNewLabel_2.setBounds(37, 103, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		
		
		btnGetGGT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int m,n,r;
				
				try {
					m = Integer.parseInt(textFieldZahlEins.getText());
					n = Integer.parseInt(textFieldZahlZwei.getText());
					
					r = m%n;
					
					int i = 0;
					while ((r = m%n) > 0) {
						
						m = n;
						n = r;
					}
					
					textFieldAusgabe.setText("" + n);
				}catch(NumberFormatException ex) {
					textFieldAusgabe.setText("Das war keine gültige Eingabe!");
				}
			}
		});
	}
}
