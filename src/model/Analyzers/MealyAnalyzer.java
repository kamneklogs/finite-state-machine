package model.Analyzers;

import model.GenericArray;
import model.mealyMachine.MealyMachine;
import model.mealyMachine.MealyState;

public class MealyAnalyzer implements Analyzer {

    private MealyMachine<String, String> myMealyMachine;

    private GenericArray<MealyState<String, String>> mealyStatesSet;

    public MealyAnalyzer(MealyMachine<String, String> myMealyMachine,
            GenericArray<MealyState<String, String>> mealyStatesSet) {
        this.myMealyMachine = myMealyMachine;
        this.mealyStatesSet = mealyStatesSet;
    }

    @Override
    public void clearInaccessibleStates() {

        String[][] adjacencyMatrix = new String[mealyStatesSet.length][myMealyMachine.getInputAlphabet().length];

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {

                adjacencyMatrix[i][j] = (String) mealyStatesSet.get(i).getMyTransitions().get(j).getOutput();

            }
        }

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public MealyMachine<String, String> getMyMealyMachine() {
        return myMealyMachine;
    }

    public void setMyMealyMachine(MealyMachine<String, String> myMealyMachine) {
        this.myMealyMachine = myMealyMachine;
    }
}
