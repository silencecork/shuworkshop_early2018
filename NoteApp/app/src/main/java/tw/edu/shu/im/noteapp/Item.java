package tw.edu.shu.im.noteapp;

import com.orm.SugarRecord;

public class Item extends SugarRecord {

    // 標題
    public String title;

    // 內文
    public String note;

    @Override
    public String toString() {
        // 物件預設回傳文字為 標題
        return title;
    }

}
