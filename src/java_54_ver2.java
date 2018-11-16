import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.NoSuchElementException;

public class java_54_ver2 {

        public static void main(String[] args) throws FileNotFoundException{
                try {
                    System.out.println("Liczbą która się powtarza najczęściej jest liczba: " + notUnique(numberList()));
                }catch (NoSuchElementException| IndexOutOfBoundsException e){
                    System.err.println("Podana tablica jest pusta");
                }

        }



        public static List<Integer> numberList() throws FileNotFoundException,NoSuchElementException {
            FileReader file = new FileReader("Zeszyt1.csv");
            Scanner scanner = new Scanner(file);
            List<Integer> list = new ArrayList<>();
            do {

               String line = scanner.nextLine();
               if(line.isEmpty()) {
                   throw new NoSuchElementException();
               }
                String[] parts = line.split(";");
                list.add(Integer.valueOf(parts[0]));

            }while (scanner.hasNextLine());



            return list;}

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