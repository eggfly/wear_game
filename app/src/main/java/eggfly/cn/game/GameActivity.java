package eggfly.cn.game;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class GameActivity extends Activity {
    private static final String TAG = "GameActivity";
    private Random mRandom = new Random();
    private View mHead;
    private ObjectAnimator mCurrentAnimator;


    private void setAnimator() {
        final float MIN_ANIMATION_OFFSET = Utils.dp2px(this, 10);
        final float MAX_ANIMATION_OFFSET = Utils.dp2px(this, 50);
        final boolean isHorizontalAnimation = mRandom.nextBoolean();
        mCurrentAnimator = isHorizontalAnimation ?
                ObjectAnimator.ofFloat(mHead, "translationX", -MAX_ANIMATION_OFFSET + mRandom.nextFloat() * (MAX_ANIMATION_OFFSET - MIN_ANIMATION_OFFSET), MIN_ANIMATION_OFFSET + mRandom.nextFloat() * (MAX_ANIMATION_OFFSET - MIN_ANIMATION_OFFSET)) :
                ObjectAnimator.ofFloat(mHead, "translationY", -MAX_ANIMATION_OFFSET + mRandom.nextFloat() * (MAX_ANIMATION_OFFSET - MIN_ANIMATION_OFFSET), MIN_ANIMATION_OFFSET + mRandom.nextFloat() * (MAX_ANIMATION_OFFSET - MIN_ANIMATION_OFFSET));
        // final ObjectAnimator yAnimator = ObjectAnimator.ofFloat(mHead, "translationY", mRandom.nextFloat() * 10, mRandom.nextFloat() * 10);
        // AnimatorSet set = new AnimatorSet();
        // set.playTogether(xAnimator, yAnimator);
        mCurrentAnimator.setTarget(mHead);
        mCurrentAnimator.setRepeatCount(2);
        mCurrentAnimator.setRepeatMode(ValueAnimator.REVERSE);
        mCurrentAnimator.setDuration(2000);
        mCurrentAnimator.addListener(mListener);
        mCurrentAnimator.start();
    }

    private Animator.AnimatorListener mListener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {
            Log.d(TAG, "onAnimationStart");
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            Log.d(TAG, "onAnimationEnd");
            setAnimator();
        }

        @Override
        public void onAnimationCancel(Animator animation) {
        }

        @Override
        public void onAnimationRepeat(Animator animation) {
            Log.d(TAG, "onAnimationRepeat");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
//        GridLayout mGridLayout = (GridLayout) findViewById(R.id.grid);
//        final int columnCount = mGridLayout.getColumnCount();
//        final int rowCount = mGridLayout.getRowCount();
//        for (int i = 0; i < rowCount; i++) {
//            for (int j = 0; j < columnCount; j++) {
//                final View item = getLayoutInflater().inflate(R.layout.snake_item, mGridLayout, false);
//                mGridLayout.addView(item);
//            }
//        }
        mHead = findViewById(R.id.head);
        setAnimator();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, ev.toString());
        return super.dispatchTouchEvent(ev);
    }
}
