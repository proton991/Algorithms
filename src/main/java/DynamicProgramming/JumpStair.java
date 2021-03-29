package DynamicProgramming;

public class JumpStair {
    public int jump(int n) {
        int x = 1;
        int y = 1;
        int res = 1;

        for (int i = 2; i <= n; i++) {
            res = (x + y)%1000000007;
            x = y;
            y = res;
        }
        return res;
    }

    public static void main(String[] args) {
        JumpStair jumpStair = new JumpStair();
        System.out.println(jumpStair.jump(0)==1);
        System.out.println(jumpStair.jump(1)==1);
        System.out.println(jumpStair.jump(2)==2);
        System.out.println(jumpStair.jump(10)==89);
        System.out.println(jumpStair.jump(100)==782204094);
    }
}
