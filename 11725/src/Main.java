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

        public Tree() {
            this.size = 0;
            this.root = null;
        }
        public void set_root(Node root){
            this.root = root;
            this.size_up();
        }

        private void size_up(){
            this.size++;
        }
        public int get_size(){
            return this.size;
        }
        public boolean is_empty(){
            if(this.get_size()==0)
                return true;
            return false;
        }
        public Node get_root(){
            return this.root;
        }
        public boolean add(int parent_value, int value){
            Node new_node = new Node(value);
            Queue<Node> in_sequence = new LinkedList<>();
            in_sequence.add(this.get_root());
            Node parent = this.find_bfs(in_sequence, parent_value);

            if(parent == null)
                return false;
            if (parent.get_left()==null)
                parent.set_left(new_node);
            else if(parent.get_right()==null)
                parent.set_right(new_node);
            else
                return false;

            this.size_up();
            return true;
        }
        public Node find_bfs(Queue<Node> in_sequence, int target_value){
            try {
                Node current = in_sequence.poll();
                if (current.get_value() == target_value)
                    return current;
                else {
                    if (current.get_left() != null)
                        in_sequence.add(current.get_left());
                    if (current.get_right() != null)
                        in_sequence.add(current.get_right());
                    return find_bfs(in_sequence, target_value);
                }
            }
            catch (Exception e){
                System.out.println();
                return null;
            }
        }
        public void print_parent_node(int target_value){
            Queue<Node> in_sequence = new LinkedList<>();
            in_sequence.add(this.get_root());
            Node target = this.find_bfs(in_sequence, target_value);
            System.out.println(target.get_parent().get_value());
        }
    }

    public static boolean make_tree(Tree tree, HashMap<Integer, Stack<Integer>> map, Stack<Integer> courses){
        int current_target = courses.pop();
        System.out.println(current_target);
        if(current_target==1){
            Node new_node = new Node(current_target);
            tree.set_root(new_node);
        }
        Stack<Integer> stack = map.get(current_target);
        if(current_target==2)
            System.out.println();
        if(stack != null){
            while(!stack.isEmpty()){
                int value = stack.pop();
                courses.add(value);
                tree.add(current_target, value);
            }
            map.remove(current_target);
        }
        if(map.size()==0){
            return true;
        }
        else if(courses.size()==0){
            Iterator<Integer> keys = map.keySet().iterator();
            courses.add(keys.next());
        }
        return make_tree(tree, map, courses);
    }


    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n_input = input.nextInt();
        HashMap<Integer, Stack<Integer>> map = new HashMap<>();

        for(int i = 0; i < n_input-1; i++){
            int key = Integer.parseInt(input.next());
            int value = Integer.parseInt(input.next());
            if(!map.containsKey(key)){
                Stack<Integer> stack = new Stack<>();
                stack.push(value);
                map.put(key,stack);
            }
            else{
                map.get(key).push(value);
            }
            System.out.println(i);
        }
        Tree tree = new Tree();
        System.out.println("--------------------------");
       Stack<Integer> courses = new Stack<>();
       courses.add(1);
       make_tree(tree, map, courses);
       System.out.println();
//        for (int key : map.keySet()) {
//            System.out.println(key);
//            Stack<Integer> stack = new Stack<>();
//            stack = map.get(key);
//            if(key==1){
//                Node new_node = new Node(key);
//                tree.set_root(new_node);
//            }
//            while(!stack.isEmpty()){
//                tree.add(key, stack.pop());
//            }
//        }
//        System.out.println();
    }
}
