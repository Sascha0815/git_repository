package git_abtra;
import java.sql.*; 
import java.util.Vector;

public class Datenbank {
	
	//METHODE: Bewerberdaten in Datenbank eintragen
	public void insertDataIntoDatabase() throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
 
		String insertTableSQL = "INSERT INTO bewerber"
				+ "(name, firstName, street, houseNr, postalCode, city) VALUES"
				+ "(?,?,?,?,?,?)";
 
		try {
			dbConnection = DriverManager.getConnection("jdbc:mysql://sql3.freemysqlhosting.net:3306/sql368354","sql368354","wM7%yR2!");
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, Oberflaeche.steuerung.name);
			preparedStatement.setString(2, Oberflaeche.steuerung.firstName);
			preparedStatement.setString(3, Oberflaeche.steuerung.street);
			preparedStatement.setInt(4, Oberflaeche.steuerung.houseNr);
			preparedStatement.setInt(5, Oberflaeche.steuerung.postalCode);
			preparedStatement.setString(6, Oberflaeche.steuerung.city); 
			preparedStatement.executeUpdate();
			System.out.println("Die Daten wurden erfoglreich an die Datenbank übermittelt!");
			Steuerung.dialogNewApplicant.dispose();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
 	}
	
	//METHODE: Bewerberdaten in Tabelle anzeigen
	protected Vector insertDataIntoTable() {
		 
        Vector results = new Vector();
        try {
        Connection con = DriverManager.getConnection("jdbc:mysql://sql3.freemysqlhosting.net:3306/sql368354","sql368354","wM7%yR2!");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from bewerber");
 
        while (rs.next()) {
        	Vector applicant = new Vector();
            applicant.add(rs.getString(1));
            applicant.add(rs.getString(2));
            applicant.add(rs.getString(3));
            applicant.add(rs.getString(4));
            applicant.add(rs.getString(5));
            applicant.add(rs.getString(6));
            results.add(applicant);
        }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
	}
	
	//METHODE: Standardkonstruktor
	public Datenbank(){
		
	}
}
