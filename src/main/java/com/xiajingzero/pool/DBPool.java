package com.xiajingzero.pool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created by xiajing on 2018-8-22.
 */
public class DBPool {
    private  static LinkedList<Connection> pool = new LinkedList<Connection>();

    public DBPool(int initSize){
        if(initSize > 0){
            for (int i = 0; i < initSize; i++) {
                pool.addLast(SqlConnection.fetchConnection());
            }
        }
    }

    public Connection fetchConn(long mills) throws InterruptedException{
        synchronized (pool){
            if(mills < 0){
                while(pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            }else{
                long overTime = System.currentTimeMillis() + mills;
                long remain = mills;
                while(pool.isEmpty() && remain > 0){
                    pool.wait(remain);
                    remain = overTime - System.currentTimeMillis();
                }
                Connection result = null;
                if(!pool.isEmpty()){
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }

    public void releaseConn(Connection conn){
        if(conn != null){
            synchronized (pool){
                pool.addLast(conn);
                pool.notifyAll();;
            }
        }
    }
}
