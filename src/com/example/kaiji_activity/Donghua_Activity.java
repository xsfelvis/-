package com.example.kaiji_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.assistant.R;
import com.example.leftslide.Leftslide_Activity;

public class Donghua_Activity extends Activity{
	private ImageView img_left,img_right;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_donghuapage);
		img_left = (ImageView) findViewById(R.id.doorpage_left);
		img_right = (ImageView) findViewById(R.id.doorpage_right);

		//创建一个AnimationSet对象
		AnimationSet animLeft = new AnimationSet(true);
		TranslateAnimation transLeft = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF,
				-1f, Animation.RELATIVE_TO_SELF, 0f,
				Animation.RELATIVE_TO_SELF, 0f);
		//设置动画效果持续的时间
		transLeft.setDuration(2000);
		//将anim对象添加到AnimationSet对象中
		animLeft.addAnimation(transLeft);
		animLeft.setFillAfter(true);
		img_left.startAnimation(transLeft);
		transLeft.startNow();
		
		
		
		//创建一个AnimationSet对象
		AnimationSet animRight = new AnimationSet(true);
		TranslateAnimation transRight = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF,
				1f, Animation.RELATIVE_TO_SELF, 0f,
				Animation.RELATIVE_TO_SELF, 0f);
		//设置动画效果持续的时间
		transRight.setDuration(2000);
		//将anim对象添加到AnimationSet对象中
		animRight.addAnimation(transRight);
		animRight.setFillAfter(true);
		img_right.startAnimation(transRight);
		transRight.startNow();
		
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Donghua_Activity.this, Leftslide_Activity.class);
				startActivity(intent);
				Donghua_Activity.this.finish();
			}
		}, 1000);
	}
	

	

}
