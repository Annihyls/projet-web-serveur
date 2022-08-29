package filejava.dao;

import filejava.classe.Prof;

import java.sql.*;
import java.util.ArrayList;

public class ProfDAO extends _Generic<Prof> {

	public ArrayList<Prof> getAllProfs() {
		ArrayList<Prof> professeurs = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM profs ORDER BY id ASC;");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Prof professeur = new Prof();
				professeur.setId(resultSet.getInt("id"));
				professeur.setNom(resultSet.getString("nom"));
				professeur.setPrenom(resultSet.getString("prenom"));
				professeur.setUsername(resultSet.getString("username"));
				
				professeurs.add(professeur);
			}
		} catch (SQLException error) {
			error.printStackTrace();
		}
		
		return professeurs;
	}
	 /*-------------------------------------------Pour ajouter des profs-------------------------------------------*/
	 public void create(String nom, String prenom, String username) {
		 try {

			 PreparedStatement statement =  this.connect.prepareStatement("INSERT INTO profs (nom, prenom, username) VALUES(?, ?, ?);");
			 statement.setString(1, nom);
			 statement.setString(2, prenom);
			 statement.setString(3, username);
			 statement.executeUpdate();
		 }catch (SQLException error) {
			 error.printStackTrace();
		 }
	 }

	public void delete(int idProf) {
		try {
			PreparedStatement preparedStatement = this.connect.prepareStatement("DELETE FROM profs WHERE id = ?");
			preparedStatement.setInt(1, idProf);
			preparedStatement.executeUpdate();
		}catch (SQLException error) {
			error.printStackTrace();
		}
	}

	public void update(int idProf, String nom, String prenom, String username) {
		try {
			PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE profs SET prenom = ?, nom = ?, username = ? WHERE id = ?");
			preparedStatement.setString(1, prenom);
			preparedStatement.setString(2, nom);
			preparedStatement.setString(3, username);
			preparedStatement.setInt(4, idProf);
			preparedStatement.executeUpdate();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	 /*----------------------------------------------------------------------------------------------------------*/
}