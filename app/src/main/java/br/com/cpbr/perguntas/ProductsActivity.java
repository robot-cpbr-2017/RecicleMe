package br.com.cpbr.perguntas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.cpbr.perguntas.adapter.ProductListAdapter;
import br.com.cpbr.perguntas.model.Product;
import br.com.cpbr.perguntas.util.ProductUtil;
import br.com.cpbr.perguntas.view.DividerItemDecoration;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsActivity extends AppCompatActivity {

    @BindView(R.id.product_recycler)
    RecyclerView productRecycler;

    private ProductListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        ButterKnife.bind(this);
        setupAdapter();
    }

    private List<Product> getProducts() {

        List<Product> products = new ArrayList<>();

        for (int index = 1, points = 1590; index <= ProductUtil.getProductImagesMap().size(); index++, points -= 30) {
            Product product = new Product();
            product.setId(index);
            product.setImageUrl(ProductUtil.getProductImagesMap().get(index));
            product.setName(ProductUtil.getProductNamesMap().get(index));
            product.setPoints(points);
            products.add(product);
        }

        return products;
    }

    private void setupAdapter() {
        adapter = new ProductListAdapter(getProducts());
        productRecycler.setHasFixedSize(true);
        productRecycler.setLayoutManager(new LinearLayoutManager(this));
        productRecycler.addItemDecoration(new DividerItemDecoration(this, LinearLayoutCompat.VERTICAL));
        productRecycler.setAdapter(adapter);
    }
}
