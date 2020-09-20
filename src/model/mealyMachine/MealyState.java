package model.mealyMachine;

import model.GenericArray;

public class MealyState<I, O> {
    private String name;
    private GenericArray<MealyTransition<I, O>> myTransitions;
    private int index;

    public MealyState(String name, int alphLength) {
        this.name = name;
        myTransitions = new GenericArray<>(alphLength);
        index = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenericArray<MealyTransition<I, O>> getMyTransitions() {
        return myTransitions;
    }

    public void setMyTransitions(GenericArray<MealyTransition<I, O>> myTransitions) {
        this.myTransitions = myTransitions;
    }

    public void link(MealyState<I, O> destiny, I input, O output) {

        myTransitions.set(index, new MealyTransition<I, O>(input, output, destiny));

        index++;
    }

}