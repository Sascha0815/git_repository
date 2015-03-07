package git_abtra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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

	// Neuer Bewerber
	private JLabel labelName = new JLabel();
	private JLabel labelFirstName = new JLabel();
	private JLabel labelStreet = new JLabel();
	private JLabel labelHouseNr = new JLabel();
	private JLabel labelPostalCode = new JLabel();
	private JLabel labelInstruction = new JLabel();
	private JLabel labelVacancy = new JLabel();
	private JLabel labelDate = new JLabel();
	private JLabel labelEducationalAchievement = new JLabel();
	private JLabel labelCity = new JLabel();

	private JTextField fieldVacancy = new JTextField();
	private JTextField fieldDate = new JTextField();
	private JTextField fieldName = new JTextField();
	private JTextField fieldFirstName = new JTextField();
	private JTextField fieldStreet = new JTextField();
	private JTextField fieldHouseNr = new JTextField();
	private JTextField fieldPostalCode = new JTextField();
	private JTextField fieldCity = new JTextField();

	private String[] boxListEducationalAchievement = { "Bitte auswählen",
			"Haupptschulabschluss", "Mittlere Reife", "Abitur", "Studium" };
	private JComboBox boxEducationalAchievement = new JComboBox(
			boxListEducationalAchievement);

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
	public boolean controlInput() {

		name = fieldName.getText();
		firstName = fieldFirstName.getText();
		street = fieldStreet.getText();
		houseNr = Integer.parseInt(fieldHouseNr.getText());
		postalCode = Integer.parseInt(fieldPostalCode.getText());
		city = fieldCity.getText();

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
		if (!(city.equals(""))) {
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
		labelInstruction
				.setText("Bitte tragen Sie alle erfoderlichen Daten ein!");
		labelInstruction.setFont(fontHeadline);
		panelDialog.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialog.add(labelName);
		labelName.setText("Name:");
		panelDialog.add(fieldName);
		panelDialog.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldName.setFont(fontTextField);
		panelDialog.add(labelFirstName);
		labelFirstName.setText("Vorname:");
		panelDialog.add(fieldFirstName);
		panelDialog.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldFirstName.setFont(fontTextField);
		panelDialog.add(labelStreet);
		labelStreet.setText("Straße:");
		panelDialog.add(fieldStreet);
		panelDialog.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldStreet.setFont(fontTextField);
		panelDialog.add(labelHouseNr);
		labelHouseNr.setText("Hausnummer:");
		panelDialog.add(fieldHouseNr);
		panelDialog.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldHouseNr.setFont(fontTextField);
		panelDialog.add(labelPostalCode);
		labelPostalCode.setText("PLZ:");
		panelDialog.add(fieldPostalCode);
		panelDialog.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldPostalCode.setFont(fontTextField);
		panelDialog.add(labelCity);
		labelCity.setText("Wohnort:");
		panelDialog.add(fieldCity);
		panelDialog.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldCity.setFont(fontTextField);
		// PanelDialog2 neuer Bewerber_Bewerbung
		panelDialog2.setBackground(Color.LIGHT_GRAY);
		panelDialog2.setLayout(new BoxLayout(panelDialog2, BoxLayout.Y_AXIS));
		panelDialog2.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialog2.add(labelVacancy);
		labelVacancy.setText("Bewerbung für die Stelle:");
		panelDialog2.add(fieldVacancy);
		panelDialog2.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldVacancy.setFont(fontTextField);
		panelDialog2.add(labelDate);
		labelDate.setText("Datum der Bewerbung:");
		panelDialog2.add(fieldDate);
		panelDialog2.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldDate.setFont(fontTextField);
		panelDialog2.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialog2.add(labelEducationalAchievement);
		boxEducationalAchievement.setToolTipText("Höchster Bildugsabschluss:");
		panelDialog2.add(boxEducationalAchievement);
		panelDialog2.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialog2.add(Oberflaeche.save);

		// TabbedPane Dialog
		dialogNewApplicant.add(tabAdd);
		tabAdd.addTab("Allgemein", panelDialog);
		tabAdd.addTab("Bewerbung", panelDialog2);

	}

	// METODE: Bewerber Dialog löschen
	public void closeDialogAddApplicant() {
		panelDialog.remove(labelName);
		panelDialog.remove(labelFirstName);
		panelDialog.remove(labelStreet);
		panelDialog.remove(labelHouseNr);
		panelDialog.remove(labelPostalCode);
		panelDialog.remove(labelInstruction);
		panelDialog.remove(labelCity);
		panelDialog.remove(fieldArea);
		panelDialog.remove(fieldName);
		panelDialog.remove(fieldFirstName);
		panelDialog.remove(fieldStreet);
		panelDialog.remove(fieldHouseNr);
		panelDialog.remove(fieldPostalCode);
		panelDialog.remove(fieldCity);
		fieldVacancy.setText("");
		fieldDate.setText("");
		fieldName.setText("");
		fieldFirstName.setText("");
		fieldStreet.setText("");
		fieldHouseNr.setText("");
		fieldPostalCode.setText("");
		fieldCity.setText("");
		name = "";
		firstName = "";
		street = "";
		houseNr = 0;
		postalCode = 0;
		city = "";

		panelDialog2.remove(fieldVacancy);
		panelDialog2.remove(fieldDate);
		panelDialog2.remove(labelEducationalAchievement);
		panelDialog2.remove(labelVacancy);
		panelDialog2.remove(labelDate);
		panelDialog2.remove(Oberflaeche.save);
		panelDialog2.remove(boxEducationalAchievement);
		dialogNewApplicant.remove(tabAdd);
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
		panelDialog4.add(labelDate);
		labelDate.setText("Datum der Bewerbung:");
		panelDialog4.add(fieldDate);
		panelDialog4.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldDate.setFont(fontTextField);
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

	}

}
