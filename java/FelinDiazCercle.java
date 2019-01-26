import java.awt.*;
/**
* Un cercle possède un centre dont on connait l’abscisse et l’ordonnée
* Un cercle a un diamètre
* Un cercle peut placer son centre sur une position donnée
* Une cercle peut se dessiner
* @author (les noms du binome) 
* @version (a version number or a date)
*/
public class FelinDiazCercle {
      public static final int xMax=500; // abscisse maximum de la fenêtre
      public static final int yMax=500; // ordonnée maximum de la fenêtre
      // l'origine (i.e. (0,0)) représente le coin supérieur gauche de la fenêtre 
      
      // instance variables
      private float abscisse ; // abscisse du centre
      private float ordonnee ; // ordonnée du centre
      private float diametre ; // diamètre 

      /*****************************************
      * Constructor for objects of class Cercle
      * creer un cercle en fixant sa position initiale et son diamètre
      * @param x abscisse du centre
      * @param y ordonnée du centre 
      * @param d diamètre
      */
      public FelinDiazCercle(float x, float y, float d) {this.abscisse=x ; this.ordonnee=y ; this.diametre=d;}

      /******************************************
      * constructor for objects of class Cercle 
      * créer un cercle au centre de la fenêtre en fixant son diamètre
      * @param d diamètre
      */
      public FelinDiazCercle(float d) {this(xMax/2,yMax/2, d);}

      /******************************************
      * constructor for objects of class Cercle
      * créer un cercle au centre de la fenêtre
      * en fixant son diamètre à 5
      */
      public FelinDiazCercle() { this(xMax/2, yMax/2, 5); }
    
      /*****************************************
      * obtenir l'abscisse du centre
      * @return abscisse
      */
      public float getAbscisse() {return this.abscisse;}
     
     /*****************************************
      * obtenir l’ordonnée du centre
      * @return ordonnee
      */
      public float getOrdonnee() {return this.ordonnee;}

     /*****************************************
      * obtenir le diamètre
      * @return diametre
      */
      public float getDiametre()  {return this.diametre;}
     
      /*****************************************
      * modifier l'abscisse du centre
      * @param x nouvelle abscisse
      */
      public void setAbscisse(float x) {this.abscisse=x;}
    
      /*****************************************
      * modifier l’ordonnée du centre
      * @param y nouvelle ordonnée
      */
      public void setOrdonnee(float y) {this.ordonnee=y;}
         
      /*****************************************
      * modifier le diamètre
      * @param d nouveau diamètre
      */
      public final void  setDiametre(float d) {this.diametre=d;}
	
      /*****************************************
      * modifier la position du centre
      * @param x abscisse
      * @param y ordonnee
      */
      public void deplacerVers(float x, float y){this.setAbscisse(x);this.setOrdonnee(y);}
 
      /*****************************************
      * se dessiner d'une certaine couleur 
      * @param g contexte graphique
      * @param c couleur
      */
      public void dessiner(Graphics g, Color c){
          g.drawOval((int)(abscisse-diametre/2),(int)(ordonnee-diametre/2),(int)diametre, (int)diametre) ; 
          g.setColor(c) ;}
     
}
