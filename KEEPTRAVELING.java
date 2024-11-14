
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class KEEPTRAVELING extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KEEPTRAVELING frame = new KEEPTRAVELING();
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
	public KEEPTRAVELING() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(94, 94, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THANK YOU ");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
		lblNewLabel.setBounds(153, 69, 140, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DO YOU WANT TO KEEP TRAVELING WITH US?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(91, 96, 274, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("YES");
		btnNewButton.setBounds(101, 130, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("NO");
		btnNewButton_1.setBounds(241, 130, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
