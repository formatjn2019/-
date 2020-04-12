package com.example.hrd.modle;

public class Chessman {

    public void setWidth(int width) {
        Width = width;
    }

    public void setHeight(int height) {
        Height = height;
    }

    public void setId(char id) {
        this.id = id;
    }

    public void setType(char type) {
        Type = type;
    }

    int X_coordinate;
    int Y_coordinate;
    int Width;
    int Height;
    char id;
    char Type = ' ';

    public int getWidth() {
        return Width;
    }

    public int getHeight() {
        return Height;
    }

    public int getX_coordinate() {
        return X_coordinate;
    }

    public void setX_coordinate(int x_coordinate) {
        X_coordinate = x_coordinate;
    }

    public int getY_coordinate() {
        return Y_coordinate;
    }

    public void setY_coordinate(int y_coordinate) {
        Y_coordinate = y_coordinate;
    }

    public Chessman(int x_coordinate, int y_coordinate, int width, int height, char id, char type) {
        super();
        X_coordinate = x_coordinate;
        Y_coordinate = y_coordinate;
        Width = width;
        Height = height;
        this.id = id;
        Type = type;
    }

    public Chessman() {

    }

    public char getId() {
        return id;
    }

    public char getType() {
        return Type;
    }
}
