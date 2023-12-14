import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;


public class BunTest {

    public static final String NAME = "name";
    public static final float PRICE = 100.0f;
    Bun bun;

    @Before
    public void setBun(){
        bun = new Bun(NAME, PRICE);
    }


    @Test
    public void getNameValueCorrectTest(){

        String actualResult = bun.getName();
        assertEquals(NAME,actualResult);
    }

    @Test
    public void getPriceValueCorrectTest(){

        float actualResult = bun.getPrice();
        assertEquals(PRICE,actualResult,0);

    }


}
