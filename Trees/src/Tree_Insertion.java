import java.util.Scanner;
class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
public class Tree_Insertion {
    Node root;
    public Tree_Insertion(){
        root=null;
    }
    private void insert(int key){
        root=insert(root,key);
    }
    private Node insert(Node curr,int val){
        if(curr==null){
           return new Node(val);
        }
        if(val<curr.data){
            curr.left=insert(curr.left,val);
        }
        else{
            curr.right=insert(curr.right,val);
        }
        return curr;
    }
    private void preOrder(){
        preOrder(root);
        System.out.println();
    }
    private void preOrder(Node root){
        if(root!=null){
           System.out.print(root.data+" ");
           preOrder(root.left);
           preOrder(root.right);
        }  
    }

    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        Tree_Insertion tree = new Tree_Insertion();
        int N=input.nextInt();
        input.nextLine();

        for(int i=0;i<N;i++){
            int val=input.nextInt();
            tree.insert(val);
        }
        tree.preOrder();

    }
}
