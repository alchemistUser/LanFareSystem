import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MRT extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    protected JTextField textField; // Changed to protected
    public JComboBox<String> cbDestination; // Changed to protected
    protected JComboBox<String> cbCardType; // Changed to protected
    protected JComboBox<String> cbDiscountType; // Changed to protected
    public JComboBox<String> cbCurrentStation; // Changed to protected
    public JButton btnTransfer; // Changed to protected
    protected JButton btnRide; // Changed to protected


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MRT frame = new MRT();
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
    public MRT() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(94, 94, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        cbDestination = new JComboBox<>(Main.MrtStations); // Changed to protected
        cbDestination.addActionListener(e -> {
            Main.comboBoxIndexChanged();
        });
        cbDestination.setBounds(30, 112, 121, 22);
        contentPane.add(cbDestination);
        
        
        JLabel lblDestination = new JLabel("Destination");
        lblDestination.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDestination.setBounds(30, 87, 132, 14);
        contentPane.add(lblDestination);
        
        textField = new JTextField();
        textField.setBounds(258, 173, 77, 20);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel lblCardType = new JLabel("Card type");
        lblCardType.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblCardType.setBounds(30, 145, 132, 14);
        contentPane.add(lblCardType);
        
        cbCardType = new JComboBox<>(Main.CardTypes); // Changed to protected
        cbCardType.addActionListener(e -> {
            Main.comboBoxIndexChanged();
        });
        cbCardType.setBounds(30, 172, 121, 22);
        contentPane.add(cbCardType);
        
        btnTransfer = new JButton("Transfer"); // Changed to protected
        btnTransfer.setBounds(247, 227, 89, 23);
        btnTransfer.addActionListener(e -> {
            Main.btnTransferPressed();
        });
        btnTransfer.setEnabled(false);
        contentPane.add(btnTransfer);
        
        btnRide = new JButton("RIDE"); // Changed to protected
        btnRide.setBounds(353, 227, 66, 23);
        btnRide.addActionListener(e -> {
            Main.btnRidePressed();
        });
        contentPane.add(btnRide);
        
        JLabel lblTotalFare = new JLabel("Total fare:");
        lblTotalFare.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTotalFare.setBounds(188, 175, 114, 14);
        contentPane.add(lblTotalFare);
        
        cbDiscountType = new JComboBox<>(Main.DiscountTypes); // Changed to protected
        cbDiscountType.addActionListener(e -> {
            Main.comboBoxIndexChanged();
        });
        cbDiscountType.setBounds(246, 50, 89, 22);
        contentPane.add(cbDiscountType);
        
        JLabel lblDiscount = new JLabel("Discount");
        lblDiscount.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblDiscount.setBounds(247, 26, 77, 14);
        contentPane.add(lblDiscount);
        
        cbCurrentStation = new JComboBox<>(Main.MrtStations); // Changed to protected
        cbCurrentStation.addActionListener(e -> {
            Main.comboBoxIndexChanged();
        });
        cbCurrentStation.setBounds(30, 50, 121, 22);
        contentPane.add(cbCurrentStation);
        
        JLabel lblCurrentStation = new JLabel("Current Station");
        lblCurrentStation.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblCurrentStation.setBounds(30, 26, 132, 14);
        contentPane.add(lblCurrentStation);
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