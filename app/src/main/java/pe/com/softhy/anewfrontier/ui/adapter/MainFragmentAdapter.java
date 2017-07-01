package pe.com.softhy.anewfrontier.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pe.com.softhy.anewfrontier.Domain.MiembrosSofthy;
import pe.com.softhy.anewfrontier.R;

/**
 * Created by Sebastian on 24/06/2017.
 */

public class MainFragmentAdapter extends RecyclerView.Adapter<MainFragmentAdapter.MainFragmentViewHolder> implements View.OnClickListener {

    private View.OnClickListener listener;
    List<MiembrosSofthy> miembros;
    Context context;

    public MainFragmentAdapter(Context context){
        this.context = context;
        this.miembros = new ArrayList<>();
    }

    @Override
    public MainFragmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_fragment_main, parent, false);

        itemView.setOnClickListener(this);
        return new MainFragmentViewHolder(itemView);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View v) {
        if(v != null)
            listener.onClick(v);
    }

    @Override
    public void onBindViewHolder(MainFragmentViewHolder holder, int position) {
        MiembrosSofthy currentMiembro = miembros.get(position);
        holder.image_item.setImageResource(miembros.get(position).getImage());
        holder.name_item.setText(miembros.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return miembros.size();
    }

    public void addAll(ArrayList<MiembrosSofthy> miembros){
        if(miembros == null) {
            throw new NullPointerException("La lista de miembros no puede ser null");
        }
        this.miembros.addAll(miembros);
        notifyDataSetChanged();
    }

    public class MainFragmentViewHolder extends RecyclerView.ViewHolder{

        public TextView  name_item;
        public ImageView image_item;
        public MainFragmentViewHolder(View itemView){
            super(itemView);
            image_item  = (ImageView) itemView.findViewById(R.id.foto_miembro);
            name_item   = (TextView) itemView.findViewById(R.id.nombre_miembro);
        }
    }
}
