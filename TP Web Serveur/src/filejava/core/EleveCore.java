package filejava.core;

import filejava.dao.EleveDAO;
import filejava.classe.Eleve;

import java.util.ArrayList;

public class EleveCore{
    public static ArrayList<Eleve> getAllEleves(){
        return new EleveDAO().getAllEleves();
    }
    public static void deleteEleve(int id){
        new EleveDAO().delete(id);
    }
    public static void updateEleve(int id, String nom, String prenom, String dateNaissance){
        new EleveDAO().update(id, nom, prenom, dateNaissance);
    }
    public static void addEleve(String nom, String prenom, String dateNaissance){
        new EleveDAO().create(nom, prenom, dateNaissance);
    }
}