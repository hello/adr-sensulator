package is.hello.sensulator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class SenseActivity extends Activity {
    private Button toggleRunning;
    private Emulator emulator;
    private @Nullable EmulatorServer server;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sense);

        this.emulator = new Emulator(getApplicationContext());

        this.toggleRunning = (Button) findViewById(R.id.activity_sense_run_toggle);
        toggleRunning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View sender) {
                togglePower();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sense, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void togglePower() {
        if (!emulator.isAdvertising()) {
            this.server = emulator.openServer();
            emulator.startAdvertising();

            toggleRunning.setText(R.string.action_stop);
        } else {
            emulator.stopAdvertising();

            toggleRunning.setText(R.string.action_start);
        }
    }
}
