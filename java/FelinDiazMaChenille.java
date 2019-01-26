import java.awt.Color ;

public class FelinDiazMaChenille

{   
    private int            epaisseur; 
    private int            longueur;  
    private Color          couleur ;
    protected FelinDiazTeteDeChenille tete;
    protected FelinDiazCercle []      corps;     

public FelinDiazMaChenille(int longueur, int epaisseur, float angleVision, Color c){ 
        this.longueur      = longueur; 
        this.epaisseur     = epaisseur;
        this.couleur       = c;
        this.tete          = new FelinDiazTeteDeChenille(125,125,this.epaisseur,angleVision/2,angleVision); 
        this.corps         = new FelinDiazCercle[this.longueur];
        corps[longueur-1]  = new FelinDiazCercle((float)((this.tete.xMax/4)-epaisseur/2),this.tete.yMax/4,epaisseur);
        for(int i=longueur-2 ; i>=0 ; i--){corps[i]=                                                                                    
        new FelinDiazCercle((float)((this.tete.xMax/4)-((epaisseur/2)*i)),this.tete.yMax/4,epaisseur);}
    }             

    public float getAngleDeVision()       {return this.tete.getAngleDeVision();}
    
    public void setAngleDeVision(float a) {this.tete.setAngleDeVision(a);}                                                       

public void deplacerControle(){
        for(int i=0 ; i<longueur-1 ; i++) {
              this.corps[i].setAbscisse(this.corps[i+1].getAbscisse()) ; 
              this.corps[i].setOrdonnee(this.corps[i+1].getOrdonnee()) ; }
        this.corps[longueur-1].setAbscisse(this.tete.getAbscisse()) ; 
        this.corps[longueur-1].setOrdonnee(this.tete.getOrdonnee()) ;
        this.tete.deplacerBis() ; 
    }

 public void dessiner(java.awt.Graphics g){
        this.tete.dessiner(g,this.couleur) ; 
        for(int i=0 ; i<longueur ; i++) {
		this.corps[i].dessiner(g,this.couleur);
	}  
    }

}
