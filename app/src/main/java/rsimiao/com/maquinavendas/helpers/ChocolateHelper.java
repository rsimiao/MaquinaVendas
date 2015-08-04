package rsimiao.com.maquinavendas.helpers;

import java.util.ArrayList;
import java.util.List;

import rsimiao.com.maquinavendas.models.Produto;

/**
 * Created by Ricardo Simiao on 04/08/15.
 * Permission is granted to copy, distribute and/or modify this
 * document under the terms of the GNU Free Documentation License,
 * Version 1.3 or any later version published by the Free Software
 * Foundation.
 * http://www.gnu.org/licenses/fdl-1.3.txt
 */
public class ChocolateHelper {

    public static List<Produto> getDataSet() {

        List results = new ArrayList<Produto>();
        results.add(new Produto("Chocolate Garoto","Lorem ipsum dolor sit amet, consectetur adipiscing elit",2.00));
        results.add(new Produto("Chocolate Nestlê","Donec in diam nibh. Done efficitur at.Sed elei pulvinar.",3.00));

        return results;
    }

}
