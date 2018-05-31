package tw.edu.shu.im.noteapp;

import java.util.ArrayList;

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

        sItemList.add(item);
    }

    /**
     * 取得全部資料
     *
     * @return
     */
    public static ArrayList<Item> getAllItem(){
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
        sItemList.remove(item);
        sItemList.add(index, item);
    }

    /**
     * 依照index刪除資料
     *
     * @param index
     */
    public static void deleteItem(int index) {
        sItemList.remove(index);
    }

}
