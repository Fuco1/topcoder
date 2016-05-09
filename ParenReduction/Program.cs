using System;

class ParenReduction
{
    public static void Main (string[] args)
    {
        Node a = new Atom("a");
        Node b = new Atom("b");
        Node c = new Atom("c");
        Node p = new Plus(a, b);
        Node parens = new Parens(p);
        Node m = new Minus(c, parens);
        Console.WriteLine (m);
    }

    // public Node Parse(string input)
    // {

    // }
}

abstract class Node
{

}

abstract class BinaryNode : Node {
    public Node left;
    public Node right;
    public string op;

    override public string ToString() {
        return left + op + right;
    }

    public BinaryNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
}

// variables
class Atom : Node {
    public String name;

    public Atom(string name) {
        this.name = name;
    }

    override public string ToString() {
        return name;
    }
}

// ( ... )
class Parens : Node {
    public Node child;

    public Parens(Node child) {
        this.child = child;
    }

    override public string ToString() {
        return "(" + child + ")";
    }
}

class Plus : BinaryNode {
    public Plus(Node left, Node right) : base(left, right) {
        op = "+";
    }
}

class Minus : BinaryNode {
    public Minus(Node left, Node right) : base(left, right) {
        op = "-";
    }
}

class Times : BinaryNode {
    public Times(Node left, Node right) : base(left, right) {
        op = "*";
    }
}

class Division : BinaryNode {
    public Division(Node left, Node right) : base(left, right) {
        op = "/";
    }
}

class Expo : BinaryNode {
    public Expo(Node left, Node right) : base(left, right) {
        op = "^";
    }
}
