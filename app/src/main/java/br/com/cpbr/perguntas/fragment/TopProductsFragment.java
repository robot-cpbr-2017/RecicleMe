package br.com.cpbr.perguntas.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.cpbr.perguntas.R;
import br.com.cpbr.perguntas.adapter.ProductListAdapter;
import br.com.cpbr.perguntas.model.Product;
import br.com.cpbr.perguntas.util.ProductUtil;
import br.com.cpbr.perguntas.view.DividerItemDecoration;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TopProductsFragment extends Fragment {

    @BindView(R.id.product_recycler)
    RecyclerView productRecycler;

    private ProductListAdapter adapter;

    public TopProductsFragment() {
    }

    public static TopProductsFragment newInstance() {
        return new TopProductsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ProductListAdapter(getProducts());
    }

    private List<Product> getProducts() {

        List<Product> products = new ArrayList<>();

        for (int index = 1, points = 1590; index <= 5; index++, points -= 30) {
            Product product = new Product();
            product.setId(index);
            product.setImageUrl(ProductUtil.getProductImagesMap().get(index));
            product.setName(ProductUtil.getProductNamesMap().get(index));
            product.setPoints(points);
            products.add(product);
        }

        return products;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_products, container, false);
        ButterKnife.bind(this, view);
        setupAdapter();
        return view;
    }

    private void setupAdapter() {
        productRecycler.setHasFixedSize(true);
        productRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        productRecycler.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutCompat.VERTICAL));
        productRecycler.setAdapter(adapter);
    }
}