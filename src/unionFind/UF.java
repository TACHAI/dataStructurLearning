package unionFind;

/**
 * Created by @Author tachai
 * date 2018/10/2 17:30
 * GitHub https://github.com/TACHAI
 * Email 1206966083@qq.com
 */
public interface UF {
    int getSize();
    boolean isConnected(int p,int q);
    void unionElements(int p, int q);
}
