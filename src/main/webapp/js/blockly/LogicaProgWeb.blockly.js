window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.LogicaProgWeb = window.blockly.js.blockly.LogicaProgWeb || {};

/**
 * @function Executar
 *
 *
 *
 * @param entradaUsuario
 *
 * @author Leonardo Dos Santos Marques
 * @since 25/03/2025, 12:02:57
 *
 */
window.blockly.js.blockly.LogicaProgWeb.ExecutarArgs = [{ description: 'entradaUsuario', id: '4c3fda04' }];
window.blockly.js.blockly.LogicaProgWeb.Executar = async function(entradaUsuario) {
 var RespostaServidor;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.LogicaProg:Executar', async function(sender_RespostaServidor) {
      RespostaServidor = sender_RespostaServidor;
    //
    this.cronapi.notification.customNotify('info', RespostaServidor, 'fade', 'top', 'center', 'false');
  }.bind(this), entradaUsuario);
}
