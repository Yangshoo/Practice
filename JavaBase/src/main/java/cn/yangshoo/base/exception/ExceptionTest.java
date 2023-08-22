package cn.yangshoo.base.exception;

/**
 * @author ： YangHaichuan
 * @version :  1.0.0
 * @date ： 22/8/2023
 */
public class ExceptionTest {
    public static void main(String[] args) {
        //接受异常
        try {
            saveAgeThrowRuntimeException(27);
            System.out.println("底层执行成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("底层出现bug");
        }

        try {
            saveAgeThrowException(24);
        } catch (AgeIllegalException e) {
            e.printStackTrace();
        }

    }


    public static void saveAgeThrowRuntimeException(int age){
        if (age > 0 && age <150){
            System.out.println("Legal age.");
        }else {
            // 用自定义异常来封装问题
            // throw 抛出去这个异常对象
            throw new AgeIllegalRuntimeException("Illegal age!");
        }
    }

    public static void saveAgeThrowException (int age) throws AgeIllegalException{
        if (age > 0 && age <150){
            System.out.println("Legal age.");
        }else {
            // 用自定义异常来封装问题
            // throw 抛出去这个异常对象
            // throws 用在方法上，抛出方法内部的异常
            throw new AgeIllegalException("Illegal age!");
        }
    }

}
