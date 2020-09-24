package data_structure.tree;

/**
 * created by victory_woo on 2020/09/24
 */
public class Tree {
    private Node root;

    void setRoot(Node root) {
        this.root = root;
    }

    Node getRoot() {
        return this.root;
    }

    Node createNode(Node left, int value, Node right) {
        Node node = new Node();
        node.value = value;
        node.left = left;
        node.right = right;
        return node;
    }


    // 중위 순회 : left -> root -> right
    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.value);
            inOrder(node.right);
        }
    }

    // 전위 순회 : root -> left -> right
    void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 후위 순회 : left -> right -> root
    void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.value);
        }
    }
}
