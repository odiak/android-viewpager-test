package net.odiak.viewpagertest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class TestFragment extends Fragment {
    public static TestFragment newInstance(int position) {
        TestFragment fragment = new TestFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        int position = 0;
        if (bundle != null) {
            position = bundle.getInt("position");
        }

        View view = inflater.inflate(R.layout.fragment_test, container, false);

        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(String.format("item: %d", position));

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null) {
            System.out.println(String.format("Fragment created %d", bundle.getInt("position")));
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            System.out.println(String.format("Fragment destroyed %d", bundle.getInt("position")));
        }
        super.onDestroy();
    }
}
