package algoandusecases.alogorithms.walmart;

public class Item {
    private int entry;
    private int min;

    public Item(int entry, int min) {
        this.entry = entry;
        this.min = min;
    }

    public int getEntry() {
        return entry;
    }

    public void setEntry(int entry) {
        this.entry = entry;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}