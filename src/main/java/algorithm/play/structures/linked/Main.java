package algorithm.play.structures.linked;

public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0 ; i < 5 ; i ++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
            linkedList.addLast(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);
        System.out.println(linkedList.get(2));
        linkedList.set(2,888);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);
    }
}
