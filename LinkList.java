public class LinkList<T> implements ListInterface<T> {

    private Node firstNode;
    private Node lastNode;

    private int numberOfEntries;


    public  LinkList(){
        initializeDataFields();
    }

    public void clear(){
        initializeDataFields();
    }

    private void initializeDataFields(){
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;

    }

    private Node getNodeAt(int givenPosition){
        Node currentNode = firstNode;
        for(int counter = 1; counter < givenPosition; counter++){
            currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }

    @Override
    public void add(T newEntry) {
        Node newNode = new Node (newEntry, null);
        if(isEmpty()){
            firstNode = newNode;
        }else {
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;
        numberOfEntries++;
    }

    public void add(int givenPosition, T newEntry){
        if(givenPosition >= 1 && givenPosition <= numberOfEntries + 1){
            Node newNode = new Node(newEntry,null);
            if(isEmpty()){
                firstNode = newNode;
                lastNode = newNode;
            }
            else if(givenPosition == 1){
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            } else if (givenPosition == numberOfEntries + 1) {
                lastNode.setNextNode(newNode);
                lastNode = newNode;
            } else {
                Node prevNode = getNodeAt(givenPosition -1);
                Node afterNode = prevNode.getNextNode();
                newNode.setNextNode(afterNode);
                prevNode.setNextNode(newNode);
            }
            numberOfEntries++;
        }else {
            throw new IndexOutOfBoundsException("Given position is out of bounds");
        }
    }

    public T remove(int givenPosition){
        T results = null;
        if(givenPosition >= 1 && givenPosition <= numberOfEntries){
            if(givenPosition == 1){
                results = firstNode.getData();
                firstNode = firstNode.getNextNode();
                if(numberOfEntries == 1)
                    lastNode = null;
            }else {
                Node prevNode = getNodeAt(givenPosition - 1);
                Node nodeToRemove = prevNode.getNextNode();
                results = nodeToRemove.getData();
                Node afterNode = nodeToRemove.getNextNode();
                prevNode.setNextNode(afterNode);
                if(givenPosition == numberOfEntries){
                    lastNode = prevNode;
                }
            }
        }
        numberOfEntries--;
        return results;
    }

    public T replace(int givenPosition,T newEntry){
        if(givenPosition >= 1 && givenPosition <= numberOfEntries){
            Node desiredNode = getNodeAt(givenPosition);
            T replaceEntry = desiredNode.getData();
            desiredNode.setData(newEntry);
            return replaceEntry;
        }else {
            throw new IndexOutOfBoundsException("Given position is out of bounds");
        }
    }

    public T getEntry(int givenPosition){
        if(givenPosition >= 0 && givenPosition < numberOfEntries){
            return getNodeAt(givenPosition).getData();
        }
        else{
            throw new IndexOutOfBoundsException("Given position is out of bounds");
        }
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && currentNode != null){
            if (anEntry.equals(currentNode.getData())) {
                found = true;
            }else{
                currentNode = currentNode.getNextNode();
            }
        }
        return found;
    }

    public int getLength(){
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }
    @SuppressWarnings("unchecked")
    public T[] toArray(){
        T[] results = (T[]) new Object[numberOfEntries];
        int index = 0;
        Node currentNode = firstNode;
        while (index < numberOfEntries && currentNode != null){
            results[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        }
        return results;
    }



    private class Node {
        private T data;
        private Node next;

        private Node(T dataPortion){
            this(dataPortion,null);
        }

        private Node(T data, Node next){
            this.data = data;
            this.next = next;
        }

        private T getData(){

            return data;
        }

        private void setData(T dataPortion){
            data = dataPortion;
        }
        private void setNextNode (Node linkPortion){
            next = linkPortion;
        }

        private Node getNextNode(){

            return next;
        }
    }
}
