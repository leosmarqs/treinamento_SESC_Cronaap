package blockly;

import cronapi.CronapiMetaData;
import cronapi.ParamMetaData;


/**
 * Função customizada para apresentar criação de bloco customizado ...
 *
 * @author Leonardo Dos Santos Marques
 * @version 1.0
 * @since 2025-03-31
 *
 */

@CronapiMetaData(categoryName = "Minhas Funções")
public class BlocoTeste {

	@CronapiMetaData(type = "function", name = "Hello world Nome", description = "Função customizada para apresentar criação de bloco customizado")
	public static String helloWorldReturn(@ParamMetaData(description = "Nome: Nome a ser impresso") String nome) throws Exception {
		return "Olá,  " + nome;
	}

	public static void helloWorldPrint(@ParamMetaData(description = "Nome: Nome a ser impresso") String nome) throws Exception {
		System.out.println("Olá, " + nome);
	}


}