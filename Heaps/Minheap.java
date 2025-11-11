
class Minheap {
    private int[]heap;
    private int size;
    private final int capacity;
    public Minheap(int capacity){
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
        while(current>0 && heap[current]<heap[parent(current)]){
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
        int smallest=i;
        int left=leftChild(i);
        int right=rightChild(i);

        if(left<size && heap[left]<heap[smallest])smallest=left;
        if(right<size && heap[right]<heap[smallest])smallest=right;

        if(smallest!=i){
            swap(i,smallest);
            heapifyDown(smallest);
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
        Minheap minheap=new Minheap(5);//You can try any capacity
        minheap.insert(13);
        minheap.insert(14);
        minheap.insert(29);
        minheap.insert(5);
        minheap.insert(57);
        minheap.insert(35);//More than capacity->insertion not possible

        System.out.println("Heap's top:"+minheap.peek());
        minheap.printHeap();

        for(int i=0;i<minheap.capacity+1;i++){
            System.out.println(minheap.delete());
        }


    }
}
