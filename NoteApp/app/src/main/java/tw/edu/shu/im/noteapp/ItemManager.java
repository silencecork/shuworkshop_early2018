package tw.edu.shu.im.noteapp;

import java.util.ArrayList;
import java.util.Iterator;

public class ItemManager {

    private static ArrayList<Item> sItemList = new ArrayList<>();

    /**
     * 加入新資料
     *
     * @param title
     * @param note
     */
    public static void addItem(String title, String note) {
        Item item = new Item();
        item.title = title;
        item.note = note;

        // 儲存到資料庫
        item.save();
        refreshItems();
    }

    /**
     * 取得全部資料
     *
     * @return
     */
    public static ArrayList<Item> getAllItem(){
        if (sItemList.size() == 0) {
            refreshItems();
        }
        return (ArrayList<Item>) sItemList.clone();
    }

    /**
     * 依照index取得資料
     *
     * @param index
     * @return
     */
    public static Item getItem(int index) {
        return sItemList.get(index);
    }

    /**
     * 依照index更新資料
     *
     * @param index
     * @param newTitleValue
     * @param newNoteValue
     */
    public static void updateItem(int index, String newTitleValue, String newNoteValue) {
        Item item = sItemList.get(index);
        item.title = newTitleValue;
        item.note = newNoteValue;
        // 更新後儲存到資料庫
        item.save();
        refreshItems();
    }

    /**
     * 依照index刪除資料
     *
     * @param index
     */
    public static void deleteItem(int index) {
        Item item = sItemList.get(index);
        // 從資料庫中刪除資料
        item.delete();
        refreshItems();
    }

    private static void refreshItems() {
        sItemList.clear();
        Iterator<Item> allItemsItr = Item.findAll(Item.class);
        while (allItemsItr.hasNext()) {
            Item item = allItemsItr.next();
            sItemList.add(item);
        }
    }


}
