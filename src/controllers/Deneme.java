/**
 * 
 */
package controllers;

/**
 * @author Emrah Denizer
 *
 */
public class Deneme {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static int kalanİzinSayisi = 5;
	public static int toplamIzinGunSayisi = 0;

	public static void main(String[] args) {

		String x = "1364534156889";
		System.out.println(TCKimlikDogrumu(x));

		// Date yeniYil = new Date();
		// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
		//
		// String newDate = sdf.format(yeniYil);
		//
		// if (newDate.equals("15/11")) {
		//
		// toplamIzinGunSayisi = kalanİzinSayisi + 20;
		//
		// System.out.println(toplamIzinGunSayisi);
		// } else {
		// System.out.println(newDate);
		// }

	}

	public static Integer kalanİzinGunSayisi(int kullanilanIzinSayisi) {

		kalanİzinSayisi -= kullanilanIzinSayisi;

		return kalanİzinSayisi;

	}

	public static int s(int n) {// girilen sayıya kadar recursive toplar
		if (n == 0)
			return 0;
		return s(n - 1) + n;
	}

	public static int f(int n) {// girilen sayıya kadar recursive çarpar
								// (faktoriyel!)
		if (n == 0)
			return 1;
		return f(n - 1) * n;
	}

	public static Integer TamSayi(String sSayi, Integer sira) {
		Integer sayi = 0;
		try {
			sayi = Integer.parseInt(sSayi.substring(sira - 1, sira));
		} catch (Exception e) {
			sayi = 0;
		}
		return sayi;
	}

	public static Boolean TCKimlikDogrumu(String TCKimlik) {
		Boolean sonuc = false;
		if (TCKimlik.length() > 0) {
			Integer carpim = 0;
			try {
				if (Long.parseLong(TCKimlik) > 9999999999L) {
					carpim = (TamSayi(TCKimlik, 1) + TamSayi(TCKimlik, 3) + TamSayi(TCKimlik, 5) + TamSayi(TCKimlik, 7)
							+ TamSayi(TCKimlik, 9)) * 7;
					carpim -= (TamSayi(TCKimlik, 2) + TamSayi(TCKimlik, 4) + TamSayi(TCKimlik, 6)
							+ TamSayi(TCKimlik, 8));
					sonuc = (carpim % 10 == TamSayi(TCKimlik, 10));
				}
			} catch (Exception e) {

				System.out.println(e.fillInStackTrace());
			}
		}
		return sonuc;
	}
}
