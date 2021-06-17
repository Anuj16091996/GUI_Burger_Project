import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class UserPannel extends JPanel {
    private JLabel burger_label;
    private JComboBox Burger_box;

    public UserPannel()
    {
        Dimension dim= getPreferredSize();
        dim.width=390;
        setPreferredSize(dim);

        //Intiliazing Members Variables
        burger_label= new JLabel("Select Your Burger");
        Burger_box= new JComboBox();

        //Adding Border to Display The Order Pannel
       TitledBorder innerborder= BorderFactory.createTitledBorder("Order Here");
       innerborder.setTitleJustification(TitledBorder.CENTER);
        Border outerborder=BorderFactory.createEmptyBorder(5,5,5,5);
        Border fullborder=BorderFactory.createCompoundBorder(outerborder,innerborder);
        setBorder(fullborder);

        //Adding Burger To Combo Box
        DefaultComboBoxModel combomodel= new DefaultComboBoxModel();

        // Basic Burger
        combomodel.addElement(new Burger("Basic",
                "With White With Chicken",3.56
        ,4));

        //Healthy Burger
        combomodel.addElement(new Burger("Healthy",
                "With Brown Rye With Bacon",5.67
                ,6));


        //Deluxe Burger
        combomodel.addElement(new Burger("Deluxe",
                "With White with Sausage",14.54
                ,2));

        //Setting the model to burger box
        Burger_box.setModel(combomodel);






        //Adding Label In the user pannel using Grid Alligment
        setLayout(new GridBagLayout());
        GridBagConstraints gc= new GridBagConstraints();

        gc.weighty=1;
        gc.weightx=1;
        gc.fill=GridBagConstraints.FIRST_LINE_START;


        gc.gridx=0;
        gc.gridy=0;
        gc.anchor= GridBagConstraints.FIRST_LINE_START;
        gc.insets= new Insets(20,130,0,0);
        add(burger_label,gc);


        gc.gridy++;
        gc.weighty=1;
        gc.insets= new Insets(00,0,300,0);
        add(Burger_box,gc);




//        setBorder(BorderFactory.createTitledBorder("Brampton Burgers"));




    }
}
