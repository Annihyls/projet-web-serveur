package filejava.dao;

import java.sql.*;

public class _Initializer {

    public static void Init(){
        Connection connection = _Connector.getInstance();

        try {
            PreparedStatement statement;
            PreparedStatement statement2;
            PreparedStatement statement3;
            PreparedStatement statement4;
            PreparedStatement statement5;

            //Init articles table
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS eleves (id int auto_increment, nom varchar(100), prenom varchar(100), dateNaissance varchar(100), PRIMARY KEY(id)); ");
            statement.executeUpdate();
            statement2 = connection.prepareStatement("CREATE TABLE IF NOT EXISTS gommettes (id int auto_increment, couleur varchar(100), description varchar(500), PRIMARY KEY(id)); ");
            statement2.executeUpdate();
            statement3 = connection.prepareStatement("CREATE TABLE IF NOT EXISTS profs (id int auto_increment, nom varchar(100), prenom varchar(100), username varchar(100), PRIMARY KEY(id)); ");
            statement3.executeUpdate();
            statement4 = connection.prepareStatement("CREATE TABLE IF NOT EXISTS elevegommettes (id int auto_increment, raison varchar(100), date varchar(100), idEleve int, idProf int, idGommette int, PRIMARY KEY(id), foreign key(idEleve) references eleves(id), foreign key(idProf) references profs(id), foreign key(idGommette) references gommettes(id)); ");
            statement4.executeUpdate();
            statement5 = connection.prepareStatement("CREATE TABLE IF NOT EXISTS login (id int auto_increment, idProf int, username varchar(100), password varchar(100), PRIMARY KEY(id), foreign key(username) references profs(username), foreign key(idProf) references profs(id));");
            statement5.executeUpdate();

        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
        }
    }
}
