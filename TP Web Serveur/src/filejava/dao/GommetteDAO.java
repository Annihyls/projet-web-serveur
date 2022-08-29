package filejava.dao;

import filejava.classe.Gommette;

import java.sql.*;
import java.util.ArrayList;

public class GommetteDAO extends _Generic<Gommette> {
	 public ArrayList<Gommette> getAllGommettes() {
		ArrayList<Gommette> gommettes = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM gommettes ORDER BY id ASC;");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Gommette gommette = new Gommette();
				gommette.setId(resultSet.getInt("id"));
				gommette.setDescription(resultSet.getString("description"));
				gommette.setCouleur(resultSet.getString("couleur"));
				
				gommettes.add(gommette);
			}
		} catch (SQLException error) {
			error.printStackTrace();
		}
		
		return gommettes;
	}
	 /*-------------------------------------------pour ajouter/effacer des gommettes-------------------------------------------*/
	 public void create(String description, String couleur) {
		 try {

			 PreparedStatement statement =  this.connect.prepareStatement("INSERT INTO gommettes(couleur, description) VALUES(?, ?);");
			 statement.setString(1, couleur);
			 statement.setString(2, description);
			 statement.executeUpdate();
		 }catch (SQLException error) {
			 error.printStackTrace();
		 }
	 }

	 public void delete(int idGommette) {
		 try {
			 PreparedStatement preparedStatement = this.connect.prepareStatement("DELETE FROM gommettes WHERE id = ?");
			 preparedStatement.setInt(1, idGommette);
			 preparedStatement.executeUpdate();
		 }catch (SQLException error) {
			 error.printStackTrace();
		 }
	 }

	public void update(int idGommette, String description, String couleur) {
		try {
			PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE gommettes SET description = ?, couleur = ? WHERE id = ?");
			preparedStatement.setString(1, description);
			preparedStatement.setString(2, couleur);
			preparedStatement.setInt(3, idGommette);
			preparedStatement.executeUpdate();
		}catch (SQLException error) {
			error.printStackTrace();
		}
	}
	 /*----------------------------------------------------------------------------------------------------------*/
}