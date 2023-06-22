public class LinkedList {
    // Первый элемент списка
    private Node head;
    // Размер списка
    private int size;

    // Добавление элемента в конец списка
    public void add(int value) {

        Node newNode = new Node(value);
        // Проверка на пустоту, если пусто, то создание нового списка
        if (head == null) {
            head = newNode;
            size = 1;
            return;
        }
        
        // Присваивание текущему элементу первый в списке
        Node currentNode = head;

        // Поиск конца списка
        while (currentNode.next != null)
            currentNode = currentNode.next;
        // Добавление элемента
        currentNode.next = newNode;
        size++;
    }

    // Удаление элемента
    public boolean remove(int value) {

        if (remove(value, head) == null)
            return true;
        else
            return false;
    }

    // Удаление элемента
    private Node remove(int value, Node startNode) {
        // Проверка на пустоту
        if (head == null)
            return null;

        Node currentNode = head;
        // Удаление первого элемента
        if (head.value == value) {
            head = head.next;
            size--;
            return head;
        }

        while (currentNode.next != null) {
            if (currentNode.next.value == value) {
                currentNode.next = currentNode.next.next;
                size--;
                return currentNode.next;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    // Удаление элемента по индексу
    public boolean removeAt(int index) {
        // Проверка на выход за грани списка
        if (head == null || index >= size)
            return false;
        // Удаление первого элемента из списка
        if (index == 0) {
            head = head.next;
            size--;
            return true;
        }

        // Получение предыдущего элемнта с нужным значением
        Node currentNode = this.getNode(index - 1);
        // Изменение ссылки
        currentNode.next = currentNode.next.next;
        size--;
        return true;
    }

    // Удаление всего списка
    public int removeAll(int value) {
        // Проверка на пустоту
        if (head == null)
            return 0;
        
        int prevSize = this.size;
        
        Node currentNode = remove(value, head);
        while (currentNode != null)
            currentNode = remove(value, currentNode);
        return prevSize - size;
    }

    // Сортировка
    public void sort() {
        sort(0, size - 1);
    }

    // Сортировка по всему списку
    private void sort(int leftBorder, int rightBorder) {
        // Инициализация границ и пивота
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = this.getValue((leftMarker + rightMarker) / 2);

        // Быстрая сортировка
        do {
            while (this.getValue(leftMarker) < pivot)
                leftMarker++;
            while (this.getValue(rightMarker) > pivot)
                rightMarker--;

            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker)
                    swap(leftMarker, rightMarker);
                leftMarker++;
                rightMarker--;
            }

        } while (leftMarker <= rightMarker);
        if (leftMarker < rightBorder)
            sort(leftMarker, rightBorder);
        if (leftBorder < rightMarker)
            sort(leftBorder, rightMarker);
    }

    // Поиск индекса по значению
    public int find(int value) {
        // Проверка на пустоту
        if (head == null)
            return -1;

        Node currentNode = head;

        for (int i = 0; currentNode != null; i++, currentNode = currentNode.next)
            if (currentNode.value == value)
                return i;
        return -1;
    }

    // Получение всего элемента по индексу
    private Node getNode(int index) {
        // Проверка на выход за грани списка
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node currentNode = head;

        for (int i = 0; i < index; i++)
            currentNode = currentNode.next;
        return currentNode;
    }

    // Получение значение по индексу
    private int getValue(int index) {
        // Проверка на выход за грани списка
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node currentNode = head;
        
        for (int i = 0; i < index; i++)
            currentNode = currentNode.next;
        return currentNode.value;
    }

    // Получение размера списка
    public int getSize() {
        return size;
    }

    // Замена местами значений
    private void swap(int index1, int index2) {
        // Проверка на выход за грани списка
        if (index1 < 0 || index1 >= size)
            return;
        if (index2 < 0 || index2 >= size)
            return;
        // Создание временных значений
        Node node1 = this.getNode(index1);
        Node node2 = this.getNode(index2);
        // Замена значений
        int temp = node1.value;
        node1.value = node2.value;
        node2.value = temp;
    }

    // Печать списка
    public void print() {
        Node currentNode = head;
        System.out.print("[ ");
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println("]");
    }

    // Разворот списка
    public void reverce(){
        // Если массив больше 1 элемента, иначе разворот не нужен 
        if (size > 1) {
            Node currentNode = head;
            Node last = null;
            Node first = head;
            Node second = head;

            while (currentNode != null ){
                // Проверка на последний элемент, если список нечетной длинны
                if (currentNode.next == null) {
                    currentNode.next = last;
                    last = currentNode;
                    break;
                }
                // Меняемые элементы
                first = currentNode;
                second = currentNode.next;
                
                currentNode = currentNode.next.next;
                second.next = first;
                first.next = last;
                
                last = second; // Последний используемый элемент

            }

            head = last;
         
        }
        
    }

    // Класс нода
    private class Node {
        int value;
        Node next;
        // Инициализация класса, если нет входных значений
        Node() {
            next = null;
        }
        // Инициализация класса, если есть одно значений
        Node(int _value) {
            this.value = _value;
        }
        // Инициализация класса, если два значения
        Node(int _value, Node _next) {
            this.value = _value; // Значение элемента, лежащего в списке
            this.next = _next; // Следующий элемент связного списка
        }
    }



}
