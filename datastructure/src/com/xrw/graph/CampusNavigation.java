package com.xrw.graph;

import java.util.*;

/**
 * @program: DataStructures
 * @description: 校园导航问题
 * 地图数据来源于百度地图坐标拾取https://api.map.baidu.com/lbsapi/getpoint/index.html
 * 将13个景点构造成图，用邻接表结构存储
 *
 * 功能：
 * （1）设计学校的校园平面图（参考江苏大学校园网上校园平面图或者百度地图），所含景点不少于10个，以图中顶点表示校内各景点，存放景点名称、代号、简介等信息；以边表示路径，存放路径长度等相关信息。
 *
 * （2）为来访客人提供图中任意景点相关信息的查询。
 *
 * （3）为来访客人提供景点的问路查询，即已知一个景点，查询到某景点之间的一条最短路径及长度。
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-05-23 18:52
 **/
public class CampusNavigation {

    public static void main(String[] args) {
        /************ 构造邻接表-start **************/
        Attraction attraction0 = new Attraction(0,"江苏大学京江操场","体育场地，近京江学院、江苏大学西门"
                ,"学府路301号江苏大学西门",119.516389,32.211077,null);
        Attraction attraction1 = new Attraction(1,"江苏大学F区宿舍","江苏大学学生宿舍F区，近京江学院、江苏大学西门、六食堂，大部分住宿学生为男生"
                ,"镇江市京口区谷阳路与禹山路交叉路口往东南约100米(江苏大学)",119.516958,32.213999,null);
        Attraction attraction2 = new Attraction(2,"江苏大学六食堂","江苏大学第六食堂，近京江学院、江苏大学西门、F区宿舍，六食堂菜式丰富，食物味道可口，并且非常实惠"
                ,"镇江市京口区学府路301号",119.518984,32.212734,null);
        Attraction attraction3 = new Attraction(3,"江苏大学图书馆","江苏大学新图书馆，近江大正门、计算机学院、研究生楼"
                ,"镇江市京口区学府路301号",119.517791,32.204924,null);
        Attraction attraction4 = new Attraction(4,"江苏大学研究生院","江苏大学研究生院，近江大正门、计算机学院、研究生楼，也是疫苗接种点"
                ,"丹徒路301号江苏大学附近",119.514466,32.203369,null);
        Attraction attraction5 = new Attraction(5,"江苏大学三江楼","江苏大学最大也是最著名的授课场所，近江大中门、三山楼、五棵松"
                ,"镇江市京口区学府路301号",119.525039,32.20211,null);
        Attraction attraction6 = new Attraction(6,"江苏大学三山楼","江苏大学第二大的授课场所，通常供高年级同学上课使用，近江大中门、三江楼、五棵松"
                ,"镇江市京口区学府路301号",119.522016,32.202085,null);
        Attraction attraction7 = new Attraction(7,"江苏大学学生工作处","江苏大学学生工作处，位于三山楼和三江楼之间"
                ,"毓秀路与求实路交叉口西100米",119.52354,32.202582,null);
        Attraction attraction8 = new Attraction(8,"江苏大学大礼堂","江苏大学大礼堂，近A区女生宿舍，常用于学术会议、学术活动、文艺演出"
                ,"镇江市京口区禹山路(江苏大学)",119.523362,32.205959,null);
        Attraction attraction9 = new Attraction(9,"江苏大学A区","女生宿舍，近江苏大学大礼堂、西山操场、三食堂"
                ,"镇江市京口区学府路301号江苏大学A区",119.523031,32.206758,null);
        Attraction attraction10 = new Attraction(10,"江苏大学体育馆","体育场地，近江苏大学中门，内设乒乓球场、篮球场、羽毛球场、游泳馆、健身房等"
                ,"镇江市京口区学府路301号",119.527316,32.200079,null);
        Attraction attraction11 = new Attraction(11,"江苏大学西山操场","体育场地，近女生宿舍，位于江苏大学本部校区中间位置"
                ,"镇江市京口区学府路301号",119.521858,32.206487,null);
        Attraction attraction12 = new Attraction(12,"江苏大学东山操场","体育场地，近江苏大学中门、教工宿舍群"
                ,"镇江市京口区学府路301号",119.527173,32.202735,null);
        AttractionGraph graph = new AttractionGraph();
        graph.add(attraction0);
        graph.add(attraction1);
        graph.add(attraction2);
        graph.add(attraction3);
        graph.add(attraction4);
        graph.add(attraction5);
        graph.add(attraction6);
        graph.add(attraction7);
        graph.add(attraction8);
        graph.add(attraction9);
        graph.add(attraction10);
        graph.add(attraction11);
        graph.add(attraction12);
        graph.get(0).setNext(new GraphNode(1,500,null));
        graph.get(0).getNext()
                .add(new GraphNode(2,290,null))
                .add(new GraphNode(3,920,null))
                .add(new GraphNode(4,1100,null))
                .add(new GraphNode(5,1700,null))
                .add(new GraphNode(6,1400,null))
                .add(new GraphNode(7,1600,null))
                .add(new GraphNode(8,1300,null))
                .add(new GraphNode(9,1200,null))
                .add(new GraphNode(10,2200,null))
                .add(new GraphNode(11,1100,null))
                .add(new GraphNode(12,1900,null));
        graph.get(1).setNext(new GraphNode(0,500,null));
        graph.get(1).getNext()
                .add(new GraphNode(2,420,null))
                .add(new GraphNode(3,1300,null))
                .add(new GraphNode(4,1500,null))
                .add(new GraphNode(5,2000,null))
                .add(new GraphNode(6,1800,null))
                .add(new GraphNode(7,1700,null))
                .add(new GraphNode(8,1500,null))
                .add(new GraphNode(9,1300,null))
                .add(new GraphNode(10,2400,null))
                .add(new GraphNode(11,1200,null))
                .add(new GraphNode(12,2100,null));
        graph.get(2).setNext(new GraphNode(0,290,null));
        graph.get(2).getNext()
                .add(new GraphNode(1,420,null))
                .add(new GraphNode(3,1100,null))
                .add(new GraphNode(4,1300,null))
                .add(new GraphNode(5,1600,null))
                .add(new GraphNode(6,1400,null))
                .add(new GraphNode(7,1300,null))
                .add(new GraphNode(8,1100,null))
                .add(new GraphNode(9,930,null))
                .add(new GraphNode(10,2000,null))
                .add(new GraphNode(11,830,null))
                .add(new GraphNode(12,1700,null));
        graph.get(3).setNext(new GraphNode(0,920,null));
        graph.get(3).getNext()
                .add(new GraphNode(1,1300,null))
                .add(new GraphNode(2,1100,null))
                .add(new GraphNode(4,430,null))
                .add(new GraphNode(5,990,null))
                .add(new GraphNode(6,690,null))
                .add(new GraphNode(7,880,null))
                .add(new GraphNode(8,840,null))
                .add(new GraphNode(9,930,null))
                .add(new GraphNode(10,1400,null))
                .add(new GraphNode(11,870,null))
                .add(new GraphNode(12,1300,null));
        graph.get(4).setNext(new GraphNode(0,1100,null));
        graph.get(4).getNext()
                .add(new GraphNode(1,1500,null))
                .add(new GraphNode(2,1300,null))
                .add(new GraphNode(3,430,null))
                .add(new GraphNode(5,1200,null))
                .add(new GraphNode(6,850,null))
                .add(new GraphNode(7,1100,null))
                .add(new GraphNode(8,1100,null))
                .add(new GraphNode(9,1200,null))
                .add(new GraphNode(10,1600,null))
                .add(new GraphNode(11,1200,null))
                .add(new GraphNode(12,1400,null));
        graph.get(5).setNext(new GraphNode(0,1700,null));
        graph.get(5).getNext()
                .add(new GraphNode(1,2000,null))
                .add(new GraphNode(2,1600,null))
                .add(new GraphNode(3,990,null))
                .add(new GraphNode(4,1200,null))
                .add(new GraphNode(6,320,null))
                .add(new GraphNode(7,240,null))
                .add(new GraphNode(8,570,null))
                .add(new GraphNode(9,760,null))
                .add(new GraphNode(10,330,null))
                .add(new GraphNode(11,750,null))
                .add(new GraphNode(12,250,null));
        graph.get(6).setNext(new GraphNode(0,1400,null));
        graph.get(6).getNext()
                .add(new GraphNode(1,1800,null))
                .add(new GraphNode(2,1400,null))
                .add(new GraphNode(3,690,null))
                .add(new GraphNode(4,850,null))
                .add(new GraphNode(5,320,null))
                .add(new GraphNode(7,230,null))
                .add(new GraphNode(8,640,null))
                .add(new GraphNode(9,730,null))
                .add(new GraphNode(10,750,null))
                .add(new GraphNode(11,660,null))
                .add(new GraphNode(12,570,null));
        graph.get(7).setNext(new GraphNode(0,1600,null));
        graph.get(7).getNext()
                .add(new GraphNode(1,1700,null))
                .add(new GraphNode(2,1300,null))
                .add(new GraphNode(3,880,null))
                .add(new GraphNode(4,1100,null))
                .add(new GraphNode(5,240,null))
                .add(new GraphNode(6,230,null))
                .add(new GraphNode(8,430,null))
                .add(new GraphNode(9,620,null))
                .add(new GraphNode(10,670,null))
                .add(new GraphNode(11,560,null))
                .add(new GraphNode(12,460,null));
        graph.get(8).setNext(new GraphNode(0,1300,null));
        graph.get(8).getNext()
                .add(new GraphNode(1,1500,null))
                .add(new GraphNode(2,1100,null))
                .add(new GraphNode(3,840,null))
                .add(new GraphNode(4,1100,null))
                .add(new GraphNode(5,570,null))
                .add(new GraphNode(6,640,null))
                .add(new GraphNode(7,430,null))
                .add(new GraphNode(9,180,null))
                .add(new GraphNode(10,990,null))
                .add(new GraphNode(11,180,null))
                .add(new GraphNode(12,680,null));
        graph.get(9).setNext(new GraphNode(0,1200,null));
        graph.get(9).getNext()
                .add(new GraphNode(1,1300,null))
                .add(new GraphNode(2,930,null))
                .add(new GraphNode(3,930,null))
                .add(new GraphNode(4,1200,null))
                .add(new GraphNode(5,760,null))
                .add(new GraphNode(6,730,null))
                .add(new GraphNode(7,620,null))
                .add(new GraphNode(8,180,null))
                .add(new GraphNode(10,1100,null))
                .add(new GraphNode(11,90,null))
                .add(new GraphNode(12,780,null));
        graph.get(10).setNext(new GraphNode(0,2200,null));
        graph.get(10).getNext()
                .add(new GraphNode(1,2400,null))
                .add(new GraphNode(2,2000,null))
                .add(new GraphNode(3,1400,null))
                .add(new GraphNode(4,1600,null))
                .add(new GraphNode(5,330,null))
                .add(new GraphNode(6,750,null))
                .add(new GraphNode(7,670,null))
                .add(new GraphNode(8,990,null))
                .add(new GraphNode(9,1100,null))
                .add(new GraphNode(11,1200,null))
                .add(new GraphNode(12,400,null));
        graph.get(11).setNext(new GraphNode(0,1100,null));
        graph.get(11).getNext()
                .add(new GraphNode(1,1200,null))
                .add(new GraphNode(2,830,null))
                .add(new GraphNode(3,870,null))
                .add(new GraphNode(4,1200,null))
                .add(new GraphNode(5,750,null))
                .add(new GraphNode(6,660,null))
                .add(new GraphNode(7,560,null))
                .add(new GraphNode(8,180,null))
                .add(new GraphNode(9,90,null))
                .add(new GraphNode(10,1200,null))
                .add(new GraphNode(12,860,null));
        graph.get(12).setNext(new GraphNode(0,1900,null));
        graph.get(12).getNext()
                .add(new GraphNode(1,2100,null))
                .add(new GraphNode(2,1700,null))
                .add(new GraphNode(3,1300,null))
                .add(new GraphNode(4,1400,null))
                .add(new GraphNode(5,250,null))
                .add(new GraphNode(6,570,null))
                .add(new GraphNode(7,460,null))
                .add(new GraphNode(8,680,null))
                .add(new GraphNode(9,780,null))
                .add(new GraphNode(10,400,null))
                .add(new GraphNode(11,860,null));
        /************ 构造邻接表-stop **************/
        //接收用户输入
        char key = ' ';
        //输入流
        Scanner scanner = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        //控制程序结束的标记
        boolean loop = true;
        //程序运行，提供一个循环操作给用户
        while (loop){
            System.out.println("a(all): 显示所有的景点");
            System.out.println("s(search): 查询一个景点的详细信息");
            System.out.println("p(path): 查询从一个景点到另一个景点的最短路径");
            System.out.println("e(exit): 退出程序");
            key = scanner.next().charAt(0);//获取用户输入的第一个字符
            switch (key){
                case 'a':
                    for (Attraction value : graph) {
                        System.out.print(value.getName() + "\t");
                    }
                    System.out.println();
                    break;
                case 's':
                    System.out.println("请输入景点的名称：");
                    String attractionName = scanner.next();

                    Attraction attractionDetail = graph.searchAttraction(attractionName);
                    if (attractionDetail != null){
                        System.out.println(attractionDetail);
                        break;
                    }
                    System.out.println("该景点不存在！");
                    break;
                case 'p':
                    System.out.println("请输入出发景点的名称：");
                    String startAttraction = scanner.next();
                    if (!graph.containsAttraction(startAttraction)){
                        System.out.println("该景点不存在！");
                        break;
                    }
                    System.out.println("请输入到达景点的名称：");
                    String stopAttraction = scanner.next();
                    if (!graph.containsAttraction(stopAttraction)){
                        System.out.println("该景点不存在！");
                        break;
                    }
                    Map<Attraction,Integer> attractions = graph.shortestPath(startAttraction,stopAttraction);
                    if (attractions == null){
                        System.out.println("路径不存在！");
                        break;
                    }
                    attractions.forEach((id,value) -> System.out.println("到达 "+id.getName()+"，需"+value+"米\t"));
                    System.out.println();
                    break;
                case 'e':
                    loop = false;
                    break;
                default:
                    System.out.println("输入非法，请重新输入");
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
}

/**
 * @Description: 顶点（景点）集合，集合中每个元素都是一个单链表，代表了从顶点出发能直接到达的相邻顶点
 * @Author: 谢荣旺
 * @Date: 2021/5/27
 */
class AttractionGraph extends ArrayList<Attraction> {

    /**
     * @Description: 通过景点名称查询景点是否存在
     * @param key: 景点名称
     * @return: boolean
     * @Author: 谢荣旺
     * @Date: 2021/5/27
     */
    public boolean containsAttraction(String key){
        List<String> attractionNames = new ArrayList<>();
        for (Attraction attraction : this){
            attractionNames.add(attraction.getName());
        }
        return attractionNames.contains(key);
    }

    /**
     * 通过出发景点和目的景点查询最短路径    应用迪杰斯特拉（Dijkstra）算法，时间复杂度为O(n^2)
     * @param startAttraction 出发景点的名称
     * @param stopAttraction 目的景点的名称
     * @return
     */
    public Map<Attraction,Integer> shortestPath(String startAttraction,String stopAttraction){
        //出发景点的编号
        int startNo = 0;
        //目的景点的编号
        int stopNo = 0;
        //通过出发景点和目的景点的名称查找他们各自的编号
        for (Attraction attraction : this) {
            if (attraction.getName().equals(startAttraction)) {
                startNo = attraction.getNo();
            }
            if (attraction.getName().equals(stopAttraction)) {
                stopNo = attraction.getNo();
            }
        }
        //辅助集合，存放到达i的最短路径的长度
        ArrayList<Integer> dist = new ArrayList<>();
        //辅助集合，存放到达i的最短路径的前驱节点
        ArrayList<Integer> path = new ArrayList<>();
        //辅助集合，标记已经找到最短路径的节点
        ArrayList<Integer> s = new ArrayList<>();
        //构造初始dis、path、s集合
        /************ 构造初始dis、path、s集合-start **************/
        //dist中元素默认值为无穷大，表示无法到达
        //path中元素默认值为-1，表示无法到达或者出发节点本身
        //s中元素默认值为0，表示还未找到最短路径
        for(Attraction attraction : this){
            dist.add(Integer.MAX_VALUE);
            path.add(-1);
            s.add(0);
        }
        //出发节点的dist为0，表示不需要行动就可到达
        dist.set(startNo,0);
        //从出发节点到他自身不需要再去寻找最短路径，就是他自己，故直接设为1，表示已经找到
        s.set(startNo,1);
        //辅助指针，用来遍历出发景点的可直接达到的相邻节点
        GraphNode temp = this.get(startNo).getNext();
        //遍历出发顶点的有向边
        while (temp != null) {
            //修改可到达的顶点的dist值
            dist.set(temp.getNo(), temp.getDistance());
            //修改可到达的顶点的path值，即前驱顶点
            path.set(temp.getNo(), startNo);
            //继续往后遍历
            temp = temp.getNext();
        }
        /************ 构造初始dis、path、s集合-stop **************/
        /************    最短路径的求解-start       **************/
        //因为出发顶点本身不需要再求最短路径，故只需要遍历this.size()-1次
        for (int i = 0; i < this.size()-1; i++) {
            int mix = Integer.MAX_VALUE;
            int mixIndex = startNo;
            //第一次内循环，找出最小的最短路径，并记录最小的最短路径对应的顶点编号和路径长度
            for (int j=0;j<dist.size();j++){
                if (s.get(j) == 0 && dist.get(j) < mix){
                    mixIndex = j;
                    mix = dist.get(j);
                }
            }
            s.set(mixIndex,1);
            boolean loop = true;
            GraphNode temp2 = this.get(mixIndex).getNext();
            //对辅助集合dist和path进行修改，查找出新的最短路径集合
            while (temp2 != null) {
                if (s.get(temp2.getNo()) == 0 && mix + temp2.getDistance() < dist.get(temp2.getNo())){
                    dist.set(temp2.getNo(),mix + temp2.getDistance());
                    path.set(temp2.getNo(),mixIndex);
                }
                temp2 = temp2.getNext();
            }
        }
        /************     最短路径的求解-stop       **************/
//        System.out.println(s);
//        System.out.println(dist);
//        System.out.println(path);
        /************     通过对辅助数组的查找，将最短路径返回-start       **************/
        Map<Attraction,Integer> map = new LinkedHashMap<>();
        AttractionGraph attractionGraph = new AttractionGraph();
        //查找路径，并返回
        map.put(this.get(startNo),0);
        while (stopNo != startNo){
            if (path.get(stopNo) == -1){
                return null;
            }
            attractionGraph.add(this.get(stopNo));
            stopNo = path.get(stopNo);
        }
        //因为是倒序查找的，所以找完之后要将集合的顺序反转
        Collections.reverse(attractionGraph);
        attractionGraph.forEach(attraction -> map.put(attraction,dist.get(attraction.getNo())));
        /************     通过对辅助数组的查找，将最短路径返回-stop       **************/
        return map;
    }

    /**
     * @Description: 通过顶点名称查找顶点的详细信息
     * @param key: 顶点名称
     * @return: com.xrw.graph.Attraction
     * @Author: 谢荣旺
     * @Date: 2021/5/27
     */
    public Attraction searchAttraction(String key){
        for (Attraction attraction : this) {
            if (attraction.getName().equals(key)) {
                return attraction;
            }
        }
        return null;
    }
}

/**
 * @Description: 有向边对应的顶点编号和有向边的长度
 * @Author: 谢荣旺
 * @Date: 2021/5/27
 */
class GraphNode{
    private int no;
    private int distance;
    private GraphNode next;

    public GraphNode(int no, int distance, GraphNode next) {
        this.no = no;
        this.distance = distance;
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public GraphNode getNext() {
        return next;
    }

    public void setNext(GraphNode next) {
        this.next = next;
    }

    public GraphNode add(GraphNode graph) {
        GraphNode temp = this;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = graph;
        return graph;
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "no=" + no +
                ", distance=" + distance +
                ", next=" + next +
                '}';
    }
}

/**
 * @Description: 顶点对象
 * @Author: 谢荣旺
 * @Date: 2021/5/27
 */
class Attraction{
    private int no;
    private String name;
    private String introduce;
    private String position;
    private double longitude;
    private double latitude;
    private GraphNode next;

    public Attraction(int no, String name, String introduce, String position, double longitude, double latitude, GraphNode next) {
        this.no = no;
        this.name = name;
        this.introduce = introduce;
        this.position = position;
        this.longitude = longitude;
        this.latitude = latitude;
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public GraphNode getNext() {
        return next;
    }

    public void setNext(GraphNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                ", position='" + position + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    public String toString2() {
        return "Attraction{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                ", position='" + position + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", next=" + next +
                '}';
    }
}