package com.example.hrd.modle;

public class Step {
    public enum Direction{
        UP,DOWN,LEFT,RINGHT
    }
    char Id;
    Direction Dir;
    int Length;
    public Step(char id, Direction dir, int length) {
        super();
        Id = id;
        Dir = dir;
        Length = length;
    }

    public char getId() {
        return Id;
    }
    public void setId(char id) {
        Id = id;
    }
    public Direction getDir() {
        return Dir;
    }
    public void setDir(Direction dir) {
        Dir = dir;
    }
    public int getLength() {
        return Length;
    }
    public void setLength(int length) {
        Length = length;
    }
}
