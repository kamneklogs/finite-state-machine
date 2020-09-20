package model.mealyMachine;

import model.*;

public class MealyMachine<I, O> {

    private MealyState<I, O> initialState;

    private String name;

    private GenericArray<I> inputAlphabet;
    private GenericArray<O> outputtAlphabet;

    public MealyMachine(MealyState<I, O> initialState, String name, GenericArray<I> inputAlphabet,
            GenericArray<O> outputtAlphabet) {
        this.initialState = initialState;
        this.name = name;
        this.inputAlphabet = inputAlphabet;
        this.outputtAlphabet = outputtAlphabet;
    }

    /* public void link() {
       for (int i = 0; i < inputAlphabet.length; i++) {
            
       }
    } */

}
