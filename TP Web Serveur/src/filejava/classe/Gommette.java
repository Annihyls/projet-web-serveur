package filejava.classe;

public class Gommette{

	private String description;
	private String couleur;
	private int ID;
	
	public Gommette(){
		//pas besoin de constructeur
	}

	public int getId(){
		return ID;
	}
	public void setId(int id){
		this.ID = id;
	}
	
	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description = description;
	}
	
	public String getCouleur(){
		return couleur;
	}
	public void setCouleur(String couleur){
		this.couleur = couleur;
	}
}