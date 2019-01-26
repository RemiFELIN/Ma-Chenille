import java.awt.* ;
/**
 * un CercleAnimé est une sorte de Cercle qui
 * possède un cap (0 = Nord, 90 = Est, ...)
 * peut modifier son cap en tournant sur lui-même
 * peut avancer dans la direction de son cap
 * sait si, oui ou non, il est au bord de son espace
 * peut se dessiner en matérialisant son cap 
 * @author (les noms du binome) 
 * @version (a version number or a date)
*/
public class FelinDiazCercleAnime extends FelinDiazCercle {
    
    private float cap;
    
    /************************************************
    * constructor for objects of class CercleAnime
    * créer un CercleAnime au centre de la fenêtre
    * @param centre du CercleAnimé
    * @param diamètre du CercleAnimé
    * @param cap du CercleAnimé
    */
    public FelinDiazCercleAnime(float x, float y, float d, float cap){super(x,y,d) ; this.cap=cap;}
  
    /************************************************
    * constructor for objects of class CercleAnime
    * créer un CercleAnime au centre de la fenêtre
    * @param diamètre du CercleAnimé
    * @param cap du CercleAnimé
    */
    public FelinDiazCercleAnime(float d, float cap){super(d) ; this.cap=cap;}
    
    /************************************************
    * constructor for objects of class CercleAnime
    * créer un CercleAnime au centre de la fenêtre
    * en fixant son diametre a 0
    * @param cap du CercleAnimé
    */
    public FelinDiazCercleAnime(float cap){ super(xMax/2, yMax/2, 0); this.cap=cap;}
    
    /************************************************
    * constructor for objects of class CercleAnime
    * créer un CercleAnime au centre de la fenêtre
    * en fixant son diamètre à 5 et son cap a 0
    */
    public FelinDiazCercleAnime(){ super(xMax/2, yMax/2, 5) ; this.cap=0;}
   
    /************************************************
    * obtenir le cap
    * @return cap
    */
    public float getCap(){return this.cap;}
    
    /************************************************
    * un CercleAnime sait s'il est bord de son espace 
    * @param les bords max de l'espace 
    * @return suis-je au bord ?
    */
    public boolean auBord(float xMax, float yMax){
      return (this.getAbscisse()+this.getDiametre()>xMax-10 || 
              this.getAbscisse()-this.getDiametre()<10      ||
              this.getOrdonnee()+this.getDiametre()>yMax-10 ||
              this.getOrdonnee()-this.getDiametre()<10);
    }
    
    /************************************************
    * un CercleAnime peut tourner d'un certain angle 
    * @param deltaCap incrément du cap
    */
    public void tourner(float deltaCap){ this.cap = this.cap + deltaCap; }
    
    /************************************************
    * un CercleAnime peut avancer selon son cap
    * s'il est au bord de son espace, il fait demi-tour
    * @param longueur du déplacement
    */
    public void avancer(float longueur){
       if (this.auBord(xMax, yMax)) this.tourner(180);
       float capEnRadian=this.cap*(float)(Math.PI/180); // conversion degre2radian
       this.setAbscisse(getAbscisse() + longueur*(float) Math.cos(capEnRadian));
       this.setOrdonnee(getOrdonnee() + longueur*(float) Math.sin(capEnRadian));
    }
   
    /************************************************
    * un CercleAnime peut dessiner son cap 
    * le cap est représente par un "petit" segment de droite issu du centre
    * @param le contexte graphique
    * @param la couleur
    */
    private void dessinerCap(Graphics g, Color c){
        float capEnRadian=this.cap*(float)(Math.PI/180);
        g.drawLine(
                   Math.round(this.getAbscisse()),
                   Math.round(this.getOrdonnee()),
                   Math.round(this.getAbscisse()+this.getDiametre()*(float) Math.cos(capEnRadian)),
                   Math.round(this.getOrdonnee()+this.getDiametre()*(float) Math.sin(capEnRadian))
                   );
    }
    
    /************************************************
    * un CercleAnime peut se dessiner d'une certaine couleur
    * @param le contexte graphique
    * @param la couleur
    */
    public void dessiner(Graphics g, Color c){ // redéfinition d'une méthode de la super classe
        super.dessiner(g,c) ; // dessiner le cercle
        this.dessinerCap(g,c) ; // dessiner le cap
    }
}
