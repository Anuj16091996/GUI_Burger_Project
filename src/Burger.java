import java.util.ArrayList;

public class Burger {
    private int id;
    private static int ids=1;
    private String Type_of_Burger;
    private String Content_BUrger;
    private Double price_of_burger;
    private Integer max_topping;
    private ArrayList<Topping> toppings = new ArrayList<>();

    public int getId() {
        return id;
    }

    public Burger(String type_of_Burger,String Content_BUrger, double price_of_burger, int max_topping)
    {
        this.id=ids++;
        this.Type_of_Burger = type_of_Burger;
        this.Content_BUrger=Content_BUrger;
        this.price_of_burger = price_of_burger;
        this.max_topping = max_topping;
    }

    public String getContent_BUrger() {
        return Content_BUrger;
    }

    public String getType_of_Burger() {
        return Type_of_Burger;
    }

    public Double getPrice_of_burger() {
        return price_of_burger;
    }

    public Integer getMax_topping() {
        return max_topping;
    }

    @Override
    public String toString() {
        return String.format(" %s -%s : $%.2f ",this.getType_of_Burger(),
             this.getContent_BUrger(),   this.getPrice_of_burger());
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


