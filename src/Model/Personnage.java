package Model;

public class Personnage {
	Case caseActuelle;
	
	public Personnage(Case c){
		this.caseActuelle = c;
	}

	public void deplacerBasique(Case nouvelleCase){
		if(caseActuelle.aPourCaseVoisine(nouvelleCase)){
			setCaseActuelle(nouvelleCase);
		}else{
			/*TODO
			 * voir plus court chemin
			 */
		}
	}

	public Case getCaseActuelle() {
		return caseActuelle;
	}

	private void setCaseActuelle(Case caseActuelle) {
		this.caseActuelle = caseActuelle;
	}
}
