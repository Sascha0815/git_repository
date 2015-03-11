package git_abtra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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

	private JPanel panelDialogApplicantMain = new JPanel();
	private JPanel panelDialogApplicantApplication = new JPanel();
	private JPanel panelDialogVacancyMain = new JPanel();
	private JPanel panelDialogVacancySpecification = new JPanel();
	private JPanel panelDialogApplicantContact = new JPanel();

	// Neuer Bewerber
	private JLabel labelName = new JLabel("Name:");
	private JLabel labelFirstName = new JLabel("Vorname:");
	private JLabel labelStreet = new JLabel("Straße:");
	private JLabel labelHouseNr = new JLabel("Hausnummer:");
	private JLabel labelPostalCode = new JLabel("PLZ:");
	private JLabel labelInstruction = new JLabel(
			"Bitte tragen Sie alle erforderlichen Daten ein!");
	private JLabel labelVacancy = new JLabel("Bewerbung für die Stelle:");
	private JLabel labelDate = new JLabel("Geburtsdatum:");
	private JLabel labelEducationalAchievement = new JLabel(
			"Höchster Bildungsabschluss:");
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

	private String[] boxListEducationalAchievement = { "Haupptschulabschluss",
			"Mittlere Reife", "Abitur", "Studium" };
	private JComboBox boxEducationalAchievement = new JComboBox(
			boxListEducationalAchievement);
	private Integer[] boxListDay = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
			14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
			31 };
	private JComboBox boxDay = new JComboBox(boxListDay);
	private Integer[] boxListMonth = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
	private JComboBox boxMonth = new JComboBox(boxListMonth);
	private Integer[] boxListYear = { 2000, 1999, 1998, 1997, 1996, 1995, 1994,
			1993, 1992, 1991, 1990, 1989, 1988, 1987, 1986, 1985, 1984, 1983,
			1982, 1981, 1980, 1979, 1978, 1977, 1976, 1975, 1974, 1973, 1972,
			1971, 1970 };
	private JComboBox boxYear = new JComboBox(boxListYear);
	private static Calendar cal = Calendar.getInstance();
	private JTabbedPane tabAdd = new JTabbedPane(JTabbedPane.TOP,
			JTabbedPane.SCROLL_TAB_LAYOUT);
	private JButton save = new JButton("Speichern");

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

	private String name;
	private String firstName;
	private String street;
	private int houseNr;
	private int postalCode;
	private String city;
	private String vacancy;
	private String telefonHome;
	private String telefonMobil;
	private String email;
	private java.sql.Date dateOfApplication;
	private String educationalAchievement;
	private int day;
	private int month;
	private int year;

	private String area;
	private String position;
	private String level;
	private String dateVacancy;

	// Sonstige

	private boolean LaF = true;
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		new Oberflaeche("Bewerberverwaltung");
	}

	public  String getName(){
		return name;
	}	
	public  String getFirstName(){
		return firstName;
	}
	public  String getStreet(){
		return street;
	}
	public  int getHouseNr(){
		return houseNr;
	}
	public  int getPostalCode(){
		return postalCode;
	}
	public  String getCity(){
		return city;
	}
	public  String getVacancy(){
		return vacancy;
	}
	public  String getTelefonHome(){
		return telefonHome;
	}
	public  String getTelefonMobil(){
		return telefonMobil;
	}
	public  String getEmail(){
		return email;
	}
	public  Calendar getCal(){
		return cal;
	}
	public  String getEducationalAchievement(){
		return educationalAchievement;
	}
	public  String getArea(){
		return area;
	}
	public  String getPosition(){
		return position;
	}
	public  String getLevel(){
		return level;
	}
	public  String getDateVacancy(){
		return dateVacancy;
	}
	
	
	// METHODE: Standardkonstruktor
	public Steuerung() {

	}
	
	// METHODE: Design ändern
		public void changeDesign() {
			if (LaF == true) {
				try {
					UIManager.setLookAndFeel(UIManager
							.getCrossPlatformLookAndFeelClassName());

				} catch (Exception e) {

				}
			} else {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());

				} catch (Exception e) {
				}
			}
			SwingUtilities.updateComponentTreeUI(Oberflaeche.frame);
			LaF = !LaF;
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
		cal.set(Calendar.MONTH, (month - 1));
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
				closeDialogAddApplicant();
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
		dialogNewApplicant.add(panelDialogApplicantMain);
		panelDialogApplicantMain.setBackground(Color.LIGHT_GRAY);
		panelDialogApplicantMain.setLayout(new BoxLayout(panelDialogApplicantMain, BoxLayout.Y_AXIS));
		panelDialogApplicantMain.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialogApplicantMain.add(labelInstruction);
		labelInstruction.setFont(fontHeadline);
		panelDialogApplicantMain.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialogApplicantMain.add(labelName);
		panelDialogApplicantMain.add(fieldName);
		panelDialogApplicantMain.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldName.setFont(fontTextField);
		panelDialogApplicantMain.add(labelFirstName);
		panelDialogApplicantMain.add(fieldFirstName);
		panelDialogApplicantMain.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldFirstName.setFont(fontTextField);
		panelDialogApplicantMain.add(labelStreet);
		panelDialogApplicantMain.add(fieldStreet);
		panelDialogApplicantMain.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldStreet.setFont(fontTextField);
		panelDialogApplicantMain.add(labelHouseNr);
		panelDialogApplicantMain.add(fieldHouseNr);
		panelDialogApplicantMain.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldHouseNr.setFont(fontTextField);
		panelDialogApplicantMain.add(labelPostalCode);
		panelDialogApplicantMain.add(fieldPostalCode);
		panelDialogApplicantMain.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldPostalCode.setFont(fontTextField);
		panelDialogApplicantMain.add(labelCity);
		panelDialogApplicantMain.add(fieldCity);
		panelDialogApplicantMain.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldCity.setFont(fontTextField);
		// panelDialogApplicantApplication neuer Bewerber_Bewerbung
		panelDialogApplicantApplication.setBackground(Color.LIGHT_GRAY);
		panelDialogApplicantApplication.setLayout(new BoxLayout(panelDialogApplicantApplication, BoxLayout.Y_AXIS));
		panelDialogApplicantApplication.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialogApplicantApplication.add(labelVacancy);
		labelVacancy.setFont(fontTextField);
		panelDialogApplicantApplication.add(fieldVacancy);
		panelDialogApplicantApplication.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldVacancy.setFont(fontTextField);
		panelDialogApplicantApplication.add(labelDate);
		labelDate.setFont(fontTextField);
		boxDay.setToolTipText("Tag");
		panelDialogApplicantApplication.add(boxDay);
		panelDialogApplicantApplication.add(Box.createRigidArea(new Dimension(0, 10)));
		boxMonth.setToolTipText("Monat");
		panelDialogApplicantApplication.add(boxMonth);
		panelDialogApplicantApplication.add(Box.createRigidArea(new Dimension(0, 10)));
		boxYear.setToolTipText("Jahr");
		panelDialogApplicantApplication.add(boxYear);
		panelDialogApplicantApplication.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialogApplicantApplication.add(labelEducationalAchievement);
		labelEducationalAchievement.setFont(fontTextField);
		boxEducationalAchievement.setToolTipText("Höchster Bildungsabschluss:");
		panelDialogApplicantApplication.add(boxEducationalAchievement);
		panelDialogApplicantApplication.add(Box.createRigidArea(new Dimension(0, 10)));
		// panelDialogApplicantApplication neuer Bewerber_Kontaktdaten
		panelDialogApplicantContact.setBackground(Color.LIGHT_GRAY);
		panelDialogApplicantContact.setLayout(new BoxLayout(panelDialogApplicantContact, BoxLayout.Y_AXIS));
		panelDialogApplicantContact.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialogApplicantContact.add(labelTelefonHome);
		panelDialogApplicantContact.add(fieldTelefonHome);
		panelDialogApplicantContact.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldTelefonHome.setFont(fontTextField);
		panelDialogApplicantContact.add(labelTelefonMobil);
		panelDialogApplicantContact.add(fieldTelefonMobil);
		panelDialogApplicantContact.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldTelefonMobil.setFont(fontTextField);
		panelDialogApplicantContact.add(labelEmail);
		panelDialogApplicantContact.add(fieldEmail);
		panelDialogApplicantContact.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldEmail.setFont(fontTextField);
		panelDialogApplicantContact.add(save);

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				controlInputApplicant();
				try {
					Oberflaeche.getDatenbank().insertApplicantData();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				closeDialogAddApplicant();
				Vector resultsApplicant = Oberflaeche.getDatenbank()
						.insertApplicantDataIntoTable();
				Oberflaeche.modelPool.setDataVector(resultsApplicant,
						Oberflaeche.COLUMN_IDENTIFIERS_APPLICANT);
				Oberflaeche.modelPool.fireTableDataChanged();
			}

		});
		// TabbedPane Dialog
		dialogNewApplicant.add(tabAdd);
		tabAdd.addTab("Allgemein", panelDialogApplicantMain);
		tabAdd.addTab("Bewerbung", panelDialogApplicantApplication);
		tabAdd.addTab("Kontaktdaten", panelDialogApplicantContact);
		SwingUtilities.updateComponentTreeUI(dialogNewApplicant);

	}

	// METODE: Bewerber Dialog löschen
	public void closeDialogAddApplicant() {
		panelDialogApplicantMain.removeAll();
		panelDialogApplicantApplication.removeAll();
		panelDialogApplicantContact.removeAll();
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
		// panelDialogVacancyMain neue freie Stelle
		dialogNewVacancy.setVisible(true);
		dialogNewVacancy.setSize(450, 400);
		dialogNewVacancy.setLocationRelativeTo(null);
		dialogNewVacancy.setResizable(false);
		dialogNewVacancy.setTitle("Neuer Stelle");
		panelDialogVacancyMain.setBackground(Color.LIGHT_GRAY);
		panelDialogVacancyMain.setLayout(new BoxLayout(panelDialogVacancyMain, BoxLayout.Y_AXIS));
		panelDialogVacancyMain.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialogVacancyMain.add(labelInstruction2);
		labelInstruction2
				.setText("Bitte tragen Sie alle erfoderlichen Daten ein!");
		labelInstruction2.setFont(fontHeadline);
		panelDialogVacancyMain.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialogVacancyMain.add(labelPosition);
		labelPosition.setText("Position:");
		panelDialogVacancyMain.add(fieldPosition);
		panelDialogVacancyMain.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldPosition.setFont(fontTextField);
		panelDialogVacancyMain.add(labelArea);
		labelArea.setText("Arbeitsbereich:");
		panelDialogVacancyMain.add(fieldArea);
		panelDialogVacancyMain.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldArea.setFont(fontTextField);

		// panelDialogVacancySpecification neue freie Stelle
		panelDialogVacancySpecification.setBackground(Color.LIGHT_GRAY);
		panelDialogVacancySpecification.setLayout(new BoxLayout(panelDialogVacancySpecification, BoxLayout.Y_AXIS));
		panelDialogVacancySpecification.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialogVacancySpecification.add(labelLevel);
		labelLevel.setText("Art des Bewerbers:");
		panelDialogVacancySpecification.add(fieldLevel);
		panelDialogVacancySpecification.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldLevel.setFont(fontTextField);
		String[] boxListDay = { "Bitte auswählen", "01", "02", "03", "04",
				"05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
				"15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
				"25", "26", "27", "28", "29", "30", "31" };
		JComboBox boxDay = new JComboBox(boxListDay);
		boxDay.setToolTipText("Tag");
		panelDialogVacancySpecification.add(boxDay);
		panelDialogVacancySpecification.add(Box.createRigidArea(new Dimension(0, 10)));
		JComboBox boxMonth = new JComboBox(boxListMonth);
		String[] boxListMonth = { "Bitte auswählen", "Januar", "Februar",
				"März", "April", "Mai", "Juni", "Juli", "August", "September",
				"Oktober", "November", "Dezember" };
		boxMonth.setToolTipText("Monat");
		panelDialogVacancySpecification.add(boxMonth);
		panelDialogVacancySpecification.add(Box.createRigidArea(new Dimension(0, 10)));
		String[] boxListYear = { "Bitte auswählen", "2000", "1999", "1998",
				"1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990",
				"1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982",
				"1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974",
				"1973", "1972", "1971", "1970" };
		JComboBox boxYear = new JComboBox(boxListYear);
		boxYear.setToolTipText("Jahr");
		panelDialogVacancySpecification.add(boxYear);
		panelDialogVacancySpecification.add(Box.createRigidArea(new Dimension(0, 10)));
		String[] boxListEducationalAchievement = { "Bitte auswählen",
				"Haupptschulabschluss", "Mittlere Reife", "Abitur", "Studium" };
		JComboBox boxEducationalAchievement = new JComboBox(
				boxListEducationalAchievement);
		panelDialogVacancySpecification.add(labelEducationalAchievement);
		boxEducationalAchievement.setToolTipText("Höchster Bildugsabschluss:");
		panelDialogVacancySpecification.add(boxEducationalAchievement);
		panelDialogVacancySpecification.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialogVacancySpecification.add(save);

		// TabbedPane Dialog
		dialogNewVacancy.add(tabVacancy);
		tabVacancy.addTab("Allgemein", panelDialogVacancyMain);
		tabVacancy.addTab("Spezifikation", panelDialogVacancySpecification);
		SwingUtilities.updateComponentTreeUI(dialogNewVacancy);

	}

}
