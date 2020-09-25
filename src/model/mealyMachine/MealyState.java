package model.mealyMachine;

import java.util.ArrayList;

import model.GenericArray;

public class MealyState<I, O> {
    private String name;
    private GenericArray<MealyTransition<I, O>> myTransitions;
    private int index;
    private boolean isAccessible;
    private String eA;
    private String myO;

    private ArrayList<String> myOutputs;

    public MealyState(String name, int alphLength) {
        this.name = name;
        myTransitions = new GenericArray<>(alphLength);
        index = 0;
        isAccessible = false;
        eA = "";
        myOutputs = new ArrayList<String>();
        myO = "";
    }

    public boolean isAccessible() {
        return isAccessible;
    }

    public String setAccessible() {

        isAccessible = true;

        eA += name + ", ";

        for (int i = 0; i < myTransitions.length; i++) {

            if (!myTransitions.get(i).getDestiny().isAccessible()) {
                eA += myTransitions.get(i).getDestiny().setAccessible();

            }

        }
        outputExtracts();
        outputExtractsArray();
        return eA;

    }

    public String outputExtracts() {

        for (int i = 0; i < myTransitions.length; i++) {
            myO += (String) myTransitions.get(i).getOutput();
        }
        return myO;
    }

    public String[] myOutputsArray;

    public String[] getMyOutputsArray() {
        return myOutputsArray;
    }

    private void outputExtractsArray() {
        myOutputsArray = new String[myTransitions.length];
        for (int i = 0; i < myTransitions.length; i++) {
            myOutputsArray[i] = (String) myTransitions.get(i).getOutput();
        }
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