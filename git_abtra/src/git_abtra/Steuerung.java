package git_abtra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

// import com.sun.glass.events.WindowEvent;

public class Steuerung {

	// Swing-Elemente

	public static JDialog dialogNewApplicant = new JDialog(Oberflaeche.frame);
	public static JDialog dialogNewVacancy = new JDialog(Oberflaeche.frame);

	private Font fontHeadline = new Font("Arial", Font.BOLD, 18);
	private Font fontTextField = new Font("Arial", Font.BOLD, 14);

	private JPanel panelDialog = new JPanel();
	private JPanel panelDialog2 = new JPanel();
	private JPanel panelDialog3 = new JPanel();
	private JPanel panelDialog4 = new JPanel();
	private JPanel panelDialog5 = new JPanel();

	// Neuer Bewerber
	private JLabel labelName = new JLabel("Name:");
	private JLabel labelFirstName = new JLabel("Vorname:");
	private JLabel labelStreet = new JLabel("Straße:");
	private JLabel labelHouseNr = new JLabel("Hausnummer:");
	private JLabel labelPostalCode = new JLabel("PLZ:");
	private JLabel labelInstruction = new JLabel("Bitte tragen Sie alle erforderlichen Daten ein!");
	private JLabel labelVacancy = new JLabel("Bewerbung für die Stelle:");
	private JLabel labelDate = new JLabel("Geburtsdatum:");
	private JLabel labelEducationalAchievement = new JLabel("Höchster Bildungsabschluss:");
	private JLabel labelCity = new JLabel("Wohnort:");
	private JLabel labelTelefonHome = new JLabel("Telefon privat:");
	private JLabel labelTelefonMobil = new JLabel("Telefon mobil");
	private JLabel labelEmail = new JLabel("E-Mail:");
	

	private JTextField fieldVacancy = new JTextField();
	private JTextField fieldDate = new JTextField();
	private JTextField fieldName = new JTextField();
	private JTextField fieldFirstName = new JTextField();
	private JTextField fieldStreet = new JTextField();
	private JTextField fieldHouseNr = new JTextField();
	private JTextField fieldPostalCode = new JTextField();
	private JTextField fieldCity = new JTextField();
	private JTextField fieldTelefonHome = new JTextField();
	private JTextField fieldTelefonMobil = new JTextField();
	private JTextField fieldEmail = new JTextField();

	private String[] boxListEducationalAchievement = { "Haupptschulabschluss", "Mittlere Reife", "Abitur", "Studium" };
	private JComboBox boxEducationalAchievement = new JComboBox(
			boxListEducationalAchievement);
	private Integer[] boxListDay = { 1, 2, 3, 4,
			5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
			16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
			27, 28, 29, 30, 31 };
	private JComboBox boxDay = new JComboBox(boxListDay);
	private Integer[] boxListMonth = { 1, 2,
			3, 4, 5, 6, 7, 8, 9, 
			10, 11, 12 };
	private JComboBox boxMonth = new JComboBox(boxListMonth);
	private Integer[] boxListYear = {  2000, 1999, 1998,
			1997, 1996, 1995, 1994, 1993, 1992, 1991, 1990,
			1989, 1988, 1987, 1986, 1985, 1984, 1983, 1982,
			1981, 1980, 1979, 1978, 1977, 1976, 1975, 1974,
			1973, 1972, 1971, 1970 };
	private JComboBox boxYear = new JComboBox(boxListYear);
	public static Calendar cal = Calendar.getInstance();
	private JTabbedPane tabAdd = new JTabbedPane(JTabbedPane.TOP,
			JTabbedPane.SCROLL_TAB_LAYOUT);
	
	// Neue Stelle
	private JLabel labelArea = new JLabel();
	private JLabel labelPosition = new JLabel();
	private JLabel labelLevel = new JLabel();
	private JLabel labelInstruction2 = new JLabel();

	private JTextField fieldArea = new JTextField();
	private JTextField fieldPosition = new JTextField();
	private JTextField fieldLevel = new JTextField();

	private JTabbedPane tabVacancy = new JTabbedPane(JTabbedPane.TOP,
			JTabbedPane.SCROLL_TAB_LAYOUT);

