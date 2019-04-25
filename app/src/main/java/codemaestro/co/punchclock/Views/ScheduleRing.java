package codemaestro.co.punchclock.Views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import codemaestro.co.punchclock.R;

public class ScheduleRing extends View {

    private static final String TAG = ScheduleRing.class.getSimpleName();
    private static int INVALID_PROGRESS_VALUE = -1;
    // The initial rotational offset -90 means we start at 12 o'clock
    private final int mAngleOffset = -90;


    private Drawable mThumb;
    private int mMaxValue = 100;
    private int mThumbProgress = 0;
    private int mRingWidth = 2;
    private boolean mClockwise = true;
    private boolean mEnabled = true;

    /**
     * The Angle to start drawing this Arc from
     */
    private int mStartAngle = 0;

    /**
     * The Angle through which to draw the arc (Max is 360)
     */
    private int mSweepAngle = 360;

    /**
     * The rotation of the SeekArc- 0 is twelve o'clock
     */
    private int mRotation = 0;

    /**
     * Give the SeekArc rounded edges
     */
    private boolean mRoundedEdges = false;

    /**
     * Enable touch inside the SeekArc
     */
    private boolean mTouchInside = true;


    // Internal variables
    private int mRingRadius = 0;
    private float mProgressSweep = 0;
    private RectF mRingRect = new RectF();
    private Paint mRingPaint;
    private Paint mProgressPaint;
    private int mTranslateX;
    private int mTranslateY;
    private int mThumbXPos;
    private int mThumbYPos;
    private double mTouchAngle;
    private float mTouchIgnoreRadius;
    private OnSeekArcChangeListener mOnSeekArcChangeListener;

    public interface OnSeekArcChangeListener {

        void onProgressChanged(ScheduleRing scheduleRing, int progress, boolean fromUser);
        void onStartTrackingTouch(ScheduleRing scheduleRing);
        void onStopTrackingTouch(ScheduleRing scheduleRing);
    }


//    public ScheduleRing(Context context) {
//        super(context);
//        init(context, null, 0);
//    }
//
//    public ScheduleRing(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//        init(context, attrs, R.attr.scheduleRingTheme);
//    }
//
//    public ScheduleRing(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
////        init(context, attrs, defStyleAttr);
//    }

