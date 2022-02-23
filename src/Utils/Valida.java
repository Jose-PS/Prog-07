/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author DAW
 */
public class Valida {
    
    
        public static void validaDni(String dni) throws BancoException, CancelException {
        char letradni;
        int numsDni;
        final char[] letras = new char[]{'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        try {
            if (dni.length() < 9 || dni.length() > 9) {
               throw new BancoException(Error.NONVALIDO);
            }
            else if (dni == null) {
                throw new BancoException (Error.PRECISASE);
            }
            else if (dni.charAt(0)== '*') throw new CancelException();
            letradni = dni.toUpperCase().charAt(dni.length() - 1);
            numsDni = Integer.parseInt(dni.substring(0, dni.length() - 1));
            int pos = numsDni % 23;
            if (letras[pos] != letradni) {
                throw new BancoException (Error.NONVALIDO);
            }
        } catch (NumberFormatException n) {
            throw new BancoException (Error.NONVALIDO);
        }
    }
        
        public static String validaIban (String iban) throws BancoException{
            if (!iban.matches("[A-Za-z]{2}([0-9]{20})")) {
            throw new BancoException (Error.NONVALIDO, "Introduce un IBAN valido");
            }
            return iban;
        }
}
