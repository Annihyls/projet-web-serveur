package filejava.core;

import filejava.dao.LoginDAO;

public class LoginCore {
    public static void createLogin(int id, String username, String password){
        new LoginDAO().createLogin(id, username, password);
    }
    public static int verifLogin(String username, String password){
        int verif = new LoginDAO().verifLogin(username, password);
        return verif;
    }
}
