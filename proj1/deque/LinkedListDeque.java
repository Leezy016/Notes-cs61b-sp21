package deque;


public class LinkedListDeque<T> {
    public class myNode{
        public myNode prev;
        public myNode next;
        public T item;

        public myNode(T i, myNode n){
            item=i;
            next=n;
        }
    }
    private myNode sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel=new myNode(null,null);
        sentinel.prev=sentinel;
        size=0;
    }
    public LinkedListDeque(T i){
        sentinel=new myNode(null,null);
        sentinel.next=new myNode(i,sentinel);
        sentinel.next.prev=sentinel;
        sentinel.prev=sentinel.next;
        size=1;
    }
    public LinkedListDeque(LinkedListDeque other){
        sentinel=new myNode(null,null);
        sentinel.prev=sentinel;
        size=0;
        if(other.size!=0){
            for(int i=0;i<other.size;i++){
                addLast((T) other.get(i));
            }
        }
    }

    public void addFirst(T item){
        if(sentinel.prev==sentinel){
            sentinel.next=new myNode(item,sentinel);

            sentinel.prev=sentinel.next;
        }else {
            sentinel.next = new myNode(item, sentinel.next);
        }
        sentinel.next.prev=sentinel;
        size += 1;
    }
    public void addLast(T item){
        myNode p=sentinel.prev;
        p.next=new myNode(item,sentinel);
        p.next.prev=p;
        sentinel.prev=p.next;
        size+=1;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        myNode p=sentinel;
        while (p.next!=sentinel){
            p=p.next;
            System.out.println(p.item);
        }
    }

    public T removeFirst(){
        T removed=null;
        if(size!=0){
            removed=sentinel.next.item;
            myNode p=sentinel.next.next;
            p.prev=sentinel;
            sentinel.next=p;
            size--;
        }
        return removed;
    }
    public T removeLast(){
        T removed=null;
        if(size!=0){
            removed=sentinel.prev.item;
            myNode p=sentinel.prev.prev;
            p.next=sentinel;
            sentinel.prev=p;
            size--;
        }
        return removed;
    }

    public T get(int index){
        if(index>=0&&index<size)
        {
            myNode p=sentinel.next;
            for(int i=0;i<size;i++){
                if(i==index){
                    return p.item;
                }else{
                    p=p.next;
                }
            }
        }
        return null;
    }
//    public T getRecursive(int index){;}
}
