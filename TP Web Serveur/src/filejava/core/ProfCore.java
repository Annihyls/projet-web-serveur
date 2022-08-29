package filejava.core;

import filejava.dao.ProfDAO;
import filejava.classe.Prof;

import java.util.ArrayList;

public class ProfCore{
    public static ArrayList<Prof> getAllProfs(){
        return new ProfDAO().getAllProfs();
    }
    public static void deleteProf(int id){
        new ProfDAO().delete(id);
    }
    public static void updateProf(int id, String nom, String prenom, String username){
        new ProfDAO().update(id, nom, prenom, username);
    }
    public static void addProf(String nom, String prenom, String username){
        new ProfDAO().create(nom, prenom, username);
    }
}