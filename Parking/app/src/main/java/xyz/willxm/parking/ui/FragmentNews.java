package xyz.willxm.parking.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.willxm.parking.R;

/**
 * Created by chenw on 3/10/2016.
 */
public class FragmentNews extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news,container,false);

        
        return view;
    }
}
