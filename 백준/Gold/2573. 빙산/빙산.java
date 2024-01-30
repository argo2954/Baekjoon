import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int h,w;	// 빙하 맵 행,열 길이
	static Ice[][] ices;	// 빙하 맵
	static Queue<Ice> now = new LinkedList<>(); // 현재 높이가 1 이상인 빙하 리스트
	
	static int[] dxs = {0,1,0,-1};	// 인접 빙하 + xindex
	static int[] dys = {-1,0,1,0};	// 인접 빙하 + yindex
	
	
	// 빙하 정보 저장을 위한 class
	static class Ice{
		int y,x;
		int height;
		boolean marked;
		
		public Ice(int y, int x, int height) {
			this.y = y;
			this.x = x;
			this.height = height;
			this.marked = false;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// input| h,w
		StringTokenizer stk = new StringTokenizer(br.readLine());
		h = Integer.parseInt(stk.nextToken());
		w = Integer.parseInt(stk.nextToken());
		
		// init| ices
		ices = new Ice[h][w];
		for(int y=0; y<h; y++) {
			stk = new StringTokenizer(br.readLine());
			for(int x=0; x<w; x++) {
				int height = Integer.parseInt(stk.nextToken());
				ices[y][x] = new Ice(y,x,height);
				
				// 높이가 0이 아닌경우 now에 add
				if(height>0)
					now.add(ices[y][x]);
			}
		}
		
		
		// find| 시간 흐름
		System.out.println(twoThousandYearsLater());
	}
	
	
	static int twoThousandYearsLater() {
		int year = 1;
		
		while(!now.isEmpty()) {
			Queue<Ice> nextYear = new LinkedList<>();
			
			while(!now.isEmpty()) {
				Ice ice = now.poll();
				ice.height -= countOfSea(ice.y, ice.x, year);
				
				if(ice.height <= 0) {
					ice.height = -year;
				}
				else {
					nextYear.add(ice);					
				}
			}

			if(!nextYear.isEmpty() && isSeperate((LinkedList)nextYear)) {
				return year;
			}
			
			now = nextYear;
			year++;
		}
		
		return 0;
	}
	
	static int countOfSea(int y, int x, int year) {
		int count = 0;
		for(int i=0; i<4; i++) {
			Ice ice = ices[y+dys[i]][x+dxs[i]];
			if(ice.height > -year && ice.height<=0) {
				count++;
			}
		}
		
		return count;
	}
	
	static boolean isSeperate(List<Ice> nextYear) {
		Ice root = nextYear.get(0);
		root.marked = true;
		
		Stack<Ice> stack = new Stack<>();
		stack.add(root);
		
		while(!stack.isEmpty()) {
			Ice ice = stack.pop();
			int y = ice.y;
			int x = ice.x;
			
			for(int i=0; i<4; i++) {
				Ice cIce = ices[y+dys[i]][x+dxs[i]];
				if(cIce.height>0 && !cIce.marked) {
					cIce.marked = true;
					stack.push(cIce);
				}
			}
		}
		
		for(Ice ice: nextYear) {
			if(!ice.marked) {
				return true;
			}
		}
		
		for(Ice i: nextYear)
			i.marked = false;
		
		return false;
	}
	
	
}
