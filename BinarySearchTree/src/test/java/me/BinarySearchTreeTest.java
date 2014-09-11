package me;

import org.junit.*;
import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    public BinarySearchTreeTest() {}

    @Test
    public void fromArrayTest() throws Exception {
        assertEquals("Empty", "" + BinarySearchTree.fromArray(null));
        assertEquals("Empty", "" + BinarySearchTree.fromArray(new int[]{}));
        assertEquals("(Node 3 (Node 2 (Node 1 Empty Empty) Empty) (Node 5 (Node 4 Empty Empty) Empty))"
                     , "" + BinarySearchTree.fromArray(new int[]{1,2,3,4,5}));
    }

    @Test
    public void lcaTest() throws Exception {
        Node root = new Node(11, new Node(9, new Node(5, new Node(4), new Node(7, new Node(6), new Node(8))), new Node(10)), new Node(12));
        assertEquals(9, root.lca(8,10));
        assertEquals(5, root.lca(4,8));
        assertEquals(7, root.lca(6,7));
        assertEquals(11, root.lca(9,12));
        assertEquals(11, root.lca(6,12));
    }

    @Test
    public void nodePrintTest() throws Exception {
        Node root = new Node(11, new Node(9, new Node(5, new Node(4), new Node(7, new Node(6), new Node(8))), new Node(10)), new Node(12));
        root.print();
        System.out.println("");
        root.printRec(root);
        System.out.println("");
    }

    @Test
    public void findSumTest() throws Exception {
        Node n1 = new Node(1);
        Node n6 = new Node(6);
        Node n8 = new Node(8);
        Node n12 = new Node(12);
        Node n18 = new Node(18);
        Node n7 = new Node(7,n6,n8);
        Node n3 = new Node(3,n1,n7);
        Node n10 = new Node(10,n3,n12);
        Node root = new Node(15,n10,n18);
        //root.print();

        assertArrayEquals(new Node[]{n1, root}, root.findSum(16));
        assertArrayEquals(new Node[]{n3, n12}, root.findSum(15));
        assertArrayEquals(new Node[]{n7, n10}, root.findSum(17));
        assertArrayEquals(new Node[]{n6, n8}, root.findSum(14));
        assertArrayEquals(new Node[]{n3, n7}, root.findSum(10));
        assertArrayEquals(new Node[]{n1, n10}, root.findSum(11));
        assertArrayEquals(new Node[]{n8, n12}, root.findSum(20));
        assertArrayEquals(new Node[]{n12, n18}, root.findSum(30));
        assertArrayEquals(null, root.findSum(5));
        assertArrayEquals(null, root.findSum(40));
    }

    @Test
    public void maxBSTTest() throws Exception {
        BinarySearchTree t = BinarySearchTree.fromArray(new int[]{1,2,3,4,5});
        //System.out.println(t);
        //Node.maxBST(t.root);
        assertEquals(5, Node.maxBST(t.root).maxtree);
        t = BinarySearchTree.fromArray(new int[]{14,4,8,2,5,1,3,9,10,11,16,15,17});
        //System.out.println(t);
        //Node.maxBST(t.root);
        assertEquals(3, Node.maxBST(t.root).maxtree);
    }

    @Test
    public void isBSTTest() throws Exception {
        Node root = new Node(11, new Node(9, new Node(5, new Node(4), new Node(7, new Node(6), new Node(8))), new Node(10)), new Node(12));
        assertEquals(true, Node.isBST(root));
        root = new Node(11, new Node(9, new Node(5, new Node(4), new Node(7, new Node(8), new Node(6))), new Node(10)), new Node(12));
        assertEquals(false, Node.isBST(root));
        root = new Node(11, new Node(9, new Node(5, new Node(4), new Node(3, new Node(6), new Node(8))), new Node(10)), new Node(12));
        assertEquals(false, Node.isBST(root));
    }

    @Test
    public void testNext() throws Exception {
        Node n1 = new Node(1);
        Node n6 = new Node(6);
        Node n8 = new Node(8);
        Node n12 = new Node(12);
        Node n18 = new Node(18);
        Node n7 = new Node(7,n6,n8);
        Node n3 = new Node(3,n1,n7);
        Node n10 = new Node(10,n3,n12);
        Node root = new Node(15,n10,n18);
        n1.parent = n3;
        n6.parent = n7;
        n8.parent = n7;
        n12.parent = n10;
        n18.parent = root;
        n7.parent = n3;
        n3.parent = n10;
        n10.parent = root;
        System.out.println(root);
        Node n = n1;
        while (n.next() != null) {
            System.out.print(n.value + " ");
            n = n.next();
        }
    }

}
