package in.kpsoft.bkanim;

import android.content.res.Resources;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class BKAnim {
    public static void setFadeAnimationAppear(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(250);
        view.startAnimation(anim);
    }

    public static void setFadeAnimationDisappear(View view) {
        AlphaAnimation anim = new AlphaAnimation(1.0f, 0.0f);
        anim.setDuration(250);
        view.startAnimation(anim);
    }

    public static void setScaleAnimation(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(500);
        view.startAnimation(anim);
    }

    public static void setTranslateAnimationUp(View view) {
        TranslateAnimation anim = new TranslateAnimation(0, 0, 50, 0);
        anim.setFillAfter(true);
        anim.setDuration(250);
        view.setAnimation(anim);
    }

    public static void setTranslateAnimationBottom(View view) {
        TranslateAnimation anim = new TranslateAnimation(0, 0, -50, 0);
        anim.setFillAfter(true);
        anim.setDuration(250);
        view.setAnimation(anim);
    }

    //==============================================================================================
    //FADE (APPEAR - DISAPPEAR)

    public static void appearFade(View view) {
        if (view.getVisibility() == View.VISIBLE) return;
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(200);
        view.startAnimation(anim);
        view.setVisibility(View.VISIBLE);
    }

    public static void disappearFade(View view) {
        if (view.getVisibility() == View.GONE) return;
        AlphaAnimation anim = new AlphaAnimation(1.0f, 0.0f);
        anim.setDuration(200);
        view.startAnimation(anim);
        view.setVisibility(View.GONE);
    }

    //==============================================================================================
    //SLIDE (APPEAR - DISAPPEAR)

    public static void appearSlideInTop(View view) {
        if (view.getVisibility() == View.VISIBLE) return;
        TranslateAnimation anim = new TranslateAnimation(0, 0, -1 * view.getHeight(), 0);
        anim.setDuration(200);
        view.setAnimation(anim);
        view.setVisibility(View.VISIBLE);
    }

    public static void appearSlideInBottom(View view) {
        TranslateAnimation anim = new TranslateAnimation(0, 0, 0, -1 * view.getHeight());
        anim.setDuration(200);
        view.setAnimation(anim);
        view.setVisibility(View.VISIBLE);
    }

    public static void appearSlideInRight(View view) {
        TranslateAnimation anim = new TranslateAnimation(Resources.getSystem().getDisplayMetrics().widthPixels, 0, 0, 0);
        anim.setDuration(200);
        view.setAnimation(anim);
        view.setVisibility(View.VISIBLE);
    }

    public static void appearSlideInLeft(View view) {
        TranslateAnimation anim = new TranslateAnimation(-1 * Resources.getSystem().getDisplayMetrics().widthPixels, 0, 0, 0);
        anim.setDuration(200);
        view.setAnimation(anim);
        view.setVisibility(View.VISIBLE);
    }

    public static void disappearSlideOutTop(View view) {
        TranslateAnimation anim = new TranslateAnimation(0, 0, 0, -1 * Resources.getSystem().getDisplayMetrics().heightPixels);
        anim.setDuration(200);
        view.setAnimation(anim);
        view.setVisibility(View.GONE);
    }

    public static void disappearSlideOutBottom(View view) {
        TranslateAnimation anim = new TranslateAnimation(0, 0, 0, Resources.getSystem().getDisplayMetrics().heightPixels);
        anim.setDuration(200);
        view.setAnimation(anim);
        view.setVisibility(View.GONE);
    }

    public static void disappearSlideOutRight(View view) {
        TranslateAnimation anim = new TranslateAnimation(0, Resources.getSystem().getDisplayMetrics().widthPixels, 0, 0);
        anim.setDuration(200);
        view.setAnimation(anim);
        view.setVisibility(View.GONE);
    }

    public static void disappearSlideOutLeft(View view) {
        TranslateAnimation anim = new TranslateAnimation(0, -1 * Resources.getSystem().getDisplayMetrics().widthPixels, 0, 0);
        anim.setDuration(200);
        view.setAnimation(anim);
        view.setVisibility(View.GONE);
    }

    //==============================================================================================
    //SCALE (APPEAR - DISAPPEAR)
    public static void appearScaleVertical(View view) {
        ScaleAnimation scale = new ScaleAnimation((float)1.0, (float)1.0, (float)0.0, (float)1.0);
        scale.setFillAfter(true);
        scale.setDuration(500);
        view.startAnimation(scale);
        view.setVisibility(View.VISIBLE);
    }
}
