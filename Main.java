import java.util.ArrayList;
import javax.swing.SwingUtilities;

class ReceiptObject {
    public String text;
    public double value;
    
    public ReceiptObject(String text, double value){
        this.text = text;
        this.value = value;
    }
    
    public String getText(){
        return text;
    }
    public double getValue(){
        return value;
    }
}
public class Main {
    static String currentFrame = new String();
    static String startStation = new String();
    static String endStation = new String();
    static String discountType = new String();
    static String cardType = new String();
    static double totalfare;
    
    static ArrayList<ReceiptObject> receiptList = new ArrayList();
    static final String[] CardTypes = {"Single Journey", "Beep"};
    static final String[] DiscountTypes = {"Regular", "Student", "Senior Citizen", "PWD"};
    static final String[] Lrt1Stations = {
            "Baclaran Station",
            "EDSA Station",
            "Libertad Station",
            "Gil Puyat Station",
            "Vito Cruz Station",
            "Quirino Station",
            "Pedro Gil Station",
            "UN Avenue Station",
            "Central Terminal Station",
            "Carriedo Station",
            "Doroteo Jose Station",
            "Bambang Station",
            "Tayuman Station",
            "Blumentritt Station",
            "Abad Santos Station",
            "R. Papa Station",
            "5th Avenue Station",
            "Monumento Station",
            "Balintawak Station",
            "Fernando Poe Jr. Station"
        };
    static final double[][] Lrt1FareMatrix_SingleJourney = {
            {0, 15, 15, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 30, 30, 30, 30, 30, 35, 35},
            {15, 0, 15, 15, 20, 20, 20, 20, 25, 25, 25, 25, 25, 25, 30, 30, 30, 30, 35, 35},
            {15, 15, 0, 15, 15, 20, 20, 20, 20, 25, 25, 25, 25, 25, 25, 30, 30, 30, 35, 35},
            {20, 15, 15, 0, 15, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 25, 30, 30, 30, 35},
            {20, 20, 15, 15, 0, 15, 15, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 30, 30, 35},
            {20, 20, 20, 20, 15, 0, 15, 15, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 30, 30},
            {20, 20, 20, 20, 15, 15, 0, 15, 20, 20, 20, 20, 20, 20, 25, 25, 25, 25, 30, 30},
            {20, 20, 20, 20, 20, 15, 15, 0, 15, 20, 20, 20, 20, 20, 20, 25, 25, 25, 30, 30},
            {25, 25, 20, 20, 20, 20, 20, 15, 0, 15, 15, 20, 20, 20, 20, 20, 20, 25, 25, 30},
            {25, 25, 25, 20, 20, 20, 20, 20, 15, 0, 15, 15, 20, 20, 20, 20, 20, 25, 25, 30},
            {25, 25, 25, 25, 20, 20, 20, 20, 20, 15, 0, 15, 15, 20, 20, 20, 20, 20, 25, 25},
            {25, 25, 25, 25, 20, 20, 20, 20, 20, 15, 15, 0, 15, 15, 20, 20, 20, 20, 25, 25},
            {25, 25, 25, 25, 25, 20, 20, 20, 20, 20, 15, 15, 0, 15, 15, 20, 20, 20, 25, 25},
            {30, 25, 25, 25, 25, 25, 20, 20, 20, 20, 20, 15, 15, 0, 15, 15, 20, 20, 20, 25},
            {30, 30, 25, 25, 25, 25, 25, 20, 20, 20, 20, 15, 15, 15, 0, 15, 15, 20, 20, 25},
            {30, 30, 30, 25, 25, 25, 25, 25, 20, 20, 20, 20, 20, 15, 15, 0, 15, 20, 20, 25},
            {30, 30, 30, 30, 25, 25, 25, 25, 20, 20, 20, 20, 20, 20, 15, 15, 0, 15, 20, 20},
            {30, 30, 30, 30, 30, 25, 25, 25, 25, 25, 20, 20, 20, 20, 20, 20, 15, 0, 20, 20},
            {35, 35, 35, 30, 30, 30, 30, 30, 25, 25, 25, 25, 25, 20, 20, 20, 20, 20, 0, 20},
            {35, 35, 35, 35, 35, 30, 30, 30, 30, 30, 25, 25, 25, 25, 25, 25, 20, 20, 20, 0}
        };
    static final double[][] Lrt1FareMatrix_Beep = {
            // Baclaran, EDSA, Libertad, Gil Puyat, Vito Cruz, Quirino, Pedro Gil, UN Avenue, Central Terminal, Carriedo, Doroteo Jose, Bambang, Tayuman, Blumentritt, Abad Santos, R. Papa, 5th Avenue, Monumento, Balintawak, Fernando Poe Jr.
            {0, 13, 13, 15, 15, 15, 15, 15, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 30, 30},  // Baclaran
            {13, 0, 13, 13, 15, 15, 15, 15, 20, 20, 20, 20, 20, 20, 25, 25, 25, 25, 30, 30},  // EDSA
            {13, 13, 0, 13, 15, 15, 15, 15, 15, 20, 20, 20, 20, 20, 20, 25, 25, 25, 30, 30},  // Libertad
            {15, 13, 13, 0, 13, 15, 15, 15, 15, 15, 20, 20, 20, 20, 20, 20, 25, 25, 30, 30},  // Gil Puyat
            {15, 15, 15, 13, 0, 13, 13, 15, 15, 15, 15, 15, 20, 20, 20, 20, 20, 25, 25, 30},  // Vito Cruz
            {15, 15, 15, 15, 13, 0, 13, 13, 15, 15, 15, 15, 15, 20, 20, 20, 20, 20, 25, 25},  // Quirino
            {15, 15, 15, 15, 13, 13, 0, 13, 15, 15, 15, 15, 15, 15, 20, 20, 20, 20, 25, 25},  // Pedro Gil
            {15, 15, 15, 15, 15, 13, 13, 0, 13, 15, 15, 15, 15, 15, 15, 20, 20, 20, 25, 25},  // UN Avenue
            {20, 20, 15, 15, 15, 15, 15, 13, 0, 13, 13, 15, 15, 15, 15, 15, 15, 20, 20, 25},  // Central Terminal
            {20, 20, 20, 15, 15, 15, 15, 15, 13, 0, 13, 13, 15, 15, 15, 15, 15, 20, 20, 25},  // Carriedo
            {20, 20, 20, 20, 15, 15, 15, 15, 15, 13, 0, 13, 13, 15, 15, 15, 15, 15, 20, 20},  // Doroteo Jose
            {20, 20, 20, 20, 15, 15, 15, 15, 15, 13, 13, 0, 13, 13, 15, 15, 15, 15, 20, 20},  // Bambang
            {20, 20, 20, 20, 15, 15, 15, 15, 15, 13, 13, 13, 0, 13, 15, 15, 15, 15, 20, 20},  // Tayuman
            {25, 20, 20, 20, 20, 20, 15, 15, 15, 15, 15, 13, 13, 0, 13, 15, 15, 15, 20, 20},  // Blumentritt
            {25, 25, 20, 20, 20, 20, 15, 15, 15, 15, 15, 13, 13, 13, 0, 13, 15, 15, 15, 20},  // Abad Santos
            {25, 25, 25, 20, 20, 20, 20, 15, 15, 15, 15, 13, 13, 13, 13, 0, 13, 15, 15, 20},  // R. Papa
            {25, 25, 25, 25, 20, 20, 20, 20, 15, 15, 15, 15, 15, 13, 13, 13, 0, 13, 15, 15},  // 5th Avenue
            {25, 25, 25, 25, 25, 20, 20, 20, 15, 15, 15, 15, 15, 13, 13, 13, 13, 0, 13, 15},  // Monumento
            {30, 30, 25, 25, 25, 25, 25, 25, 20, 20, 20, 20, 20, 15, 15, 15, 15, 13, 0, 13},  // Balintawak
            {30, 30, 30, 25, 25, 25, 25, 25, 20, 20, 20, 20, 20, 15, 15, 15, 15, 13, 13, 0}   // Fernando Poe Jr.
        };
    static final String[] Lrt2Stations = {
            "Recto Station",
            "Legarda Station",
            "Pureza Station",
            "V. Mapa Station",
            "J. Ruiz Station",
            "Gilmore Station",
            "Betty Go-Belmonte Station",
            "Araneta Center-Cubao Station",
            "Anonas Station",
            "Katipunan Station",
            "Santolan Station",
            "Marikina-Pasig Station",
            "Antipolo Station"
        };
    static final double[][] Lrt2FareMatrix_SingleJourney = {
        // Recto    Legarda  Pureza   VMapa    JRuiz    Gilmore  BettyGo  Cubao    Anonas   Katipunan  Santolan  Marikina  Antipolo
        {  0.0,     15.0,    20.0,    20.0,    20.0,    25.0,    25.0,    25.0,    25.0,    30.0,      30.0,     35.0,     35.0   }, // Recto
        { 15.0,     0.0,     15.0,    15.0,    20.0,    20.0,    20.0,    20.0,    25.0,    25.0,      30.0,     35.0,     35.0   }, // Legarda
        { 20.0,     15.0,    0.0,     15.0,    15.0,    20.0,    20.0,    20.0,    25.0,    25.0,      30.0,     35.0,     35.0   }, // Pureza
        { 20.0,     15.0,    15.0,    0.0,     15.0,    20.0,    20.0,    20.0,    25.0,    25.0,      30.0,     35.0,     35.0   }, // V. Mapa
        { 20.0,     20.0,    15.0,    15.0,    0.0,     15.0,    20.0,    20.0,    25.0,    25.0,      30.0,     35.0,     35.0   }, // J. Ruiz
        { 25.0,     20.0,    20.0,    20.0,    15.0,    0.0,     15.0,    20.0,    25.0,    25.0,      30.0,     35.0,     35.0   }, // Gilmore
        { 25.0,     20.0,    20.0,    20.0,    20.0,    15.0,    0.0,     15.0,    20.0,    25.0,      30.0,     35.0,     35.0   }, // Betty Go-Belmonte
        { 25.0,     20.0,    20.0,    20.0,    20.0,    20.0,    15.0,    0.0,     15.0,    20.0,      30.0,     35.0,     35.0   }, // Araneta Center-Cubao
        { 25.0,     25.0,    25.0,    25.0,    25.0,    25.0,    20.0,    15.0,    0.0,     15.0,      25.0,     30.0,     35.0   }, // Anonas
        { 30.0,     25.0,    25.0,    25.0,    25.0,    25.0,    25.0,    20.0,    15.0,    0.0,       15.0,     25.0,     30.0   }, // Katipunan
        { 30.0,     30.0,    30.0,    30.0,    30.0,    30.0,    30.0,    30.0,    25.0,    15.0,      0.0,      15.0,     20.0   }, // Santolan
        { 35.0,     35.0,    35.0,    35.0,    35.0,    35.0,    35.0,    35.0,    30.0,    25.0,      15.0,     0.0,      15.0   }, // Marikina-Pasig
        { 35.0,     35.0,    35.0,    35.0,    35.0,    35.0,    35.0,    35.0,    35.0,    30.0,      20.0,     15.0,     0.0    }  // Antipolo
    };
    static final double[][] Lrt2FareMatrix_Beep = {
        // Recto    Legarda  Pureza   VMapa    JRuiz    Gilmore  BettyGo  Cubao    Anonas   Katipunan  Santolan  Marikina  Antipolo
        {  0.0,     15.0,    16.0,    18.0,    19.0,    21.0,    22.0,    23.0,    25.0,    26.0,      28.0,     31.0,     33.0   }, // Recto
        { 15.0,     0.0,     15.0,    16.0,    18.0,    19.0,    21.0,    22.0,    23.0,    25.0,      27.0,     30.0,     32.0   }, // Legarda
        { 16.0,     15.0,    0.0,     15.0,    16.0,    18.0,    19.0,    21.0,    22.0,    23.0,      25.0,     28.0,     30.0   }, // Pureza
        { 18.0,     16.0,    15.0,    0.0,     15.0,    16.0,    18.0,    19.0,    21.0,    22.0,      24.0,     27.0,     29.0   }, // V. Mapa
        { 19.0,     18.0,    16.0,    15.0,    0.0,     15.0,    16.0,    18.0,    19.0,    21.0,      23.0,     26.0,     28.0   }, // J. Ruiz
        { 21.0,     19.0,    18.0,    16.0,    15.0,    0.0,     15.0,    16.0,    18.0,    19.0,      21.0,     24.0,     26.0   }, // Gilmore
        { 22.0,     21.0,    19.0,    18.0,    16.0,    15.0,    0.0,     15.0,    16.0,    18.0,      20.0,     23.0,     25.0   }, // Betty Go-Belmonte
        { 23.0,     22.0,    21.0,    19.0,    18.0,    16.0,    15.0,    0.0,     15.0,    16.0,      18.0,     21.0,     23.0   }, // Araneta Center-Cubao
        { 25.0,     23.0,    22.0,    21.0,    19.0,    18.0,    16.0,    15.0,    0.0,     15.0,      16.0,     19.0,     21.0   }, // Anonas
        { 26.0,     25.0,    23.0,    22.0,    21.0,    19.0,    18.0,    16.0,    15.0,    0.0,       15.0,     17.0,     20.0   }, // Katipunan
        { 28.0,     27.0,    25.0,    24.0,    23.0,    21.0,    20.0,    18.0,    16.0,    15.0,      0.0,      15.0,     18.0   }, // Santolan
        { 31.0,     30.0,    28.0,    27.0,    26.0,    24.0,    23.0,    21.0,    19.0,    17.0,      15.0,     0.0,      15.0   }, // Marikina-Pasig
        { 33.0,     32.0,    30.0,    29.0,    28.0,    26.0,    25.0,    23.0,    21.0,    20.0,      18.0,     15.0,     0.0    }  // Antipolo
    };
    static final String[] MrtStations = {
            "North Avenue Station",
            "Quezon Avenue Station",
            "GMA Kamuning Station",
            "Araneta Center-Cubao Station",
            "Santolan-Annapolis Station",
            "Ortigas Station",
            "Shaw Boulevard Station",
            "Boni Station",
            "Guadalupe Station",
            "Buendia Station",
            "Ayala Station",
            "Magallanes Station",
            "Taft Avenue Station"
        };
    static final double[][] MrtFareMatrix = {
        // North Ave  Quezon Ave  Kamuning   Cubao     Santolan   Ortigas   Shaw Blvd  Boni      Guadalupe  Buendia   Ayala     Magallanes  Taft Ave
        { 0.0,        13.0,       16.0,      20.0,     24.0,      28.0,     30.0,      33.0,     36.0,      40.0,     44.0,     48.0,       53.0  }, // North Avenue
        { 13.0,       0.0,        13.0,      16.0,     20.0,      24.0,     28.0,      30.0,     33.0,      37.0,     41.0,     45.0,       50.0  }, // Quezon Avenue
        { 16.0,       13.0,       0.0,       13.0,     16.0,      20.0,     24.0,      28.0,     30.0,      34.0,     38.0,     42.0,       47.0  }, // GMA Kamuning
        { 20.0,       16.0,       13.0,      0.0,      13.0,      16.0,     20.0,      24.0,     28.0,      32.0,     36.0,     40.0,       45.0  }, // Cubao
        { 24.0,       20.0,       16.0,      13.0,     0.0,       13.0,     16.0,      20.0,     24.0,      28.0,     32.0,     36.0,       41.0  }, // Santolan
        { 28.0,       24.0,       20.0,      16.0,     13.0,      0.0,      13.0,      16.0,     20.0,      24.0,     28.0,     32.0,       37.0  }, // Ortigas
        { 30.0,       28.0,       24.0,      20.0,     16.0,      13.0,     0.0,       13.0,     16.0,      20.0,     24.0,     28.0,       33.0  }, // Shaw Blvd
        { 33.0,       30.0,       28.0,      24.0,     20.0,      16.0,     13.0,      0.0,      13.0,      16.0,     20.0,     24.0,       29.0  }, // Boni
        { 36.0,       33.0,       30.0,      28.0,     24.0,      20.0,     16.0,      13.0,     0.0,       13.0,     16.0,     20.0,       25.0  }, // Guadalupe
        { 40.0,       37.0,       34.0,      32.0,     28.0,      24.0,     20.0,      16.0,     13.0,      0.0,      13.0,     16.0,       21.0  }, // Buendia
        { 44.0,       41.0,       38.0,      36.0,     32.0,      28.0,     24.0,      20.0,     16.0,      13.0,     0.0,      13.0,       16.0  }, // Ayala
        { 48.0,       45.0,       42.0,      40.0,     36.0,      32.0,     28.0,      24.0,     20.0,      16.0,     13.0,     0.0,        13.0  }, // Magallanes
        { 53.0,       50.0,       47.0,      45.0,     41.0,      37.0,     33.0,      29.0,     25.0,      21.0,     16.0,     13.0,       0.0   }  // Taft Avenue
    };
    
