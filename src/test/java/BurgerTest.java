import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static praktikum.IngredientType.SAUCE;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;

    @Before
    public void setBurger(){
        burger = new Burger();
    }

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient secondIngredient;

    @Test
    public void setBunsCorrectTest(){
        burger.setBuns(bun);
        Bun expectedResult = bun;
        Bun actualResult = burger.bun;
        assertEquals(expectedResult,actualResult);

    }

    @Test
    public void getPriceCorrectTest(){
        float expectedResult = 175.0f;
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(50.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(75.0f);
        float actualResult = burger.getPrice();
        assertEquals(expectedResult,actualResult,0);
    }

    @Test
    public void addIngredientCorrectTest(){
        burger.addIngredient(ingredient);
        Ingredient expectedResult = ingredient;
        Ingredient actualResult = burger.ingredients.get(0);
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void removeIngredientCorrectTest(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        int expectedResult = 0;
        int actualResult = burger.ingredients.size();
        assertEquals(expectedResult,actualResult);

    }

    @Test
    public void moveIngredientCorrectTest(){
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(1,0);
        Ingredient expectedResult = secondIngredient;
        Ingredient actualResult = burger.ingredients.get(0);
        assertEquals(expectedResult,actualResult);

    }


    @Test
    public void getReceiptCorrectValueTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);

        String expectedResult = String.format("(==== bun ====)%n" +
                "= sauce first =%n" +
                "= filling second =%n" +
                "(==== bun ====)%n" +
                "%n" +
                "Price: 220,000000%n");

        Mockito.when(bun.getPrice()).thenReturn(50.0f);
        Mockito.when(bun.getName()).thenReturn("bun");
        Mockito.when(ingredient.getName()).thenReturn("first");
        Mockito.when(secondIngredient.getName()).thenReturn("second");
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(secondIngredient.getType()).thenReturn(FILLING);



        Mockito.when(ingredient.getPrice()).thenReturn(75.0f);
        Mockito.when(secondIngredient.getPrice()).thenReturn(45.0f);

        String actualResult= burger.getReceipt();

        assertEquals(expectedResult,actualResult);



    }

}
