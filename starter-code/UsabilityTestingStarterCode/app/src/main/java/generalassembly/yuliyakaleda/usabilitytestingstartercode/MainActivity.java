package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
  implements ListFragment.OnSignSelectedListener {

  private static final String SIGN = "sign";
  private String mSelectedSign;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (savedInstanceState != null) {
      onSignSelected(savedInstanceState.getString(SIGN));
    }
  }

  @Override
  public boolean onSignSelected(String sign) {
    mSelectedSign = sign;
    DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager()
            .findFragmentById(R.id.detail_frag);
    if (detailsFragment != null) {
      detailsFragment.updateContent(sign);
      return true;
    }
    return false;
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    if (mSelectedSign != null) {
      outState.putString(SIGN, mSelectedSign);
    }
    super.onSaveInstanceState(outState);
  }
}
