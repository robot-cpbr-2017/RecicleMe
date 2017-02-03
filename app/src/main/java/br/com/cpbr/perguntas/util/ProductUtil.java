package br.com.cpbr.perguntas.util;

import java.util.HashMap;
import java.util.Map;

public class ProductUtil {

    public static Map<Integer, String> getProductImagesMap() {

        Map<Integer, String> players = new HashMap<>();

        players.put(1, "https://images-americanas.b2w.io/produtos/01/00/item/113618/0/113618026SZ.jpg");
        players.put(2, "http://i1.sephora.com.br/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/_/5/_5B70D706-DFD2-4668-BA7F-8B1FF296E88D__Esmalte_dior-Milly_500px.jpg");
        players.put(3, "https://n1.sdlcdn.com/imgs/a/i/p/Philips-In-Ear-Headphones-SHE1360-1074667-1-2a516.jpg");
        players.put(4, "http://s3.amazonaws.com/img.iluria.com/product/C96EF/1D0899/450xN.jpg");
        players.put(5, "http://www.arteemminiaturas.com.br/webapps/imagefile/arquivos/m%C3%A1scara-v-de-vingan%C3%A7a-original-v-for-vendetta-wb-04836-01.jpg");
        players.put(6, "https://http2.mlstatic.com/cartucho-super-mario-world-original-super-nintendo-snes-D_NQ_NP_886115-MLB25148545632_112016-F.jpg");
        players.put(7, "https://resources.rocketz.com.br/products/354/product_image/big_178b2d214f48ac894d38d10c9f5d72d3");
        players.put(8, "https://cdn1.pcadvisor.co.uk/cmsdata/reviews/3625829/elivebuy_power_bank_thumb800.jpg");
        players.put(9, "http://image.dhgate.com/0x0/f2/albu/g2/M00/F9/D5/rBVaGlUVL7WACH4NAAC7gzXQ88w176.jpg");
        players.put(10, "https://http2.mlstatic.com/S_14632-MLB2986319634_082012-O.jpg");

        return players;
    }

    public static Map<Integer, String> getProductNamesMap() {

        Map<Integer, String> players = new HashMap<>();

        players.put(1, "MicroSD Scandisk 8GB");
        players.put(2, "Esmalte Dior Milly");
        players.put(3, "Fone Ouvido Philips");
        players.put(4, "Caneca Mike Wazowski");
        players.put(5, "Máscara V for Vendetta");
        players.put(6, "Cartucho Super Mario");
        players.put(7, "Mouse Gamer Razer");
        players.put(8, "Power Bank Elivebuy");
        players.put(9, "Pantufa Minion");
        players.put(10, "Kingston 16GB micro");

        return players;
    }

}