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
public class Validar_CPF {

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
        // Check if CPF is null or empty
        if (cpf == null || cpf.isEmpty()) {
            return false;
        }
        
        // Remove non-numeric characters
        var cleanedCpf = cpf.replaceAll("\\D", "");

        // Check if CPF has 11 digits
        if (cleanedCpf.length() != 11) {
            return false;
        }

        // Check if CPF is composed of the same digit
        var firstDigit = cleanedCpf.charAt(0);
        var allSame = true;
        for (var i = 1; i < cleanedCpf.length(); i++) {
            if (cleanedCpf.charAt(i) != firstDigit) {
                allSame = false;
                break;
            }
        }
        if (allSame) {
            return false;
        }

        // Calculate the first verification digit
        var sum = 0;
        for (var i = 0; i < 9; i++) {
            sum += java.lang.Integer.parseInt(cleanedCpf.substring(i, i + 1)) * (10 - i);
        }
        var firstVerificationDigit = (sum * 10) % 11;
        if (firstVerificationDigit == 10) {
            firstVerificationDigit = 0;
        }

        // Calculate the second verification digit
        sum = 0;
        for (var i = 0; i < 10; i++) {
            sum += java.lang.Integer.parseInt(cleanedCpf.substring(i, i + 1)) * (11 - i);
        }
        var secondVerificationDigit = (sum * 10) % 11;
        if (secondVerificationDigit == 10) {
            secondVerificationDigit = 0;
        }

        // Check if verification digits match
        return java.lang.Integer.parseInt(cleanedCpf.substring(9, 10)) == firstVerificationDigit && 
               java.lang.Integer.parseInt(cleanedCpf.substring(10, 11)) == secondVerificationDigit;
    }
}


