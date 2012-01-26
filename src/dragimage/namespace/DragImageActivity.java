package dragimage.namespace;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class DragImageActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View myView = new MyView(this);
        setContentView(myView);
      
    }
}