    public ScheduleRing(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }



//    private void init(Context context, AttributeSet attrs, int defStyle) {
//        final Resources res = getResources();
//
//
//        // Defaults, may need to link this into theme settings
//        int arcColor = res.getColor(R.color.progress_gray);
//        int progressColor = res.getColor(R.color.default_blue_light);
//        int thumbHalfheight = 0;
//        int thumbHalfWidth = 0;
//        mThumb = res.getDrawable(R.drawable.seek_arc_control_selector);
//
//        // Convert progress width to pixels for current density
//        float density = context.getResources().getDisplayMetrics().density;
//        mProgressWidth = (int) (mProgressWidth * density);
//
//        // Attributes from xml
//        if (attrs != null) {
//
//            final TypedArray a = context.obtainStyledAttributes(attrs,
//                    R.styleable.ScheduleRing, defStyle, 0);
//
//            Drawable thumb = a.getDrawable(R.styleable.SeekArc_thumb);
//            if (thumb != null) {
//                mThumb = thumb;
//            }
//
//
//
//            thumbHalfheight = (int) mThumb.getIntrinsicHeight() / 2;
//            thumbHalfWidth = (int) mThumb.getIntrinsicWidth() / 2;
//            mThumb.setBounds(-thumbHalfWidth, -thumbHalfheight, thumbHalfWidth,
//                    thumbHalfheight);
//
//            mMaxValue = a.getInteger(R.styleable.SeekArc_max, mMaxValue);
//            mThumbProgress = a.getInteger(R.styleable.SeekArc_progress, mThumbProgress);
//            mProgressWidth = (int) a.getDimension(
//                    R.styleable.SeekArc_progressWidth, mProgressWidth);
//            mRingWidth = (int) a.getDimension(R.styleable.SeekArc_arcWidth,
//                    mRingWidth);
//            mStartAngle = a.getInt(R.styleable.SeekArc_startAngle, mStartAngle);
//            mSweepAngle = a.getInt(R.styleable.SeekArc_sweepAngle, mSweepAngle);
//            mRotation = a.getInt(R.styleable.SeekArc_rotation, mRotation);
//            mRoundedEdges = a.getBoolean(R.styleable.SeekArc_roundEdges,
//                    mRoundedEdges);
//            mTouchInside = a.getBoolean(R.styleable.SeekArc_touchInside,
//                    mTouchInside);
//            mClockwise = a.getBoolean(R.styleable.SeekArc_clockwise,
//                    mClockwise);
//            mEnabled = a.getBoolean(R.styleable.SeekArc_enabled, mEnabled);
//
//            arcColor = a.getColor(R.styleable.SeekArc_arcColor, arcColor);
//            progressColor = a.getColor(R.styleable.SeekArc_progressColor,
//                    progressColor);
//
//            a.recycle();
//        }
//
//        mThumbProgress = (mThumbProgress > mMaxValue) ? mMaxValue : mThumbProgress;
//        mThumbProgress = (mThumbProgress < 0) ? 0 : mThumbProgress;
//
//        mSweepAngle = (mSweepAngle > 360) ? 360 : mSweepAngle;
//        mSweepAngle = (mSweepAngle < 0) ? 0 : mSweepAngle;
//
//        mProgressSweep = (float) mThumbProgress / mMaxValue * mSweepAngle;
//
//        mStartAngle = (mStartAngle > 360) ? 0 : mStartAngle;
//        mStartAngle = (mStartAngle < 0) ? 0 : mStartAngle;
//
//        mRingPaint = new Paint();
//        mRingPaint.setColor(arcColor);
//        mRingPaint.setAntiAlias(true);
//        mRingPaint.setStyle(Paint.Style.STROKE);
//        mRingPaint.setStrokeWidth(mRingWidth);
//        //mRingPaint.setAlpha(45);
//
//        mProgressPaint = new Paint();
//        mProgressPaint.setColor(progressColor);
//        mProgressPaint.setAntiAlias(true);
//        mProgressPaint.setStyle(Paint.Style.STROKE);
//        mProgressPaint.setStrokeWidth(mProgressWidth);
//
//        if (mRoundedEdges) {
//            mRingPaint.setStrokeCap(Paint.Cap.ROUND);
//            mProgressPaint.setStrokeCap(Paint.Cap.ROUND);
//        }
//    }

//    @Override
//    protected void onDraw(Canvas canvas) {
//        if(!mClockwise) {
//            canvas.scale(-1, 1, mRingRect.centerX(), mRingRect.centerY() );
//        }
//
//        // Draw the arcs
//        final int arcStart = mStartAngle + mAngleOffset + mRotation;
//        final int arcSweep = mSweepAngle;
//        canvas.drawArc(mRingRect, arcStart, arcSweep, false, mRingPaint);
//        canvas.drawArc(mRingRect, arcStart, mProgressSweep, false,
//                mProgressPaint);
//
//        if(mEnabled) {
//            // Draw the thumb nail
//            canvas.translate(mTranslateX - mThumbXPos, mTranslateY - mThumbYPos);
//            mThumb.draw(canvas);
//        }
//    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        final int height = getDefaultSize(getSuggestedMinimumHeight(),
                heightMeasureSpec);
        final int width = getDefaultSize(getSuggestedMinimumWidth(),
                widthMeasureSpec);
        final int min = Math.min(width, height);
        float top = 0;
        float left = 0;
        int arcDiameter = 0;

        mTranslateX = (int) (width * 0.5f);
        mTranslateY = (int) (height * 0.5f);

        arcDiameter = min - getPaddingLeft();
        mRingRadius = arcDiameter / 2;
        top = height / 2 - (arcDiameter / 2);
        left = width / 2 - (arcDiameter / 2);
        mRingRect.set(left, top, left + arcDiameter, top + arcDiameter);

        int arcStart = (int)mProgressSweep + mStartAngle  + mRotation + 90;
        mThumbXPos = (int) (mRingRadius * Math.cos(Math.toRadians(arcStart)));
        mThumbYPos = (int) (mRingRadius * Math.sin(Math.toRadians(arcStart)));

