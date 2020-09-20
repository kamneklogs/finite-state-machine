package model.mealyMachine;

import model.*;

public class MealyMachine<I, O> extends Machine {

    private MealyState<I, O> initialState;

    private GenericArray<I> inputAlphabet;
    private GenericArray<O> outputtAlphabet;

    public MealyMachine(MealyState<I, O> initialState, String name, GenericArray<I> inputAlphabet,
            GenericArray<O> outputtAlphabet) {
        super(name);
        this.initialState = initialState;
        this.inputAlphabet = inputAlphabet;
        this.outputtAlphabet = outputtAlphabet;
    }

    public MealyState<I, O> getInitialState() {
        return initialState;
    }

    public void setInitialState(MealyState<I, O> initialState) {
        this.initialState = initialState;
    }

    public GenericArray<I> getInputAlphabet() {
        return inputAlphabet;
    }

    public void setInputAlphabet(GenericArray<I> inputAlphabet) {
        this.inputAlphabet = inputAlphabet;
    }

    public GenericArray<O> getOutputtAlphabet() {
        return outputtAlphabet;
    }

    public void setOutputtAlphabet(GenericArray<O> outputtAlphabet) {
        this.outputtAlphabet = outputtAlphabet;
    }

}
