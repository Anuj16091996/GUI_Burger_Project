import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class TextArea extends JPanel {

    private JTextArea textArea;
    private  TitledBorder title;

    public TextArea()
    {
        //Initialize Fields
        textArea= new JTextArea();

        //Setting Layouts
       setLayout(new BorderLayout());
       add(new JScrollPane(textArea), BorderLayout.CENTER);

       //Creating a Dimension to divide into half
       Dimension dim= new Dimension();
       dim.width=220;

       //Setting dimension
       setPreferredSize(dim);

       //No Writing Option
        textArea.setEditable(false);

        //Adding Border To Mention Display Area
        title = BorderFactory.createTitledBorder("Order Here");
        title.setTitleJustification(TitledBorder.CENTER);
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border fullBorder = BorderFactory.createCompoundBorder(outerBorder, title);
        setBorder(fullBorder);
    }

    public void appendText(String str)
    {
        textArea.append(str);
    }

    public void setText(String str)
    {
        textArea.setText(str);
    }
}
