package dao;

/**
 * @Auther syc.
 * @Date 2017/11/17 17:00.
 */
public interface DBBase {
    void save();
    void update();
    <T> T get();
}
