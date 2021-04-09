package com.geek.yourquiz;
import android.app.AlertDialog;
import android.content.Context;

public class AlertDialogClass {
   //  private final Activity requireActivity;
    private final Context context;
    private final String title;
    private final String message;
    private final int icon;

    public AlertDialogClass( Context context, String title, String message, int icon) {
        //this.requireActivity = requireActivity;
        this.context = context;
        this.title = title;
        this.message = message;
        this.icon = icon;
    }
    public AlertDialog getDialog(){
       AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setTitle(title);
        builder1.setIcon(icon);
        builder1.setMessage(message);
        builder1.setCancelable(true);
        builder1.setPositiveButton(
                "Ok",
                (dialog, id) ->dialog.cancel());
//        builder1.setNegativeButton
//                ("Cancel", (dialog, which) -> {
//                     requireActivity.finish();
//                });
        return builder1.create();
    }
}
