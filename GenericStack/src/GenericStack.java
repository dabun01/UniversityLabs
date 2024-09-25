import java.util.ArrayList;

public class GenericStack<E> {
    private ArrayList<E> list;

    public GenericStack(){
        list = new ArrayList<>();
    }

    public int getSize(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public String toString(){
        return "stack: " + list;
    }

    public void push(E o){
        list.add(o);
    }

    public E peek(){
        return list.get(getSize() - 1);
    }

    public E pop(){
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;

    }
}
