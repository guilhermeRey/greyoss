package org.greyoss.visitorpattern;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    int sum;
    
    public SumInLeavesVisitor() {
        this.sum = 0;
    }
    
    public int getResult() {
      	return this.sum;
    }

    public void visitNode(TreeNode node) {
      	// do nothing
    }

    public void visitLeaf(TreeLeaf leaf) {
    	System.out.println("Valor folha: " + leaf.getValue());
      	this.sum += leaf.getValue();
      	System.out.println("Soma atual: " + this.sum);
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private int product;
    
    public ProductOfRedNodesVisitor() {
        this.product = 1;
    }
    
    public int getResult() {
      	return this.product;
    }

    public void visitNode(TreeNode node) {
      	if (node.getColor() == Color.RED)
            this.product *= node.getValue();
    }

    public void visitLeaf(TreeLeaf leaf) {
    	if (leaf.getColor() == Color.RED)
    		this.product *= leaf.getValue();
    }
}

class FancyVisitor extends TreeVis {
	private int sumNonLeafEven = 0;
	private int sumGreenLeafNodes = 0;
	
    public int getResult() {
      	return Math.abs(sumNonLeafEven - sumGreenLeafNodes);
    }

    public void visitNode(TreeNode node) {
    	if (node.getDepth() % 2 == 0)
    		sumNonLeafEven += node.getValue();
    }

    public void visitLeaf(TreeLeaf leaf) {
    	if (leaf.getColor() == Color.GREEN)
    		sumGreenLeafNodes += leaf.getValue();
    }
}

class TreeBuilder {
    int     n;
    int[]   values;
    Color[] colors;
    
    LinkedList<LinkedList<Integer>> edges = new LinkedList<LinkedList<Integer>>();
    
    TreeNode root;
    
    public TreeBuilder(int n, int[] values, Color[] colors) {
        this.n = n;
        this.values = values;
        this.colors = colors;
        
        for (int i = 0; i < this.n; i++) edges.add(new LinkedList<Integer>());
    }
    
    public void addEdge(int from, int to) {
        this.edges.get(from).add(to);
    }
    
    private void buildFrom(TreeNode parent, int nodeIndex) {
        LinkedList<Integer> nodeEdges = edges.get(nodeIndex);
        
        for (int i = 0; i < nodeEdges.size(); i++) {
            Integer vi = nodeEdges.get(i);
            if (this.edges.get(vi).size() == 0)
                parent.addChild(new TreeLeaf(this.values[vi], this.colors[vi], parent.getDepth() + 1));
            else
            {
                TreeNode toAdd = new TreeNode(this.values[vi], this.colors[vi], parent.getDepth() + 1);
                parent.addChild(toAdd);
                buildFrom(toAdd, vi);
            }
        }
    }
    
    public Tree build() {
        this.root = new TreeNode(this.values[0], this.colors[0], 0);
        this.buildFrom(this.root, 0);
        
        return this.root;
    }
}

public class Solution {
  
    public static Tree solve() throws FileNotFoundException {
    	File input = new File("C:\\Users\\Grey\\Documents\\Github\\greyoss\\hacker-rank\\VisitorPattern\\src\\org\\greyoss\\visitorpattern\\test-case-1.txt");
        Scanner scanner = new Scanner(input);
        
        int     nodeCount   = scanner.nextInt();
        int[]   nodeValues  = new int[nodeCount];
        Color[] nodeColors  = new Color[nodeCount];
        
        for (int i = 0; i < nodeCount; i++)
            nodeValues[i] = scanner.nextInt();
        
        for (int i = 0; i < nodeCount; i++)
            nodeColors[i] = scanner.nextInt() == 0 ? Color.RED : Color.GREEN;
        
        TreeBuilder builder = new TreeBuilder(nodeCount, nodeValues, nodeColors);
        for (int j = 0; j < nodeCount - 1; j++) {
        	int u = scanner.nextInt() - 1;
        	int v = scanner.nextInt() - 1;
            builder.addEdge(u, v);
            builder.addEdge(v, u);
        }
        
        scanner.close();
        Tree myTree = builder.build();
        return myTree;
    }   
    
    public static void main(String[] args) throws FileNotFoundException {
      	Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
	}
}