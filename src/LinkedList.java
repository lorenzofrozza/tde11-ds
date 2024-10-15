import java.util.spi.AbstractResourceBundleProvider;

public class LinkedList<T> {
    private Node<T> head; //inicio
    private int size;

    // Constructor
    public LinkedList() {
        head = null;
    }

    // int tamanho(): Retorna o número de elementos na lista.
    public void getSize() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            System.out.println("Linked list size: "+size);
        }
    }

    // boolean estaVazia(): Retorna true se a lista estiver vazia, caso contrário, false.
    public boolean isEmpty(){
        if(this.head == null){ //Verifying if the list is empty
            System.out.println("List is empty");
            return true; //As if it were a BREAK to get out of conditions
        }
        System.out.println("List is not empty");
        return false;
    }

    // void adicionarNoFim(T valor): Insere um elemento no final da lista.
    public void insertEnd(T element){
        Node<T> newKnot = new Node<>(element);
        if(this.head == null){
            this.head = newKnot;
        }else{
            Node<T> currentKnot = head;
            while(currentKnot.getNext()!=null){
                currentKnot = currentKnot.getNext();
            }
            currentKnot.setNext(newKnot);
        }
        size++;
    }

    //void adicionarNoInicio(T valor): Insere um elemento no início da lista.
    public void insertBeginning(T element) {
        Node<T> newKnot = new Node<>(element);
        newKnot.setNext(head); //
        head = newKnot;
        size++;
    }

    // void adicionarNaPosicao(int posicao, T valor): Insere um elemento em uma posição específica da lista.
    public void insertPosition(int position, T element) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position");
            return;
        }

        Node<T> newNode = new Node<>(element);

        if (position == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }

        size++;
    }

    //T removerDoInicio(): Remove o primeiro elemento da lista e retorna seu valor.
    public T removeBeginning() {
        if (head == null) {
            return null;
        }

        T removedElement = head.getElement();
        head = head.getNext();
        size--;

        return removedElement;
    }

    //T removerDoFim(): Remove o último elemento da lista e retorna seu valor.
    public T removeEnd() {
        if (head == null) { //If is empty
            return null;
        }

        if (size == 1) { //One element
            T removedElement = head.getElement();
            head = null;
            size--;
            return removedElement;
        }

        Node<T> current = head;
        while (current.getNext().getNext() != null) { // Navega até o penúltimo nó
            current = current.getNext();
        }

        T removedElement = current.getNext().getElement();
        current.setNext(null);
        size--;

        return removedElement;
    }

    //void atualizar(int posicao, T novoValor): Atualiza o valor de um nó em uma posição específica.
    public void update(int position, T newElement){
        Node<T> current = head;
        int index = 0;

        if (position == 0){
            current.setElement(newElement);
        }
        while(current != null){
            current = current.getNext();
            index++;
            if(position == index){
                current.setElement(newElement);
                break;
            }

        }
    }

    // T buscar(int posicao): Retorna o valor do elemento em uma determinada posição.
    public void search(int position){
        Node<T> current = head;
        int index = 0;

        if (position == 0){
            System.out.println(current.getElement());
        }
        while(current != null){
            current = current.getNext();
            index++;
            if(position == index){
                System.out.println(current.getElement());
                break;
            }

        }
    }

    // T removerPorValor(T elemento): Remove o elemento específico e retorna seu valor.
    public void removeByElement(T element){
        if(this.head == null){ //Verifying if the list is empty
            System.out.println("List is empty");
            return; //As if it were a BREAK to get out of conditions
        }
        if(head.getElement().equals(element)){ //It's used to compare objects, any type
            System.out.println("Element found: " + head.getElement());
            this.head = this.head.getNext();
            return;
        }
        Node<T> current = head; // Variable to inteirar the list
        Node<T> previous = null;

        while (current != null && current.getElement() != element) {
            previous = current;
            current = current.getNext();
        }
        if (current == null) {
            System.out.println("Element not found");
            return;
        }
        System.out.println("Element found: " + current.getElement());
        previous.setNext(current.getNext());
        size--;
    }

    //T removerDaPosicao(int posicao): Remove o elemento de uma posição específica e retorna seu valor.
    public T removeByPosition(int position) {
        if (head == null) {
            return null;
        }

        if (position < 0 || position >= size) {
            System.out.println("Invalid position");
            return null;
        }

        Node<T> current = head;
        T removedElement;

        if (position == 0) {
            removedElement = head.getElement();
            head = head.getNext();
        } else {
            Node<T> previous = null;
            for (int i = 0; i < position; i++) {
                previous = current;
                current = current.getNext();
            }
            removedElement = current.getElement();
            previous.setNext(current.getNext());
        }

        size--;
        return removedElement;
    }

    // void limpar(): Remove todos os elementos da lista.
    public void clear() {
        head = null; //
        size = 0;    //
        System.out.println("List cleared");
    }

    // int buscarPosicao(T valor): Retorna a posição de um elemento com o valor especificado, ou -1 se não for encontrado.
    public void searchByElement(T element) {
        if (this.head == null) {
            System.out.println("List is empty");
            return;
        }

        Node<T> current = head;
        int index = 0;
        boolean found = false;

        while (current != null) {
            if (element.equals(current.getElement())) {
                System.out.println("Position: " + index +
                        "\nPosition element: " + current.getElement());
                found = true;
                break; // Saímos do loop se encontramos o elemento
            }
            current = current.getNext();
            index++;
        }

        if (!found) {
            System.out.println("Element not found (-1)");
        }
    }

    // String toString(): Retorna uma representação textual da lista, exibindo os valores dos nós.
    public void display() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.getElement() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

}
