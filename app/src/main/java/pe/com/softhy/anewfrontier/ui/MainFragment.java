package pe.com.softhy.anewfrontier.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import pe.com.softhy.anewfrontier.Domain.MiembrosSofthy;
import pe.com.softhy.anewfrontier.R;
import pe.com.softhy.anewfrontier.ui.adapter.MainFragmentAdapter;

/**
 * Created by Sebastian on 24/06/2017.
 */

public class MainFragment extends Fragment{

//    public static final int NUM_COLUMNS = 1;
    public static  final String LOG_TAG = MainFragment.class.getName();

    private RecyclerView mMainFragment;
    private MainFragmentAdapter adapter;
    ArrayList<MiembrosSofthy> arrayMiembros;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new MainFragmentAdapter(getActivity());

        adapter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("AS", "Iberriiiicoooo");
                Toast.makeText(getContext(), "En construcción...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mMainFragment = (RecyclerView) root.findViewById(R.id.main_list);
        setUpMainList();
        setListMiembrosSofthy();
        return root;
    }

    private void setUpMainList(){
        mMainFragment.setLayoutManager( new LinearLayoutManager(getActivity()));
        mMainFragment.setAdapter(adapter);
        mMainFragment.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.integer.offset));
    }

    private void setListMiembrosSofthy(){
        arrayMiembros = new ArrayList<>();

        arrayMiembros.add(new MiembrosSofthy(R.drawable.foto_peredo, "Sebastian Peredo"));
        arrayMiembros.add(new MiembrosSofthy(R.drawable.foto_iberico, "Jhonatan Iberico"));
        arrayMiembros.add(new MiembrosSofthy(R.drawable.foto_meza, "Jhonatan Meza"));
        arrayMiembros.add(new MiembrosSofthy(R.drawable.foto_minaya, "¡Minnaaaayyaaa!"));
        arrayMiembros.add(new MiembrosSofthy(R.drawable.foto_frank, "Frank VO"));

        adapter.addAll(arrayMiembros);
    }
}
