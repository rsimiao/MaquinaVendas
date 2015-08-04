package rsimiao.com.maquinavendas.views;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import rsimiao.com.maquinavendas.R;
import rsimiao.com.maquinavendas.adapters.ProdutoAdapter;
import rsimiao.com.maquinavendas.helpers.RefrigeranteHelper;

/**
 * Created by Ricardo Simiao on 02/08/15.
 * Permission is granted to copy, distribute and/or modify this
 * document under the terms of the GNU Free Documentation License,
 * Version 1.3 or any later version published by the Free Software
 * Foundation.
 * http://www.gnu.org/licenses/fdl-1.3.txt
 */
public class TabRefrigerante extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private TextView statusMaquina;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.item_tab,container,false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.itens);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ProdutoAdapter(RefrigeranteHelper.getDataSet(),statusMaquina);
        mRecyclerView.setAdapter(mAdapter);

        return v;

    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //compartilha o objeto statusMaquina da main
        MainActivity mainActivity = (MainActivity) activity;
        statusMaquina = mainActivity.estadoMaquina;
    }





}
