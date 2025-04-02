package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class TesteApi {

public static final int TIMEOUT = 300;

/**
 *
 * @author Leonardo Dos Santos Marques
 * @since 01/04/2025, 11:54:01
 *
 */
public static Var Executar() throws Exception {
 return new Callable<Var>() {

   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    item =
    cronapi.json.Operations.toJson(
    cronapi.util.Operations.getURLFromOthers(
    Var.valueOf("GET"),
    Var.valueOf("application/json"),
    Var.valueOf("https://pokeapi.co/api/v2/pokemon/"), Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL,
    Var.valueOf(""),
    Var.valueOf("BODY")));
    cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
    cronapi.json.Operations.getJsonOrMapField(item,
    Var.valueOf("results[5].name")));
    return
cronapi.json.Operations.getJsonOrMapField(item,
Var.valueOf("results"));
   }
 }.call();
}

}

