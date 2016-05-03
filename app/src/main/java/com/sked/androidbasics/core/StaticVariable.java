package com.sked.androidbasics.core;

/**
 * Created by manish on 2/9/2016.
 */
class StaticVariable {
    int a;
    static int b;
    void get(int c){
        a=c;
        ++b;

    }
    void show(){
        System.out.println(a+""+b);
    }
}
class y
{
    public static void main(String args[])
    {
        StaticVariable obj1= new StaticVariable();
        obj1.get(50);
        StaticVariable obj2=new StaticVariable();
        obj2.get(60);
        StaticVariable obj3=new StaticVariable();
        obj3.get(70);


        obj1.show();
        obj2.show();
        obj3.show();
    }
}
