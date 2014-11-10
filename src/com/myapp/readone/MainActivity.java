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

	// ������Ļ����
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

	// ���ƻ�������
	class GestureListener implements OnGestureListener {

		@Override
		public boolean onDown(MotionEvent e) {
			// TODO Auto-generated method stub
			//������Ļʱ����
			// Toast.makeText(getApplicationContext(), "-----------> onDown",
			// Toast.LENGTH_LONG).show();
			return false;
		}

		@Override//��������
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			// e1 ��������ʼλ�ã�e2 �����Ľ���λ�ã�velocityX X��ÿһ���ƶ��������ٶȣ���������˼�� velocityY ���ǣٿ�
			// ������,��Ϊ�� �������ң���Ϊ����
			if (e2.getX() - e1.getX() > 50) {
				// e2.getX()-e1.getX()<��Ļ���
				Toast.makeText(getApplicationContext(), "���һ���",
						Toast.LENGTH_SHORT).show();
				// ���Ҫ��ת������һ��activity
				Intent intent = new Intent(MainActivity.this,
						StartbActivity.class);
				startActivity(intent);
			}
			if (e2.getX() - e1.getX() < -50) {
				Toast.makeText(getApplicationContext(), "���󻬶�",
						Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(MainActivity.this,
						FinishbActivity.class);
				startActivity(intent);
			}
			if (e2.getY() - e1.getY() <-50) {
				Toast.makeText(getApplicationContext(), "���ϻ���",
						Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(MainActivity.this,
						ExcerptActivity.class);
				startActivity(intent);
			}
			if (e2.getY() - e1.getY() > 50) {
				Toast.makeText(getApplicationContext(), "���»���",
						Toast.LENGTH_SHORT).show();
			}
			return false;
		}

		@Override//�����¼� һ�г��¼�����Ļ��Ҫ�������¼���������д
		public void onLongPress(MotionEvent e) {
			// TODO Auto-generated method stub\
//			Toast.makeText(getApplicationContext(),
//					"------------> onLongPress", Toast.LENGTH_LONG).show();
		}

		@Override//�϶��¼� distanceX ��X��·������
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {
			// TODO Auto-generated method stub
//			Toast.makeText(getApplicationContext(), "------------> onScroll",
//					Toast.LENGTH_LONG).show();
			return false;
		}

		@Override//down�¼�������move����up��û����ǰ�������¼�
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