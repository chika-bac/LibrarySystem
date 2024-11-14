package org.example;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Library {

  List<Book> bookList = List.of(
      new Book("アルジャーノンに花束を", "ダニエル キイス", 101),
      new Book("ノルウェイの森", "村上 春樹", 102),
      new Book("1984年", "ジョージ オーウェル", 103),
      new Book("そして誰もいなくなった", "アガサ クリスティ", 104),
      new Book("ハリー・ポッターと賢者の石", "J.K.ローリング", 105),
      new Book("罪と罰", "フョードル ドストエフスキー", 106),
      new Book("老人と海", "アーネスト ヘミングウェイ", 107),
      new Book("アンドロイドは電気羊の夢を見るか？", "フィリップ・K・ディック", 108),
      new Book("シャーロック・ホームズの冒険", "アーサー・コナン・ドイル", 109),
      new Book("星の王子さま", "アントワーヌ・ド・サン＝テグジュペリ", 110),
      new Book("星の王子さま2", "アントワーヌ・ド・サン＝テグジュペリ", 111),
      new Book("ハリー・ポッターとアズカバンの囚人", "J.K.ローリング", 112)
  );
  Scanner scanner = new Scanner(System.in);

  //  タイトルから検索
  public void findByTitle() {
    System.out.print("タイトルを入力してください（部分一致OK）：");
    String title = scanner.next();

    List<Book> searchResult = bookList.stream()
        .filter(book -> book.getTitle().contains(title))
        .toList();

    outputResult(searchResult);
  }

  //  著者名から検索
  public void findByAuthor() {
    System.out.print("著者名を入力してください（部分一致OK）：");
    String author = scanner.next();

    List<Book> searchResult = bookList.stream()
        .filter(book -> book.getAuthor().contains(author))
        .toList();

    outputResult(searchResult);
  }

  //  番号から検索
  public void findByNumber() {
    try {
      System.out.print("番号を入力してください：");
      int bookNumber = scanner.nextInt();

      List<Book> searchResult = bookList.stream()
          .filter(book -> book.getNumber() == bookNumber)
          .toList();

      outputResult(searchResult);

    } catch (InputMismatchException e) {
      System.out.print("不正な入力です");
      scanner.next();
    }
  }

  //  検索結果の出力
  public void outputResult(List<Book> searchResult) {
    int resultCount = searchResult.size();

    if (resultCount > 0) {
      System.out.println(resultCount + "件見つかりました。");

      searchResult.forEach((book) -> {
        System.out.println("--------------------------------------");
        System.out.println("タイトル：" + book.getTitle());
        System.out.println("著者：" + book.getAuthor());
        System.out.println("番号：" + book.getNumber());
        System.out.println("--------------------------------------");
      });
    } else {
      System.out.println("該当する書籍が見つかりませんでした。");
    }
  }
}


