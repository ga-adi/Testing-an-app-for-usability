package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ListFragment.OnSymbolSelectedListener {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //TODO: Create a separate layout xml file for tablet devices.

    final FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    ListFragment listFragment = new ListFragment();
    fragmentTransaction.add(R.id.fragment_list, listFragment);

    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
        DetailsFragment detailsFragment = new DetailsFragment();
        fragmentTransaction.add(R.id.fragment_details_webview, detailsFragment);
    }
    fragmentTransaction.commit();

  }

  @Override
  public void onSymbolSelected(String symbol) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra(DetailsActivity.SIGN, symbol);
            startActivity(intent);
        }else {
            FragmentManager fragmentManager = getSupportFragmentManager();
            DetailsFragment detailsFragment = new DetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("sign", symbol);
            detailsFragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
            fragmentTransaction1.add(R.id.fragment_details_webview, detailsFragment);
            fragmentTransaction1.commit();
        }
  }
}
