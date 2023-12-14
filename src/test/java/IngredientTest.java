import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

public class IngredientTest {
    public static final String NAME = "name";
    public static final float PRICE = 100.0f;
    Ingredient ingredient;
    @Before
    public void setIngredient(){
        ingredient = new Ingredient(FILLING, NAME, PRICE);
    }

    @Test
    public void getNameValueCorrectTest(){

        String actualResult = ingredient.getName();
        assertEquals(NAME,actualResult);
    }

    @Test
    public void getPriceValueCorrectTest(){

        float actualResult = ingredient.getPrice();
        assertEquals(PRICE,actualResult,0);
    }
    @Test
    public void getTypeValueCorrectTest(){
        IngredientType actualResult = ingredient.getType();
        assertEquals(FILLING,actualResult);
    }


}
