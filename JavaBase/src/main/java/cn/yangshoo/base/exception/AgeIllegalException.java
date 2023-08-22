package cn.yangshoo.base.exception;

/**
 * @author ： YangHaichuan
 * @version :  1.0.0
 * @date ： 22/8/2023
 */
//自定义编译时异常
public class AgeIllegalException extends Exception{
    public AgeIllegalException() {
    }

    public AgeIllegalException(String message) {
        super(message);
    }
}
