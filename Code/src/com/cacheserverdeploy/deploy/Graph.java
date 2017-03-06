package com.cacheserverdeploy.deploy;
/** 
* @author E-mail: hou76132927@126.com
* @version Date：2017年3月6日 下午4:43:52 
* Introduction 图类
*/
public class Graph {
	//通过边结点来构建一个图
	void creatGraph(EdgeElement d[]) {
	} 
	//返回图的顶点数 
	int vertices() {
		return 0;
	}    
	//返回图的边数  
    int edges() {
		return 0;
	} 
    //从图中查找一条边(i,j)是否存在  
    boolean find(int i,int j) {
		return false;
	} 
    //像图中插入一条边 theEdge 
    void putEdge(EdgeElement theEdge) {
	} 
    //从图中删除一条边  
    void removeEdge(int i,int j) {
	}      
  //返回顶点i的度
    int degree(int i) {
		return 0;
	}  
    //返回顶点i的入度
    int inDegree(int i) {
		return 0;
	}
    //返回顶点i的出度
    int outDegree(int i) {
		return 0;
	}     
    //以图的顶点集和边集的形式输出一个图
    void output() {
	}       
    //从顶点v开始深度优先搜索整幅图
    void depthFirstSearch(int v) {
	}   
    //从顶点v开始广度优先搜索整幅图
    void breadthFirstSearch(int v) {
	}         
}
