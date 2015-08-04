package rsimiao.com.maquinavendas.views;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import java.text.DecimalFormat;

import rsimiao.com.maquinavendas.core.Utils;

/**
 * Created by Ricardo Simiao on 04/08/15.
 * Permission is granted to copy, distribute and/or modify this
 * document under the terms of the GNU Free Documentation License,
 * Version 1.3 or any later version published by the Free Software
 * Foundation.
 * http://www.gnu.org/licenses/fdl-1.3.txt
 */
public class DialogProduto extends AlertDialog {

    private double troco;
    private String produto;
    private StringBuffer mensagem;
    private OnClickListener onclick;

    public DialogProduto(Context context) {
        super(context);
        StringBuffer mensagem = new StringBuffer("Retire seu produto");
    }


    public DialogProduto setTroco(double troco){
        this.troco = troco;

        return this;
    }


    public DialogProduto setProduto(String produto){
        this.produto = produto;
        return this;

    }
    public DialogProduto setEvento(OnClickListener onclick){
        this.onclick = onclick;
        return this;
    }

    @Override
    public void show() {
        StringBuffer mensagem = troco > 0? new StringBuffer("Retire seu ").append(produto).append(" e seu troco de ").
                append(Utils.toMoneyString(troco)):new StringBuffer("Retire seu ").append(produto);

        this.setTitle("A maquina");
        this.setMessage(mensagem);
        this.setButton(BUTTON_POSITIVE, "OK", onclick);
        super.show();
    }



}
