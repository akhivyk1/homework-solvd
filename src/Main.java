import task1.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("Общее количество аргументов: " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("Аргумент " + i + ": " + args[i]);
        }

        MergeSort algorithm = new MergeSort();
        int[] array = new int [] {5, 8, 1, 9, 10, 4, 3};
        int [] resultSort = algorithm.mergeSort(array, 7);

        System.out.println("Отсортированный массив:");
        for (int j : resultSort) {
            System.out.print(j + " ");
        }
    }
}