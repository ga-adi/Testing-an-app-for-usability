package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  private String mURL = "http://www.google.com";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    ListFragment listFragment = new ListFragment();
    fragmentTransaction.add(R.id.frame_layout, listFragment);
    fragmentTransaction.commit();

    //TODO: Create a separate layout xml file for tablet devices.
  }

  public void swapFragment(String listItem){
    this.mURL = listItem;
    DetailsFragment detailsFragment = new DetailsFragment();
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    transaction.replace(R.id.frame_layout, detailsFragment);
    transaction.addToBackStack(null);
    transaction.commit();
  }

  public String getUrl(){
    return mURL;
  }
}
