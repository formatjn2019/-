package com.example.hrd.Control;

import com.example.hrd.modle.Checkerboard;
import com.example.hrd.modle.Chessman;
import com.example.hrd.modle.Step;
import com.example.hrd.modle.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class CreateTree {


    ArrayList<Long> statuslist = new ArrayList<>();
    TreeNode Root;
    TreeNode EndNode;
    int breakNum = 0;

    public static void main(String[] args) {
        ArrayList<Chessman> list = new ArrayList<>();
        list = addList2();
        CreateTree cTree = new CreateTree(list);
        TreeNode node = cTree.EndNode;
        Stack<TreeNode> Result = new Stack<>();
        Result.add(node);
        while (node.getFather() != null) {
            node = node.getFather();
            Result.add(node);
        }
        Checkerboard ck;
        while(!Result.isEmpty()) {
            ck=new Checkerboard(Result.pop().getLocation());
            ck.print(ck.getArray());
            System.out.println();
        }



//		for(TreeNode temp:Result) {
//			temp.printLocation();
//		}
//		while (!Result.isEmpty()) {
//			Result.pop().printLocation();
//		}
//		System.out.println(list.size());
    }

    private static ArrayList<Chessman> addList() {
        ArrayList<Chessman> list;
        Chessman caoChao = new Chessman(3, 0, 2, 2, 'a', 'a');
        Chessman guanYu = new Chessman(2, 2, 2, 1, 'b', 'b');
        Chessman zhangFei = new Chessman(0, 3, 1, 2, 'c', 'c');
        Chessman huangZhong = new Chessman(0, 1, 1, 2, 'd', 'c');
        Chessman maChao = new Chessman(0, 0, 1, 2, 'e', 'c');
        Chessman zhaoYuan = new Chessman(0, 2, 1, 2, 'f', 'c');
        Chessman bing1 = new Chessman(2, 0, 1, 1, 'g', 'd');
        Chessman bing2 = new Chessman(2, 1, 1, 1, 'h', 'd');
        Chessman bing3 = new Chessman(3, 3, 1, 1, 'i', 'd');
        Chessman bing4 = new Chessman(4, 3, 1, 1, 'j', 'd');
        list = new ArrayList<>();
        list.add(caoChao);
        list.add(guanYu);
        list.add(zhangFei);
        list.add(huangZhong);
        list.add(maChao);
        list.add(zhaoYuan);
        list.add(bing4);
        list.add(bing3);
        list.add(bing2);
        list.add(bing1);
        return list;
    }

    /* 横刀立马 */
    private static ArrayList<Chessman> addList2() {
        ArrayList<Chessman> list;
        Chessman caoChao = new Chessman(0, 1, 2, 2, 'a', 'a');
        Chessman guanYu = new Chessman(3, 1, 2, 1, 'b', 'b');
        Chessman zhangFei = new Chessman(0, 0, 1, 2, 'c', 'c');
        Chessman huangZhong = new Chessman(0, 3, 1, 2, 'd', 'c');
        Chessman maChao = new Chessman(2, 0, 1, 2, 'e', 'c');
        Chessman zhaoYuan = new Chessman(2, 3, 1, 2, 'f', 'c');
        Chessman bing1 = new Chessman(4, 0, 1, 1, 'g', 'd');
        Chessman bing2 = new Chessman(4, 1, 1, 1, 'h', 'd');
        Chessman bing3 = new Chessman(4, 2, 1, 1, 'i', 'd');
        Chessman bing4 = new Chessman(4, 3, 1, 1, 'j', 'd');
        Chessman kong1 = new Chessman(2, 1, 1, 1, 'k', 'e');
        Chessman kong2 = new Chessman(2, 2, 1, 1, 'l', 'e');
        list = new ArrayList<>();
        list.add(caoChao);
        list.add(guanYu);
        list.add(zhangFei);
        list.add(huangZhong);
        list.add(maChao);
        list.add(zhaoYuan);
        list.add(bing1);
        list.add(bing2);
        list.add(bing3);
        list.add(bing4);
        list.add(kong1);
        list.add(kong2);
        return list;
    }

    /* 横刀立马接近解 */
    private static ArrayList<Chessman> addList3() {
        ArrayList<Chessman> list;
        Chessman caoChao = new Chessman(2, 0, 2, 2, 'a', 'a');
        Chessman guanYu = new Chessman(3, 2, 2, 1, 'b', 'b');
        Chessman zhangFei = new Chessman(0, 0, 1, 2, 'c', 'c');
        Chessman huangZhong = new Chessman(0, 1, 1, 2, 'd', 'c');
        Chessman maChao = new Chessman(0, 2, 1, 2, 'e', 'c');
        Chessman zhaoYuan = new Chessman(0, 3, 1, 2, 'f', 'c');
        Chessman bing1 = new Chessman(2, 2, 1, 1, 'g', 'd');
        Chessman bing2 = new Chessman(2, 3, 1, 1, 'h', 'd');
        Chessman bing3 = new Chessman(4, 2, 1, 1, 'i', 'd');
        Chessman bing4 = new Chessman(4, 3, 1, 1, 'j', 'd');

        list = new ArrayList<>();
        list.add(caoChao);
        list.add(guanYu);
        list.add(zhangFei);
        list.add(huangZhong);
        list.add(maChao);
        list.add(zhaoYuan);
        list.add(bing4);
        list.add(bing3);
        list.add(bing2);
        list.add(bing1);
        return list;
    }

    public CreateTree(ArrayList<Chessman> list) {
        Root = new TreeNode(list, statuslist);
        Stack<TreeNode> NodeStack = new Stack<>();
        NodeStack.add(Root);
        EndNode = createLayerTree(NodeStack);
    }

    public TreeNode createLayerTree(Stack<TreeNode> father) {
        Stack<TreeNode> treeNodeStack = new Stack<>(); // 栈，记录下一层的第一孩子节点
        int deepth = 0;
        while (!father.isEmpty()) {
            TreeNode temp = father.pop(); // 子节点出栈
            deepth = temp.getDeepth();
            if (!temp.isAddChildren()) {
                continue;
            } else {
                Stack<Step> stepStack = temp.getAllStep(); // 获取父节点的所有步骤
                while (!stepStack.isEmpty()) {
                    Step steptemp = stepStack.pop();
//					System.out.println("\n"+steptemp.getId()+" "+steptemp.getDir()+" "+steptemp.getLength()+"\n");
                    TreeNode children = createNode(temp, steptemp);
                    treeNodeStack.add(children);
//					System.out.println(children.getLocation());
//					System.out.println(children.getFather().getLocation());
//					if(children.getFather().getFather()!=null) {
//						System.out.println(children.getFather().getFather().getLocation());
//					}

                    if (children.isEndNode()) {
                        return children;
                    }

                }

            }

        }
        System.out.println(deepth + "层");
        System.out.println("记录了" + statuslist.size() + "种状态");
        return createLayerTree(treeNodeStack);
    }

    public TreeNode createNode(TreeNode father, Step step) {
        TreeNode node = new TreeNode(father, father.getDeepth() + 1, statuslist, step);
        return node;
    }
}
