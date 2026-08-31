package br.com.floating_button.floating_button;

import android.os.Bundle;
import android.widget.ImageView;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.plugin.common.MethodChannel;

import com.yhao.floatwindow.FloatWindow;
import com.yhao.floatwindow.Screen;


public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "floating_button";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        MethodChannel channel = new MethodChannel(
            getFlutterEngine().getDartExecutor().getBinaryMessenger(), 
            CHANNEL
        );

        channel.setMethodCallHandler(
            (call, result) -> {
                switch(call.method) {
                    case "create":
                        ImageView imageView = new ImageView(getApplicationContext());
                        imageView.setImageResource(R.drawable.plus);

                        FloatWindow.with(getApplicationContext()).setView(imageView)
                        .setWidth(Screen.width, 0.15f)
                        .setHeight(Screen.width, 0.15f)
                        .setX(Screen.width, 0.8f)
                        .setY(Screen.height, 0.3f)
                        .setDesktopShow(true)
                        .build();

                        result.success(null);
                        break;
                    case "show":
                        FloatWindow.get().show();
                        result.success(null);
                        break;
                    case "hide":
                        FloatWindow.get().hide();
                        result.success(null);
                        break;
                    default:
                        result.notImplemented();
                        break;
                }
            }
        );
    }
}
