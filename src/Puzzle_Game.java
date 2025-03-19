
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 3x3배열로 출력하고 wasd키로 0이있는 자리를 위아래,양옆으로 옮길수 있어요 */

public class Puzzle_Game {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[][] grid = new int[9][9];

        ArrayList<Integer> numbers = new ArrayList<>();

        // 0~8까지 리스트에 추가
        for (int i = 0; i < 81; i++) {
            numbers.add(i);
        }

        // 리스트 셔플 (섞기)
        Collections.shuffle(numbers);

        int zeroX = 0, zeroY = 0; // 0의 위치 저장 변수
        int index = 0;

        // 셔플된 값을 3x3 배열에 채우기
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = numbers.get(index++);
                if (grid[i][j] == 0) { // 0의 위치 저장
                    zeroX = i;
                    zeroY = j;
                  }
                 }
             }

             
        while (true) {
            // 현재 배열 출력
            System.out.println("현재 상태:");
            printGrid(grid);

            // 이동 가능한 방향 출력
            System.out.println("0을 이동할 방향을 선택하세요: (w: 위, s: 아래, a: 왼쪽, d: 오른쪽, q: 종료)");
            char move = sc.next().charAt(0);

            // 사용자가 q 입력 시 종료
            if (move == 'q') break;

            // 이동 방향에 따라 스왑
            int newX = zeroX, newY = zeroY;
            if (move == 'w' && zeroX > 0) newX--; // 위로 이동
            if (move == 's' && zeroX < 8) newX++; // 아래로 이동
            if (move == 'a' && zeroY > 0) newY--; // 왼쪽 이동
            if (move == 'd' && zeroY < 8) newY++; // 오른쪽 이동

            // 위치가 변했으면 스왑
            if (newX != zeroX || newY != zeroY) {
                swap(grid, zeroX, zeroY, newX, newY);
                zeroX = newX;
                zeroY = newY;
            }
        }

    

        // 2차원 배열 출력
        System.out.println("랜덤 9x9 배열:");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    //InvCount에서 사용할 그리드 값을 1차원 배열로 줄 변수에 저장한후 반환
    public static int[] getGrid = new int[81];
    public static int[] getGrid(int[][] grid){

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                getGrid[i+j] = grid[i][j];
            }
        }
        return getGrid;

    }

    

    // 2차원 배열 출력 함수
    public static void printGrid(int[][] grid) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

       // 두 위치를 바꾸는 함수
       public static void swap(int[][] grid, int x1, int y1, int x2, int y2) {
        int temp = grid[x1][y1];
        grid[x1][y1] = grid[x2][y2];
        grid[x2][y2] = temp;
    }

}