    static int findStationIndex(String station, String[] STATIONS) {
        for (int i = 0; i < STATIONS.length; i++) {
            if (STATIONS[i].equalsIgnoreCase(station)) {
                return i;
            }
        }
        return -1; // Station not found
    }
    static double calculateFare(String startStation, String endStation, String[] STATIONS, String discountType, String cardType) {
        // Find the index of the start and end stations
        int startIndex = findStationIndex(startStation, STATIONS);
        int endIndex = findStationIndex(endStation, STATIONS);
        
        // Return the fare from the FARE_MATRIX
        double fare=0;
        if(STATIONS==MrtStations){
            fare =  MrtFareMatrix[startIndex][endIndex];
        }
        else if(STATIONS == Lrt1Stations){
            if(cardType.equals("Single Journey")){
                fare = Lrt1FareMatrix_SingleJourney[startIndex][endIndex];
            }
            else if(cardType.equals("Beep")){
                fare = Lrt1FareMatrix_Beep[startIndex][endIndex];
            }
        }
        else if(STATIONS == Lrt2Stations){
            if(cardType.equals("Single Journey")){
                fare = Lrt2FareMatrix_SingleJourney[startIndex][endIndex];
            }
            if(cardType.equals("Beep")){
                fare = Lrt2FareMatrix_Beep[startIndex][endIndex];
            }
        }
        else{
            // Invalid station parameter
            fare = -1;
        }
        if(!discountType.equals("Regular")){
            fare*=0.8;
        }
        return fare;
    }
    
    
    static MainMenu frmMainMenu = new MainMenu();
    static LRT1 frmLrt1 = new LRT1();
    static LRT2 frmLrt2 = new LRT2();
    static MRT frmMrt = new MRT();
    static Receiptpanel frmReceipt = new Receiptpanel();
    
