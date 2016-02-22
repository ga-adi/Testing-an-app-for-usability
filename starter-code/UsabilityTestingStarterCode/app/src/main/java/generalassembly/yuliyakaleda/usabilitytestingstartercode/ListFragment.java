package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class ListFragment extends Fragment {
  private static final String SIGN = "sign";
  private ListView listView;
    OnSymbolSelectedListener mCallback;


  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_layout, container, false);
    listView = (ListView) view.findViewById(R.id.list_view);

    return view;
  }
    public interface OnSymbolSelectedListener{
        public void onSymbolSelected(String symbol);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            mCallback= (OnSymbolSelectedListener)activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+ "must implement OnSymbolSelected");
        }
    }

    @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    String[] values = getResources().getStringArray(R.array.signs);
        String[] birthdays = {"1/11-2/19","2/20-3/20","3/21-4/20","4/21-5/21","5/22-6/21", "6/22-7/22","7/23-8/23","8/24-9/23","9/24-10/23","10/24-11/22","11/23-12/21","12/22-1/20"};

//    ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
//        R.layout.zodiac_list_layout, R.id.zodiac_name, values);
        ArrayList<Zodiac> zodiacArrayList = new ArrayList<>();
        for (int i = 0; i<values.length;i++){
            zodiacArrayList.add(new Zodiac(values[i],birthdays[i]));
        }

        ZodiacArrayAdapter arrayAdapter = new ZodiacArrayAdapter(getActivity(), zodiacArrayList);
        listView.setAdapter(arrayAdapter);
   // listView.setAdapter(adapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      // TODO: Write the logic that will check if the DetailsFragment is present next to the
      // TODO: ListFragment or not. If it is not (it is a handset), start DetailsActivity. If
      // TODO: it is present, get reference to DetailsFragment and call a method on it that will
      // TODO: open a webview with the information about the clicked sign.



      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //  String itemValue = (String) listView.getItemAtPosition(position);
          TextView zodiacText = (TextView) view.findViewById(R.id.zodiac_name);
          String itemValue = zodiacText.getText().toString();
          mCallback.onSymbolSelected(itemValue);
//        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
//            Intent intent = new Intent(getActivity(), DetailsActivity.class);
//            intent.putExtra(SIGN, itemValue);
//            startActivity(intent);
//        }else {
//            FragmentManager fragmentManager = getFragmentManager();
//            DetailsFragment detailsFragment = new DetailsFragment();
//            Bundle bundle = new Bundle();
//            bundle.putString("sign", itemValue);
//            detailsFragment.setArguments(bundle);
//            FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
//            fragmentTransaction1.add(R.id.fragment_container1, detailsFragment);
//            fragmentTransaction1.commit();
//        }
    }
  });
}}
