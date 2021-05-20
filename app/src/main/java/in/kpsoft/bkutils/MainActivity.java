package in.kpsoft.bkutils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import in.kpsoft.bkcalender.BKCalender;
import in.kpsoft.bkdialog.BKDialog;
import in.kpsoft.bktoast.BKToast;

public class MainActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        BKToast.makeText(context, "Simple Toast", BKToast.LENGTH_LONG, BKToast.TYPE_SUCCESS).show();
        String today = BKCalender.getCurrentDate("dd-MM-yyyy");
        new BKDialog(context).simpleAlert("This is simple alert!\n"+today, "This is simple alert message long description.", BKDialog.DIALOG_SUCCESS).show();
    }
}