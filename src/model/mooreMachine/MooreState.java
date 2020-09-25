package model.mooreMachine;

public class MooreState {

    private String name;
    private String output;
    private MooreTransition myTransition;

    public MooreState(String name, String output, MooreTransition myTransition) {
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

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public MooreTransition getMyTransition() {
        return myTransition;
    }

    public void setMyTransition(MooreTransition myTransition) {
        this.myTransition = myTransition;
    }

}
