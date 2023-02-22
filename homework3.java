/**
 * homework3
 */
public class homework3 {
    public static void main(String[] args) {
        
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
}