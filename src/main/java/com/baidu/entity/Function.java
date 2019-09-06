package com.baidu.entity;

import java.util.List;


/**
 * 功能实体类
 * 实现Comparable接口（排序用: 因为要向sort方法提供对象的比较方式) 
 * @author chenzg
 * @date 2019年9月6日 下午4:27:40
 */
public class Function implements Comparable<Function>{
    private String id;

    private String parentid;

    private String funname;

    private Integer sortNumber;
    
    //子级菜单
    private List<Function> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public String getFunname() {
        return funname;
    }

    public void setFunname(String funname) {
        this.funname = funname == null ? null : funname.trim();
    }

    public Integer getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }
    
	public List<Function> getChildren() {
		return children;
	}

	public void setChildren(List<Function> children) {
		this.children = children;
	}

	@Override
	public int compareTo(Function o) {
		//如果第一个参数小于第二个参数， 会返回一个负值；相等则返回 0; 否则返回一个正值。
		return Integer.compare(this.sortNumber, o.sortNumber);
	}
}