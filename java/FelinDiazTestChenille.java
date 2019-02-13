import java.applet.Applet;
import java.awt.*;
import java.awt.event.* ;

public class FelinDiazTestChenille extends Applet implements ActionListener{
    
    private Button reduireAngle = new Button("-") ; 
    private Button deplacer = new Button("GO") ; 
    private Button deplacerVite = new Button("GOO") ; 
    private Button augmenterAngle = new Button("+") ; 
    private FelinDiazChenille maChenille  ;

    public void init(){
        this.add(reduireAngle) ; reduireAngle.addActionListener(this) ;
        this.add(deplacer) ; deplacer.addActionListener(this) ;
        this.add(deplacerVite) ; deplacerVite.addActionListener(this) ;
        this.add(augmenterAngle) ; augmenterAngle.addActionListener(this) ;
        // créer une chenille
        maChenille = new FelinDiazChenille(20,10,45,Color.blue);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand() == "-"){
            if (maChenille.getAngleDeVision()>0){
                maChenille.setAngleDeVision((float)(maChenille.getAngleDeVision()*0.90)); 
                repaint();
            }
        }
        else if(e.getActionCommand() == "+"){
            if (maChenille.getAngleDeVision()<180){
                maChenille.setAngleDeVision((float)(maChenille.getAngleDeVision()*1.1)); 
                repaint();
            }
        }
        else if(e.getActionCommand() == "GO"){
            maChenille.deplacer(); 
            repaint();
        }
       else if(e.getActionCommand() == "GOO"){
           for(int i=0 ; i<5 ; i++){
              maChenille.deplacer(); 
              repaint();
           }
       }
    }

    public void paint(Graphics g) {  
       g.drawRect(5,5,FelinDiazCercle.xMax-5,FelinDiazCercle.yMax-5);
       maChenille.dessiner(g) ;
    }

}
