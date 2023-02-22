package changgou.pojo;

/**
 * @className book
 * @userName 李院斌
 * @DATA 2023-02-04 10:40
 * @nickName 辻弎
 **/
public class book {
    private Integer bookId;
    private String bookName;
    private int price;
    private int stock;

    public book () {
    }

    public book (Integer bookId, String bookName, int price, int stock) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.stock = stock;
    }

    public Integer getBookId () {
        return bookId;
    }

    public void setBookId (Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName () {
        return bookName;
    }

    public void setBookName (String bookName) {
        this.bookName = bookName;
    }

    public int getPrice () {
        return price;
    }

    public void setPrice (int price) {
        this.price = price;
    }

    public int getStock () {
        return stock;
    }

    public void setStock (int stock) {
        this.stock = stock;
    }

    @Override
    public String toString () {
        return "book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
