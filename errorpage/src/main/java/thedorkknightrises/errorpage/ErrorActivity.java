package thedorkknightrises.errorpage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;

public class ErrorActivity extends Dialog {
    WebView errorView;
    Button reportButton, closeButton;
    Context context;

    public ErrorActivity(Context c) {
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

    public ErrorActivity setError(String error) {
        errorView.loadData(error, "text/html", null);
        return this;
    }

    public ErrorActivity setError(String error, String mimeType, String encoding) {
        errorView.loadData(error, mimeType, encoding);
        return this;
    }

    public ErrorActivity setException(Exception error) {
        String errorText = Log.getStackTraceString(error);
        errorView.loadData(errorText, "text/html", null);
        return this;
    }

    public ErrorActivity setOnReportButtonClickListener(View.OnClickListener onReportButtonClickListener) {
        reportButton.setOnClickListener(onReportButtonClickListener);
        return this;
    }

    public ErrorActivity setOnCloseButtonClickListener(View.OnClickListener onCloseButtonClickListener) {
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
