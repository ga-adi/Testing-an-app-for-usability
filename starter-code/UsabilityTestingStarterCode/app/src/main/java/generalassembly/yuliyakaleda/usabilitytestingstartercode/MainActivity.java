package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
  public WebView webView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    webView = (WebView) findViewById(R.id.webView);

    //TODO: Create a separate layout xml file for tablet devices.
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    DetailsFragment detailsFragment = new DetailsFragment();
    ListFragment listFragment = new ListFragment();

    fragmentTransaction.add(R.id.listContainer,listFragment);
    if (fragmentManager.findFragmentById(R.id.detailContainer) instanceof DetailsFragment){
    fragmentTransaction.add(R.id.detailContainer,detailsFragment);}
    fragmentTransaction.commit();
  }
}
