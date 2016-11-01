package BuilderPattern;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal vegaMeal = mealBuilder.prepareNonVegaMeal();
        System.out.println("Veg Meal");
        vegaMeal.showItems();
        System.out.println("Total Cost: " + vegaMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareVegaMeal();
        System.out.println("Non Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());
    }
}