//        setTouchInSide(mTouchInside);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mEnabled) {
            this.getParent().requestDisallowInterceptTouchEvent(true);

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    onStartTrackingTouch();
                    updateOnTouch(event);
                    break;
                case MotionEvent.ACTION_MOVE:
                    updateOnTouch(event);
                    break;
                case MotionEvent.ACTION_UP:
                    onStopTrackingTouch();
                    setPressed(false);
                    this.getParent().requestDisallowInterceptTouchEvent(false);
                    break;
                case MotionEvent.ACTION_CANCEL:
                    onStopTrackingTouch();
                    setPressed(false);
                    this.getParent().requestDisallowInterceptTouchEvent(false);
                    break;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (mThumb != null && mThumb.isStateful()) {
            int[] state = getDrawableState();
            mThumb.setState(state);
        }
        invalidate();
    }

    private void onStartTrackingTouch() {
        if (mOnSeekArcChangeListener != null) {
            mOnSeekArcChangeListener.onStartTrackingTouch(this);
        }
    }

    private void onStopTrackingTouch() {
        if (mOnSeekArcChangeListener != null) {
            mOnSeekArcChangeListener.onStopTrackingTouch(this);
        }
    }

    private void updateOnTouch(MotionEvent event) {
        boolean ignoreTouch = ignoreTouch(event.getX(), event.getY());
        if (ignoreTouch) {
            return;
        }
        setPressed(true);
        mTouchAngle = getTouchDegrees(event.getX(), event.getY());
        int progress = getProgressForAngle(mTouchAngle);
        onProgressRefresh(progress, true);
    }

    private boolean ignoreTouch(float xPos, float yPos) {
        boolean ignore = false;
        float x = xPos - mTranslateX;
        float y = yPos - mTranslateY;

        float touchRadius = (float) Math.sqrt(((x * x) + (y * y)));
        if (touchRadius < mTouchIgnoreRadius) {
            ignore = true;
        }
        return ignore;
    }

    private double getTouchDegrees(float xPos, float yPos) {
        float x = xPos - mTranslateX;
        float y = yPos - mTranslateY;
        //invert the x-coord if we are rotating anti-clockwise
        x= (mClockwise) ? x:-x;
        // convert to arc Angle
        double angle = Math.toDegrees(Math.atan2(y, x) + (Math.PI / 2)
                - Math.toRadians(mRotation));
        if (angle < 0) {
            angle = 360 + angle;
        }
        angle -= mStartAngle;
        return angle;
    }

    private int getProgressForAngle(double angle) {
        int touchProgress = (int) Math.round(valuePerDegree() * angle);

        touchProgress = (touchProgress < 0) ? INVALID_PROGRESS_VALUE
                : touchProgress;
        touchProgress = (touchProgress > mMaxValue) ? INVALID_PROGRESS_VALUE
                : touchProgress;
        return touchProgress;
    }

    private float valuePerDegree() {
        return (float) mMaxValue / mSweepAngle;
    }

    private void onProgressRefresh(int progress, boolean fromUser) {
        updateProgress(progress, fromUser);
    }

    private void updateThumbPosition() {
        int thumbAngle = (int) (mStartAngle + mProgressSweep + mRotation + 90);
        mThumbXPos = (int) (mRingRadius * Math.cos(Math.toRadians(thumbAngle)));
        mThumbYPos = (int) (mRingRadius * Math.sin(Math.toRadians(thumbAngle)));
    }

    private void updateProgress(int progress, boolean fromUser) {

        if (progress == INVALID_PROGRESS_VALUE) {
            return;
        }

        progress = (progress > mMaxValue) ? mMaxValue : progress;
        progress = (progress < 0) ? 0 : progress;
        mThumbProgress = progress;

        if (mOnSeekArcChangeListener != null) {
            mOnSeekArcChangeListener
                    .onProgressChanged(this, progress, fromUser);
        }

        mProgressSweep = (float) progress / mMaxValue * mSweepAngle;

        updateThumbPosition();

        invalidate();
    }

