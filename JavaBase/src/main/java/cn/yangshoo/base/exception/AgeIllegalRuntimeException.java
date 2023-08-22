package cn.yangshoo.base.exception;

/**
 * @author ： YangHaichuan
 * @version :  1.0.0
 * @date ： 22/8/2023
 */
//自定义运行时异常
public class AgeIllegalRuntimeException extends RuntimeException{
    //重写构造器
    public AgeIllegalRuntimeException() {
    }
    //重写构造器
    public AgeIllegalRuntimeException(String message) {
        super(message);
    }
}
