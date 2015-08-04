package rsimiao.com.maquinavendas.core;

import rsimiao.com.maquinavendas.models.Produto;

/**
 * Created by Ricardo Simiao on 03/08/15.
 * Permission is granted to copy, distribute and/or modify this
 * document under the terms of the GNU Free Documentation License,
 * Version 1.3 or any later version published by the Free Software
 * Foundation.
 * http://www.gnu.org/licenses/fdl-1.3.txt
 */
public class ComGranaState implements MaquinaVendaState {

    private double quantia;
    @Override
    public String selecionaProdutoColocaDinheiro(Produto produto,double credito) {
        //o produto e o valor foi selecionado...espere o fim do processo de solta do produto
        this.quantia = quantia;


        return new StringBuffer("O ").
                append(produto.getTitulo()).
                append("foi selecionado...espere o fim do processo para pegar produto ").toString();
    }

    @Override
    public String soltarProduto() {
        //maquina de venda soltando o produto
        return new StringBuffer("Soltando o Produto").toString();
    }

    public double getQuantia(){

        return quantia;

    }
}
