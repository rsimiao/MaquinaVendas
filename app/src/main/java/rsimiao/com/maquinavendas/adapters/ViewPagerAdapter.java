package rsimiao.com.maquinavendas.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import rsimiao.com.maquinavendas.views.TabAgua;
import rsimiao.com.maquinavendas.views.TabChocolate;
import rsimiao.com.maquinavendas.views.TabRefrigerante;

/**
 * Created by Ricardo Simiao on 02/08/15.
 * Permission is granted to copy, distribute and/or modify this
 * document under the terms of the GNU Free Documentation License,
 * Version 1.3 or any later version published by the Free Software
 * Foundation.
 * http://www.gnu.org/licenses/fdl-1.3.txt
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence titulos[];
    Integer numTabs;


    public ViewPagerAdapter(FragmentManager fm,CharSequence titulos[], Integer numTabs) {
        super(fm);

        this.titulos = titulos;
        this.numTabs = numTabs;


    }

    @Override
    public Fragment getItem(int position) {

        if (position ==0){
            TabChocolate tabChocolate = new TabChocolate();
            return  tabChocolate;
        }else if(position ==1){
            TabRefrigerante tabRefrigerante = new TabRefrigerante();
            return  tabRefrigerante;
        }else{
            TabAgua tabAgua = new TabAgua();
            return  tabAgua;
        }

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titulos[position];
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
