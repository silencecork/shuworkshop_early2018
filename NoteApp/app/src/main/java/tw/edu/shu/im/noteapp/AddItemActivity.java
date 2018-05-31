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

            // 取得目前畫面上打的標題與內文
            String title = mTitleEditText.getEditableText().toString();
            String note = mNoteEditText.getEditableText().toString();

            // 儲存到ItemManager
            ItemManager.addItem(title, note);

            // 建立Intent把要帶回前一個Activity的值存下來
            Intent data = new Intent();
            data.putExtra("update", true);

            // 帶回前一個Activity
            setResult(RESULT_OK, data);

            // 關閉目前Activity，以便呈現上一個Activity
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
