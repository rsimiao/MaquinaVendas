package rsimiao.com.maquinavendas.core;

import android.util.Log;

/**
 * Created by Ricardo Simiao on 03/08/15.
 * Permission is granted to copy, distribute and/or modify this
 * document under the terms of the GNU Free Documentation License,
 * Version 1.3 or any later version published by the Free Software
 * Foundation.
 * http://www.gnu.org/licenses/fdl-1.3.txt
 */
public class MaquinaVendaFacade {

    public static MaquinaVenda maquina;
    private static String TAG ="MAQUINA";

    public static MaquinaVenda getMaquinaVenda(){

        if(maquina == null){
            maquina = new MaquinaVenda();
            Log.d("MAQUINA","CRIOU UMA NOVA");
        }

        return maquina;
    }

    public static String getStatus(){

        StringBuffer status;

        if(getMaquinaVenda().getMaquinaVendaState() instanceof SemGranaState){
            status = new StringBuffer("SEM CRÉDITO");
            Log.d("MAQUINA","Sem grana");
        }else{
            ComGranaState comGrana = (ComGranaState) getMaquinaVenda().getMaquinaVendaState();
          //  status = new StringBuffer(String.format("%1$,.3f R$",comGrana.getQuantia()));
            status = Utils.toMoneyString(String.valueOf(comGrana.getQuantia()));
            Log.d("MAQUINA","COM GRANA");
        }

        return status.toString();
    }


}
