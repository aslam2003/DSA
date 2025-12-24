import java.util.ArrayList;
import java.util.List;
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
public class BinarySearchTrees {
    Node root;
    public BinarySearchTrees(){
        root=null;
    }

    private void insert(int key){
        root=insert(key,root);
    }

    private  Node insert(int key,Node root){
        if(root==null)return new Node(key);
        if(key<root.data){
            root.left=insert(key,root.left);
        }
        else{
            root.right=insert(key,root.right);
        }
        return root;
    }

    private void delete(int key){
        root=delete(key,root);
    }
    
    private Node delete(int key,Node root){
        if(root==null)return null;
        if(key<root.data){
            root.left=delete(key,root.left);
        }
        else if(key>root.data){
            root.right=delete(key,root.right);
        }
        else{
            if(root.left==null && root.right==null)return null;
            if(root.left==null)return root.right;
            if(root.right==null)return root.left;
            
            int successor=findMin(root.right);//Find the smallest in the right subtree
            root.data=successor;
            root.right=delete(successor,root.right);
        }
        return root;
    }

    private int search(int key){
        return search(key,root);
    }
    
    private int search(int key,Node root){
        if(root==null)return -1;
        if(key<root.data) return search(key,root.left);
        else if(key>root.data)return search(key,root.right);
        else return 1;
    }

    private int findMin(Node root){
         while(root.left!=null){
            root=root.left;
         }
         return root.data;
    }

    private int findMax(Node root){
        while(root.right!=null)root=root.right;
        return root.data;
    }

    private List<Integer>preOrder(){
        return preOrder(root);
    }

    private List<Integer>preOrder(Node root){
        List<Integer>nodes=new ArrayList<>();
        while(root!=null){
            if(root.left==null){
                nodes.add(root.data);
                root=root.right;
            }
            else{
                Node prev=root.left;
                while(prev.right!=null && prev.right!=root){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=root;
                    nodes.add(root.data);
                    root=root.left;
                }
                else{
                    prev.right=null;
                    root=root.right;
                }
            }
        }
        return nodes;
    } 
    

    public static void main(String[] args) {
        try(Scanner input=new Scanner(System.in)){
             //Testcases
            int T=input.nextInt();
            input.nextLine();

            while(T-->0){
               BinarySearchTrees bst=new BinarySearchTrees();
               int n=input.nextInt();//Number of nodes
               int k=input.nextInt();//Number of nodes that we can delete
               int target=input.nextInt();
               input.nextLine();

               while(n-->0){
                  int toInsert=input.nextInt();
                  bst.insert(toInsert);
               }
               System.out.println(bst.preOrder());
               System.out.println(bst.findMin(bst.root));
               System.out.println(bst.findMax(bst.root));
               System.out.println(bst.search(target));

               while(k-->0){
                  int toDelete=input.nextInt();
                  bst.delete(toDelete);
               }
               System.out.println(bst.preOrder());

            }
              
        }

    }
}
