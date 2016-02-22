package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static generalassembly.yuliyakaleda.usabilitytestingstartercode.DetailsActivity.*;


public class DetailsFragment extends Fragment{
  WebView webView;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
      View view= inflater.inflate(R.layout.details_fragment,container,false);
    WebView webView= (WebView)view.findViewById(R.id.webViewFragment);
    Bundle bundle1= this.getArguments();
    if(bundle1!=null && bundle1.getString("sign")!=null) {
      String myString= bundle1.getString("sign").toLowerCase();
      webView.getSettings().setJavaScriptEnabled(true);
      webView.setWebViewClient(new MyWebClient());
      webView.loadUrl(String.valueOf(Uri.parse("http://www.horoscopedates.com/zodiac-signs/" + myString + "/")));
    }
//    webView.setWebViewClient(new WebViewClient() {
//      @Override
//      public boolean shouldOverrideUrlLoading(WebView view, String url) {
//        view.loadUrl(url);
//        return true;
//      }
//    });
//    webView.setWebViewClient(new WebViewClient());

    //TODO: Inflate the view and change the return type;
    return view;
  }

  public void updateContent(String sign) {

    // TODO: Finish the method which will open a webview and redirect the user to the website
    // TODO: to read about the sign that was clicked in the ListView
  }
//  public class myWebClient extends WebViewClient {
//    @Override
//    public void onPageStarted(WebView view, String url, Bitmap favicon) {
//      super.onPageStarted(view, url, favicon);
//    }
//
//    @Override
//    public boolean shouldOverrideUrlLoading(WebView view, String url) {
//      view.loadUrl(url);
//      return true;
//
//    }
//  }

  }

