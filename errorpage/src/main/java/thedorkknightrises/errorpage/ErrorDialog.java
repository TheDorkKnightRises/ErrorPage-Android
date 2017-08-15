package thedorkknightrises.errorpage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;


public class ErrorDialog extends Dialog {
    WebView errorView;
    Button reportButton, closeButton;
    Context context;

    public ErrorDialog(Context c) {
        super(c, ViewGroup.LayoutParams.MATCH_PARENT);
        this.context = c;

        setContentView(R.layout.activity_error);

        errorView = findViewById(R.id.errorView);
        errorView.getSettings().setLoadWithOverviewMode(true);
        errorView.getSettings().setUseWideViewPort(true);
        errorView.getSettings().setBuiltInZoomControls(true);

        reportButton = findViewById(R.id.reportButton);
        closeButton = findViewById(R.id.closeButton);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity) context).finishAffinity();
            }
        });
    }

    public ErrorDialog setError(String error) {
        errorView.loadData(error, "text/html", null);
        return this;
    }

    public ErrorDialog setError(String error, String mimeType, String encoding) {
        errorView.loadData(error, mimeType, encoding);
        return this;
    }

    public ErrorDialog setException(Exception error) {
        String errorText = Log.getStackTraceString(error);
        errorView.loadData(errorText, "text/html", null);
        return this;
    }

    public ErrorDialog setReportButtonVisibility(boolean visible) {
        if (visible) {
            reportButton.setVisibility(View.VISIBLE);
        } else {
            reportButton.setVisibility(View.GONE);
        }
        return this;
    }

    public ErrorDialog setOnReportButtonClickListener(View.OnClickListener onReportButtonClickListener) {
        reportButton.setOnClickListener(onReportButtonClickListener);
        return this;
    }

    public ErrorDialog setOnCloseButtonClickListener(View.OnClickListener onCloseButtonClickListener) {
        closeButton.setOnClickListener(onCloseButtonClickListener);
        return this;
    }

    public void show() {
        if (context == null) {
            throw new IllegalStateException("No context specified! Supply the context of the calling activity by calling `with()` first");
        } else {
            super.show();
        }
    }

}
