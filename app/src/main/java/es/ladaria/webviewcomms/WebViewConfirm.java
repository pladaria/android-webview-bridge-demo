package es.ladaria.webviewcomms;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.webkit.WebView;

class WebViewConfirm {
    static void show(final WebView webView, String message, String okText, String cancelText) {

        new AlertDialog.Builder(webView.getContext())
                .setMessage(message)
                .setPositiveButton(okText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        WebAppInterface.dispatch(webView, "alert", "ok");
                    }
                })
                .setNegativeButton(cancelText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        WebAppInterface.dispatch(webView, "alert", "cancel");
                    }
                }).show();
    }
}