import java.awt.Color ;

public class FelinDiazChenille
{   
    private int            epaisseur; // épaisseur de la chenille
    private int            longueur;  // longueur du corps en nombre d'anneaux
    private Color          couleur ;
    protected FelinDiazTeteDeChenille tete;
    protected FelinDiazCercle []      corps;     // tableau de cercles

    public FelinDiazChenille(int longueur, int epaisseur, float angleVision, Color c){
        this.longueur      = longueur; // longueur du corps
        this.epaisseur     = epaisseur;
        this.couleur       = c;
        this.tete          = new FelinDiazTeteDeChenille(this.epaisseur,0,angleVision);
        this.corps         = new FelinDiazCercle[this.longueur];
        corps[longueur-1]=new FelinDiazCercle((float)(this.tete.xMax/2)-epaisseur/2,this.tete.yMax/2,epaisseur);
        for(int i=longueur-2 ; i>=0 ; i--){corps[i]= 
        new FelinDiazCercle((float)(this.tete.xMax/2)-((epaisseur/2)*i),this.tete.yMax/2,epaisseur);}
    }
    
    public float getAngleDeVision()       {return this.tete.getAngleDeVision();}
    
    public void setAngleDeVision(float a) {this.tete.setAngleDeVision(a);}
    
    public void deplacer(){
        for(int i=0 ; i<longueur-1 ; i++) {
              this.corps[i].setAbscisse(this.corps[i+1].getAbscisse()) ; 
              this.corps[i].setOrdonnee(this.corps[i+1].getOrdonnee()) ; }
        this.corps[longueur-1].setAbscisse(this.tete.getAbscisse()) ; 
        this.corps[longueur-1].setOrdonnee(this.tete.getOrdonnee()) ;
       // déplacer l'ensemble du corps
        this.tete.deplacer() ; // déplacer la tête
    }
    
    public void dessiner(java.awt.Graphics g){
        this.tete.dessiner(g,this.couleur) ; // dessiner la tête
        for(int i=0 ; i<=longueur ; i++) {
		this.corps[i].dessiner(g,this.couleur);
	}  // dessiner le corps
    }
}
