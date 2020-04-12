package com.example.hrd.modle;

import java.util.ArrayList;

public class Checkerboard {

    private long Location;
    private long Statue;
    private long MirrorStatue;
    private char Array[][] = new char[5][4];


    public static void main(String[] args) {
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

        Checkerboard checkerboard=new Checkerboard(list);
        System.out.println(checkerboard.getLocation());
        Checkerboard checkerboard2=new Checkerboard(checkerboard.getArray());
        checkerboard.print(checkerboard2.getArray());
        System.out.println(checkerboard2.getLocation());
        Checkerboard checkerboard3=new Checkerboard(checkerboard2.getLocation());
        System.out.println(checkerboard3.getStatue());

    }


    public Checkerboard(ArrayList<Chessman> list) {
        setArray(list);
        setLocation(list);
        //print(Array);
        Statue=createStatue(getCopyArray(Array));
        MirrorStatue=createStatue(getMirrorArray(Array));
        //	System.out.println(Statue+" "+MirrorStatue);
    }

    public Checkerboard(long location) {
        Location = location;
        ArrayList<Chessman> list = new ArrayList<>();
        getList(list, location);
        setArray(list);
        Statue=createStatue(getCopyArray(Array));
        MirrorStatue=createStatue(getMirrorArray(Array));
        //print(Array);
    }

    public Checkerboard(char [][] cArray) {
        Array=cArray;
        long location=0;
        for(char c='a';c<='l';c++) {
            location=addLocation(cArray, c, location);
        }
        Location=location;
        Statue=createStatue(getCopyArray(Array));
        MirrorStatue=createStatue(getMirrorArray(Array));
    }
    private long addLocation(char cArray[][], char id,long location) {
        for(int i=0;i<5;i++) {
            for(int j=0;j<4;j++) {
                if(cArray[i][j]==id) {
                    switch (id) {
                        case 'a':
                        case 'c':
                        case 'd':
                        case 'e':
                        case 'f':
                            location*=4;
                            location+=i;
                            location*=4;
                            location+=j;
                            break;

                        default:
                            location*=8;
                            location+=i;
                            location*=4;
                            location+=j;
                            break;

                    }
                    return location;
                }
            }
        }


        return location;
    }




    private long createStatue(char [][] cArray) {
        long statue=0;
        statue=switchType(cArray, 'a', 'a', statue, 1, 1, true);
        statue=switchType(cArray, 'b', 'b', statue, 1, 0, true);
        statue=switchType(cArray, 'c', 'f', statue, 0, 1, true);
        statue=switchType(cArray, 'g', 'j', statue, 0, 0, true);
        return statue;
    }

    private long switchType(char [][] cArray,char begin,char end,long statue,int width,int height,boolean type) {
        for(int i=0;i<5;i++) {
            for(int j=0;j<4;j++) {
                if(cArray[i][j]>=begin && cArray[i][j] <=end) {
                    if(type) {
                        statue*=8;
                        statue+=i+1;
                        statue*=4;
                        statue+=j+1;
                    }else {
                        statue*=4;
                        statue+=i+1;
                        statue*=4;
                        statue+=j+1;
                    }
                    cArray[i][j]=' ';
                    cArray[i+height][j]=' ';
                    cArray[i][j+width]=' ';
                    cArray[i+height][j+width]=' ';

                }
            }
        }
        return statue;
    }






    //镜像数组
    private char[][] getMirrorArray(char [][] cArray){
        char [][] mir=new char[5][4];
        for(int i=0;i<5;i++) {
            for(int j=0;j<4;j++) {
                mir[i][j]=cArray[i][3-j];
            }
        }
        return mir;
    }
    //复制数组
    private char[][] getCopyArray(char [][] cArray){
        char [][] cop=new char[5][4];
        for(int i=0;i<5;i++) {
            for(int j=0;j<4;j++) {
                cop[i][j]=cArray[i][j];
            }
        }
        return cop;
    }







    public long getLocation() {
        return Location;
    }

    public void setLocation(long location) {
        Location = location;
    }

    public long getStatue() {
        return Statue;
    }

    public void setStatue(long statue) {
        Statue = statue;
    }

    public long getMirrorStatue() {
        return MirrorStatue;
    }

    public void setMirrorStatue(long mirrorStatue) {
        MirrorStatue = mirrorStatue;
    }

    public char[][] getArray() {
        return Array;
    }

    public void setArray(char[][] array) {
        Array = array;
    }



    private void setLocation(ArrayList<Chessman> list) {
        long location = 0;
        for (int i = 0; i < 12; i++) {
            switch (i) {
                case 0:
                case 2:
                case 3:
                case 4: // 曹操和四上将可以压缩存储
                case 5:
                    location = addLocatin(i, list, location, false);
                    break;

                default:
                    location = addLocatin(i, list, location, true);
                    break;
            }
        }
        Location = location;
    }

    private void setArray(ArrayList<Chessman> list) {
        for (int i = 0; i < list.size(); i++) {
            Chessman temp = list.get(i);
            for (int j = 0; j < temp.getHeight(); j++) {
                for (int k = 0; k < temp.getWidth(); k++) {
                    Array[temp.getX_coordinate() + j][temp.getY_coordinate() + k] = temp.getId();
                }
            }
        }
    }

    private void getList(ArrayList<Chessman> list, long location) {
        for (int i = 0; i < 12; i++) {
            switch (i) {
                case 0:
                    list.add(new Chessman(0, 0, 2, 2, (char) ('a' + i), 'a'));
                    break;
                case 1:
                    list.add(new Chessman(0, 0, 2, 1, (char) ('a' + i), 'b'));
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    list.add(new Chessman(0, 0, 1, 2, (char) ('a' + i), 'c'));
                    break;
                case 6:
                case 7:
                case 8:
                case 9:
                    list.add(new Chessman(0, 0, 1, 1, (char) ('a' + i), 'd'));
                    break;
                default:
                    list.add(new Chessman(0, 0, 1, 1, (char) ('a' + i), 'e'));
                    break;
            }
        }

        for (int i = 11; i >= 0; i--) {
            switch (i) {
                case 0:
                case 2:
                case 3:
                case 4:
                case 5:
                    location = getLocatin(i, list, location, false);
                    break;

                default:
                    location = getLocatin(i, list, location, true);
                    break;
            }
        }
    }

    private long addLocatin(int index, ArrayList<Chessman> list, long location, boolean type) {
        if (type) { // type为真时代表兵等精确坐标
            location *= 8;
            location += list.get(index).getX_coordinate();

        } else {	// type为假时代表上将的压缩坐标
            location *= 4;
            location += list.get(index).getX_coordinate();
        }
        location *= 4;
        location += list.get(index).getY_coordinate();
        return location;
    }

    private long getLocatin(int index, ArrayList<Chessman> list, long location, boolean type) {
        list.get(index).setY_coordinate((int) (location % 4));
        location /= 4;
        if (type) { // type为真时代表兵等精确坐标
            list.get(index).setX_coordinate((int) (location % 8));
            location /= 8;
        } else {
            list.get(index).setX_coordinate((int) (location % 4));
            location /= 4;
        }
        return location;
    }

    public void print(char cArray[][]) {
        for(int i=0;i<cArray.length;i++) {
            for(int j=0;j<cArray[i].length;j++) {
                System.out.print(cArray[i][j]+" ");
            }
            System.out.println();
        }
    }
}
