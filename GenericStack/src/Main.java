public class Main {
    public static void main(String[] args) {
        GenericStack<Integer> numbers = new GenericStack<>();

        numbers.push(5);
        numbers.push(10);
        numbers.push(15);


         GenericStack<Number> numbers2 = new GenericStack<>();

        numbers2.push(20);
        numbers2.push(25);
        numbers2.push(30);

        add(numbers,numbers2);

        while (!numbers2.isEmpty()){
            System.out.println(numbers2.pop());
        }

    }

    public static <T> void add(GenericStack<T> stack1, GenericStack<? super T> stack2){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }
}
