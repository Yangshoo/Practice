## Lambda表达式
    作用：用于简化匿名内部类的代码写法

    格式：(被重写方法的形参列表)->{
        被重写方法的方法体代码
    }

    注意：lambda表达式并不是说能简化全部匿名内部类的写法， 
         只能简化函数式接口（接口只有一个抽象方法）的匿名内部类
    
    省略规则：参数类型可以省略不写
            如果只有一个参数，参数类型可以省略，同时()也可以省略
            如果Lambda表达式中的方法体代码只有一行，可以省略大括号，同时省略分号
            
```java
interface interfaceTest(){
    void go(){
        
    }
}

public class Test(){
    interfaceTest it = () -> {
        System.out.println("test lambda");
    };
}
```