package com.cacheserverdeploy.deploy;
/** 
* @author E-mail: hou76132927@126.com
* @version Date：2017年3月6日 下午4:43:52 
* Introduction 图类
*/
public class Graph {
	int vexNum,arcNum,costNodeNum;//节点数目，链路数目，消费节点数目
	int []vex;//节点信息
	EdgeElement [][]arcs;//邻接矩阵
	int deployCost;//部署成本
	CostNode []cnode;
	public Graph(){}//空构造函数
	public void initalVAC(String[]vexinfo){//初始化节点数目，链路数目，消费节点数目
		this.vexNum=Integer.parseInt(vexinfo[0]);
		this.arcNum=Integer.parseInt(vexinfo[1]);
		this.costNodeNum=Integer.parseInt(vexinfo[2]);
	}
	public int initalArcs(String[] graphContent){//初始化边信息
		this.arcs=new EdgeElement[vexNum][vexNum];
		for(int v=0;v<vexNum;v++)
			for(int u=0;u<vexNum;u++){
				arcs[v][u]=new EdgeElement();
				arcs[u][v]=new EdgeElement();
				}
		int i;
		for(i=4;!(graphContent[i]==null||graphContent[i].length()<=0);i++){//边赋值
			String[]arcsInfo=graphContent[i].split(" ");
			int f,e,b,p;
			f=Integer.parseInt(arcsInfo[0]);
			e=Integer.parseInt(arcsInfo[1]);
			b=Integer.parseInt(arcsInfo[2]);
			p=Integer.parseInt(arcsInfo[3]);
			this.arcs[f][e].bandwidth=this.arcs[e][f].bandwidth=b;
			this.arcs[f][e].percost=this.arcs[e][f].percost=p;	
		}
		return i;
	}
	public void initalCostNode(int tag,String[] graphContent){///初始化消费节点信息
		int len=graphContent.length;
		cnode=new CostNode[len-tag-1];
		len=cnode.length;
		tag++;
		for(int i=0;i<len;i++){
			String[]cnodeinfo=graphContent[i+tag].split(" ");
			cnode[i]=new CostNode();
			cnode[i].nodeid=Integer.parseInt(cnodeinfo[0]);
			cnode[i].vexid=Integer.parseInt(cnodeinfo[1]);
			cnode[i].need=Integer.parseInt(cnodeinfo[2]);
		}
			
	}
	public void createGraph(String[] graphContent){//初始化图
		this.initalVAC(graphContent[0].split(" "));
		this.deployCost=Integer.parseInt(graphContent[2]);//初始化部署成本
		
		vex=new int[vexNum];//初始化节点信息
		for(int i=0;i<vexNum;i++)//节点赋值
			vex[i]=i;	
		int tag=this.initalArcs(graphContent);//初始化边
		this.initalCostNode(tag,graphContent);//初始化消费节点
	}
	public void printArcs(){
//		  for(int i=0;i<cnode.length;i++)
//			   System.out.println(cnode[i].nodeid+" "+cnode[i].vexid+" "+cnode[i].need);
//		for(int i=0;i<vexNum;i++){
//			for(int j=0;j<vexNum;j++)
//				if(arcs[i][j].bandwidth!=-1)
//					{System.out.println(i+" "+j+" "+arcs[i][j].bandwidth+"  "+arcs[i][j].percost+", ");}
//		}
	
	}
	
	
	
	public String[] getResult(){
		String []result=new String[cnode.length+2];
		result[0]=String.valueOf(cnode.length);
		result[1]="\r\n";
		for(int i=0;i<cnode.length;i++)
			result[i+2]=String.valueOf(cnode[i].vexid)+" "+String.valueOf(cnode[i].nodeid)+" "+String.valueOf(cnode[i].need);
		return result;
		
	}
}
