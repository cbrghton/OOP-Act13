package mx.ipn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        Catalog catalog = new Catalog();
        int foodType;
        int money;
        String name;
        Food food;
        Dish[] dishes;
        Dish dish;
        ArrayList<Dish> dishArrayList;

        while(flag) {
            int option;
            System.out.println("""
                    Bienvenido a la Actividad 13
                    Elija una opción:
                    1. Sugiereme un platillo
                    2. Agrega un platillo nuevo
                    3. Agrega un nuevo tipo de comida
                    0. Salir""");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("¿Qué tipo de comida prefiere?");
                    foodType = 0;
                    for (Food f:catalog.getFoodTypes()) {
                        System.out.println("" + (foodType+1) + ": " + f.getName());
                        foodType++;
                    }
                    foodType = scanner.nextInt() - 1;
                    scanner.nextLine();

                    System.out.println("¿Cuánto presupuesto tienes?");
                    money = scanner.nextInt();
                    scanner.nextLine();

                    food = catalog.getFoodTypes()[foodType];

                    if (money < 300) {
                        dishes = food.getLowCostDishes();
                    } else {
                        dishes = food.getHighCostDishes();
                    }

                    Random random = new Random();
                    int dishId = (int) (random.nextDouble() * dishes.length);

                    System.out.println("Le recomendamos: " + dishes[dishId].getName());

                    break;

                case 2:
                    System.out.println("¿A qué tipo de comida le gustaría agregar la nueva comida?");
                    foodType = 0;
                    for (Food f:catalog.getFoodTypes()) {
                        System.out.println("" + (foodType+1) + ": " + f.getName());
                        foodType++;
                    }
                    foodType = scanner.nextInt() - 1;
                    scanner.nextLine();

                    food = catalog.getFoodTypes()[foodType];

                    System.out.println("""
                            ¿De qué categoría es el platillo?
                            1. Precio Alto
                            2. Precio Bajo""");
                    money = scanner.nextInt();
                    scanner.nextLine();

                    if (money == 1) {
                        dishes = food.getHighCostDishes();
                    } else if (money == 2) {
                        dishes = food.getLowCostDishes();
                    } else {
                        System.out.println("Opción Incorrecta");
                        break;
                    }

                    System.out.println("Ingrese el nombre del nuevo platillo");
                    name = scanner.nextLine();

                    dish = new Dish(name);

                    dishArrayList = new ArrayList<Dish>(Arrays.stream(dishes).toList());
                    dishArrayList.add(dish);

                    if (money == 1) {
                        food.setHighCostDishes(dishArrayList.toArray(new Dish[0]));
                    } else {
                        food.setLowCostDishes(dishArrayList.toArray(new Dish[0]));
                    }

                    System.out.println("¡Platillo agregado!");
                    break;

                case 3:
                    System.out.println("Para agregar un nuevo tipo de comida es necesario registrar un platillo caro y uno barato\n" +
                            "Ingrese el nombre del platillo caro");
                    name = scanner.nextLine();
                    Dish highCostDish = new Dish(name);

                    System.out.println("Ingrese el nombre del platillo barato");
                    name = scanner.nextLine();
                    Dish lowCostDish = new Dish(name);

                    System.out.println("Ingrese el nombre del nuevo tipo de comida");
                    name = scanner.nextLine();
                    food = new Food(name, new Dish[] {lowCostDish}, new Dish[] {highCostDish});

                    ArrayList<Food> foodArrayList = new ArrayList<Food>(Arrays.stream(catalog.getFoodTypes()).toList());
                    foodArrayList.add(food);
                    catalog.setFoodTypes(foodArrayList.toArray(new Food[0]));

                    System.out.println("Nuevo tipo de comida registrado");
                    break;

                case 0:
                default:
                    flag = false;
                    break;
            }
        }
    }
}
