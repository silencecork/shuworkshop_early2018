package tw.edu.shu.im.noteapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("簡單記事APP");

        // 建立測試資料
        if (ItemManager.getAllItem().size() <= 0) {
            TestDataCreator creator = new TestDataCreator();
            creator.createTestData(30);
        }

        // 初始化Adapter及ListView
        mListView = findViewById(R.id.listview);
        mAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ItemManager.getAllItem());

        mListView.setAdapter(mAdapter);

    }

}
