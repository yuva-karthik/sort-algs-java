/* This Java file consists of various sorting algorithms.
 * each algorithm is written in the best way possible.
 * each sorting function is written to return the array after sorting.
 * feel free to reach me out for any additions/corrections
 * 
 * Available sorting algorithms:
 *  1. bubble sort
 *  2. selection sort
 *  3. insertion sort
 *  4. merge sort
 *  5. quick sort
 */


class SortMaster{

//  <---BUBBLE SORT ALGORITHM-->

    private void bubble(int[] arr){
        int n = arr.length;
        for(int i = 0 ; i < n - 1 ; i++){
            for(int j = i + 1 ; j < n ; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public int[] BubbleSort(int[] arr){
        bubble(arr);
        return arr;
    }

//  <--SELECTION SORT ALGORITHM-->

    private void selection(int[] arr){
        int n = arr.length;
        for(int i = 0 ; i < n - 1 ; i++){
            int l = i;
            for(int j = i + 1 ; j < n ; j++){
                if(arr[l] > arr[j]){
                    l = j;
                }
            }
            if(l != i){
                int temp = arr[l];
                arr[l] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public int[] SelectionSort(int[] arr){
        selection(arr);
        return arr;
    }

//  <--INSERTION SORT ALGORITHM-->

    private void insertion(int[] arr){
        int n = arr.length;
        for(int i = 1 ; i < n ; i++){
            int num = arr[i];
            int j = i - 1;
            while(j >= 0 && num < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = num;
        }
    }

    public int[] InsertionSort(int[] arr){
        insertion(arr);
        return arr;
    }

//  <--MERGE SORT ALGORITHM-->

    private void merge(int[] arr , int si ,int mid , int ei){
        int[] ans = new int[ei - si + 1];

        int i1 = si;
        int i2 = mid+1;
        int x = 0;

        while(i1 <= mid && i2 <= ei){
            if(arr[i1] <= arr[i2]){
                ans[x] = arr[i1];
                i1++;
            }else{
                ans[x] = arr[i2];
                i2++;
            }
            x++;
        }

        while(i1 <= mid){
            ans[x] = arr[i1];
            i1++;
            x++;
        }
        while(i2 <= ei){
            ans[x] = arr[i2];
            i2++;
            x++;
        }

        for(int i = 0 , j = si ; i < ans.length ; i++ , j++){
            arr[j] = ans[i];
        }
        
    }

    private void split(int[] arr , int si , int ei){
        if(si >= ei){
            return;
        }

        int mid = (si+ei)/2 ;
        split(arr , si , mid);
        split(arr , mid+1 , ei);
        merge(arr , si , mid , ei);
    }

    public int[] MergeSort(int[] arr){
        split(arr , 0 , arr.length-1);
        return arr;
    }

//  <--QUICK SORT ALGORITHM-->

    private int partition(int[] arr, int l, int h) {
        int pivot = arr[h];
        int i = l - 1;

        for(int j = l ; j < h ; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
          
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[h] = temp;
        
        return i;
    }

    private void QSort(int[] arr, int l , int h){
        if(l < h){
            int i_pivot = partition(arr , l , h);
            QSort(arr, l , i_pivot - 1);
            QSort(arr, i_pivot + 1 , h);
        }
    }

    public int[] QuickSort(int[] arr){
        QSort(arr, 0, arr.length - 1);
        return arr;
    }

}