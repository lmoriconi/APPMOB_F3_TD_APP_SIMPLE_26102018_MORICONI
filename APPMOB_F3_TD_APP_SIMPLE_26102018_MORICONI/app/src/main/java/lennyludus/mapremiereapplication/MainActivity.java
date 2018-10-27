package lennyludus.mapremiereapplication;

import android.content.pm.ApplicationInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView dateView = null;
    EditText nameText = null;
    EditText firstNameText = null;
    EditText mailText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("[ADMIN]", "***** MON APPLICATION COMMENCE ICI *****");

        //AFFICHER DATE
        dateView = (TextView)findViewById(R.id.myDate);
        setDate(dateView);

        //CREER ADRESSE MAIL
        nameText = (EditText)findViewById(R.id.myName);
        firstNameText = (EditText)findViewById(R.id.myFirstName);
        mailText = (EditText)findViewById(R.id.myMail);

        firstNameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                String sFirstName = "";
                String sName = "";

                sName = nameText.getText().toString().toLowerCase();
                sFirstName = firstNameText.getText().toString().substring(0, 1).toLowerCase();

                mailText.setText(sFirstName + "." + sName + "@ludus-academie.com");
            }
        });
    }

    public void setDate (TextView view){
        Date today = Calendar.getInstance().getTime();  //getting date
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");    //format de l'heure
        String date = formatter.format(today);
        view.setText(date);
    }
}
