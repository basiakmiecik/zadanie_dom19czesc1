import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class java_54 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ile liczb chcesz wylosowac?");
        int numAmount = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Do jakiej liczby chesz losować?");
        int numbound = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Liczbą która się powtarza najczęściej jest liczba: " + notUnique(numberList(numAmount, numbound)));


    }

    public static List<Integer> numberList(int numberAmount, int numbound) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numberAmount; i++) {
            Random random = new Random();
            int number = random.nextInt(numbound);
            list.add(number);
            System.out.print(number + ", ");
        }
        return list;
    }


    public static int notUnique(List<Integer> list) {

        List<Integer> numberTable = list;
        List<Integer> row1 = new ArrayList<>();
        row1.add(0);
        List<Integer> row2 = new ArrayList<>();
        row2.add(0);
        int num = 0;
        int nUnique = 0;
        do {
            int liczba = 0;
            nUnique = numberTable.get(num);
            for (int i = 0; i < numberTable.size(); i++) {
                int control = 0;
                for (int j = 0; j < row1.size(); j++) {
                    if (nUnique == row1.get(j)) {
                        control = +1;
                    }
                }
                if (numberTable.get(i) == nUnique && control == 0) {
                    liczba += 1;
                }
            }
            if (liczba >= row2.get(row2.size() - 1)) {
                row1.add(nUnique);
                row2.add(liczba);
            }
            nUnique = numberTable.get(liczba + 2);
            num += 1;
        } while (num != list.size());

        return row1.get(row1.size() - 1);
    }
}
/*Zdefiniuj metodę, która przyjmuje tablicę liczb, a w wyniku zwraca liczbę, która najczęściej się powtarzała.
W przypadku przekazania pustej tablicy powinien być rzucony wyjątek NoSuchElementException.
W przypadku, gdy liczba powtórzeń kilku liczb jest taka sama, zwrócona powinna być najmniejsza z nich.

Przykładowo dla tablicy
[2, 2, 2, 3, 3, 4, 5]
Powinna być zwrócona liczba 2 (liczby w tablicy nie muszą być pogrupowane, ani ustawione w określonej kolejności)

Dla tablicy
[5, 5, 5, 8, 3, 3, 3, 10, 2, 1, 2]
Powinna być zwrócona liczba 3.

Przetestuj działanie metody w osobnej klasie.*/