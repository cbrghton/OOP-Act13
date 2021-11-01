package mx.ipn;

import java.util.ArrayList;

public class Catalog {
    private Food[] foodTypes;

    public Catalog() {
        String[] italianLowCost = new String[] {"Spaguetti", "Ravioles", "Milanesa Capresse", "Gnokis", "Fetuccini"};
        String[] italianHighCost = new String[] {"Vieiras Napolitanas", "Tiramisu", "Lasagna Trattoria"};

        String[] mexicanLowCost = new String[] {"Pozole", "Tamales", "Tacos", "Chilaquiles", "Quesadillas"};
        String[] mexicanHighCost = new String[] {"Escamoles en mole poblano", "Chiles en Nogada", "Pechuga de Pollo en salsa de Huitlacoche"};

        String[] chineseLowCost = new String[] {"Chop Sui", "Rammen", "Wok de Pollo", "Arrow Frito", "Pollo Agridulce"};
        String[] chineseHighCost = new String[] {"Pato Pekines", "Chow Mein", "Dumplings de Esturion"};

        String[] fastfoodLowCost = new String[] {"Pizza", "Hamburguesa", "Hot Dogs", "Banderillas", "Burritos"};
        String[] fastfoodHighCost = new String[] {"Costillas a la BBQ", "Sushi", "Hamburguesa Gourmet"};

        ArrayList<Dish> italianLowCostDishes = this.dishesGenerator(italianLowCost);
        ArrayList<Dish> italianHighCostDishes = this.dishesGenerator(italianHighCost);

        ArrayList<Dish> mexicanLowCostDishes = this.dishesGenerator(mexicanLowCost);
        ArrayList<Dish> mexicanHighCostDishes = this.dishesGenerator(mexicanHighCost);

        ArrayList<Dish> chineseLowCostDishes = this.dishesGenerator(chineseLowCost);
        ArrayList<Dish> chineseHighCostDishes = this.dishesGenerator(chineseHighCost);

        ArrayList<Dish> fastfoodLowCostDishes = this.dishesGenerator(fastfoodLowCost);
        ArrayList<Dish> fastfoodHighCostDishes = this.dishesGenerator(fastfoodHighCost);

        Food italianFood = new Food("Italiana", italianLowCostDishes.toArray(new Dish[0]), italianHighCostDishes.toArray(new Dish[0]));
        Food mexicanFood = new Food("Mexicana", mexicanLowCostDishes.toArray(new Dish[0]), mexicanHighCostDishes.toArray(new Dish[0]));
        Food chineseFood = new Food("China", chineseLowCostDishes.toArray(new Dish[0]), chineseHighCostDishes.toArray(new Dish[0]));
        Food fastFood = new Food("Fast Food", fastfoodLowCostDishes.toArray(new Dish[0]), fastfoodHighCostDishes.toArray(new Dish[0]));

        this.foodTypes = new Food[] {italianFood, mexicanFood, chineseFood, fastFood};
    }

    public Food[] getFoodTypes() {
        return foodTypes;
    }

    public void setFoodTypes(Food[] foodTypes) {
        this.foodTypes = foodTypes;
    }

    private ArrayList<Dish> dishesGenerator(String[] names) {
        ArrayList<Dish> dishes = new ArrayList<>();
        for (String s:names) {
            Dish dish = new Dish(s);
            dishes.add(dish);
        }

        return dishes;
    }
}
