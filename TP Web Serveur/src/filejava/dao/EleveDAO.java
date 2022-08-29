package filejava.dao;

import filejava.classe.Eleve;

import java.sql.*;
import java.util.ArrayList;

public class EleveDAO extends _Generic<Eleve> {
	 public ArrayList<Eleve> getAllEleves() {
		ArrayList<Eleve> eleves = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM eleves ORDER BY id ASC;");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Eleve eleve = new Eleve();
				eleve.setId(resultSet.getInt("id"));
				eleve.setNom(resultSet.getString("nom"));
				eleve.setPrenom(resultSet.getString("prenom"));
				eleve.setDateNaissance(resultSet.getString("dateNaissance"));
				
				eleves.add(eleve);
			}
		} catch (SQLException error) {
			error.printStackTrace();
		}
		
		return eleves;
	}
	 /*-------------------------------------------pour ajouter/effacer des élèves-------------------------------------------*/
	 public void create(String nom, String prenom, String dateNaissance) {
		 try {
			 PreparedStatement statement =  this.connect.prepareStatement("INSERT INTO eleves (nom, prenom, dateNaissance) VALUES(?, ?, ?);");
			 statement.setString(1, nom);
			 statement.setString(2, prenom);
			 statement.setString(3, dateNaissance);
			 statement.executeUpdate();
		 }catch (SQLException error) {
			 error.printStackTrace();
		 }
	 }

	public void delete(int idEleve) {
		try {
			PreparedStatement preparedStatement = this.connect.prepareStatement("DELETE FROM eleves WHERE id = ?");
			preparedStatement.setInt(1, idEleve);
			preparedStatement.executeUpdate();
		}catch (SQLException error) {
			error.printStackTrace();
		}
	}

	public void update(int idEleve, String nom, String prenom, String dateNaissance) {
		try {
			PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE eleves SET prenom = ?, nom = ?, dateNaissance = ? WHERE id = ?");
			preparedStatement.setString(1, prenom);
			preparedStatement.setString(2, nom);
			preparedStatement.setString(3, dateNaissance);
			preparedStatement.setInt(4, idEleve);
			preparedStatement.executeUpdate();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	 /*----------------------------------------------------------------------------------------------------------*/

}