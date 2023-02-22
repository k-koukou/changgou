package changgou.pojo;

/**
 * @className user
 * @userName 李院斌
 * @DATA 2023-02-04 10:42
 * @nickName 辻弎
 **/
public class user {
    private Integer userId;
    private String username;
    private int balance;

    public user () {
    }

    public user (Integer userId, String username, int balance) {
        this.userId = userId;
        this.username = username;
        this.balance = balance;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public int getBalance () {
        return balance;
    }

    public void setBalance (int balance) {
        this.balance = balance;
    }

    @Override
    public String toString () {
        return "user{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                '}';
    }
}
