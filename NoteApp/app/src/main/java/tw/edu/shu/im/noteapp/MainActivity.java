package tw.edu.shu.im.noteapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private static final int ADD_ITEM = 1;
    private static final int UPDATE_ITEM = 2;
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

        // 點擊ListView單一項目可以進行
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ModifyItemActivity.class);
                intent.putExtra("index", position);
                startActivityForResult(intent, UPDATE_ITEM);
            }
        });

        // 長按ListView可以進行刪除
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("刪除")
                        .setMessage("確定要刪除此項目嗎?")
                        .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ItemManager.deleteItem(position);
                                mAdapter.clear();
                                mAdapter.addAll(ItemManager.getAllItem());
                                mAdapter.notifyDataSetChanged();

                            }
                        })
                        .setNegativeButton("取消", null);

                builder.show();
                return true;
            }
        });
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
            Intent intent = new Intent(this, AddItemActivity.class);
            startActivityForResult(intent, ADD_ITEM);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_ITEM && resultCode == RESULT_OK) {
            // 新增資料回來，加入到ItemManager中
            boolean needUpdate = data.getBooleanExtra("update", false);
            if (needUpdate) {
                mAdapter.clear();
                mAdapter.addAll(ItemManager.getAllItem());
                mAdapter.notifyDataSetChanged();
            }
        } else if (requestCode == UPDATE_ITEM &&resultCode == RESULT_OK) {
            // 更新資料回來
            boolean needUpdate = data.getBooleanExtra("update", false);
            if (needUpdate) {
                mAdapter.clear();
                mAdapter.addAll(ItemManager.getAllItem());
                mAdapter.notifyDataSetChanged();
            }
        }
    }
}
