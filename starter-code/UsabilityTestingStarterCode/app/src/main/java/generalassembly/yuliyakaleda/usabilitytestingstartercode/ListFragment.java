package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ListFragment extends Fragment {
    private final String SIGN = "sign";
    private ListView listView;
    onZodiacSelectedListener mCallback;

    public interface onZodiacSelectedListener {
        public void onSignSelected(String sign);
    }


//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        try {
//            mCallback = (onZodiacSelectedListener) getActivity();
//        } catch (ClassCastException e) {
//            throw new ClassCastException(getActivity().toString()
//                    + " must implement OnZodiacSelectedListener");
//        }
//    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (onZodiacSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
            + " must implement OnZodiacSelectedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_layout, container, false);
        listView = (ListView) view.findViewById(R.id.list_view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] values = getResources().getStringArray(R.array.signs);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // TODO: Write the logic that will check if the DetailsFragment is present next to the
            // TODO: ListFragment or not. If it is not (it is a handset), start DetailsActivity. If
            // TODO: it is present, get reference to DetailsFragment and call a method on it that will
            // TODO: open a webview with the information about the clicked sign.
//            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemValue = (String) listView.getItemAtPosition(position);

                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    mCallback.onSignSelected(itemValue);
                } else {
                    Intent intent = new Intent(getActivity(), DetailsActivity.class);
                    intent.putExtra(SIGN, itemValue);
                    startActivity(intent);

                }
            }
        });
    }
}
