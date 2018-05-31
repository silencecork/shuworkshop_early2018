package tw.edu.shu.im.noteapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 建立App右上角的按鈕
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 點下App右上角的按鈕
        if (item.getItemId() == R.id.menu_add) {
            Log.d("Menu", "點下新增按鈕");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
