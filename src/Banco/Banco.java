/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Banco;

import Utils.BancoException;
import Utils.Error;
import Utils.Valida;

/**
 *
 * @author DAW
 */
public class Banco {

    private final ContaBancaria[] contas = new ContaBancaria[100];
    private int pos;

    /**
     * Inserta unha conta bancaria no banco. Maximo 100 contas.
     *
     * @param cb
     * @return Devolve true ou false en funcion de se tivo exito.
     */
    public boolean abrirConta(ContaBancaria cb) {
        if (pos >= contas.length) {
            return false;
        }
        contas[pos] = cb;
        pos++;
        return true;
    }

    /**
     * Lista as contas que hai no banco
     *
     * @return Devolve un array coa informacion de cada conta
     * @throws Utils.BancoException
     */
    public String[] listadoContas() throws BancoException {
        String[] lisContas = new String[pos];
        try {
            for (int i = 0; i < pos; i++) {
                lisContas[i] = contas[i].devolverInfoString();
            }
        } catch (NullPointerException n) {
            throw new BancoException(Error.NONEXISTE);
        }
        return lisContas;
    }

    /**
     * Recibe un iban pra dar a informacion da conta.
     *
     * @param iban
     * @return Devolve un String coa informacion da conta ou null se non existe.
     * @throws Utils.BancoException
     */
    public String informacionConta(String iban) throws BancoException {
        Valida.validaIban(iban);
        try {
            for (int i = 0; i < pos; i++) {
                if (contas[i].getIban().equals(iban)) {
                    return contas[i].devolverInfoString();
                }
            }
        } catch (NullPointerException n) {
            throw new BancoException(Error.NONEXISTE);
        }
        return null;
    }

    /**
     * Introducindo o iban e a cantidade, fai o ingreso na conta indicada.
     *
     * @param iban
     * @param cant
     * @return devolve true ou false en funcion de como saiu a operacion.
     * @throws Utils.BancoException
     */
    public boolean ingresoConta(String iban, double cant) throws BancoException {
        Valida.validaIban(iban);
        if (cant < 0) {
            throw new BancoException(Error.NONVALIDO, "Introduce un valor positivo");
        }
        for (int i = 0; i < pos; i++) {
            if (contas[i].getIban().equals(iban)) {
                contas[i].setSaldo(contas[i].getSaldo() + cant);
                return true;
            }
        }
        return false;
    }

    /**
     * Introducindo o iban e a cantidade, retira os cartos da conta indicada.
     *
     * @param iban
     * @param cant
     * @return Devolve true ou false en funcion de como saiu a operacion.
     * @throws Utils.BancoException
     */
    public boolean retiradaConta(String iban, double cant) throws BancoException {
        Valida.validaIban(iban);
        if (cant < 0) {
            throw new BancoException(Error.NONVALIDO, "Introduce un valor positivo");
        }
        for (int i = 0; i < pos; i++) {
            if (contas[i].getIban().equals(iban)) {
                contas[i].setSaldo(contas[i].getSaldo() - cant);
                return true;
            }
        }
        return false;
    }

    /**
     * Recibe un iban e mostra o saldo da conta
     *
     * @param iban
     * @return devolve un double co saldo da conta ou -1 se non a atopa.
     * @throws Utils.BancoException
     */
    public double obterSaldo(String iban) throws BancoException {
        Valida.validaIban(iban);
        for (int i = 0; i < pos; i++) {
            if (contas[i].getIban().equals(iban)) {
                return contas[i].getSaldo();
            }
        }
        return -1;
    }

}
