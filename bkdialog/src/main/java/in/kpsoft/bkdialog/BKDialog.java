package in.kpsoft.bkdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BKDialog {
    private Context context;
    private Dialog dialog;

    private TextView tv_dialogTitle, tv_dialogMsg;
    private EditText et_dialogSearch;
    private Button btn_dialogBtn1, btn_dialogBtn2, btn_dialogBtn3;

    public static final int DIALOG_SUCCESS = 1;
    public static final int DIALOG_WARNING = 2;
    public static final int DIALOG_ERROR = 3;
    public static final int DIALOG_INFO = 4;

    //==============================================================================================
    //==============================================================================================

    public BKDialog(Context context) {
        this.context = context;
    }

    public Dialog getDialog() {
        return dialog;
    }

    public TextView getTv_dialogTitle() {
        return tv_dialogTitle;
    }

    public TextView getTv_dialogMsg() {
        return tv_dialogMsg;
    }

    public Button getBtn_dialogBtn1() {
        return btn_dialogBtn1;
    }

    public Button getBtn_dialogBtn2() {
        return btn_dialogBtn2;
    }

    public Button getBtn_dialogBtn3() {
        return btn_dialogBtn3;
    }

    //==============================================================================================
    //==============================================================================================

    private Dialog buildAlertDialog(Context context, int dialogType) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.bkdialog_alert);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams lWindowParams = new WindowManager.LayoutParams();
        lWindowParams.copyFrom(dialog.getWindow().getAttributes());
        lWindowParams.width = WindowManager.LayoutParams.FILL_PARENT;
        lWindowParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lWindowParams);

        tv_dialogTitle = (TextView) dialog.findViewById(R.id.bkdialog_title);
        tv_dialogMsg = (TextView) dialog.findViewById(R.id.bkdialog_msg);
        btn_dialogBtn1 = (Button) dialog.findViewById(R.id.bkdialog_btn1);
        btn_dialogBtn2 = (Button) dialog.findViewById(R.id.bkdialog_btn2);
        btn_dialogBtn3 = (Button) dialog.findViewById(R.id.bkdialog_btn3);

        switch (dialogType) {
            case DIALOG_SUCCESS:
                tv_dialogTitle.setTextColor(ContextCompat.getColor(context, R.color.bkDialog_success));
                btn_dialogBtn2.setTextColor(ContextCompat.getColor(context, R.color.bkDialog_success));
                break;
            case DIALOG_WARNING:
                tv_dialogTitle.setTextColor(ContextCompat.getColor(context, R.color.bkDialog_warning));
                btn_dialogBtn2.setTextColor(ContextCompat.getColor(context, R.color.bkDialog_warning));
                break;
            case DIALOG_ERROR:
                tv_dialogTitle.setTextColor(ContextCompat.getColor(context, R.color.bkDialog_error));
                btn_dialogBtn2.setTextColor(ContextCompat.getColor(context, R.color.bkDialog_error));
                break;
            case DIALOG_INFO:
                tv_dialogTitle.setTextColor(ContextCompat.getColor(context, R.color.bkDialog_info));
                btn_dialogBtn2.setTextColor(ContextCompat.getColor(context, R.color.bkDialog_info));
                break;
            default:
                tv_dialogTitle.setTextColor(ContextCompat.getColor(context, R.color.bkDialog_default));
                btn_dialogBtn2.setTextColor(ContextCompat.getColor(context, R.color.bkDialog_default));
                break;
        }

        return dialog;
    }

    //==============================================================================================
    //==============================================================================================

    public Dialog simpleAlert(String title, String msg) {
        return simpleAlert(title, msg, context.getString(R.string.bkDialog_ok), DIALOG_INFO);
    }

    public Dialog simpleAlert(String title, String msg, int dialogType) {
        return simpleAlert(title, msg, context.getString(R.string.bkDialog_ok), dialogType);
    }

    public Dialog simpleAlert(String title, String msg, String btn1, int dialogType) {
        dialog = buildAlertDialog(context, dialogType);

        tv_dialogTitle.setVisibility((title != null && title.length() > 0) ? View.VISIBLE : View.GONE);
        tv_dialogMsg.setVisibility((msg != null && msg.length() > 0) ? View.VISIBLE : View.GONE);
        btn_dialogBtn1.setVisibility((btn1 != null && btn1.length() > 0) ? View.VISIBLE : View.GONE);
        btn_dialogBtn2.setVisibility(View.GONE);
        btn_dialogBtn3.setVisibility(View.GONE);

        tv_dialogTitle.setText(title);
        tv_dialogMsg.setText(msg);
        btn_dialogBtn1.setText(btn1);

        btn_dialogBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        return dialog;
    }

    //==============================================================================================
    //==============================================================================================

    public Dialog confirmAlert(String title, String msg, String btn2) {
        return confirmAlert(title, msg, context.getString(R.string.bkDialog_cancel), btn2, DIALOG_INFO);
    }

    public Dialog confirmAlert(String title, String msg, String btn2, int dialogType) {
        return confirmAlert(title, msg, context.getString(R.string.bkDialog_cancel), btn2, dialogType);
    }

    public Dialog confirmAlert(String title, String msg, String btn1, String btn2, int dialogType) {
        dialog = buildAlertDialog(context, dialogType);

        tv_dialogTitle.setVisibility((title != null && title.length() > 0) ? View.VISIBLE : View.GONE);
        tv_dialogMsg.setVisibility((msg != null && msg.length() > 0) ? View.VISIBLE : View.GONE);
        btn_dialogBtn1.setVisibility((btn1 != null && btn1.length() > 0) ? View.VISIBLE : View.GONE);
        btn_dialogBtn2.setVisibility((btn2 != null && btn2.length() > 0) ? View.VISIBLE : View.GONE);
        btn_dialogBtn3.setVisibility(View.GONE);

        tv_dialogTitle.setText(title);
        tv_dialogMsg.setText(msg);
        btn_dialogBtn1.setText(btn1);
        btn_dialogBtn2.setText(btn2);

        btn_dialogBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        return dialog;
    }

    //==============================================================================================
    //==============================================================================================

    public Dialog selectionDialog(String title, ArrayList<BKDialogRowItemVo> itemVos, BKDialogSelectAdapter.AdapterListener listener, boolean searchable) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.bkdialog_selection);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams lWindowParams = new WindowManager.LayoutParams();
        lWindowParams.copyFrom(dialog.getWindow().getAttributes());
        lWindowParams.width = WindowManager.LayoutParams.FILL_PARENT;
        lWindowParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lWindowParams);

        tv_dialogTitle = (TextView) dialog.findViewById(R.id.bkdialog_title);
        tv_dialogMsg = (TextView) dialog.findViewById(R.id.bkdialog_msg);
        et_dialogSearch = (EditText) dialog.findViewById(R.id.bkdialog_search);
        TextView tv_noRecordFound = (TextView) dialog.findViewById(R.id.bkdialog_tvNoRecordFound);
        RecyclerView recyclerView = (RecyclerView) dialog.findViewById(R.id.bkdialog_recyclerView);

        tv_dialogTitle.setText(title);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new BKListItemDivider(context, DividerItemDecoration.VERTICAL, 0));
        BKDialogSelectAdapter bkDialogSelectAdapter = new BKDialogSelectAdapter(context, listener);
        recyclerView.setAdapter(bkDialogSelectAdapter);

        bkDialogSelectAdapter.setItemList(itemVos);
        bkDialogSelectAdapter.notifyDataSetChanged();
        tv_noRecordFound.setVisibility((itemVos != null && itemVos.size() > 0) ? View.VISIBLE : View.GONE);

        return dialog;
    }

    //==============================================================================================
    //==============================================================================================

    public static Dialog progressDialog(Context context) {
        return progressDialog(context, context.getString(R.string.bkDialog_loading));
    }

    public static Dialog progressDialog(Context context, String msg) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.bkdialog_progress);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);

        WindowManager.LayoutParams lWindowParams = new WindowManager.LayoutParams();
        lWindowParams.copyFrom(dialog.getWindow().getAttributes());
        lWindowParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lWindowParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lWindowParams);

        TextView dialog_msg = (TextView) dialog.findViewById(R.id.bkdialog_msg);
        dialog_msg.setText(msg);
        dialog_msg.setVisibility((msg != null && msg.length() > 0) ? View.VISIBLE : View.GONE);

        return dialog;
    }

    //==============================================================================================
    //==============================================================================================
}
