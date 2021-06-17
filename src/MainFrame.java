import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Jlabels label;
    private TextArea textArea;
    private UserPannel user;

        public MainFrame()
        {
            super("Brampton Burgers");
            setLayout(new BorderLayout());


            //Adding Label
                label= new Jlabels();
                add(label, BorderLayout.NORTH);

            //Adding textarea
            textArea= new TextArea();
            add(textArea, BorderLayout.EAST);

            //Adding User Pannel
            user= new UserPannel();
            add(user,BorderLayout.WEST);

            setSize(600,500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setLocationRelativeTo(null);
        }


}
