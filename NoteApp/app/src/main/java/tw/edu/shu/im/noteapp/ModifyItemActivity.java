package tw.edu.shu.im.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * 修改項目
 */
public class ModifyItemActivity extends AppCompatActivity {

    private int mIndex;
    private EditText mTitleEditText;
    private EditText mNoteEditText;
    private Button mUpdateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_item);

        setTitle("更新項目");

        // 取得更新項目的資料是在列表中的哪一個位置
        mIndex = getIntent().getIntExtra("index", 0);
        Item item = ItemManager.getItem(mIndex);

        mTitleEditText = findViewById(R.id.title);
        mNoteEditText = findViewById(R.id.note);
        mUpdateButton = findViewById(R.id.button_update);

        // 將帶來的資料呈現在畫面上
        mTitleEditText.setText(item.title);
        mNoteEditText.setText(item.note);
        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = mTitleEditText.getEditableText().toString();
                String note = mNoteEditText.getEditableText().toString();

                ItemManager.updateItem(mIndex, title, note);

                // 建立Intent把要帶回前一個Activity的值存下來
                Intent data = new Intent();
                data.putExtra("update", true);

                // 帶回前一個Activity
                setResult(RESULT_OK, data);

                // 關閉目前Activity，以便呈現上一個Activity
                finish();
            }
        });
    }
}
