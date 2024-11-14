import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class LRT1 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public JTextField textField;
    public JComboBox<String> cbDestination; // Destination ComboBox
    private JComboBox<String> cbCardType; // Card Type ComboBox
    private JComboBox<String> cbDiscountType; // Discount ComboBox
    public JComboBox<String> cbCurrentStation; // Current Station ComboBox
    public JButton btnNewButton;
    private JButton btnNewButton_1;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LRT1 frame = new LRT1();
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
    public LRT1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(94, 94, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // destination combobox
        cbDestination = new JComboBox<>(Main.Lrt1Stations);
        cbDestination.addActionListener(e -> {
            Main.comboBoxIndexChanged();
        });
        cbDestination.setBounds(30, 112, 121, 22);
        contentPane.add(cbDestination);
        

        JLabel lblNewLabel = new JLabel("Destination");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setBounds(30, 87, 132, 14);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(258, 173, 77, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Card type");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1.setBounds(30, 145, 132, 14);
        contentPane.add(lblNewLabel_1);

        // card type combobox
        cbCardType = new JComboBox<>(Main.CardTypes);
        cbCardType.addActionListener(e -> {
            Main.comboBoxIndexChanged();
        });
        cbCardType.setBounds(30, 172, 121, 22);
        contentPane.add(cbCardType);

        btnNewButton = new JButton("Transfer");
        btnNewButton.setBounds(247, 227, 89, 23);
        btnNewButton.addActionListener(e -> {
            Main.btnTransferPressed();
        });
        btnNewButton.setEnabled(false);
        contentPane.add(btnNewButton);

        btnNewButton_1 = new JButton("RIDE");
        btnNewButton_1.addActionListener(e -> {
            Main.btnRidePressed();
        });
        btnNewButton_1.setBounds(353, 227, 66, 23);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel_2 = new JLabel("Total fare:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_2.setBounds(188, 175, 114, 14);
        contentPane.add(lblNewLabel_2);

        // discount combobox
        cbDiscountType = new JComboBox<>(Main.DiscountTypes);
        cbDiscountType.addActionListener(e -> {
            Main.comboBoxIndexChanged();
        });
        cbDiscountType.setBounds(246, 50, 89, 22);
        contentPane.add(cbDiscountType);

        JLabel lblNewLabel_3 = new JLabel("Discount");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_3.setBounds(247, 26, 77, 14);
        contentPane.add(lblNewLabel_3);

        // current station combobox
        cbCurrentStation = new JComboBox<>(Main.Lrt1Stations);
        cbCurrentStation.addActionListener(e -> {
            Main.comboBoxIndexChanged();
        });
        cbCurrentStation.setBounds(30, 50, 121, 22);
        contentPane.add(cbCurrentStation);

        JLabel lblNewLabel_4 = new JLabel("Current Station");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_4.setBounds(30, 26, 132, 14);
        contentPane.add(lblNewLabel_4);
    }
    
    public String getCurrentStation(){
        return (String) cbCurrentStation.getSelectedItem();
    }
    public String getDestination(){
        return (String) cbDestination.getSelectedItem();
    }
    public String getDiscountType(){
        return (String) cbDiscountType.getSelectedItem();
    }
    public String getCardType(){
        return (String) cbCardType.getSelectedItem();
    }
}
