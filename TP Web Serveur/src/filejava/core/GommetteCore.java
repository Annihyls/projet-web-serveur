package filejava.core;

import filejava.dao.GommetteDAO;
import filejava.classe.Gommette;

import java.util.ArrayList;

public class GommetteCore{
    public static ArrayList<Gommette> getAllGommettes(){
        return new GommetteDAO().getAllGommettes();
    }
    public static void deleteGommette(int id){
        new GommetteDAO().delete(id);
    }
    public static void updateGommette(int id, String description, String couleur){
        new GommetteDAO().update(id, description, couleur);
    }
    public static void addGommette(String description, String couleur){
        new GommetteDAO().create(description, couleur);
    }
}
