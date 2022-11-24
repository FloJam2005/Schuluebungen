package Q1P2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class FeldGUI2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldZahl1;
	private JTextField textFieldZahl2;
	private static int[] feld;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeldGUI2 frame = new FeldGUI2();
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
	public FeldGUI2() {
		feld = new int[20];
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Zahlenfeld mit 20 Werten");
		lblNewLabel.setBounds(20, 11, 171, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnInit = new JButton("Inititialisieren");
		
		btnInit.setBounds(239, 43, 114, 23);
		contentPane.add(btnInit);
		
		JButton btnRandomZahl = new JButton("Zufallszahlen");
		
		btnRandomZahl.setEnabled(false);
		btnRandomZahl.setBounds(239, 77, 114, 23);
		contentPane.add(btnRandomZahl);
		
		textFieldZahl1 = new JTextField();
		textFieldZahl1.setEnabled(false);
		textFieldZahl1.setBounds(264, 122, 86, 20);
		contentPane.add(textFieldZahl1);
		textFieldZahl1.setColumns(10);
		
		textFieldZahl2 = new JTextField();
		textFieldZahl2.setEnabled(false);
		textFieldZahl2.setBounds(264, 153, 86, 20);
		contentPane.add(textFieldZahl2);
		textFieldZahl2.setColumns(10);
		
		JButton btnChange = new JButton("Vertauschen");
		
		btnChange.setEnabled(false);
		btnChange.setBounds(239, 205, 114, 23);
		contentPane.add(btnChange);
		
		JButton btnSort = new JButton("Sortieren");
		
		btnSort.setEnabled(false);
		btnSort.setBounds(239, 239, 114, 23);
		contentPane.add(btnSort);
		
		JTextArea textAreaFeld = new JTextArea();
		textAreaFeld.setAutoscrolls(true);
		textAreaFeld.setBounds(20, 43, 209, 355);
		//JScrollPane scrollPane = new JScrollPane(textAreaFeld);
		contentPane.add(textAreaFeld);
		
		JTextArea textAreaOutput = new JTextArea();
		textAreaOutput.setBounds(20, 409, 333, 62);
		contentPane.add(textAreaOutput);
		
		
		
		// Actions
		
		btnInit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Feld.FeldFuellen(feld, feld.length, 0);
				feldAusgeben(textAreaFeld, feld);
				
				btnChange.setEnabled(true);
				btnRandomZahl.setEnabled(true);
				btnSort.setEnabled(true);
				textFieldZahl1.setEnabled(true);
				textFieldZahl2.setEnabled(true);
			}
		});
		
		btnRandomZahl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Feld.FeldFuellenZufallszahl(feld, feld.length, 100);
				feldAusgeben(textAreaFeld, feld);
			}
		});
		
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feld =Feld.mergeSort(feld);
				feldAusgeben(textAreaFeld, feld);
			}
		});
		
		
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int zahl1 = Integer.MIN_VALUE;
				int zahl2 = Integer.MIN_VALUE;
				try 
				{
					zahl1 = Integer.parseInt(textFieldZahl1.getText());
					zahl2 = Integer.parseInt(textFieldZahl2.getText());	
				}
				catch(NumberFormatException ex)
				{
					textFieldZahl1.setText("");
					textFieldZahl2.setText("");
					ausgeben(textAreaOutput, "Falsche Eingaben!");
					return;
					
				}
				
				if (zahl1 >= 0 && zahl2>=0)
				{
					if (zahl1 < feld.length && zahl2<feld.length)
					{
						int x = feld[zahl1];
						feld[zahl1] = feld[zahl2];
						feld[zahl2] = x;
						
						feldAusgeben(textAreaFeld, feld);
						return;
					}
				}
				ausgeben(textAreaOutput, "Ungültige Zahlen!");
				
			}
		});
		
		
		
		
		
		
		
		
	}
	
	
	private void feldAusgeben(JTextArea area, int[] feld)
	{
		area.setText("");
		for(int i =0; i<feld.length; i++)
		{
			area.append(i + ": " + feld[i] + "\n");
		}
	}
	
	private void ausgeben(JTextArea area, String s)
	{
		area.setText("");
		area.append(s +  "\n");
	}
}