    public static void refreshVariables(){        
        startStation = new String();
        endStation = new String();
        discountType = new String();
        cardType = new String();
        totalfare = 0;
    }
    
    public static void updateFare(){
        switch(currentFrame){
            case "lrt1":
                startStation = frmLrt1.getCurrentStation();
                endStation = frmLrt1.getDestination();
                discountType = frmLrt1.getDiscountType();
                cardType = frmLrt1.getCardType();
                totalfare = calculateFare(startStation, endStation, Lrt1Stations, discountType, cardType);
                frmLrt1.textField.setText(String.format("%.2f", totalfare));                
                break;
            case "lrt2":
                startStation = frmLrt2.getCurrentStation();
                endStation = frmLrt2.getDestination();
                discountType = frmLrt2.getDiscountType();
                cardType = frmLrt2.getCardType();
                totalfare = calculateFare(startStation, endStation, Lrt2Stations, discountType, cardType);
                frmLrt2.textField.setText(String.format("%.2f", totalfare));
                break;
            case "mrt":
                startStation = frmMrt.getCurrentStation();
                endStation = frmMrt.getDestination();
                discountType = frmMrt.getDiscountType();
                cardType = frmMrt.getCardType();
                totalfare = calculateFare(startStation, endStation, MrtStations, discountType, cardType);
                frmMrt.textField.setText(String.format("%.2f", totalfare));
                break;
        }
    }
    
