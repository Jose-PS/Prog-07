/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author DAW
 */
public enum Error {
    NONESPAZO ("Non queda espazo pra gardar mais elementos."),
    XAEXISTE ("Elemento duplicado"),
    NONEXISTE ("Non se atopou o elemento ou o almcen esta vacio"),
    NONVALIDO ("Introduce ben os datos"),
    PRECISASE ("Campo obrigatorio");
    
    private String mensaxe;

    private Error(String mensaxe) {
        this.mensaxe = mensaxe;
    }

    

    @Override
    public String toString() {
        return "ERRO: "+mensaxe;
    }
    

    
        
    
    
}
