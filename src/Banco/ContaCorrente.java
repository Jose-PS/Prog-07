/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Banco;

/**
 *
 * @author DAW
 */
public abstract class ContaCorrente extends ContaBancaria {

    private String[] listaEntidades;

    public ContaCorrente(Persoa titular, double saldo, String iban, TipoConta tipoConta) {
        super(titular, saldo, iban, tipoConta);
    }

    public boolean cobraRecibo (Recibo r){
        for (String listaEntidade : listaEntidades) {
            if (r.getEntidad().equals(listaEntidade)) {
                saldo=saldo-r.getImporte();
                return true;
            }
        }
        return false;
    }

}
