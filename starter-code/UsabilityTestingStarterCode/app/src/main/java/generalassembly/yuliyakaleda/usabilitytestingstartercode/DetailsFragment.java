package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class DetailsFragment extends Fragment{

    WebView mWebview;
    String mSignText;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
      View detailsView = inflater.inflate(R.layout.details_fragment_layout, container, false);
      mWebview = (WebView) detailsView.findViewById(R.id.webview);
      mWebview.loadUrl("http://www.horoscopedates.com/zodiac-signs/" + mSignText.toLowerCase() + "/");

      return detailsView;
  }


    public void updateContent(String sign) {
        mSignText = sign;
    }
}
