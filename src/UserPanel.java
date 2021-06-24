import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserPanel extends JPanel {
    private JLabel burgerLabel;
    private JComboBox burgerBox;
    private JButton burgerSubmit;
    private ArrayList<Burger> burgers;

    private FormListener formListener;

    private JLabel toppingsLabel;
    ArrayList<Topping> toppings;
    private JLabel tomatoLabel;
    private JLabel lettuceLabel;
    private JLabel cheeseLabel;
    private JLabel carrotLabel;
    private JButton toppingsSubmit;
    private JTextField tomatoField;
    private JTextField lettuceField;
    private JTextField cheeseField;
    private JTextField carrotField;
    private  ArrayList<Burger> burgersSelected;

    private JButton tomatoPlus;
    private JButton tomatoMinus;
    private JButton lettucePlus;
    private JButton lettuceMinus;
    private JButton cheesePlus;
    private JButton cheeseMinus;
    private JButton carrotPlus;
    private JButton carrotMinus;

    private ToppingSection toppingSection;
    private BurgerSection burgerSection;

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
        gc.gridx = 0;
        gc.gridy++;
        gc.weighty = 0.1;
        gc.anchor = anchor;
        gc.insets = new Insets(0,0,0,0);
        add(label,gc);
    }

    public UserPanel() {
        setLayout(new GridBagLayout());

        settingSize(360);

        //Initializing Members Variables
        burgerLabel = new JLabel("Select Your Burger");
        burgerBox = new JComboBox();
        burgerSubmit = new JButton("Submit");


        tomatoLabel = new JLabel("Tomato: ");
        tomatoMinus = new JButton("—");
        tomatoField = new JTextField("0");
        tomatoField.setEditable(false);
        tomatoPlus = new JButton("+");
        addingAction(tomatoPlus,tomatoMinus,tomatoField);

        lettuceLabel = new JLabel("Lettuce: ");
        lettuceMinus = new JButton("—");
        lettuceField = new JTextField("0");
        lettuceField.setEditable(false);
        lettucePlus = new JButton("+");
        addingAction(lettucePlus,lettuceMinus,lettuceField);

        cheeseLabel = new JLabel("Cheese: ");
        cheeseMinus = new JButton("—");
        cheeseField = new JTextField("0");
        cheeseField.setEditable(false);
        cheesePlus = new JButton("+");
        addingAction(cheesePlus,cheeseMinus,cheeseField);

        carrotLabel = new JLabel("Carrot: ");
        carrotMinus = new JButton("—");
        carrotField = new JTextField("0");
        carrotField.setEditable(false);
        carrotPlus = new JButton("+");
        addingAction(carrotPlus,carrotMinus,carrotField);

        toppingsSubmit = new JButton("Submit");

        //Calling Action Listener
        burgerSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Burger userSelection= (Burger) burgerBox.getSelectedItem();

                    //Calling Form Event
                    FormEvent fe = new FormEvent(e,userSelection);

                    //Checking That FormListener is not null
                    if(formListener!= null)
                    {
                        burgersSelected.add(userSelection);
                        formListener.Form_Event_Trigger(fe);
                        burgerBox.setEnabled(false);
                        burgerSubmit.setEnabled(false);
                        toppingsLabel = new JLabel("Add "+ userSelection.getMaxToppings() +" toppings -: ");

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
        });

        //Adding Border to Display The Order Panel
        setBorder(createBorder("Order Here"));

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

        burgersSelected = new ArrayList<>();
        //Adding Burger To Combo Box
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        for (Burger b: burgers) {
            comboModel.addElement(b);
        }

        //Setting the model to burger box
        burgerBox.setModel(comboModel);
        burgerBox.setSelectedIndex(-1);
        alignment();
        DocumentListener changesOnField = new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                warn();
            }
            public void removeUpdate(DocumentEvent e) {
                warn();
            }
            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            public void warn() {
                    /*JOptionPane.showMessageDialog(null,
                            "This changed", "Error Message",
                            JOptionPane.ERROR_MESSAGE);*/
                int max = burgersSelected.get(0).getMaxToppings();
                int toppingsSelected = 0;
                if (!(tomatoField.getText().isEmpty()))
                    toppingsSelected += Integer.valueOf(tomatoField.getText());
                if (!(lettuceField.getText().isEmpty()))
                    toppingsSelected += Integer.valueOf(lettuceField.getText());
                if (!(cheeseField.getText().isEmpty()))
                    toppingsSelected += Integer.valueOf(cheeseField.getText());
                if (!(carrotField.getText().isEmpty()))
                    toppingsSelected += Integer.valueOf(carrotField.getText());
                System.out.println(String.format("Max: %d and Selected: %d",max,toppingsSelected));
                if(toppingsSelected == max){
                    if(Integer.valueOf(tomatoField.getText()) == 0){
                        tomatoField.setEnabled(false);
                        tomatoPlus.setEnabled(false);
                        tomatoMinus.setEnabled(false);}
                    if(Integer.valueOf(lettuceField.getText()) == 0){
                        lettuceField.setEnabled(false);
                        lettucePlus.setEnabled(false);
                        lettuceMinus.setEnabled(false);}
                    if(Integer.valueOf(carrotField.getText()) == 0){
                        carrotField.setEnabled(false);
                        carrotPlus.setEnabled(false);
                        carrotMinus.setEnabled(false);}
                    if(Integer.valueOf(cheeseField.getText()) == 0){
                        cheeseField.setEnabled(false);
                        cheesePlus.setEnabled(false);
                        cheeseMinus.setEnabled(false);}
                } else if(toppingsSelected > max) {
                    tomatoField.setText("0");
                    lettuceField.setText("0");
                    carrotField.setText("0");
                    cheeseField.setText("0");
                    JOptionPane.showMessageDialog(null,
                            "You have tried to add more topping than limit allowed", "Error Message",
                            JOptionPane.ERROR_MESSAGE);
                }
                else {
                    carrotField.setEnabled(true);
                    carrotPlus.setEnabled(true);
                    carrotMinus.setEnabled(true);
                    cheeseField.setEnabled(true);
                    cheesePlus.setEnabled(true);
                    cheeseMinus.setEnabled(true);
                    lettuceField.setEnabled(true);
                    lettucePlus.setEnabled(true);
                    lettuceMinus.setEnabled(true);
                    tomatoField.setEnabled(true);
                    tomatoPlus.setEnabled(true);
                    tomatoMinus.setEnabled(true);
                }
            }
        };

        carrotField.getDocument().addDocumentListener(changesOnField);
        lettuceField.getDocument().addDocumentListener(changesOnField);
        cheeseField.getDocument().addDocumentListener(changesOnField);
        tomatoField.getDocument().addDocumentListener(changesOnField);
    }

    public void addingAction(JButton buttonPlus, JButton buttonMinus, JTextField textField){
        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int max = burgersSelected.get(0).getMaxToppings();
                int toppingsSelected = 0;
                if (!(tomatoField.getText().isEmpty()))
                    toppingsSelected += Integer.valueOf(tomatoField.getText());
                if (!(lettuceField.getText().isEmpty()))
                    toppingsSelected += Integer.valueOf(lettuceField.getText());
                if (!(cheeseField.getText().isEmpty()))
                    toppingsSelected += Integer.valueOf(cheeseField.getText());
                if (!(carrotField.getText().isEmpty()))
                    toppingsSelected += Integer.valueOf(carrotField.getText());
                System.out.println(String.format("Max: %d and Selected: %d",max,toppingsSelected));
                if(toppingsSelected == max){
                    if(Integer.valueOf(tomatoField.getText()) == 0){
                        tomatoField.setEnabled(false);
                        tomatoPlus.setEnabled(false);
                        tomatoMinus.setEnabled(false);}
                    if(Integer.valueOf(lettuceField.getText()) == 0){
                        lettuceField.setEnabled(false);
                        lettucePlus.setEnabled(false);
                        lettuceMinus.setEnabled(false);}
                    if(Integer.valueOf(carrotField.getText()) == 0){
                        carrotField.setEnabled(false);
                        carrotPlus.setEnabled(false);
                        carrotMinus.setEnabled(false);}
                    if(Integer.valueOf(cheeseField.getText()) == 0){
                        cheeseField.setEnabled(false);
                        cheesePlus.setEnabled(false);
                        cheeseMinus.setEnabled(false);}
                }
                else {
                    carrotField.setEnabled(true);
                    carrotPlus.setEnabled(true);
                    carrotMinus.setEnabled(true);
                    cheeseField.setEnabled(true);
                    cheesePlus.setEnabled(true);
                    cheeseMinus.setEnabled(true);
                    lettuceField.setEnabled(true);
                    lettucePlus.setEnabled(true);
                    lettuceMinus.setEnabled(true);
                    tomatoField.setEnabled(true);
                    tomatoPlus.setEnabled(true);
                    tomatoMinus.setEnabled(true);
                    textField.setText(String.valueOf(Integer.valueOf(textField.getText()) + 1));
                }
            }
        });
        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Integer.valueOf(textField.getText()) != 0)
                    textField.setText(String.valueOf(Integer.valueOf(textField.getText()) - 1));
            }
        });
    }

    public Border createBorder(String title){
        TitledBorder innerBorder = BorderFactory.createTitledBorder(title);
        innerBorder.setTitleJustification(TitledBorder.CENTER);
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        return BorderFactory.createCompoundBorder(outerBorder, innerBorder);
    }

    public void setFormListener(FormListener formListener) {
        this.formListener = formListener;
    }

    public void addComponent(Component component, double weighty, double weightx, int gridy, int gridx, int gridwidth, int fill){
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5,5,5,5);
        gc.weighty = weighty;
        gc.weightx = weightx;
        gc.gridy = gridy;
        gc.gridx = gridx;
        gc.gridwidth = gridwidth;
        gc.fill = fill;
        add(component,gc);
    }

    public void alignment()
    {
        burgerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        addComponent(burgerLabel,1/12, 1,1,0,4,GridBagConstraints.HORIZONTAL);
        addComponent(burgerBox,1/12, 1,2,0,4,GridBagConstraints.HORIZONTAL);
        addComponent(burgerSubmit,1/12, 1,3,0,4,GridBagConstraints.NONE);
    }

    public void alignment_2()
    {
        alignment();

        toppingsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        addComponent(toppingsLabel,1/12, 1,5,0,4,GridBagConstraints.HORIZONTAL);

        addComponent(tomatoLabel,1/12, 1,6,0,1,GridBagConstraints.LINE_END);
        addComponent(tomatoMinus,1/12, 1,6,1,1,GridBagConstraints.NONE);
        addComponent(tomatoField,1/12, 1,6,2,1,GridBagConstraints.HORIZONTAL);
        addComponent(tomatoPlus,1/12, 1,6,3,1,GridBagConstraints.NONE);

        addComponent(lettuceLabel,1/12, 1,7,0,1,GridBagConstraints.LINE_END);
        addComponent(lettuceMinus,1/12, 1,7,1,1,GridBagConstraints.NONE);
        addComponent(lettuceField,1/12, 1,7,2,1,GridBagConstraints.HORIZONTAL);
        addComponent(lettucePlus,1/12, 1,7,3,1,GridBagConstraints.NONE);

        addComponent(carrotLabel,1/12, 1,8,0,1,GridBagConstraints.LINE_END);
        addComponent(carrotMinus,1/12, 1,8,1,1,GridBagConstraints.NONE);
        addComponent(carrotField,1/12, 1,8,2,1,GridBagConstraints.HORIZONTAL);
        addComponent(carrotPlus,1/12, 1,8,3,1,GridBagConstraints.NONE);

        addComponent(cheeseLabel,1/12, 1,9,0,1,GridBagConstraints.LINE_END);
        addComponent(cheeseMinus,1/12, 1,9,1,1,GridBagConstraints.NONE);
        addComponent(cheeseField,1/12, 1,9,2,1,GridBagConstraints.HORIZONTAL);
        addComponent(cheesePlus,1/12, 1,9,3,1,GridBagConstraints.NONE);

        addComponent(toppingsSubmit,1/12, 1,10,0,4,GridBagConstraints.NONE);

        setBorder(createBorder("Order Here"));
    }
}