	// Datentypen

	public static String name;
	public static String firstName;
	public static String street;
	public static int houseNr;
	public static int postalCode;
	public static String city;
	public static String vacancy;
	public static String telefonHome;
	public static String telefonMobil;
	public static String email;
	public static java.sql.Date dateOfApplication;
	public static String educationalAchievement;
	public static int day;
	public static int month;
	public static int year;

	public static String area;
	public static String position;
	public static String level;
	public static String dateVacancy;


	public static void main(String[] args) {
		// Design des Programms
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {

		}

		new Oberflaeche("Bewerberverwaltung");

	}

	// METHODE: Standardkonstruktor
	public Steuerung() {

	}

	// METHODE: Bewerbereingabe überprüfen
	public boolean controlInputApplicant() {

		name = fieldName.getText();
		firstName = fieldFirstName.getText();
		street = fieldStreet.getText();
		houseNr = Integer.parseInt(fieldHouseNr.getText());
		postalCode = Integer.parseInt(fieldPostalCode.getText());
		city = fieldCity.getText();
		vacancy = fieldVacancy.getText();
		telefonHome = fieldTelefonHome.getText();
		telefonMobil = fieldTelefonMobil.getText();
		email = fieldEmail.getText();
	    day = (int) boxDay.getSelectedItem();
		month = (int) boxMonth.getSelectedItem();
		year = (int) boxYear.getSelectedItem();		
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, (month-1));
		cal.set(Calendar.DAY_OF_MONTH, day);
		
		
		educationalAchievement = String.valueOf(boxEducationalAchievement
				.getSelectedItem());

