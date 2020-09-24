package data_structure.tree;

/**
 * created by victory_woo on 2020/09/24
 */
public class TreeTest {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node node4 = tree.createNode(null, 4, null);
        Node node5 = tree.createNode(null, 5, null);
        Node node2 = tree.createNode(node4, 2, node5);
        Node node3 = tree.createNode(null, 3, null);
        Node node1 = tree.createNode(node2, 1, node3);

        tree.setRoot(node1);
        System.out.println("중위 순회");
        tree.inOrder(tree.getRoot());
        System.out.println("전위 순회");
        tree.preOrder(tree.getRoot());
        System.out.println("후위 순회");
        tree.postOrder(tree.getRoot());
    }
}
