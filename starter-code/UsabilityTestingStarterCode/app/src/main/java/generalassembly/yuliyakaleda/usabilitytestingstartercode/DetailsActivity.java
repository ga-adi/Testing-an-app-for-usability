package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;


public class DetailsActivity extends AppCompatActivity {
  private static final String SIGN = "sign";
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.details_activity_layout);

    Bundle extras = getIntent().getExtras();

    if (extras != null) {
      String sign = extras.getString(SIGN);
      WebView webView = (WebView) findViewById(R.id.web_view);
      webView.loadUrl("http://www.horoscopedates.com/zodiac-signs/" + sign + "/");
    }
  }
}
