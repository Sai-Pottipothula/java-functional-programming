package com.java.lambda;

interface shape{
    public void draw();
}

class square implements shape{
    @Override
    public void draw() {
        System.out.println("Shape should be square");
    }
}
class rectangle implements shape{
    @Override
    public void draw() {
        System.out.println("Shape should be rectangle");
    }
}
class circle implements shape{
    @Override
    public void draw() {
        System.out.println("Shape should be circle");
    }
}
public class LambdaExample {
    public static void main(String[] args) {
        shape obj = new rectangle();
        obj.draw();

        shape obj1 = ()->{
            System.out.println("Shape should be hexagon");
        };
        obj1.draw();
    }
}
