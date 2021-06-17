import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Jlabels extends JLabel {

   Jlabels()
   {
       super("Welcome To Brampton Burgers");
       Border bor= BorderFactory.createLineBorder(Color.BLACK);
       setBorder(bor);

       setPreferredSize(new Dimension(150,30));
       setHorizontalAlignment(CENTER);
       setVerticalAlignment(CENTER);



   }
}
