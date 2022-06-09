package guthabenentwicklung;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Guthabenentwicklung extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldGuthaben;
	private JTextField textFieldZinssatz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guthabenentwicklung frame = new Guthabenentwicklung();
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
	public Guthabenentwicklung() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldGuthaben = new JTextField();
		textFieldGuthaben.setBounds(32, 53, 86, 20);
		contentPane.add(textFieldGuthaben);
		textFieldGuthaben.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Guthaben");
		lblNewLabel.setBounds(32, 28, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Zinssatz");
		lblNewLabel_1.setBounds(128, 28, 82, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldZinssatz = new JTextField();
		textFieldZinssatz.setBounds(128, 53, 86, 20);
		contentPane.add(textFieldZinssatz);
		textFieldZinssatz.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(32, 99, 338, 270);
		contentPane.add(textArea);
		
		JButton btnBerechnen = new JButton("Berechnen");
		
		btnBerechnen.setBounds(242, 52, 128, 23);
		contentPane.add(btnBerechnen);
		
		btnBerechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				try {
					double guthaben = Long.parseLong(textFieldGuthaben.getText());
					double zinssatz = Double.parseDouble(textFieldZinssatz.getText());
					String ausgabe = "%s.Jahr Guthaben: %s€ \n";
					for(int i = 1; i<=10; i++) {
						double aktuellesGuthaben = guthaben * (1 + zinssatz / 100);
						guthaben = guthaben + ((guthaben * zinssatz) / 100);  //KLammern zum verdeutlichen -> Nicht relevant
						
						
						double gerundetesGuthaben = Math.round((aktuellesGuthaben*100.0))/100.0;
						textArea.append(ausgabe.formatted(i, gerundetesGuthaben));
					}
					
				} catch(NumberFormatException ex) {
					textArea.setText("Das war keine gültige eingabe!");
				}
			}
		});
	}
}
