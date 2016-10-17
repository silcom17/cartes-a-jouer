Cartes à jouer--------------
Url     : http://codes-sources.commentcamarche.net/source/101507-cartes-a-jouerAuteur  : KXDate    : 05/06/2016
Licence :
=========

Ce document intitul� � Cartes à jouer � issu de CommentCaMarche
(codes-sources.commentcamarche.net) est mis � disposition sous les termes de
la licence Creative Commons. Vous pouvez copier, modifier des copies de cette
source, dans les conditions fix�es par la licence, tant que cette note
appara�t clairement.

Description :
=============

Cette API permet de manipuler des cartes à jouer en Java, elle est étroitement
 liée aux caractères Unicode qui représente ces cartes.
<br />Les images fou
rnies sont des enregistrements des caractères Unicode associés en fonte Verdan
a.
<br />
<br />Exemple d'utilisation (Java 5 ou supérieur).
<br />
<br /><
pre class="code" data-mode="java">import java.awt.*;
import javax.swing.JFrame;

import ccm.kx.cards.*;

public class Test {

    public static void main(String[
] args) {
        Card card = new Card(Value.QUEEN, Suit.HEARTS);
        System
.out.println("Card: " + card);
        System.out.println("Unicode: " + Characte
r.getName(UnicodeTools.getCard(card)));
        show(card.getImage());
    }

  
  private static void show(final Image image) {
        final JFrame frame = new
 JFrame();
        frame.setSize(250, 300);
        frame.setContentPane(new Con
tainer() {
            private static final long serialVersionUID = 1;
         
   public void paint(Graphics g) {
                g.drawImage(image, 0, 0, fram
e);
            }
        });
        frame.setLocationRelativeTo(null);
       
 frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_C
LOSE);
    }
}</pre>
<br />Voir aussi : <a href='http://unicode.org/charts/PDF/
U1F0A0.pdf' target='_blank'>http://unicode.org/charts/PDF/U1F0A0.pdf</a>
