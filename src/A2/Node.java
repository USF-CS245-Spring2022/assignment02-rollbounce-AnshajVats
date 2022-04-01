package A2;

public class Node {
    private final BounceBalls val;
    private Node next;

    public Node(BounceBalls val) {
        this.val = val;
    }

    /**
     * @return the value which is of type BounceBalls.
     */
    public BounceBalls getVal() {
        return val;
    }

    /**
     * @return returns the next value.
     */
    public Node getNext() {
        return next;
    }

    /**
     * @param next Sets the next.
     */
    public void setNext(Node next) {
        this.next = next;
    }
}
