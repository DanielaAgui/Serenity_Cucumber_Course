package swaglabs.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import swaglabs.model.SwaglabsUser;
import swaglabs.tasks.authentication.Login;
import swaglabs.tasks.navigation.Navigate;

public class AuthenticationStepDefinitions {

    @Given("{actor} is on the login page")
    //Pasamos la clase 'Actor' que representa la persona o sistema que usa la aplicación
    public void on_the_login_page(Actor actor) {
        //Método para intentar realizar una serie de interacciones
        //Abrimos la URL
        actor.attemptsTo(Open.url("https://www.saucedemo.com/"));
    }

    @When("{actor} logs in with valid credentials")
    public void logs_in_with_valid_credentials(Actor actor) {
        actor.attemptsTo(
                //Ingresamos como usuario
                Login.asA(SwaglabsUser.STANDARD_USER)
        );
    }

    @Given("{actor} has logged on to the application")
    public void is_logged_on(Actor actor) {
        actor.attemptsTo(
                //El actor navega hasta la página web
                Navigate.toTheLoginPage(),
                //Ingresa como usuario
                Login.asA(SwaglabsUser.STANDARD_USER)
        );
    }

    @Then("{actor} should be presented with the product catalog")
    public void he_should_be_presented_with_the_product_catalog(Actor actor) {
        actor.attemptsTo(
                //Clase para realizar verificaciones
                //Verificamos que el texto del título sea igual al dado
                Ensure.that(Text.of(".title")).isEqualToIgnoringCase("Products")
        );
    }

}
