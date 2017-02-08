package pro.appus.checkableexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import pro.appus.checkableitemviews.CheckableItemGroup;
import pro.appus.checkableitemviews.CheckableView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckableItemGroup checkableItemGroup = (CheckableItemGroup) findViewById(R.id.group);
        checkableItemGroup.setOnCheckedChangeListener(new CheckableItemGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CheckableView view, int checkedId) {
                if (view.isChecked()) {
                    Toast.makeText(MainActivity.this, "Checked view with ID: " + checkedId, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
