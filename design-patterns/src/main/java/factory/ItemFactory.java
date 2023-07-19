package factory;

public class ItemFactory {

    public Item getItemImpl(String name) {

        if (name.equalsIgnoreCase("FoodItem")) {
            System.out.println("FoodIteam");
            System.out.println("FoodIteam");
            System.out.println("FoodIteam");
            System.out.println("FoodIteam");
        }
        return new FastfoodItem();
    }
}
