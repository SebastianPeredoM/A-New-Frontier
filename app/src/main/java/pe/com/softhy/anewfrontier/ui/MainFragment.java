package pe.com.softhy.anewfrontier.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new MainFragmentAdapter(getActivity());
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
        ArrayList<MiembrosSofthy> arrayMiembros = new ArrayList<>();

        arrayMiembros.add(new MiembrosSofthy("Sebastian Peredo"));
        arrayMiembros.add(new MiembrosSofthy(("Jhonatan Iberico")));
        arrayMiembros.add(new MiembrosSofthy(("Jhonatan Meza")));
        arrayMiembros.add(new MiembrosSofthy(("¡Minanaaayyaaa!")));

        adapter.addAll(arrayMiembros);
    }
}
