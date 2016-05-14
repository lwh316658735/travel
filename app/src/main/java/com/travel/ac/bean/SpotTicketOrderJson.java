package com.travel.ac.bean;

/**
 * Created by lwh on 2016/5/10. description
 */
public class SpotTicketOrderJson
{

	/**
	 * description :
	 * ★风吹疏竹，曲径回廊，泉水潺湲，温波涟涟，置身池中，身心俱醉。田园温泉之中放目南山，心神邈然。秦龙温泉景色优美，交通便利；
	 * ★看远山近水，感受大地的宁静祥和，有美体养颜的贵妃浴、牛奶浴、花瓣浴，有干蒸房，儿童浴区，养生水疗区，供您选择；
	 * ★室外温泉，静躺水中，深层岩浆送出地表的温水约60℃:温暖慢慢渗入体内，驱走一身的疲劳； ★西安周边唯一一个四季都可以玩儿的温泉水上乐园。 id
	 * : 0 map : null name : null price : null url :
	 * http://image.juntu.com/uploadfile/2015/1201/20151201051505456.jpg
	 */

	private BeanBean	bean;
	/**
	 * bean : {"description":
	 * "★风吹疏竹，曲径回廊，泉水潺湲，温波涟涟，置身池中，身心俱醉。田园温泉之中放目南山，心神邈然。秦龙温泉景色优美，交通便利；\n★看远山近水，感受大地的宁静祥和，有美体养颜的贵妃浴、牛奶浴、花瓣浴，有干蒸房，儿童浴区，养生水疗区，供您选择；\n★室外温泉，静躺水中，深层岩浆送出地表的温水约60℃:温暖慢慢渗入体内，驱走一身的疲劳；\n★西安周边唯一一个四季都可以玩儿的温泉水上乐园。"
	 * ,"id":0,"map":null,"name":null,"price":null,"url":
	 * "http://image.juntu.com/uploadfile/2015/1201/20151201051505456.jpg"} id :
	 * 0 list : null table : spot_description
	 */

	private String		id;
	private Object		list;
	private String		table;

	public BeanBean getBean()
	{
		return bean;
	}

	public void setBean(BeanBean bean)
	{
		this.bean = bean;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public Object getList()
	{
		return list;
	}

	public void setList(Object list)
	{
		this.list = list;
	}

	public String getTable()
	{
		return table;
	}

	public void setTable(String table)
	{
		this.table = table;
	}

	public static class BeanBean
	{
		private String	description;
		private int		id;
		private Object	map;
		private Object	name;
		private Object	price;
		private String	url;
		private String	type;

		public String getType()
		{
			return type;
		}

		public void setType(String type)
		{
			this.type = type;
		}

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

		public Object getMap()
		{
			return map;
		}

		public void setMap(Object map)
		{
			this.map = map;
		}

		public Object getName()
		{
			return name;
		}

		public void setName(Object name)
		{
			this.name = name;
		}

		public Object getPrice()
		{
			return price;
		}

		public void setPrice(Object price)
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
			return "BeanBean{" +
					"description='" + description + '\'' +
					", id=" + id +
					", map=" + map +
					", name=" + name +
					", price=" + price +
					", url='" + url + '\'' +
					", type='" + type + '\'' +
					'}';
		}
	}
}
