package creationalPattern.objectPoolPattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class ObjectPoolDemo {
    private ObjectPool<ExportingProcess> pool;
    private AtomicLong processNo = new AtomicLong(0);

    public void setUp(){

        pool = new ObjectPool<ExportingProcess>(4, 10, 5) {

            protected ExportingProcess createObject(){
                return new ExportingProcess(processNo.incrementAndGet());
            }

        };

    }

    public void teatDown(){
        pool.shutdown();
    }

    public void testObjectPool(){
        ExecutorService executorService = Executors.newFixedThreadPool(8);

        executorService.execute(new ExportingTask(pool, 1));
        executorService.execute(new ExportingTask(pool, 2));
        executorService.execute(new ExportingTask(pool, 3));
        executorService.execute(new ExportingTask(pool, 4));
        executorService.execute(new ExportingTask(pool, 5));
        executorService.execute(new ExportingTask(pool, 6));
        executorService.execute(new ExportingTask(pool, 7));
        executorService.execute(new ExportingTask(pool, 8));

        executorService.shutdown();

        try{
            executorService.awaitTermination(30, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
