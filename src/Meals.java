import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.RejectedExecutionException;

public class Meals {

    private List<String> meals;
    private List<String> mealPlan;
    private String[] weekdays = {"Monday ", "Tuesday ", "Wednesday ", "Thursday ", "Friday ", "Saturday ", "Sunday "};
    private JButton getMealsButton;
    private JButton resetButton;
    private JButton addMealButton;
    private JButton getMealPlanButton;
    private JTextArea Text;
    private javax.swing.JPanel JPanel;
    private JScrollPane ScrollPane;
    private JButton ClearTextButton;
    private JButton RemoveMealButton;


    public Meals(){
        this.meals = new ArrayList<>();
        this.mealPlan = new ArrayList<>();
        getMealPlanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (meals.size()<6){
                    Text.append("Add more meals before creating a meal plan!\n");
                } else {

                    createMealPlan();

                    for (int i = 0; i < 7; i++) {
                        Text.append(weekdays[i] + mealPlan.get(i) + "\n");
                    }

                }

            }
        });
        addMealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                meals.addAll(Arrays.asList(Text.getText().split("\\r?\\n")));
            }
        });
        getMealsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (String meal:
                        meals) {
                    if (meal.equals(meals.get(meals.size()-1))){
                        Text.append(meal);
                    } else Text.append(meal + "\n");
                }
            }
        });
        ClearTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Text.setText(null);
            }
        });
        RemoveMealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                meals.removeAll(Arrays.asList(Text.getText().split("\\r?\\n")));
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                meals.clear();
                mealPlan.clear();
            }
        });
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
        if (this.meals.size()<6){
            throw new RejectedExecutionException("Add more meals before creating a meal plan!\n");
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

        for (int i = 0; i < 7; i++) {
            System.out.println(weekdays[i] + this.mealPlan.get(i));
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Meals");
        frame.setContentPane(new Meals().JPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
