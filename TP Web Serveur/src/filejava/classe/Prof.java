package filejava.classe;

public class Prof{
	private String nom;
	private String prenom;
	private String username;
	private int ID;
	
	public Prof(){
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
	
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username = username;
	}

	public int getId(){
		return ID;
	}
	public void setId(int id){
		this.ID = id;
	}
}