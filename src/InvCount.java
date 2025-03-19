
public class InvCount {

    Puzzle_Game puzzle = new Puzzle_Game();


    int[] arr =puzzle.getGrid; //현재 상태의 grid 값을 1차월 배열로 나타냄

        public int getInvCount(int[] arr) {
            int invCount = 0;
            int n = arr.length; // 배열의 길이를 사용

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] != 0 && arr[i] != 0 && arr[i] > arr[j]) {
                        invCount++; // inversion 카운트를 증가시킴
                    }
                }
            }
            return invCount; // inversion 카운트 반환
        }
}
