package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Library library = new Library();

    boolean isValid = false;
    while (!isValid) {
      try {
        //    タイトル・著者名・番号どれから検索するかを選択
        System.out.println("検索方法を選択してください。（番号を入力）");
        System.out.print("1.タイトル 2.著者名 3.番号：");
        int selectedNumber = scanner.nextInt();
        isValid = true; // 正常な入力の場合はループを抜ける

        switch (selectedNumber) {
          case 1 -> library.findByTitle();
          case 2 -> library.findByAuthor();
          case 3 -> library.findByNumber();
          default -> {
            System.out.println("1~3で選択してください。");
            isValid = false; // ループ継続のためfalseを格納
          }
        }

      } catch (InputMismatchException e) {
        System.out.println("数値を入力してください。");
        scanner.next(); // 不正な入力をスキップ
      }

    }

  }
}
