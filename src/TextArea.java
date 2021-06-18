import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class TextArea extends JPanel {

    private JTextArea textArea;
    private  TitledBorder tittle;


    public TextArea()
    {
        //Intilaize Fields
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
        tittle= BorderFactory.createTitledBorder("Your Order Display");
        tittle.setTitleJustification(TitledBorder.CENTER);
        Border outerborder=BorderFactory.createEmptyBorder(5,5,5,5);
        Border fullborder=BorderFactory.createCompoundBorder(outerborder,tittle);
        setBorder(fullborder);




    }

    public void AppendText(String str)
    {
        textArea.append(str);
    }


    public void SetText(String str)
    {
        textArea.setText(str);
    }
}
