package HW_03_1;

import org.jetbrains.annotations.NotNull;

public class ObjectQueue
{
    private ObjectBox head = null;
    private ObjectBox tail = null;
    private int size = 0;
    private final int size_final;

    public ObjectQueue(int size_final) throws StackException {
        if (size_final > 1) {
            this.size_final = size_final;
        }
        else {
            throw new StackException("Trying to create a stack smaller than 2.");
        }

    }
    public ObjectQueue() {
        this.size_final = 16;
    }

    public void push(Object obj) {
        ObjectBox ob = new ObjectBox();
        ob.setObject(obj);
        if (head == null) {
            head = ob;
        } else {
            if (size == size_final)
            {
                pull();
            }
            tail.setNext(ob);
            ob.setPrev(tail);
        }
        tail = ob;
        size++;
    }

    public Object pullback(){
        if(size == 0){
            return null;
        }
        Object obj = tail.getObject();
        tail = tail.getPrev();
        if (tail == null){
            head = null;
        }
        size--;
        return obj;
    }

    private Object pull() {
        if (size == 0) {
            return null;
        }
        Object obj = head.getObject();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        return obj;
    }

    public int size() {
        return size;
    }
    @NotNull
    public Integer testNotNull() throws IllegalStateException {
        Integer integer = new Integer(25);
        integer = null;
        return integer;
    }
    private class ObjectBox
    {
        private Object object;
        private ObjectBox next;
        private ObjectBox prev;

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }

        public ObjectBox getNext() {
            return next;
        }

        public void setNext(ObjectBox next) {
            this.next = next;
        }

        public ObjectBox getPrev() {
            return prev;
        }

        public void setPrev(ObjectBox prev) {
            this.prev = prev;
        }
    }
}
