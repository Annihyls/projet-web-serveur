package filejava.core;

import filejava.dao.EleveGommettesDAO;
import filejava.classe.EleveGommettes;
import filejava.dao.GommetteDAO;

import java.util.ArrayList;

public class EleveGommettesCore {
    public static ArrayList<EleveGommettes> getAllEleveGommettes(int id){
        return new EleveGommettesDAO().getAllEleveGommettes(id);
    }
    public static void deleteEleveGommette(int idEleve, int idEleveGommette){
        new EleveGommettesDAO().delete(idEleve, idEleveGommette);
    }
    public static void addEleveGommette(int idEleve, int idProf, int idGommette, String raison, String date){
        new EleveGommettesDAO().create(idEleve, idProf, idGommette, raison, date);
    }
    public static void updateEleveGommette(int idEleveGommette, int idProf, int idGommette, String raison, String date){
        new EleveGommettesDAO().update(idEleveGommette, idProf, idGommette, raison, date);
    }
}
