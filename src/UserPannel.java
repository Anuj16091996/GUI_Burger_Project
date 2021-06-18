import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class UserPannel extends JPanel {
    private JLabel burger_label;
    private JComboBox Burger_box;
    ArrayList<Burger>burger= new ArrayList<>();

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

        //Adding Burger to arraylist
        Burger Basic=(new Burger("Basic",
                "With White With Chicken",3.56
                ,4));

        Burger Healthy=new Burger("Healthy",
                "With Brown Rye With Bacon",5.67
                ,6);

        Burger Deluxe=new Burger("Deluxe",
                "With White with Sausage",14.54
                ,2);

        //Adding Burger To Combo Box
        DefaultComboBoxModel combomodel= new DefaultComboBoxModel();
        combomodel.addElement(Basic.getType_of_Burger()+" Burger. Price-" + Basic.getPrice_of_burger());
        combomodel.addElement(Healthy.getType_of_Burger()+" Burger. Price-" + Healthy.getPrice_of_burger());
        combomodel.addElement(Deluxe.getType_of_Burger()+" Burger. Price-" + Deluxe.getPrice_of_burger());

        //Setting the model to burger box
        Burger_box.setModel(combomodel);
        Burger_box.setSelectedIndex(-1);






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
        gc.insets= new Insets(0,100,300,0);
        add(Burger_box,gc);




//        setBorder(BorderFactory.createTitledBorder("Brampton Burgers"));




    }
}
