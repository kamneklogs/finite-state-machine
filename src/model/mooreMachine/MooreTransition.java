package model.mooreMachine;

public class MooreTransition {

    private String input;
    private MooreState destiny;

    public MooreTransition(String input, MooreState destiny) {
        this.input = input;
        this.destiny = destiny;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public MooreState getDestiny() {
        return destiny;
    }

    public void setDestiny(MooreState destiny) {
        this.destiny = destiny;
    }


}