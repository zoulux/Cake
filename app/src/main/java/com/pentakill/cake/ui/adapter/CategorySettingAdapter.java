package com.pentakill.cake.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pentakill.cake.R;
import com.pentakill.cake.db.CategoryDao;
import com.pentakill.cake.model.CategoryBean;

import java.util.List;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by zoulux on 2016-02-13  22:35.
 */
public class CategorySettingAdapter extends BaseAdapter implements View.OnClickListener {

    private static final String TAG = "CategorySettingAdapter";
    private List<CategoryBean> data;
    private Context context;
    private int resId;
    private LayoutInflater inflater;
    private CategoryDao categoryDao;

    public CategorySettingAdapter(Context context, int resId) {
        this.context = context;
        this.resId = resId;
        inflater = LayoutInflater.from(context);
        categoryDao=new CategoryDao(context);
    }


    public void setData(List<CategoryBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public Object getItem(int position) {
        if (data != null)
            return data.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(resId, parent, false);

        TextView categoryName = (TextView) convertView.findViewById(R.id.tv_category_name);
        TextView categoryDelete = (TextView) convertView.findViewById(R.id.tv_categoty_delete);
        categoryDelete.setOnClickListener(this);
        categoryDelete.setTag(position);

        TextView categoryUpdate = (TextView) convertView.findViewById(R.id.tv_category_update);
        categoryUpdate.setOnClickListener(this);
        categoryUpdate.setTag(position);

        categoryName.setText(data.get(position).getName());
        return convertView;
    }

    MaterialDialog dialog;

    @Override
    public void onClick(View v) {
        final int position= (int) v.getTag();
        if (v.getId() == R.id.tv_categoty_delete) {

            dialog = new MaterialDialog(context).setTitle("提示").setMessage("确定删除“"+data.get(position).getName()+"”吗？").setNegativeButton("取消", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            }).setPositiveButton("确认", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    categoryDao.delete(data.get(position));
                    data.remove(position);
                    dialog.dismiss();
                    notifyDataSetInvalidated();

                }
            });
            dialog.show();

        } else if (v.getId() == R.id.tv_category_update) {
            Log.d(TAG, "onClick: 修改" + v.getTag());
        }

    }
}
