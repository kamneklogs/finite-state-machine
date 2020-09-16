package model;

public class Machine <I,O>{
    private String name;

    private I[] inputAlphabet;
    private O[] outputAlphabet;

    public Machine(String name, I[] inputAlphabet, O[] outputAlphabet) {
        this.name = name;
        this.inputAlphabet = inputAlphabet;
        this.outputAlphabet = outputAlphabet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public I[] getInputAlphabet() {
        return inputAlphabet;
    }

    public void setInputAlphabet(I[] inputAlphabet) {
        this.inputAlphabet = inputAlphabet;
    }

    public O[] getOutputAlphabet() {
        return outputAlphabet;
    }

    public void setOutputAlphabet(O[] outputAlphabet) {
        this.outputAlphabet = outputAlphabet;
    }
    

}
