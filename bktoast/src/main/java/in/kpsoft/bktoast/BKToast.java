package in.kpsoft.bktoast;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

public class BKToast extends Toast {

    public static final int TYPE_SUCCESS = 1;
    public static final int TYPE_WARNING = 2;
    public static final int TYPE_ERROR = 3;
    public static final int TYPE_INFO = 4;
    public static final int TYPE_RETRY = 5;

    public static final int LENGTH_LONG = Toast.LENGTH_LONG;
    public static final int LENGTH_SHORT = Toast.LENGTH_SHORT;

    public static final int GRAVITY_TOP = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
    public static final int GRAVITY_TOP_LEFT = Gravity.TOP | Gravity.START;
    public static final int GRAVITY_TOP_RIGHT = Gravity.TOP | Gravity.END;
    public static final int GRAVITY_BOTTOM = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
    public static final int GRAVITY_BOTTOM_LEFT = Gravity.BOTTOM | Gravity.START;
    public static final int GRAVITY_BOTTOM_RIGHT = Gravity.BOTTOM | Gravity.END;
    public static final int GRAVITY_CENTER = Gravity.CENTER;
    public static final int GRAVITY_CENTER_LEFT = Gravity.CENTER_VERTICAL | Gravity.START;
    public static final int GRAVITY_CENTER_RIGHT = Gravity.CENTER_VERTICAL | Gravity.END;

    private Context context;

    public BKToast(Context context) {
        super(context);
        this.context = context;
    }

    public static BKToast makeText(Context context, String message) {
        return makeText(context, message, Toast.LENGTH_SHORT, 0, GRAVITY_BOTTOM);
    }

    public static BKToast makeText(Context context, String message, int duration) {
        return makeText(context, message, duration, 0, GRAVITY_BOTTOM);
    }

    public static BKToast makeText(Context context, String message, int duration, int type) {
        return makeText(context, message, duration, type, GRAVITY_BOTTOM);
    }

    public static BKToast makeText(Context context, String message, int duration, int type, int gravity) {
        BKToast bkToast = new BKToast(context);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.bktoast_layout, null);
        ImageView bkIcon = (ImageView) view.findViewById(R.id.bktoast_icon);
        TextView bkText = (TextView) view.findViewById(R.id.bktoast_text);

        switch (type) {
            case TYPE_SUCCESS:
                bkIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.bktoast_icon_success));
                view.setBackground(ContextCompat.getDrawable(context, R.drawable.bktoast_bg_success));
                break;
            case TYPE_WARNING:
                bkIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.bktoast_icon_warning));
                view.setBackground(ContextCompat.getDrawable(context, R.drawable.bktoast_bg_warning));
                break;
            case TYPE_ERROR:
                bkIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.bktoast_icon_error));
                view.setBackground(ContextCompat.getDrawable(context, R.drawable.bktoast_bg_error));
                break;
            case TYPE_INFO:
                bkIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.bktoast_icon_info));
                view.setBackground(ContextCompat.getDrawable(context, R.drawable.bktoast_bg_info));
                break;
            case TYPE_RETRY:
                bkIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.bktoast_icon_retry));
                view.setBackground(ContextCompat.getDrawable(context, R.drawable.bktoast_bg_retry));
                break;
            default:
                bkIcon.setVisibility(View.GONE);
                bkText.setTextColor(Color.parseColor("#222222"));
                view.setBackground(ContextCompat.getDrawable(context, R.drawable.bktoast_bg_default));
                break;
        }

        int offsetX = 0, offsetY = 0;
        switch (gravity) {
            case GRAVITY_TOP_LEFT:
            case GRAVITY_TOP_RIGHT:
                offsetX = 50;
            case GRAVITY_TOP:
                offsetY = 100;
                break;
            case GRAVITY_BOTTOM_LEFT:
            case GRAVITY_BOTTOM_RIGHT:
                offsetX = 50;
            case GRAVITY_BOTTOM:
                offsetY = 100;
                break;
            case GRAVITY_CENTER_LEFT:
            case GRAVITY_CENTER_RIGHT:
                offsetX = 50;
            case GRAVITY_CENTER:
                offsetY = 0;
                break;
            default:
                offsetX = 0;
                offsetY = 0;
                break;
        }

        bkText.setText(message);
        bkToast.setDuration(duration);
        bkToast.setView(view);
        bkToast.setGravity(gravity, offsetX, offsetY);

        return bkToast;
    }
}
