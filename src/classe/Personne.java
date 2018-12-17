package classe;

import java.util.ArrayList;

public class Personne {
	String nom;
	String prenom;
	ArrayList<Discipline> disciplines = new ArrayList<Discipline>();
	ArrayList<Recompense> recompenses = new ArrayList<Recompense>();
	int taille;

	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;

	}
	
	@Override
	public String toString() {
		ArrayList<String> affiche = new ArrayList<String>();
		int index =0;
		for (Recompense re : recompenses) {
			affiche.add(re.getRecompense()+" "+disciplines.get(index).getDiscipline()+"\r\n");
			index++;
		}
		return "Personne nom=" + nom + ", prenom= " + prenom + ",\r\n" + affiche;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public ArrayList<Discipline> getDisciplines() {
		return disciplines;
	}
	
	public ArrayList<Recompense> getRecompenses() {
		return recompenses;
	}
	public void addRecompensesAndDiscipline(Recompense recompense,Discipline discipline) {
		this.recompenses.add(recompense);
		this.disciplines.add(discipline);	
	}
	public int getTaille() {
		
		this.taille = recompenses.size();
		return taille;
	}
	
}
