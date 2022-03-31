package A2;

public class LinkList {
    private Node head;
    private int size;

    public int getSize() {
        return size;
    }

    public LinkList() {
        head = null;
    }

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



    public void setSize(int size) {
        this.size = size;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return head;
    }

}
