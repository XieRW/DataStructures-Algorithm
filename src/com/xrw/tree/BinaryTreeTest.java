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

/**
 * @Description: 二叉树
 * @Author: 谢荣旺
 * @Date: 2021/4/27
 */
class BinaryTree{
    /**
     * 二叉树的根节点
     */
    TreeNode rootNode;

    /**
     * @Description: 构造方法，创建一个默认根节点的二叉树
     * @Author: 谢荣旺
     * @Date: 2021/4/27
     */
    public BinaryTree(){
        this.rootNode = new TreeNode("root");
    }

    /**
     * @Description: 通过前序的字符串序列构造出来的栈创建一个二叉树，字符串中空子树用#代替
     * @param stack: 字符串序列构造的栈
     * @return: com.xrw.tree.BinaryTree
     * @Author: 谢荣旺
     * @Date: 2021/4/27
     */
    public BinaryTree binaryTreeByPre(Stack<String> stack){
        if (stack.isEmpty() || "#".equals(stack.peek())){
            return this;
        }else {
            rootNode = new TreeNode(stack.pop());
            rootNode.createByPre(stack);
            return this;
        }
    }

    /**
     * 递归先序遍历
     */
    public void listByPre(){
        rootNode.listByPre();
    }

    /**
     * 递归中序遍历
     */
    public void listByInfix(){
        rootNode.listByInfix();
    }

    /**
     * 递归后续遍历
     */
    public void listByPost(){
        rootNode.listByPost();
    }

    /**
     * 求树的深度
     * @return
     */
    public int deep(){
        return rootNode.deep();
    }

    /**
     * 求树的叶子节点个数，并打印出叶子节点
     * @return
     */
    public int leafNode(){
        return rootNode.leftNode();
    }

    /**
     * @Description: 树的非递归先序遍历
     * @Author: 谢荣旺
     * @Date: 2021/4/27
     */
    public void listByPreWithNonRecursive(){
        rootNode.listByPreWithNonRecursive();
    }

    /**
     * @Description: 树的非递归中序遍历
     * @Author: 谢荣旺
     * @Date: 2021/4/27
     */
    public void listByInfixWithNonRecursive(){
        rootNode.listByInfixWithNonRecursive();
    }

    /**
     * @Description: 树的非递归后序遍历
     * @Author: 谢荣旺
     * @Date: 2021/4/27
     */
    public void listByPostWithNonRecursive(){
        rootNode.listByPostWithNonRecursive();
    }
}

/**
 * @Description: 二叉树结点类
 * @Author: 谢荣旺
 * @Date: 2021/4/27
 */
class TreeNode{
    /**
     * 结点数据
     */
    String data;
    /**
     * 左子树
     */
    TreeNode left;
    /**
     * 右子树
     */
    TreeNode right;

    /**
     * @Description: 构造函数，构造一个无子树的结点
     * @param data: 结点的数据
     * @Author: 谢荣旺
     * @Date: 2021/4/27
     */
    public TreeNode(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return data;
    }

    /**
     * @Description: 通过前序的字符串序列构造出来的栈创建一个二叉树，字符串中空子树用#代替
     * @param stack: 字符串序列构造的栈
     * @return: com.xrw.tree.BinaryTree
     * @Author: 谢荣旺
     * @Date: 2021/4/27
     */
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

    /**
     * 递归先序遍历
     */
    public void listByPre(){
        System.out.print(this);
        if (left != null){
            left.listByPre();
        }
        if (right != null){
            right.listByPre();
        }
    }

    /**
     * 递归中序遍历
     */
    public void listByInfix(){
        if (left != null){
            left.listByInfix();
        }
        System.out.print(this);
        if (right != null){
            right.listByInfix();
        }
    }

    /**
     * 递归后续遍历
     */
    public void listByPost(){
        if (left != null){
            left.listByPost();
        }
        if (right != null){
            right.listByPost();
        }
        System.out.print(this);
    }

    /**
     * 求树的深度
     * @return
     */
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

    /**
     * 求树的叶子节点个数，并打印出叶子节点
     * @return
     */
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

    /**
     * @Description: 树的非递归先序遍历
     * @Author: 谢荣旺
     * @Date: 2021/4/27
     */
    public void listByPreWithNonRecursive(){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(this);
        TreeNode temp;

        while (!stack.isEmpty()){
            //根节点直接输出
            temp = stack.pop();
            System.out.print(temp.data);
            //要先访问左子树，故把右子树先加入栈中
            if (temp.right != null){
                stack.push(temp.right);
            }
            if (temp.left != null){
                stack.push(temp.left);
            }
        }
    }

    /**
     * @Description: 树的非递归中序遍历
     * @Author: 谢荣旺
     * @Date: 2021/4/27
     */
    public void listByInfixWithNonRecursive(){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(this);
        TreeNode temp;

        while (!stack.isEmpty()){
            temp = stack.peek();
            //先找到最左边的节点
            while (temp.left != null){
                stack.push(temp.left);
                temp = temp.left;
            }
            //最左边一定不含有左子树，故可以直接出栈输出
            temp = stack.pop();
            System.out.print(temp.data);
            //遍历栈顶，如果栈顶节点没有右子树，则直接出栈输出
            while (temp.right == null && !stack.empty()){
                temp = stack.pop();
                System.out.print(temp.data);
            }
            //如果刚出栈的元素有右子树，则将右子树将入栈
            if (temp.right != null){
                stack.push(temp.right);
            }
        }
    }

    /**
     * @Description: 树的非递归后序遍历
     * 思路：先访问树的根节点，再访问数的右子树，最后访问数的左子树，然后把结果利用栈倒序输出
     * @Author: 谢荣旺
     * @Date: 2021/4/27
     */
    public void listByPostWithNonRecursive(){
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack.push(this);
        TreeNode temp;

        while (!stack.isEmpty()){
            temp = stack.pop();
            stack2.push(temp);
            //要先访问右子树，故先将左子树入栈
            if (temp.left != null){
                stack.push(temp.left);
            }
            if (temp.right != null){
                stack.push(temp.right);
            }
        }

        //通过栈，将遍历的结果反向输出
        while (!stack2.isEmpty()){
            System.out.print(stack2.pop());
        }
    }
}