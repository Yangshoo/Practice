## 泛型
    建议命名：E、T、K、V

#### 泛型类

```java
public class MyClass<E extends T>{
    
}

//声明MyClass泛型类必须为：T或T的子类
```

#### 泛型接口
```java
//接口
public class DataInterface<T> {
    void add(T t);
    ArrarList<T> getByName(String name); 
}

//实现
public class DataInterfaceImpl implements DataInterface<Band>{
    @Override
    public void add(Band band){
        
    }
    
    @Override
    public ArrayList<Band> getByName(String name){
        
    }
}
```

#### 泛型方法
修饰符<类型变量,类型变量, ...> 返回值类型 方法名(形参列表){

}

```java
import java.util.ArrayList;

public class Test {
    //泛型方法
    public static <T> void genericMethod(T t) {
    }

    // ? 通配符，在使用泛型的时候可以代表一切类型
    // ? extends (上限类), ? super (下限类)
    public static void go(ArrayList<?> params){

    }
}

```