package br.com.cpbr.perguntas.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.cpbr.perguntas.model.Player;

public class PlayerUtil {

    public static Map<Integer, String> getPlayerImagesMap() {

        Map<Integer, String> players = new HashMap<>();

        players.put(1, "http://saranossaterra.com.br/content/uploads/2015/04/Chuck-Norris-CelebHealthy_com.jpg");
        players.put(2, "http://media.salon.com/2013/02/house_of_cards2.jpg");
        players.put(3, "http://www.osul.com.br/wp-content/uploads/2016/10/donald.jpg");
        players.put(4, "http://pixel.nymag.com/imgs/daily/vulture/2016/08/11/11-obama-sex-playlist.w529.h529.jpg");
        players.put(5, "http://vignette2.wikia.nocookie.net/p__/images/1/19/Walter-White.jpg/revision/latest?cb=20141001144340&path-prefix=protagonist");
        players.put(6, "https://s-media-cache-ak0.pinimg.com/736x/6f/b8/f3/6fb8f395e2e235bcb19a6ee9999e69d6.jpg");
        players.put(7, "https://sheldon-cooper.de/wp-content/themes/twentyten/images/sheldon-cooper.png");
        players.put(8, "https://upload.wikimedia.org/wikipedia/en/4/4e/Elijah_Wood_as_Frodo_Baggins.png");
        players.put(9, "http://www.gannett-cdn.com/-mm-/9b4c30b697d01e1dc44d186b69884a7b2e73feef/c=0-17-709-550&r=x404&c=534x401/local/-/media/2017/01/19/DetroitNews/DetroitNews/636204554334983968-count-olaf.jpg");
        players.put(10, "https://pmctvline2.files.wordpress.com/2016/08/stranger-things-eleven-haircut-video1.jpg");
        players.put(11, "http://blogs.diariodonordeste.com.br/diarioemseries/wp-content/uploads/2011/11/barney.jpg");
        players.put(12, "https://erinfconley.files.wordpress.com/2015/05/friendss06e17-0127.jpg");
        players.put(13, "https://i.ytimg.com/vi/nVHiUAD3xbQ/hqdefault.jpg");
        players.put(14, "https://drinkerswithwritingproblems.files.wordpress.com/2014/09/jules.jpg");
        players.put(15, "https://www.proibidoler.com/wp-content/uploads/2015/02/homem-de-ferro-como-ter-uma-barba-igual-ao-do-tony-stark9.jpg");

        return players;
    }

    public static Map<Integer, String> getPlayerNamesMap() {

        Map<Integer, String> players = new HashMap<>();

        players.put(1, "Chuck Norris");
        players.put(2, "Frank Underwood");
        players.put(3, "Donald Trump");
        players.put(4, "Barack Obama");
        players.put(5, "Walter White");
        players.put(6, "kimberly Hart");
        players.put(7, "Sheldon Cooper");
        players.put(8, "Frodo Baggins");
        players.put(9, "Count Olaf");
        players.put(10, "Eleven");
        players.put(11, "Barney Stinson");
        players.put(12, "Ross Geller");
        players.put(13, "Ace Ventura");
        players.put(14, "Jules Winnfield");
        players.put(15, "Tony Stark");

        return players;
    }

    public static List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();

        for (int rank = 1, score = 58465416, productsAcquired = 53; rank <= PlayerUtil.getPlayerImagesMap().size(); rank++, score = score - 43, productsAcquired--) {
            Player player = new Player();
            player.setImage(PlayerUtil.getPlayerImagesMap().get(rank));
            player.setName(PlayerUtil.getPlayerNamesMap().get(rank));
            player.setPointsAmount(score);
            player.setProductsAcquired(productsAcquired);
            player.setRank(rank);
            players.add(player);
        }

        return players;
    }

}
