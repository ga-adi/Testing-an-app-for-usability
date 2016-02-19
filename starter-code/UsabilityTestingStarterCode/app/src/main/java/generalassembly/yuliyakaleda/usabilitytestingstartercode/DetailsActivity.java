package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class DetailsActivity extends AppCompatActivity {
  public static final String SIGN = "sign";

  WebView mWebView;
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.details_activity_layout);

    Bundle extras = getIntent().getExtras();
    String sign = " ";

    if (extras != null) {
      sign = extras.getString(SIGN);
      mWebView=(WebView)findViewById(R.id.webView);
      mWebView.setWebViewClient(new MyWebClient());
      mWebView.getSettings().setJavaScriptEnabled(true);
      mWebView.loadUrl(String.valueOf(Uri.parse("http://www.horoscopedates.com/zodiac-signs/" + sign + "/")));
    }
  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    if((keyCode==KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
      mWebView.goBack();
      return true;

    }
    return super.onKeyDown(keyCode,event);
  }
}
