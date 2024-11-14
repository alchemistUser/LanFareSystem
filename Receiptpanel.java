import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Receiptpanel extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Receiptpanel frame = new Receiptpanel();
                    frame.setTitle("Receipt");
                    // Add a WindowListener to handle the window closing event
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
    public Receiptpanel() {
        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Prevent default closing behavior

        
        // Initialize content panel
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null); // Use null layout for absolute positioning

        // Create a JTextArea
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        // Set the bounds of the JScrollPane to include a 10px margin
        scrollPane.setBounds(10, 10, 410, 210); // 450 - 10px margin on each side = 430 width, 300 - 10px margin on top and bottom = 260 height

        JButton button = new JButton("New Transaction"){{
            setBounds(10, 223, 410, 30);
        }};
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.btnNewTransactionPressed();
            }
        });
        
        // Add the scroll pane to the content pane
        contentPane.add(scrollPane);
        contentPane.add(button);
    }
}