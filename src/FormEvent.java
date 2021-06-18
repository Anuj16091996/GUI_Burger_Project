import java.util.EventObject;

public class FormEvent extends EventObject {

private Burger bur;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source,Burger bur)
    {
        super(source);
            this.bur=bur;
    }

    @Override
    public String toString() {
        return String.format(" %s %s, :- \n Cost-: $%.2f \n Maximum Topping: %d",bur.getType_of_Burger(),
                bur.getContent_BUrger(),bur.getPrice_of_burger(), bur.getMax_topping());
    }

    public Burger getBur() {
        return bur;


    }
}
