package xyz.willxm.parking.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ZoomControls;

import com.baidu.mapapi.map.MapView;

import xyz.willxm.parking.R;

/**
 * Created by chenw on 3/10/2016.
 */
public class FragmentMap extends Fragment {

    MapView mMapView = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_map,container,false);

        mMapView = (MapView) view.findViewById(R.id.bmapView);

        //隐藏缩放控件

        int childCount = mMapView.getChildCount();

        View zoom = null;

        for (int i = 0; i<childCount; i++) {
            View child  = mMapView.getChildAt(i);

            if (child instanceof ZoomControls) {

                zoom = child;
                break;
            }
        }
        zoom.setVisibility(View.GONE);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mMapView.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();

        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();

        mMapView.onPause();
    }
}
