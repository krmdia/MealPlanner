import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.RejectedExecutionException;

public class Meals {

    private List<String> meals;
    private List<String> mealPlan;


    public Meals(){
        this.meals = new ArrayList<>();
        this.mealPlan = new ArrayList<>();
    }

    public Meals(ArrayList<String> meals){
        this.meals = meals;
        this.mealPlan = new ArrayList<>();
    }

    public void addMeal(String meal){
        this.meals.add(meal);
    }

    public void addMeals(List<String> additionalMeals){
        this.meals.addAll(additionalMeals);
    }

    public List<String> getMealPlanList(){
        return this.mealPlan;
    }

    public List<String> getMeals(){
        return this.meals;
    }

    public void createMealPlan(){
        if (this.meals.size()<7){
            throw new RejectedExecutionException("Add more meals before creating a meal plan!");
        }
        List<String> tempMeals = new ArrayList<>(this.meals);

        this.mealPlan.clear();

        Random rand = new Random();

        for (int i = 0; i < 7; i++) {
            int randomIndex = rand.nextInt(tempMeals.size());
            mealPlan.add(tempMeals.get(randomIndex));
            tempMeals.remove(randomIndex);
        }

    }

    public void displayMealPlan(){
        String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        for (int i = 0; i < 7; i++) {
            System.out.println(weekdays[i] + this.mealPlan.get(i));
        }
    }


    public static void main(String[] args) {


    }



}
