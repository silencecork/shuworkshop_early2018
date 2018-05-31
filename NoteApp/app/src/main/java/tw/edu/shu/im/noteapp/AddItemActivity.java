package tw.edu.shu.im.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

/**
 * 新增項目
 */
public class AddItemActivity extends AppCompatActivity {

    private EditText mTitleEditText;
    private EditText mNoteEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        setTitle("新增項目");

        mTitleEditText = findViewById(R.id.title);
        mNoteEditText = findViewById(R.id.note);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 建立畫面右上方儲存按鈕
        getMenuInflater().inflate(R.menu.add_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 點下儲存按鈕
        if (item.getItemId() == R.id.menu_save) {
            Log.d("Menu", "點下儲存按鈕");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
