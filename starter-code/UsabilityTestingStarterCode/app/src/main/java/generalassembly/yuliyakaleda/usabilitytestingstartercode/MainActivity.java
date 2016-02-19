package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

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

    public void swapFragment(String prefix) {
        String url = "http://www.horoscopedates.com/zodiac-signs/" + prefix + "/";
        DetailsFragment detailsFragment = new DetailsFragment(url);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, detailsFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
