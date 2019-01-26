import java.applet.Applet;
import java.awt.*;

public class FelinDiazTestCercleAnime extends Applet {

  private FelinDiazCercleAnime monCercleAnime;

  public void init(){ monCercleAnime = new FelinDiazCercleAnime(30,0);}

  public void paint(Graphics g) {  
     g.drawRect(5,5,FelinDiazCercleAnime.xMax-5,FelinDiazCercleAnime.yMax-5) ; monCercleAnime.dessiner(g, Color.blue) ;
     monCercleAnime.avancer(200) ; monCercleAnime.dessiner(g, Color.red) ;
     monCercleAnime.tourner(90) ; monCercleAnime.avancer(100) ; monCercleAnime.dessiner(g, Color.green) ;
  }
}
