package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements ListFragment.onZodiacSelectedListener{

    public DetailsFragment mDetailsFragment;
    public static ListFragment mListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO: Create a separate layout xml file for tablet devices.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TODO: Create a separate layout xml file for tablet devices.
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (mListFragment == null) {
            mListFragment = new ListFragment();
        }
            fragmentTransaction.replace(R.id.list_fragment_container, mListFragment);


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            mDetailsFragment = new DetailsFragment();
            fragmentTransaction.add(R.id.details_fragment_container, mDetailsFragment);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onSignSelected(String sign) {
        mDetailsFragment.updateContent(sign);
    }
}
