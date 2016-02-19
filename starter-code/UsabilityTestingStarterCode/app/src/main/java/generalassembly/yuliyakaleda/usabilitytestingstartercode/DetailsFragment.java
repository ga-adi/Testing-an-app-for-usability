package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class DetailsFragment extends Fragment{

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    //TODO: Inflate the view and change the return type;
    View v= inflater.inflate(R.layout.details_fragment_layout,container,false);

    return v;

  }

  public void updateContent(String sign) {
    WebView webView = (WebView)getView().findViewById(R.id.webView_DetailsFragment);
    webView.loadUrl("http://www.horoscopedates.com/zodiac-signs/" + sign + "/");
    // TODO: Finish the method which will open a webview and redirect the user to the website
    // TODO: to read about the sign that was clicked in the ListView
  }
}
