import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/**
 * homework3
 */
public class homework3 {
    public static void main(String[] args) throws FileNotFoundException {
        int[] arr = readFile();        
        mergeSort(arr);
        printArray(arr);
    }

    private static void mergeSort(int[] arr) { // метод деления массива
        int n = arr.length;
        if(n == 1) return; // условие выхода из рекурсии

        int mid = n / 2; // делим длину массива пополам
        int [] l = new int[mid]; // создаем левую половину массива
        int [] r = new int[n - mid]; // создаем правую половину массива

        for(int i = 0; i < mid; i++){
            l[i] = arr[i];
        }
        for(int i = mid; i < n; i++) {
            r[i - mid] = arr[i];
        }

        mergeSort(l); // запуск рекурсии деления левой половины массива
        mergeSort(r); // запуск рекурисии деления правой половины массива
        marge(arr, l, r);
    }

    private static void marge(int[] arr, int[] l, int[] r) { // метод слияния массива
        int left = l.length;
        int right = r.length;
        int i = 0;
        int j = 0;
        int idx = 0;

        while(i < left && j < right) {
            if(l[i] < r[j]) {
                arr[idx] = l[i];
                i++;
                idx++;
            }
            else {
                arr[idx] = r[j];
                j++;
                idx++;
            }
        }
        for(int ll = i; ll < left; ll++) { // Если в левом массиве остался элемент - добавляем его в итоговый массив
            arr[idx++] = l[ll];
        }
        for(int rr = j; rr < right; rr++) { // Если в правом массиве остался элемент - добавляем его в итоговый массив
            arr[idx++] = r[rr];
        }
    }
    
    private static void printArray(int [] arr) throws FileNotFoundException{
        System.out.println(Arrays.toString(arr));
        File file = new File("output.txt");
        PrintWriter pw = new PrintWriter(file);
        String str = Arrays.toString(arr);
        pw.println(str);
        pw.close();
    }

    private static int[] readFile() throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);
        String[] stringArray = scanner.nextLine().split(",");
        int[] intArray = new int[stringArray.length];

        for(int i = 0; i < stringArray.length; i++){
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        scanner.close();
        return intArray;
    }
}