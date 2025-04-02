package blockly;

import cronapi.CronapiMetaData;
import cronapi.Utils;
import cronapi.Var;
import cronapi.CronapiMetaData.CategoryType;
import cronapi.CronapiMetaData.ObjectType;	
import cronapi.ParamMetaData;
import cronapi.rest.security.CronappSecurity;


/**
 * @author Leonardo Dos Santos Marques
 * @version 1.0
 * @since 2025-04-01
 *
 */
 
@CronappSecurity
@cronapi.CronapiMetaData(type = "blockly", categoryName = "Blocos Diana")
public class MinhaClasse {

    /**
     * Validate a Brazilian CPF.
     * 
     * @param cpf the CPF to be validated
     * @return true if the CPF is valid, false otherwise
     */
    @cronapi.CronapiMetaData(
        type = "function",
        name = "validarCpf",
        nameTags = {"cpf", "brazil", "validation", "brasil", "documento"},
        description = "Valida um CPF brasileiro."
    )
    public static boolean validarCpf(java.lang.String cpf) throws Exception {
        // Remove non-numeric characters from the CPF
        var cpfCleaned = cpf.replaceAll("\\D", "");

        // Check if the CPF has 11 digits
        if (cpfCleaned.length() != 11) {
            return false;
        }

        // Check if the CPF is valid (not all the same digits)
        if (cpfCleaned.chars().distinct().count() == 1) {
            return false;
        }

        // Calculate the first digit of the CPF
        var sum = 0;
        for (var i = 0; i < 9; i++) {
            sum += java.lang.Integer.parseInt(cpfCleaned.substring(i, i + 1)) * (10 - i);
        }
        var firstDigit = (sum * 10) % 11;
        if (firstDigit == 10) {
            firstDigit = 0;
        }

        // Calculate the second digit of the CPF
        sum = 0;
        for (var i = 0; i < 10; i++) {
            sum += java.lang.Integer.parseInt(cpfCleaned.substring(i, i + 1)) * (11 - i);
        }
        var secondDigit = (sum * 10) % 11;
        if (secondDigit == 10) {
            secondDigit = 0;
        }

        // Compare the calculated digits with the last two digits of the CPF
        return java.lang.Integer.parseInt(cpfCleaned.substring(9, 10)) == firstDigit && java.lang.Integer.parseInt(cpfCleaned.substring(10, 11)) == secondDigit;
    }
}


