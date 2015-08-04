package rsimiao.com.maquinavendas.views;


import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import rsimiao.com.maquinavendas.R;
import rsimiao.com.maquinavendas.core.MaquinaVendaFacade;
import rsimiao.com.maquinavendas.widgets.SlidingTabLayout;
import rsimiao.com.maquinavendas.adapters.ViewPagerAdapter;


public class MainActivity extends ActionBarActivity {

    Toolbar toolbar;
    public TextView estadoMaquina;
    ViewPager pager;
    ViewPagerAdapter tabsAdapter;
    SlidingTabLayout tabs;
    CharSequence titulos[] ={"Chocolate","Refri","Agua"};
    Integer numeroDeTabs = 3;


    public void init(){
        //inicia a barra superior
        toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //inicia o menu de tabs
        tabsAdapter = new ViewPagerAdapter(getSupportFragmentManager(), titulos, numeroDeTabs);
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(tabsAdapter);
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);


        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {

            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        tabs.setViewPager(pager);
    }

    public void turnOnMachine(){

        estadoMaquina = (TextView) findViewById(R.id.estado_maquina);
        MaquinaVendaFacade.getMaquinaVenda();
        estadoMaquina.setText(MaquinaVendaFacade.getStatus());


/*
        addCredito = (FloatingActionButton) findViewById(R.id.add_credito);
        addCredito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                CreditosFragment creditos = new CreditosFragment();
                ft.replace(R.id.painel, creditos);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(creditos.getClass().getName());
                ft.commit();

            }
        });
*/

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        turnOnMachine();

    }


}
