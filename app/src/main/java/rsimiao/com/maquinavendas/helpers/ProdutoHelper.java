package rsimiao.com.maquinavendas.helpers;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.NumberFormat;

import rsimiao.com.maquinavendas.core.MaquinaVendaFacade;
import rsimiao.com.maquinavendas.core.Utils;
import rsimiao.com.maquinavendas.models.Produto;
import rsimiao.com.maquinavendas.views.DialogProduto;

/**
 * Created by Ricardo Simiao on 04/08/15.
 * Permission is granted to copy, distribute and/or modify this
 * document under the terms of the GNU Free Documentation License,
 * Version 1.3 or any later version published by the Free Software
 * Foundation.
 * http://www.gnu.org/licenses/fdl-1.3.txt
 */
public class ProdutoHelper {

    private Produto produto;
    private Context context;
    private TextView statusMaquina;

    public ProdutoHelper(Context context,Produto produto,TextView statusMaquina){
        this.produto = produto;
        this.context = context;
        this.statusMaquina = statusMaquina;
    }

    public View.OnClickListener eventoComprarProduto(){


        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double credito = Utils.MoneyToDouble(statusMaquina.getText().toString());


                final String msgMoney = MaquinaVendaFacade.getMaquinaVenda().
                        selecionaProdutoColocaDinheiro(produto, credito);

                Toast.makeText(context, msgMoney, Toast.LENGTH_LONG).show();

                if(!msgMoney.equals("dinheiro insuficiente")){

                    //Retira o Produto e o troco
                    new DialogProduto(context).
                            setProduto(produto.getTitulo()).
                            setTroco(credito - produto.getValor()).
                            setEvento(new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //Solta o Produto;
                                    String msgSoltaProduto = MaquinaVendaFacade.getMaquinaVenda().soltarProduto();

                                    statusMaquina.setText(MaquinaVendaFacade.getStatus());
                                    Toast.makeText(context, msgSoltaProduto, Toast.LENGTH_LONG).show();

                                }
                            }).show();

                }

            }
        };

    }

    public TextWatcher callbackStatusMaquina(){

        return new TextWatcher() {
            private NumberFormat nf = NumberFormat.getCurrencyInstance();
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String str = s.toString();

                boolean hasMask = ((str.indexOf("R$") > -1 || str.indexOf("$") > -1) &&
                        (str.indexOf(".") > -1 || str.indexOf(",") > -1));
                // Verificamos se existe máscara
                if (hasMask) {
                    // Retiramos a máscara.
                    str = str.replaceAll("[R$]", "").replaceAll("[,]", "")
                            .replaceAll("[.]", "");
                }

                try {
                    // Transformamos o número que está escrito no EditText em
                    // monetário.
                    str = nf.format(Double.parseDouble(str) / 100);
                    statusMaquina.setText(str);
                } catch (NumberFormatException e) {
                    s = "";
                }



            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

    }




}
