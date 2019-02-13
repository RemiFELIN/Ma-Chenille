
import java.applet.Applet;
import java.awt.*;
import java.awt.event.* ;

public class FelinDiazTestTeteDeChenille extends Applet implements ActionListener {
      
      private FelinDiazTeteDeChenille maTeteDeChenille;
      private Button reduireAngle = new Button("-"); 
      private Button deplacer = new Button("GO"); 
      private Button deplacerVite = new Button("GOO"); 
      private Button augmenterAngle = new Button("+");

      public void init(){
            this.add(reduireAngle); // ajouter un Button
            this.add(deplacer); // ajouter un Button
            this.add(deplacerVite); // ajouter un Button
            this.add(augmenterAngle); // ajouter un Button
            reduireAngle.addActionListener(this); // l'applet écoute le bouton
            deplacer.addActionListener(this); // l'applet écoute le bouton
            deplacerVite.addActionListener(this); // l'applet écoute le bouton
            augmenterAngle.addActionListener(this); // l'applet écoute le bouton
            // créer une tête de chenille
            maTeteDeChenille = new FelinDiazTeteDeChenille(FelinDiazCercle.xMax/2, FelinDiazCercle.yMax/2, 30, 45, 10);
      }

      // méthode exécutée dès qu'un bouton est enfoncé
      public void actionPerformed(ActionEvent e){
            if(e.getActionCommand() == "-" && maTeteDeChenille.getAngleDeVision()>0){
                  maTeteDeChenille.setAngleDeVision( (float)(maTeteDeChenille.getAngleDeVision()*0.9)); 
                  repaint();
            }
            else if(e.getActionCommand() == "+" && maTeteDeChenille.getAngleDeVision()<180){
                  maTeteDeChenille.setAngleDeVision( (float)(maTeteDeChenille.getAngleDeVision()*1.1)); 
                  repaint();
            }
            else if(e.getActionCommand() == "GO"){
                  maTeteDeChenille.deplacer(); 
                  repaint();
            }
            else if(e.getActionCommand() == "GOO"){
                  for(int i=0 ; i<5 ; i++){
                        maTeteDeChenille.deplacer(); 
                        repaint();
                  }
            }
      }

      public void paint(Graphics g) {  
            g.drawRect(5, 5, FelinDiazCercle.xMax-5, FelinDiazCercle.yMax-5);
            maTeteDeChenille.dessiner(g, Color.blue);
      }

}
