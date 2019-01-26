import java.awt.* ;
/**
 * une TeteDeChenille est une sorte de cercleAnime qui :
 * possède un angle de vision
 * peut se déplacer : elle avance alors dans une direction qui dévie aléatoirement
 *    par rapport a son cap sans toutefois aller au delà de la zone couverte par son angle de vision
 * peut se dessiner en matérialisant son angle de vision 
 * @author (les noms du binome) 
 * @version (a version number or a date)
 */
public class FelinDiazTeteDeChenille extends FelinDiazCercleAnime
{
	private float angleDeVision ; // angle de vision exprimé en degré
	
       /************************************************* 
       * Constructor for objects of class TeteDeChenille
       */
       public FelinDiazTeteDeChenille() {super() ; angleDeVision=45;}
	   
       /************************************************* 
       * Constructor for objects of class TeteDeChenille
       */
       public FelinDiazTeteDeChenille(float vision) {super() ; angleDeVision=vision; }
	   
       /*************************************************  
       * Constructor for objects of class TeteDeChenille
       */
       public FelinDiazTeteDeChenille(float d, float cap, float vision){super(d,cap) ; angleDeVision=vision;}
	 
       /*************************************************  
       * Constructor for objects of class TeteDeChenille
       */
       public FelinDiazTeteDeChenille(float x, float y, float d, float cap, float vision) {super(x,y,d,cap) ; angleDeVision=vision;}

       public float getAngleDeVision()       {return this.angleDeVision;}
	
       public void setAngleDeVision(float a) {this.angleDeVision=a % 360;}
    
       /************************************************* 
       * une TeteDeChenille peut se déplacer ; elle avance alors dans une direction qui dévie aléatoirement
       * par rapport a son cap sans toutefois aller au delà de la zone couverte par son angle de vision
       */
       public void deplacer(){
	    this.tourner((float)( (-angleDeVision/2) + Math.random()*(angleDeVision) ));
            this.avancer(this.getDiametre()/2);
       }

       public void deplacerBis(){
	    this.tourner(angleDeVision);
            this.avancer(this.getDiametre()/2); //Utilisé dans l'éxtention
       }
	
       /************************************************* 
       * une TeteDeChenille peut dessiner son angle de vision
       * l'angleDeVision est représenté par deux "petits" segment de droites issues de son centre
       * @param g le contexte graphique
       */
       private void dessinerAngleDeVision(Graphics g){
            g.setColor(Color.red);
            float capEnRadian=this.getCap()*(float)(Math.PI/180);
            float angleDeVisionEnRadian=this.angleDeVision*(float)(Math.PI/180);
            g.drawLine(
                   Math.round(this.getAbscisse()),
                   Math.round(this.getOrdonnee()),
                   Math.round(this.getAbscisse()+30*(float) Math.cos(capEnRadian+angleDeVisionEnRadian/2)),
                   Math.round(this.getOrdonnee()+30*(float) Math.sin(capEnRadian+angleDeVisionEnRadian/2))
                   );
            g.drawLine(
                   Math.round(this.getAbscisse()),
                   Math.round(this.getOrdonnee()),
                   Math.round(this.getAbscisse()+30*(float) Math.cos(capEnRadian-angleDeVisionEnRadian/2)),
                   Math.round(this.getOrdonnee()+30*(float) Math.sin(capEnRadian-angleDeVisionEnRadian/2))
                   );
         }
    
         /************************************************* 
	 * une TeteDeChenille peut se dessiner d'une certaine couleur
	 * @param g le contexte graphique
	 * @param c la couleur
	 */
         public void dessiner(Graphics g, Color c){
              super.dessiner(g,c) ; // dessiner le cercleAnimé
              this.dessinerAngleDeVision(g) ; // dessiner l'angle de vision
         }
}

