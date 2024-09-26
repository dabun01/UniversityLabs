public class Main {
    public static void main(String[] args) {
        ListInterface<String> cities = new LinkList<>();

        cities.add("San Antonio");
        cities.add("Dallas");
        cities.add("Houston");
        cities.add(1,"Austin");


        cities.remove(3);
        cities.remove(3);
        cities.add("College Station");

        System.out.println(cities.contains("Houston"));

        while(!cities.isEmpty()){
            System.out.println(cities.remove(1));
        }
    }
}
