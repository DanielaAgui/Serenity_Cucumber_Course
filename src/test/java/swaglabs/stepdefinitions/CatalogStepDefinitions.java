package swaglabs.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import swaglabs.tasks.cart.AddToCart;
import swaglabs.tasks.cart.CartContents;
import swaglabs.tasks.cart.CartCount;
import swaglabs.tasks.navigation.Navigate;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CatalogStepDefinitions {

    @And("{actor} is browsing the catalog")
    public void heIsBrowsingTheCatalog(Actor actor) {
        actor.attemptsTo(
                Navigate.toTheCatalogPage()
        );
    }

    //Variable de la lista de los items
    List<String> cartItems;

    @When("{actor} adds the following items to the cart:")
    public void addsTheFollowingItemsToTheCart(Actor actor, List<String> items) {
        cartItems = items;
        //Para cada elemento de la lista items
        items.forEach(
                //El actor añade al carrito de compras los elementos según los nombres dados en el ejemplo de feature
                itemName -> actor.attemptsTo(AddToCart.item(itemName))
        );
    }

    @Then("the shopping cart count should be {int}")
    public void theShoppingCartCountShouldBe(int expectedCount) {
        //Recuperamos el actor que se encuentra instanciado
        theActorInTheSpotlight().attemptsTo(
                //Verificamos que el texto del localizador según el método devuelto sea igual al dado
                Ensure.that(CartCount.currentlyDisplayed()).asAnInteger().isEqualTo(expectedCount)
        );
    }

    @And("the items should appear in the cart")
    public void theItemsShouldAppearInTheCart() {
        //El actor
        theActorInTheSpotlight().attemptsTo(
                //Se dirige a la página del carrito de compras
                Navigate.toTheShoppingCart(),
                //Verifica que el texto de cada entrada según un localizador sea igual a la lista de los items
                Ensure.that(CartContents.currentDisplayed()).containsElementsFrom(cartItems)
        );
    }
}
