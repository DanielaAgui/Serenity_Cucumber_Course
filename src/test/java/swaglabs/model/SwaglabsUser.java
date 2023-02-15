package swaglabs.model;

//Creamos una clase con las constantes de usuario
public enum SwaglabsUser {

    //Constante con sus datos
    STANDARD_USER("standard_user", "secret_sauce");

    //Variables a usar en las constantes
    public final String username;
    public final String password;

    //Constructor
    SwaglabsUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
