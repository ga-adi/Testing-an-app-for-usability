package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity
  implements ListFragment.OnZodiacSelectedListener {

    FragmentManager fragmentManager;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //TODO: Create a separate layout xml file for tablet devices.
      fragmentManager = getSupportFragmentManager();
      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
      fragmentTransaction.add(R.id.fragment_container,new ListFragment());
      fragmentTransaction.commit();


  }

  @Override
  public void onZodiacSelected(String sign) {
    if(getResources().getBoolean(R.bool.isTablet)){
      DetailsFragment detailsFragment = new DetailsFragment();
      detailsFragment.updateContent(sign);
      FragmentManager fragmentManager = getSupportFragmentManager();
      FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
      fragmentTransaction1.replace(R.id.fragment_container_two, detailsFragment);
      fragmentTransaction1.commit();
    }else {
      DetailsFragment detailsFragment = new DetailsFragment();
      detailsFragment.updateContent(sign);
      FragmentManager fragmentManager = getSupportFragmentManager();
      FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
      fragmentTransaction1.replace(R.id.fragment_container, detailsFragment);
      fragmentTransaction1.commit();
    }

      //  }
  }
}
