package com.travel.ac.bean;

import java.util.List;

/**
 * Created by lwh on 2016/5/7. description
 */
public class TravelListBean
{
	/**
	 * description : 买一赠一活动： 购买希乐城 亲子套票（一大一小） 平日/假日即可赠送希乐城 亲子套票（一大一小）
	 * 平日/假日票1张，赠票使用需隔日生效 id : 1 name : 西安希乐城少儿职业探索乐园 price : 123.0 url :
	 * http://image.juntu.com/uploadfile/2016/0114/20160114024314918.jpg
	 */
	private List<ListBean>	list;

	public List<ListBean> getList()
	{
		return list;
	}

	public void setList(List<ListBean> list)
	{
		this.list = list;
	}

	public static class ListBean
	{
		private String	description;
		private int		id;
		private String	name;
		private String	price;
		private String	url;

		public String getDescription()
		{
			return description;
		}

		public void setDescription(String description)
		{
			this.description = description;
		}

		public int getId()
		{
			return id;
		}

		public void setId(int id)
		{
			this.id = id;
		}

		public String getName()
		{
			return name;
		}

		public void setName(String name)
		{
			this.name = name;
		}

		public String getPrice()
		{
			return price;
		}

		public void setPrice(String price)
		{
			this.price = price;
		}

		public String getUrl()
		{
			return url;
		}

		public void setUrl(String url)
		{
			this.url = url;
		}

		@Override
		public String toString()
		{
			return "ListBean{" +
					"description='" + description + '\'' +
					", id=" + id +
					", name='" + name + '\'' +
					", price='" + price + '\'' +
					", url='" + url + '\'' +
					'}';
		}
	}

	@Override
	public String toString()
	{
		return "TravelListBean{" +
				"list=" + list +
				'}';
	}
}
