package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class LogicaProg {

public static final int TIMEOUT = 300;

/**
 *
 * @param valorEntrada
 *
 * @author Leonardo Dos Santos Marques
 * @since 26/03/2025, 10:34:26
 *
 */
public static Var Executar(@ParamMetaData(description = "valorEntrada", id = "8349575f") @RequestBody(required = false) Var valorEntrada) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return
Var.valueOf(
Var.valueOf("A Resposta é : ").getObjectAsString() +
Var.valueOf(validarPalindrome(valorEntrada)).getObjectAsString());
   }
 }.call();
}

/**
 *
 * @param stringRomano
 *
 * @author Leonardo Dos Santos Marques
 * @since 26/03/2025, 10:34:26
 *
 */
public static Var romanoParainteiro(@ParamMetaData(description = "stringRomano", id = "18223bb7") @RequestBody(required = false) Var stringRomano) throws Exception {
 return new Callable<Var>() {

   private Var mapaRomano = Var.VAR_NULL;
   private Var Resposta = Var.VAR_NULL;
   private Var NumAnterior = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;
   private Var i_start = Var.VAR_NULL;
   private Var i_end = Var.VAR_NULL;
   private Var i_inc = Var.VAR_NULL;

   public Var call() throws Exception {
    mapaRomano =
    cronapi.map.Operations.createObjectMapWith(Var.valueOf("I",
    Var.valueOf(1)) , Var.valueOf("V",
    Var.valueOf(5)) , Var.valueOf("X",
    Var.valueOf(10)) , Var.valueOf("L",
    Var.valueOf(50)) , Var.valueOf("C",
    Var.valueOf(100)) , Var.valueOf("D",
    Var.valueOf(500)) , Var.valueOf("M",
    Var.valueOf(1000)));
    Resposta =
    Var.valueOf(0);
    NumAnterior =
    Var.valueOf(0);
    i_start =
    Var.valueOf(stringRomano.length());
    i_end =
    Var.valueOf(1);
    i_inc =
    Var.valueOf(1);
    if (i_start.greaterThan(i_end)) {
        i_inc.multiply(-1);
    }
    for (i = Var.valueOf(i_start);
        i_inc.getObjectAsInt() >= 0 ? i.getObjectAsLong() <= i_end.getObjectAsLong() : i.getObjectAsLong()  >= i_end.getObjectAsLong();
    i.inc(i_inc))  {
        item =
        cronapi.map.Operations.getMapField(mapaRomano,
        Var.valueOf(cronapi.text.Operations.getLetter(stringRomano,i)));
        if (
        Var.valueOf(item.compareTo(NumAnterior) < 0).getObjectAsBoolean()) {
            Resposta =
            cronapi.math.Operations.subtract(Resposta,item);
        } else {
            Resposta =
            cronapi.math.Operations.sum(Resposta,item);
        }
        NumAnterior = item;
    } // end for
    return Resposta;
   }
 }.call();
}

/**
 *
 * @param frase
 *
 * @author Leonardo Dos Santos Marques
 * @since 26/03/2025, 10:34:26
 *
 */
public static Var validarPalindrome(@ParamMetaData(description = "param_frase", id = "d32d6c94") @RequestBody(required = false) Var param_frase) throws Exception {
 return new Callable<Var>() {

   // param
   private Var frase = param_frase;
   // end
   private Var comeco = Var.VAR_NULL;
   private Var fim = Var.VAR_NULL;
   private Var caractereComeco = Var.VAR_NULL;
   private Var caractereFinal = Var.VAR_NULL;
   private Var letrasDigitos = Var.VAR_NULL;

   public Var call() throws Exception {
    // Essa função checa se uma frase é um polindromo
    comeco =
    Var.valueOf(1);
    fim =
    Var.valueOf(frase.length());
    while (
    Var.valueOf(comeco.compareTo(fim) <= 0).getObjectAsBoolean()) {
        caractereComeco =
        Var.valueOf(cronapi.text.Operations.getLetter(frase,comeco));
        caractereFinal =
        Var.valueOf(cronapi.text.Operations.getLetter(frase,fim));
        // region Checar se é caractere ou digito
            letrasDigitos =
            Var.valueOf("abcdefghijlmnopqrstuvwxyz0123456789");
            if (
            Var.valueOf(!
            Var.valueOf(letrasDigitos.getObjectAsString().indexOf(
            Var.valueOf(caractereComeco.getObjectAsString().toLowerCase()).getObjectAsString()) + 1).equals(
            Var.valueOf(0))).getObjectAsBoolean()) {
                comeco =
                cronapi.math.Operations.sum(comeco,
                Var.valueOf(1));
            } else if (
            Var.valueOf(!
            Var.valueOf(letrasDigitos.getObjectAsString().indexOf(
            Var.valueOf(caractereFinal.getObjectAsString().toLowerCase()).getObjectAsString()) + 1).equals(
            Var.valueOf(0))).getObjectAsBoolean()) {
                fim =
                cronapi.math.Operations.subtract(fim,
                Var.valueOf(1));
            } else {
                if (
                Var.valueOf(!caractereComeco.equals(caractereFinal)).getObjectAsBoolean()){
                  return
                Var.VAR_FALSE;
                }
                comeco =
                cronapi.math.Operations.sum(comeco,
                Var.valueOf(1));
                fim =
                cronapi.math.Operations.sum(fim,
                Var.valueOf(1));
            }
        // endregion Checar se é caractere ou digito
    } // end while
    return
Var.VAR_TRUE;
   }
 }.call();
}

}

