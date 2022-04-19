package in.kpsoft.bkutils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import in.kpsoft.bkcalender.BKCalender;
import in.kpsoft.bkdialog.BKDialog;
import in.kpsoft.bktoast.BKToast;

public class MainActivity extends AppCompatActivity {

    Context context;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;

        textView = (TextView) findViewById(R.id.textview);
        textView.setText(BKCalender.getCurrentDate("dd-MM-yyyy hh:mm a"));

        //BKToast.makeText(context, "Simple Toast", BKToast.LENGTH_LONG, BKToast.TYPE_SUCCESS).show();
        //String today = BKCalender.getCurrentDate("dd-MM-yyyy");
        //new BKDialog(context).simpleAlert("This is simple alert!\n"+today, "This is simple alert message long description.").show();
    }

    @Override
    protected void onResume() {
        textView.setText(BKCalender.getCurrentDate("dd-MM-yyyy hh:mm a"));
        super.onResume();
    }
}