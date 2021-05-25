package in.kpsoft.bkdialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BKDialogSelectAdapter extends RecyclerView.Adapter<BKDialogSelectAdapter.MyViewHolder> {

    public static final int ROW_SELECTION = 1;
    public static final int ROW_CHECKBOX = 2;

    private Context context;
    private List<BKDialogRowItemVo> itemVos, listFiltered;
    private AdapterListener adapterListener;
    private int ROW_TYPE = ROW_SELECTION;
    private ArrayList<String> filterQueryCd, filterQueryNm;

    public BKDialogSelectAdapter(Context context1, AdapterListener listener) {
        this.context = context1;
        this.adapterListener = listener;
    }

    public void setItemList(List<BKDialogRowItemVo> itemList){
        this.itemVos = itemList;
        this.listFiltered = itemList;
        this.filterQueryCd = new ArrayList<String>();
        this.filterQueryNm = new ArrayList<String>();
    }

    public void setRowType(int rowType){
        this.ROW_TYPE = rowType;
    }

    public void setQueryLists(ArrayList<String> filterQueryCd, ArrayList<String> filterQueryNm){
        this.filterQueryCd = filterQueryCd;
        this.filterQueryNm = filterQueryNm;
    }

    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    listFiltered = itemVos;
                } else {
                    List<BKDialogRowItemVo> filteredList = new ArrayList<>();
                    for (BKDialogRowItemVo row : itemVos) {
                        if ((row.getItemName() != null && row.getItemName().toLowerCase().contains(charString.toLowerCase())) ||
                                (row.getItemName2() != null && row.getItemName2().toLowerCase().contains(charString.toLowerCase()))) {
                            filteredList.add(row);
                        }
                    }
                    listFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = listFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                listFiltered = (ArrayList<BKDialogRowItemVo>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public CheckBox mCheckBox;
        public TextView tvName, tvName2;
        public ConstraintLayout row_root;

        public MyViewHolder(View view) {
            super(view);
            mCheckBox = (CheckBox) view.findViewById(R.id.mCheckBox);
            tvName = (TextView) view.findViewById(R.id.tvName);
            tvName2 = (TextView) view.findViewById(R.id.tvName2);
            row_root = view.findViewById(R.id.row_root);

            if (ROW_TYPE != ROW_CHECKBOX)
                mCheckBox.setVisibility(View.GONE);

            row_root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BKDialogRowItemVo item = listFiltered.get(getAdapterPosition());
                    if (ROW_TYPE == ROW_CHECKBOX) {
                        CheckBox tempCheckbox = MyViewHolder.this.mCheckBox;
                        tempCheckbox.setChecked(!tempCheckbox.isChecked());
                    } else {
                        filterQueryCd.clear();
                        filterQueryNm.clear();
                        filterQueryCd.add(item.getItemCd());
                        filterQueryNm.add(item.getItemName());
                        adapterListener.onItemSelected(item);
                    }
                }
            });

            mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    BKDialogRowItemVo item = listFiltered.get(getAdapterPosition());
                    item.setIsChecked(isChecked);
                    String str_itemCd = item.getItemCd();
                    String str_itemNm = item.getItemName();
                    String str_itemCd2 = item.getItemCd2();
                    String str_itemNm2 = item.getItemName2();

                    if (isChecked) {
                        if (!filterQueryCd.contains(str_itemCd))
                            filterQueryCd.add(str_itemCd);
                        if (!filterQueryNm.contains(str_itemNm))
                            filterQueryNm.add(str_itemNm);
                    } else {
                        filterQueryCd.remove(str_itemCd);
                        filterQueryNm.remove(str_itemNm);
                    }
                }
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bkdialog_selection_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final BKDialogRowItemVo item = listFiltered.get(position);

        holder.mCheckBox.setChecked(item.getIsChecked());
        holder.tvName.setText(item.getItemName());
        holder.tvName2.setText(item.getItemName2());

        holder.tvName.setCompoundDrawablesWithIntrinsicBounds(item.getDrawable(), null, null, null);
    }

    @Override
    public int getItemCount() {
        if (listFiltered != null) {
            return listFiltered.size();
        } else {
            return 0;
        }
    }

    public interface AdapterListener {
        void onItemSelected(BKDialogRowItemVo itemVo);
    }

}
