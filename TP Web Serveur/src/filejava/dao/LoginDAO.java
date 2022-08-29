package filejava.dao;

import java.sql.*;
import java.util.StringTokenizer;

public class LoginDAO extends _Generic {

    public void createLogin(int id, String username, String password){
        try{
            PreparedStatement statement = this.connect.prepareStatement("INSERT INTO login(username, password, idProf) VALUES(?,?,?);");
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

    public int verifLogin(String username, String password) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM login;");
            ResultSet resultSet = preparedStatement.executeQuery();
            int idProf;
            String usernameBD, passwordBD;
            while (resultSet.next()) {
                passwordBD = resultSet.getString("password");
                usernameBD = resultSet.getString("username");
                idProf = resultSet.getInt("idProf");
                if(password.compareTo(passwordBD) == 0 && username.compareTo(usernameBD) == 0){
                    return idProf;
                }
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return -1;
    }
}
