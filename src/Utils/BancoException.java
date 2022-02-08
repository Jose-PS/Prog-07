/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author DAW
 */
public class BancoException extends Exception {
    private Error codigo;
    private String mensaxe;

    public BancoException(Error codigo) {
        this.codigo = codigo;
    }

    public BancoException(Error codigo, String mensaxe) {
        this.codigo = codigo;
        this.mensaxe = mensaxe;
    }
    

    public Error getCodigo() {
        return codigo;
    }
    
    
    public String getMessage () {
    return mensaxe;
    }
}
