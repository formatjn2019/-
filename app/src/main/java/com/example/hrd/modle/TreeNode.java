package com.example.hrd.modle;

import java.util.ArrayList;
import java.util.Stack;


public class TreeNode {
    TreeNode Father;
    int Deepth;
    long Location;
    boolean AddChildren = true;
    boolean EndNode=false;
    public TreeNode() {

    }
    public static void main(String[] args) {
	/*	ArrayList<Chessman> list;
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
		ArrayList <Long> statuelist=new ArrayList<>();
		System.out.println("\n根节点");
		TreeNode tNode=new TreeNode(list,statuelist);
	//	ArrayList<Step>sl=tNode.getAllStep();
	//	System.out.println(sl.size());
		System.out.println("\n上移");
		TreeNode t2=new TreeNode(tNode,1,statuelist,new Step('b', Direction.UP, 1));
	//=t2.getAllStep();
	//	System.out.println(sl.size());
		System.out.println("\n上移");
		TreeNode t3=new TreeNode(t2,2,statuelist,new Step('h', Direction.UP, 1));
		System.out.println("\n右移");
		TreeNode t4=new TreeNode(t3,2,statuelist,new Step('h', Direction.RINGHT, 1));
		System.out.println("\n左移");
		TreeNode t5=new TreeNode(t4,2,statuelist,new Step('i', Direction.LEFT, 1));
		System.out.println("\n上移");
		TreeNode t6=new TreeNode(t5,2,statuelist,new Step('i', Direction.UP, 1));
		System.out.println(t6.getLocation());
		System.out.println("\n右移2");
		TreeNode t7=new TreeNode(t6,2,statuelist,new Step('g', Direction.RINGHT, 2));
		System.out.println("\n左移2");
		TreeNode t8=new TreeNode(t7,2,statuelist,new Step('g', Direction.LEFT, 2));
		System.out.println(t8.getLocation());
	//	sl=t8.getAllStep();
	//	System.out.println(sl.size());
*/
        ArrayList<Long> sl=new ArrayList<>();
        TreeNode boot=new TreeNode();
        boot.setLocation(2886092950260179l);
        Stack<Step> s=boot.getAllStep();
        ArrayList<TreeNode> tList=new ArrayList<>();
        Step steptemp;
        while(!s.isEmpty()) {
            steptemp=s.pop();
            System.out.println("\n"+steptemp.getId()+" "+steptemp.getDir()+" "+steptemp.getLength()+"\n");
            System.out.println(new TreeNode(boot, 1, sl, steptemp).getLocation());
        }





    }
    /*创建普通节点*/
    public TreeNode(TreeNode father, int deepth, ArrayList<Long> statusList,Step step) {
        Father = father;
        Deepth = deepth;
        Checkerboard ck=new Checkerboard(father.getLocation());
        char cArray[][]=ck.getArray();
        long statue=0;
//		System.out.println("移动前");
//		ck.print(cArray);
//		System.out.println();
        moveChessman(cArray, step);
//		System.out.println("移动后");
//		ck.print(cArray);
//		System.out.println();
        Checkerboard ck2=new Checkerboard(cArray);
        statue=ck2.getStatue();
//		System.out.println(statue);
//		statue=ck2.getLocation();
        Location=ck2.getLocation();
//
        for (long temp : statusList) {
            if (temp==statue) {
                AddChildren = false;
                break;
            }
        }
        if (AddChildren) {
            statusList.add(statue);
//			System.out.println(statue);
            long mirror=ck2.getMirrorStatue();
            if(mirror!=statue) {
                statusList.add(ck2.getMirrorStatue());
            }
        }
        EndNode=judgeEndNode(cArray);
    }
    /*创建根节点*/
    public TreeNode(ArrayList<Chessman> list, ArrayList<Long> statusList) {
        Deepth = 0;
        Father=null;
        long statue=0;
        Checkerboard ck2=new Checkerboard(list);
        statue=ck2.getStatue();
        char cArray[][]=ck2.getArray();
        Location=ck2.getLocation();
        for (long temp : statusList) {
            if (temp==statue) {
                AddChildren = false;
                break;
            }
        }
        if (AddChildren) {
            statusList.add(statue);
            long mirror=ck2.getMirrorStatue();
            if(mirror!=statue) {
                statusList.add(ck2.getMirrorStatue());
            }
        }
        EndNode=judgeEndNode(cArray);



    }
    private void moveChessman(char[][] cArray, Step step) {
        int movX = 0, movY = 0; // x,y移动坐标
        int width = 1, height = 1; // 宽,高
        switch (step.Dir) {
            case UP:
                movX = -1;
                break;
            case DOWN:
                movX = 1;
                break;
            case LEFT:
                movY = -1;
                break;
            default:
                movY = 1;
                break;
        }
        if (step.Id <= 'b') {
            width = 2;
        }
        if (step.Id != 'b' && step.Id <= 'f') {
            height = 2;
        }
        char t1, t2;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                if (cArray[i][j] == step.Id) {
                    if (step.Length == 1) {
                        switch (step.Dir) {
                            case UP: // 向上移动
                                t1 = cArray[i + movX][j];
                                t2 = cArray[i + movX][j + width - 1];
                                movewrite(cArray, movX, movY, width, height, i, j, step.Length, step.Id);
                                cArray[i + height - 1][j] = t1;
                                cArray[i + height - 1][j + width - 1] = t2;
                                break;
                            case DOWN:
                                t1 = cArray[i + height - 1 + movX][j];
                                t2 = cArray[i + height - 1 + movX][j + width - 1];
                                movewrite(cArray, movX, movY, width, height, i, j, step.Length, step.Id);
                                cArray[i][j] = t1;
                                cArray[i][j + width - 1] = t2;
                                break;
                            case LEFT:
                                t1 = cArray[i][j - 1];
                                t2 = cArray[i + height - 1][j - 1];
                                movewrite(cArray, movX, movY, width, height, i, j, step.Length, step.Id);
                                cArray[i][j + width - 1] = t1;
                                cArray[i + height - 1][j + width - 1] = t2;
                                break;
                            default:
                                t1 = cArray[i][j + width - 1 + 1];
                                t2 = cArray[i + height - 1][j + width - 1 + 1];
                                movewrite(cArray, movX, movY, width, height, i, j, step.Length, step.Id);
                                cArray[i][j] = t1;
                                cArray[i + height - 1][j] = t2;
                                break;
                        }
                    } else {
                        switch (step.Dir) {
                            case UP: // 向上移动
                                t1 = cArray[i - 2][j];
                                t2 = cArray[i - 1][j];
                                movewrite(cArray, movX, movY, width, height, i, j, step.Length, step.Id);
                                cArray[i + height - 2][j] = t1;
                                cArray[i + height - 2 + 1][j] = t2;
                                break;
                            case DOWN:
                                t1 = cArray[i + height - 1 + 1][j];
                                t2 = cArray[i + height - 1 + 2][j];
                                movewrite(cArray, movX, movY, width, height, i, j, step.Length, step.Id);
                                cArray[i][j] = t1;
                                cArray[i +1][j] = t2;
                                break;
                            case LEFT:
                                t1 = cArray[i][j - 2];
                                t2 = cArray[i][j - 1];
                                movewrite(cArray, movX, movY, width, height, i, j, step.Length, step.Id);
                                cArray[i][j + width - 2] = t1;
                                cArray[i][j + width-1] = t2;
                                break;
                            default:
                                t1 = cArray[i][j + width];
                                t2 = cArray[i][j + width+1];
                                movewrite(cArray, movX, movY, width, height, i, j, step.Length, step.Id);
                                cArray[i][j] = t1;
                                cArray[i][j+1] = t2;
                                break;

                        }

                    }

                    return;
                }
            }
        }

    }

    private void movewrite(char[][] cArray, int movX, int movY, int width, int height, int i, int j, int Length,
                           char c) {
        for (int k = 0; k < height; k++) { // 清空原位置
            for (int l = 0; l < width; l++) {
                cArray[i + k][j + l] = ' ';
            }
        }
        for (int k = 0; k < height; k++) { // 新位置写入
            for (int l = 0; l < width; l++) {
                cArray[i + movX * Length + k][j + movY * Length + l] = c;
            }
        }
    }

    public Stack<Step> getAllStep() {
        Stack<Step> stepStack = new Stack();
        Checkerboard ck = new Checkerboard(Location);
        char cArray[][] = ck.getArray();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                if (cArray[i][j] > 'j') {
                    if (i > 0) { // 上方不越界
                        if (cArray[i - 1][j] > 'b' && cArray[i - 1][j] <= 'j') { // 宽为一
                            stepStack.add(new Step(cArray[i - 1][j], Step.Direction.DOWN, 1));
                            if (i < 4 && cArray[i + 1][j] > 'j') {
                                stepStack.add(new Step(cArray[i - 1][j], Step.Direction.DOWN, 2));
                            }
                        } else { // 宽为2
                            if (j < 3 && cArray[i - 1][j] == cArray[i - 1][j + 1]) {
                                if (cArray[i][j + 1] > 'j') {
                                    stepStack.add(new Step(cArray[i - 1][j], Step.Direction.DOWN, 1));
                                }
                            }
                        }

                    }
                    if (i < 4) { // 下方不越界
                        if (cArray[i + 1][j] > 'b' && cArray[i + 1][j] <= 'j') { // 宽为一
                            stepStack.add(new Step(cArray[i + 1][j], Step.Direction.UP, 1));
                            if (i > 0 && cArray[i - 1][j] > 'j') {
                                stepStack.add(new Step(cArray[i + 1][j], Step.Direction.UP, 2));
                            }
                        } else { // 宽为2
                            if (j < 3 && cArray[i + 1][j] == cArray[i + 1][j + 1]) {
                                if (cArray[i][j + 1] > 'j') {
                                    stepStack.add(new Step(cArray[i + 1][j], Step.Direction.UP, 1));
                                }
                            }
                        }

                    }
                    if (j > 0) { // 左方不越界
                        if ((cArray[i][j - 1] >= 'g' && cArray[i][j - 1] <= 'j') || cArray[i][j - 1] == 'b') { // 高为一
                            stepStack.add(new Step(cArray[i][j - 1], Step.Direction.RINGHT, 1));
                            if (j < 3 && cArray[i][j + 1] > 'j') {
                                stepStack.add(new Step(cArray[i][j - 1], Step.Direction.RINGHT, 2));
                            }
                        } else { // 高为2
                            if (i < 4 && cArray[i][j - 1] == cArray[i + 1][j - 1]) {
                                if (cArray[i + 1][j] > 'j') {
                                    stepStack.add(new Step(cArray[i][j - 1], Step.Direction.RINGHT, 1));
                                }
                            }
                        }

                    }
                    if (j < 3) { // 右方不越界
                        if ((cArray[i][j + 1] >= 'g' && cArray[i][j + 1] <= 'j') || cArray[i][j + 1] == 'b') { // 高为一
                            stepStack.add(new Step(cArray[i][j + 1], Step.Direction.LEFT, 1));
                            if (j > 0 && cArray[i][j - 1] > 'j') {
                                stepStack.add(new Step(cArray[i][j + 1], Step.Direction.LEFT, 2));
                            }
                        } else { // 高为2
                            if (i < 4 && cArray[i][j + 1] == cArray[i + 1][j + 1]) {
                                if (cArray[i + 1][j] > 'j') {
                                    stepStack.add(new Step(cArray[i][j + 1], Step.Direction.LEFT, 1));
                                }
                            }
                        }

                    }
                }
            }
        }

        return stepStack;
    }



    public boolean judgeEndNode(char cArray[][]) {
        if (cArray[3][1] == 'a' && cArray[3][2] == 'a' && cArray[4][1] == 'a' && cArray[4][2] == 'a') {
            return true;
        }
        return false;
    }

    public TreeNode getFather() {
        return Father;
    }

    public void setFather(TreeNode father) {
        Father = father;
    }


    public int getDeepth() {
        return Deepth;
    }

    public void setDeepth(int deepth) {
        Deepth = deepth;
    }

    public long getLocation() {
        return Location;
    }

    public void setLocation(long location) {
        Location = location;
    }

    public boolean isAddChildren() {
        return AddChildren;
    }

    public void setAddChildren(boolean addChildren) {
        AddChildren = addChildren;
    }

    public boolean isEndNode() {
        return EndNode;
    }

    public void setEndNode(boolean endNode) {
        EndNode = endNode;
    }
}
