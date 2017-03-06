package com.cacheserverdeploy.deploy;
/** 
* @author E-mail: hou76132927@126.com
* @version Date：2017年3月6日 下午4:43:52 
* Introduction 图类
*/
public class Graph {
	int vexNum,arcNum,costnode;//节点数目，链路数目，消费节点数目
	int []vex;//节点信息
	EdgeElement [][]arcs;//邻接矩阵
	int deployCost;//部署成本
	public Graph(){}//空构造函数
	public void initalVAC(String[]vexinfo){//初始化节点数目，链路数目，消费节点数目
		this.vexNum=Integer.parseInt(vexinfo[0]);
		this.arcNum=Integer.parseInt(vexinfo[1]);
		this.costnode=Integer.parseInt(vexinfo[2]);
	}
	public void createGraph(String[] graphContent){//初始化图
		this.initalVAC(graphContent[0].split(" "));
		this.deployCost=Integer.parseInt(graphContent[2]);//初始化部署成本
		
		vex=new int[vexNum];//初始化节点信息
		int i=0;
		for(i=0;i<vexNum;i++)//节点赋值
			vex[i]=i;
		
		arcs=new EdgeElement[vexNum][vexNum];//初始化边信息
		for(i=4;"".equals(graphContent[i]);i++){//边赋值
			String[]arcsInfo=graphContent[i].split("");
			int f,e,b,p;
			f=Integer.parseInt(arcsInfo[0]);
			e=Integer.parseInt(arcsInfo[1]);
			b=Integer.parseInt(arcsInfo[2]);
			p=Integer.parseInt(arcsInfo[3]);
			
		}
	}
}
