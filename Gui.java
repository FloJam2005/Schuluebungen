package main.de.florian.windowBuilder;

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
import javax.swing.SwingConstants;


public class Gui extends JFrame {

	private JPanel contentPane;
	private JTextField textField_für_was_steht_gui;
	private JTextField textField_was_ist_das_gui;
	private JTextField textField_ausgabe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
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
	public Gui() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_für_was_steht_gui = new JTextField();
		textField_für_was_steht_gui.setBounds(242, 98, 185, 20);
		contentPane.add(textField_für_was_steht_gui);
		textField_für_was_steht_gui.setColumns(10);
		
		JLabel label_Für_was_steht_GUI = new JLabel("F\u00FCr was steht GUI?");
		label_Für_was_steht_GUI.setHorizontalAlignment(SwingConstants.RIGHT);
		label_Für_was_steht_GUI.setBounds(28, 101, 204, 14);
		contentPane.add(label_Für_was_steht_GUI);
		
		textField_was_ist_das_gui = new JTextField();
		textField_was_ist_das_gui.setBounds(242, 146, 185, 20);
		contentPane.add(textField_was_ist_das_gui);
		textField_was_ist_das_gui.setColumns(10);
		
		JLabel label_Was_ist_das_GUI = new JLabel("Was ist das GUI?");
		label_Was_ist_das_GUI.setHorizontalAlignment(SwingConstants.RIGHT);
		label_Was_ist_das_GUI.setBounds(28, 149, 204, 14);
		contentPane.add(label_Was_ist_das_GUI);
		
		JButton btn_löschen = new JButton("l\u00F6schen");
		btn_löschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Löscht den Text
				textField_für_was_steht_gui.setText("");
			}
		});
		btn_löschen.setBounds(461, 97, 89, 23);
		contentPane.add(btn_löschen);
		
		JButton btn_antwort = new JButton("Antwort");
		btn_antwort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//kopiert den oben eingegebenen Text in das Zweitefeld
				String eingabe = textField_für_was_steht_gui.getText();
				textField_was_ist_das_gui.setText(eingabe);
			}
		});
		btn_antwort.setBounds(461, 145, 89, 23);
		contentPane.add(btn_antwort);
		
		JLabel label_Ausgabe = new JLabel("Ausgabe");
		label_Ausgabe.setHorizontalAlignment(SwingConstants.RIGHT);
		label_Ausgabe.setBounds(28, 189, 204, 14);
		contentPane.add(label_Ausgabe);
		
		textField_ausgabe = new JTextField();
		textField_ausgabe.setBounds(242, 186, 185, 20);
		contentPane.add(textField_ausgabe);
		textField_ausgabe.setColumns(10);
		
		JButton btn_kopieren = new JButton("kopieren");
		btn_kopieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//kopiert den Text vom zweiten ins Dritte feld
				String eingabe = textField_was_ist_das_gui.getText();
				textField_ausgabe.setText(eingabe);
			}
		});
		btn_kopieren.setBounds(461, 185, 89, 23);
		contentPane.add(btn_kopieren);
	}
}
