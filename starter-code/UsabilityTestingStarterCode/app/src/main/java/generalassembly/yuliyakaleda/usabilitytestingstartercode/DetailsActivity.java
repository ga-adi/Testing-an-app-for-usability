package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


public class DetailsActivity extends AppCompatActivity {
  private static final String SIGN = "sign";
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.details_activity_layout);

      getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//      FragmentManager fragmentManager = getSupportFragmentManager();
//      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//      DetailsFragment detailsFragment = new DetailsFragment();
//
//      String sign = getIntent().getExtras().getString(SIGN);
//      Bundle bundle = new Bundle();
//      bundle.putString("SIGN_KEY", sign);
//      detailsFragment.setArguments(bundle);
//
//      fragmentTransaction.add(R.id.fragment_container, detailsFragment);
//      fragmentTransaction.commit();
//
//      if(getResources().getBoolean(R.bool.isTablet)){
//          FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
//          fragmentTransaction1.add(R.id.fragment_container_two,new DetailsFragment());
//      }



//    Bundle extras = getIntent().getExtras();
//    String sign = " ";
//
//    if (extras != null) {
//      sign = extras.getString(SIGN);
//      Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.horoscopedates.com/zodiac-signs/" + sign + "/"));
//      startActivity(browserIntent);
//    }
  }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