//    /**
//     * Sets a listener to receive notifications of changes to the SeekArc's
//     * progress level. Also provides notifications of when the user starts and
//     * stops a touch gesture within the SeekArc.
//     *
//     * @param l
//     *            The seek bar notification listener
//     *
//     * @see SeekArc.OnSeekBarChangeListener
//     */
//    public void setOnSeekArcChangeListener(OnSeekArcChangeListener l) {
//        mOnSeekArcChangeListener = l;
//    }
//
//    public void setProgress(int progress) {
//        updateProgress(progress, false);
//    }
//
//    public int getProgress() {
//        return mThumbProgress;
//    }
//
//    public int getProgressWidth() {
//        return mProgressWidth;
//    }
//
//    public void setProgressWidth(int mProgressWidth) {
//        this.mProgressWidth = mProgressWidth;
//        mProgressPaint.setStrokeWidth(mProgressWidth);
//    }

//    public int getArcWidth() {
//        return mRingWidth;
//    }
//
//    public void setArcWidth(int mArcWidth) {
//        this.mRingWidth = mArcWidth;
//        mRingPaint.setStrokeWidth(mArcWidth);
//    }
//    public int getArcRotation() {
//        return mRotation;
//    }
//
//    public void setArcRotation(int mRotation) {
//        this.mRotation = mRotation;
//        updateThumbPosition();
//    }
//
//    public int getStartAngle() {
//        return mStartAngle;
//    }
//
//    public void setStartAngle(int mStartAngle) {
//        this.mStartAngle = mStartAngle;
//        updateThumbPosition();
//    }
//
//    public int getSweepAngle() {
//        return mSweepAngle;
//    }

    public void setSweepAngle(int mSweepAngle) {
        this.mSweepAngle = mSweepAngle;
        updateThumbPosition();
    }

    public void setRoundedEdges(boolean isEnabled) {
        mRoundedEdges = isEnabled;
        if (mRoundedEdges) {
            mRingPaint.setStrokeCap(Paint.Cap.ROUND);
            mProgressPaint.setStrokeCap(Paint.Cap.ROUND);
        } else {
            mRingPaint.setStrokeCap(Paint.Cap.SQUARE);
            mProgressPaint.setStrokeCap(Paint.Cap.SQUARE);
        }
    }

    public void setTouchInSide(boolean isEnabled) {
        int thumbHalfheight = (int) mThumb.getIntrinsicHeight() / 2;
        int thumbHalfWidth = (int) mThumb.getIntrinsicWidth() / 2;
        mTouchInside = isEnabled;
        if (mTouchInside) {
            mTouchIgnoreRadius = (float) mRingRadius / 4;
        } else {
            // Don't use the exact radius makes interaction too tricky
            mTouchIgnoreRadius = mRingRadius
                    - Math.min(thumbHalfWidth, thumbHalfheight);
        }
    }

    public void setClockwise(boolean isClockwise) {
        mClockwise = isClockwise;
    }
//
//    public boolean isClockwise() {
//        return mClockwise;
//    }
//
//    public boolean isEnabled() {
//        return mEnabled;
//    }
//
//    public void setEnabled(boolean enabled) {
//        this.mEnabled = enabled;
//    }
//
//    public int getProgressColor() {
//        return mProgressPaint.getColor();
//    }
//
//    public void setProgressColor(int color) {
//        mProgressPaint.setColor(color);
//        invalidate();
//    }
//
//    public int getArcColor() {
//        return mRingPaint.getColor();
//    }
//
//    public void setArcColor(int color) {
//        mRingPaint.setColor(color);
//        invalidate();
//    }
//
//    public int getMax() {
//        return mMaxValue;
//    }

    public void setMax(int mMax) {
        this.mMaxValue = mMax;
    }
}
