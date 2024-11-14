import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton btnLrt1, btnLrt2, btnMrt, btnExit;
    private JLabel lblWelcome, lblMenu;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainMenu frame = new MainMenu();
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
    public MainMenu() {
        setBackground(new Color(94, 94, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 324, 428);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(94, 94, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Welcome Label
        lblWelcome = new JLabel("WELCOME");
        lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblWelcome.setBounds(109, 28, 85, 30);
        contentPane.add(lblWelcome);

        // LRT 1 Button
        btnLrt1 = new JButton("LRT 1");
        btnLrt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.btnLrt1Pressed();
            }
        });
        btnLrt1.setBounds(105, 127, 89, 23);
        contentPane.add(btnLrt1);

        // LRT 2 Button
        btnLrt2 = new JButton("LRT 2");
        btnLrt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.btnLrt2Pressed();
            }
        });
        btnLrt2.setBounds(105, 173, 89, 23);
        contentPane.add(btnLrt2);

        // MRT Button
        btnMrt = new JButton("MRT");
        btnMrt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.btnMrtPressed();
            }
        });
        btnMrt.setBounds(105, 213, 89, 23);
        contentPane.add(btnMrt);

        // Exit Button
        btnExit = new JButton("EXIT");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnExit.setBounds(105, 279, 89, 23);
        contentPane.add(btnExit);

        // Menu Label
        lblMenu = new JLabel("MENU");
        lblMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblMenu.setBounds(119, 96, 67, 20);
        contentPane.add(lblMenu);
    }
}
