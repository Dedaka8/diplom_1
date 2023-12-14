
import org.junit.Test;
import static praktikum.IngredientType.SAUCE;
import static praktikum.IngredientType.FILLING;

import static org.junit.Assert.assertEquals;


public class IngredientTypeTest {
    @Test
    public void ingredientTypeSauceTest(){
        assertEquals("SAUCE", SAUCE.name());
    }

    @Test
    public void ingredientTypeFillingTest(){
        assertEquals("FILLING", FILLING.name());
    }
}
