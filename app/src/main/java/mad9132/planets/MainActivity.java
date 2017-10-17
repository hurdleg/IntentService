package mad9132.planets;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import mad9132.planets.services.MyService;

/**
 * Manage requests with class IntentService.
 *
 * @author Gerald.Hurdle@AlgonquinCollege.com
 * @author David Gassner (original)
 *
 * Reference: Chapter 2. Manage Multithreading in Android
 *            "Android App Development: RESTful Web Services" with David Gassner
 */
public class MainActivity extends Activity {

    private static final Boolean IS_LOCALHOST;
    private static final String JSON_URL;

    private TextView output;

    // TODO: use Java's static block ( {} ) initializer to initialize class (i.e. static) variables.
    static {
        IS_LOCALHOST = false;
        JSON_URL = IS_LOCALHOST ? "http://10.0.2.2:3000/planets" : "https://planets.mybluemix.net/planets";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (TextView) findViewById(R.id.output);
    }

    public void runClickHandler(View view) {
        Intent intent = new Intent(this, MyService.class);
        intent.setData(Uri.parse(JSON_URL));
        startService(intent);
        startService(intent);
        startService(intent);
    }

    public void clearClickHandler(View view) {
        output.setText("");
    }
}
