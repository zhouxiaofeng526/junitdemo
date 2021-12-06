import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import io.qameta.allure.Allure;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoTest {
    @Test
    @DisplayName("静态用例名字")
    public void demo1(){
        assert 1+1==2;
        Allure.description("动态描述信息11");
    }

    @Test
    public void demo2(){
        assertThat(2,equalTo(2));
    }

    @Test
    public void demo3(){
        assertThat(2,equalTo(2));
    }

    @Test
    public void evnTest(){
        assertEquals(1,3,"实际值与预期结果不符");
    }
}
