public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();

        // Check if the list is empty
        numbers.isEmpty();
        // Inserts an element at the end of the list
        numbers.insertEnd(5);
        numbers.insertEnd(7);
        numbers.insertEnd(10);
        numbers.display();
        numbers.update(2,99);
        numbers.display();
        // Normal search by position
        numbers.search(2);
        // Searching by element
        numbers.searchByElement(10);
        // Similar to toString
        numbers.display();
        // Check if the list is empty
        numbers.isEmpty();
        // Get size
        numbers.getSize();
        // Removing by element
        numbers.removeByElement(80);
        numbers.removeByElement(5);
        numbers.display();
        // Removing element by position
        numbers.removeByPosition(1);
        // Clean
        numbers.clear();
        numbers.display();
        // Inserts an element at the beginning of the list
        numbers.insertBeginning(55);
        numbers.insertBeginning(66);
        numbers.display();
        // Removing the first element of the list
        numbers.removeBeginning();
        numbers.display();
        // Removing the last element of the list
        numbers.insertBeginning(33);
        numbers.removeEnd();
        numbers.insertBeginning(77);
        numbers.display();
        // Insert an element in a special position
        numbers.insertPosition(1,88);
        numbers.display();
    }
}