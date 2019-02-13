import java.applet.Applet;
import java.awt.*;
import java.awt.event.* ;

public class FelinDiazTestMaChenille extends Applet implements ActionListener {
    private Button reduireAngle = new Button("Gauche"); 
    private Button deplacer = new Button("GO"); 
    private Button deplacerVite = new Button("GOO"); 
    private Button augmenterAngle = new Button("Droite"); 
    private FelinDiazChenille chenilleAlea;
    private FelinDiazMaChenille chenilleControle;
    public int Texte;

    public void init(){
        this.add(reduireAngle); 
        reduireAngle.addActionListener(this);
        this.add(deplacer); 
        deplacer.addActionListener(this);
        this.add(deplacerVite);
        deplacerVite.addActionListener(this);
        this.add(augmenterAngle); 
        augmenterAngle.addActionListener(this);
        chenilleAlea = new FelinDiazChenille(20,10,90,Color.blue);
        chenilleControle = new FelinDiazMaChenille(20,10,0,Color.red);
        Texte = 0;
    }

    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand() == "Gauche"){
            if(chenilleControle.getAngleDeVision()>=-5){
                chenilleControle.setAngleDeVision( (float)(chenilleControle.getAngleDeVision() - 5) ); 
                repaint();
            }
        }
        else if(e.getActionCommand() == "Droite"){
            if (chenilleControle.getAngleDeVision()<=5){
                chenilleControle.setAngleDeVision( (float)(chenilleControle.getAngleDeVision() + 5)); 
                repaint();
            }
        }
        else if(e.getActionCommand() == "GO"){
            chenilleControle.deplacerControle(); 
            repaint();
            chenilleAlea.deplacer(); 
            repaint();
        }
        else if(e.getActionCommand() == "GOO"){
            for(int i=0 ; i<5 ; i++){
                chenilleControle.deplacerControle(); 
                repaint();
                chenilleAlea.deplacer(); 
                repaint();
            }
        }
        if(e.getActionCommand() == "GO" || e.getActionCommand() == "GOO"){ 
            for(int i=0 ; i<20 ; i++){
                if( Math.abs(chenilleControle.tete.getAbscisse() - chenilleAlea.corps[i].getAbscisse() )<=10 && Math.abs(chenilleControle.tete.getOrdonnee()-chenilleAlea.corps[i].getOrdonnee())<=10 ){
                    Texte=1; 
                    repaint(); 
                }
                else if ( Math.abs(chenilleControle.tete.getAbscisse() - chenilleAlea.tete.getAbscisse() )<=10 && Math.abs(chenilleControle.tete.getOrdonnee()-chenilleAlea.tete.getOrdonnee())<=10 ) {
                    Texte=1; 
                    repaint();
                }
            } 
        } 
    }


    public void paint(Graphics g) {  
        g.drawRect(5, 5, FelinDiazCercle.xMax-5, FelinDiazCercle.yMax-5);
        chenilleControle.dessiner(g);
        chenilleAlea.dessiner(g);
        if (Texte==1){
            g.clearRect(5, 5, 495, 495);
            g.drawString("WIN", 250, 250); 
        } 
    }
  
}
