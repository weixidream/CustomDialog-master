package com.liuhc.library.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * DialogBuild
 * Created by Liuhuacheng.
 * Created time 16/1/27.
 */
public class DialogBuilder extends Dialog implements DialogInterface, View.OnClickListener {
    private static Context mContext;

    private static DialogBuilder instance;
    private View mDialogView;
    private TextView dialog_title;
    private TextView dialog_content;
    private TextView confirm_ok;
    private TextView confirm_cancel;
    private View confirm_line;
    private LinearLayout confirm_layout;

    private OnClickListener mCancelClickListener;
    private OnClickListener mConfirmClickListener;

    public static interface OnClickListener {
        public void onClick(DialogBuilder dialogBuilder);
    }

    public DialogBuilder(Context context) {
        super(context);
        init(context);
    }

    public DialogBuilder(Context context, int theme) {
        super(context, theme);
        init(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes((WindowManager.LayoutParams) params);

    }

    public static DialogBuilder getInstance(Context context) {
        if (instance == null || !mContext.equals(context)) {
            synchronized (DialogBuilder.class) {
                if (instance == null || !mContext.equals(context)) {
                    instance = new DialogBuilder(context, R.style.CustomDialog);
                }
            }
        }
        mContext = context;
        return instance;
    }

    private void init(Context context) {
        mDialogView = View.inflate(context, R.layout.dialog_view, null);
        dialog_title = (TextView) mDialogView.findViewById(R.id.dialog_title);
        confirm_line = mDialogView.findViewById(R.id.confirm_line);
        confirm_layout = (LinearLayout) mDialogView.findViewById(R.id.confirm_layout);
        dialog_content = (TextView) mDialogView.findViewById(R.id.confirm_content);
        confirm_ok = (TextView) mDialogView.findViewById(R.id.confirm_ok);
        confirm_cancel = (TextView) mDialogView.findViewById(R.id.confirm_cancel);
        confirm_ok.setOnClickListener(this);
        confirm_cancel.setOnClickListener(this);
        setContentView(mDialogView);
    }

    public DialogBuilder withTitleColor(String colorString) {
        if (dialog_title != null) {
            dialog_title.setTextColor(Color.parseColor(colorString));
        }
        return this;
    }

    public DialogBuilder withTitleColor(int color) {
        if (dialog_title != null) {
            dialog_title.setTextColor(color);
        }
        return this;
    }

    public DialogBuilder withContentColor(String colorString) {
        if (dialog_content != null) {
            dialog_content.setTextColor(Color.parseColor(colorString));
        }
        return this;
    }

    public DialogBuilder withContentColor(int color) {
        if (dialog_content != null) {
            dialog_content.setTextColor(color);
        }
        return this;
    }

    public DialogBuilder withTitle(String mTitleText) {
        if (dialog_title != null && !TextUtils.isEmpty(mTitleText)) {
            dialog_title.setVisibility(View.VISIBLE);
            dialog_title.setText(mTitleText);
            if (confirm_line != null) {
                confirm_line.setVisibility(View.VISIBLE);
            }
        } else {
            dialog_title.setVisibility(View.GONE);
        }

        return this;
    }

    public DialogBuilder withTitle(int textResId) {
        if (dialog_title != null) {
            dialog_title.setVisibility(View.VISIBLE);
            dialog_title.setText(textResId);
        }
        return this;
    }

    public DialogBuilder withContent(String mContentText) {
        if (dialog_content != null) {
            dialog_content.setText(mContentText);
        }
        return this;
    }

    //设置内容居左显示
    public DialogBuilder setContentLeft() {
        if (dialog_content != null) {
            dialog_content.setGravity(View.TEXT_ALIGNMENT_TEXT_START);
            int padding = (int) mContext.getResources().getDimension(R.dimen.dialog_content_padding);
            dialog_content.setPadding(padding, padding, padding, padding);
        }
        return this;
    }

    public DialogBuilder withContent(int mContentText) {
        if (dialog_content != null) {
            dialog_content.setText(mContentText);
        }
        return this;
    }

    //外部点击取消
    public DialogBuilder isCancelableOutside(boolean cancelable) {
        this.setCanceledOnTouchOutside(cancelable);
        return this;
    }

    //能否取消
    public DialogBuilder isCancelable(boolean cancelable) {
        this.setCancelable(cancelable);
        return this;
    }

    //是否显示取消按钮
    public DialogBuilder showCancelButton(boolean mShowCancel) {
        if (confirm_cancel != null) {
            confirm_cancel.setVisibility(mShowCancel ? View.VISIBLE : View.GONE);
        }
        return this;
    }

    public DialogBuilder showConfirmlayout(boolean mShowConfirm) {
        if (confirm_layout != null) {
            confirm_layout.setVisibility(mShowConfirm ? View.VISIBLE : View.GONE);
        }
        return this;
    }

    public DialogBuilder withCancelText(String mCancelText) {
        if (confirm_cancel != null && mCancelText != null) {
            confirm_cancel.setText(mCancelText);
            confirm_cancel.setVisibility(View.VISIBLE);
        }
        return this;
    }

    public DialogBuilder withCancelText(int mCancelText) {
        if (confirm_cancel != null) {
            confirm_cancel.setText(mCancelText);
            confirm_cancel.setVisibility(View.VISIBLE);
        }
        return this;
    }

    public DialogBuilder withConfirmText(String mConfirmText) {
        if (confirm_ok != null && mConfirmText != null) {
            confirm_ok.setText(mConfirmText);
        }
        return this;
    }

    public DialogBuilder withConfirmText(int mConfirmText) {
        if (confirm_ok != null) {
            confirm_ok.setText(mConfirmText);
        }
        return this;
    }

    public DialogBuilder setCancelClickListener(OnClickListener listener) {
        mCancelClickListener = listener;
        return this;
    }

    public DialogBuilder setConfirmClickListener(OnClickListener listener) {
        mConfirmClickListener = listener;
        return this;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.confirm_cancel) {
            if (mCancelClickListener != null) {
                mCancelClickListener.onClick(this);
            }
            dismiss();
        } else if (v.getId() == R.id.confirm_ok) {
            if (mConfirmClickListener != null) {
                mConfirmClickListener.onClick(this);
            }
            dismiss();
        }
    }

}
