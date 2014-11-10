package com.myapp.readone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

	GestureDetector detector;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		detector = new GestureDetector(new GestureListener());
		LinearLayout layout = (LinearLayout) findViewById(R.id.linearlayout);
		layout.setOnTouchListener(new TouhListener());
		layout.setLongClickable(true);
	}

	// 触摸屏幕监听
	class TouhListener implements OnTouchListener {
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
//			Toast.makeText(getApplicationContext(), "----?",
//			event.getAction())
//			 .show();
			return detector.onTouchEvent(event);
		}
	}

	// 手势滑动监听
	class GestureListener implements OnGestureListener {

		@Override
		public boolean onDown(MotionEvent e) {
			// TODO Auto-generated method stub
			//按下屏幕时触发
			// Toast.makeText(getApplicationContext(), "-----------> onDown",
			// Toast.LENGTH_LONG).show();
			return false;
		}

		@Override//滑动手势
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			// e1 触摸的起始位置，e2 触摸的结束位置，velocityX X轴每一秒移动的像素速度（大概这个意思） velocityY 就是Ｙ咯
			// 手势左,上为正 ——，右，下为负正
			if (e2.getX() - e1.getX() > 50) {
				// e2.getX()-e1.getX()<屏幕宽度
				Toast.makeText(getApplicationContext(), "向右滑动",
						Toast.LENGTH_SHORT).show();
				// 如果要跳转到另外一个activity
				Intent intent = new Intent(MainActivity.this,
						StartbActivity.class);
				startActivity(intent);
			}
			if (e2.getX() - e1.getX() < -50) {
				Toast.makeText(getApplicationContext(), "向左滑动",
						Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(MainActivity.this,
						FinishbActivity.class);
				startActivity(intent);
			}
			if (e2.getY() - e1.getY() <-50) {
				Toast.makeText(getApplicationContext(), "向上滑动",
						Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(MainActivity.this,
						ExcerptActivity.class);
				startActivity(intent);
			}
			if (e2.getY() - e1.getY() > 50) {
				Toast.makeText(getApplicationContext(), "向下滑动",
						Toast.LENGTH_SHORT).show();
			}
			return false;
		}

		@Override//长按事件 一切长事件按屏幕想要触发的事件都在这里写
		public void onLongPress(MotionEvent e) {
			// TODO Auto-generated method stub\
//			Toast.makeText(getApplicationContext(),
//					"------------> onLongPress", Toast.LENGTH_LONG).show();
		}

		@Override//拖动事件 distanceX 是X轴路径长度
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {
			// TODO Auto-generated method stub
//			Toast.makeText(getApplicationContext(), "------------> onScroll",
//					Toast.LENGTH_LONG).show();
			return false;
		}

		@Override//down事件发生而move或则up还没发生前触发该事件
		public void onShowPress(MotionEvent e) {
			// TODO Auto-generated method stub
//			Toast.makeText(getApplicationContext(),
//					"------------> onShowPress", Toast.LENGTH_LONG).show();
		}

		@Override
		public boolean onSingleTapUp(MotionEvent e) {
			// TODO Auto-generated method stub
//			Toast.makeText(getApplicationContext(),
//					"------------> onSingleTapUp", Toast.LENGTH_LONG).show();
			return false;
		}

	}
}