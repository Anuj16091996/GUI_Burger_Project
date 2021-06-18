import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class UserPannel extends JPanel implements ActionListener {
    private JLabel burger_label;
    private JComboBox Burger_box;
    private JButton subbtn;
    ArrayList<Burger>burger= new ArrayList<Burger>();
    private FormListner formListner;
    private JLabel Topping_label;


    public UserPannel() {
        Dimension dim = getPreferredSize();
        dim.width = 360;
        setPreferredSize(dim);

        //Intiliazing Members Variables
        burger_label = new JLabel("Select Your Burger");
        Burger_box = new JComboBox();
        subbtn = new JButton("Submit");
        Topping_label = new JLabel("Add Some Toppings");


        //Calling Action Listner
        subbtn.addActionListener(this);

        //Adding Border to Display The Order Pannel
        TitledBorder innerborder = BorderFactory.createTitledBorder("Order Here");
        innerborder.setTitleJustification(TitledBorder.CENTER);
        Border outerborder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border fullborder = BorderFactory.createCompoundBorder(outerborder, innerborder);
        setBorder(fullborder);

        //Adding Burger to arraylist
        ArrayList<Burger> Bur_ele = new ArrayList<Burger>();
        Burger Basic = (new Burger("Basic",
                "With White With Chicken", 3.56
                , 4));

        Burger Healthy = new Burger("Healthy",
                "With Brown Rye With Bacon", 5.67
                , 6);

        Burger Deluxe = new Burger("Deluxe",
                "With White with Sausage", 14.54
                , 2);
        Bur_ele.add(Basic);
        Bur_ele.add(Healthy);
        Bur_ele.add(Deluxe);


        //Adding Burger To Combo Box
        DefaultComboBoxModel combomodel = new DefaultComboBoxModel();
        combomodel.addElement(Bur_ele.get(0));
        combomodel.addElement(Bur_ele.get(1));
        combomodel.addElement(Bur_ele.get(2));

        //Setting the model to burger box
        Burger_box.setModel(combomodel);
        Burger_box.setSelectedIndex(-1);
        Alligment();

    }

        public void Alligment()
        {
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


            //Adding Drop Down Menu
            gc.gridy++;
            gc.weighty=1;
            gc.insets= new Insets(0,40,300,0);
            add(Burger_box,gc);

            //Adding a submit Button
            gc.insets= new Insets(50,150,00,0);
            add(subbtn, gc);



        }



//        setBorder(BorderFactory.createTitledBorder("Brampton Burgers"));






    @Override
    public void actionPerformed(ActionEvent e) {
      Burger User_select= (Burger) Burger_box.getSelectedItem();



        //Calling Form Event
        FormEvent fe=new FormEvent(e,User_select);

        //Checking That Formlistner is not null

        if(formListner!= null)
        {



            formListner.Form_Event_Trigger(fe);
            Burger_box.setSelectedIndex(-1);
            setLayout(new GridBagLayout());
            Alligment();
//            GridBagConstraints gc= new GridBagConstraints();
//            add(Topping_label);

        }

    }


    public void setFormListner(FormListner formListner) {
        this.formListner = formListner;
    }
}
