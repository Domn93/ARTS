package algorithm.play.structures.set;

import algorithm.play.structures.linked.LinkedList;
import algorithm.play.structures.utils.FileOperation;

import java.util.ArrayList;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/3/27 11:36
 */
public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> list;
    public LinkedListSet(){
        this.list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!contains(e)){
            list.addFirst(e);
        }
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile("src/main/java/algorithm/play/structures/data/pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            LinkedListSet<String> set1 = new LinkedListSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();


        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile("src/main/java/algorithm/play/structures/data/a-tale-of-two-cities.txt", words2)) {
            System.out.println("Total words: " + words2.size());

            LinkedListSet<String> set2 = new LinkedListSet<>();
            for (String word : words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.getSize());
        }
    }
}
