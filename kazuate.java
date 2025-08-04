import java.util.InputMismatchException;
import java.util.Scanner;

public class kazuate {

    public static void main(String[] args) {

        // --- ゲーム設定 ---
        final int ANSWER = 77; // 正解の数 (2桁の正の整数)
        final int MAX_ATTEMPTS = 5; // 最大試行回数

        // --- ゲーム開始 ---
        System.out.println("数当てゲームを開始します！");
        System.out.println("2桁の正の整数を当ててください。入力は" + MAX_ATTEMPTS + "回までです。");

        Scanner scanner = new Scanner(System.in);
        boolean isCorrect = false; // 正解したかどうかを管理するフラグ

        // --- メインループ (5回まで) ---
        for (int i = 1; i <= MAX_ATTEMPTS; i++) {
            System.out.println("\n--- " + i + "回目の入力 ---");
            System.out.print("数を入力してください: ");

            try {
                int userGuess = scanner.nextInt();

                // 2桁の正の整数かチェック
                if (userGuess < 10 || userGuess > 99) {
                    System.out.println("エラー: 2桁の正の整数を入力してください。");
                    continue; // 今回の試行をやり直す（回数は消費される）
                }

                // --- 判定 ---
                if (userGuess == ANSWER) {
                    System.out.println("🎉 当たり！正解です！");
                    isCorrect = true;
                    break; // 正解したのでループを抜ける
                } else {
                    int diff = Math.abs(userGuess - ANSWER); // 差の絶対値
                    if (userGuess > ANSWER) {
                        System.out.print("もっと小さいです。");
                        if (diff >= 20) {
                            System.out.println(" (ヒント: 差は20以上あります)");
                        } else {
                            System.out.println();
                        }
                    } else { // userGuess < ANSWER
                        System.out.print("もっと大きいです。");
                        if (diff >= 20) {
                            System.out.println(" (ヒント: 差は20以上あります)");
                        } else {
                            System.out.println();
                        }
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("エラー: 数字を入力してください。");
                scanner.next(); // 不正な入力をクリアする
            }
        }

        // --- ゲーム終了 ---
        if (!isCorrect) {
            System.out.println("\n残念！時間切れです。");
            System.out.println("正解は " + ANSWER + " でした。");
        }

        scanner.close(); // スキャナーを閉じる
        System.out.println("ゲームを終了します。");
    }
}