package filejava.classe;

public class Eleve{
	private String nom;
	private String prenom;
	private String dateNaissance;
	private int ID;
	
	public Eleve(){
		//pas besoin de constructeur
	}
	
	public String getNom(){
		return nom;
	}
	public void setNom(String nom){
		this.nom = nom;
	}
	
	public String getPrenom(){
		return prenom;
	}
	public void setPrenom(String prenom){
		this.prenom = prenom;
	}
	
	public String getDateNaissance(){
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance){
		this.dateNaissance = dateNaissance;
	}
	
	public int getId(){
		return ID;
	}
	public void setId(int id){
		this.ID = id;
	}
}