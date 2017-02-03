package br.com.cpbr.perguntas.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.cpbr.perguntas.R;
import br.com.cpbr.perguntas.model.Product;
import br.com.cpbr.perguntas.util.StringUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    private List<Product> products;

    public ProductListAdapter(List<Product> products) {
        this.products = products;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product = products.get(position);

        Glide.with(holder.itemView.getContext()).load(product.getImageUrl()).into(holder.productImage);
        holder.produtctName.setText(product.getName());
        holder.productPoints.setText(StringUtil.productPointsToString(holder.itemView.getContext(), product.getPoints()));
    }

    @Override
    public int getItemCount() {
        return products == null ? 0 : products.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.product_image)
        CircleImageView productImage;

        @BindView(R.id.product_name)
        TextView produtctName;

        @BindView(R.id.product_points)
        TextView productPoints;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}