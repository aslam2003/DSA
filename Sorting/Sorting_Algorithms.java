class Sorting_Algorithms{
    public void display(int arr[]){
        System.out.println("Modified Array:");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public void bubble_sort(int arr[]){
        int n=arr.length;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public void insertion_sort(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int j=i;
            while(j>0 && arr[j-1]>arr[j]){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
            }
        }
    }
    public void selection_sort(int[]arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int minindex=i;
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j]){
                    minindex=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[minindex];
            arr[minindex]=temp;

        }
    }
    public void mergeSort(int arr[],int low,int high){
        if(low<high){
            int mid=(low+high)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr,low,mid,high);
        }
    }
    public void merge(int arr[],int low,int mid,int high){
        int temp[]=new int[arr.length];
        int k=0;
        int i=low;
        int j=mid+1;
        while(i<=mid && j<=high){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
            }
            }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=high){
            temp[k++]=arr[j++];
        }
        for(int l=low;l<=high;l++){
            arr[l]=temp[l-low];
        }
      
    }
    public void quicksort(int[]arr,int low,int high){
        if(low<high){
            int pos=partition(arr,low,high);
            quicksort(arr,low,pos-1);
            quicksort(arr,pos+1,high);
        }
    }
    public int partition(int arr[],int low,int high){
           int pivot=arr[low];
           int i=low;
           int j=high;
           while(i<j){
            while(arr[i]<=pivot && i<high){
                i++;
            }
            while(arr[j]>pivot && j>low){
                j--;
            }
            if(i<j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
           }
           int temp=arr[low];
           arr[low]=arr[j];
           arr[j]=temp;
           return j;
    }
    public static void main(String[] args) {
        int[]arr={13,8,27,3};
        int[]arr1={9,13,24,53,23};
        int[]arr2={13,4,16,-1,10,23,45};
        int[]arr3={90,40,-2,31,19,12,39,34,104};
        int[]arr4={0,0,-4,3,2,4,17,18,-48211,1044843,12,13,4,9427,2432,1282};
        Sorting_Algorithms obj=new Sorting_Algorithms();

        obj.bubble_sort(arr);
        obj.insertion_sort(arr1);
        obj.selection_sort(arr2);
        obj.mergeSort(arr3,0,arr3.length-1);
        obj.quicksort(arr4, 0, arr4.length-1);

        obj.display(arr);
        obj.display(arr1);
        obj.display(arr2);
        obj.display(arr3);
        obj.display(arr4);






    }
}