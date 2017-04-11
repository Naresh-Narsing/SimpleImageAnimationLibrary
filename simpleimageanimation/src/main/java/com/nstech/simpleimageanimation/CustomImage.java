package com.nstech.simpleimageanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by abc on 11/4/17.
 */

public class CustomImage extends AppCompatImageView implements View.OnClickListener {

    private View.OnClickListener  listener;

    public CustomImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);
    }

    public CustomImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnClickListener(this);
    }

    public CustomImage(Context context) {
        super(context);
        setOnClickListener(this);
    }

    @Override
    public void setOnClickListener(OnClickListener l) {
        if (l == this){
            super.setOnClickListener(l);
        }else {
            listener = l;
        }
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            AnimatorSet animatorSet = new AnimatorSet();

            ObjectAnimator rotationAnim = ObjectAnimator.ofFloat(v, "rotation", 0f, 360f);
            rotationAnim.setDuration(300);


            ObjectAnimator bounceAnimX = ObjectAnimator.ofFloat(v, "scaleX", 0.2f, 1f);
            bounceAnimX.setDuration(300);

            ObjectAnimator bounceAnimY = ObjectAnimator.ofFloat(v, "scaleY", 0.2f, 1f);
            bounceAnimY.setDuration(300);

            animatorSet.play(rotationAnim);
            animatorSet.play(bounceAnimX).with(bounceAnimY).after(rotationAnim);
            animatorSet.start();
            listener.onClick(this);
        }
    }
}
