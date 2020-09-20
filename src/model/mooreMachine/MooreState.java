package model.mooreMachine;

public class MooreState<O, I> {

    private String name;
    private O output;
    private MooreTransition<I> myTransition;

    public MooreState(String name, O output, MooreTransition<I> myTransition) {
        this.name = name;
        this.output = output;
        this.myTransition = myTransition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public O getOutput() {
        return output;
    }

    public void setOutput(O output) {
        this.output = output;
    }

    public MooreTransition<I> getMyTransition() {
        return myTransition;
    }

    public void setMyTransition(MooreTransition<I> myTransition) {
        this.myTransition = myTransition;
    }

}
