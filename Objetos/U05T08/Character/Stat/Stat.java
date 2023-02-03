package Character.Stat;

public abstract class Stat {

    int value;

    public Stat() {
        this.value = 0;
    }

    @Override
    public abstract String toString();

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void increase() {
        this.value++;
    }

    public void decrease() {
        this.value--;
    }
    
}