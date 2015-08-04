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
public class MaquinaVenda implements MaquinaVendaState {
    //context
    private MaquinaVendaState maquinaVendaState;

    public MaquinaVenda(){

        setMaquinaVendaState(new SemGranaState());
    }

    @Override
    public String selecionaProdutoColocaDinheiro(Produto produto,double credito) {

        String msg = "";
        if(credito >= produto.getValor()){
            MaquinaVendaState comGrana = new ComGranaState();
            msg =  maquinaVendaState.selecionaProdutoColocaDinheiro(produto, credito);

            //O dinheiro foi inserido e mo produto escolhido
            if(maquinaVendaState instanceof SemGranaState){
                //A maquina trocou o estado para comGrana
                setMaquinaVendaState(comGrana);
            }
        }else{
            msg = "dinheiro insuficiente";
        }

        return msg;

    }
    @Override
    public String soltarProduto() {
        String msg = "";
        MaquinaVendaState  semGrana = new SemGranaState();
        msg = maquinaVendaState.soltarProduto();

        //a maquina soltou o produto e agora está sem dinheiro
        if(maquinaVendaState instanceof ComGranaState){
            //mudou para sem grana
            setMaquinaVendaState(semGrana);
        }
        return msg;

    }

    public MaquinaVendaState getMaquinaVendaState() {
        return maquinaVendaState;
    }

    public void setMaquinaVendaState(MaquinaVendaState maquinaVendaState) {
        this.maquinaVendaState = maquinaVendaState;
    }


}