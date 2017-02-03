package br.com.cpbr.perguntas.util;

import android.content.Context;

import br.com.cpbr.perguntas.R;

public class StringUtil {

    public static String productPointsToString(Context context, int points) {
        return points > 1 ? context.getString(R.string.product_points, points) : context.getString(R.string.product_point, points);
    }

    public static String userPointsToString(Context context, int points) {
        return context.getString(R.string.user_points, points);
    }

    public static String userProductsAcquiredToString(Context context, int productsAcquired) {
        return context.getString(R.string.user_products_acquired, productsAcquired);
    }
}
