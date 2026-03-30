class MyLinkedList {
        class Node {
        int val;
        Node prev, next;
        Node(int val) {
             this.val = val; 
             }
    }

    Node head, tail;
    int size;

    public MyLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        size = 0;
        
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) return -1;

        Node curr = head.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    private void addBetween(int val, Node prev, Node next) {
        Node node = new Node(val);
        node.prev = prev;
        node.next = next;
        prev.next = node;
        next.prev = node;
        size++;
    }
        
    
    public void addAtHead(int val) {
         addBetween(val, head, head.next);
        
    }
    
    public void addAtTail(int val) {
        addBetween(val, tail.prev, tail);
    }
    
    public void addAtIndex(int index, int val) {
         if (index > size) return;
        if (index < 0) index = 0;

        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        addBetween(val, curr, curr.next);
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        Node curr = head.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */