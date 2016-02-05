package tk.gamecraftpe.gamecraftpe;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Driesboy on 1/02/16.
 */
public class Vote extends Activity {

    private static final String TAG = "Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vote);

        String url = "http://minecraftpocket-servers.com/server/30206/vote/";
        WebView view = (WebView) this.findViewById(R.id.webView);

        view.getSettings().setJavaScriptEnabled(true);

        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();


        final ProgressDialog progressBar = ProgressDialog.show(Vote.this, "Loading","Please wait");

        view.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.i(TAG, "Processing webview url click...");
                view.loadUrl(url);
                return true;
            }

            public void onPageFinished(WebView view, String url) {
                Log.i(TAG, "Finished loading URL: " + url);
                if (progressBar.isShowing()) {
                    progressBar.dismiss();
                }
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Log.e(TAG, "Error: " + description);

            }
        });
        view.loadUrl(url);
    }
    @Override
    public void onBackPressed() {
        Intent i = null;
        i = new Intent(Vote.this, MainActivity.class);
        startActivity(i);
        finish();
        super.onBackPressed();
    }
}