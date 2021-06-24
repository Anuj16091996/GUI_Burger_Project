import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventObject;

public class FormEvent2 extends EventObject {

private ArrayList<Burger> burgers;

    public FormEvent2(Object source) {
        super(source);
    }

    public FormEvent2(Object source, ArrayList<Burger> burgers)
    {
        super(source);
            this.burgers=burgers;
    }

    @Override
    public String toString() {
        String string = "\n\n";

        double total = 0;
        for (Burger b: burgers){
            total += b.priceWithToppings();
        }
        string += "\nReceipt\n";
        string += "```````\n";
        for (int i=0; i < burgers.size(); i++){
            string += String.format("%d. %s %s - %.2f\n",(i+1),burgers.get(i).getName(),burgers.get(i).getContentBurger(),burgers.get(i).getPrice());
            string += "\nExtras:\n";
            string += "```````\n";
            for (int z=0; z < burgers.get(i).getToppings().size(); z++){
                string += (z+1) + ". " + burgers.get(i).getToppings().get(z) + "\n";
            }
        }
        string += "\n--------------------------------\n";
        string += String.format("Amount: %.2f$ + (Tax: %.2f$)\n", total, (total*0.15));
        string += "--------------------------------\n";
        string += String.format("Amount: %.2f$\n", (total*1.15));
        string += "--------------------------------\n";

        return string;
    }
}
