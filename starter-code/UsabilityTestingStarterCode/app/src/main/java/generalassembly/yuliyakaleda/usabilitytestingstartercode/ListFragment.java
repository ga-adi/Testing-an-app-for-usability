package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
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
  private static final String SIGN = "sign";
  private ListView listView;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_layout, container, false);
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

      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        int currentOrientation = ListFragment.this.getActivity().getResources().getConfiguration().orientation;
        if(currentOrientation == Configuration.ORIENTATION_PORTRAIT) {
          String input = (String) listView.getItemAtPosition(position);
          String[] sign = input.split(" ");
          Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.horoscopedates.com/zodiac-signs/" + sign[0] + "/"));
          browserIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
          startActivity(browserIntent);

        }else{

          Fragment f = getFragmentManager().findFragmentById(R.id.detail_frag);
          String input = (String) listView.getItemAtPosition(position);
          String[] sign = input.split(" ");
          DetailsFragment df = (DetailsFragment)f;
          df.updateContent(sign[0]);
//          if(f!=null){
//            Toast.makeText(ListFragment.this.getContext(), "FRAGMENT NOT NULL", Toast.LENGTH_SHORT).show();
//          }else{
//            Toast.makeText(ListFragment.this.getContext(), "FRAGMENT IS NULL", Toast.LENGTH_SHORT).show();
//          }
        }
        /*if (getFragmentManager().findFragmentById(R.id.linearLayoutDetailsFragment) != null) {
          //DetailsFragment
          //updateContent("aries");
          Toast.makeText(ListFragment.this.getContext(),"CLICKED HERE",Toast.LENGTH_SHORT).show();

        }else{
          String sign = (String) listView.getItemAtPosition(position);
          Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.horoscopedates.com/zodiac-signs/" + sign + "/"));
          browserIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
          startActivity(browserIntent);
//          String itemValue = (String) listView.getItemAtPosition(position);
//          Intent intent = new Intent(getActivity(), DetailsActivity.class);
//          intent.putExtra(SIGN, itemValue);
//          startActivity(intent);
        }*/

      }
    });
  }
}
