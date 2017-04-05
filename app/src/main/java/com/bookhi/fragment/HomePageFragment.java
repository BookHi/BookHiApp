package com.bookhi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.bookhi.R;
import com.bookhi.di.component.DaggerHomePageComponent;
import com.bookhi.di.component.HomePageComponent;

import javax.inject.Inject;

/**
 * Created by Limingyu on 2017/4/4.
 */
public class HomePageFragment extends Fragment {

    private ViewFlipper viewFlipper;
    private Button mRegisterButton;
    private Button mLoginButton;

    private HomePageComponent mComponent;

    private View.OnClickListener mRegisterButtonOnClickListener;
    private View.OnClickListener mLoginButtonOnClickListener;

    @Inject
    int[] resources;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, null);
        viewFlipper = (ViewFlipper) view.findViewById(R.id.viewflipper);
        for (int i = 0; i < resources.length; ++i) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(resources[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setInAnimation(getActivity(), android.R.anim.fade_in);
        viewFlipper.setInAnimation(getActivity(), android.R.anim.fade_out);
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(4000);
        mRegisterButton = (Button) view.findViewById(R.id.button_register);
        mRegisterButton.setOnClickListener(mRegisterButtonOnClickListener);
        mLoginButton = (Button) view.findViewById(R.id.button_login);
        mLoginButton.setOnClickListener(mLoginButtonOnClickListener);
        CustomGestureDetector customGestureDetector = new CustomGestureDetector();
        gestureDetector = new GestureDetector(getActivity(), customGestureDetector);
        return view;
    }

    public void setRegisterButtonClickListener(View.OnClickListener listener) {
        mRegisterButtonOnClickListener = listener;
    }

    public void setLoginButtonClickListener(View.OnClickListener listener) {
        mLoginButtonOnClickListener = listener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mComponent = DaggerHomePageComponent.create();
        mComponent.inject(this);
    }

    private GestureDetector gestureDetector;

    class CustomGestureDetector extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() > e2.getX()) { //如果初始触点的X坐标比最终触点的X坐标大表示向左滑动
                viewFlipper.showNext();
            }

            if (e1.getX() < e2.getX()) { //如果初始触点的X坐标比最终触点的X坐标小表示向右滑动
                viewFlipper.showPrevious();
            }

            return super.onFling(e1, e2, velocityX, velocityY);
        }

    }

}
