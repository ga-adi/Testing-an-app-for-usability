package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class DetailsFragment extends Fragment{
  static WebView mWebView;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    //TODO: Inflate the view and change the return type;

    View frag = inflater.inflate(R.layout.fragment_detail,container,false);
    mWebView = (WebView) frag.findViewById(R.id.webView);
    mWebView.loadUrl("http://www.horoscopedates.com/zodiac-signs/");

    return frag;
  }

  public void updateContent(String sign) {
    // TODO: Finish the method which will open a webview and redirect the user to the website
    // TODO: to read about the sign that was clicked in the ListView

    String url =  "http://www.horoscopedates.com/zodiac-signs/" + sign + "/";
    mWebView.loadUrl(url);
  }
}
