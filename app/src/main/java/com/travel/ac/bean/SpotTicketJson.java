package com.travel.ac.bean;

import java.util.List;

/**
 * Created by lwh on 2016/5/10. description
 */
public class SpotTicketJson
{

	/**
	 * bean : null id : null list :
	 * [{"description":"西安周边唯一一个四季都可以玩儿的温泉水上乐园 ","id"
	 * :0,"map":null,"name":"秦龙温泉水上乐园","price":"99","url":
	 * "http://image.juntu.com/uploadfile/2015/0917/20150917110852490.jpg"
	 * },{"description"
	 * :"【4.10-5.10】买一赠一活动： 购买希乐城 亲子套票平日/假日即可赠送希乐城 亲子套票平日/假日票1张，赠票使用需隔日生效"
	 * ,"id":1,"map":null,"name":"西安希乐城少儿职业探索乐园","price":"30","url":
	 * "http://image.juntu.com/uploadfile/2016/0119/20160119031730204.jpg"
	 * },{"description"
	 * :"可随时入园 免去等待集合入园时间 乐华欢乐世界是中国目前拥有过山车数量最多的主题乐园","id":2,"map"
	 * :null,"name":"乐华欢乐世界（乐华城）","price":"178","url":
	 * "http://image.juntu.com/uploadfile/2015/0713/20150713010819620.jpg"
	 * },{"description"
	 * :"天天抢票惠！天竺山国家森林公园成人票每周五下单立减10元！秦岭深处不可多见的森林生态旅游胜地，动植物的天堂，中药材的宝库"
	 * ,"id":3,"map":null,"name":"天竺山国家森林公园","price":"70","url":
	 * "http://image.juntu.com/uploadfile/2013/1127/20131127025244503.jpg"
	 * },{"description"
	 * :"走进北方的香格里拉，美景尽收眼底","id":4,"map":null,"name":"黑河国家森林公园","price"
	 * :"1","url":
	 * "http://image.juntu.com/uploadfile/2015/0323/20150323103354525.jpg"
	 * },{"description"
	 * :"森林资源多姿彩 探险寻幽好去处 ","id":5,"map":null,"name":"金丝峡大峡谷","price":"82","url":
	 * "http://image.juntu.com/uploadfile/2015/0326/20150326023105283.jpg"
	 * },{"description"
	 * :"AAAA级景区 陕西东部黄金旅游线上以生态旅游 登山健身为主题的旅游风景区","id":6,"map":null
	 * ,"name":"少华山国家森林公园","price":"1","url":
	 * "http://image.juntu.com/uploadfile/2015/0526/20150526043337687.jpg"
	 * },{"description"
	 * :"秦巴腹地 汉江两岸特有的原生态美 结合悠久的汉水文化 美不胜收","id":7,"map":null,"name"
	 * :"汉江燕翔洞生态旅游区","price":"65","url":
	 * "http://image.juntu.com/uploadfile/2015/0123/20150123030452956.jpg"
	 * },{"description"
	 * :"素有\u201c夏有寒泉地无大暑\u201d之美称 是避暑 度假 疗养的好去处","id":8,"map":null
	 * ,"name":"铜川玉华宫风景区","price":"35","url":
	 * "http://image.juntu.com/uploadfile/2014/0220/20140220055532788.jpg"
	 * },{"description"
	 * :"一年四季 季季皆景 洞中石钟乳 石林千姿百态 琳琅满目","id":9,"map":null,"name":"月亮洞溶洞景区"
	 * ,"price":"25","url":
	 * "http://image.juntu.com/uploadfile/2013/1125/20131125041536520.jpg"}]
	 * table : spot_list2
	 */

	private Object			bean;
	private Object			id;
	private String			table;
	/**
	 * description : 西安周边唯一一个四季都可以玩儿的温泉水上乐园 id : 0 map : null name : 秦龙温泉水上乐园
	 * price : 99 url :
	 * http://image.juntu.com/uploadfile/2015/0917/20150917110852490.jpg
	 */

	private List<ListBean>	list;

	public Object getBean()
	{
		return bean;
	}

	public void setBean(Object bean)
	{
		this.bean = bean;
	}

	public Object getId()
	{
		return id;
	}

	public void setId(Object id)
	{
		this.id = id;
	}

	public String getTable()
	{
		return table;
	}

	public void setTable(String table)
	{
		this.table = table;
	}

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
		private Object	map;
		private String	name;
		private String	price;
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
	}
}
