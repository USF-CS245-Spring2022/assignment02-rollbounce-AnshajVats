package A2;

public class Node {
    private BounceBalls val;
    private Node next;

    public Node(BounceBalls val) {
        this.val = val;
    }

    public BounceBalls getVal() {
        return val;
    }

    public void setVal(BounceBalls val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
