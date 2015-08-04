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
public class SemGranaState implements MaquinaVendaState {
    @Override
    public String selecionaProdutoColocaDinheiro(Produto produto,double credito) {
        //O Dinheiro foi colocado e o produto foi selecionado

        return new StringBuffer("O ").
                append(produto.getTitulo()).
                append("foi selecionado...espere o fim do processo para pegar produto ").toString();
    }

    @Override
    public String soltarProduto() {
        return new StringBuffer("o produto nao pode ser solto pois o valor do produto não foi inserido").toString();
    }
}
