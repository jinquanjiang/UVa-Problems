/*
 * Question 3
 */
import java.io.*;
import java.util.*;
public class question3 {
	


static ArrayList<Integer>[] adjList;
static int path[]= new int[5005];
static int visited[]=new int[5005];
static int length;

	static boolean dfs(int left, int right, int fa)
	{
		
		path[length++]=left;
		for(int a=0;a<10;a++){
			System.out.print(path[a]);
			
		}
		System.out.println("end");
		if(left==right)
		{
			return true;
		}
		
		for(int i=0; i<adjList[left].size();i++)
		{
			int a = adjList[left].get(i);
			if(fa==a)
			{
				continue;
			}
			
			if(dfs(a,right,left))
			{
				
				return true;
			}
		}
		
		return false;
		
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException 
	{
		int totalNode;
		int numberOfLoops=0;
		
		BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
		while(true)
		{
			
			totalNode =Integer.parseInt(reader.readLine());
			if(totalNode==0)
			{
				break;
			}
			adjList = new ArrayList[totalNode+1];
			
			for(int index=1;index <= totalNode; index++)
			{
				adjList[index] = new ArrayList<Integer>();
			}
			
			for(int i = 0; i < totalNode-1; i++)
			{
				StringTokenizer st = new StringTokenizer(reader.readLine());
				int leftInt = Integer.parseInt(st.nextToken());
				int rightInt = Integer.parseInt(st.nextToken());
				adjList[leftInt].add(rightInt); 
				adjList[rightInt].add(leftInt);
				
				
				
			}
			

			int NumberOfCase = Integer.parseInt(reader.readLine());
			while(NumberOfCase-->0){
				StringTokenizer st = new StringTokenizer(reader.readLine());
				int leftInt2 = Integer.parseInt(st.nextToken());
				int rightInt2 = Integer.parseInt(st.nextToken());
				length=0;
				Arrays.fill(path, -1);
				dfs(leftInt2,rightInt2,-1);
				
				if(length%2!=0)
				{
					System.out.println("The fleas meet at "+ path[length/2]);
					
				}
				else
				{
					int a= path[length/2-1];
					int b= path[length/2];
					if(a>b)
					{
						int temp=a;
						a=b;
						b=temp;
					}
					System.out.println("The fleas jump forever between "+a+" and "+b);
				}
			}
			numberOfLoops++;
			
			//print out the adjacent list 
			for(int index=1;index <= totalNode; index++)
			{
				System.out.println(adjList[index]);
			}
			
			//System.out.println(adjList[1].get(0));
		}
//		System.out.println(numberOfLoops);

	}
}


