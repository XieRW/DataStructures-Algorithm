package com.xrw.tree;

import java.util.Stack;

/**
 * @program: DataStructures
 * @description: 二叉树的建立与遍历
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-04-26 19:51
 **/
public class BinaryTreeTest {
    public static void main(String[] args) {
        String pre = "ABC##DE#G##F###";
        System.out.printf("创建二叉树的前序字符串为：%s\n",pre);
        Stack<String> stack = new Stack<>();
        int i = pre.length()-1;
        System.out.print("将字符串存放到栈中：");
        for (;i>=0;i--){
            stack.push(pre.substring(i,i+1));
        }
        String[] objects = new String[stack.size()];
        objects = stack.toArray(objects);
        for (String s: objects){
            System.out.print(s);
        }
        System.out.println();
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.binaryTreeByPre(stack);

        System.out.println("二叉树的前序遍历为：");
        binaryTree.listByPre();
        System.out.println();

        System.out.println("二叉树的中序遍历为：");
        binaryTree.listByInfix();
        System.out.println();

        System.out.println("二叉树的后序遍历为：");
        binaryTree.listByPost();
        System.out.println();

        System.out.printf("二叉树的深度为：%d\n",binaryTree.deep());

        System.out.println("二叉树叶子节点为：");
        System.out.printf("二叉树叶子节点个数为：%d\n",binaryTree.leafNode());

        System.out.println("前序非递归遍历二叉树：");
        binaryTree.listByPreWithNonRecursive();
        System.out.println();

        System.out.println("中序非递归遍历二叉树：");
        binaryTree.listByInfixWithNonRecursive();
        System.out.println();

        System.out.println("后序非递归遍历二叉树：");
        binaryTree.listByPostWithNonRecursive();
        System.out.println();

    }
}

class BinaryTree{
    TreeNode rootNode;

    public BinaryTree(){
        this.rootNode = new TreeNode("root");
    }

    public BinaryTree binaryTreeByPre(Stack<String> stack){
        if (stack.isEmpty() || "#".equals(stack.peek())){
            return this;
        }else {
            rootNode = new TreeNode(stack.pop());
            rootNode.createByPre(stack);
            return this;
        }
    }

    public void listByPre(){
        rootNode.listByPre();
    }

    public void listByInfix(){
        rootNode.listByInfix();
    }

    public void listByPost(){
        rootNode.listByPost();
    }

    public int deep(){
        return rootNode.deep();
    }

    public int leafNode(){
        return rootNode.leftNode();
    }

    public void listByPreWithNonRecursive(){
        rootNode.listByPreWithNonRecursive();
    }

    public void listByInfixWithNonRecursive(){
        rootNode.listByInfixWithNonRecursive();
    }

    public void listByPostWithNonRecursive(){
        rootNode.listByPostWithNonRecursive();
    }
}

class TreeNode{
    String data;
    TreeNode left;
    TreeNode right;

    public TreeNode(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return data;
    }

    public void createByPre(Stack<String> stack){
        if (stack.empty()){
            return;
        }

        if (!"#".equals(stack.peek())){
            this.left = new TreeNode(stack.pop());
            this.left.createByPre(stack);
        }else {
            stack.pop();
        }

        if (stack.empty()){
            return;
        }

        if (!"#".equals(stack.peek())){
            this.right = new TreeNode(stack.pop());
            this.right.createByPre(stack);
        }else {
            stack.pop();
        }
    }

    public void listByPre(){
        System.out.print(this);
        if (left != null){
            left.listByPre();
        }
        if (right != null){
            right.listByPre();
        }
    }

    public void listByInfix(){
        if (left != null){
            left.listByInfix();
        }
        System.out.print(this);
        if (right != null){
            right.listByInfix();
        }
    }

    public void listByPost(){
        if (left != null){
            left.listByPost();
        }
        if (right != null){
            right.listByPost();
        }
        System.out.print(this);
    }

    public int deep(){
        int deep = 1;
        if (left == null && right == null){
        }else if (left == null){
            deep += right.deep();
        }else if (right == null){
            deep += left.deep();
        }else {
            int sonDeep = Math.max(left.deep(), right.deep());
            deep += sonDeep;
        }
        return deep;
    }

    public int leftNode(){
        int num = 0;
        if (left == null && right == null){
            System.out.println(this);
            num = 1;
        }else if (left == null){
            num += right.leftNode();
        }else if (right == null){
            num += left.leftNode();
        }else {
            num += left.leftNode();
            num += right.leftNode();
        }
        return num;
    }

    public void listByPreWithNonRecursive(){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(this);
        TreeNode temp;

        while (!stack.isEmpty()){
            temp = stack.pop();
            System.out.print(temp.data);
            if (temp.right != null){
                stack.push(temp.right);
            }
            if (temp.left != null){
                stack.push(temp.left);
            }
        }
    }

    public void listByInfixWithNonRecursive(){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(this);
        TreeNode temp;

        while (!stack.isEmpty()){
            temp = stack.peek();
            while (temp.left != null){
                stack.push(temp.left);
                temp = temp.left;
            }
            temp = stack.pop();
            System.out.print(temp.data);
            while (temp.right == null && !stack.empty()){
                temp = stack.pop();
                System.out.print(temp.data);
            }
            if (temp.right != null){
                stack.push(temp.right);
            }
        }
    }

    public void listByPostWithNonRecursive(){
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack.push(this);
        TreeNode temp;

        while (!stack.isEmpty()){
            temp = stack.pop();
            stack2.push(temp);
            if (temp.left != null){
                stack.push(temp.left);
            }
            if (temp.right != null){
                stack.push(temp.right);
            }
        }

        while (!stack2.isEmpty()){
            System.out.print(stack2.pop());
        }
    }
}