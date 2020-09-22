package model.Analyzers;

import java.util.ArrayList;

import model.mealyMachine.MealyMachine;
import model.mealyMachine.MealyState;

public class MealyAnalyzer {

    private MealyMachine<String, String> myMealyMachine;

    private ArrayList<MealyState<String, String>> mealyStatesSet;

    public MealyAnalyzer(MealyMachine<String, String> myMealyMachine,
            ArrayList<MealyState<String, String>> mealyStatesSet) {
        this.myMealyMachine = myMealyMachine;
        this.mealyStatesSet = mealyStatesSet;
    }


    

    public MealyMachine<String, String> getMyMealyMachine() {
        return myMealyMachine;
    }

    public void setMyMealyMachine(MealyMachine<String, String> myMealyMachine) {
        this.myMealyMachine = myMealyMachine;
    }

    public ArrayList<MealyState<String, String>> getMealyStatesSet() {
        return mealyStatesSet;
    }

    public void setMealyStatesSet(ArrayList<MealyState<String, String>> mealyStatesSet) {
        this.mealyStatesSet = mealyStatesSet;
    }
}