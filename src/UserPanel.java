import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserPanel extends JPanel implements ActionListener {
    private JLabel burgerLabel;
    private JComboBox burgerBox;
    private JButton burgerSubmit;
    ArrayList<Burger> burgers;

    private FormListener formListener;

    private JLabel toppingsLabel;
    ArrayList<Topping> toppings;
    private JLabel tomatoLabel;
    private JLabel lettuceLabel;
    private JLabel cheeseLabel;
    private JLabel carrotLabel;
    private JButton toppingsSubmit;
    private TextField tomatoField;
    private TextField lettuceField;
    private TextField cheeseField;
    private TextField carrotField;

    public void settingSize(int num)
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

    public UserPanel() {

        settingSize(360);

        //Initializing Members Variables
        burgerLabel = new JLabel("Select Your Burger");
        burgerBox = new JComboBox();
        burgerSubmit = new JButton("Submit");

        tomatoLabel= new JLabel("Tomato :- ");
        lettuceLabel= new JLabel("Lettuce :-  ");
        cheeseLabel= new JLabel("Cheese :- ");
        carrotLabel= new JLabel("Carrot :- ");
        toppingsSubmit=new JButton("Submit");

        tomatoField= new TextField(2);
        lettuceField= new TextField(2);
        cheeseField= new TextField(2);
        carrotField= new TextField(2);

        //Calling Action Listener
        burgerSubmit.addActionListener(this);

        //Adding Border to Display The Order Panel
        TitledBorder innerBorder = BorderFactory.createTitledBorder("Order Here");
        innerBorder.setTitleJustification(TitledBorder.CENTER);
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border fullBorder = BorderFactory.createCompoundBorder(outerBorder, innerBorder);
        setBorder(fullBorder);

        //Adding Burger to arraylist
        burgers = new ArrayList<Burger>();
        burgers.add(new Burger("Basic",
                "With White With Chicken", 3.56
                , 4));
        burgers.add(new Burger("Healthy",
                "With Brown Rye With Bacon", 5.67
                , 6));
        burgers.add(new Burger("Deluxe",
                "With White with Sausage", 14.54
                , 2));

        //Adding Topping to arraylist
        toppings= new ArrayList<>();
        toppings.add(new Topping("Tomato", 0.27));
        toppings.add(new Topping("Lettuce",0.72 ));
        toppings.add(new Topping("Cheese",1.13 ));
        toppings.add(new Topping("Carrot",2.75 ));

        //Adding Burger To Combo Box
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        for (Burger b: burgers) {
            comboModel.addElement(b);
        }
        /*comboModel.addElement(burgers.get(0));
        comboModel.addElement(burgers.get(1));
        comboModel.addElement(burgers.get(2));*/

        //Setting the model to burger box
        burgerBox.setModel(comboModel);
        burgerBox.setSelectedIndex(-1);
        alignment();
    }

//        setBorder(BorderFactory.createTitledBorder("Brampton Burgers"));

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Burger userSelection= (Burger) burgerBox.getSelectedItem();

        //Calling Form Event
        FormEvent fe = new FormEvent(e,userSelection);

        //Checking That FormListener is not null

        if(formListener!= null)
        {
            formListener.Form_Event_Trigger(fe);
            burgerBox.setSelectedIndex(-1);
            toppingsLabel = new JLabel("Add "+ userSelection.getMaxToppings() +"Toppings -: ");

            Border bor= BorderFactory.createLineBorder(Color.BLACK);
            setBorder(bor);
            alignment_2();
        }
        }catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null,
                    "Please Select An option",
                    "Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setFormListener(FormListener formListener) {
        this.formListener = formListener;
    }

    public void alignment()
    {
        //Adding Label In the user Panel using Grid Alignment
        setLayout(new GridBagLayout());
        GridBagConstraints gc= new GridBagConstraints();

        gc.weighty=0.1;
        gc.weightx=1;
        gc.fill=GridBagConstraints.NONE;

        gc.gridx=1;
        gc.gridy=0;
//        gc.anchor= GridBagConstraints.CENTER;
        gc.insets= new Insets(0,0,0,0);
        add(burgerLabel,gc);


        //Adding Drop Down Menu
        gc.gridy++;

        gc.weighty=0.1;
//        gc.anchor=GridBagConstraints.HORIZONTAL;
        add(burgerBox,gc);

        //Adding a submit Button
        gc.gridy++;

        gc.weighty=2;
        gc.anchor=GridBagConstraints.FIRST_LINE_END;
        gc.insets= new Insets(0,0,00,120);
        add(burgerSubmit, gc);
    }

    public void alignment_2()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints gc= new GridBagConstraints();
        alignment();


        gc.weighty=0.1;
        gc.weightx=0.1;
        gc.fill=GridBagConstraints.NONE;


        gc.gridx=1;
        gc.gridy=2;
//        gc.anchor= GridBagConstraints.CENTER;
        gc.insets= new Insets(0,0,0,50);
//            add(burgerLabel,gc);

        add(toppingsLabel,gc);

        gc.gridx=0;
        gc.gridy++;
//            gc.anchor=GridBagConstraints.CENTER;
        gc.insets= new Insets(0,20,00,0);
        add(tomatoLabel,gc);



        gc.gridx++;

        gc.insets= new Insets(0,0,00,10);
        add(tomatoField,gc);


        gc.gridx=0;
        gc.gridy++;
        gc.insets= new Insets(0,20,00,0);
        add(lettuceLabel,gc);

        gc.gridx++;
        gc.insets= new Insets(0,0,00,10);
        add(lettuceField,gc);



        gc.gridx=0;
        gc.gridy++;
        gc.insets= new Insets(0,20,00,0);
        add(carrotLabel,gc);

        gc.gridx++;
        gc.insets= new Insets(0,0,00,10);
        add(carrotField,gc);



        gc.gridx=0;
        gc.gridy++;
        gc.insets= new Insets(0,20,00,0);
        add(cheeseLabel,gc);

        gc.gridx++;
        gc.insets= new Insets(0,0,00,10);
        add(cheeseField,gc);

        gc.gridx=1;
        gc.gridy++;
        gc.weighty=1;
//            gc.anchor=GridBagConstraints.FIRST_LINE_END;
//            gc.insets= new Insets(50,0,00,120);
        add(toppingsSubmit,gc);
    }
}


