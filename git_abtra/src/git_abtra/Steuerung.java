package git_abtra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class Steuerung {
		
	//Swing-Elemente
	
	public static JDialog		dialogNewApplicant = new JDialog(Oberflaeche.frame);
	  
	private JPanel	panelDialog = new JPanel();
	private JPanel	panelDialog2 = new JPanel();
	private JLabel	labelName = new JLabel();
	private JLabel	labelFirstName = new JLabel();
	private JLabel	labelStreet = new JLabel();
	private JLabel	labelHouseNr = new JLabel();
	private JLabel	labelPostalCode = new JLabel();
	private JLabel	labelInstruction = new JLabel();
	private JLabel	labelVacancy = new JLabel();
	private JLabel	labelDate = new JLabel();
	private JLabel	labelEducationalAchievement = new JLabel();	  
	private JLabel	labelCity = new JLabel();
	  
	private Font 	fontHeadline = new Font("Arial", Font.BOLD, 18);
	private Font	fontTextField = new Font("Arial", Font.BOLD, 14);	  
	  
	private JTextField	fieldVacancy = new JTextField();
	private JTextField	fieldDate = new JTextField();
	private JTextField	fieldName = new JTextField();
	private JTextField	fieldFirstName = new JTextField();
	private JTextField	fieldStreet = new JTextField();
	private JTextField	fieldHouseNr = new JTextField();
	private JTextField	fieldPostalCode = new JTextField();
	private JTextField	fieldCity = new JTextField();
	  
	private JTabbedPane 	tabAdd = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
	
	//Datentypen
	
	public static String 	name;
	public static String 	firstName;
	public static String 	street;
	public static int 	houseNr;
	public static int 	postalCode;
	public static String 	city;
	  
	public static void main(String[]args){
		//Design des Programms
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {	
		}
	    
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (InstantiationException e) {
	        e.printStackTrace();
	    } catch (IllegalAccessException e) {
	        e.printStackTrace();
	    } catch (UnsupportedLookAndFeelException e) {
	        e.printStackTrace();
	    }
		
		new Oberflaeche("Bewerberverwaltung"); 

	}
	
	//METHODE: Standardkonstruktor
	public Steuerung(){
		
	}
	
	//METHODE: Bewerbereingabe �berpr�fen
	public boolean controlInput (){
		
		name = fieldName.getText();
		firstName = fieldFirstName.getText();
		street = fieldStreet.getText();
		houseNr = Integer.parseInt(fieldHouseNr.getText());
		postalCode = Integer.parseInt(fieldPostalCode.getText());
		city = fieldCity.getText();
	
		if(name.equals("")){
			return false;
		}
		if(firstName.equals("")){
			return false;
		}
		if(street.equals("")){
			return false;
		}
		if(!(houseNr>0)){
			return false;
		}
		if(!(postalCode>0)){
			return false;
		}
		if(!(city.equals(""))){
			return false;
		}
		else{
			return true;		
		}
		
	}
	
	//METHODE: Neuer Bewerber anlegen
	public void dialogAddApplicant(){
		
		//PanelDialog neuer Bewerber_Allgemein
	    dialogNewApplicant.setVisible(true);
	  	dialogNewApplicant.setSize(450,400);
	  	dialogNewApplicant.setLocationRelativeTo(null);	
	  	dialogNewApplicant.setResizable(false);
	  	dialogNewApplicant.setTitle("Neuer Bewerber");
	  	panelDialog.setBackground(Color.LIGHT_GRAY);
	  	panelDialog.setLayout(new BoxLayout(panelDialog, BoxLayout.Y_AXIS));
	  	panelDialog.add(Box.createRigidArea(new Dimension(0,10)));
	    panelDialog.add(labelInstruction); 
	    labelInstruction.setText("Bitte tragen Sie alle erfoderlichen Daten ein!");
	    labelInstruction.setFont(fontHeadline);
	    panelDialog.add(Box.createRigidArea(new Dimension(0,10)));
	    panelDialog.add(labelName);
	    labelName.setText("Name:");
	    panelDialog.add(fieldName);
	    panelDialog.add(Box.createRigidArea(new Dimension(0,10)));
	    fieldName.setFont(fontTextField);
	    panelDialog.add(labelFirstName); 
	    labelFirstName.setText("Vorname:");
	    panelDialog.add(fieldFirstName);
	    panelDialog.add(Box.createRigidArea(new Dimension(0,10)));
	    fieldFirstName.setFont(fontTextField);
	    panelDialog.add(labelStreet);
	    labelStreet.setText("Stra�e:");
	    panelDialog.add(fieldStreet);
	    panelDialog.add(Box.createRigidArea(new Dimension(0,10)));
	    fieldStreet.setFont(fontTextField);
	    panelDialog.add(labelHouseNr);
	    labelHouseNr.setText("Hausnummer:");
	    panelDialog.add(fieldHouseNr);
	    panelDialog.add(Box.createRigidArea(new Dimension(0,10)));
	    fieldHouseNr.setFont(fontTextField);
	    panelDialog.add(labelPostalCode);
	    labelPostalCode.setText("PLZ:");  
	    panelDialog.add(fieldPostalCode);
	    panelDialog.add(Box.createRigidArea(new Dimension(0,10)));
	    fieldPostalCode.setFont(fontTextField);  
	    panelDialog.add(labelCity);
	    labelCity.setText("Wohnort:");  
	    panelDialog.add(fieldCity);
	    panelDialog.add(Box.createRigidArea(new Dimension(0,10)));
	    fieldCity.setFont(fontTextField);  

	    //PanelDialog2 neuer Bewerber_Bewerbung
	   	panelDialog2.setBackground(Color.LIGHT_GRAY);
	  	panelDialog2.setLayout(new BoxLayout(panelDialog2, BoxLayout.Y_AXIS));
	    panelDialog2.add(Box.createRigidArea(new Dimension(0,10)));
	    panelDialog2.add(labelVacancy);
	    labelVacancy.setText("Bewerbung f�r die Stelle:");
	    panelDialog2.add(fieldVacancy);
	    panelDialog2.add(Box.createRigidArea(new Dimension(0,10)));
	    fieldVacancy.setFont(fontTextField);
	    panelDialog2.add(labelDate); 
	    labelDate.setText("Datum der Bewerbung:");
	    panelDialog2.add(fieldDate);
	    panelDialog2.add(Box.createRigidArea(new Dimension(0,10)));
	    fieldDate.setFont(fontTextField);
	    panelDialog2.add(Box.createRigidArea(new Dimension(0,10)));
	    String[] boxListEducationalAchievement ={"Bitte ausw�hlen","Haupptschulabschluss","Mittlere Reife","Abitur","Studium"}; 
	    JComboBox	boxEducationalAchievement = new JComboBox(boxListEducationalAchievement);
	    panelDialog2.add(labelEducationalAchievement);
	    boxEducationalAchievement.setToolTipText("H�chster Bildugsabschluss:");
	    panelDialog2.add(boxEducationalAchievement);
	    panelDialog2.add(Box.createRigidArea(new Dimension(0,10)));
	    panelDialog2.add(Oberflaeche.save);

	    //TabbedPane Dialog
	    dialogNewApplicant.add(tabAdd);
	    tabAdd.addTab("Allgemein", panelDialog);
	    tabAdd.addTab("Bewerbung", panelDialog2);
	}

}

