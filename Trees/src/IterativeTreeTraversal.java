import java.util.Scanner;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

record Node(int data,Node left,Node right){}

public class IterativeTreeTraversal {
    Node root;
    public IterativeTreeTraversal(){
        root=null;
    }
    private void insert(int key){
        root=insert(key,root);
    }
    private Node insert(int key,Node root){
        if(root==null)return new Node(key,null,null);
        if(key<root.data()){
            return new Node(root.data(),insert(key,root.left()),root.right());
            
        }
        else{
            return new Node(root.data(),root.left(),insert(key,root.right()));

        }
    }
    private List<Integer> preOrder(){
        return preOrder(root);
    }
    private List<Integer>inOrder(){
        return inOrder(root);
    }

    private List<Integer>postOrder1(){
        return postOrder1(root);
    }

    private List<Integer>postOrder2(){
        return postOrder2(root);
    }

    
    private List<Integer> preOrder(Node root){
        List<Integer>nodes=new ArrayList<>();
        Stack<Node>stack=new Stack<>();
        if(root==null)return nodes;

        stack.push(root);
        while(!stack.isEmpty()){
            Node curr=stack.pop();

            if(curr.right()!=null){
                stack.push(curr.right());
            }
            if(curr.left()!=null){
                stack.push(curr.left());
            }
            nodes.add(curr.data()); 
        }
        return nodes;
    }
    private List<Integer>inOrder(Node curr){
        List<Integer>nodes=new ArrayList<>();
        Stack<Node>stack=new Stack<>();

        while(curr!=null||!stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr=curr.left();
            }
            curr=stack.pop();
            nodes.add(curr.data());
            curr=curr.right();
        }  
        return nodes;
    }

    private List<Integer>postOrder1(Node curr){
       List<Integer>nodes=new ArrayList<>();
       Stack<Node>stack=new Stack<>();
       Node lastVisited=null;

       while(curr!=null||!stack.isEmpty()){
           while(curr!=null){
            stack.push(curr);
            curr=curr.left();
           }
           Node top=stack.peek();
           if(top.right()!=null && lastVisited!=top.right()){
             curr=top.right();
           }
           else{
               nodes.add(top.data());
               lastVisited=stack.pop();
           }
       }
       return nodes;
    }
    
    private List<Integer>postOrder2(Node curr){
        List<Integer>nodes=new ArrayList<>();
        Stack<Node>stack=new Stack<>();
        if(curr==null)return nodes;

        stack.push(curr);
        while(!stack.isEmpty()){
            Node top=stack.pop();

            if(top.left()!=null){
                stack.push(top.left());
            }
            if(top.right()!=null){
                stack.push(top.right());
            }
            nodes.add(0,top.data());
        }
        return nodes;   
    }

    public static void main(String[] args) {
        IterativeTreeTraversal tree=new IterativeTreeTraversal();
        Scanner input=new Scanner(System.in);
        
        int n=input.nextInt();
        input.nextLine();

        while(n-->0){
            int value=input.nextInt();
            tree.insert(value);
        }

        System.out.println(tree.preOrder());
        System.out.println(tree.inOrder());
        System.out.println(tree.postOrder1());
        System.out.println(tree.postOrder2());
    }
}
