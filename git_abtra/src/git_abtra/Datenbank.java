package git_abtra;

import java.sql.*;
import java.util.Vector;

public class Datenbank {

	// METHODE: Bewerberdaten in Datenbank eintragen
	public void insertApplicantData() throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO applicant"
				+ "(name, firstName, street, houseNr, postalCode, city, telefonHome, telefonMobil, email, vacancy, date, educationalAchievement) VALUES"
				+ "(?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, Oberflaeche.getSteuerung().name);
			preparedStatement.setString(2, Oberflaeche.getSteuerung().firstName);
			preparedStatement.setString(3, Oberflaeche.getSteuerung().street);
			preparedStatement.setInt(4, Oberflaeche.getSteuerung().houseNr);
			preparedStatement.setInt(5, Oberflaeche.getSteuerung().postalCode);
			preparedStatement.setString(6, Oberflaeche.getSteuerung().city);
			preparedStatement.setString(7, Oberflaeche.getSteuerung().telefonHome);
			preparedStatement.setString(8, Oberflaeche.getSteuerung().telefonMobil);
			preparedStatement.setString(9, Oberflaeche.getSteuerung().email);
			preparedStatement.setString(10, Oberflaeche.getSteuerung().vacancy);
			preparedStatement.setDate(11, new java.sql.Date(Oberflaeche.getSteuerung().cal.getTimeInMillis()));
			preparedStatement.setString(12,
					Oberflaeche.getSteuerung().educationalAchievement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert problems - Datenbank - insert Applicant data" + e.getMessage());
		}
	}

	// METHODE: Arbeitsstellendaten in Datenbank eintragen
	public void insertVacancyData() throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO vacancy"
				+ "(area, position, level, date) VALUES" + "(?,?,?,?)";

		try {
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, Oberflaeche.getSteuerung().area);
			preparedStatement.setString(2, Oberflaeche.getSteuerung().position);
			preparedStatement.setString(3, Oberflaeche.getSteuerung().level);
			preparedStatement.setString(4, Oberflaeche.getSteuerung().dateVacancy);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Datenbank - insert VacancyData" + e.getMessage());
		}
	}

	// METHODE: Bewerberdaten in Tabelle anzeigen
	protected Vector insertApplicantDataIntoTable() {

		Vector resultsApplicant = new Vector();
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from applicant");

			while (rs.next()) {
				Vector applicant = new Vector();
				applicant.add(rs.getString(1));
				applicant.add(rs.getString(2));
				applicant.add(rs.getString(3));
				applicant.add(rs.getString(4));
				applicant.add(rs.getString(5));
				applicant.add(rs.getString(6));
				applicant.add(rs.getString(7));
				applicant.add(rs.getString(8));
				applicant.add(rs.getString(9));
				applicant.add(rs.getString(10));
				applicant.add(rs.getString(11));
				applicant.add(rs.getString(12));
				applicant.add(rs.getString(13));
				resultsApplicant.add(applicant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Oberflaeche.tableApplicant.setAutoCreateRowSorter(true);
		return resultsApplicant;
	}

	// METHODE: Arbeitsstellendaten in Tabelle anzeigen
	protected Vector insertVacancyDataIntoTable() {

		Vector resultsVacancy = new Vector();
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from vacancy");

			while (rs.next()) {
				Vector applicant = new Vector();
				applicant.add(rs.getString(1));
				applicant.add(rs.getString(2));
				applicant.add(rs.getString(3));
				applicant.add(rs.getString(4));
				resultsVacancy.add(applicant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Oberflaeche.tableApplicant.setAutoCreateRowSorter(true);
		return resultsVacancy;
	}

	//METHODE: Bewerber löschen
	public void deleteApplicant(){	
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
		}
			catch (SQLException e) {
				System.out.println("Datenbank - deleteApplicant" + e.getMessage());
			}
		
	int [] rows = Oberflaeche.tableApplicant.getSelectedRows(); 	
	for (int i = 0; i <= (rows.length); i++) {
		try {	
			int id = (rows[i])+1;
			String query = "delete from applicant where id = "+id;
			PreparedStatement preparedStmt = dbConnection.prepareStatement(query);
		    preparedStmt.execute();
		     
		} catch (Exception e) {
			
		}
	}
		
	try {
		String query = "ALTER TABLE `applicant` DROP `id`";
		PreparedStatement preparedStmt = dbConnection.prepareStatement(query);
	    preparedStmt.execute();
	    query = "ALTER TABLE `applicant` ADD `id` INT( 11 ) NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST";
		preparedStmt = dbConnection.prepareStatement(query);
		preparedStmt.execute();
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	}
		
	
	
	
	// METHODE: Standardkonstruktor
	public Datenbank() {

	}
}
