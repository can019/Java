import java.util.*;

public class Main {
    public static class Node{
        private int value = -1;
        private Node left = null;
        private Node right = null;
        private Node parent = null;

        public Node(int value){
            this.value = value;
        }
        public void set_left(Node left){
            this.left = left;
        }
        public void set_right(Node right){
            this.right = right;
        }
        public void set_parent(Node parent){
            this.parent = parent;
        }
        public int get_value(){
            return this.value;
        }
        public Node get_left(){
            return this.left;
        }
        public Node get_right(){
            return this.right;
        }
        public Node get_parent(){
            return this.parent;
        }
    }
    public static class Tree{
        private Node root;
        private int size;

        public Tree(int value){
            Node new_Node = new Node(value);
            this.root = new_Node;
            this.size = 0;
        }
        public boolean add(Node new_node){

        }
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n_input = input.nextInt();
        HashMap<Integer, Stack<Integer>> map = new HashMap<>();

        for(int i = 0; i < n_input; i++){
            int key = input.nextInt();
            int value = input.nextInt();
            if(!map.containsKey(key)){
                Stack<Integer> stack = new Stack<>();
                stack.push(value);
                map.put(key,stack);
            }
            else{
                map.get(key).push(value);
            }
        }

        for (int key : map.keySet()) {
            map.get(key);
        }

    }
}
