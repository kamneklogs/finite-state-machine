package model.mooreMachine;

public class MooreTransition<T> {

    private T tag;
    private MooreState destiny;

    public MooreTransition(T tag, MooreState destiny) {
        this.tag = tag;
        this.destiny = destiny;
    }

    public T getTag() {
        return tag;
    }

    public MooreState getDestiny() {
        return destiny;
    }

    public void setTag(T tag) {
        this.tag = tag;
    }

    public void setDestiny(MooreState destiny) {
        this.destiny = destiny;
    }

}