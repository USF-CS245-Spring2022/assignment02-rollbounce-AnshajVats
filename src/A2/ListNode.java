package A2;

import java.util.Objects;

public class ListNode {
    private final LinkList list = new LinkList();
    /**
     * Appends the specified element to the end of this list (optional
     * operation).
     *
     * <p>Lists that support this operation may place limitations on what
     * elements may be added to this list.  In particular, some
     * lists will refuse to add null elements, and others will impose
     * restrictions on the type of elements that may be added.  List
     * classes should clearly specify in their documentation any restrictions
     * on what elements may be added.
     *
     * @param item element to be appended to this list
     * @return {@code true}
     * @throws ClassCastException            if the class of the specified element
     *                                       prevents it from being added to this list
     * @throws NullPointerException          if the specified element is null and this
     *                                       list does not permit null elements
     * @throws IllegalArgumentException      if some property of this element
     *                                       prevents it from being added to this list
     */
    public boolean add(BounceBalls item) {

        if (item == null) {
            throw new NullPointerException();
        }
        if(item.equals("")) {
            throw new IllegalArgumentException();
        }
        list.tailInsert(item);
        return true;
    }


    /**
     * Returns the element at the specified position in this list.
     *
     * @param position index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   ({@code index < 0 || index >= size()})
     */
    public BounceBalls get(int position) {
        int count = 0;
        Node curr = list.getHead();
        if (position < 0 || position > list.getSize()) {
            throw new java.lang.IndexOutOfBoundsException("Try again with any integer between 0 and" + list.getSize());
        }
        while(count != position) {
            curr = curr.getNext();
            count++;
        }

        return curr.getVal();

    }

    /**
     * Shows ListNode as a String, with each object in parentheses separated by
     * A ListNode of {1, 2, 3} should return the String "(1) -> (2) -> (3)".
     * @return String representation of the ListNode
     */
    @Override
    public String toString() {
        //TODO implement this method
        StringBuilder sb = new StringBuilder();
        Node curr = list.getHead();
        sb.append("\"");
        while (curr != null) {
            sb.append("(");
            sb.append(curr.getVal());
            sb.append(")");
            sb.append("->");
            curr = curr.getNext();
        }

        sb.append("\"");
        return sb.toString();
    }

    public int getSize(){
       return list.getSize();
    }


}