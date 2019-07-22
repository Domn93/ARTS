package jvm;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/7/10 14:58
 */
public class ObjectSurviver {
    public static void main(String[] args) throws InterruptedException {
        while (true){
            loadReplicasFromDisk();
            Thread.sleep(1000);
        }
    }

    private static void loadReplicasFromDisk() {
        ReplicaManager replicaManager = new ReplicaManager();
        replicaManager.load();
    }
}
