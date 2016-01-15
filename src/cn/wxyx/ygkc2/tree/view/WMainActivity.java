package cn.wxyx.ygkc2.tree.view;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import cn.wxyx.ygkc2.R;
import cn.wxyx.ygkc2.tree.bean.Node;
import cn.wxyx.ygkc2.tree.bean.TreeListViewAdapter;
import cn.wxyx.ygkc2.tree.bean.TreeListViewAdapter.OnTreeNodeClickListener;
import cn.wxyx.ygkc2.tree.beanforlist.Bean;
import cn.wxyx.ygkc2.tree.beanforlist.FileBean;


public class WMainActivity extends Activity
{
	@SuppressWarnings("unused")
	private List<Bean> mDatas = new ArrayList<Bean>();
	private List<FileBean> mDatas2 = new ArrayList<FileBean>();
	private ListView mTree;
	@SuppressWarnings("rawtypes")
	private TreeListViewAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listactivity_main);

		initDatas();
		mTree = (ListView) findViewById(R.id.id_tree);
		try
		{
			mAdapter = new SimpleTreeAdapter<FileBean>(mTree, this, mDatas2, 10);
			mAdapter.setOnTreeNodeClickListener(new OnTreeNodeClickListener()
			{
				@Override
				public void onClick(Node node, int position)
				{
					if (node.isLeaf())
					{                                                                                                                                                    
						Toast.makeText(getApplicationContext(), node.getName(),
								Toast.LENGTH_SHORT).show();
					}
				}

			});

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		mTree.setAdapter(mAdapter);

	}

	private void initDatas()
	{

		mDatas2.add(new FileBean(1, 0, "无锡第二人民医院"));

		mDatas2.add(new FileBean(3, 1, "派单信息"));
		mDatas2.add(new FileBean(4, 1, "联系客户"));
		mDatas2.add(new FileBean(5, 1, "完成服务"));

		mDatas2.add(new FileBean(6, 3, "客户信息"));
		mDatas2.add(new FileBean(7, 3, "服务请求信息"));
		mDatas2.add(new FileBean(8, 3, "派单信息"));
		
		mDatas2.add(new FileBean(36, 4, "约定到达时间(选择)"+"\n"+"是否按派单内容服务"));
		
		mDatas2.add(new FileBean(39, 5, "完成服务"));
		
		mDatas2.add(new FileBean(9, 6, "客户卡号"));
		mDatas2.add(new FileBean(10, 6, "客户类型"));
		mDatas2.add(new FileBean(11, 6, "客户名称"));
		mDatas2.add(new FileBean(12, 6, "联系人"));
		mDatas2.add(new FileBean(13, 6, "固定电话"));
		mDatas2.add(new FileBean(14, 6, "手机"));
		mDatas2.add(new FileBean(15, 6, "所属区域"));
		mDatas2.add(new FileBean(16, 6, "所属服务区域"));
		mDatas2.add(new FileBean(17, 6, "关系类型"));
		mDatas2.add(new FileBean(18, 6, "地址"));
		mDatas2.add(new FileBean(19, 6, "公交线路"));
		mDatas2.add(new FileBean(20, 6, "所属门店"));
		mDatas2.add(new FileBean(21, 6, "所属部门"));
		mDatas2.add(new FileBean(22, 6, "所属人员"));
		
		mDatas2.add(new FileBean(23, 7, "需求描述"));
		mDatas2.add(new FileBean(24, 7, "服务级别"));
		mDatas2.add(new FileBean(25, 7, "服务方式"));
		mDatas2.add(new FileBean(26, 7, "发起人"));
		mDatas2.add(new FileBean(27, 7, "发起时间"));
		
		mDatas2.add(new FileBean(28, 8, "最晚服务完成时间"));
		mDatas2.add(new FileBean(29, 8, "工程师级别"));
		mDatas2.add(new FileBean(30, 8, "预计服务费用"));
		mDatas2.add(new FileBean(31, 8, "注意事项"));
		mDatas2.add(new FileBean(32, 8, "服务工程师"));
		mDatas2.add(new FileBean(33, 8, "主要工程师"));
		mDatas2.add(new FileBean(34, 8, "任务类型"));
		mDatas2.add(new FileBean(35, 8, "单量"));
		
		
	}

}
