package factory;

public class ItemFactory {

    public Item getItemImpl(String name) {

        if (name.equalsIgnoreCase("FoodItem")) {
            return new FastfoodItem();
        }
        return new FoodItem();
    }
}
