package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;


public class DetailsActivity extends AppCompatActivity {
    private static final String SIGN = "sign";
    WebView mWebViewB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity_layout);

        mWebViewB = (WebView) findViewById(R.id.webView);
        Bundle extras = getIntent().getExtras();
        String sign = " ";

        if (extras != null) {
            sign = extras.getString(SIGN);
            String[] horoscope = sign.split(":");

//      Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.horoscopedates.com/zodiac-signs/" + sign + "/"));
//      startActivity(browserIntent);

            mWebViewB.loadUrl("http://www.horoscopedates.com/zodiac-signs/" + horoscope[0].toLowerCase() + "/");
        }
    }
}
