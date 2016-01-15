package cn.wxyx.ygkc2.tree.beanforlist;

import cn.wxyx.ygkc2.tree.bean.TreeNodeId;
import cn.wxyx.ygkc2.tree.bean.TreeNodeLabel;
import cn.wxyx.ygkc2.tree.bean.TreeNodePid;
@SuppressWarnings("unused")
public class FileBean
{
	@TreeNodeId
	private int _id;
	@TreeNodePid
	private int parentId;
	@TreeNodeLabel
	private String name;

	private long length;
	private String desc;

	public FileBean(int _id, int parentId, String name)
	{
		super();
		this._id = _id;
		this.parentId = parentId;
		this.name = name;
	}

}
