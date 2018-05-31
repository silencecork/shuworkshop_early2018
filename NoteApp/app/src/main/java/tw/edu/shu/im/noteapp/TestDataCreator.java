package tw.edu.shu.im.noteapp;

/**
 * 建立測試資料
 */
public class TestDataCreator {

    public TestDataCreator() {

    }

    public void createTestData(int recordCount) {
        for (int i = 0; i < recordCount; i++) {
            ItemManager.addItem("測試" + i + "號", "這是測試內容，這是第" + i + "項的測試內容\nThis is a test content. This is option " + i);
        }
    }

}
