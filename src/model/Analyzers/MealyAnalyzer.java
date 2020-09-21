package model.Analyzers;

import model.mealyMachine.MealyMachine;

public class MealyAnalyzer implements Analyzer {

    private MealyMachine<String, String> myMealyMachine;

    @Override
    public MealyMachine<String, String> getMinimalEquivalentAndConexAutomaton() {


        

        return null;
    }

    public MealyAnalyzer(MealyMachine<String, String> myMealyMachine) {
        this.myMealyMachine = myMealyMachine;
    }

}
