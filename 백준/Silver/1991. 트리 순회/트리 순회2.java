import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static class Node {
        char value;
        Node left;
        Node right;

        Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static int N;
    static Node head = new Node('A', null, null);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            char root = str[0].charAt(0);
            char left = str[1].charAt(0);
            char right = str[2].charAt(0);
            insertNode(head, root, left, right);
        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
        System.out.println();

    }

    static void insertNode(Node node, char root, char left, char right) {
        if (node.value == root) {
            node.left = (left=='.'? null : new Node(left, null, null));
            node.right = (right=='.'? null : new Node(right, null, null));
        } else {
            if (node.left != null) insertNode(node.left, root, left, right);
            if (node.right != null) insertNode(node.right, root, left, right);
        }
    }
    //전위 순회
    static void preOrder(Node n) {
        if (n==null) return;
        System.out.print(n.value); // root
        preOrder(n.left); // 왼
        preOrder(n.right); // 오
    }
    // 중위 순회
    static void inOrder(Node n) {
        if (n==null) return;
        inOrder(n.left); // 왼
        System.out.print(n.value); // root
        inOrder(n.right); // 오
    }
    // 후위 순회
    static void postOrder(Node n) {
        if (n==null) return;
        postOrder(n.left); // 왼
        postOrder(n.right); // 오
        System.out.print(n.value); // root
    }
}
