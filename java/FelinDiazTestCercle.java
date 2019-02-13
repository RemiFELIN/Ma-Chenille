import java.applet.Applet;
import java.awt.*;

public class FelinDiazTestCercle extends Applet{

  private FelinDiazCercle monCercle;
  
  public void init(){
    monCercle = new FelinDiazCercle(50);
  }

  public void paint(Graphics g){  
    g.drawRect(5, 5, FelinDiazCercle.xMax-5, FelinDiazCercle.yMax-5); 
    monCercle.dessiner(g, Color.blue);
    monCercle.setDiametre(100); 
    monCercle.dessiner(g, Color.red);
    monCercle.deplacerVers(100, 100); 
    monCercle.dessiner(g, Color.green) ;
  }
  
}
