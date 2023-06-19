public class DZ2 {

   public static void main(String[] args) {
    int[] arr = {12, 6, 4, 1, 15, 10};
    arr = sortArray(arr);
    // печать массива
     for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
   }
    // сортировка массива    
    public static int[] sortArray(int[] array){
        // проверка на массив из 1 элемента
        if (array.length <= 1) {
            return array;
        }
        // первая полная сортировка снизу вверх
        array = toHeap(array);
        int temp = array[0];
        array[0] = array[array.length-1];
        array[array.length-1] = temp;
        
        // сортировка элементов, которые меняются
        for (int i = array.length-2; i > 0; i--) {
            array = sortNums(array, 0, i);
        
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;
        }
        return array;
    }  

    // создание кучи из массива
    public static int[] toHeap(int[] array){
        for (int i = (array.length-1)/2; i >= 0; i--) {
            array = sortNums(array, i, array.length-1);
        }
       
        return array;
    }
// рекурсивная сортировка трех элементов 
    public static int[] sortNums(int[] array, int i, int maxVal){
        
        int maxNum = i;

        
        if (i*2+2 <= maxVal) {
            int rightNum = i*2+2;
            if (array[rightNum] > array[maxNum]) {
                maxNum = rightNum;
            }
        }

        if (i*2+1 <= maxVal) {
            int leftNum = i*2+1;
            if (array[leftNum] > array[maxNum]) {
                maxNum = leftNum;
            }
        }

        if (maxNum != i) {
            int temp = array[maxNum];
            array[maxNum] = array[i];
            array[i] = temp;
            array = sortNums(array, maxNum, maxVal);
        }
         
        return array;
    }
}
