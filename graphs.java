import java.util.*;
public class graphs{
    static class Edge{
        int src;
        int dest;
        //int wt;
        Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
           // this.wt=wt;
        }
    }
    public static void creategraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        // graph[0].add(new Edge(0,1,1));
        // graph[0].add(new Edge(0,2,1));
        // graph[1].add(new Edge(1,0,1));
        // graph[1].add(new Edge(1,3,1));
        // graph[2].add(new Edge(2,0,1));
        // graph[2].add(new Edge(2,4,1));
        // graph[3].add(new Edge(3,1,1));
        // graph[3].add(new Edge(3,4,1));
        // graph[3].add(new Edge(3,5,1));
        // graph[4].add(new Edge(4,2,1));
        // graph[4].add(new Edge(4,3,1));
        // graph[4].add(new Edge(4,5,1));
        // graph[5].add(new Edge(5,3,1));
        // graph[5].add(new Edge(5,4,1));
        // graph[5].add(new Edge(5,6,1));
        // graph[5].add(new Edge(5,5,1));


        //barpartite graph
        // graph[0].add(new Edge(0,1,1));
        // graph[0].add(new Edge(0,2,1));
        // graph[1].add(new Edge(1,0,1));
        // graph[1].add(new Edge(1,3,1));
        // graph[2].add(new Edge(2,0,1));
        // graph[2].add(new Edge(2,3,1));

        //directed graph
        // graph[1].add(new Edge(1,2,1));
        // graph[1].add(new Edge(1,3,1));
        // graph[3].add(new Edge(3,4,1));
        // graph[2].add(new Edge(2,4,1));

        //topological
        // graph[5].add(new Edge(5,0,1));
        // graph[5].add(new Edge(5,2,1));
        // graph[4].add(new Edge(4,0,1));
        // graph[4].add(new Edge(4,1,1));
        // graph[2].add(new Edge(2,3,1));
        // graph[3].add(new Edge(3,1,1));

       // dijkart's graph
        // graph[0].add(new Edge(0,1,2));
        // graph[0].add(new Edge(0,2,4));
        // graph[1].add(new Edge(1,2,1));
        // graph[1].add(new Edge(1,3,7));
        // graph[2].add(new Edge(2,4,3));
        // graph[3].add(new Edge(3,5,1));
        // graph[4].add(new Edge(4,3,2));
        // graph[4].add(new Edge(4,5,5));
        
        //bellman
        // graph[0].add(new Edge(0,1,2));
        // graph[0].add(new Edge(0,2,4));
        // graph[1].add(new Edge(1,2,-4));
        // graph[2].add(new Edge(2,3,2));
        // graph[3].add(new Edge(3,4,4));
        // graph[4].add(new Edge(4,1,-1));

        //kosaraju
        graph[0].add(new Edge(0,2)); 
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,4));
    }
    public static void bfs(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            if(!vis[i]){
                bfsutil(graph,vis);
            }
        }
    }
    public static void bfsutil(ArrayList<Edge> graph[],boolean vis[])
    {
        Queue<Integer> q= new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int curr=q.remove();
            if(!vis[curr]){
                System.out.print(curr + " ");
                vis[curr]=true;
                for(int i=0;i<graph[i].size();i++){
                    Edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void dfs(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                dfsutil(graph,vis,i);
                //System.out.println(); //for SCC
            }
        }
    }
    public static void dfsutil(ArrayList<Edge> graph[],boolean vis[],int curr){
        System.out.print(curr +" ");                                       
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i); //this is edge i.e. (0,1)(0,2)(1,3)(1,0)....
            if(!vis[e.dest]){
                dfsutil(graph, vis, e.dest);   
            }
        }
        //System.out.println();
    }
    public static boolean haspath(ArrayList<Edge> graph[],int src,int dest,boolean vis[]){
        if(src==dest){
            return true; // will return true to haspath but sirf return hua hai ... 
        }
        vis[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
           // if(!vis[e.dest]){
               // haspath(graph,e.dest,dest,vis); // if this return true then we return true rather than calling for further more;
                // ek jagah se mera ans aa chuka hai na so i wont check further
           // }
           if(!vis[e.dest] && haspath(graph, e.dest, dest, vis)){
               return true;
           }
        }
        return false;
    }
    public static boolean detectcycle(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
           if(!vis[i] && detectcycleutil(graph,i,vis,-1)){
              return true;
           }
        }
        return false;
    }
    public static boolean detectcycleutil(ArrayList<Edge> graph[],int curr,boolean vis[],int par){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                if(detectcycleutil(graph,e.dest,vis,curr))
                    return true;
            }
            // if(!vis[e.dest] && detectcycleutil(graph,e.dest,vis,curr)){ //yeh condition to kabhi false hii nhii hui
            //     return true;
            // }
            else if(vis[e.dest] && e.dest!=par){ //e.dest=jahan mai jaa rahi hoon wo mera par=jahan se mai aayi hoon are not equal
                return true;
            }
            //case 2 : do nothing = continue
        }
        return false;
    }
    public static boolean isbarpartite(ArrayList<Edge> graph[]){
        int col[]=new int[graph.length];
        for(int i=0;i<col.length;i++){
            col[i]=-1;
        } 
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(col[i]==-1){
                q.add(i);
                col[i]=0;
                while(!q.isEmpty()){
                    int curr=q.remove();
                    for(int j=0;j<graph[curr].size();j++){
                        Edge e=graph[curr].get(j);
                        if(col[e.dest]==-1){
                            int nextcol=col[curr]==0?1:0;
                            col[e.dest]=nextcol;
                            q.add(e.dest);
                        }else if(col[e.dest]==col[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public static boolean directedcycle(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(directedutil(graph,vis,stack,i)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean directedutil(ArrayList<Edge> graph[],boolean vis[],boolean stack[],int curr){
        vis[curr]=true;
        stack[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            if(!vis[e.dest] && directedutil(graph,vis,stack,e.dest)){
                return true;
            }
        }
        stack[curr]=false;
        return false;
    }
    public static void topsort(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topsortutil(graph,vis,s,i);
            }
        }
        while(!s.isEmpty()){
            System.out.println(s.pop()+ " ");
        }
    }
    public static void topsortutil(ArrayList<Edge> graph[],boolean vis[],Stack<Integer> s,int curr){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                topsortutil(graph,vis,s,e.dest);
            }
        }
        s.add(curr);
    }
    public static void kahnalgo(ArrayList<Edge> graph[]){
        int indeg[]=new int[graph.length];
        Queue<Integer> q=new LinkedList<>();
        calcindeg(graph,indeg);
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.remove();
            System.out.print(curr + " ");
            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }
    public static void calcindeg(ArrayList<Edge> graph[],int indeg[]){
        for(int i=0;i<graph.length;i++){
            int v=i;
            for(int j=0;j<graph[v].size();j++){
                Edge e=graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }
    static class Pair implements Comparable<Pair>{
        int n;
        int path;
        Pair(int n,int path){
            this.n=n;
            this.path=path;
        }
        @Override
        public int compareTo(Pair p2){
            return this.path-p2.path;
        }
    }
    
    public static void Bellmanford(ArrayList<Edge> graph[],int src,int vt){
        int dist[]=new int[graph.length];
        for(int i=0;i<dist.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<vt;i++){
            for(int j=0;j<graph.length;j++){           //to put current ,before pq did this job
                for(int k=0;k<graph[j].size();k++){
                        Edge e=graph[j].get(k);
                        int u=e.src;
                        int v=e.dest;
                        int wt=e.wt;
                        if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v]){
                            dist[v]=dist[u]+wt;
                        }
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i] + " ");
        }
    }
    public static void primsalgo(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int finalcost=0;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!vis[curr.n]){
                vis[curr.n]=true;
                finalcost+=curr.path;
                for(int i=0;i<graph[curr.n].size();i++){
                    Edge e=graph[curr.n].get(i);
                    pq.add(new Pair(e.dest,e.wt));
                }
            }
        }
        System.out.print(finalcost);
    }
    public static void flightgraph(int flight[][],ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<flight.length;i++){
            int src=flight[i][0];
            int dest=flight[i][1];
            int wt=flight[i][2];
            Edge e=new Edge(src,dest,wt);
            graph[src].add(e);
        }
    }
    static class Info{
        int src;
        int cost;
        int stops;
        public Info(int src,int cost,int stops){
            this.src=src;
            this.cost=cost;
            this.stops=stops;
        }
    }
    public static int cheapestflight(int n,int flight[][],int src,int dest,int k){
        ArrayList<Edge> graph[]=new ArrayList[n];
        flightgraph(flight,graph);
        int dist[]=new int[n];
        for(int i=0;i<dist.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        Queue<Info> q=new LinkedList<>();
        q.add(new Info(src,0,0));
        while(!q.isEmpty()){
            Info curr=q.remove();
            if(curr.stops>k){
                break;
            }
            for(int i=0;i<graph[curr.src].size();i++){
                Edge e=graph[curr.src].get(i);
               // int u=e.src;
                int v=e.dest;
                int wt=e.wt;
                if(curr.cost + wt<dist[v] && curr.stops<=k){
                    dist[v]=curr.cost+wt;
                    q.add(new Info(v,dist[v],curr.stops+1));
                }
            }
        }
        if(dist[dest]==Integer.MAX_VALUE){
            return -1;
        }else{
            return dist[dest];
        }
    }
    public static int connectingcities(int cities[][]){
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        boolean vis[]=new boolean[cities.length];
        pq.add(new Pair(0,0));
        int finalcost=0;
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!vis[curr.n]){
                vis[curr.n]=true;
                finalcost+=curr.path;
                for(int i=0;i<cities[curr.n].length;i++){
                   if(cities[curr.n][i]!=0 ){
                       pq.add(new Pair(i,cities[curr.n][i]));
                    }
                }
            }
        }
        return finalcost;
    }
    static int n=7;
    static int par[]=new int[7];
    static int rank[]=new int[7];
    public static void init(){
        for(int i=0;i<n;i++){
            par[i]=i;
        }
    }
    public static int find(int x){
        if(x==par[x]){
            return x;
        }
        return par[x]=find(par[x]);
    }
    public static void union(int a,int b){
        int parA=find(a);
        int parB=find(b);

        if(rank[parA]==rank[parB]){
            par[parB]=parA;
            rank[parA]++;
        }else if(rank[parA]<rank[parB]){
            par[parA]=parB;
        }else{
            par[parB]=parA;
        }
    }
    static class edgee implements Comparable<edgee>{
        int src;
        int dest;
        int wt;
        public edgee(int s,int d,int wt){
            this.src=s;
            this.dest=d;
            this.wt=wt;
        }
        @Override
        public int compareTo(edgee e2){
            return this.wt-e2.wt;
        }
    }
    static void createkrushkalgraph(ArrayList<edgee> edges){
        edges.add(new edgee(0,1,10));
        edges.add(new edgee(0,2,15));
        edges.add(new edgee(0,3,30));
        edges.add(new edgee(1,3,40));
        edges.add(new edgee(2,3,50));
    }
    public static void krushkalmst(ArrayList<edgee> edges,int v){
        init();
        Collections.sort(edges);
        int mstcost=0;
        int count=0;
        for(int i=0;count<v-1;i++){
            edgee e=edges.get(i);
            int parA=e.src;
            int parB=e.dest;
            if(parA!=parB){
                union(e.src,e.dest);
                mstcost+=e.wt;
                count++;
            }
        }
        System.out.print(mstcost);
    }
    public static void kosaraju(ArrayList<Edge> graph[],int v){
        ArrayList<Edge> transpose[]=new ArrayList[v];
        boolean vis[]=new boolean[v];
        for(int i=0;i<graph.length;i++){
            vis[i]=false;
            transpose[i]=new ArrayList<Edge>();
        }
        for(int i=0;i<v;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest,e.src));
            }
        }
        dfs(transpose);
    }
    public static void main(String args[]){
        int v=5;
        ArrayList<Edge> graph[]=new ArrayList[v];
        //boolean vis[]=new boolean[v];
        creategraph(graph);
        //(graph);
        //int flights[][]={{0,1,100},{1,2,100},{1,3,600},{2,3,200}};
        //System.out.print(cheapestflight(4,flights,0,3,1));
        // int cities[][]={
        //     {0,1,2,3,4},
        //     {1,0,5,0,7},
        //     {2,5,0,6,0}, 
        //     {3,0,6,0,0},
        //     {4,7,0,0,0}
        // };
        // System.out.print(connectingcities(cities));
        // init();
        // union(1,3);
        // find(3);
        // union(2,4);
        // union(3,6);
        // union(3,4);
        // union(6,2);
        // union(3,4);
        // for(int i=0;i<rank.length;i++){
        //     System.out.println(rank[i]+ " ");
        // }
        // for(int i=0;i<par.length;i++){
        //     System.out.println(par[i]+ " ");
        // }
        // int v=4;
        // ArrayList<edgee> edges=new ArrayList<>();
        // createkrushkalgraph(edges);
        // krushkalmst(edges, v);
        //dfs(graph);
        kosaraju(graph, v);
    }
}