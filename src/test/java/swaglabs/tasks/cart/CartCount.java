package swaglabs.tasks.cart;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class CartCount {

    //Permite al actor recuperar información sobre el estado del sistema bajo prueba
    public static Question<Integer> currentlyDisplayed() {
        //Retorna el texto del elemento en el localizador
        return Text.of(".shopping_cart_badge").asInteger();
    }
}
