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
        size=0;
    }
    public LinkedListDeque(T i){
        sentinel=new myNode(null,null);
        sentinel.next=new myNode(i,null);
        size=1;
    }
//    public LinkedListDeque(LinkedListDeque other)

    public void addFirst(T item){
        sentinel.next=new myNode(item,sentinel.next);
        size+=1;
    }
    public void addLast(T item){
        myNode p=sentinel;
        while (p.next!=null){
            p=p.next;
        }
        p.next=new myNode(item,null);
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
        while (p.next!=null){
            p=p.next;
            System.out.println(p.item);
        }
    }
//    public T removeFirst(){;}
//    public T removeLast(){;}
//    public T get(int index){;}
//    public T getRecursive(int index){;}
}
