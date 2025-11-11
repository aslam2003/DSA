public class MinHeaptoMaxHeap {
     private int minheap[];
    
    public MinHeaptoMaxHeap(int heap[]){
        this.minheap=heap;
    }
    private int leftChild(int i){return 2*i+1;}
    private int rightChild(int i){return 2*i+2;}

    public void heapifyDown(int i,int n){
        int largest=i;
        int left=leftChild(i);
        int right=rightChild(i);

        if(left<n && minheap[left]>minheap[largest])largest=left;
        if(right<n && minheap[right]>minheap[largest])largest=right;

        if(largest!=i){
            swap(i,largest);
            heapifyDown(largest,n);
        }
    }
    public void swap(int i,int j){
        int temp=minheap[i];
        minheap[i]=minheap[j];
        minheap[j]=temp;
    }
    public void printHeap(){
        for(int number:minheap){
            System.out.print(number+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int heap1[]={10,20,25,30,50,35,40};
        MinHeaptoMaxHeap minheap1=new MinHeaptoMaxHeap(heap1);

        for(int i=(heap1.length/2)-1;i>=0;i--){
            minheap1.heapifyDown(i,heap1.length);
        }
        minheap1.printHeap();
    }
}

