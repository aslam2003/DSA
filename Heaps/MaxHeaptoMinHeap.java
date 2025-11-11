public class MaxHeaptoMinHeap {
    private int maxheap[];
    
    public MaxHeaptoMinHeap(int heap[]){
        this.maxheap=heap;
    }
    private int leftChild(int i){return 2*i+1;}
    private int rightChild(int i){return 2*i+2;}

    public void heapifyDown(int i,int n){
        int smallest=i;
        int left=leftChild(i);
        int right=rightChild(i);

        if(left<n && maxheap[left]<maxheap[smallest])smallest=left;
        if(right<n && maxheap[right]<maxheap[smallest])smallest=right;

        if(smallest!=i){
            swap(i,smallest);
            heapifyDown(smallest,n);
        }
    }
    public void swap(int i,int j){
        int temp=maxheap[i];
        maxheap[i]=maxheap[j];
        maxheap[j]=temp;
    }
    public void printHeap(){
        for(int number:maxheap){
            System.out.print(number+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int heap1[]={50, 30, 40, 10, 20, 35, 25};
        MaxHeaptoMinHeap maxheap1=new MaxHeaptoMinHeap(heap1);

        for(int i=(heap1.length/2)-1;i>=0;i--){
            maxheap1.heapifyDown(i,heap1.length);
        }
        maxheap1.printHeap();
    }
}
