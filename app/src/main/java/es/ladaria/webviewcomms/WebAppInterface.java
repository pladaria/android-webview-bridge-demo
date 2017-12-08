package es.ladaria.webviewcomms;

import android.content.Context;
import android.os.Build;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.Toast;

public class WebAppInterface {
    private WebView wv;
    private Context ctx;

    WebAppInterface(WebView webView) {
        wv = webView;
        ctx = webView.getContext();
    }

    @JavascriptInterface
    public void toast(String toast) {
        Toast.makeText(ctx, toast, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void notifyPageReady() {
        Toast.makeText(ctx, "ready", Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void alert(String message, String okText, String cancelText) {
        WebViewConfirm.show(wv, message, okText, cancelText);
    }

    static void dispatch(final WebView webView, final String type, final String payload) {
        webView.post(new Runnable() {
            @Override
            public void run() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    String src = "WebView.dispatch({type: '" + type+"', payload: '" + payload+"'});";
                    webView.evaluateJavascript(src, cb);
                } else {
                    System.out.print("javascript:...");
                }
            }
        });
    }

    private static final ValueCallback<String> cb = new ValueCallback<String>() {
        @Override
        public void onReceiveValue(String s) {}
    };
}