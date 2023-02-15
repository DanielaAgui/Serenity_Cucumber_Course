package swaglabs.tasks.cart;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.PageElement;

//Método para agregar elementos al carrito de compras
public class AddToCart {
    public static Performable item(String itemName) {
        //Devuelve una tarea donde el actor hace (nombre de la tarea)
        return Task.where("{0} clicks on the add to cart button for " + itemName,
                //Añadimos las actividades del actor
                //Dar clic en el botón con el localizador
                Click.on(Button.withText("Add to cart")
                        //Que se encuentra dentro del elemento web con el localizador
                        .inside(PageElement.withCSSClass("inventory_item")
                                //Que contiene el nombre del parámetro
                                .containingText(itemName)))
        );
    }
}
