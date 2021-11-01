package mx.ipn;

public class Food {
    private String name;
    private Dish[] lowCostDishes;
    private Dish[] highCostDishes;

    public Food(String name, Dish[] lowCostDishes, Dish[] highCostDishes) {
        this.name = name;
        this.lowCostDishes = lowCostDishes;
        this.highCostDishes = highCostDishes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dish[] getLowCostDishes() {
        return lowCostDishes;
    }

    public void setLowCostDishes(Dish[] lowCostDishes) {
        this.lowCostDishes = lowCostDishes;
    }

    public Dish[] getHighCostDishes() {
        return highCostDishes;
    }

    public void setHighCostDishes(Dish[] highCostDishes) {
        this.highCostDishes = highCostDishes;
    }
}
