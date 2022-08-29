package filejava.classe;

public class EleveGommettes{

	private String raison;
    private String date;
	private int ID;
    private int IDEleve;
    private int IDProf;
    private int IDGommette;
	
	public EleveGommettes(){
		//pas besoin de constructeur
	}

	public int getId(){
		return ID;
	}
	public void setId(int id){
		this.ID = id;
	}

	public int getIdEleve(){
		return IDEleve;
	}
	public void setIdEleve(int IDEleve){
		this.IDEleve = IDEleve;
	}

	public int getIdProf(){
		return IDProf;
	}
	public void setIdProf(int IDProf){
		this.IDProf = IDProf;
	}

	public int getIdGommette(){ return IDGommette; }
	public void setIdGommette(int IDGommette){ this.IDGommette = IDGommette; }

	public String getRaison(){
		return raison;
	}
	public void setRaison(String raison){
		this.raison = raison;
	}

    public String getDate(){
		return date;
	}
	public void setDate(String date){
		this.date = date;
	}
}