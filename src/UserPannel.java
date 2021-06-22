import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public class UserPannel extends JPanel implements ActionListener {
    private JLabel burger_label;
    private JComboBox Burger_box;
    private JButton subbtn;
    ArrayList<Burger>burger= new ArrayList<Burger>();
    private FormListner formListner;
    private JLabel Topping_label;
    ArrayList<Topping> toppings= new ArrayList<>();
    private JLabel tomoto_label;
    private JLabel lettuce_label;
    private JLabel Cheese_label;
    private JLabel Carrot_label;
    private JButton Topping_subbtn;
    private TextField tom_feild;
    private TextField lec_feild;
    private TextField chee_feild;
    private TextField carr_feild;

    public void settingsize(int num)
    {
        Dimension dim = getPreferredSize();
        dim.width = num;
        setPreferredSize(dim);
    }

    public void settingHeight(int num)
    {
        Dimension dim = getPreferredSize();
        dim.height = num;
        setPreferredSize(dim);
    }

    public void dropdown(JLabel label, GridBagConstraints gc, int anchor)
    {
        gc.gridx=0;
        gc.gridy++;
        gc.weighty=0.1;
        gc.anchor=anchor;
        gc.insets=new Insets(0,0,0,0);
        add(label,gc);

    }




    public UserPannel() {

        settingsize(360);

        //Intiliazing Members Variables
        burger_label = new JLabel("Select Your Burger");
        Burger_box = new JComboBox();
        subbtn = new JButton("Submit");

        tomoto_label= new JLabel("Tomoto :- ");
        lettuce_label= new JLabel("Letuce :-  ");
        Cheese_label= new JLabel("Cheese :- ");
        Carrot_label= new JLabel("Carrot :- ");
        Topping_subbtn=new JButton("Submit");

        tom_feild= new TextField(2);
        lec_feild= new TextField(2);
        chee_feild= new TextField(2);
        carr_feild= new TextField(2);



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



        //Adding Topping to arraylist
        ArrayList<Topping> toppings= new ArrayList<>();

        Topping Tomoto= new Topping("Tomato", 0.27);
        Topping Letcue= new Topping("Lettuce",0.72 );
        Topping Cheese = new Topping("Cheese",1.13 );
        Topping Carrot= new Topping("Carrot",2.75 );

        toppings.add(Tomoto);
        toppings.add(Letcue);
        toppings.add(Cheese);
        toppings.add(Carrot);


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




//        setBorder(BorderFactory.createTitledBorder("Brampton Burgers"));






    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Burger User_select= (Burger) Burger_box.getSelectedItem();





        //Calling Form Event
        FormEvent fe=new FormEvent(e,User_select);

        //Checking That Formlistner is not null

        if(formListner!= null)
        {
            formListner.Form_Event_Trigger(fe);
            Burger_box.setSelectedIndex(-1);
            Topping_label = new JLabel("Add "+ User_select.getMax_topping() +"Toppings -: ");

            Border bor= BorderFactory.createLineBorder(Color.BLACK);
            setBorder(bor);
            ALligment_2();


        }


        }catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null,
                    "Please Select An option",
                    "Error",JOptionPane.ERROR_MESSAGE);
        }
    }


    public void setFormListner(FormListner formListner) {
        this.formListner = formListner;
    }


    public void Alligment()
    {
        //Adding Label In the user pannel using Grid Alligment
        setLayout(new GridBagLayout());
        GridBagConstraints gc= new GridBagConstraints();

        gc.weighty=0.1;
        gc.weightx=1;
        gc.fill=GridBagConstraints.NONE;


        gc.gridx=1;
        gc.gridy=0;
//        gc.anchor= GridBagConstraints.CENTER;
        gc.insets= new Insets(0,0,0,0);
        add(burger_label,gc);


        //Adding Drop Down Menu
        gc.gridy++;

        gc.weighty=0.1;
//        gc.anchor=GridBagConstraints.HORIZONTAL;
        add(Burger_box,gc);

        //Adding a submit Button

        gc.gridy++;

        gc.weighty=2;
        gc.anchor=GridBagConstraints.FIRST_LINE_END;
        gc.insets= new Insets(0,0,00,120);
        add(subbtn, gc);

    }



    public void ALligment_2()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints gc= new GridBagConstraints();
        Alligment();


        gc.weighty=0.1;
        gc.weightx=0.1;
        gc.fill=GridBagConstraints.NONE;


        gc.gridx=1;
        gc.gridy=2;
//        gc.anchor= GridBagConstraints.CENTER;
        gc.insets= new Insets(0,0,0,50);
//            add(burger_label,gc);

        add(Topping_label,gc);

        gc.gridx=0;
        gc.gridy++;
//            gc.anchor=GridBagConstraints.CENTER;
        gc.insets= new Insets(0,20,00,0);
        add(tomoto_label,gc);



        gc.gridx++;

        gc.insets= new Insets(0,0,00,10);
        add(tom_feild,gc);


        gc.gridx=0;
        gc.gridy++;
        gc.insets= new Insets(0,20,00,0);
        add(lettuce_label,gc);

        gc.gridx++;
        gc.insets= new Insets(0,0,00,10);
        add(lec_feild,gc);



        gc.gridx=0;
        gc.gridy++;
        gc.insets= new Insets(0,20,00,0);
        add(Carrot_label,gc);

        gc.gridx++;
        gc.insets= new Insets(0,0,00,10);
        add(carr_feild,gc);



        gc.gridx=0;
        gc.gridy++;
        gc.insets= new Insets(0,20,00,0);
        add(Cheese_label,gc);

        gc.gridx++;
        gc.insets= new Insets(0,0,00,10);
        add(chee_feild,gc);

        gc.gridx=1;
        gc.gridy++;
        gc.weighty=1;
//            gc.anchor=GridBagConstraints.FIRST_LINE_END;
//            gc.insets= new Insets(50,0,00,120);
        add(Topping_subbtn,gc);






    }

}


