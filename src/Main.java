import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * This is a program, united an array of integers manipulation
 * with a sweet box constructor.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
         * The user is prompted to select a task to perform.
         */
        System.out.println("Enter number of task: (1 - intArray, 2 - sweeties)");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                intArray();
                break;
            case 2:
                sweeties();
                break;

            default:
                System.out.println("Wrong number of task!");
        }
    }

    /**
     * This is a sweet box method.
     */
    private static void sweeties() {
        class Sweetness {
            private String name;
            private int weight;
            private int cost;

            public Sweetness(String name, int weight, int cost) {
                this.name = name;
                this.weight = weight;
                this.cost = cost;
            }

            public String getName() {
                return name;
            }

            public int getWeight() {
                return weight;
            }

            public int getCost() {
                return cost;
            }

            @Override
            public String toString() {
                return "Название: " + name + ", Вес: " + weight + ", Цена: " + cost;
            }
        }

        class Candy extends Sweetness {
            private String param;

            public Candy(String name, int weight, int cost, String param) {
                super(name, weight, cost);
                this.param = param;
            }

            @Override
            public String toString() {
                return super.toString() + ", Параметр: " + param;
            }
        }

        class Jellybean extends Sweetness {
            private String param;

            public Jellybean(String name, int weight, int cost, String param) {
                super(name, weight, cost);
                this.param = param;
            }

            @Override
            public String toString() {
                return super.toString() + ", Параметр: " + param;
            }
        }

        List<Sweetness> sweets = new ArrayList<>();
        sweets.add(new Candy("Candy1", 10, 100, "Param1"));
        sweets.add(new Jellybean("Jellybean1", 20, 200, "Param2"));
        sweets.add(new Candy("Candy2", 30, 300, "Param3"));
        sweets.add(new Jellybean("Jellybean2", 40, 400, "Param4"));

        int totalWeight = 0;
        int totalCost = 0;
        for (Sweetness sweetness : sweets) {
            totalWeight += sweetness.getWeight();
            totalCost += sweetness.getCost();
        }
        System.out.println("Общий вес подарка: " + totalWeight);
        System.out.println("Общая стоимость подарка: " + totalCost);

        for (Sweetness sweetness : sweets) {
            System.out.println(sweetness.toString());
        }
    }

    /**
     * Int array manipulation method.
     */
    private static void intArray() {
        int[] array = new int[20];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(21) - 10;
        }
        System.out.println("Исходный массив: " + Arrays.toString(array));

        int maxNegative = Integer.MIN_VALUE;
        int minPositive = Integer.MAX_VALUE;
        for (int num : array) {
            if (num < 0 && num > maxNegative) {
                maxNegative = num;
            }
            if (num > 0 && num < minPositive) {
                minPositive = num;
            }
        }
        System.out.println("Максимальный отрицательный элемент: " + maxNegative);
        System.out.println("Минимальный положительный элемент: " + minPositive);

        int maxNegativeIndex = -1;
        int minPositiveIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == maxNegative) {
                maxNegativeIndex = i;
            }
            if (array[i] == minPositive) {
                minPositiveIndex = i;
            }
        }
        if (maxNegativeIndex != -1 && minPositiveIndex != -1) {
            array[maxNegativeIndex] = minPositive;
            array[minPositiveIndex] = maxNegative;
        }
        System.out.println("Массив после замены: " + Arrays.toString(array));
    }
}


