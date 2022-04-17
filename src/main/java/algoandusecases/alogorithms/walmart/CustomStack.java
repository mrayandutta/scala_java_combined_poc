package algoandusecases.alogorithms.walmart;

import java.util.Stack;

public class CustomStack {
    private Stack innerStack = new Stack<Item>() ;
    public void push(Integer entry) {
        if(this.innerStack.isEmpty())
        {
            this.innerStack.push(new Item(entry,entry));
        }
        else
        {
            Item existingItem = (Item) this.innerStack.peek();
            Item newItem = new Item(entry,entry);
            if(entry > existingItem.getMin())
            {
                newItem.setMin(existingItem.getMin());
            }
            innerStack.push(newItem);
        }


    }
    public int pop() {
        Item item =(Item) this.innerStack.pop();
        return item.getEntry();

    }
    public int getTop() {
        Item item =(Item) this.innerStack.peek();
        return item.getEntry();
    }
    public int getMin() {
        Item item =(Item) this.innerStack.peek();
        return item.getMin();
    }
    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        stack.push(100);
        stack.push(2);
        stack.push(20);
        stack.push(25);
        System.out.println("Min: "+stack.getMin());
        System.out.println("Top: "+stack.getTop());
    }

}
