package model.mealyMachine;

public class MealyTransition<I, O> {
    private I input;
    private O output;
    private MealyState<I, O> destiny;

    public MealyTransition(I input, O output, MealyState<I, O> destiny) {
        this.input = input;
        this.output = output;
        this.destiny = destiny;
    }

    public I getInput() {
        return input;
    }

    public void setInput(I input) {
        this.input = input;
    }

    public O getOutput() {
        return output;
    }

    public void setOutput(O output) {
        this.output = output;
    }

    public MealyState<I, O> getDestiny() {
        return destiny;
    }

    public void setDestiny(MealyState<I, O> destiny) {
        this.destiny = destiny;
    }

}
