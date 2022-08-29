package filejava;

import filejava.classe.EleveGommettes;
import filejava.dao.ProfDAO;
import filejava.dao._Initializer;
import filejava.gui.*;
import filejava.core.*;
import filejava.security.doLogin;

import java.util.Map;

import static spark.Spark.*;

public class StartServer{
	private static Map<String, String> session;
	private static String login;

	public static void main(String[] args){

		staticFiles.location("/static/");
		port(8088);

		_Initializer.Init();

		get("/index", (req, res) ->{
			return indexGUI.getIndex();
		});

		get("redirect/eleve/gommettes", (req, res) ->{
			String idEleveGommette = req.queryParams("eleveid");
			res.redirect("/eleves/"+idEleveGommette+"/gommettes", 301);
			return null;
		});

		get("/gommettes", (req, res) ->{
			return GommetteGUI.getAllGommettes();
		});

		get("/gommettes/:id/delete", (req, res) ->{
			String id = req.params(":id");
			int ID = Integer.parseInt(id);
			if(login == null){
				System.out.println("Connectez-vous !");
				res.redirect("/login", 301);
			}
			else{
				session = doLogin.introspect(login);
				if(session != null){
					GommetteCore.deleteGommette(ID);
					res.redirect("/gommettes", 301);
				}
				else{
					System.out.println("TOKEN EXPIRE OU TOKEN INVALIDE !");
					res.redirect("/login", 301);
				}
			}
			return null;
		});

		post("/gommettes/update", (req, res) ->{
			String id = req.queryParams("id");
			String description = req.queryParams("descriptionUpdate");
			String couleur = req.queryParams("couleurUpdate");
			int ID = Integer.parseInt(id);
			if(login == null){
				System.out.println("Connectez-vous !");
				res.redirect("/login", 301);
			}
			else{
				session = doLogin.introspect(login);
				if(session != null){
					GommetteCore.updateGommette(ID, description, couleur);
					res.redirect("/gommettes", 301);
				}
				else{
					System.out.println("TOKEN EXPIRE OU TOKEN INVALIDE !");
					res.redirect("/login", 301);
				}
			}
			return null;
		});

		post("/gommettes/add", (req, res) ->{
			String description = req.queryParams("description");
			String couleur = req.queryParams("couleur");
			if(login == null){
				System.out.println("Connectez-vous !");
				res.redirect("/login", 301);
			}
			else{
				session = doLogin.introspect(login);
				if(session != null){
					GommetteCore.addGommette(description, couleur);
					res.redirect("/gommettes", 301);
				}
				else{
					System.out.println("TOKEN EXPIRE OU TOKEN INVALIDE !");
					res.redirect("/login", 301);
				}
			}
			return null;
		});

		get("/eleves", (req, res) ->{
			return EleveGUI.getAllEleves();
		});

		get("/eleves/:id/delete", (req, res) ->{
			String id = req.params(":id");
			int ID = Integer.parseInt(id);
			if(login == null){
				System.out.println("Connectez-vous !");
				res.redirect("/login", 301);
			}
			else{
				session = doLogin.introspect(login);
				if(session != null){
					EleveCore.deleteEleve(ID);
					res.redirect("/eleves", 301);
				}
				else{
					System.out.println("TOKEN EXPIRE OU TOKEN INVALIDE !");
					res.redirect("/login", 301);
				}
			}
			return null;
		});

		post("/eleves/update", (req, res) ->{
			String id = req.queryParams("id");
			String nom = req.queryParams("nomUpdate");
			String prenom = req.queryParams("prenomUpdate");
			String dateNaissance = req.queryParams("dateNaissanceUpdate");
			int ID = Integer.parseInt(id);
			if(login == null){
				System.out.println("Connectez-vous !");
				res.redirect("/login", 301);
			}
			else{
				session = doLogin.introspect(login);
				if(session != null){
					EleveCore.updateEleve(ID, nom, prenom, dateNaissance);
					res.redirect("/eleves", 301);
				}
				else{
					System.out.println("TOKEN EXPIRE OU TOKEN INVALIDE !");
					res.redirect("/login", 301);
				}
			}
			return null;
		});

		post("/eleves/add", (req, res) ->{
			String nom = req.queryParams("nom");
			String prenom = req.queryParams("prenom");
			String dateNaissance = req.queryParams("dateNaissance");
			if(login == null){
				System.out.println("Connectez-vous !");
				res.redirect("/login", 301);
			}
			else{
				session = doLogin.introspect(login);
				if(session != null){
					EleveCore.addEleve(nom, prenom, dateNaissance);
					res.redirect("/eleves", 301);
				}
				else{
					System.out.println("TOKEN EXPIRE OU TOKEN INVALIDE !");
					res.redirect("/login", 301);
				}
			}
			return null;
		});

		get("/eleves/:id/gommettes", (req, res) ->{
			String id = req.params(":id");
			int ID = Integer.parseInt(id);
			return EleveGommettesGUI.getAllEleveGommettes(ID);
		});

		get("/eleves/:id/gommettes/:idGommette/delete", (req, res) ->{
			String id = req.params(":id");
			String id2 = req.params(":idGommette");
			int ID = Integer.parseInt(id);
			int ID2 = Integer.parseInt(id2);
			if(login == null){
				System.out.println("Connectez-vous !");
				res.redirect("/login", 301);
			}
			else{
				session = doLogin.introspect(login);
				if(session != null){
					EleveGommettesCore.deleteEleveGommette(ID, ID2);
					res.redirect("/eleves/"+id+"/gommettes", 301);
				}
				else{
					System.out.println("TOKEN EXPIRE OU TOKEN INVALIDE !");
					res.redirect("/login", 301);
				}
			}
			return null;
		});

		post("/eleves/:id/gommettes/update", (req, res) ->{
			String id = req.params(":id");
			String idEleveGommette = req.queryParams("idEleveGommetteUpdate");
			String idGommette = req.queryParams("idGommetteUpdate");
			String raison = req.queryParams("raisonUpdate");
			String date = req.queryParams("dateUpdate");
			int IdEleveGommette = Integer.parseInt(idEleveGommette);
			int IdGommette = Integer.parseInt(idGommette);

			if(login == null){
				System.out.println("Connectez-vous !");
				res.redirect("/login", 301);
			}
			else{
				session = doLogin.introspect(login);
				if(session != null){
					String idprof = session.get("uuid");
					int IdProf = Integer.parseInt(idprof);
					EleveGommettesCore.updateEleveGommette(IdEleveGommette, IdProf, IdGommette, raison, date);
					res.redirect("/eleves/"+id+"/gommettes", 301);
				}
				else{
					System.out.println("TOKEN EXPIRE OU TOKEN INVALIDE !");
					res.redirect("/login", 301);
				}
			}
			return null;
		});

		post("/eleves/:id/gommettes/add", (req, res) ->{
			String id = req.params(":id");
			String idGommette = req.queryParams("idGommette");
			String raison = req.queryParams("raison");
			String date = req.queryParams("date");
			int IdEleve = Integer.parseInt(id);
			int IdGommette = Integer.parseInt(idGommette);

			if(login == null){
				System.out.println("Connectez-vous !");
				res.redirect("/login", 301);
			}
			else{
				session = doLogin.introspect(login);
				if(session != null){
					String idprof = session.get("uuid");
					int IdProf = Integer.parseInt(idprof);
					EleveGommettesCore.addEleveGommette(IdEleve, IdProf, IdGommette, raison, date);
					res.redirect("/eleves/"+id+"/gommettes", 301);
				}
				else{
					System.out.println("TOKEN EXPIRE OU TOKEN INVALIDE !");
					res.redirect("/login", 301);
				}
			}
			return null;
		});

		get("/profs", (req, res) ->{
			return ProfGUI.getAllProfs();
		});

		get("/profs/:id/delete", (req, res) ->{
			String id = req.params(":id");
			int ID = Integer.parseInt(id);
			if(login == null){
				System.out.println("Connectez-vous !");
				res.redirect("/login", 301);
			}
			else{
				session = doLogin.introspect(login);
				if(session != null){

					ProfCore.deleteProf(ID);
					res.redirect("/profs", 301);
				}
				else{
					System.out.println("TOKEN EXPIRE OU TOKEN INVALIDE !");
					res.redirect("/login", 301);
				}
			}
			return null;
		});

		post("/profs/update", (req, res) ->{
			String id = req.queryParams("id");
			String nom = req.queryParams("nomUpdate");
			String prenom = req.queryParams("prenomUpdate");
			String username = req.queryParams("usernameUpdate");
			int ID = Integer.parseInt(id);

			if(login == null){
				System.out.println("Connectez-vous !");
				res.redirect("/login", 301);
			}
			else{
				session = doLogin.introspect(login);
				if(session != null){

					ProfCore.updateProf(ID, nom, prenom, username);
					res.redirect("/profs", 301);
				}
				else{
					System.out.println("TOKEN EXPIRE OU TOKEN INVALIDE !");
					res.redirect("/login", 301);
				}
			}
			return null;
		});

		post("/profs/add", (req, res) ->{
			String nom = req.queryParams("nom");
			String prenom = req.queryParams("prenom");
			String username = req.queryParams("username");

			if(login == null){
				System.out.println("Connectez-vous !");
				res.redirect("/login", 301);
			}
			else{
				session = doLogin.introspect(login);
				if(session != null){

					ProfCore.addProf(nom, prenom, username);
					res.redirect("/profs", 301);
				}
				else{
					System.out.println("TOKEN EXPIRE OU TOKEN INVALIDE !");
					res.redirect("/login", 301);
				}
			}
			return null;
		});

		get("/login", (req, res) ->{
			return LoginGUI.getLoginPage();
		});

		post("/login/create", (req, res) ->{
			String idProf = req.queryParams("idProfCreate");
			int id = Integer.parseInt(idProf);
			String username = req.queryParams("usernameCreate");
			String password = req.queryParams("passwordCreate");
			LoginCore.createLogin(id, username, password);
			res.redirect("/login", 301);
			return null;
		});

		post("/login/connect", (req, res) ->{
			String username = req.queryParams("username");
			String password = req.queryParams("password");
			int verif = LoginCore.verifLogin(username, password);
			if (verif != -1){
				login = doLogin.createToken(username, String.valueOf(verif));
				session = doLogin.introspect(login);
				System.out.println(login);
				System.out.println(session);
				System.out.println("Vous êtes connecté !");
			}
			else{
				System.out.println("Erreur, identifiant ou mot de passe incorrect !");
			}
			res.redirect("/login", 301);
			return null;
		});
	}
}