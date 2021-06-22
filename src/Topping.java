public class Topping {
    private int  id;
    private static int ids=0;
    private String name;
    private double price;

    public Topping(String name, double price)
    {
        this.id=ids++;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString()
    {
        return String.format(" %s : $%.2f ", this.getName(), this.getPrice());
    }
}
