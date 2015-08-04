package rsimiao.com.maquinavendas.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import rsimiao.com.maquinavendas.R;
import rsimiao.com.maquinavendas.core.Utils;
import rsimiao.com.maquinavendas.helpers.ProdutoHelper;
import rsimiao.com.maquinavendas.models.Produto;

/**
 * Created by Ricardo Simiao on 02/08/15.
 * Permission is granted to copy, distribute and/or modify this
 * document under the terms of the GNU Free Documentation License,
 * Version 1.3 or any later version published by the Free Software
 * Foundation.
 * http://www.gnu.org/licenses/fdl-1.3.txt
 */
public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ViewHolder> {


    private List<Produto> mDataset;
    private TextView statusMaquina;


    public ProdutoAdapter(List<Produto> dataset,TextView statusMaquina) {
        mDataset = dataset;
        this.statusMaquina = statusMaquina;
    }


    //o holder do nosso adapter
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView subTitulo;
        TextView preco;
        EditText credito;
        Button comprar;

        public ViewHolder(View itemView) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.item_titulo);
            subTitulo = (TextView) itemView.findViewById(R.id.item_descricao);
            preco = (TextView) itemView.findViewById(R.id.item_preco);
            credito = (EditText) itemView.findViewById(R.id.valor_credito);
            comprar = (Button) itemView.findViewById(R.id.botao_comprar);
        }


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_maquina, viewGroup, false);

        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.titulo.setText(mDataset.get(position).getTitulo());
        holder.subTitulo.setText(mDataset.get(position).getDescricao());
        holder.preco.setText(String.format("%1$,.2f R$", mDataset.get(position).getValor()));
        holder.credito.addTextChangedListener(Utils.maskMoney(holder.credito));

        //Interação com a maquina.
        ProdutoHelper helper = new ProdutoHelper(holder.credito.getContext(),
                    mDataset.get(position),statusMaquina);
        holder.credito.addTextChangedListener(helper.callbackStatusMaquina());
        holder.comprar.setOnClickListener(helper.eventoComprarProduto());

    }

    public void addItem(Produto item, int index) {
        mDataset.add(index, item);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
