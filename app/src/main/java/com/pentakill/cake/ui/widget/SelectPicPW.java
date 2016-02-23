package com.pentakill.cake.ui.widget;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.pentakill.cake.R;
import com.pentakill.cake.common.listener.PopupListener;

/**
 * Created by zoulux on 2016-02-16  22:18.
 */
public class SelectPicPW extends PopupWindow implements View.OnClickListener, PopupWindow.OnDismissListener {
    private static final String TAG = "SelectPicPW";
    private View contentView;
    private TextView tvSelectByAlbum;
    private TextView tvSelectByCamera;
    private TextView tvCancel;
    private PopupListener listener;

    private Activity contenxt;
    private Window window;

    public void setListener(PopupListener listener) {
        this.listener = listener;
    }

    public SelectPicPW(Activity context) {
        super(context);
        this.contenxt=context;
        window=context.getWindow();
        contentView = LayoutInflater.from(context).inflate(R.layout.popup_select_pic, null);
        tvSelectByAlbum = (TextView) contentView.findViewById(R.id.tv_select_album);
        tvSelectByCamera = (TextView) contentView.findViewById(R.id.tv_select_camera);
        tvCancel = (TextView) contentView.findViewById(R.id.tv_cancel);

        setContentView(contentView);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        setOutsideTouchable(true);
        setFocusable(true);

        tvSelectByAlbum.setOnClickListener(this);
        tvSelectByCamera.setOnClickListener(this);
        tvCancel.setOnClickListener(this);
        setOnDismissListener(this);

    }

    @Override
    public void onClick(View v) {
        dismiss();
        if (listener != null)
            switch (v.getId()) {
                case R.id.tv_select_album:
                    listener.onSelectFromAlbum();
                    break;
                case R.id.tv_select_camera:
                    listener.onSelectFromCamera();
                    break;

            }
    }


    @Override
    public void onDismiss() {
setAlpha(1.0f);
    }

    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        super.showAtLocation(parent, gravity, x, y);
        setAlpha(0.6f);
    }

   public void setAlpha(float a)
   {
       WindowManager.LayoutParams lp = window.getAttributes();
       lp.alpha=a;
       window.setAttributes(lp);


   }
}
