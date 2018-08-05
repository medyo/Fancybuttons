package mehdi.sakout.fancybuttons.samples;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity implements AdapterView.OnItemClickListener {

    String[] listItems = {"XML buttons", "Programmatically Buttons",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems));
        getListView().setOnItemClickListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        switch (position) {
            case 0:
                Intent intentXML = new Intent(MainActivity.this, XmlButtons.class);
                startActivity(intentXML);

                break;
            case 1:
                Intent intentProg = new Intent(MainActivity.this, ProgramButtons.class);
                startActivity(intentProg);
                break;
            default:
                throw new IllegalArgumentException("Hold up, hold my phone :)");
        }
    }
}
