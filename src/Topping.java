public class Topping {
    private int  id;
    private static int ids=1;
    private String Topping_Name;
    private double Topping_price;


    public Topping(String topping_Name, double topping_price)
    {
        this.id=ids++;
        this.Topping_Name = topping_Name;
        this.Topping_price = topping_price;
    }



    public String getTopping_Name() {
        return Topping_Name;
    }

    public double getTopping_price() {
        return Topping_price;
    }


    @Override
    public String toString()
    {
        return String.format(" %s : $%.2f ", this.getTopping_Name(), this.getTopping_price());

    }
}
