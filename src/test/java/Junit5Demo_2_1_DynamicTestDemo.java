import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import entity.ResultList;
import entity.ShellResult;
import org.junit.Test;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class Junit5Demo_2_1_DynamicTestDemo {
    //动态测试demo
    @TestFactory
    Collection<DynamicTest> dynamicTestCollection(){
        return Arrays.asList(
                dynamicTest("1st dynamic test",()->{assertTrue(true);}),
                dynamicTest("2nd dynamic test",()->assertEquals(4,4))

        );
    }

    @Test
    public void entityTest()throws IOException {
        //将文件yaml变成对象
        ObjectMapper objectMapper=new ObjectMapper(new YAMLFactory());
        ResultList resultList=objectMapper.readValue(new File("E:/JAVA-hogwarts/junit5demo2/resources/shell_test_result.yaml"), ResultList.class);
    }

    @TestFactory
    Collection<DynamicTest> runShellResult() throws IOException{
        List<DynamicTest> dynamicTestList=new ArrayList<>();
        ObjectMapper objectMapper=new ObjectMapper(new YAMLFactory());
        //反序列化yaml数据到对象列表中
        ResultList resultList=objectMapper.readValue(new File("E:/JAVA-hogwarts/junit5demo2/resources/shell_test_result.yaml"), ResultList.class);
        System.out.println("Done!");
        //动态遍历生成测试方法
        for(ShellResult shellResult: resultList.getResultList()){
            dynamicTestList.add(
                    dynamicTest(shellResult.getCaseName(),()->{assertTrue(shellResult.isResult());})
            );

        }
        return dynamicTestList;
    }
}
