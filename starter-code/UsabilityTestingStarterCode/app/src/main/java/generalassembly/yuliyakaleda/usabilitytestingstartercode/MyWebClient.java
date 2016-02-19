package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Ra on 2/18/16.
 */
public class MyWebClient extends WebViewClient {
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;

    }
}
