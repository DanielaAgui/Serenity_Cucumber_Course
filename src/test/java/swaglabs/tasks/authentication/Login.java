package swaglabs.tasks.authentication;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ui.Button;
import swaglabs.model.SwaglabsUser;

public class Login {

    //Método para ejecutar una tarea
    public static Performable asA(SwaglabsUser standardUser) {
        //Con 'Task' marcamos para indicar que un ejecutable representa una tarea y no una interacción del sistema
        //Le pasamos el título y la el parámetro tomado de la clase enum
        return Task.where("{0} logs in as as " + standardUser,
                //Clase que indica al actor que introduzca un valor en un input pasando el localizador
                //Ingresamos el usuario
                Enter.theValue(standardUser.username).into("#user-name"),
                //Ingresamos la contraseña
                Enter.theValue(standardUser.password).into("#password"),
                //Clase para dar clic en un elemento web
                //Damos clic en el botón según el localizador
                Click.on(Button.withNameOrId("login-button"))
        );
    }
}