		if (name.equals("")) {
			return false;
		}
		if (firstName.equals("")) {
			return false;
		}
		if (street.equals("")) {
			return false;
		}
		if ((houseNr == 0)) {
			return false;
		}
		if ((postalCode == 0)) {
			return false;
		}
		if (city.equals("")) {
			return false;
		}
		if (vacancy.equals("")) {
			return false;
		}
		if (educationalAchievement.equals("")) {
			return false;
		}
		if (telefonHome.equals("")) {
			return false;
		}
		if (telefonMobil.equals("")) {
			return false;
		}
		if (email.equals("")) {
			return false;
		} else {
			return true;
		}

	}

	// METHODE: Arbeitsstelleneingabe überprüfen
	public boolean controlInputVacancy() {
		area = fieldArea.getText();
		position = fieldPosition.getText();
		level = fieldLevel.getText();
		String day = String.valueOf(boxDay.getSelectedItem());
		String month = String.valueOf(boxMonth.getSelectedItem());
		String year = String.valueOf(boxYear.getSelectedItem());
		dateVacancy = day + "." + month + "." + year;

		if (area.equals("")) {
			return false;
		}
		if (position.equals("")) {
			return false;
		}
		if (level.equals("")) {
			return false;
		}
		if (dateVacancy.equals("")) {
			return false;
		} else {
			return true;
		}

	}

	// METHODE: Neuer Bewerber anlegen
	public void dialogAddApplicant() {

		// PanelDialog neuer Bewerber_Allgemein
		dialogNewApplicant
				.setDefaultCloseOperation(dialogNewApplicant.DO_NOTHING_ON_CLOSE);
		dialogNewApplicant.addWindowListener(new WindowListener() {
			public void windowClosing(WindowEvent arg0) {
				Oberflaeche.steuerung.closeDialogAddApplicant();
			}

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		dialogNewApplicant.setVisible(true);
		dialogNewApplicant.setSize(450, 400);
		dialogNewApplicant.setLocationRelativeTo(null);
		dialogNewApplicant.setResizable(false);
		dialogNewApplicant.setTitle("Neuer Bewerber");
		dialogNewApplicant.add(panelDialog);
		panelDialog.setBackground(Color.LIGHT_GRAY);
		panelDialog.setLayout(new BoxLayout(panelDialog, BoxLayout.Y_AXIS));
		panelDialog.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialog.add(labelInstruction);
		labelInstruction.setFont(fontHeadline);
		panelDialog.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialog.add(labelName);
		panelDialog.add(fieldName);
		panelDialog.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldName.setFont(fontTextField);
		panelDialog.add(labelFirstName);
		panelDialog.add(fieldFirstName);
		panelDialog.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldFirstName.setFont(fontTextField);
		panelDialog.add(labelStreet);
		panelDialog.add(fieldStreet);
		panelDialog.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldStreet.setFont(fontTextField);
		panelDialog.add(labelHouseNr);
		panelDialog.add(fieldHouseNr);
		panelDialog.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldHouseNr.setFont(fontTextField);
		panelDialog.add(labelPostalCode);
		panelDialog.add(fieldPostalCode);
		panelDialog.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldPostalCode.setFont(fontTextField);
		panelDialog.add(labelCity);
		panelDialog.add(fieldCity);
		panelDialog.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldCity.setFont(fontTextField);
		// PanelDialog2 neuer Bewerber_Bewerbung
		panelDialog2.setBackground(Color.LIGHT_GRAY);
		panelDialog2.setLayout(new BoxLayout(panelDialog2, BoxLayout.Y_AXIS));
		panelDialog2.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialog2.add(labelVacancy);
		labelVacancy.setFont(fontTextField);
		panelDialog2.add(fieldVacancy);
		panelDialog2.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldVacancy.setFont(fontTextField);
		panelDialog2.add(labelDate);	
		labelDate.setFont(fontTextField);
		boxDay.setToolTipText("Tag");
		panelDialog2.add(boxDay);
		panelDialog2.add(Box.createRigidArea(new Dimension(0, 10)));
		boxMonth.setToolTipText("Monat");
		panelDialog2.add(boxMonth);
		panelDialog2.add(Box.createRigidArea(new Dimension(0, 10)));
		boxYear.setToolTipText("Jahr");
		panelDialog2.add(boxYear);
		panelDialog2.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialog2.add(labelEducationalAchievement);
		labelEducationalAchievement.setFont(fontTextField);
		boxEducationalAchievement.setToolTipText("Höchster Bildungsabschluss:");
		panelDialog2.add(boxEducationalAchievement);
		panelDialog2.add(Box.createRigidArea(new Dimension(0, 10)));
		// PanelDialog2 neuer Bewerber_Kontaktdaten
		panelDialog5.setBackground(Color.LIGHT_GRAY);
		panelDialog5.setLayout(new BoxLayout(panelDialog5, BoxLayout.Y_AXIS));
		panelDialog5.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialog5.add(labelTelefonHome);
		panelDialog5.add(fieldTelefonHome);
		panelDialog5.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldTelefonHome.setFont(fontTextField);
		panelDialog5.add(labelTelefonMobil);
		panelDialog5.add(fieldTelefonMobil);
		panelDialog5.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldTelefonMobil.setFont(fontTextField);
		panelDialog5.add(labelEmail);
		panelDialog5.add(fieldEmail);
		panelDialog5.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldEmail.setFont(fontTextField);
		panelDialog5.add(Oberflaeche.save);

		// TabbedPane Dialog
		dialogNewApplicant.add(tabAdd);
		tabAdd.addTab("Allgemein", panelDialog);
		tabAdd.addTab("Bewerbung", panelDialog2);
		tabAdd.addTab("Kontaktdaten", panelDialog5);
		SwingUtilities.updateComponentTreeUI(dialogNewApplicant);

	}

	// METODE: Bewerber Dialog löschen
	public void closeDialogAddApplicant() {
		panelDialog.removeAll();
		panelDialog2.removeAll();
		panelDialog5.removeAll();
		fieldVacancy.setText("");
		fieldDate.setText("");
		fieldName.setText("");
		fieldFirstName.setText("");
		fieldStreet.setText("");
		fieldHouseNr.setText("");
		fieldPostalCode.setText("");
		fieldCity.setText("");
		fieldTelefonHome.setText("");
		fieldTelefonMobil.setText("");
		fieldEmail.setText("");
		name = "";
		firstName = "";
		street = "";
		houseNr = 0;
		postalCode = 0;
		city = "";
		boxDay.setSelectedIndex(0);
		boxMonth.setSelectedIndex(0);
		boxYear.setSelectedIndex(0);
		boxEducationalAchievement.setSelectedIndex(0);
		tabAdd.removeAll();
		dialogNewApplicant.dispose();
	}

	// METHODE: Neue Stelle anlegen
	public void dialogAddVacancy() {
		// PanelDialog3 neue freie Stelle
		dialogNewVacancy.setVisible(true);
		dialogNewVacancy.setSize(450, 400);
		dialogNewVacancy.setLocationRelativeTo(null);
		dialogNewVacancy.setResizable(false);
		dialogNewVacancy.setTitle("Neuer Stelle");
		panelDialog3.setBackground(Color.LIGHT_GRAY);
		panelDialog3.setLayout(new BoxLayout(panelDialog3, BoxLayout.Y_AXIS));
		panelDialog3.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialog3.add(labelInstruction2);
		labelInstruction2
				.setText("Bitte tragen Sie alle erfoderlichen Daten ein!");
		labelInstruction2.setFont(fontHeadline);
		panelDialog3.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialog3.add(labelPosition);
		labelPosition.setText("Position:");
		panelDialog3.add(fieldPosition);
		panelDialog3.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldPosition.setFont(fontTextField);
		panelDialog3.add(labelArea);
		labelArea.setText("Arbeitsbereich:");
		panelDialog3.add(fieldArea);
		panelDialog3.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldArea.setFont(fontTextField);

		// PanelDialog4 neue freie Stelle
		panelDialog4.setBackground(Color.LIGHT_GRAY);
		panelDialog4.setLayout(new BoxLayout(panelDialog4, BoxLayout.Y_AXIS));
		panelDialog4.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialog4.add(labelLevel);
		labelLevel.setText("Art des Bewerbers:");
		panelDialog4.add(fieldLevel);
		panelDialog4.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldLevel.setFont(fontTextField);
		String[] boxListDay = { "Bitte auswählen", "01", "02", "03", "04",
				"05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
				"15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
				"25", "26", "27", "28", "29", "30", "31" };
		JComboBox boxDay = new JComboBox(boxListDay);
		boxDay.setToolTipText("Tag");
		panelDialog4.add(boxDay);
		panelDialog4.add(Box.createRigidArea(new Dimension(0, 10)));
		JComboBox boxMonth = new JComboBox(boxListMonth);
		String[] boxListMonth = { "Bitte auswählen", "Januar", "Februar",
				"März", "April", "Mai", "Juni", "Juli", "August", "September",
				"Oktober", "November", "Dezember" };
		boxMonth.setToolTipText("Monat");
		panelDialog4.add(boxMonth);
		panelDialog4.add(Box.createRigidArea(new Dimension(0, 10)));
		String[] boxListYear = { "Bitte auswählen", "2000", "1999", "1998",
				"1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990",
				"1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982",
				"1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974",
				"1973", "1972", "1971", "1970" };
		JComboBox boxYear = new JComboBox(boxListYear);
		boxYear.setToolTipText("Jahr");
		panelDialog4.add(boxYear);
		panelDialog4.add(Box.createRigidArea(new Dimension(0, 10)));
		String[] boxListEducationalAchievement = { "Bitte auswählen",
				"Haupptschulabschluss", "Mittlere Reife", "Abitur", "Studium" };
		JComboBox boxEducationalAchievement = new JComboBox(
				boxListEducationalAchievement);
		panelDialog4.add(labelEducationalAchievement);
		boxEducationalAchievement.setToolTipText("Höchster Bildugsabschluss:");
		panelDialog4.add(boxEducationalAchievement);
		panelDialog4.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialog4.add(Oberflaeche.save);

		// TabbedPane Dialog
		dialogNewVacancy.add(tabVacancy);
		tabVacancy.addTab("Allgemein", panelDialog3);
		tabVacancy.addTab("Spezifikation", panelDialog4);
		SwingUtilities.updateComponentTreeUI(dialogNewVacancy);

	}

}
