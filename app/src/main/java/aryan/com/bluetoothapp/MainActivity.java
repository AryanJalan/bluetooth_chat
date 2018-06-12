package aryan.com.bluetoothapp;

import android.bluetooth.BluetoothAdapter;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter=BluetoothAdapter.getDefaultAdapter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1) {
            String title = item.getTitle().toString();
            if (title.equals("Bluetooth OFF")) {
                adapter.enable();
                item.setTitle("Bluetooth ON");
                item.setIcon(getResources().getDrawable(R.drawable.bluetooth_on));
            } else if (title.equals("Bluetooth ON")) {
                adapter.disable();
                item.setTitle("Bluetooth OFF");
                item.setIcon(getResources().getDrawable(R.drawable.bluetooth_off));

            }
        }return true;

    }
}
