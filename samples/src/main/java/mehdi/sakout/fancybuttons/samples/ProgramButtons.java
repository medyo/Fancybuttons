package mehdi.sakout.fancybuttons.samples;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import mehdi.sakout.fancybuttons.FancyButton;


public class ProgramButtons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_buttons);


        FancyButton facebookLoginBtn = new FancyButton(this);
        facebookLoginBtn.setText("Login with Facebook");
        facebookLoginBtn.setBackgroundColor(Color.parseColor("#3b5998"));
        facebookLoginBtn.setFocusBackgroundColor(Color.parseColor("#5474b8"));
        facebookLoginBtn.setTextSize(17);
        facebookLoginBtn.setRadius(5);
        facebookLoginBtn.setIconResource("\uf082");
        facebookLoginBtn.setIconPosition(FancyButton.POSITION_LEFT);
        facebookLoginBtn.setFontIconSize(30);

        FancyButton foursquareBtn = new FancyButton(this);
        foursquareBtn.setText("Check in");
        foursquareBtn.setBackgroundColor(Color.parseColor("#0072b1"));
        foursquareBtn.setFocusBackgroundColor(Color.parseColor("#228fcb"));
        foursquareBtn.setTextSize(17);
        foursquareBtn.setRadius(5);
        foursquareBtn.setIconResource("\uf180");
        foursquareBtn.setIconPosition(FancyButton.POSITION_TOP);
        foursquareBtn.setFontIconSize(30);

        FancyButton installBtn = new FancyButton(this);
        installBtn.setText("Google play install");
        installBtn.setBackgroundColor(Color.parseColor("#a4c639"));
        installBtn.setFocusBackgroundColor(Color.parseColor("#bfe156"));
        installBtn.setTextSize(17);
        installBtn.setRadius(5);
        installBtn.setIconPadding(0,30,0,0);

        FancyButton signupBtn = new FancyButton(this);
        signupBtn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        signupBtn.setText("Repost the song");
        signupBtn.setIconResource(R.drawable.soundcloud);
        signupBtn.setBackgroundColor(Color.parseColor("#ff8800"));
        signupBtn.setFocusBackgroundColor(Color.parseColor("#ffa43c"));
        signupBtn.setTextSize(20);
        signupBtn.setCustomTextFont("robotothin.ttf");
        signupBtn.setIconPadding(10,0,10,0);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0,0,0,10);

        LinearLayout container = (LinearLayout)findViewById(R.id.container);
        container.addView(facebookLoginBtn,layoutParams);
        container.addView(foursquareBtn,layoutParams);
        container.addView(installBtn,layoutParams);
        container.addView(signupBtn);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.program_buttons, menu);
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

}