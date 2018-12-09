package com.acc.gp.quick.note.customviews;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.acc.gp.quick.note.R;


public class NavigationBar extends RelativeLayout implements OnClickListener {
//    private INavigationOnClick navigationOnClick;
    private ImageView imgLeft;
    private ImageView imgRight;
    private LinearLayout lnLeft;
    private LinearLayout lnRight;
    private LinearLayout lnSearch;
    private TextView tvTitle;
    private AppBarLayout app_barQuestion;
    private EditText edtSearch;
    private ImageView imgClear;

    public NavigationBar(Context context) {
        super(context);
        initialView();
    }

    public NavigationBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialView();

    }

    public NavigationBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialView();

    }

    private void initialView() {
        if (isInEditMode()) {
            return;
        }
        View view = View.inflate(getContext(), R.layout.navigation_bar, null);

        if (view != null) {
            addView(view, new LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            imgLeft = view.findViewById(R.id.img_left);
            imgRight = view.findViewById(R.id.img_right);
            lnLeft = view.findViewById(R.id.ln_left);
            lnRight = view.findViewById(R.id.ln_right);
            tvTitle = view.findViewById(R.id.tv_title);
            app_barQuestion = view.findViewById(R.id.app_bar_question);


            lnLeft.setOnClickListener(this);
            lnRight.setOnClickListener(this);
        }
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    public void setIconLeft(int drawable) {
        lnLeft.setVisibility(View.VISIBLE);
        imgLeft.setImageResource(drawable);
    }

    public void setIconRight(int drawable) {
        lnRight.setVisibility(View.VISIBLE);
        imgRight.setImageResource(drawable);
    }

    public void showSearchView() {
        tvTitle.setVisibility(GONE);
        lnSearch.setVisibility(VISIBLE);
        lnRight.setVisibility(GONE);
    }

    public EditText getEdtSearch() {
        return edtSearch;
    }

    public ImageView getImgClear() {
        return imgClear;
    }

    public void reSetAll() {
        lnLeft.setVisibility(View.INVISIBLE);
        lnRight.setVisibility(View.INVISIBLE);
        tvTitle.setVisibility(VISIBLE);
        lnSearch.setVisibility(GONE);
    }

    public void hiddenView() {
        app_barQuestion.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ln_left:
//                if (navigationOnClick != null) {
//                    navigationOnClick.OnLeftClick();
//                }
                break;

            case R.id.ln_right:
//                if (navigationOnClick != null) {
//                    navigationOnClick.onRightClick();
//                }
                break;
            default:
                /*TODO*/
                break;
        }
    }

//    public void setINavigationOnClick(INavigationOnClick navigationOnClick) {
//        this.navigationOnClick = navigationOnClick;
//    }

}
