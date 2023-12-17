import java.util.PrimitiveIterator;
import java.util.Scanner;
public class Palindrome {

    // ONCE SAYININ SON VE İLK HANELERİNİ KONTROL EDİYORUZ
    // EŞİT DEĞİLSELER ; BU SAYI PALİNDROME DEĞİLDİR DİYORUZ, EŞİTSELER SAYININ İLK VE SON HANELERİNİ SİLİYORUZ
    // KALAN SAYIYI KONTROL EDİYORUZ
    // BU SEKİLDE SAYI 1 hane veya 0 hane kalana kadar devam ediyoruz, HALA DEĞİLDİR ÇIKMADIYSA
    // BU SAYI PALİNDROMEDİR DİYORUZ

    // 3 tane yardımcı fonksiyon var
    //  - kacBasamak(int a)   - firstDigit(int a) ; ilk basamağını söylüyor sayının ve son olarak
    // ilk ve son hanesini silen bir fonksiyon,
    // çözümü de recursive yapıyoruz

    public static int kacBasamak(int a){
        // önce sayının kaç haneli olduğunu bul
        int basamak = 0;
        while (a != 0){
            a /= 10;
            basamak ++;
        }
        return basamak;
    }
    public static int firstDigit(int a){
        int result =0;
        int b = 1;
        for(int i = 1; i<kacBasamak(a);i++){
            b*= 10;
        }
        return a/b;
    }
    public static int son_Hane_Ve_Ilk_Hanesini_Sil(int a ){
        // isminden de anlaşılacağı gibi ilk ve son hanesini siliyoruz sayının
        int temp = 1;
        for(int i = 1;i<kacBasamak(a);i++){
            temp *= 10;
        }
        a = a - firstDigit(a)* temp;
        // üstteki işlem ilk hanesini sildi
        a = a/10;
        // üstteki işlem son hanesini sildi
        return a;
    }

    public static boolean isPalindrome(int a){
        if(kacBasamak(a) == 0) return true;
        if(kacBasamak(a) == 1) return true;

        if(kacBasamak(a) == 2){
            if(firstDigit(a) != a%10){
                return false;
            }else {
                return true;
            }
        }
            if(firstDigit(a) != a%10)return false;

         return isPalindrome(son_Hane_Ve_Ilk_Hanesini_Sil(a));

    }
    public static void main(String [] args) {

        System.out.print("Bir sayı giriniz:   ");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();


        if(isPalindrome(number)) System.out.println("Bu sayı palindrome "+ number);
        else System.out.println("Bu sayı palindrome değil" + number);
    }
}
