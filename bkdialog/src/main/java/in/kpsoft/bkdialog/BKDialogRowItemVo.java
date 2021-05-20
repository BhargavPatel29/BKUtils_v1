package in.kpsoft.bkdialog;

import android.graphics.drawable.Drawable;

public class BKDialogRowItemVo {
    String itemCd = "";
    String itemCd2 = "";
    String itemName = "";
    String itemName2 = "";
    String itemStrVal = "";
    int itemIntVal = 0;
    Boolean isChecked = false;
    Drawable drawable = null;

    public String getItemCd(){return itemCd;}
    public String getItemCd2(){return itemCd2;}
    public String getItemName(){return itemName;}
    public String getItemName2(){return itemName2;}
    public String getItemStrVal(){return itemStrVal;}
    public int getItemIntVal(){return itemIntVal;}
    public Boolean getIsChecked(){return isChecked;}
    public Drawable getDrawable(){return drawable;}

    public void setItemCd(String itemCd){this.itemCd = itemCd;}
    public void setItemCd2(String itemCd2){this.itemCd2 = itemCd2;}
    public void setItemName(String itemName){this.itemName = itemName;}
    public void setItemName2(String itemName2){this.itemName2 = itemName2;}
    public void setItemStrVal(String itemStrVal){this.itemStrVal = itemStrVal;}
    public void setItemIntVal(int itemIntVal){this.itemIntVal = itemIntVal;}
    public void setIsChecked(Boolean isChecked){this.isChecked = isChecked;}
    public void setDrawable(Drawable drawable){this.drawable = drawable;}
}
