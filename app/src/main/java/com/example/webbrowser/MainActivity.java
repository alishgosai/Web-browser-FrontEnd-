package com.example.webbrowser;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private EditText urlBox;
    private Button goButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link UI components to Java code
        webView = findViewById(R.id.webView);
        urlBox = findViewById(R.id.urlBox);
        goButton = findViewById(R.id.goButton);

        // Enable JavaScript in the WebView
        webView.getSettings().setJavaScriptEnabled(true);

        // Set WebViewClient to handle loading within the app
        webView.setWebViewClient(new WebViewClient());

        // Set the button click listener
        goButton.setOnClickListener(view -> {
            String url = urlBox.getText().toString();
            if (!url.startsWith("https://") && !url.startsWith("http://")) {
                url = "https://" + url; // Add "https://" if missing
            }
            webView.loadUrl(url);
        });
    }
}
