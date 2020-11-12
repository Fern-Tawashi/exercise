class OtsuriKeisan {
	public static void main(String[] args) {
		/** 金種 */
		int[] kinsyu = {10000, 5000, 1000, 500, 100, 50, 10, 5, 1}; // 大きい金種順で

		/** 売上 */
		int uriage = 13832;
		//int uriage = new java.util.Random().nextInt(30000) + 1; // 1～30000までランダムにしたい場合

		/** 預り金 */
		int azukari = 0;

		java.util.Scanner scan = new java.util.Scanner(System.in); // Scannerは使い回しした方が効率よいので変数に格納します

		System.out.println("売上金額：" + uriage);

		/** 預り金入力 */
		for (int i = 0; i < kinsyu.length; i++) { //配列のインデックスは0から始まります
			System.out.print(kinsyu[i] + "円：");
			int n = scan.nextInt();
			azukari = azukari + (kinsyu[i] * n);
		}

		System.out.println("預り金額：" + azukari);

		/** おつり計算 */
		int otsuri = azukari - uriage;

		System.out.println("おつり：" + otsuri);

		if (otsuri >= 0) {
			for (int i = 0; i < kinsyu.length && otsuri > 0; i++) { // &&で終了条件を追加しています
				int n = otsuri / kinsyu[i]; // 整数（int）の除算は常に切り捨てになります
				System.out.println(kinsyu[i] + "円：" + n + " 枚");
				otsuri = otsuri - (kinsyu[i] * n);
			}
		}
		else {
			System.out.println("預り金が不足しています");
		}
	}
}