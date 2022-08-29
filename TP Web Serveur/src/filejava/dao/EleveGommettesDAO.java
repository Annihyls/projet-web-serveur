package filejava.dao;

import filejava.classe.EleveGommettes;

import java.sql.*;
import java.util.ArrayList;

public class EleveGommettesDAO extends _Generic<EleveGommettes>{

    public ArrayList<EleveGommettes> getAllEleveGommettes(int id) {
        ArrayList<EleveGommettes> elevegommettes = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT eg.id, eg.idEleve, eg.idProf, eg.idGommette, eg.raison, eg.date FROM elevegommettes AS eg LEFT JOIN eleves AS e ON e.id = eg.idEleve LEFT JOIN profs AS p ON p.id = eg.idProf LEFT JOIN gommettes AS g ON g.id = eg.idGommette WHERE eg.idEleve = ? ORDER BY eg.id ASC;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EleveGommettes eleve = new EleveGommettes();

                eleve.setId(resultSet.getInt("id"));
                eleve.setIdEleve(id);
                eleve.setIdProf(resultSet.getInt("idProf"));
                eleve.setIdGommette(resultSet.getInt("idGommette"));
                eleve.setRaison(resultSet.getString("raison"));
                eleve.setDate(resultSet.getString("date"));

                elevegommettes.add(eleve);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }

        return elevegommettes;
    }

    /*-------------------------------------------pour ajouter/effacer des gommettes aux élèves-------------------------------------------*/
    public void create(int idEleve, int idProf, int idGommette, String raison, String date) {
        try {
            PreparedStatement statement =  this.connect.prepareStatement("INSERT INTO elevegommettes (idEleve, idGommette, raison, date, idProf) VALUES(?, ?, ?, ?, ?);");
            statement.setInt(1, idEleve);
            statement.setInt(2, idGommette);
            statement.setString(3, raison);
            statement.setString(4, date);
            statement.setInt(5, idProf);
            statement.executeUpdate();
        }catch (SQLException error) {
            error.printStackTrace();
        }
    }

    public void delete(int idEleve, int idEleveGommette) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("DELETE FROM elevegommettes WHERE id = ? AND idEleve = ?");
            preparedStatement.setInt(1, idEleveGommette);
            preparedStatement.setInt(2, idEleve);
            preparedStatement.executeUpdate();
        }catch (SQLException error) {
            error.printStackTrace();
        }
    }
    public void update(int idEleveGommette, int idProf, int idGommette, String raison, String date) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE elevegommettes SET idGommette = ?, idProf = ?, raison = ?, date = ? WHERE id = ?");
            preparedStatement.setInt(1, idGommette);
            preparedStatement.setInt(2, idProf);
            preparedStatement.setString(3, raison);
            preparedStatement.setString(4, date);
            preparedStatement.setInt(5, idEleveGommette);
            preparedStatement.executeUpdate();
        }catch (SQLException error) {
            error.printStackTrace();
        }
    }
    /*----------------------------------------------------------------------------------------------------------*/
}
