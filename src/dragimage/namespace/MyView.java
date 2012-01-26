package dragimage.namespace;



import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View{

	private int x=100;
	private int y=100;
	public int offsetX;
	public int offsetY;
	private Bitmap img=null;
	private boolean dragOn=false;
	
	public MyView(Context context) {
		super(context);
		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inJustDecodeBounds = true;
		img = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher);
	}
	@Override
	protected void onDraw(Canvas canvas){
		canvas.drawBitmap(img, x, y,null);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		int eventaction = event.getAction();
		int touchX = (int)event.getX();
		int touchY = (int)event.getY();
		
		switch (eventaction){
		case MotionEvent.ACTION_DOWN:
			if (touchX>x & touchX<x+img.getWidth()
				&touchY>y & touchY<y+img.getHeight()){
				dragOn=true;
				offsetX=touchX-x;
				offsetY=touchY-y;
			}
			break;
		case MotionEvent.ACTION_MOVE:
			if (dragOn){
				x=touchX-offsetX;
				y=touchY-offsetY;
			    invalidate();
			}
			break;
		case MotionEvent.ACTION_UP:
			dragOn=false;
			break;
		}
		
		return true;
	}
}
