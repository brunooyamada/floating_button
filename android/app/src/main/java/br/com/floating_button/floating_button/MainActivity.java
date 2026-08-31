package br.com.floating_button.floating_button;

import android.os.Bundle;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "floating_button";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        MethodChannel channel = new MethodChannel(
            getFlutterEngine().getDartExecutor().getBinaryMessenger(), 
            CHANNEL
        );

        channel.setMethodCallHandler((call, result) -> {
            
        });
    }
}
