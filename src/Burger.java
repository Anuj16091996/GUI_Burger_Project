import java.util.ArrayList;

public class Burger {
    private int id;
    private static int ids=0;
    private String typeOfBurger;
    private String contentBurger;
    private Double priceOfBurger;
    private Integer maxToppings;
    private ArrayList<Topping> toppings = new ArrayList<>();

    public int getId() {
        return id;
    }

    public Burger(String typeOfBurger,String contentBurger, double priceOfBurger, int maxToppings)
    {
        this.id=ids++;
        this.typeOfBurger = typeOfBurger;
        this.contentBurger=contentBurger;
        this.priceOfBurger = priceOfBurger;
        this.maxToppings = maxToppings;
    }

    public String getContentBurger() {
        return contentBurger;
    }

    public String getTypeOfBurger() {
        return typeOfBurger;
    }

    public Double getPriceOfBurger() {
        return priceOfBurger;
    }

    public Integer getMaxToppings() {
        return maxToppings;
    }

    @Override
    public String toString() {
        return String.format(" %s -%s : $%.2f ",this.getTypeOfBurger(),
             this.getContentBurger(),   this.getPriceOfBurger());
    }

    public void setToppings(Topping top)
    {
        this.toppings.add(top);
    }

    public ArrayList<Topping>getToppings()
    {
        return this.toppings;
    }
}


