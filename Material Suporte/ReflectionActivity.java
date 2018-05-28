package pt.isel.simplelayout;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Constructor;

public class ReflectionActivity extends Activity {

    private void M(int ... values) {
        for(int j=0; j< values.length; ++j) {
            values[j] = 0;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //M(1,2,3,4,4,3,4,1,2,3,4,3,4,5,65,6,76,7,7,8,8,1);

        Button create = findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText classNameText =
                        findViewById(R.id.className);
                String className =
                        classNameText.getText().toString();
                try {
                    Class klass = Class.forName(className);
                    Constructor ctor =
                            klass.getConstructor(new Class[] {Context.class});
                            //klass.getConstructor(Context.class);
                    Log.i("Reflection", "Class name is " + klass.getName());
                    Log.i("Reflection", "Ctor name is " + ctor.toString());

                    // instanciar widget
                    Object obj =
                            ctor.newInstance(ReflectionActivity.this);
                            //ctor.newInstance(new object[] {ReflectionActivity.this});

                    if (!(obj instanceof TextView)) {
                        Log.e("Reflection", "Only text widgets are allowed!!");
                        return;
                    }
                    TextView newView = (TextView)obj;

                    LinearLayout holder = findViewById(R.id.holder);
                    newView.setText("POO");
                    // methods can also be called using the reflection api (but only if necessary)
                    //Method setTestMtd = klass.getMethod("setText");
                    //setTestMtd.invoke("POO");

                    // add view to holder
                    holder.addView(newView);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
