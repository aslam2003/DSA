
class Maxheap {
    private int[]heap;
    private int size;
    private final int capacity;
    public Maxheap(int capacity){
        this.heap=new int[capacity];
        this.size=0;
        this.capacity=capacity;
    }
    private int parent(int i){return ((i-1)/2);}
    private int leftChild(int i){return 2*i+1;}
    private int rightChild(int i){return 2*i+2;}

    public void insert(int number){
        if(size==capacity){
            System.out.println("Heap is full!Delete some elements for insertion.");
            return;
        }
        heap[size]=number;
        int current=size;
        size++;
        while(current>0 && heap[current]>heap[parent(current)]){
            swap(current,parent(current));
            current=parent(current);
        }
    }

    public int delete(){
        if(size==0){
            System.out.println("Heap is empty!!!");
            return -1;
        }
        int root=heap[0];
        heap[0]=heap[size-1];
        heap[size-1]=0;
        size--;
        heapifyDown(0);
        return root;
    }
    public int peek(){
        if(size==0){
            System.out.println("Heap is empty!!!");
            return -1;
        }
        int top=heap[0];
        return top;
    }

    public void heapifyDown(int i){
        int largest=i;
        int left=leftChild(i);
        int right=rightChild(i);

        if(left<size && heap[left]>heap[largest])largest=left;
        if(right<size && heap[right]>heap[largest])largest=right;

        if(largest!=i){
            swap(i,largest);
            heapifyDown(largest);
        }
    }
    public void swap(int i,int j){
        int temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }

    public void printHeap(){
        for(int i=0;i<size;i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Maxheap maxheap=new Maxheap(5);//You can try any capacity
        maxheap.insert(13);
        maxheap.insert(14);
        maxheap.insert(29);
        maxheap.insert(5);
        maxheap.insert(57);
        maxheap.insert(35);//More than capacity->insertion not possible

        System.out.println("Heap's top:"+maxheap.peek());
        maxheap.printHeap();

        for(int i=0;i<maxheap.capacity+1;i++){
            System.out.println(maxheap.delete());
        }


    }
}
