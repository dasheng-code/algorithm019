学习笔记


冒泡排序
-----------------
    public int[] bubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
 
插入排序
---------------------------
     public int[] insertSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int index = i-1;
            int cur = arr[i];
            while(index>=0 && arr[index] > cur){
                arr[index+1] = arr[index];
                index--;
            }
            arr[index+1] = cur;
        }
        return arr;
    }
    
选择排序
------------------------------
     public int[] selectSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int min = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
