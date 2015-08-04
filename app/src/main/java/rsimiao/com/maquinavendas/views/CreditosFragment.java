package rsimiao.com.maquinavendas.views;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import rsimiao.com.maquinavendas.R;
import rsimiao.com.maquinavendas.core.Utils;


/**
 * Created by Ricardo Simiao on 03/08/15.
 * Permission is granted to copy, distribute and/or modify this
 * document under the terms of the GNU Free Documentation License,
 * Version 1.3 or any later version published by the Free Software
 * Foundation.
 * http://www.gnu.org/licenses/fdl-1.3.txt
 */
public class CreditosFragment extends Fragment {


    Button btnInserirCredito;
    EditText edtValor;
    TextView estadoMaquina;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.insira_creditos, container, false);

        btnInserirCredito = (Button) v.findViewById(R.id.btn_inserir_credito);

        edtValor = (EditText) v.findViewById(R.id.valor_credito);
        edtValor.addTextChangedListener(Utils.maskMoney(edtValor));

        btnInserirCredito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                estadoMaquina.setText(edtValor.getText());

                getActivity().getSupportFragmentManager().beginTransaction().
                        setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).
                        remove(CreditosFragment.this).commit();

            }
        });

        return v;

    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //compartilha o objeto estadoMaquina da main
        MainActivity mainActivity = (MainActivity) activity;
        estadoMaquina = mainActivity.estadoMaquina;
    }
}