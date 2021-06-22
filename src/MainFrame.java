import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Labels label;
    private TextArea textArea;
    private UserPanel user;

        public MainFrame()
        {
            super("Brampton Burgers");
            setLayout(new BorderLayout());

            //Adding Label
                label= new Labels();
                add(label, BorderLayout.NORTH);

            //Adding textarea
            textArea= new TextArea();
            add(textArea, BorderLayout.EAST);

            //Adding User Panel
            user= new UserPanel();
            add(user,BorderLayout.CENTER);

            //Setting FormListener
            user.setFormListener(new FormListener() {
                @Override
                public void Form_Event_Trigger(FormEvent e) {
                    textArea.setText(String.valueOf(e));
                }
            });
            setMinimumSize(new Dimension(600,500));
            setSize(600,500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setLocationRelativeTo(null);
        }
}
