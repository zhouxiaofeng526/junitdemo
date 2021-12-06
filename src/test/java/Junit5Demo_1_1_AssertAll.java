import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Junit5Demo_1_1_AssertAll {

    //硬断言，一个错误后，后面的都不执行了
    @Test
    public void addTest() throws InterruptedException{
        int result=Calculator.add(4,2);
        System.out.println("加法计算结果："+result);
        assertEquals(2,result);

        int result01=Calculator.add(4,3);
        System.out.println("加法计算结果："+result01);
        assertEquals(2,result01);

        int result03=Calculator.add(4,4);
        System.out.println("加法计算结果："+result03);
        assertEquals(2,result03);
    }

    //软断言，一个错误后后面的扔会执行
    @Test
    public void addTest2() throws InterruptedException{
        int result=Calculator.add(4,2);
        System.out.println("加法计算结果："+result);
        //assertEquals(2,result);

        int result01=Calculator.add(4,3);
        System.out.println("加法计算结果："+result01);
        //assertEquals(2,result01);

        int result03=Calculator.add(4,4);
        System.out.println("加法计算结果："+result03);
        //assertEquals(2,result03);
        assertAll("加法计算结果校验",
                ()->assertEquals(2,result),
                ()->assertEquals(7,result01),
                ()->assertEquals(8,result03)
                );
    }

    @Test
    public void addTest03() throws InterruptedException{
        //Executable表示这个list是个可执行的
        ArrayList<Executable> assertList=new ArrayList<>();
        for (int i=0;i<10;i++){
            int result=Calculator.add(1,i);
            System.out.println("加法计算结果："+result);
            assertList.add(()->assertEquals(5, result));
        }
        assertAll("加法计算结果校验：", assertList.stream());

    }


}