    public static void comboBoxIndexChanged(){
        refreshVariables();
        updateFare();
        tranferBtnStatus();
    }
    
    public static void addToReceipt(){
        String text =
                "From:\t"+startStation+"\nTo:\t"+endStation+"\n\n"
                +discountType+" Passenger\n"
                +"Card Type: "+cardType
                +"\n\nFare Price: P"+totalfare
                +"\n---------------------------\n"
                ;
        double value = totalfare;
        receiptList.add(new ReceiptObject(text, value));
    }
    public static String finalReceipt(){
        String s = new String();
        double price = 0;
        StringBuilder sb = new StringBuilder();
        
        for(ReceiptObject o : receiptList){
            sb.append(o.text);
            price += o.value;
        }
        
        sb.append("\nTotal: P" + String.format("%.2f", price));
        
        s = String.valueOf(sb);
        
        return s;        
    }
    
    public static void tranferBtnStatus(){
        switch(currentFrame){
/*
LRT1 Doroteo - Recto(LRT2)
    EDSA - Taft(MRT)
LRT2 Recto - Doroteo(LRT1)
    Cubao - Cubao(MRT)
MRT Taft - EDSA(LRT1)
    Cubao - Cubao(LRT2)
*/
            case "lrt1":                
                if(endStation.equals("Doroteo Jose Station")||endStation.equals("EDSA Station")){
                    frmLrt1.btnNewButton.setEnabled(true);
                }else{                    
                    frmLrt1.btnNewButton.setEnabled(false);
                }
                break;
            case "lrt2":
                if(endStation.equals("Recto Station")||endStation.equals("Araneta Center-Cubao Station")){
                    frmLrt2.btnNewButton.setEnabled(true);
                }else{
                    frmLrt2.btnNewButton.setEnabled(false);
                }
                break;
            case "mrt":
                if(endStation.equals("Taft Avenue Station")||endStation.equals("Araneta Center-Cubao Station")){
                    frmMrt.btnTransfer.setEnabled(true);
                }else{
                    frmMrt.btnTransfer.setEnabled(false);
                }
                break;
        }
    }    

