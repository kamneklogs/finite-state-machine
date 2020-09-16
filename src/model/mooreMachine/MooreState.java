package model.mooreMachine;

import model.Machine;

public class MooreState<O, I> extends Machine{

    private String name;
    private O output;
    private MooreTransition<I> myTransition;

    public MooreState(String name, Object[] inputAlphabet, Object[] outputAlphabet, String name2, O output,
            MooreTransition<I> myTransition) {
        super(name, inputAlphabet, outputAlphabet);
        name = name2;
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
