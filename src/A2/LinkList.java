package A2;

public class LinkList {
    private Node head;
    private int size;

    /**
     *
     * @return the size of the linkList
     */
    public int getSize() {
        return size;
    }

    public LinkList() {
        head = null;
    }

    /**
     *
     * @param val The ball to add
     *            Adds the ball at the end of the list.
     */
    public void tailInsert(BounceBalls val) {
        Node temp = new Node(val);
        if (head == null) {
            head = temp;
            size++;
            return;
        }
        Node curr = head;
        while (curr.getNext() != null) {
            curr = curr.getNext();
        }
        curr.setNext(temp);
        size++;

    }

    /**
     *
     * @return the head of the link list
     */
    public Node getHead() {
        return head;
    }

}