    public static void btnTransferPressed(){
/*
LRT1 Doroteo - Recto(LRT2)
    EDSA - Taft(MRT)
LRT2 Recto - Doroteo(LRT1)
    Cubao - Cubao(MRT)
MRT Taft - EDSA(LRT1)
    Cubao - Cubao(LRT2)
*/
        switch(currentFrame){
            case"lrt1":
                if(endStation.equals("Doroteo Jose Station")){
                    addToReceipt();
                    frmLrt1.dispose();
                    btnLrt2Pressed();
                    frmLrt2.cbCurrentStation.setSelectedItem("Recto Station");
                    comboBoxIndexChanged();
                }
                if(endStation.equals("EDSA Station")){
                    addToReceipt();
                    frmLrt1.dispose();
                    btnMrtPressed();
                    frmMrt.cbCurrentStation.setSelectedItem("Taft Avenue Station");
                    comboBoxIndexChanged();
                }
                break;
            case"lrt2":
                if(endStation.equals("Recto Station")){
                    addToReceipt();
                    frmLrt2.dispose();
                    btnLrt1Pressed();                    
                    frmLrt2.cbCurrentStation.setSelectedItem("Doroteo Jose Station");
                    comboBoxIndexChanged();
                }
                if(endStation.equals("Araneta Center-Cubao Station")){
                    addToReceipt();
                    frmLrt2.dispose();
                    btnMrtPressed();
                    frmMrt.cbCurrentStation.setSelectedItem("Araneta Center-Cubao Station");
                    comboBoxIndexChanged();
                }
                break;
            case"mrt":
                if(endStation.equals("Taft Avenue Station")){
                    addToReceipt();
                    frmMrt.dispose();
                    btnLrt1Pressed();
                    frmLrt1.cbCurrentStation.setSelectedItem("EDSA Station");
                    comboBoxIndexChanged();
                }
                if(endStation.equals("Araneta Center-Cubao Station")){
                    addToReceipt();
                    frmMrt.dispose();
                    btnLrt2Pressed();
                    frmLrt2.cbCurrentStation.setSelectedItem("Araneta Center-Cubao Station");
                    comboBoxIndexChanged();
                }
                break;
        }
    }
    
