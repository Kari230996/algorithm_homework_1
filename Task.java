/**
 * 1. Реализовать алгоритм пирамидальной сортировки (сортировка кучей).
      Реализация quickSort с семинара
 */
public class Task {

    public static void main(String[] args) {
        int[] array = { 5, 2, 9, 1, 3 };
        Task.heapSort(array);

        // Вывод отсортированного массива
        for (int num : array) {
            System.out.println(num + " ");
        }
    }

    public static void heapSort(int[] array) {
        // Построение кучи (перегруппировка массива)
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        // Извлечение элементов из кучи один за другим
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex; // Инициализируем наибольший элемент как корень
        int leftChild = 2 * rootIndex + 1; // Левый потомок
        int rightChild = 2 * rootIndex + 2; // Правый потомок

        // Если левый потомок больше корня
        if (leftChild < heapSize && array[leftChild] > array[largest])
            largest = leftChild;

        // Если правый потомок больше наибольшего элемента на данный момент
        if (rightChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;

        // Если наибольший элемент не является корневым
        if (largest != rootIndex) {
            int swap = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = swap;

            // Рекурсивно вызываем heapify для затронутой подкучи
            heapify(array, heapSize, largest);
        }
    }

}