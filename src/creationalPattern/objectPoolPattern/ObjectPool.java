package creationalPattern.objectPoolPattern;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class ObjectPool<T> {//타입파라미터 T를 받아

    private ConcurrentLinkedQueue<T> pool;//해당 T타입의 컬렉션 프레임워크 thread-safe
    private ScheduledExecutorService executorService;

    public ObjectPool(final int minObjects){
        initialize(minObjects);
    }

    //최소한 minObjects부터 maxObject 사이즈 만큼은 풀에 갖고 있어라.
    public ObjectPool(final int minObjects, final int maxObjects, final long validationInterval){
        initialize(minObjects);

        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                int size = pool.size();

                if(size < minObjects){
                    int sizeToBeAdded = minObjects + size;
                    for(int i = 0; i < sizeToBeAdded; i++){
                        pool.add(createObject());
                    }
                }else if(size > maxObjects){
                    int sizeTobeRemoved = size - maxObjects;
                    for(int i = 0; i < sizeTobeRemoved; i++){
                        pool.poll();
                    }
                }
            }
        }, validationInterval, validationInterval, TimeUnit.SECONDS);
    }

    public T borrowObject(){
        T object;
        if((object = pool.poll()) == null){
            object = createObject();
        }
        return object;
    }

    public void returnObject(T object){
        if(object == null){
            return;
        }
        this.pool.offer(object);
    }

    public void shutdown(){
        if(executorService != null){
            executorService.shutdown();
        }
    }

    protected abstract T createObject();

    private void initialize(final int minObjects){
        pool = new ConcurrentLinkedQueue<T>();//pool에 큐를 대입한다.
        for(int i=0; i<minObjects; i++){
            pool.add(createObject());
        }
    }
}
