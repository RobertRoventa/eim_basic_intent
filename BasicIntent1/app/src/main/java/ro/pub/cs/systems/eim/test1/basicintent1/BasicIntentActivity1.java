package ro.pub.cs.systems.eim.test1.basicintent1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class BasicIntentActivity1 extends AppCompatActivity {
    Button createintentButton = null;
    createIntentButtonListener createIntentButtonListener = new createIntentButtonListener();
    private class createIntentButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = new Intent("ro.pub.cs.systems.eim.test1.basicintentactivity2.intent.action.basicintentactivity2");
            intent.putExtra("asd","true");
            startActivityForResult(intent, 1);
            Toast.makeText(getApplication(), "S-a trimis intent-ul", Toast.LENGTH_LONG).show();


        }
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_intent1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        createintentButton = (Button)findViewById(R.id.createintentbutton);
        createintentButton.setOnClickListener(createIntentButtonListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_basic_intent_activity1, menu);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (requestCode) {
            case 1:
                Log.d("Intent1", "Intent trimis si primit cu bine");
                setResult(resultCode, new Intent());

                break;
        }
    }
}