    public static void btnRidePressed(){
        addToReceipt();        
        frmReceipt.textArea.setText(finalReceipt());
        frmReceipt.setVisible(true);        
        refreshVariables();
        receiptList = new ArrayList();
    }
    public static void btnNewTransactionPressed(){
        frmReceipt.dispose();
        frmLrt1.dispose();
        frmLrt2.dispose();
        frmMrt.dispose();
        showMainMenu();
    }
        
    public static void btnLrt1Pressed(){
        refreshVariables();
        frmMainMenu.dispose();
        frmLrt1.setVisible(true);
        currentFrame = "lrt1";
        comboBoxIndexChanged();
    }
    public static void btnLrt2Pressed(){
        refreshVariables();
        frmMainMenu.dispose();
        frmLrt2.setVisible(true);
        currentFrame = "lrt2";
        comboBoxIndexChanged();
    }
    public static void btnMrtPressed(){
        refreshVariables();
        frmMainMenu.dispose();
        frmMrt.setVisible(true);
        currentFrame = "mrt";
        comboBoxIndexChanged();
    }
    
        // Method to show the MainMenu frame
    public static void showMainMenu() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Check if the main menu instance already exists
                if (frmMainMenu == null || !frmMainMenu.isDisplayable()) {
                    frmMainMenu = new MainMenu(); // Create a new instance if it doesn't exist
                }
                frmMainMenu.setVisible(true); // Show the main menu
            }
        });
    }
    
    public static void main(String[] args) {
        showMainMenu();
        currentFrame = new String();
    }
}
